package br.com.wgc.design_system.core.tokens

import br.com.wgc.design_system.constants.CoreConstants

/**
 * Tokens de Breakpoints e Dimensões de Layout Adaptativo do Design System WGC.
 * Valores definidos em Dp numérico primitivo.
 *
 * Exemplo: `WgcCoreDsBreakpoints.calculateWindowSizeClass(700.0)`.
 * Quando usar: escolha esta API quando classificar a janela e adaptar o layout responsivo.
 */
object WgcCoreDsBreakpoints {
    /** Limite superior para telas compactas (smartphones em retrato) em dp */
    const val COMPACT_MAX: Double   = CoreConstants.CoreDsBreakpoints.COMPACT_MAX

    /** Limite inferior para telas médias (tablets pequenos e dobráveis) em dp */
    const val MEDIUM_MIN: Double   = CoreConstants.CoreDsBreakpoints.MEDIUM_MIN

    /** Limite superior para telas médias em dp */
    const val MEDIUM_MAX: Double   = CoreConstants.CoreDsBreakpoints.MEDIUM_MAX

    /** Limite inferior para telas expandidas (tablets grandes e desktops) em dp */
    const val EXPANDED_MIN: Double   = CoreConstants.CoreDsBreakpoints.EXPANDED_MIN

    /**
     * Calcula a classe de tamanho de janela a partir da largura disponível em dp.
     * Quando usar: chame este método ao escolher o layout correspondente à largura da janela.
     */
    fun calculateWindowSizeClass(widthDp: Double): WgcWindowSizeClass {
        return when {
            widthDp < MEDIUM_MIN -> WgcWindowSizeClass.COMPACT
            widthDp <= MEDIUM_MAX -> WgcWindowSizeClass.MEDIUM
            else -> WgcWindowSizeClass.EXPANDED
        }
    }
}
