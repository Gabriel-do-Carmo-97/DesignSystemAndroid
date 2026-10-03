package br.com.wgc.design_system.core

import org.junit.Assert.assertTrue
import org.junit.Test

class WgcContrastMatrixTest {

    @Test
    fun testHighContrastPaletteComplianceAAA() {
        val darkRatio = WgcContrastCalculator.calculateContrastRatio(
            WgcHighContrastPaletteTokens.textOnDarkArgb,
            WgcHighContrastPaletteTokens.backgroundDarkArgb
        )
        assertTrue("Text on dark background must pass AAA (ratio: $darkRatio >= 7.0)", darkRatio >= 7.0)

        val lightRatio = WgcContrastCalculator.calculateContrastRatio(
            WgcHighContrastPaletteTokens.textOnLightArgb,
            WgcHighContrastPaletteTokens.backgroundLightArgb
        )
        assertTrue("Text on light background must pass AAA (ratio: $lightRatio >= 7.0)", lightRatio >= 7.0)
    }

    @Test
    fun testAccentColorsOnDarkBackground() {
        val yellowRatio = WgcContrastCalculator.calculateContrastRatio(
            WgcHighContrastPaletteTokens.primaryHighContrastYellowArgb,
            WgcHighContrastPaletteTokens.backgroundDarkArgb
        )
        assertTrue("Yellow on black must have high visibility (ratio: $yellowRatio >= 7.0)", yellowRatio >= 7.0)
    }
}
