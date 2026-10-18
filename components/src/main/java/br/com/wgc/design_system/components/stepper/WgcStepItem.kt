package br.com.wgc.design_system.components.stepper

/**
 * Item representativo de uma etapa do formulário/fluxo (WgcStepItem).
 */
data class WgcStepItem(
    val title: String,
    val state: WgcStepState
)
