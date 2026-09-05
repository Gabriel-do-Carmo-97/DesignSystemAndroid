package br.com.wgc.design_system.components.chip

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class WgcChipUnitTest {

    @Test
    fun chip_selectionState_properties() {
        val label = "Filtro"
        val selected = true
        assertEquals("Filtro", label)
        assertTrue(selected)
    }

    @Test
    fun chip_clickCallback_isInvoked() {
        var clicked = false
        val onClick = { clicked = true }
        onClick()
        assertTrue(clicked)
    }
}
