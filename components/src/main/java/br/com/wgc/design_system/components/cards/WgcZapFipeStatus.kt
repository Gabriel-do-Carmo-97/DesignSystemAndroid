package br.com.wgc.design_system.components.cards

/**
 * Status de precificação em relação ao Índice FipeZAP.
 */
enum class WgcZapFipeStatus(val label: String) {
    BELOW_AVERAGE("Preço abaixo da média"),
    ON_AVERAGE("Preço na média"),
    ABOVE_AVERAGE("Preço acima da média")
}
