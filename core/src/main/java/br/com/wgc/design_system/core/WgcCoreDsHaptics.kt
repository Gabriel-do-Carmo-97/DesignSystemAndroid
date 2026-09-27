package br.com.wgc.design_system.core

/**
 * Padrões de Feedback Tátil (Háptico) padronizados para o Design System WGC.
 * Garante que microinterações críticas (confirmação de compra, erro em senhas, alternância de switches)
 * possuam sensações táteis uniformes em toda a frota de dispositivos.
 */
object WgcCoreDsHaptics {
    /** Feedback suave e rápido para toques em botões e seletores (ex: Chips, Tabs) */
    const val patternLightClick = "LIGHT_CLICK"

    /** Feedback médio para confirmações normais de ação (ex: Toggle Switch, Checkbox) */
    const val patternMediumConfirm = "MEDIUM_CONFIRM"

    /** Feedback forte para ações de impacto (ex: Pagamento concluído, Transferência Pix) */
    const val patternHeavySuccess = "HEAVY_SUCCESS"

    /** Padrão duplo de vibração para alertas de limite ou aviso de confirmação */
    const val patternWarningAlert = "WARNING_ALERT"

    /** Padrão triplo ou rítmico de erro para falhas de validação ou biometria recusada */
    const val patternErrorReject = "ERROR_REJECT"

    /** Duração em milissegundos para micro-vibração leve */
    const val durationMicroMs = 15L

    /** Duração em milissegundos para vibração de confirmação */
    const val durationStandardMs = 40L

    /** Duração em milissegundos para vibração de erro */
    const val durationLongMs = 80L
}
