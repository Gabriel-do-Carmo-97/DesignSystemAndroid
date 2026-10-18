package br.com.wgc.design_system.commons.previews.multi.theme

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

/**
 * Gera previews do composable nos modos claro e escuro do sistema.
 *
 * Use ao conferir cores e contraste em ambos os temas:
 * `@ThemePreviews @Composable fun ThemePreview() { Text("Exemplo") }`.
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
annotation class ThemePreviews
