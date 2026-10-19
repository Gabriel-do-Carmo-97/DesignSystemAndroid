package br.com.wgc.design_system.commons.haptics.contract

/**
 * Contrato de feedback tátil para comunicar interações e resultados sem depender de uma implementação
 * específica do dispositivo.
 *
 * Use os métodos nos eventos correspondentes (por exemplo, `click()` após uma ativação e `error()`
 * após uma validação recusada). Em Compose, obtenha a implementação padrão com
 * `rememberWgcHapticFeedback()`.
 *
 * ```kotlin
 * val haptics = rememberWgcHapticFeedback()
 * Button(onClick = { haptics.click(); onSubmit() }) { Text("Enviar") }
 * ```
 */
interface WgcHapticFeedback {
    /** Dispara vibração tátil suave para cliques em botões, chips e seletores. */
    fun click()

    /** Dispara vibração média para confirmação de ações (switches, checkboxes). */
    fun confirm()

    /** Comunica sucesso ou conclusão de uma operação. */
    fun success()

    /** Comunica um aviso que não representa necessariamente uma falha. */
    fun warning()

    /** Dispara padrão tátil firme para erros de validação ou recusa de ação. */
    fun error()
}
