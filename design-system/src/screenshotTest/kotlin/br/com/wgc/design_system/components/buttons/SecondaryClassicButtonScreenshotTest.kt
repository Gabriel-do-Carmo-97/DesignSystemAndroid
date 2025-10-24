package br.com.wgc.design_system.components.buttons

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.components.buttons.secondarybutton.SecondaryClassicButton
import com.android.tools.screenshot.PreviewTest

class SecondaryClassicButtonScreenshotTest {
    @PreviewTest
    @Preview(showBackground = true, showSystemUi = true, name = "Enabled")
    @Composable
    private fun SecondaryClassicButtonDefaultPreview() {
        SecondaryClassicButton(textButton = "Secondary Button")
    }

    @PreviewTest
    @Preview(showBackground = true, showSystemUi = true, name = "Disabled")
    @Composable
    private fun SecondaryClassicButtonDisablePreview() {
        SecondaryClassicButton(textButton = "Secondary Button", isEnabled = false)
    }
}