package br.com.wgc.design_system.core.tokens

import br.com.wgc.design_system.constants.CoreConstants

/**
 * Escala de elevação e parâmetros de sombra para hierarquia de superfícies.
 *
 * Exemplo: `val cardElevation = WgcCoreDsElevation.CARD_DEFAULT`.
 * Quando usar: escolha esta API quando escolher elevação e transparência de sombra.
 */
object WgcCoreDsElevation {
    /** 0dp - Sem elevação */
    const val LEVEL0 = CoreConstants.CoreDsElevation.LEVEL0

    /** 1dp - Elevação sutil (cards) */
    const val LEVEL1 = CoreConstants.CoreDsElevation.LEVEL1

    /** 2dp - Elevação baixa (barras de navegação e abas) */
    const val LEVEL2 = CoreConstants.CoreDsElevation.LEVEL2

    /** 3dp - Elevação média (botões elevados) */
    const val LEVEL3 = CoreConstants.CoreDsElevation.LEVEL3

    /** 6dp - Elevação alta (menus suspensos) */
    const val LEVEL6 = CoreConstants.CoreDsElevation.LEVEL6

    /** 8dp - Elevação máxima (modais, diálogos) */
    const val LEVEL8 = CoreConstants.CoreDsElevation.LEVEL8

    /** 12dp - Elevação extrema (drawers, sheets flutuantes) */
    const val LEVEL12 = CoreConstants.CoreDsElevation.LEVEL12

    // --- ALIASES SEMÂNTICOS DE ELEVAÇÃO ---
    const val CARD_FLAT = CoreConstants.CoreDsElevation.CARD_FLAT
    const val CARD_DEFAULT = CoreConstants.CoreDsElevation.CARD_DEFAULT
    const val NAVIGATION_BAR = CoreConstants.CoreDsElevation.NAVIGATION_BAR
    const val BUTTON_RAISED = CoreConstants.CoreDsElevation.BUTTON_RAISED
    const val DROPDOWN_MENU = CoreConstants.CoreDsElevation.DROPDOWN_MENU
    const val MODAL_BOTTOM_SHEET = CoreConstants.CoreDsElevation.MODAL_BOTTOM_SHEET
    const val DIALOG = CoreConstants.CoreDsElevation.DIALOG
    const val FLOATING_DRAWER = CoreConstants.CoreDsElevation.FLOATING_DRAWER

    // --- PROPRIEDADES DE SOMBRA DINÂMICA (AMBIENT & SPOT) ---
    /** Transparência de sombra ambiente em tema claro */
    const val AMBIENT_SHADOW_ALPHA_LIGHT = CoreConstants.CoreDsElevation.AMBIENT_SHADOW_ALPHA_LIGHT

    /** Transparência de sombra direcionada em tema claro */
    const val SPOT_SHADOW_ALPHA_LIGHT = CoreConstants.CoreDsElevation.SPOT_SHADOW_ALPHA_LIGHT

    /** Transparência de sombra ambiente em tema escuro */
    const val AMBIENT_SHADOW_ALPHA_DARK = CoreConstants.CoreDsElevation.AMBIENT_SHADOW_ALPHA_DARK

    /** Transparência de sombra direcionada em tema escuro */
    const val SPOT_SHADOW_ALPHA_DARK = CoreConstants.CoreDsElevation.SPOT_SHADOW_ALPHA_DARK

    const val level0 = LEVEL0
    const val level1 = LEVEL1
    const val level2 = LEVEL2
    const val level3 = LEVEL3
    const val level6 = LEVEL6
    const val level8 = LEVEL8
}
