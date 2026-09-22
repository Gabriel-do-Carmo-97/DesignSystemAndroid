package br.com.wgc.design_system.components.gauge

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class WgcGaugeScoreMeterTest {

    @Test
    fun `score ratio is calculated correctly within range`() {
        val min = 0
        val max = 1000
        val score = 750

        val ratio = (score - min).toFloat() / (max - min)
        assertEquals(0.75f, ratio, 0.001f)
    }

    @Test
    fun `score ratio coerces properly with extreme values`() {
        val min = 0
        val max = 1000

        val overScore = 1200
        val overRatio = ((overScore - min).toFloat() / (max - min)).coerceIn(0f, 1f)
        assertEquals(1.0f, overRatio, 0.001f)

        val underScore = -50
        val underRatio = ((underScore - min).toFloat() / (max - min)).coerceIn(0f, 1f)
        assertEquals(0.0f, underRatio, 0.001f)
    }

    @Test
    fun `label and subtitle are assigned correctly`() {
        val label = "Excelente"
        val subtitle = "Atualizado em tempo real"

        assertEquals("Excelente", label)
        assertTrue(subtitle.isNotEmpty())
    }
}
