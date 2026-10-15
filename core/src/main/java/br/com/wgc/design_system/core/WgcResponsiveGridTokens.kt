package br.com.wgc.design_system.core

/**
 * Tokens do sistema de Grid Responsivo (colunas, calhas e margens externas) por breakpoint de tela.
 */
object WgcResponsiveGridTokens {
    // Smartphone / Compact (< 600dp)
    const val columnsCompact = CoreConstants.ResponsiveGridTokens.COLUMNS_COMPACT
    const val gutterCompactDp = CoreConstants.ResponsiveGridTokens.GUTTER_COMPACT_DP
    const val marginCompactDp = CoreConstants.ResponsiveGridTokens.MARGIN_COMPACT_DP

    // Tablet / Medium (600dp .. 840dp)
    const val columnsMedium = CoreConstants.ResponsiveGridTokens.COLUMNS_MEDIUM
    const val gutterMediumDp = CoreConstants.ResponsiveGridTokens.GUTTER_MEDIUM_DP
    const val marginMediumDp = CoreConstants.ResponsiveGridTokens.MARGIN_MEDIUM_DP

    // Desktop & Foldable Expandido (> 840dp)
    const val columnsExpanded = CoreConstants.ResponsiveGridTokens.COLUMNS_EXPANDED
    const val gutterExpandedDp = CoreConstants.ResponsiveGridTokens.GUTTER_EXPANDED_DP
    const val marginExpandedDp = CoreConstants.ResponsiveGridTokens.MARGIN_EXPANDED_DP
}
