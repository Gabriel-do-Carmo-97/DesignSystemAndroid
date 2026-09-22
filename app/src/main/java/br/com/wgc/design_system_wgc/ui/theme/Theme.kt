package br.com.wgc.design_system_wgc.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Tema do app de vitrine/sandbox que delega diretamente para o tema oficial [WgcTheme]
 * do módulo :components.
 */
@Composable
fun DesignSystemWGCTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    WgcTheme(
        darkTheme = darkTheme,
        content = content
    )
}
