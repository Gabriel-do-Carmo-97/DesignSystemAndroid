package br.com.wgc.design_system.components.timeline

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class WgcTimelineTest {

    @Test
    fun `WgcTimelineStatus should contain all expected states`() {
        val statuses = WgcTimelineStatus.entries
        assertEquals(3, statuses.size)
        assertTrue(statuses.contains(WgcTimelineStatus.COMPLETED))
        assertTrue(statuses.contains(WgcTimelineStatus.CURRENT))
        assertTrue(statuses.contains(WgcTimelineStatus.PENDING))
    }

    @Test
    fun `WgcTimelineItem should construct with default values`() {
        val item = WgcTimelineItem(title = "Etapa 1")
        assertEquals("Etapa 1", item.title)
        assertNull(item.description)
        assertNull(item.timestamp)
        assertEquals(WgcTimelineStatus.PENDING, item.status)
        assertNull(item.icon)
    }
}
