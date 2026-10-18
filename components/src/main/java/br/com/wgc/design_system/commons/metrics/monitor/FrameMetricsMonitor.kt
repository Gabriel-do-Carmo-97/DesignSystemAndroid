package br.com.wgc.design_system.commons.metrics.monitor

import android.os.Handler
import android.os.Looper
import android.view.FrameMetrics
import android.view.Window
import br.com.wgc.design_system.commons.metrics.model.JankReport
import br.com.wgc.design_system.commons.constants.ComponentsConstants

/**
 * Monitora frames de uma [Window] e informa os que excedem um limite de duração.
 *
 * Use para instrumentar uma janela fora de um efeito Compose; inicie com [startMonitoring] e pare
 * com [stopMonitoring] quando o ciclo de vida do proprietário da janela terminar. O monitor reporta
 * jank, mas não calcula uma taxa de frames por segundo.
 *
 * ```kotlin
 * val monitor = FrameMetricsMonitor()
 * monitor.startMonitoring(window) { report -> log(report.totalDurationMs) }
 * // Ao encerrar a observação: monitor.stopMonitoring(window)
 * ```
 *
 * @param jankThresholdMs Duração mínima, em ms, para gerar um [JankReport].
 */
class FrameMetricsMonitor(
    private val jankThresholdMs: Long = DEFAULT_JANK_THRESHOLD_MS,
) {
    private var listener: Window.OnFrameMetricsAvailableListener? = null
    private var isMonitoring: Boolean = false

    /**
     * Registra um listener na janela e entrega um relatório a cada frame que atinge o limite.
     *
     * Uma segunda chamada enquanto o monitor já estiver ativo não registra outro listener.
     *
     * @param window Janela cujos frames serão observados.
     * @param handler Handler que recebe os callbacks; por padrão, a thread principal.
     * @param onJankDetected Callback executado para cada frame lento detectado.
     */
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

    /**
     * Remove o listener ativo e torna possível iniciar novamente o monitoramento.
     *
     * @param window A mesma janela usada em [startMonitoring].
     */
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

    /** Retorna se um listener está atualmente registrado. */
    fun isMonitoring(): Boolean = isMonitoring

    companion object {
        /** Limite padrão, em ms, a partir do qual um frame é reportado como jank. */
        const val DEFAULT_JANK_THRESHOLD_MS: Long  = ComponentsConstants.Metrics.DEFAULT_JANK_THRESHOLD_MS
        /** Limite, em ms, para classificar um frame reportado como congelado. */
        const val FROZEN_THRESHOLD_MS: Long  = ComponentsConstants.Metrics.FROZEN_THRESHOLD_MS
        private const val NANOS_PER_MILLI: Long  = ComponentsConstants.Metrics.NANOS_PER_MILLI
    }
}
