package br.com.wgc.design_system.commons.haptics.remember

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import br.com.wgc.design_system.commons.haptics.contract.WgcHapticFeedback
import br.com.wgc.design_system.commons.haptics.impl.DefaultWgcHapticFeedback

/**
 * Obtém uma instância padrão de [WgcHapticFeedback] lembrada na composição atual.
 *
 * Use em composables que disparam feedback a partir de interações do usuário; a instância é refeita
 * somente quando o contexto ou o feedback háptico local mudar.
 *
 * ```kotlin
 * val haptics = rememberWgcHapticFeedback()
 * IconButton(onClick = { haptics.click(); onClose() }) {
 *     Icon(imageVector = Icons.Default.Close, contentDescription = "Fechar")
 * }
 * ```
 */
@Composable
fun rememberWgcHapticFeedback(): WgcHapticFeedback {
    val context = LocalContext.current
    val composeHaptic = LocalHapticFeedback.current
    return remember(context, composeHaptic) {
        DefaultWgcHapticFeedback(context = context, composeHaptic = composeHaptic)
    }
}
