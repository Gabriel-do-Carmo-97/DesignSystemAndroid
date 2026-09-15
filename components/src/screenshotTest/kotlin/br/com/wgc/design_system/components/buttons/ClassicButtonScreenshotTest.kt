package br.com.wgc.design_system.components.buttons

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android.tools.screenshot.PreviewTest

class ClassicButtonScreenshotTest {
    @PreviewTest
    @Preview(showBackground = true, showSystemUi = true, name = "Enabled ")
    @Composable
    private fun ClassicButtonDefaultPreview() {
        ClassicButton(textButton = "Classic Button")
    }

    @PreviewTest
    @Preview(showBackground = true, showSystemUi = true, name = "Disabled")
    @Composable
    private fun ClassicButtonDisablePreview() {
        ClassicButton(textButton = "Classic Button", isEnabled = false)
    }
}