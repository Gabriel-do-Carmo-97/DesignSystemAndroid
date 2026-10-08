package br.com.wgc.design_system.commons.metrics.monitor

import br.com.wgc.design_system.commons.constants.ComponentsConstants
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test

class FrameMetricsMonitorTest {

    @Test
    fun `constants should match expected threshold values`() {
        assertEquals(
            ComponentsConstants.Metrics.DEFAULT_JANK_THRESHOLD_MS,
            FrameMetricsMonitor.DEFAULT_JANK_THRESHOLD_MS,
        )
        assertEquals(
            ComponentsConstants.Metrics.FROZEN_THRESHOLD_MS,
            FrameMetricsMonitor.FROZEN_THRESHOLD_MS,
        )
    }

    @Test
    fun `monitor initial state should not be monitoring`() {
        val monitor = FrameMetricsMonitor()
        assertFalse(monitor.isMonitoring())
    }
}
