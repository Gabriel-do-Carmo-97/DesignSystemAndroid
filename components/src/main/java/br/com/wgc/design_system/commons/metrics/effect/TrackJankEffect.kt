package br.com.wgc.design_system.commons.metrics.effect

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalContext
import br.com.wgc.design_system.commons.metrics.model.JankReport
import br.com.wgc.design_system.commons.metrics.monitor.FrameMetricsMonitor

/**
 * Composable Effect para monitoramento automático de Jank durante o ciclo de vida da tela Compose.
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
