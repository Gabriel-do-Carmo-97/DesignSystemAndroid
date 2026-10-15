package br.com.wgc.design_system.core.telemetry

import br.com.wgc.design_system.core.brand.WgcBrandType

/**
 * Tracker central singleton de telemetria para componentes e tokens do WGC Design System.
 * Exemplo: `WgcTelemetryTracker.track("WgcButton", "click")`.
 * Quando usar: escolha esta API quando registrar listeners ou reportar ações de componentes.
 */
object WgcTelemetryTracker {
    private val listeners = mutableListOf<WgcTelemetryListener>()

    fun registerListener(listener: WgcTelemetryListener) {
        synchronized(listeners) {
            listeners.add(listener)
        }
    }

    fun unregisterListener(listener: WgcTelemetryListener) {
        synchronized(listeners) {
            listeners.remove(listener)
        }
    }

    fun track(componentName: String, actionType: String, brandType: WgcBrandType = WgcBrandType.DEFAULT) {
        val event = WgcTelemetryEvent(
            componentName = componentName,
            actionType = actionType,
            brandType = brandType
        )
        synchronized(listeners) {
            listeners.forEach { it.onEvent(event) }
        }
    }
}
