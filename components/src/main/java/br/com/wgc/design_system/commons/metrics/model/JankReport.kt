package br.com.wgc.design_system.commons.metrics.model

/**
 * Dados de métrica de renderização de um frame com lentidão (jank) detectado.
 */
data class JankReport(
    val totalDurationMs: Long,
    val isFrozen: Boolean,
    val timestamp: Long = System.currentTimeMillis(),
)
