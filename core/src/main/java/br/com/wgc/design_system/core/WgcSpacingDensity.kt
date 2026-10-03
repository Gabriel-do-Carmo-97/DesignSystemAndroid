package br.com.wgc.design_system.core

/**
 * Modos de Densidade de Espaçamento para o WGC Design System.
 * - COMPACT: 75% da escala de espaçamento padrão (indicado para terminais de dados densos e tabelas).
 * - NORMAL: 100% da escala corporativa (padrão de produção).
 * - COMFORTABLE: 125% da escala (indicado para telas de onboarding e leitura espaçada).
 */
enum class WgcSpacingDensity(val scaleFactor: Double) {
    COMPACT(0.75),
    NORMAL(1.0),
    COMFORTABLE(1.25);

    /**
     * Aplica o multiplicador de densidade a um valor de espaçamento base.
     */
    fun scale(baseValue: Double): Double {
        return baseValue * scaleFactor
    }
}
