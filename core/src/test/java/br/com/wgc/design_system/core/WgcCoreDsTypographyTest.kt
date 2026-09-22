package br.com.wgc.design_system.core

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class WgcCoreDsTypographyTest {

    @Test
    fun `font weights conform to standards`() {
        assertEquals(700, WgcCoreDsTypography.weightBold)
        assertEquals(600, WgcCoreDsTypography.weightSemiBold)
        assertEquals(500, WgcCoreDsTypography.weightMedium)
        assertEquals(400, WgcCoreDsTypography.weightNormal)
        assertEquals(300, WgcCoreDsTypography.weightLight)
    }

    @Test
    fun `display scale sizes are strictly decreasing`() {
        assertTrue(WgcCoreDsTypography.displayLargeSize > WgcCoreDsTypography.displayMediumSize)
        assertTrue(WgcCoreDsTypography.displayMediumSize > WgcCoreDsTypography.displaySmallSize)
    }

    @Test
    fun `headline scale sizes are strictly decreasing`() {
        assertTrue(WgcCoreDsTypography.headlineLargeSize > WgcCoreDsTypography.headlineMediumSize)
        assertTrue(WgcCoreDsTypography.headlineMediumSize > WgcCoreDsTypography.headlineSmallSize)
    }

    @Test
    fun `title scale sizes are strictly decreasing`() {
        assertTrue(WgcCoreDsTypography.titleLargeSize > WgcCoreDsTypography.titleMediumSize)
        assertTrue(WgcCoreDsTypography.titleMediumSize > WgcCoreDsTypography.titleSmallSize)
    }

    @Test
    fun `body scale sizes are strictly decreasing`() {
        assertTrue(WgcCoreDsTypography.bodyLargeSize > WgcCoreDsTypography.bodyMediumSize)
        assertTrue(WgcCoreDsTypography.bodyMediumSize > WgcCoreDsTypography.bodySmallSize)
    }

    @Test
    fun `label scale sizes are strictly decreasing`() {
        assertTrue(WgcCoreDsTypography.labelLargeSize > WgcCoreDsTypography.labelMediumSize)
        assertTrue(WgcCoreDsTypography.labelMediumSize > WgcCoreDsTypography.labelSmallSize)
    }
}
