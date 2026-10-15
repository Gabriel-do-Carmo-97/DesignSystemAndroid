package br.com.wgc.design_system.commons.metrics.model

import br.com.wgc.design_system.commons.constants.ComponentsConstants
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class JankReportTest {

    @Test
    fun `JankReport should hold correct metrics`() {
        val durationMs = ComponentsConstants.Metrics.DEFAULT_JANK_THRESHOLD_MS
        val report = JankReport(totalDurationMs = durationMs, isFrozen = false)
        assertEquals(durationMs, report.totalDurationMs)
        assertFalse(report.isFrozen)
        assertTrue(report.timestamp > 0L)
    }
}
