package br.com.wgc.design_system.components.radio

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android.tools.screenshot.PreviewTest

class WgcRadioButtonScreenshotTest {
    @PreviewTest
    @Preview(showBackground = true, name = "Radio Selected Enabled")
    @Composable
    private fun RadioSelectedEnabledPreview() {
        WgcRadioButton(selected = true, label = "Selecionado", onClick = {}, isEnabled = true)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Radio Unselected Enabled")
    @Composable
    private fun RadioUnselectedEnabledPreview() {
        WgcRadioButton(selected = false, label = "Não selecionado", onClick = {}, isEnabled = true)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Radio Selected Disabled")
    @Composable
    private fun RadioSelectedDisabledPreview() {
        WgcRadioButton(selected = true, label = "Selecionado Desabilitado", onClick = {}, isEnabled = false)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Radio Unselected Disabled")
    @Composable
    private fun RadioUnselectedDisabledPreview() {
        WgcRadioButton(selected = false, label = "Não selecionado Desabilitado", onClick = {}, isEnabled = false)
    }
}
