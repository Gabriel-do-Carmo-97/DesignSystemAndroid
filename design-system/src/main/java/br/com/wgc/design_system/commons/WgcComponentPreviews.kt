package br.com.wgc.design_system.commons

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    name = "Light Mode",
    group = "Themes",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true
)
@Preview(
    name = "Dark Mode",
    group = "Themes",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Preview(
    name = "Font Scale 1.5x",
    group = "Accessibility",
    fontScale = 1.5f,
    showBackground = true
)
annotation class WgcComponentPreviews
