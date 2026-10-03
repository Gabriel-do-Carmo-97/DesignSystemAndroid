package br.com.wgc.design_system.core

/**
 * Esquema unificado de eventos de telemetria e analytics corporativos (Mixpanel, Amplitude, GA4).
 */
object WgcAnalyticsSchema {

    // Nomes padronizados de eventos
    const val EVENT_SCREEN_VIEW = "wgc_screen_view"
    const val EVENT_COMPONENT_CLICK = "wgc_component_click"
    const val EVENT_FLOW_STARTED = "wgc_flow_started"
    const val EVENT_FLOW_COMPLETED = "wgc_flow_completed"
    const val EVENT_ERROR_DISPLAYED = "wgc_error_displayed"

    // Parâmetros padronizados
    const val PARAM_SCREEN_NAME = "screen_name"
    const val PARAM_COMPONENT_ID = "component_id"
    const val PARAM_FLOW_NAME = "flow_name"
    const val PARAM_ERROR_CODE = "error_code"
    const val PARAM_TENANT = "tenant"
}
