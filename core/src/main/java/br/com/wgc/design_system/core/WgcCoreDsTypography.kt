package br.com.wgc.design_system.core

/**
 * Tokens de Tipografia Oficial do Design System WGC.
 * Padroniza escalas de display, headline, title, body e label para garantir hierarquia consistente.
 * Valores definidos em pontos/sp primitivos para máxima portabilidade.
 */
object WgcCoreDsTypography {
    // --- PESOS DE FONTE (FONT WEIGHTS) ---
    const val weightBold = 700
    const val weightSemiBold = 600
    const val weightMedium = 500
    const val weightNormal = 400
    const val weightLight = 300

    // --- DISPLAY (Telas de impacto, splash, números grandes) ---
    const val displayLargeSize: Double = 57.0
    const val displayLargeLineHeight: Double = 64.0
    const val displayLargeTracking: Double = -0.25

    const val displayMediumSize: Double = 45.0
    const val displayMediumLineHeight: Double = 52.0
    const val displayMediumTracking: Double = 0.0

    const val displaySmallSize: Double = 36.0
    const val displaySmallLineHeight: Double = 44.0
    const val displaySmallTracking: Double = 0.0

    // --- HEADLINE (Títulos de seções principais, cabeçalhos de tela) ---
    const val headlineLargeSize: Double = 32.0
    const val headlineLargeLineHeight: Double = 40.0
    const val headlineLargeTracking: Double = 0.0

    const val headlineMediumSize: Double = 28.0
    const val headlineMediumLineHeight: Double = 36.0
    const val headlineMediumTracking: Double = 0.0

    const val headlineSmallSize: Double = 24.0
    const val headlineSmallLineHeight: Double = 32.0
    const val headlineSmallTracking: Double = 0.0

    // --- TITLE (Títulos de cards, diálogos, itens de lista destacados) ---
    const val titleLargeSize: Double = 22.0
    const val titleLargeLineHeight: Double = 28.0
    const val titleLargeTracking: Double = 0.0

    const val titleMediumSize: Double = 16.0
    const val titleMediumLineHeight: Double = 24.0
    const val titleMediumTracking: Double = 0.15

    const val titleSmallSize: Double = 14.0
    const val titleSmallLineHeight: Double = 20.0
    const val titleSmallTracking: Double = 0.1

    // --- BODY (Textos corridos, descrições, parágrafos) ---
    const val bodyLargeSize: Double = 16.0
    const val bodyLargeLineHeight: Double = 24.0
    const val bodyLargeTracking: Double = 0.5

    const val bodyMediumSize: Double = 14.0
    const val bodyMediumLineHeight: Double = 20.0
    const val bodyMediumTracking: Double = 0.25

    const val bodySmallSize: Double = 12.0
    const val bodySmallLineHeight: Double = 16.0
    const val bodySmallTracking: Double = 0.4

    // --- LABEL (Botões, chips, badges, legendas) ---
    const val labelLargeSize: Double = 14.0
    const val labelLargeLineHeight: Double = 20.0
    const val labelLargeTracking: Double = 0.1

    const val labelMediumSize: Double = 12.0
    const val labelMediumLineHeight: Double = 16.0
    const val labelMediumTracking: Double = 0.5

    const val labelSmallSize: Double = 11.0
    const val labelSmallLineHeight: Double = 16.0
    const val labelSmallTracking: Double = 0.5
}
