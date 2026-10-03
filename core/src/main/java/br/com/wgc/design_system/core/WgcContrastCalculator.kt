@file:Suppress("MagicNumber")

package br.com.wgc.design_system.core

import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow

/**
 * Calculador de contraste e conformidade WCAG 2.1 / 2.2 em tempo de execução.
 * Suporta avaliação automática para texto normal, texto ampliado e elementos gráficos.
 * Implementação pura sem acoplamento direto com UI frameworks.
 */
object WgcContrastCalculator {

    const val WCAG_AA_NORMAL_TEXT_MIN_RATIO = 4.5
    const val WCAG_AA_LARGE_TEXT_MIN_RATIO = 3.0
    const val WCAG_AAA_NORMAL_TEXT_MIN_RATIO = 7.0
    const val WCAG_AAA_LARGE_TEXT_MIN_RATIO = 4.5

    const val COLOR_WHITE = 0xFFFFFFFF.toInt()
    const val COLOR_BLACK = 0xFF000000.toInt()

    /**
     * Calcula o valor de luminância relativa de uma cor ARGB de acordo com o padrão W3C.
     */
    fun calculateLuminance(colorArgb: Int): Double {
        val r = sRgbToLinear(((colorArgb shr 16) and 0xFF) / 255.0)
        val g = sRgbToLinear(((colorArgb shr 8) and 0xFF) / 255.0)
        val b = sRgbToLinear((colorArgb and 0xFF) / 255.0)
        return 0.2126 * r + 0.7152 * g + 0.0722 * b
    }

    private fun sRgbToLinear(channel: Double): Double {
        return if (channel <= 0.03928) {
            channel / 12.92
        } else {
            ((channel + 0.055) / 1.055).pow(2.4)
        }
    }

    /**
     * Calcula o ratio de contraste entre duas cores ARGB (foreground e background).
     * Retorna um valor entre 1.0 e 21.0.
     */
    fun calculateContrastRatio(foregroundArgb: Int, backgroundArgb: Int): Double {
        val lum1 = calculateLuminance(foregroundArgb)
        val lum2 = calculateLuminance(backgroundArgb)
        val lighter = max(lum1, lum2)
        val darker = min(lum1, lum2)
        return (lighter + 0.05) / (darker + 0.05)
    }

    /**
     * Verifica se o par de cores atende ao nível WCAG 2.1/2.2 AA para texto padrão.
     */
    fun isWcagAaCompliant(foregroundArgb: Int, backgroundArgb: Int): Boolean {
        return calculateContrastRatio(foregroundArgb, backgroundArgb) >= WCAG_AA_NORMAL_TEXT_MIN_RATIO
    }

    /**
     * Verifica se o par de cores atende ao nível WCAG 2.1/2.2 AAA para texto padrão.
     */
    fun isWcagAaaCompliant(foregroundArgb: Int, backgroundArgb: Int): Boolean {
        return calculateContrastRatio(foregroundArgb, backgroundArgb) >= WCAG_AAA_NORMAL_TEXT_MIN_RATIO
    }

    /**
     * Recomenda a melhor cor de texto (Branco ou Preto puro) para maximizar o contraste com o fundo.
     */
    fun getRecommendedTextColor(backgroundArgb: Int): Int {
        val whiteContrast = calculateContrastRatio(COLOR_WHITE, backgroundArgb)
        val blackContrast = calculateContrastRatio(COLOR_BLACK, backgroundArgb)
        return if (whiteContrast >= blackContrast) COLOR_WHITE else COLOR_BLACK
    }
}
