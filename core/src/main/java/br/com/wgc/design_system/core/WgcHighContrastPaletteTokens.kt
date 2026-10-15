package br.com.wgc.design_system.core

/**
 * Tokens da paleta de Alto Contraste com garantia estrita de conformidade WCAG 2.1/2.2 nível AAA (>= 7:1).
 */
object WgcHighContrastPaletteTokens {
    // Fundo preto puro e branco puro para máximo alcance dinâmico
    const val backgroundDarkArgb: Int  = CoreConstants.HighContrastPaletteTokens.BACKGROUND_DARK_ARGB
    const val backgroundLightArgb: Int  = CoreConstants.HighContrastPaletteTokens.BACKGROUND_LIGHT_ARGB

    // Texto de máximo contraste
    const val textOnDarkArgb: Int  = CoreConstants.HighContrastPaletteTokens.TEXT_ON_DARK_ARGB
    const val textOnLightArgb: Int  = CoreConstants.HighContrastPaletteTokens.TEXT_ON_LIGHT_ARGB

    // Cores de destaque com luminância calibrada para visibilidade extrema
    const val primaryHighContrastYellowArgb: Int  = CoreConstants.HighContrastPaletteTokens.PRIMARY_HIGH_CONTRAST_YELLOW_ARGB
    const val primaryHighContrastCyanArgb: Int  = CoreConstants.HighContrastPaletteTokens.PRIMARY_HIGH_CONTRAST_CYAN_ARGB
    const val errorHighContrastArgb: Int  = CoreConstants.HighContrastPaletteTokens.ERROR_HIGH_CONTRAST_ARGB
    const val successHighContrastArgb: Int  = CoreConstants.HighContrastPaletteTokens.SUCCESS_HIGH_CONTRAST_ARGB
}
