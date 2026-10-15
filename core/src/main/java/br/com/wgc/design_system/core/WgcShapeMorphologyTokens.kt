package br.com.wgc.design_system.core

/**
 * Tokens de geometria e morfologia de formas avançadas (cantos chanfrados, squircles e pílulas).
 */
object WgcShapeMorphologyTokens {
    // Chanfro em cantos cortados (Cut corner)
    const val cutCornerSmallDp = CoreConstants.ShapeMorphologyTokens.CUT_CORNER_SMALL_DP
    const val cutCornerMediumDp = CoreConstants.ShapeMorphologyTokens.CUT_CORNER_MEDIUM_DP
    const val cutCornerLargeDp = CoreConstants.ShapeMorphologyTokens.CUT_CORNER_LARGE_DP

    // Curvatura contínua / Superelipse (Squircle factor)
    const val squircleCornerSmoothing = CoreConstants.ShapeMorphologyTokens.SQUIRCLE_CORNER_SMOOTHING

    // Pílulas e formas circulares
    const val pillRadiusDp = CoreConstants.ShapeMorphologyTokens.PILL_RADIUS_DP
}
