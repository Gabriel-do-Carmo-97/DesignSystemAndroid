package br.com.wgc.design_system.core

object WgcCoreDsElevation {
    /** 0dp - Sem elevação */
    const val level0 = 0.0

    /** 1dp - Elevação sutil (cards) */
    const val level1 = 1.0

    /** 2dp - Elevação baixa (barras de navegação e abas) */
    const val level2 = 2.0

    /** 3dp - Elevação média (botões elevados) */
    const val level3 = 3.0

    /** 6dp - Elevação alta (menus suspensos) */
    const val level6 = 6.0

    /** 8dp - Elevação máxima (modais, diálogos) */
    const val level8 = 8.0

    /** 12dp - Elevação extrema (drawers, sheets flutuantes) */
    const val level12 = 12.0

    // --- ALIASES SEMÂNTICOS DE ELEVAÇÃO ---
    const val cardFlat = level0
    const val cardDefault = level1
    const val navigationBar = level2
    const val buttonRaised = level3
    const val dropdownMenu = level6
    const val modalBottomSheet = level8
    const val dialog = level8
    const val floatingDrawer = level12

    // --- PROPRIEDADES DE SOMBRA DINÂMICA (AMBIENT & SPOT) ---
    /** Transparência de sombra ambiente em tema claro */
    const val ambientShadowAlphaLight = 0.06f

    /** Transparência de sombra direcionada em tema claro */
    const val spotShadowAlphaLight = 0.12f

    /** Transparência de sombra ambiente em tema escuro */
    const val ambientShadowAlphaDark = 0.15f

    /** Transparência de sombra direcionada em tema escuro */
    const val spotShadowAlphaDark = 0.30f
}
