package br.com.wgc.design_system.core

/**
 * Esquema unificado de eventos de telemetria e analytics corporativos (Mixpanel, Amplitude, GA4).
 */
object WgcAnalyticsSchema {

    // Nomes padronizados de eventos
    const val EVENT_SCREEN_VIEW = CoreConstants.AnalyticsSchema.EVENT_SCREEN_VIEW
    const val EVENT_COMPONENT_CLICK = CoreConstants.AnalyticsSchema.EVENT_COMPONENT_CLICK
    const val EVENT_FLOW_STARTED = CoreConstants.AnalyticsSchema.EVENT_FLOW_STARTED
    const val EVENT_FLOW_COMPLETED = CoreConstants.AnalyticsSchema.EVENT_FLOW_COMPLETED
    const val EVENT_ERROR_DISPLAYED = CoreConstants.AnalyticsSchema.EVENT_ERROR_DISPLAYED

    // Parâmetros padronizados
    const val PARAM_SCREEN_NAME = CoreConstants.AnalyticsSchema.PARAM_SCREEN_NAME
    const val PARAM_COMPONENT_ID = CoreConstants.AnalyticsSchema.PARAM_COMPONENT_ID
    const val PARAM_FLOW_NAME = CoreConstants.AnalyticsSchema.PARAM_FLOW_NAME
    const val PARAM_ERROR_CODE = CoreConstants.AnalyticsSchema.PARAM_ERROR_CODE
    const val PARAM_TENANT = CoreConstants.AnalyticsSchema.PARAM_TENANT
}
