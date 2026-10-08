package br.com.wgc.design_system.commons.haptics.contract

/**
 * Contrato oficial de feedback tátil (háptico) para componentes do Design System WGC.
 */
interface WgcHapticFeedback {
    /** Dispara vibração tátil suave para cliques em botões, chips e seletores. */
    fun click()

    /** Dispara vibração média para confirmação de ações (switches, checkboxes). */
    fun confirm()

    /** Dispara padrão tátil indicativo de sucesso ou conclusão. */
    fun success()

    /** Dispara vibração de alerta ou aviso de confirmação. */
    fun warning()

    /** Dispara padrão tátil firme para erros de validação ou recusa de ação. */
    fun error()
}
