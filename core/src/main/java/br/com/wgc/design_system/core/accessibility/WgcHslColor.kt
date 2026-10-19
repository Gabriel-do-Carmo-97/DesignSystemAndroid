package br.com.wgc.design_system.core.accessibility

/**
 * Cor no espaço HSL, com matiz em graus e saturação/luminosidade entre 0 e 1.
 *
 * Exemplo: `val hsl = WgcColorHarmonizer.argbToHsl(0xFFFF5722.toInt())`.
 * Quando usar: escolha esta API quando representar ou transferir uma cor em componentes HSL.
 */
data class WgcHslColor(val hue: Float, val saturation: Float, val lightness: Float)
