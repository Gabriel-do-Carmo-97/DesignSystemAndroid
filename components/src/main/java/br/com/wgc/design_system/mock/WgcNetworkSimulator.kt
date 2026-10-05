package br.com.wgc.design_system.mock

import kotlinx.coroutines.delay

/**
 * Simulador de condições de rede para validação de estados de carregamento (Skeletons) e telas de contingência.
 */
object WgcNetworkSimulator {

    enum class NetworkCondition(val delayMs: Long, val isFailure: Boolean) {
        FAST(delayMs = 200, isFailure = false),
        SLOW_3G(delayMs = 2500, isFailure = false),
        OFFLINE(delayMs = 0, isFailure = true),
        SERVER_ERROR_500(delayMs = 800, isFailure = true)
    }

    suspend fun simulate(condition: NetworkCondition) {
        if (condition.delayMs > 0) {
            delay(condition.delayMs)
        }
        if (condition.isFailure) {
            error("Simulated Network Error: ${condition.name}")
        }
    }
}
