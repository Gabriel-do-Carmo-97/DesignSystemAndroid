package br.com.wgc.design_system.core.theme

/**
 * Contrato mínimo de cores semânticas para implementar temas intercambiáveis.
 *
 * Exemplo: `val background = theme.backgroundColor`.
 * Quando usar: escolha esta API quando implementar ou consumir cores semânticas de um tema.
 */
interface WgcThemeTokens {
    val primaryColor: Int
    val secondaryColor: Int
    val backgroundColor: Int
}
