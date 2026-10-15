package br.com.wgc.design_system.core.tokens

import br.com.wgc.design_system.constants.CoreConstants

/**
 * Tokens de Tipografia Oficial do Design System WGC.
 * Padroniza escalas de display, headline, title, body e label para garantir hierarquia consistente.
 * Valores definidos em pontos/sp primitivos para máxima portabilidade.
 * Exemplo: `val titleSizeSp = WgcCoreDsTypography.TITLE_MEDIUM_SIZE`.
 * Quando usar: escolha esta API quando consultar dimensões e pesos da escala tipográfica oficial.
 */
object WgcCoreDsTypography {
    // --- PESOS DE FONTE (FONT WEIGHTS) ---
    const val WEIGHT_BOLD = CoreConstants.CoreDsTypography.WEIGHT_BOLD
    const val WEIGHT_SEMI_BOLD = CoreConstants.CoreDsTypography.WEIGHT_SEMI_BOLD
    const val WEIGHT_MEDIUM = CoreConstants.CoreDsTypography.WEIGHT_MEDIUM
    const val WEIGHT_NORMAL = CoreConstants.CoreDsTypography.WEIGHT_NORMAL
    const val WEIGHT_LIGHT = CoreConstants.CoreDsTypography.WEIGHT_LIGHT

    // --- DISPLAY (Telas de impacto, splash, números grandes) ---
    const val DISPLAY_LARGE_SIZE: Double   = CoreConstants.CoreDsTypography.DISPLAY_LARGE_SIZE
    const val DISPLAY_LARGE_LINE_HEIGHT: Double   = CoreConstants.CoreDsTypography.DISPLAY_LARGE_LINE_HEIGHT
    const val DISPLAY_LARGE_TRACKING: Double   = CoreConstants.CoreDsTypography.DISPLAY_LARGE_TRACKING

    const val DISPLAY_MEDIUM_SIZE: Double   = CoreConstants.CoreDsTypography.DISPLAY_MEDIUM_SIZE
    const val DISPLAY_MEDIUM_LINE_HEIGHT: Double   = CoreConstants.CoreDsTypography.DISPLAY_MEDIUM_LINE_HEIGHT
    const val DISPLAY_MEDIUM_TRACKING: Double   = CoreConstants.CoreDsTypography.DISPLAY_MEDIUM_TRACKING

    const val DISPLAY_SMALL_SIZE: Double   = CoreConstants.CoreDsTypography.DISPLAY_SMALL_SIZE
    const val DISPLAY_SMALL_LINE_HEIGHT: Double   = CoreConstants.CoreDsTypography.DISPLAY_SMALL_LINE_HEIGHT
    const val DISPLAY_SMALL_TRACKING: Double   = CoreConstants.CoreDsTypography.DISPLAY_SMALL_TRACKING

    // --- HEADLINE (Títulos de seções principais, cabeçalhos de tela) ---
    const val HEADLINE_LARGE_SIZE: Double   = CoreConstants.CoreDsTypography.HEADLINE_LARGE_SIZE
    const val HEADLINE_LARGE_LINE_HEIGHT: Double   = CoreConstants.CoreDsTypography.HEADLINE_LARGE_LINE_HEIGHT
    const val HEADLINE_LARGE_TRACKING: Double   = CoreConstants.CoreDsTypography.HEADLINE_LARGE_TRACKING

    const val HEADLINE_MEDIUM_SIZE: Double   = CoreConstants.CoreDsTypography.HEADLINE_MEDIUM_SIZE
    const val HEADLINE_MEDIUM_LINE_HEIGHT: Double   = CoreConstants.CoreDsTypography.HEADLINE_MEDIUM_LINE_HEIGHT
    const val HEADLINE_MEDIUM_TRACKING: Double   = CoreConstants.CoreDsTypography.HEADLINE_MEDIUM_TRACKING

    const val HEADLINE_SMALL_SIZE: Double   = CoreConstants.CoreDsTypography.HEADLINE_SMALL_SIZE
    const val HEADLINE_SMALL_LINE_HEIGHT: Double   = CoreConstants.CoreDsTypography.HEADLINE_SMALL_LINE_HEIGHT
    const val HEADLINE_SMALL_TRACKING: Double   = CoreConstants.CoreDsTypography.HEADLINE_SMALL_TRACKING

    // --- TITLE (Títulos de cards, diálogos, itens de lista destacados) ---
    const val TITLE_LARGE_SIZE: Double   = CoreConstants.CoreDsTypography.TITLE_LARGE_SIZE
    const val TITLE_LARGE_LINE_HEIGHT: Double   = CoreConstants.CoreDsTypography.TITLE_LARGE_LINE_HEIGHT
    const val TITLE_LARGE_TRACKING: Double   = CoreConstants.CoreDsTypography.TITLE_LARGE_TRACKING

    const val TITLE_MEDIUM_SIZE: Double   = CoreConstants.CoreDsTypography.TITLE_MEDIUM_SIZE
    const val TITLE_MEDIUM_LINE_HEIGHT: Double   = CoreConstants.CoreDsTypography.TITLE_MEDIUM_LINE_HEIGHT
    const val TITLE_MEDIUM_TRACKING: Double   = CoreConstants.CoreDsTypography.TITLE_MEDIUM_TRACKING

    const val TITLE_SMALL_SIZE: Double   = CoreConstants.CoreDsTypography.TITLE_SMALL_SIZE
    const val TITLE_SMALL_LINE_HEIGHT: Double   = CoreConstants.CoreDsTypography.TITLE_SMALL_LINE_HEIGHT
    const val TITLE_SMALL_TRACKING: Double   = CoreConstants.CoreDsTypography.TITLE_SMALL_TRACKING

    // --- BODY (Textos corridos, descrições, parágrafos) ---
    const val BODY_LARGE_SIZE: Double   = CoreConstants.CoreDsTypography.BODY_LARGE_SIZE
    const val BODY_LARGE_LINE_HEIGHT: Double   = CoreConstants.CoreDsTypography.BODY_LARGE_LINE_HEIGHT
    const val BODY_LARGE_TRACKING: Double   = CoreConstants.CoreDsTypography.BODY_LARGE_TRACKING

    const val BODY_MEDIUM_SIZE: Double   = CoreConstants.CoreDsTypography.BODY_MEDIUM_SIZE
    const val BODY_MEDIUM_LINE_HEIGHT: Double   = CoreConstants.CoreDsTypography.BODY_MEDIUM_LINE_HEIGHT
    const val BODY_MEDIUM_TRACKING: Double   = CoreConstants.CoreDsTypography.BODY_MEDIUM_TRACKING

    const val BODY_SMALL_SIZE: Double   = CoreConstants.CoreDsTypography.BODY_SMALL_SIZE
    const val BODY_SMALL_LINE_HEIGHT: Double   = CoreConstants.CoreDsTypography.BODY_SMALL_LINE_HEIGHT
    const val BODY_SMALL_TRACKING: Double   = CoreConstants.CoreDsTypography.BODY_SMALL_TRACKING

    // --- LABEL (Botões, chips, badges, legendas) ---
    const val LABEL_LARGE_SIZE: Double   = CoreConstants.CoreDsTypography.LABEL_LARGE_SIZE
    const val LABEL_LARGE_LINE_HEIGHT: Double   = CoreConstants.CoreDsTypography.LABEL_LARGE_LINE_HEIGHT
    const val LABEL_LARGE_TRACKING: Double   = CoreConstants.CoreDsTypography.LABEL_LARGE_TRACKING

    const val LABEL_MEDIUM_SIZE: Double   = CoreConstants.CoreDsTypography.LABEL_MEDIUM_SIZE
    const val LABEL_MEDIUM_LINE_HEIGHT: Double   = CoreConstants.CoreDsTypography.LABEL_MEDIUM_LINE_HEIGHT
    const val LABEL_MEDIUM_TRACKING: Double   = CoreConstants.CoreDsTypography.LABEL_MEDIUM_TRACKING

    const val LABEL_SMALL_SIZE: Double   = CoreConstants.CoreDsTypography.LABEL_SMALL_SIZE
    const val LABEL_SMALL_LINE_HEIGHT: Double   = CoreConstants.CoreDsTypography.LABEL_SMALL_LINE_HEIGHT
    const val LABEL_SMALL_TRACKING: Double   = CoreConstants.CoreDsTypography.LABEL_SMALL_TRACKING

    // --- DIRETRIZES DE ACESSIBILIDADE E FONT SCALING ---
    /** Escala padrão do sistema (100%) */
    const val FONT_SCALE_STANDARD: Float   = CoreConstants.CoreDsTypography.FONT_SCALE_STANDARD

    /** Escala máxima recomendada pela WCAG / Android Accessibility antes de acionar quebra de layout responsivo (200%) */
    const val FONT_SCALE_MAX_ACCESSIBLE: Float   = CoreConstants.CoreDsTypography.FONT_SCALE_MAX_ACCESSIBLE

    /** Dimensão mínima de alvo de toque recomendada pela WCAG 2.1 AA (48dp) */
    const val MIN_TOUCH_TARGET_DP: Double   = CoreConstants.CoreDsTypography.MIN_TOUCH_TARGET_DP
}
