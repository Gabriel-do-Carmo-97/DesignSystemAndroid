package br.com.wgc.design_system.commons.previews.components

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.commons.constants.ComponentsConstants

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
