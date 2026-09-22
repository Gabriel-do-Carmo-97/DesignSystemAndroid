package br.com.wgc.design_system.components.accordion

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class WgcAccordionTest {

    @Test
    fun expansionToggleFlipsState() {
        var isExpanded = false
        val onToggle = { isExpanded = !isExpanded }

        onToggle()
        assertTrue(isExpanded)

        onToggle()
        assertFalse(isExpanded)
    }
}
