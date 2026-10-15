package br.com.wgc.design_system.core

import br.com.wgc.design_system.constants.CoreConstants

/**
 * Categorias de Tamanho de Janela / Layout Adaptativo.
 */
enum class WgcWindowSizeClass {
    /** Smartphones em modo retrato (< 600dp) */
    Compact,

    /** Telas médias, dobráveis abertos e tablets pequenos em retrato (600dp - 839dp) */
    Medium,

    /** Tablets em paisagem, dobráveis expandidos e desktops (>= 840dp) */
    Expanded
}

/**
 * Tokens de Breakpoints e Dimensões de Layout Adaptativo do Design System WGC.
 * Valores definidos em Dp numérico primitivo.
 */
object WgcCoreDsBreakpoints {
    /** Limite superior para telas compactas (smartphones em retrato) em dp */
    const val compactMax: Double   = CoreConstants.CoreDsBreakpoints.COMPACT_MAX

    /** Limite inferior para telas médias (tablets pequenos e dobráveis) em dp */
    const val mediumMin: Double   = CoreConstants.CoreDsBreakpoints.MEDIUM_MIN

    /** Limite superior para telas médias em dp */
    const val mediumMax: Double   = CoreConstants.CoreDsBreakpoints.MEDIUM_MAX

    /** Limite inferior para telas expandidas (tablets grandes e desktops) em dp */
    const val expandedMin: Double   = CoreConstants.CoreDsBreakpoints.EXPANDED_MIN

    /**
     * Calcula a classe de tamanho de janela a partir da largura disponível em dp.
     */
    fun calculateWindowSizeClass(widthDp: Double): WgcWindowSizeClass {
        return when {
            widthDp < mediumMin -> WgcWindowSizeClass.Compact
            widthDp <= mediumMax -> WgcWindowSizeClass.Medium
            else -> WgcWindowSizeClass.Expanded
        }
    }
}
