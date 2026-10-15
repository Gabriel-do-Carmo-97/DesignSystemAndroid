package br.com.wgc.design_system.core.tokens

/**
 * Classe de largura de janela usada para adaptar o layout a diferentes dispositivos.
 *
 * Exemplo: `if (sizeClass == WgcWindowSizeClass.COMPACT) showSingleColumn()`.
 * Quando usar: escolha esta API quando selecionar layouts distintos conforme a largura da janela.
 */
enum class WgcWindowSizeClass {
    /** Smartphones em modo retrato (< 600dp). */
    COMPACT,
    /** Telas médias, dobráveis abertos e tablets pequenos em retrato (600dp–839dp). */
    MEDIUM,
    /** Tablets em paisagem, dobráveis expandidos e desktops (>= 840dp). */
    EXPANDED
}
