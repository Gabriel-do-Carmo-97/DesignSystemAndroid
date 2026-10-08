package br.com.wgc.design_system.commons.constants

import org.junit.Assert.assertEquals
import org.junit.Test

class ComponentsConstantsTest {

    @Test
    fun `commons constants should have expected values`() {
        assertEquals("pt-BR", ComponentsConstants.Commons.PT_BR)
        assertEquals("dd/MM/yyyy", ComponentsConstants.Commons.DEFAULT_DATE_PATTERN)
    }

    @Test
    fun `image constants should have expected dimensions`() {
        assertEquals(1920, ComponentsConstants.Image.DEFAULT_MAX_WIDTH)
        assertEquals(1080, ComponentsConstants.Image.DEFAULT_MAX_HEIGHT)
        assertEquals(80, ComponentsConstants.Image.DEFAULT_QUALITY)
    }

    @Test
    fun `modifiers constants should have expected timings`() {
        assertEquals(600L, ComponentsConstants.Modifiers.DEFAULT_DEBOUNCE_TIME_MS)
        assertEquals(0L, ComponentsConstants.Modifiers.INITIAL_CLICK_TIME_MS)
    }
}
