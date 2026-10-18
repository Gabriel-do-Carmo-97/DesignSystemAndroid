package br.com.wgc.design_system.core.tokens

import br.com.wgc.design_system.constants.CoreConstants

/**
 * Escala de raios de borda oficiais para superfícies, controles e formas arredondadas.
 *
 * Exemplo: `val radius = WgcCoreDsBorderRadius.MD8`.
 * Quando usar: escolha esta API quando escolher raios oficiais de borda para elementos visuais.
 */
object WgcCoreDsBorderRadius {
    const val NONE0 = CoreConstants.CoreDsBorderRadius.NONE0

    /** 2px */
    const val XS2 = CoreConstants.CoreDsBorderRadius.XS2

    /** 4px */
    const val SM4 = CoreConstants.CoreDsBorderRadius.SM4

    /** 8px */
    const val MD8 = CoreConstants.CoreDsBorderRadius.MD8

    /** 12px */
    const val LG12 = CoreConstants.CoreDsBorderRadius.LG12

    /** 16px */
    const val XL16 = CoreConstants.CoreDsBorderRadius.XL16

    /** 18px */
    const val SL18 = CoreConstants.CoreDsBorderRadius.SL18

    /** 24px */
    const val XXL24 = CoreConstants.CoreDsBorderRadius.XXL24

    /** 45px */
    const val DISPLAY45 = CoreConstants.CoreDsBorderRadius.DISPLAY45

    /** 999px */
    const val CIRCULAR999 = CoreConstants.CoreDsBorderRadius.CIRCULAR999

    // Ergonomic standard aliases
    const val NONE = CoreConstants.CoreDsBorderRadius.NONE
    const val XS = CoreConstants.CoreDsBorderRadius.XS
    const val SM = CoreConstants.CoreDsBorderRadius.SM
    const val MD = CoreConstants.CoreDsBorderRadius.MD
    const val LG = CoreConstants.CoreDsBorderRadius.LG
    const val XL = CoreConstants.CoreDsBorderRadius.XL
    const val SL = CoreConstants.CoreDsBorderRadius.SL
    const val XXL = CoreConstants.CoreDsBorderRadius.XXL
    const val CIRCULAR = CoreConstants.CoreDsBorderRadius.CIRCULAR
    const val PILL = CoreConstants.CoreDsBorderRadius.PILL

    const val none0 = NONE0
    const val xs2 = XS2
    const val sm4 = SM4
    const val md8 = MD8
    const val lg12 = LG12
    const val xl16 = XL16
    const val sl18 = SL18
    const val xxl24 = XXL24
    const val display45 = DISPLAY45
    const val circular999 = CIRCULAR999
    const val xs = XS
    const val sm = SM
    const val md = MD
    const val lg = LG
    const val xl = XL
    const val xxl = XXL
    const val circular = CIRCULAR
}
