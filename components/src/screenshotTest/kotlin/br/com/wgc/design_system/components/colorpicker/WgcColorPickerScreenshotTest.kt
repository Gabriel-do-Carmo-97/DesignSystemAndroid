package br.com.wgc.design_system.components.colorpicker

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.tools.screenshot.PreviewTest

class WgcColorPickerScreenshotTest {

    @PreviewTest
    @Preview(showBackground = true, name = "Color Wheel Preview")
    @Composable
    private fun ColorWheelScreenshotPreview() {
        Box(modifier = Modifier.padding(16.dp)) {
            WgcColorWheel(
                selectedColor = Color(0xFF6750A4),
                onColorChanged = {}
            )
        }
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Color Picker Badge Trigger")
    @Composable
    private fun ColorPickerBadgeTriggerScreenshotPreview() {
        Box(modifier = Modifier.padding(16.dp)) {
            WgcColorPicker(
                selectedColor = Color(0xFF2E7D32),
                onColorSelected = {},
                triggerType = WgcColorPickerTriggerType.BADGE
            )
        }
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Color Picker Icon Trigger")
    @Composable
    private fun ColorPickerIconTriggerScreenshotPreview() {
        Box(modifier = Modifier.padding(16.dp)) {
            WgcColorPicker(
                selectedColor = Color(0xFFD32F2F),
                onColorSelected = {},
                triggerType = WgcColorPickerTriggerType.ICON
            )
        }
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Color Picker Dialog Content")
    @Composable
    private fun ColorPickerDialogContentScreenshotPreview() {
        WgcColorPickerDialogContent(
            selectedColor = Color(0xFF1976D2),
            onConfirm = {},
            onDismiss = {}
        )
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Color Picker BottomSheet Content")
    @Composable
    private fun ColorPickerBottomSheetContentScreenshotPreview() {
        WgcColorPickerBottomSheetContent(
            selectedColor = Color(0xFFFF8F00),
            onConfirm = {},
            onDismiss = {}
        )
    }
}
