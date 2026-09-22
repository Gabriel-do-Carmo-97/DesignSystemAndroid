package br.com.wgc.design_system.components.timeline

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class WgcTimelineTrackerTest {

    @Test
    fun `timeline items instantiate with correct default states`() {
        val item = WgcTimelineStep(id = "step-1", title = "Análise Cadastral")
        assertEquals("step-1", item.id)
        assertEquals("Análise Cadastral", item.title)
        assertEquals(WgcTimelineState.Pending, item.state)
    }

    @Test
    fun `timeline orientation enum contains both options`() {
        assertEquals(2, WgcTimelineOrientation.values().size)
        assertNotNull(WgcTimelineOrientation.valueOf("Vertical"))
        assertNotNull(WgcTimelineOrientation.valueOf("Horizontal"))
    }

    @Test
    fun `timeline states encompass all lifecycle steps`() {
        assertEquals(4, WgcTimelineState.values().size)
        assertEquals(WgcTimelineState.Completed, WgcTimelineState.valueOf("Completed"))
        assertEquals(WgcTimelineState.InProgress, WgcTimelineState.valueOf("InProgress"))
        assertEquals(WgcTimelineState.Pending, WgcTimelineState.valueOf("Pending"))
        assertEquals(WgcTimelineState.Failed, WgcTimelineState.valueOf("Failed"))
    }
}
