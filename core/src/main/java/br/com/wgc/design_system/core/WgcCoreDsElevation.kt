package br.com.wgc.design_system.core

import br.com.wgc.design_system.constants.CoreConstants

object WgcCoreDsElevation {
    /** 0dp - Sem elevação */
    const val level0 = CoreConstants.CoreDsElevation.LEVEL0

    /** 1dp - Elevação sutil (cards) */
    const val level1 = CoreConstants.CoreDsElevation.LEVEL1

    /** 2dp - Elevação baixa (barras de navegação e abas) */
    const val level2 = CoreConstants.CoreDsElevation.LEVEL2

    /** 3dp - Elevação média (botões elevados) */
    const val level3 = CoreConstants.CoreDsElevation.LEVEL3

    /** 6dp - Elevação alta (menus suspensos) */
    const val level6 = CoreConstants.CoreDsElevation.LEVEL6

    /** 8dp - Elevação máxima (modais, diálogos) */
    const val level8 = CoreConstants.CoreDsElevation.LEVEL8

    /** 12dp - Elevação extrema (drawers, sheets flutuantes) */
    const val level12 = CoreConstants.CoreDsElevation.LEVEL12

    // --- ALIASES SEMÂNTICOS DE ELEVAÇÃO ---
    const val cardFlat = CoreConstants.CoreDsElevation.CARD_FLAT
    const val cardDefault = CoreConstants.CoreDsElevation.CARD_DEFAULT
    const val navigationBar = CoreConstants.CoreDsElevation.NAVIGATION_BAR
    const val buttonRaised = CoreConstants.CoreDsElevation.BUTTON_RAISED
    const val dropdownMenu = CoreConstants.CoreDsElevation.DROPDOWN_MENU
    const val modalBottomSheet = CoreConstants.CoreDsElevation.MODAL_BOTTOM_SHEET
    const val dialog = CoreConstants.CoreDsElevation.DIALOG
    const val floatingDrawer = CoreConstants.CoreDsElevation.FLOATING_DRAWER

    // --- PROPRIEDADES DE SOMBRA DINÂMICA (AMBIENT & SPOT) ---
    /** Transparência de sombra ambiente em tema claro */
    const val ambientShadowAlphaLight = CoreConstants.CoreDsElevation.AMBIENT_SHADOW_ALPHA_LIGHT

    /** Transparência de sombra direcionada em tema claro */
    const val spotShadowAlphaLight = CoreConstants.CoreDsElevation.SPOT_SHADOW_ALPHA_LIGHT

    /** Transparência de sombra ambiente em tema escuro */
    const val ambientShadowAlphaDark = CoreConstants.CoreDsElevation.AMBIENT_SHADOW_ALPHA_DARK

    /** Transparência de sombra direcionada em tema escuro */
    const val spotShadowAlphaDark = CoreConstants.CoreDsElevation.SPOT_SHADOW_ALPHA_DARK
}
