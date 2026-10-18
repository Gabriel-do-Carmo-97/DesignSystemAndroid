package br.com.wgc.design_system.commons.previews.components

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import br.com.wgc.design_system.commons.constants.ComponentsConstants

/**
 * Gera previews do componente nos temas claro/escuro e com escala de fonte ampliada.
 *
 * Use em funções `@Composable` pequenas para verificar rapidamente a aparência base e a adaptação
 * tipográfica no Android Studio:
 * ```kotlin
 * @WgcComponentPreviews
 * @Composable fun ComponentPreview() { Text("Exemplo") }
 * ```
 */
@Preview(
    name = "Light Mode",
    group = "Themes",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true,
)
@Preview(
    name = "Dark Mode",
    group = "Themes",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
)
@Preview(
    name = "Font Scale 1.5x",
    group = "Accessibility",
    fontScale = ComponentsConstants.Previews.FONT_SCALE_LARGE,
    showBackground = true,
)
annotation class WgcComponentPreviews
