package br.com.wgc.design_system.core

import br.com.wgc.design_system.constants.CoreConstants

/**
 * Tokens de Opacidade e Transparência Semântica do Design System WGC.
 * Define constantes numéricas de alfa para estados de interação e superfícies.
 */
object WgcCoreDsOpacity {
    /** 100% visibilidade */
    const val opaque: Float   = CoreConstants.CoreDsOpacity.OPAQUE

    /** 87% visibilidade - texto ou superfície secundária de alto contraste */
    const val surfaceDim: Float   = CoreConstants.CoreDsOpacity.SURFACE_DIM

    /** 60% visibilidade - máscaras de scrim / backdrops de bottom sheet e diálogos */
    const val scrim: Float   = CoreConstants.CoreDsOpacity.SCRIM

    /** 38% visibilidade - componentes, botões e textos desabilitados */
    const val disabled: Float   = CoreConstants.CoreDsOpacity.DISABLED

    /** 16% visibilidade - estado de arrasto (dragged) */
    const val dragged: Float   = CoreConstants.CoreDsOpacity.DRAGGED

    /** 12% visibilidade - estado pressionado (pressed) ou com foco (focused) */
    const val pressed: Float   = CoreConstants.CoreDsOpacity.PRESSED
    const val focus: Float   = CoreConstants.CoreDsOpacity.FOCUS

    /** 8% visibilidade - estado de hover do cursor */
    const val hover: Float   = CoreConstants.CoreDsOpacity.HOVER

    /** 4% visibilidade - tint suave de superfície */
    const val subtle: Float   = CoreConstants.CoreDsOpacity.SUBTLE

    /** 0% visibilidade - transparente */
    const val transparent: Float   = CoreConstants.CoreDsOpacity.TRANSPARENT
}
