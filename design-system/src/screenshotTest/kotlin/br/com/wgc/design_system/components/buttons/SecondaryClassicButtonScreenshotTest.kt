package br.com.wgc.design_system.components.buttons

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android.tools.screenshot.PreviewTest

class SecondaryClassicButtonScreenshotTest {
    @PreviewTest
    @Preview(showBackground = true, showSystemUi = true, name = "Enabled")
    @Composable
    private fun SecondaryClassicButtonDefaultPreview() {
        WgcSecondaryClassicButton(textButton = "Secondary Button")
    }

    @PreviewTest
    @Preview(showBackground = true, showSystemUi = true, name = "Disabled")
    @Composable
    private fun SecondaryClassicButtonDisablePreview() {
        WgcSecondaryClassicButton(textButton = "Secondary Button", isEnabled = false)
    }
}
