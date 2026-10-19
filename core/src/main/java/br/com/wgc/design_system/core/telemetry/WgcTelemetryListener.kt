package br.com.wgc.design_system.core.telemetry

/**
 * Recebe eventos emitidos pelo tracker de telemetria do Design System.
 *
 * Exemplo: `WgcTelemetryTracker.registerListener(WgcTelemetryListener { event -> log(event) })`.
 * Quando usar: escolha esta API quando observar eventos emitidos pelo tracker de telemetria.
 */
fun interface WgcTelemetryListener {
    fun onEvent(event: WgcTelemetryEvent)
}
