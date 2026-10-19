package br.com.wgc.design_system.core.feedback

import br.com.wgc.design_system.constants.CoreConstants

/**
 * Padrões de Feedback Tátil (Háptico) padronizados para o Design System WGC.
 * Garante que microinterações críticas (confirmação de compra, erro em senhas, alternância de switches)
 * possuam sensações táteis uniformes em toda a frota de dispositivos.
 * Exemplo: `val clickPattern = WgcCoreDsHaptics.PATTERN_LIGHT_CLICK`.
 * Quando usar: escolha esta API quando escolher feedback tatil consistente para uma interacao.
 */
object WgcCoreDsHaptics {
    /** Feedback suave e rápido para toques em botões e seletores (ex: Chips, Tabs) */
    const val PATTERN_LIGHT_CLICK = CoreConstants.CoreDsHaptics.PATTERN_LIGHT_CLICK

    /** Feedback médio para confirmações normais de ação (ex: Toggle Switch, Checkbox) */
    const val PATTERN_MEDIUM_CONFIRM = CoreConstants.CoreDsHaptics.PATTERN_MEDIUM_CONFIRM

    /** Feedback forte para ações de impacto (ex: Pagamento concluído, Transferência Pix) */
    const val PATTERN_HEAVY_SUCCESS = CoreConstants.CoreDsHaptics.PATTERN_HEAVY_SUCCESS

    /** Padrão duplo de vibração para alertas de limite ou aviso de confirmação */
    const val PATTERN_WARNING_ALERT = CoreConstants.CoreDsHaptics.PATTERN_WARNING_ALERT

    /** Padrão triplo ou rítmico de erro para falhas de validação ou biometria recusada */
    const val PATTERN_ERROR_REJECT = CoreConstants.CoreDsHaptics.PATTERN_ERROR_REJECT

    /** Duração em milissegundos para micro-vibração leve */
    const val DURATION_MICRO_MS = CoreConstants.CoreDsHaptics.DURATION_MICRO_MS

    /** Duração em milissegundos para vibração de confirmação */
    const val DURATION_STANDARD_MS = CoreConstants.CoreDsHaptics.DURATION_STANDARD_MS

    /** Duração em milissegundos para vibração de erro */
    const val DURATION_LONG_MS = CoreConstants.CoreDsHaptics.DURATION_LONG_MS

    const val patternLightClick = PATTERN_LIGHT_CLICK
    const val patternMediumConfirm = PATTERN_MEDIUM_CONFIRM
    const val patternHeavySuccess = PATTERN_HEAVY_SUCCESS
    const val patternWarningAlert = PATTERN_WARNING_ALERT
    const val patternErrorReject = PATTERN_ERROR_REJECT
}
