package br.com.wgc.design_system.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsColors

/**
 * Esquema de cores corporativo no modo escuro (Dark Mode).
 */
val WgcDarkColorScheme: ColorScheme = darkColorScheme(
    primary = Color(WgcCoreDsColors.primary),
    secondary = Color(WgcCoreDsColors.secondary),
    background = Color(WgcCoreDsColors.grey900),
    surface = Color(WgcCoreDsColors.grey900),
    error = Color(WgcCoreDsColors.error),
    onPrimary = Color(WgcCoreDsColors.white),
    onSecondary = Color(WgcCoreDsColors.grey900),
    onBackground = Color(WgcCoreDsColors.grey50),
    onSurface = Color(WgcCoreDsColors.grey50),
    onError = Color(WgcCoreDsColors.white)
)

/**
 * Esquema de cores corporativo no modo claro (Light Mode).
 */
val WgcLightColorScheme: ColorScheme = lightColorScheme(
    primary = Color(WgcCoreDsColors.primary),
    secondary = Color(WgcCoreDsColors.textPrimary),
    background = Color(WgcCoreDsColors.background),
    surface = Color(WgcCoreDsColors.white),
    error = Color(WgcCoreDsColors.error),
    onPrimary = Color(WgcCoreDsColors.white),
    onSecondary = Color(WgcCoreDsColors.white),
    onBackground = Color(WgcCoreDsColors.textPrimary),
    onSurface = Color(WgcCoreDsColors.textPrimary),
    onError = Color(WgcCoreDsColors.white)
)

/**
 * Tipografia oficial padrão do Design System WGC.
 */
val WgcTypography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    )
)

/**
 * Tema central e oficial do Design System WGC para Jetpack Compose.
 *
 * Aplica os tokens semânticos de cores do `:core` e tipografia corporativa ao [MaterialTheme].
 * Pode ser consumido diretamente por qualquer aplicativo móvel cliente da organização.
 *
 * Exemplo de uso:
 * ```kotlin
 * WgcTheme {
 *     WgcClassicButton(textButton = "Continuar", onClick = { ... })
 * }
 * ```
 *
 * @param darkTheme Se o tema deve renderizar a variante escura (padrão: detecção do sistema).
 * @param content Conteúdo Composable encapsulado pelo tema.
 */
@Composable
fun WgcTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) WgcDarkColorScheme else WgcLightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = WgcTypography,
        content = content
    )
}
