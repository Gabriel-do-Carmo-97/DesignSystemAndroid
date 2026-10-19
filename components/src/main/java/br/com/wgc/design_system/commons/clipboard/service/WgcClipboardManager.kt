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
 * Copia, consulta e limpa texto na área de transferência do Android, com suporte a marcação sensível,
 * feedback háptico de sucesso e limpeza automática opcional.
 *
 * Use diretamente quando precisar controlar o ciclo de vida de um serviço de clipboard; em Compose,
 * prefira [br.com.wgc.design_system.commons.clipboard.remember.rememberWgcClipboardManager].
 * O período de limpeza é contado a partir da chamada; ao expirar, a limpeza ocorre somente se o
 * primeiro item do clipe ainda contiver o mesmo texto.
 *
 * ```kotlin
 * val clipboard = WgcClipboardManager(context)
 * clipboard.copy("Código", code, isSensitive = true, autoClearDelayMs = 30_000L)
 * ```
 *
 * @param context Context usado para obter o serviço Android de clipboard.
 * @param hapticFeedback Feedback opcional disparado após copiar.
 * @param scope Escopo em que é executada a limpeza automática agendada.
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
     * Copia texto para a área de transferência e dispara feedback háptico de sucesso quando disponível.
     * Marque conteúdo confidencial como sensível para ocultar sua prévia no Android 13 ou superior.
     * Use `autoClearDelayMs` para tentar limpar depois do prazo; zero desativa a limpeza automática.
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
     *
     * Use após uma ação explícita de remoção ou quando dados copiados não devam mais permanecer
     * disponíveis. No Android anterior ao Pie, substitui o conteúdo por texto vazio.
     */

    fun clear() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            clipboard?.clearPrimaryClip()
        } else {
            clipboard?.setPrimaryClip(ClipData.newPlainText("", ""))
        }
    }

    /**
     * Informa se a área de transferência possui um clipe primário.
     *
     * Use antes de apresentar ações condicionais de colagem; `true` não garante que o item contenha texto.
     *
     * @return `true` se o serviço do clipboard estiver disponível e tiver clipe primário.
     */
    fun hasPrimaryClip(): Boolean = clipboard?.hasPrimaryClip() == true

    /**
     * Obtém o texto do primeiro item do clipe primário, se houver.
     *
     * Use para ler texto colado; outros tipos de conteúdo e clipes sem itens retornam `null`.
     *
     * @return Texto do primeiro item ou `null` quando não houver texto disponível.
     */
    fun getPrimaryClipText(): String? {
        val clip = clipboard?.primaryClip ?: return null
        return if (clip.itemCount > 0) clip.getItemAt(0)?.text?.toString() else null
    }

    companion object {
        /** Prazo padrão recomendado para a limpeza automática, em milissegundos (60 segundos). */
        const val DEFAULT_AUTO_CLEAR_MS = ComponentsConstants.Clipboard.DEFAULT_AUTO_CLEAR_MS
    }
}
