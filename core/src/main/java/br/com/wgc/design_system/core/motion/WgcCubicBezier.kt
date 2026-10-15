package br.com.wgc.design_system.core.motion

/**
 * Pontos de controle de uma curva cúbica de Bézier para temporização de animações.
 *
 * Exemplo: `val easing = WgcCubicBezier(0.2f, 0f, 0f, 1f)`.
 * Quando usar: escolha esta API quando descrever os pontos de controle de uma curva de easing.
 */
data class WgcCubicBezier(
    val x1: Float,
    val y1: Float,
    val x2: Float,
    val y2: Float
)
