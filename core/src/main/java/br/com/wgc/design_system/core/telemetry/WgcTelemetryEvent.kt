package br.com.wgc.design_system.core.telemetry

import br.com.wgc.design_system.core.brand.WgcBrandType

/**
 * Dados de uma ação de componente enviada à telemetria.
 *
 * Exemplo: `WgcTelemetryTracker.track("WgcButton", "click", WgcBrandType.DEFAULT)`.
 * Quando usar: escolha esta API quando enviar ao tracker os dados de uma ação de componente.
 */
data class WgcTelemetryEvent(
    val componentName: String,
    val actionType: String,
    val brandType: WgcBrandType = WgcBrandType.DEFAULT,
    val timestamp: Long = System.currentTimeMillis()
)
