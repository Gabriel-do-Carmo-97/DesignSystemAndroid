package br.com.wgc.design_system.commons.previews.multi.theme

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

/**
 * Anotação Multi-Preview para validação simultânea de temas Claro (Light) e Escuro (Dark).
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
