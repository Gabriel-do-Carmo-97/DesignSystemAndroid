package br.com.wgc.design_system.core

/**
 * Tokens de geometria e morfologia de formas avançadas (cantos chanfrados, squircles e pílulas).
 */
object WgcShapeMorphologyTokens {
    // Chanfro em cantos cortados (Cut corner)
    const val cutCornerSmallDp = 4f
    const val cutCornerMediumDp = 8f
    const val cutCornerLargeDp = 16f

    // Curvatura contínua / Superelipse (Squircle factor)
    const val squircleCornerSmoothing = 0.6f

    // Pílulas e formas circulares
    const val pillRadiusDp = 999f
}
