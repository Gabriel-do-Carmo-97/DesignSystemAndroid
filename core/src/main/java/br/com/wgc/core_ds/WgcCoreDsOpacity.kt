package br.com.wgc.core_ds

/**
 * Tokens de Opacidade e Transparência Semântica do Design System WGC.
 * Define constantes numéricas de alfa para estados de interação e superfícies.
 */
object WgcCoreDsOpacity {
    /** 100% visibilidade */
    const val opaque: Float = 1.0f

    /** 87% visibilidade - texto ou superfície secundária de alto contraste */
    const val surfaceDim: Float = 0.87f

    /** 60% visibilidade - máscaras de scrim / backdrops de bottom sheet e diálogos */
    const val scrim: Float = 0.60f

    /** 38% visibilidade - componentes, botões e textos desabilitados */
    const val disabled: Float = 0.38f

    /** 16% visibilidade - estado de arrasto (dragged) */
    const val dragged: Float = 0.16f

    /** 12% visibilidade - estado pressionado (pressed) ou com foco (focused) */
    const val pressed: Float = 0.12f
    const val focus: Float = 0.12f

    /** 8% visibilidade - estado de hover do cursor */
    const val hover: Float = 0.08f

    /** 4% visibilidade - tint suave de superfície */
    const val subtle: Float = 0.04f

    /** 0% visibilidade - transparente */
    const val transparent: Float = 0.0f
}
