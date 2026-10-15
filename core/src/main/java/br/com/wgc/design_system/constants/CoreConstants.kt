package br.com.wgc.design_system.constants

/** Central source for compile-time constants owned by the core module. */
object CoreConstants {
    /**
     * Nomes padronizados para eventos de analytics e suas propriedades.
     * Use-os ao registrar eventos em plataformas como Mixpanel, Amplitude ou GA4
     * para manter a telemetria consistente entre telas, componentes e fluxos.
     */
    object AnalyticsSchema {
        /** Evento emitido quando uma tela é visualizada. */
        const val EVENT_SCREEN_VIEW = "wgc_screen_view"
        /** Evento emitido quando um componente é acionado. */
        const val EVENT_COMPONENT_CLICK = "wgc_component_click"
        /** Evento emitido ao iniciar um fluxo. */
        const val EVENT_FLOW_STARTED = "wgc_flow_started"
        /** Evento emitido ao concluir um fluxo. */
        const val EVENT_FLOW_COMPLETED = "wgc_flow_completed"
        /** Evento emitido quando um erro é apresentado. */
        const val EVENT_ERROR_DISPLAYED = "wgc_error_displayed"
        /** Propriedade que identifica a tela associada ao evento. */
        const val PARAM_SCREEN_NAME = "screen_name"
        /** Propriedade que identifica o componente associado ao evento. */
        const val PARAM_COMPONENT_ID = "component_id"
        /** Propriedade que identifica o fluxo associado ao evento. */
        const val PARAM_FLOW_NAME = "flow_name"
        /** Propriedade que identifica o código do erro apresentado. */
        const val PARAM_ERROR_CODE = "error_code"
        /** Propriedade que identifica o tenant associado ao evento. */
        const val PARAM_TENANT = "tenant"
    }

    /**
     * Raios numéricos para efeitos de Glassmorphism e Backdrop Blur.
     * Use o nível apropriado ao aplicar desfoque em fundos e superfícies.
     */
    object BlurTokens {
        /** Sem desfoque. */
        const val NONE = 0.0
        /** Desfoque extra pequeno. */
        const val BLUR_SM = 4.0
        /** Desfoque médio. */
        const val BLUR_MD = 12.0
        /** Desfoque grande. */
        const val BLUR_LG = 24.0
        /** Desfoque extra grande. */
        const val BLUR_XL = 40.0
    }

    object ContrastCalculator {
        const val WCAG_AA_NORMAL_TEXT_MIN_RATIO = 4.5
        const val WCAG_AA_LARGE_TEXT_MIN_RATIO = 3.0
        const val WCAG_AAA_NORMAL_TEXT_MIN_RATIO = 7.0
        const val WCAG_AAA_LARGE_TEXT_MIN_RATIO = 4.5
        const val COLOR_WHITE = 0xFFFFFFFF.toInt()
        const val COLOR_BLACK = 0xFF000000.toInt()
    }

    object CoreDsBorderRadius {
        const val NONE0 = 0.0
        const val XS2 = 2.0
        const val SM4 = 4.0
        const val MD8 = 8.0
        const val LG12 = 12.0
        const val XL16 = 16.0
        const val SL18 = 18.0
        const val XXL24 = 24.0
        const val DISPLAY45 = 45.0
        const val CIRCULAR999 = 999.0
        const val NONE = NONE0
        const val XS = XS2
        const val SM = SM4
        const val MD = MD8
        const val LG = LG12
        const val XL = XL16
        const val SL = SL18
        const val XXL = XXL24
        const val CIRCULAR = CIRCULAR999
        const val PILL = CIRCULAR999
    }

    object CoreDsBreakpoints {
        const val COMPACT_MAX: Double = 599.0
        const val MEDIUM_MIN: Double = 600.0
        const val MEDIUM_MAX: Double = 839.0
        const val EXPANDED_MIN: Double = 840.0
    }

    object CoreDsDirectional {
        const val DIRECTION_LTR = "LTR"
        const val DIRECTION_RTL = "RTL"
    }

    object CoreDsElevation {
        const val LEVEL0 = 0.0
        const val LEVEL1 = 1.0
        const val LEVEL2 = 2.0
        const val LEVEL3 = 3.0
        const val LEVEL6 = 6.0
        const val LEVEL8 = 8.0
        const val LEVEL12 = 12.0
        const val CARD_FLAT = LEVEL0
        const val CARD_DEFAULT = LEVEL1
        const val NAVIGATION_BAR = LEVEL2
        const val BUTTON_RAISED = LEVEL3
        const val DROPDOWN_MENU = LEVEL6
        const val MODAL_BOTTOM_SHEET = LEVEL8
        const val DIALOG = LEVEL8
        const val FLOATING_DRAWER = LEVEL12
        const val AMBIENT_SHADOW_ALPHA_LIGHT = 0.06f
        const val SPOT_SHADOW_ALPHA_LIGHT = 0.12f
        const val AMBIENT_SHADOW_ALPHA_DARK = 0.15f
        const val SPOT_SHADOW_ALPHA_DARK = 0.30f
    }

    object CoreDsHaptics {
        const val PATTERN_LIGHT_CLICK = "LIGHT_CLICK"
        const val PATTERN_MEDIUM_CONFIRM = "MEDIUM_CONFIRM"
        const val PATTERN_HEAVY_SUCCESS = "HEAVY_SUCCESS"
        const val PATTERN_WARNING_ALERT = "WARNING_ALERT"
        const val PATTERN_ERROR_REJECT = "ERROR_REJECT"
        const val DURATION_MICRO_MS = 15L
        const val DURATION_STANDARD_MS = 40L
        const val DURATION_LONG_MS = 80L
    }

    object CoreDsMotion {
        const val DURATION_FAST100 = 100
        const val DURATION_SHORT150 = 150
        const val DURATION_NORMAL200 = 200
        const val DURATION_SHORT200 = DURATION_NORMAL200
        const val DURATION_STANDARD300 = 300
        const val DURATION_SLOW500 = 500
        const val DURATION_EXTRA_SLOW700 = 700
        const val SPRING_DAMPING_NO_BOUNCY = 1.0f
        const val SPRING_DAMPING_MEDIUM_BOUNCY = 0.75f
        const val SPRING_DAMPING_HIGH_BOUNCY = 0.5f
        const val SPRING_STIFFNESS_LOW = 50.0f
        const val SPRING_STIFFNESS_MEDIUM = 300.0f
        const val SPRING_STIFFNESS_HIGH = 800.0f
    }

    /**
     * Opacidade e transparência semântica do Design System WGC.
     * Os valores representam alfa de 0 (transparente) a 1 (opaco); use-os
     * em superfícies e estados de interação para manter a hierarquia visual.
     */
    object CoreDsOpacity {
        /** Visibilidade total. */
        const val OPAQUE: Float = 1.0f
        /** Superfície ou texto secundário com visibilidade ligeiramente reduzida. */
        const val SURFACE_DIM: Float = 0.87f
        /** Máscara de fundo para scrims, diálogos e bottom sheets. */
        const val SCRIM: Float = 0.60f
        /** Estado de componentes e textos desabilitados. */
        const val DISABLED: Float = 0.38f
        /** Estado de um elemento sendo arrastado. */
        const val DRAGGED: Float = 0.16f
        /** Estado de um elemento pressionado. */
        const val PRESSED: Float = 0.12f
        /** Estado de foco. */
        const val FOCUS: Float = 0.12f
        /** Estado de hover, normalmente em interfaces com cursor. */
        const val HOVER: Float = 0.08f
        /** Tint sutil aplicado a uma superfície. */
        const val SUBTLE: Float = 0.04f
        /** Transparência total. */
        const val TRANSPARENT: Float = 0.0f
    }

    object CoreDsSize {
        const val S0 = 0.0
        const val S1 = 1.0
        const val S2 = 2.0
        const val S4 = 4.0
        const val S6 = 6.0
        const val S8 = 8.0
        const val S10 = 10.0
        const val S12 = 12.0
        const val S14 = 14.0
        const val S16 = 16.0
        const val S18 = 18.0
        const val S20 = 20.0
        const val S22 = 22.0
        const val S24 = 24.0
        const val S26 = 26.0
        const val S28 = 28.0
        const val S30 = 30.0
        const val S32 = 32.0
        const val S34 = 34.0
        const val S36 = 36.0
        const val S38 = 38.0
        const val S40 = 40.0
        const val S42 = 42.0
        const val S44 = 44.0
        const val S46 = 46.0
        const val S48 = 48.0
        const val S50 = 50.0
        const val S52 = 52.0
        const val S54 = 54.0
        const val S56 = 56.0
        const val S58 = 58.0
        const val S60 = 60.0
        const val S62 = 62.0
        const val S64 = 64.0
        const val S66 = 66.0
        const val S68 = 68.0
        const val S70 = 70.0
        const val S72 = 72.0
        const val S74 = 74.0
        const val S76 = 76.0
        const val S78 = 78.0
        const val S80 = 80.0
        const val S82 = 82.0
        const val S84 = 84.0
        const val S86 = 86.0
        const val S88 = 88.0
        const val S90 = 90.0
        const val S92 = 92.0
        const val S94 = 94.0
        const val S96 = 96.0
        const val S98 = 98.0
        const val S100 = 100.0
        const val S120 = 120.0
        const val S140 = 140.0
        const val S160 = 160.0
        const val S180 = 180.0
        const val S200 = 200.0
        const val S240 = 240.0
        const val S280 = 280.0
        const val S300 = 300.0
        const val S360 = 360.0
        const val S400 = 400.0
    }

    object CoreDsSpacing {
        const val NONE0 = 0.0
        const val XXXS2 = 2.0
        const val XXS4 = 4.0
        const val XS8 = 8.0
        const val SM12 = 12.0
        const val MD16 = 16.0
        const val LG24 = 24.0
        const val XL32 = 32.0
        const val XXL40 = 40.0
        const val XXXL48 = 48.0
        const val DISPLAY64 = 64.0
        const val GIANT80 = 80.0
        const val NONE = NONE0
        const val XXXS = XXXS2
        const val XXS = XXS4
        const val XS = XS8
        const val SM = SM12
        const val SM8 = XS8
        const val XS6 = XXS4
        const val MD = MD16
        const val LG = LG24
        const val XL = XL32
        const val XXL = XXL40
        const val XXXL = XXXL48
    }

    object CoreDsTypography {
        const val WEIGHT_BOLD = 700
        const val WEIGHT_SEMI_BOLD = 600
        const val WEIGHT_MEDIUM = 500
        const val WEIGHT_NORMAL = 400
        const val WEIGHT_LIGHT = 300
        const val DISPLAY_LARGE_SIZE: Double = 57.0
        const val DISPLAY_LARGE_LINE_HEIGHT: Double = 64.0
        const val DISPLAY_LARGE_TRACKING: Double = -0.25
        const val DISPLAY_MEDIUM_SIZE: Double = 45.0
        const val DISPLAY_MEDIUM_LINE_HEIGHT: Double = 52.0
        const val DISPLAY_MEDIUM_TRACKING: Double = 0.0
        const val DISPLAY_SMALL_SIZE: Double = 36.0
        const val DISPLAY_SMALL_LINE_HEIGHT: Double = 44.0
        const val DISPLAY_SMALL_TRACKING: Double = 0.0
        const val HEADLINE_LARGE_SIZE: Double = 32.0
        const val HEADLINE_LARGE_LINE_HEIGHT: Double = 40.0
        const val HEADLINE_LARGE_TRACKING: Double = 0.0
        const val HEADLINE_MEDIUM_SIZE: Double = 28.0
        const val HEADLINE_MEDIUM_LINE_HEIGHT: Double = 36.0
        const val HEADLINE_MEDIUM_TRACKING: Double = 0.0
        const val HEADLINE_SMALL_SIZE: Double = 24.0
        const val HEADLINE_SMALL_LINE_HEIGHT: Double = 32.0
        const val HEADLINE_SMALL_TRACKING: Double = 0.0
        const val TITLE_LARGE_SIZE: Double = 22.0
        const val TITLE_LARGE_LINE_HEIGHT: Double = 28.0
        const val TITLE_LARGE_TRACKING: Double = 0.0
        const val TITLE_MEDIUM_SIZE: Double = 16.0
        const val TITLE_MEDIUM_LINE_HEIGHT: Double = 24.0
        const val TITLE_MEDIUM_TRACKING: Double = 0.15
        const val TITLE_SMALL_SIZE: Double = 14.0
        const val TITLE_SMALL_LINE_HEIGHT: Double = 20.0
        const val TITLE_SMALL_TRACKING: Double = 0.1
        const val BODY_LARGE_SIZE: Double = 16.0
        const val BODY_LARGE_LINE_HEIGHT: Double = 24.0
        const val BODY_LARGE_TRACKING: Double = 0.5
        const val BODY_MEDIUM_SIZE: Double = 14.0
        const val BODY_MEDIUM_LINE_HEIGHT: Double = 20.0
        const val BODY_MEDIUM_TRACKING: Double = 0.25
        const val BODY_SMALL_SIZE: Double = 12.0
        const val BODY_SMALL_LINE_HEIGHT: Double = 16.0
        const val BODY_SMALL_TRACKING: Double = 0.4
        const val LABEL_LARGE_SIZE: Double = 14.0
        const val LABEL_LARGE_LINE_HEIGHT: Double = 20.0
        const val LABEL_LARGE_TRACKING: Double = 0.1
        const val LABEL_MEDIUM_SIZE: Double = 12.0
        const val LABEL_MEDIUM_LINE_HEIGHT: Double = 16.0
        const val LABEL_MEDIUM_TRACKING: Double = 0.5
        const val LABEL_SMALL_SIZE: Double = 11.0
        const val LABEL_SMALL_LINE_HEIGHT: Double = 16.0
        const val LABEL_SMALL_TRACKING: Double = 0.5
        const val FONT_SCALE_STANDARD: Float = 1.0f
        const val FONT_SCALE_MAX_ACCESSIBLE: Float = 2.0f
        const val MIN_TOUCH_TARGET_DP: Double = 48.0
    }

    object FluidTypography {
        const val DEFAULT_MIN_VIEWPORT_WIDTH_DP = 360.0f
        const val DEFAULT_MAX_VIEWPORT_WIDTH_DP = 840.0f
    }

    object HighContrastPaletteTokens {
        const val BACKGROUND_DARK_ARGB: Int = 0xFF000000.toInt()
        const val BACKGROUND_LIGHT_ARGB: Int = 0xFFFFFFFF.toInt()
        const val TEXT_ON_DARK_ARGB: Int = 0xFFFFFFFF.toInt()
        const val TEXT_ON_LIGHT_ARGB: Int = 0xFF000000.toInt()
        const val PRIMARY_HIGH_CONTRAST_YELLOW_ARGB: Int = 0xFFFFD700.toInt()
        const val PRIMARY_HIGH_CONTRAST_CYAN_ARGB: Int = 0xFF00E5FF.toInt()
        const val ERROR_HIGH_CONTRAST_ARGB: Int = 0xFFFF1744.toInt()
        const val SUCCESS_HIGH_CONTRAST_ARGB: Int = 0xFF00E676.toInt()
    }

    /**
     * Especificações visuais para renderização tipográfica de Markdown e rich text.
     * Use estes valores ao estilizar código inline, blocos de código e citações.
     */
    object MarkdownTypographyTokens {
        /** Família tipográfica monoespaçada usada em trechos e blocos de código. */
        const val CODE_FONT_FAMILY_MONOSPACE = "monospace"
        /** Cor de fundo ARGB dos blocos de código em tema escuro. */
        const val CODE_BLOCK_BACKGROUND_DARK_ARGB = 0xFF1E1E1E.toInt()
        /** Cor de fundo ARGB dos blocos de código em tema claro. */
        const val CODE_BLOCK_BACKGROUND_LIGHT_ARGB = 0xFFF5F5F5.toInt()
        /** Espaçamento horizontal interno do código inline, em dp. */
        const val INLINE_CODE_PADDING_HORIZONTAL_DP = 4f
        /** Raio dos cantos do código inline, em dp. */
        const val INLINE_CODE_RADIUS_DP = 4f
        /** Espessura da borda indicadora de uma citação, em dp. */
        const val BLOCKQUOTE_BORDER_WIDTH_DP = 3f
        /** Recuo inicial do conteúdo de uma citação, em dp. */
        const val BLOCKQUOTE_PADDING_START_DP = 12f
    }

    object MotionChoreography {
        const val STAGGER_DELAY_FAST = 40
        const val STAGGER_DELAY_NORMAL = 75
        const val STAGGER_DELAY_SLOW = 120
        const val CASCADE_DURATION_SHORT = 200
        const val CASCADE_DURATION_MEDIUM = 350
        const val CASCADE_DURATION_LONG = 500
        const val EASE_IN_OUT_CUBIC = "cubic-bezier(0.65, 0, 0.35, 1)"
        const val EASE_OUT_QUAD = "cubic-bezier(0.25, 0.46, 0.45, 0.94)"
    }

    /**
     * Dimensões do grid responsivo por classe de largura de tela.
     * Use o conjunto correspondente ao breakpoint para definir colunas,
     * espaçamento entre elas (gutter) e margens externas.
     */
    object ResponsiveGridTokens {
        /** Quantidade de colunas para smartphones e telas compactas (abaixo de 600 dp). */
        const val COLUMNS_COMPACT = 4
        /** Espaçamento entre colunas em telas compactas, em dp. */
        const val GUTTER_COMPACT_DP = 16f
        /** Margem externa em telas compactas, em dp. */
        const val MARGIN_COMPACT_DP = 16f
        /** Quantidade de colunas para tablets e telas médias (600 a 839 dp). */
        const val COLUMNS_MEDIUM = 8
        /** Espaçamento entre colunas em telas médias, em dp. */
        const val GUTTER_MEDIUM_DP = 24f
        /** Margem externa em telas médias, em dp. */
        const val MARGIN_MEDIUM_DP = 32f
        /** Quantidade de colunas para telas expandidas (a partir de 840 dp). */
        const val COLUMNS_EXPANDED = 12
        /** Espaçamento entre colunas em telas expandidas, em dp. */
        const val GUTTER_EXPANDED_DP = 24f
        /** Margem externa em telas expandidas, em dp. */
        const val MARGIN_EXPANDED_DP = 48f
    }

    /**
     * Dimensões e fatores para geometrias de formas avançadas.
     * Use-os para construir cantos chanfrados, curvas suaves (squircles)
     * e formas de pílula de maneira consistente.
     */
    object ShapeMorphologyTokens {
        /** Tamanho do chanfro pequeno em cantos cortados, em dp. */
        const val CUT_CORNER_SMALL_DP = 4f
        /** Tamanho do chanfro médio em cantos cortados, em dp. */
        const val CUT_CORNER_MEDIUM_DP = 8f
        /** Tamanho do chanfro grande em cantos cortados, em dp. */
        const val CUT_CORNER_LARGE_DP = 16f
        /** Fator de suavização da curvatura de cantos do tipo squircle. */
        const val SQUIRCLE_CORNER_SMOOTHING = 0.6f
        /** Raio amplo para formas circulares e de pílula, em dp. */
        const val PILL_RADIUS_DP = 999f
    }

    /**
     * Identificadores semânticos de efeitos sonoros (Sound FX) do Design System.
     * Use-os para selecionar o efeito correspondente ao feedback de interação.
     */
    object SoundFxTokens {
        /** Feedback sonoro leve para toque. */
        const val SOUND_TAP_LIGHT = "wgc_sfx_tap_light"
        /** Feedback sonoro mais marcado para toque. */
        const val SOUND_TAP_MEDIUM = "wgc_sfx_tap_medium"
        /** Confirmação sonora de uma ação bem-sucedida. */
        const val SOUND_SUCCESS_CONFIRM = "wgc_sfx_success_confirm"
        /** Alerta sonoro associado a uma falha ou erro. */
        const val SOUND_ERROR_ALERT = "wgc_sfx_error_alert"
        /** Efeito emitido ao soltar a ação de atualizar por gesto. */
        const val SOUND_PULL_REFRESH_RELEASE = "wgc_sfx_refresh_release"
        /** Notificação sonora de uma nova badge ou indicador. */
        const val SOUND_BADGE_NOTIFICATION = "wgc_sfx_badge_notify"
    }

}
