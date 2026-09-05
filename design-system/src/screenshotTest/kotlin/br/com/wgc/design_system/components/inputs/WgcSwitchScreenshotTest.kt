package br.com.wgc.design_system.components.inputs

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android.tools.screenshot.PreviewTest

class WgcSwitchScreenshotTest {
    @PreviewTest
    @Preview(showBackground = true, name = "Switch Checked Enabled")
    @Composable
    private fun SwitchCheckedEnabledPreview() {
        WgcSwitch(checked = true, onCheckedChange = {}, isEnabled = true)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Switch Unchecked Enabled")
    @Composable
    private fun SwitchUncheckedEnabledPreview() {
        WgcSwitch(checked = false, onCheckedChange = {}, isEnabled = true)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Switch Checked Disabled")
    @Composable
    private fun SwitchCheckedDisabledPreview() {
        WgcSwitch(checked = true, onCheckedChange = {}, isEnabled = false)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Switch Unchecked Disabled")
    @Composable
    private fun SwitchUncheckedDisabledPreview() {
        WgcSwitch(checked = false, onCheckedChange = {}, isEnabled = false)
    }
}
