package br.com.wgc.design_system.core.tokens

import br.com.wgc.design_system.constants.CoreConstants

/**
 * Escala de espaçamentos e aliases ergonômicos usados nos layouts WGC.
 *
 * Exemplo: `val sectionGapDp = WgcCoreDsSpacing.LG24`.
 * Quando usar: escolha esta API quando escolher distâncias de layout da escala corporativa.
 */
object WgcCoreDsSpacing {
    /** 0px */
    const val NONE0 = CoreConstants.CoreDsSpacing.NONE0

    /** 2px */
    const val XXXS2 = CoreConstants.CoreDsSpacing.XXXS2

    /** 4px */
    const val XXS4 = CoreConstants.CoreDsSpacing.XXS4

    /** 8px */
    const val XS8 = CoreConstants.CoreDsSpacing.XS8

    /** 12px */
    const val SM12 = CoreConstants.CoreDsSpacing.SM12

    /** 16px */
    const val MD16 = CoreConstants.CoreDsSpacing.MD16

    /** 24px */
    const val LG24 = CoreConstants.CoreDsSpacing.LG24

    /** 32px */
    const val XL32 = CoreConstants.CoreDsSpacing.XL32

    /** 40px */
    const val XXL40 = CoreConstants.CoreDsSpacing.XXL40

    /** 48px */
    const val XXXL48 = CoreConstants.CoreDsSpacing.XXXL48

    /** 64px */
    const val DISPLAY64 = CoreConstants.CoreDsSpacing.DISPLAY64

    /** 80px */
    const val GIANT80 = CoreConstants.CoreDsSpacing.GIANT80

    // Ergonomic standard aliases
    const val NONE = CoreConstants.CoreDsSpacing.NONE
    const val XXXS = CoreConstants.CoreDsSpacing.XXXS
    const val XXS = CoreConstants.CoreDsSpacing.XXS
    const val XS = CoreConstants.CoreDsSpacing.XS
    const val SM = CoreConstants.CoreDsSpacing.SM
    const val SM8 = CoreConstants.CoreDsSpacing.SM8
    const val XS6 = CoreConstants.CoreDsSpacing.XS6
    const val MD = CoreConstants.CoreDsSpacing.MD
    const val LG = CoreConstants.CoreDsSpacing.LG
    const val XL = CoreConstants.CoreDsSpacing.XL
    const val XXL = CoreConstants.CoreDsSpacing.XXL
    const val XXXL = CoreConstants.CoreDsSpacing.XXXL
}
