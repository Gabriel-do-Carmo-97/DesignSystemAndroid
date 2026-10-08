package br.com.wgc.design_system.commons.clipboard.service

import android.content.ClipData
import android.content.ClipDescription
import android.content.ClipboardManager
import android.content.Context
import android.os.Build
import android.os.PersistableBundle
import br.com.wgc.design_system.commons.constants.ComponentsConstants
import br.com.wgc.design_system.commons.haptics.contract.WgcHapticFeedback
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Gerenciador corporativo para cópia de dados na área de transferência com suporte a dados sensíveis
 * (Pix, cartões, senhas) e destruição automática (auto-clear).
 */
class WgcClipboardManager(
    private val context: Context,
    private val hapticFeedback: WgcHapticFeedback? = null,
    private val scope: CoroutineScope = CoroutineScope(Dispatchers.Main),
) {
    private val clipboard: ClipboardManager? by lazy {
        context.getSystemService(Context.CLIPBOARD_SERVICE) as? ClipboardManager
    }

    /**
     * Copia um texto para a área de transferência.
     *
     * @param label Rótulo do conteúdo copiado.
     * @param text Texto a ser copiado.
     * @param isSensitive Se verdadeiro, oculta prévias no Android 13+ (LGPD / Segurança).
     * @param autoClearDelayMs Tempo em ms para auto-destruição do conteúdo no clipboard (0 = não limpa).
     */
    fun copy(
        label: String,
        text: String,
        isSensitive: Boolean = false,
        autoClearDelayMs: Long = ComponentsConstants.Clipboard.NO_AUTO_CLEAR_MS,
    ) {
        val clip = ClipData.newPlainText(label, text).apply {
            if (isSensitive && Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                description.extras = PersistableBundle().apply {
                    putBoolean(ClipDescription.EXTRA_IS_SENSITIVE, true)
                }
            }
        }

        clipboard?.setPrimaryClip(clip)
        hapticFeedback?.success()

        if (autoClearDelayMs > ComponentsConstants.Clipboard.NO_AUTO_CLEAR_MS) {
            scope.launch {
                delay(autoClearDelayMs)
                val currentClip = clipboard?.primaryClip
                if (currentClip != null && currentClip.itemCount > 0 && currentClip.getItemAt(0)?.text == text) {
                    clear()
                }
            }
        }
    }

    /**
     * Limpa o conteúdo atualmente retido na área de transferência.
     */
    fun clear() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            clipboard?.clearPrimaryClip()
        } else {
            clipboard?.setPrimaryClip(ClipData.newPlainText("", ""))
        }
    }

    /**
     * Verifica se existe conteúdo na área de transferência.
     */
    fun hasPrimaryClip(): Boolean = clipboard?.hasPrimaryClip() == true

    /**
     * Obtém o texto atual presente no clipboard.
     */
    fun getPrimaryClipText(): String? {
        val clip = clipboard?.primaryClip ?: return null
        return if (clip.itemCount > 0) clip.getItemAt(0)?.text?.toString() else null
    }

    companion object {
        const val DEFAULT_AUTO_CLEAR_MS = ComponentsConstants.Clipboard.DEFAULT_AUTO_CLEAR_MS
    }
}
