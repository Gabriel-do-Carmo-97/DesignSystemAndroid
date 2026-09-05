package br.com.wgc.design_system_wgc.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import br.com.wgc.core_ds.WgcCoreDsColors

private val DarkColorScheme = darkColorScheme(
    primary = Color(WgcCoreDsColors.primary),
    secondary = Color(WgcCoreDsColors.secondary),
    background = Color(WgcCoreDsColors.grey900),
    surface = Color(WgcCoreDsColors.grey900),
    error = Color(WgcCoreDsColors.error)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(WgcCoreDsColors.primary),
    secondary = Color(WgcCoreDsColors.textPrimary),
    background = Color(WgcCoreDsColors.background),
    surface = Color(WgcCoreDsColors.white),
    error = Color(WgcCoreDsColors.error)
)

@Composable
fun DesignSystemWGCTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
