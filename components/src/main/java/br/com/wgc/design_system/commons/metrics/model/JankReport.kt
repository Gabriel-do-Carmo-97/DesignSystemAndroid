package br.com.wgc.design_system.commons.metrics.model

/**
 * Métricas de um frame lento reportado por [br.com.wgc.design_system.commons.metrics.monitor.FrameMetricsMonitor].
 *
 * Use no callback de monitoramento para registrar ou diagnosticar fluidez. `isFrozen` indica que
 * a duração atingiu o limiar de congelamento do monitor; `timestamp` é o instante de criação em ms.
 *
 * @property totalDurationMs Duração total do frame em milissegundos.
 * @property isFrozen Se a duração atingiu o limiar de frame congelado.
 * @property timestamp Instante Unix em milissegundos em que o relatório foi criado.
 */
data class JankReport(
    val totalDurationMs: Long,
    val isFrozen: Boolean,
    val timestamp: Long = System.currentTimeMillis(),
)
