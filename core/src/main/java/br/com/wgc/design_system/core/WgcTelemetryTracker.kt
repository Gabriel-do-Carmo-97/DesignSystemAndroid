package br.com.wgc.design_system.core

/**
 * Evento de telemetria emitido pelo Design System WGC.
 */
data class WgcTelemetryEvent(
    val componentName: String,
    val actionType: String,
    val brandType: WgcBrandType = WgcBrandType.DEFAULT,
    val timestamp: Long = System.currentTimeMillis()
)

/**
 * Listener de telemetria para observabilidade corporativa e medição de adoção de componentes.
 */
fun interface WgcTelemetryListener {
    fun onEvent(event: WgcTelemetryEvent)
}

/**
 * Tracker central singleton de telemetria para componentes e tokens do WGC Design System.
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
