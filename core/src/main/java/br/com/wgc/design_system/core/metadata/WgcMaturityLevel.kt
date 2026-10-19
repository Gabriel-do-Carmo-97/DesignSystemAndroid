package br.com.wgc.design_system.core.metadata

/**
 * Estado de estabilidade e ciclo de vida de uma API do Design System.
 *
 * Exemplo: `@WgcMaturity(level = WgcMaturityLevel.BETA)`.
 * Quando usar: escolha esta API quando classificar a estabilidade de uma API do Design System.
 */
enum class WgcMaturityLevel {
    EXPERIMENTAL,
    BETA,
    STABLE,
    DEPRECATED
}
