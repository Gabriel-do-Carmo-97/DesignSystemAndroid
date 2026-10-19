package br.com.wgc.design_system.core

import br.com.wgc.design_system.core.accessibility.WgcContrastCalculator
import br.com.wgc.design_system.core.accessibility.WgcHighContrastPaletteTokens
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Testes da matriz de combinacoes da paleta de alto contraste.
 * Quando executar: ao alterar cores ou tokens de acessibilidade.
 */
class WgcContrastMatrixTest {

    @Test
    fun testHighContrastPaletteComplianceAAA() {
        val darkRatio = WgcContrastCalculator.calculateContrastRatio(
            WgcHighContrastPaletteTokens.TEXT_ON_DARK_ARGB,
            WgcHighContrastPaletteTokens.BACKGROUND_DARK_ARGB
        )
        assertTrue("Text on dark background must pass AAA (ratio: $darkRatio >= 7.0)", darkRatio >= 7.0)

        val lightRatio = WgcContrastCalculator.calculateContrastRatio(
            WgcHighContrastPaletteTokens.TEXT_ON_LIGHT_ARGB,
            WgcHighContrastPaletteTokens.BACKGROUND_LIGHT_ARGB
        )
        assertTrue("Text on light background must pass AAA (ratio: $lightRatio >= 7.0)", lightRatio >= 7.0)
    }

    @Test
    fun testAccentColorsOnDarkBackground() {
        val yellowRatio = WgcContrastCalculator.calculateContrastRatio(
            WgcHighContrastPaletteTokens.PRIMARY_HIGH_CONTRAST_YELLOW_ARGB,
            WgcHighContrastPaletteTokens.BACKGROUND_DARK_ARGB
        )
        assertTrue("Yellow on black must have high visibility (ratio: $yellowRatio >= 7.0)", yellowRatio >= 7.0)
    }
}
