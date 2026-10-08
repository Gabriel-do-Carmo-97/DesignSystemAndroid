package br.com.wgc.design_system.commons.haptics.remember

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import br.com.wgc.design_system.commons.haptics.contract.WgcHapticFeedback
import br.com.wgc.design_system.commons.haptics.impl.DefaultWgcHapticFeedback

/**
 * Cria e lembra uma instância de [WgcHapticFeedback] no escopo da composição.
 */
@Composable
fun rememberWgcHapticFeedback(): WgcHapticFeedback {
    val context = LocalContext.current
    val composeHaptic = LocalHapticFeedback.current
    return remember(context, composeHaptic) {
        DefaultWgcHapticFeedback(context = context, composeHaptic = composeHaptic)
    }
}
