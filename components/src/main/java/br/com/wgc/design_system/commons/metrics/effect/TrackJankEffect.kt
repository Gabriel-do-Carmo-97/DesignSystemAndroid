package br.com.wgc.design_system.commons.metrics.effect

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalContext
import br.com.wgc.design_system.commons.metrics.model.JankReport
import br.com.wgc.design_system.commons.metrics.monitor.FrameMetricsMonitor

/**
 * Observa as métricas de frames da janela da Activity enquanto este composable estiver na composição.
 *
 * Use em uma tela Compose hospedada por uma Activity para registrar frames cuja duração atinja
 * [thresholdMs]. O listener é removido ao sair da composição ou quando a Activity/limite muda.
 * Fora de uma Activity, o efeito não inicia monitoramento.
 *
 * ```kotlin
 * TrackJankEffect { report -> analytics.recordFrameJank(report.totalDurationMs) }
 * ```
 *
 * @param thresholdMs Duração mínima do frame, em ms, para reportar jank.
 * @param onJankDetected Callback chamado para cada frame acima do limite.
 */
@Composable
fun TrackJankEffect(
    thresholdMs: Long = FrameMetricsMonitor.DEFAULT_JANK_THRESHOLD_MS,
    onJankDetected: (JankReport) -> Unit,
) {
    val context = LocalContext.current
    val activity = context as? Activity ?: return

    DisposableEffect(activity, thresholdMs) {
        val monitor = FrameMetricsMonitor(thresholdMs)
        monitor.startMonitoring(activity.window, onJankDetected = onJankDetected)

        onDispose {
            monitor.stopMonitoring(activity.window)
        }
    }
}
