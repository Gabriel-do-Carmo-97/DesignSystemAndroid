package br.com.wgc.design_system.components.inputs

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class WgcSwitchUnitTest {

    @Test
    fun switch_stateToggleLogic_isCorrect() {
        var checkedState = false
        val onCheckedChange: (Boolean) -> Unit = { newValue ->
            checkedState = newValue
        }

        // Simulate toggle to true
        onCheckedChange(true)
        assertTrue(checkedState)

        // Simulate toggle to false
        onCheckedChange(false)
        assertFalse(checkedState)
    }
}
