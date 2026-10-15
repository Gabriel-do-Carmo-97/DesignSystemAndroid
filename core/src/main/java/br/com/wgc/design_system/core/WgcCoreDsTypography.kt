package br.com.wgc.design_system.core

import br.com.wgc.design_system.constants.CoreConstants

/**
 * Tokens de Tipografia Oficial do Design System WGC.
 * Padroniza escalas de display, headline, title, body e label para garantir hierarquia consistente.
 * Valores definidos em pontos/sp primitivos para máxima portabilidade.
 */
object WgcCoreDsTypography {
    // --- PESOS DE FONTE (FONT WEIGHTS) ---
    const val weightBold = CoreConstants.CoreDsTypography.WEIGHT_BOLD
    const val weightSemiBold = CoreConstants.CoreDsTypography.WEIGHT_SEMI_BOLD
    const val weightMedium = CoreConstants.CoreDsTypography.WEIGHT_MEDIUM
    const val weightNormal = CoreConstants.CoreDsTypography.WEIGHT_NORMAL
    const val weightLight = CoreConstants.CoreDsTypography.WEIGHT_LIGHT

    // --- DISPLAY (Telas de impacto, splash, números grandes) ---
    const val displayLargeSize: Double   = CoreConstants.CoreDsTypography.DISPLAY_LARGE_SIZE
    const val displayLargeLineHeight: Double   = CoreConstants.CoreDsTypography.DISPLAY_LARGE_LINE_HEIGHT
    const val displayLargeTracking: Double   = CoreConstants.CoreDsTypography.DISPLAY_LARGE_TRACKING

    const val displayMediumSize: Double   = CoreConstants.CoreDsTypography.DISPLAY_MEDIUM_SIZE
    const val displayMediumLineHeight: Double   = CoreConstants.CoreDsTypography.DISPLAY_MEDIUM_LINE_HEIGHT
    const val displayMediumTracking: Double   = CoreConstants.CoreDsTypography.DISPLAY_MEDIUM_TRACKING

    const val displaySmallSize: Double   = CoreConstants.CoreDsTypography.DISPLAY_SMALL_SIZE
    const val displaySmallLineHeight: Double   = CoreConstants.CoreDsTypography.DISPLAY_SMALL_LINE_HEIGHT
    const val displaySmallTracking: Double   = CoreConstants.CoreDsTypography.DISPLAY_SMALL_TRACKING

    // --- HEADLINE (Títulos de seções principais, cabeçalhos de tela) ---
    const val headlineLargeSize: Double   = CoreConstants.CoreDsTypography.HEADLINE_LARGE_SIZE
    const val headlineLargeLineHeight: Double   = CoreConstants.CoreDsTypography.HEADLINE_LARGE_LINE_HEIGHT
    const val headlineLargeTracking: Double   = CoreConstants.CoreDsTypography.HEADLINE_LARGE_TRACKING

    const val headlineMediumSize: Double   = CoreConstants.CoreDsTypography.HEADLINE_MEDIUM_SIZE
    const val headlineMediumLineHeight: Double   = CoreConstants.CoreDsTypography.HEADLINE_MEDIUM_LINE_HEIGHT
    const val headlineMediumTracking: Double   = CoreConstants.CoreDsTypography.HEADLINE_MEDIUM_TRACKING

    const val headlineSmallSize: Double   = CoreConstants.CoreDsTypography.HEADLINE_SMALL_SIZE
    const val headlineSmallLineHeight: Double   = CoreConstants.CoreDsTypography.HEADLINE_SMALL_LINE_HEIGHT
    const val headlineSmallTracking: Double   = CoreConstants.CoreDsTypography.HEADLINE_SMALL_TRACKING

    // --- TITLE (Títulos de cards, diálogos, itens de lista destacados) ---
    const val titleLargeSize: Double   = CoreConstants.CoreDsTypography.TITLE_LARGE_SIZE
    const val titleLargeLineHeight: Double   = CoreConstants.CoreDsTypography.TITLE_LARGE_LINE_HEIGHT
    const val titleLargeTracking: Double   = CoreConstants.CoreDsTypography.TITLE_LARGE_TRACKING

    const val titleMediumSize: Double   = CoreConstants.CoreDsTypography.TITLE_MEDIUM_SIZE
    const val titleMediumLineHeight: Double   = CoreConstants.CoreDsTypography.TITLE_MEDIUM_LINE_HEIGHT
    const val titleMediumTracking: Double   = CoreConstants.CoreDsTypography.TITLE_MEDIUM_TRACKING

    const val titleSmallSize: Double   = CoreConstants.CoreDsTypography.TITLE_SMALL_SIZE
    const val titleSmallLineHeight: Double   = CoreConstants.CoreDsTypography.TITLE_SMALL_LINE_HEIGHT
    const val titleSmallTracking: Double   = CoreConstants.CoreDsTypography.TITLE_SMALL_TRACKING

    // --- BODY (Textos corridos, descrições, parágrafos) ---
    const val bodyLargeSize: Double   = CoreConstants.CoreDsTypography.BODY_LARGE_SIZE
    const val bodyLargeLineHeight: Double   = CoreConstants.CoreDsTypography.BODY_LARGE_LINE_HEIGHT
    const val bodyLargeTracking: Double   = CoreConstants.CoreDsTypography.BODY_LARGE_TRACKING

    const val bodyMediumSize: Double   = CoreConstants.CoreDsTypography.BODY_MEDIUM_SIZE
    const val bodyMediumLineHeight: Double   = CoreConstants.CoreDsTypography.BODY_MEDIUM_LINE_HEIGHT
    const val bodyMediumTracking: Double   = CoreConstants.CoreDsTypography.BODY_MEDIUM_TRACKING

    const val bodySmallSize: Double   = CoreConstants.CoreDsTypography.BODY_SMALL_SIZE
    const val bodySmallLineHeight: Double   = CoreConstants.CoreDsTypography.BODY_SMALL_LINE_HEIGHT
    const val bodySmallTracking: Double   = CoreConstants.CoreDsTypography.BODY_SMALL_TRACKING

    // --- LABEL (Botões, chips, badges, legendas) ---
    const val labelLargeSize: Double   = CoreConstants.CoreDsTypography.LABEL_LARGE_SIZE
    const val labelLargeLineHeight: Double   = CoreConstants.CoreDsTypography.LABEL_LARGE_LINE_HEIGHT
    const val labelLargeTracking: Double   = CoreConstants.CoreDsTypography.LABEL_LARGE_TRACKING

    const val labelMediumSize: Double   = CoreConstants.CoreDsTypography.LABEL_MEDIUM_SIZE
    const val labelMediumLineHeight: Double   = CoreConstants.CoreDsTypography.LABEL_MEDIUM_LINE_HEIGHT
    const val labelMediumTracking: Double   = CoreConstants.CoreDsTypography.LABEL_MEDIUM_TRACKING

    const val labelSmallSize: Double   = CoreConstants.CoreDsTypography.LABEL_SMALL_SIZE
    const val labelSmallLineHeight: Double   = CoreConstants.CoreDsTypography.LABEL_SMALL_LINE_HEIGHT
    const val labelSmallTracking: Double   = CoreConstants.CoreDsTypography.LABEL_SMALL_TRACKING

    // --- DIRETRIZES DE ACESSIBILIDADE E FONT SCALING ---
    /** Escala padrão do sistema (100%) */
    const val fontScaleStandard: Float   = CoreConstants.CoreDsTypography.FONT_SCALE_STANDARD

    /** Escala máxima recomendada pela WCAG / Android Accessibility antes de acionar quebra de layout responsivo (200%) */
    const val fontScaleMaxAccessible: Float   = CoreConstants.CoreDsTypography.FONT_SCALE_MAX_ACCESSIBLE

    /** Dimensão mínima de alvo de toque recomendada pela WCAG 2.1 AA (48dp) */
    const val minTouchTargetDp: Double   = CoreConstants.CoreDsTypography.MIN_TOUCH_TARGET_DP
}
