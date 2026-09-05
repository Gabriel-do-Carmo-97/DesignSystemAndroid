package br.com.wgc.design_system.components.alert

import org.junit.Assert.assertEquals
import org.junit.Test

class WgcAlertUnitTest {

    @Test
    fun alertType_enumValues_areCorrect() {
        val types = AlertType.entries
        assertEquals(4, types.size)
        assertEquals(AlertType.SUCCESS, types[0])
        assertEquals(AlertType.ERROR, types[1])
        assertEquals(AlertType.WARNING, types[2])
        assertEquals(AlertType.INFO, types[3])
    }
}
