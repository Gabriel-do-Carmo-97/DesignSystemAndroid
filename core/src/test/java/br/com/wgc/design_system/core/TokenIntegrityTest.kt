package br.com.wgc.design_system.core

import br.com.wgc.design_system.constants.CoreConstants
import br.com.wgc.design_system.core.accessibility.WgcHighContrastPaletteTokens
import br.com.wgc.design_system.core.motion.WgcCoreDsMotion
import br.com.wgc.design_system.core.tokens.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.tokens.WgcCoreDsBreakpoints
import br.com.wgc.design_system.core.tokens.WgcCoreDsDirectional
import br.com.wgc.design_system.core.tokens.WgcCoreDsElevation
import br.com.wgc.design_system.core.tokens.WgcCoreDsSize
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing
import br.com.wgc.design_system.core.tokens.WgcCoreDsTypography
import br.com.wgc.design_system.core.tokens.WgcWindowSizeClass
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Verifica que os tokens públicos continuam alinhados à fonte central e que as classes de janela
 * mantêm nomes de enum em maiúsculas. Quando executar: após alterar tokens, aliases ou enums do core.
 */
class TokenIntegrityTest {
    @Test
    fun `public token aliases preserve central values`() {
        assertEquals(CoreConstants.CoreDsSpacing.LG24, WgcCoreDsSpacing.LG24, 0.0)
        assertEquals(CoreConstants.CoreDsSize.S24, WgcCoreDsSize.S24, 0.0)
        assertEquals(CoreConstants.CoreDsBorderRadius.MD8, WgcCoreDsBorderRadius.MD8, 0.0)
        assertEquals(CoreConstants.CoreDsElevation.CARD_DEFAULT, WgcCoreDsElevation.CARD_DEFAULT, 0.0)
        assertEquals(CoreConstants.CoreDsTypography.WEIGHT_BOLD, WgcCoreDsTypography.WEIGHT_BOLD)
        assertEquals(CoreConstants.CoreDsBreakpoints.COMPACT_MAX, WgcCoreDsBreakpoints.COMPACT_MAX, 0.0)
        assertEquals(CoreConstants.CoreDsDirectional.DIRECTION_RTL, WgcCoreDsDirectional.DIRECTION_RTL)
        assertEquals(CoreConstants.CoreDsMotion.DURATION_STANDARD300, WgcCoreDsMotion.DURATION_STANDARD300)
        assertEquals(
            CoreConstants.HighContrastPaletteTokens.BACKGROUND_DARK_ARGB,
            WgcHighContrastPaletteTokens.BACKGROUND_DARK_ARGB,
        )
    }

    @Test
    fun `window size class entries use uppercase names`() {
        assertArrayEquals(
            arrayOf("COMPACT", "MEDIUM", "EXPANDED"),
            WgcWindowSizeClass.entries.map { it.name }.toTypedArray(),
        )
    }
}
