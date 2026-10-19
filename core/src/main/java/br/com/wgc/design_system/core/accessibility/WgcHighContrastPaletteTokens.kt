package br.com.wgc.design_system.core.accessibility

import br.com.wgc.design_system.constants.CoreConstants.HighContrastPaletteTokens as Tokens

/**
 * Tokens da paleta de Alto Contraste com garantia estrita de conformidade WCAG 2.1/2.2 nível AAA (>= 7:1).
 * Exemplo: `val contrast = WgcContrastCalculator.calculateContrastRatio(
 *     WgcHighContrastPaletteTokens.TEXT_ON_DARK_ARGB, WgcHighContrastPaletteTokens.BACKGROUND_DARK_ARGB)`.
 * Quando usar: escolha esta API quando apresentar conteúdo em uma paleta de alto contraste.
 */
object WgcHighContrastPaletteTokens {
    // Fundo preto puro e branco puro para máximo alcance dinâmico
    const val BACKGROUND_DARK_ARGB: Int = Tokens.BACKGROUND_DARK_ARGB
    const val BACKGROUND_LIGHT_ARGB: Int = Tokens.BACKGROUND_LIGHT_ARGB

    // Texto de máximo contraste
    const val TEXT_ON_DARK_ARGB: Int = Tokens.TEXT_ON_DARK_ARGB
    const val TEXT_ON_LIGHT_ARGB: Int = Tokens.TEXT_ON_LIGHT_ARGB

    // Cores de destaque com luminância calibrada para visibilidade extrema
    const val PRIMARY_HIGH_CONTRAST_YELLOW_ARGB: Int = Tokens.PRIMARY_HIGH_CONTRAST_YELLOW_ARGB
    const val PRIMARY_HIGH_CONTRAST_CYAN_ARGB: Int = Tokens.PRIMARY_HIGH_CONTRAST_CYAN_ARGB
    const val ERROR_HIGH_CONTRAST_ARGB: Int = Tokens.ERROR_HIGH_CONTRAST_ARGB
    const val SUCCESS_HIGH_CONTRAST_ARGB: Int = Tokens.SUCCESS_HIGH_CONTRAST_ARGB
}

