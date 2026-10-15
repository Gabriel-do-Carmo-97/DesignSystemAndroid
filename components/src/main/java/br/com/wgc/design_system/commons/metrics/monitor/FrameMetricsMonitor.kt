package br.com.wgc.design_system.commons.metrics.monitor

import android.os.Handler
import android.os.Looper
import android.view.FrameMetrics
import android.view.Window
import br.com.wgc.design_system.commons.metrics.model.JankReport
import br.com.wgc.design_system.commons.constants.ComponentsConstants

/**
 * Monitor agnóstico de Jank e taxas de renderização utilizando [Window.OnFrameMetricsAvailableListener].
 */
class FrameMetricsMonitor(
    private val jankThresholdMs: Long = DEFAULT_JANK_THRESHOLD_MS,
) {
    private var listener: Window.OnFrameMetricsAvailableListener? = null
    private var isMonitoring: Boolean = false

    fun startMonitoring(
        window: Window,
        handler: Handler = Handler(Looper.getMainLooper()),
        onJankDetected: (JankReport) -> Unit,
    ) {
        if (isMonitoring) return

        val frameListener =
            Window.OnFrameMetricsAvailableListener { _, frameMetrics, _ ->
                val durationNs = frameMetrics.getMetric(FrameMetrics.TOTAL_DURATION)
                val durationMs = durationNs / NANOS_PER_MILLI
                if (durationMs >= jankThresholdMs) {
                    val isFrozen = durationMs >= FROZEN_THRESHOLD_MS
                    onJankDetected(
                        JankReport(
                            totalDurationMs = durationMs,
                            isFrozen = isFrozen,
                        ),
                    )
                }
            }

        this.listener = frameListener
        window.addOnFrameMetricsAvailableListener(frameListener, handler)
        this.isMonitoring = true
    }

    fun stopMonitoring(window: Window) {
        listener?.let {
            try {
                window.removeOnFrameMetricsAvailableListener(it)
            } catch (@Suppress("SwallowedException") _: IllegalArgumentException) {
                // Listener já removido
            }
        }
        listener = null
        isMonitoring = false
    }

    fun isMonitoring(): Boolean = isMonitoring

    companion object {
        const val DEFAULT_JANK_THRESHOLD_MS: Long  = ComponentsConstants.Metrics.DEFAULT_JANK_THRESHOLD_MS
        const val FROZEN_THRESHOLD_MS: Long  = ComponentsConstants.Metrics.FROZEN_THRESHOLD_MS
        private const val NANOS_PER_MILLI: Long  = ComponentsConstants.Metrics.NANOS_PER_MILLI
    }
}
