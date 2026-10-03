@file:Suppress("MagicNumber")

package br.com.wgc.design_system.core

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class WgcContrastCalculatorTest {

    @Test
    fun `black on white satisfies WCAG AAA contrast ratio`() {
        val whiteArgb = 0xFFFFFFFF.toInt()
        val blackArgb = 0xFF000000.toInt()

        val ratio = WgcContrastCalculator.calculateContrastRatio(blackArgb, whiteArgb)
        assertTrue("Preto no branco deve atingir contraste 21:1", ratio >= 20.0)
        assertTrue(WgcContrastCalculator.isWcagAaCompliant(blackArgb, whiteArgb))
        assertTrue(WgcContrastCalculator.isWcagAaaCompliant(blackArgb, whiteArgb))
    }

    @Test
    fun `recommended text color on dark surface is white`() {
        val darkSurface = 0xFF121212.toInt()
        val recommended = WgcContrastCalculator.getRecommendedTextColor(darkSurface)
        assertEquals(WgcContrastCalculator.COLOR_WHITE, recommended)
    }

    @Test
    fun `recommended text color on light surface is black`() {
        val lightSurface = 0xFFF5F5F5.toInt()
        val recommended = WgcContrastCalculator.getRecommendedTextColor(lightSurface)
        assertEquals(WgcContrastCalculator.COLOR_BLACK, recommended)
    }

    @Test
    fun `fluid typography clamps correctly between bounds`() {
        val minSp = 14.0f
        val maxSp = 24.0f
        val minWidth = 360.0f
        val maxWidth = 840.0f

        // Below or at min width
        val atMin = WgcFluidTypography.clampSp(
            currentWidthDp = 300.0f,
            minSp = minSp,
            maxSp = maxSp,
            minWidthDp = minWidth,
            maxWidthDp = maxWidth
        )
        assertEquals(14.0f, atMin, 0.01f)

        // Above or at max width
        val atMax = WgcFluidTypography.clampSp(
            currentWidthDp = 900.0f,
            minSp = minSp,
            maxSp = maxSp,
            minWidthDp = minWidth,
            maxWidthDp = maxWidth
        )
        assertEquals(24.0f, atMax, 0.01f)

        // Mid point (600dp -> midpoint between 360 and 840 is 600)
        val atMid = WgcFluidTypography.clampSp(
            currentWidthDp = 600.0f,
            minSp = minSp,
            maxSp = maxSp,
            minWidthDp = minWidth,
            maxWidthDp = maxWidth
        )
        assertEquals(19.0f, atMid, 0.01f)
    }

    @Test
    fun `spacing density scaling works as expected`() {
        val baseSpacing = 16.0
        assertEquals(12.0, WgcSpacingDensity.COMPACT.scale(baseSpacing), 0.01)
        assertEquals(16.0, WgcSpacingDensity.NORMAL.scale(baseSpacing), 0.01)
        assertEquals(20.0, WgcSpacingDensity.COMFORTABLE.scale(baseSpacing), 0.01)
    }
}
