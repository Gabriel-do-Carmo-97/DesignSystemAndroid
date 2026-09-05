package br.com.wgc.design_system.components.radio

import org.junit.Assert.assertTrue
import org.junit.Test

class WgcRadioButtonUnitTest {

    @Test
    fun radioButton_clickCallback_isInvoked() {
        var clicked = false
        val onClick: () -> Unit = {
            clicked = true
        }

        onClick()
        assertTrue(clicked)
    }
}
