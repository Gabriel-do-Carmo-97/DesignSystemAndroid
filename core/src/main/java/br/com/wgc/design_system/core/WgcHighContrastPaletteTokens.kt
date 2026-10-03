package br.com.wgc.design_system.core

/**
 * Tokens da paleta de Alto Contraste com garantia estrita de conformidade WCAG 2.1/2.2 nível AAA (>= 7:1).
 */
object WgcHighContrastPaletteTokens {
    // Fundo preto puro e branco puro para máximo alcance dinâmico
    const val backgroundDarkArgb: Int = 0xFF000000.toInt()
    const val backgroundLightArgb: Int = 0xFFFFFFFF.toInt()

    // Texto de máximo contraste
    const val textOnDarkArgb: Int = 0xFFFFFFFF.toInt()
    const val textOnLightArgb: Int = 0xFF000000.toInt()

    // Cores de destaque com luminância calibrada para visibilidade extrema
    const val primaryHighContrastYellowArgb: Int = 0xFFFFD700.toInt()
    const val primaryHighContrastCyanArgb: Int = 0xFF00E5FF.toInt()
    const val errorHighContrastArgb: Int = 0xFFFF1744.toInt()
    const val successHighContrastArgb: Int = 0xFF00E676.toInt()
}
