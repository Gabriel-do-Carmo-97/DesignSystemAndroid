package br.com.wgc.design_system.commons.clipboard.remember

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import br.com.wgc.design_system.commons.clipboard.service.WgcClipboardManager
import br.com.wgc.design_system.commons.haptics.remember.rememberWgcHapticFeedback

/**
 * Obtém um [WgcClipboardManager] associado à composição atual, pronto para uso em eventos da interface.
 *
 * Use em um `@Composable` que precise copiar ou limpar texto sem recriar o gerenciador a cada
 * recomposição. A instância acompanha o `Context`, o feedback háptico e o escopo de corrotinas locais.
 *
 * ```kotlin
 * val clipboard = rememberWgcClipboardManager()
 * Button(onClick = { clipboard.copy(label = "Chave Pix", text = pixKey, isSensitive = true) }) {
 *     Text("Copiar")
 * }
 * ```
 */
@Composable
fun rememberWgcClipboardManager(): WgcClipboardManager {
    val context = LocalContext.current
    val haptic = rememberWgcHapticFeedback()
    val scope = rememberCoroutineScope()
    return remember(context, haptic, scope) {
        WgcClipboardManager(context = context, hapticFeedback = haptic, scope = scope)
    }
}
