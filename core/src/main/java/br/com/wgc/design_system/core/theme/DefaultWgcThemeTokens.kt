package br.com.wgc.design_system.core.theme

/**
 * Implementação dos tokens de tema com as cores padrão corporativas da WGC.
 *
 * Exemplo: `val theme: WgcThemeTokens = DefaultWgcThemeTokens()`.
 * Quando usar: escolha esta API quando o produto precisar dos tokens semanticos corporativos padrao.
 */
class DefaultWgcThemeTokens : WgcThemeTokens {
    override val primaryColor: Int = WgcCoreDsColorsFacade.orange500
    override val secondaryColor: Int = WgcCoreDsColorsFacade.white
    override val backgroundColor: Int = WgcCoreDsColorsFacade.gray50
}
