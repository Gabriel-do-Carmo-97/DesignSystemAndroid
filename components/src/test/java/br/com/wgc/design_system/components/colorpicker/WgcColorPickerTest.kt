package br.com.wgc.design_system.components.colorpicker

import androidx.compose.ui.graphics.Color
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class WgcColorPickerTest {

    @Test
    fun `hsvToColor correctly converts primary and secondary hues`() {
        // Vermelho (Hue 0)
        val red = WgcColorPickerUtils.hsvToColor(0f, 1f, 1f)
        assertEquals(1f, red.red, 0.01f)
        assertEquals(0f, red.green, 0.01f)
        assertEquals(0f, red.blue, 0.01f)

        // Verde (Hue 120)
        val green = WgcColorPickerUtils.hsvToColor(120f, 1f, 1f)
        assertEquals(0f, green.red, 0.01f)
        assertEquals(1f, green.green, 0.01f)
        assertEquals(0f, green.blue, 0.01f)

        // Azul (Hue 240)
        val blue = WgcColorPickerUtils.hsvToColor(240f, 1f, 1f)
        assertEquals(0f, blue.red, 0.01f)
        assertEquals(0f, blue.green, 0.01f)
        assertEquals(1f, blue.blue, 0.01f)

        // Branco (Saturação 0, Valor 1)
        val white = WgcColorPickerUtils.hsvToColor(0f, 0f, 1f)
        assertEquals(1f, white.red, 0.01f)
        assertEquals(1f, white.green, 0.01f)
        assertEquals(1f, white.blue, 0.01f)

        // Preto (Valor 0)
        val black = WgcColorPickerUtils.hsvToColor(0f, 1f, 0f)
        assertEquals(0f, black.red, 0.01f)
        assertEquals(0f, black.green, 0.01f)
        assertEquals(0f, black.blue, 0.01f)
    }

    @Test
    fun `colorToHsv correctly converts RGB to HSV`() {
        val (rH, rS, rV) = WgcColorPickerUtils.colorToHsv(Color.Red)
        assertEquals(0f, rH, 1f)
        assertEquals(1f, rS, 0.01f)
        assertEquals(1f, rV, 0.01f)

        val (gH, gS, gV) = WgcColorPickerUtils.colorToHsv(Color.Green)
        assertEquals(120f, gH, 1f)
        assertEquals(1f, gS, 0.01f)
        assertEquals(1f, gV, 0.01f)

        val (bH, bS, bV) = WgcColorPickerUtils.colorToHsv(Color.Blue)
        assertEquals(240f, bH, 1f)
        assertEquals(1f, bS, 0.01f)
        assertEquals(1f, bV, 0.01f)
    }

    @Test
    fun `colorToHex formats correctly`() {
        val redHex = WgcColorPickerUtils.colorToHex(Color.Red)
        assertEquals("#FF0000", redHex)

        val blueHex = WgcColorPickerUtils.colorToHex(Color.Blue)
        assertEquals("#0000FF", blueHex)

        val greenHexWithAlpha = WgcColorPickerUtils.colorToHex(Color.Green, includeAlpha = true)
        assertEquals("#FF00FF00", greenHexWithAlpha)
    }

    @Test
    fun `quickPalette contains corporate brand colors`() {
        val palette = WgcColorPickerDefaults.quickPalette
        assertTrue(palette.isNotEmpty())
        assertEquals(10, palette.size)
    }
}
