package br.com.wgc.design_system.core

import br.com.wgc.design_system.core.tokens.WgcCoreDsTypography
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Testes de consistência e hierarquia dos tokens tipográficos.
 * Quando executar: ao alterar pesos, tamanhos ou escalas tipográficas.
 */
class WgcCoreDsTypographyTest {

    @Test
    fun `font weights conform to standards`() {
        assertEquals(700, WgcCoreDsTypography.WEIGHT_BOLD)
        assertEquals(600, WgcCoreDsTypography.WEIGHT_SEMI_BOLD)
        assertEquals(500, WgcCoreDsTypography.WEIGHT_MEDIUM)
        assertEquals(400, WgcCoreDsTypography.WEIGHT_NORMAL)
        assertEquals(300, WgcCoreDsTypography.WEIGHT_LIGHT)
    }

    @Test
    fun `display scale sizes are strictly decreasing`() {
        assertTrue(WgcCoreDsTypography.DISPLAY_LARGE_SIZE > WgcCoreDsTypography.DISPLAY_MEDIUM_SIZE)
        assertTrue(WgcCoreDsTypography.DISPLAY_MEDIUM_SIZE > WgcCoreDsTypography.DISPLAY_SMALL_SIZE)
    }

    @Test
    fun `headline scale sizes are strictly decreasing`() {
        assertTrue(WgcCoreDsTypography.HEADLINE_LARGE_SIZE > WgcCoreDsTypography.HEADLINE_MEDIUM_SIZE)
        assertTrue(WgcCoreDsTypography.HEADLINE_MEDIUM_SIZE > WgcCoreDsTypography.HEADLINE_SMALL_SIZE)
    }

    @Test
    fun `title scale sizes are strictly decreasing`() {
        assertTrue(WgcCoreDsTypography.TITLE_LARGE_SIZE > WgcCoreDsTypography.TITLE_MEDIUM_SIZE)
        assertTrue(WgcCoreDsTypography.TITLE_MEDIUM_SIZE > WgcCoreDsTypography.TITLE_SMALL_SIZE)
    }

    @Test
    fun `body scale sizes are strictly decreasing`() {
        assertTrue(WgcCoreDsTypography.BODY_LARGE_SIZE > WgcCoreDsTypography.BODY_MEDIUM_SIZE)
        assertTrue(WgcCoreDsTypography.BODY_MEDIUM_SIZE > WgcCoreDsTypography.BODY_SMALL_SIZE)
    }

    @Test
    fun `label scale sizes are strictly decreasing`() {
        assertTrue(WgcCoreDsTypography.LABEL_LARGE_SIZE > WgcCoreDsTypography.LABEL_MEDIUM_SIZE)
        assertTrue(WgcCoreDsTypography.LABEL_MEDIUM_SIZE > WgcCoreDsTypography.LABEL_SMALL_SIZE)
    }
}
