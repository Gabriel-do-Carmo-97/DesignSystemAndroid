package br.com.wgc.design_system.core

/**
 * Tokens do sistema de Grid Responsivo (colunas, calhas e margens externas) por breakpoint de tela.
 */
object WgcResponsiveGridTokens {
    // Smartphone / Compact (< 600dp)
    const val columnsCompact = 4
    const val gutterCompactDp = 16f
    const val marginCompactDp = 16f

    // Tablet / Medium (600dp .. 840dp)
    const val columnsMedium = 8
    const val gutterMediumDp = 24f
    const val marginMediumDp = 32f

    // Desktop & Foldable Expandido (> 840dp)
    const val columnsExpanded = 12
    const val gutterExpandedDp = 24f
    const val marginExpandedDp = 48f
}
