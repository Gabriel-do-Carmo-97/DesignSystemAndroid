package br.com.wgc.design_system.commons.clipboard.remember

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import br.com.wgc.design_system.commons.clipboard.service.WgcClipboardManager
import br.com.wgc.design_system.commons.haptics.remember.rememberWgcHapticFeedback

/**
 * Cria e lembra um [WgcClipboardManager] no escopo da composição do Jetpack Compose.
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
