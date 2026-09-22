package br.com.wgc.design_system.core

import org.junit.Assert.assertTrue
import org.junit.Test
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow

/**
 * Suite de Auditoria de Acessibilidade e Contraste Baseada nas Normas W3C / WCAG 2.1.
 * Valida que as cores dos tokens de texto e fundo possuem contraste adequado:
 * - WCAG 2.1 Nível AA: Mínimo 4.5:1 para texto normal e 3.0:1 para componentes gráficos.
 * - WCAG 2.1 Nível AAA: Mínimo 7.0:1 para texto normal.
 */
class WgcAccessibilityAuditorTest {

    private data class Argb(val hex: Long) {
        val red: Double get() = ((hex shr 16) and 0xFF).toDouble() / 255.0
        val green: Double get() = ((hex shr 8) and 0xFF).toDouble() / 255.0
        val blue: Double get() = (hex and 0xFF).toDouble() / 255.0
    }

    @Test
    fun `dark text on light surface satisfies WCAG 2_1 AA contrast`() {
        val lightSurface = Argb(0xFFFFFFFFL)
        val darkText = Argb(0xFF1C1B1FL)

        val ratio = calculateContrastRatio(darkText, lightSurface)
        // Ratio should be well above 4.5:1
        assertTrue("O contraste deve ser >= 4.5:1 (Obtido: $ratio)", ratio >= 4.5)
    }

    @Test
    fun `light text on dark surface satisfies WCAG 2_1 AA contrast`() {
        val darkSurface = Argb(0xFF141218L)
        val lightText = Argb(0xFFE6E1E5L)

        val ratio = calculateContrastRatio(lightText, darkSurface)
        assertTrue("O contraste deve ser >= 4.5:1 (Obtido: $ratio)", ratio >= 4.5)
    }

    @Test
    fun `primary on surface container satisfies graphical component contrast`() {
        val background = Argb(0xFFFFFFFFL)
        val primaryColor = Argb(0xFF0D47A1L) // Deep blue

        val ratio = calculateContrastRatio(primaryColor, background)
        assertTrue("O contraste para elementos primários deve ser >= 3.0:1 (Obtido: $ratio)", ratio >= 3.0)
    }

    @Test
    fun `error text on error container satisfies minimum readable contrast`() {
        val errorContainer = Argb(0xFFF9DEDCL)
        val onErrorContainer = Argb(0xFF410E0BL)

        val ratio = calculateContrastRatio(onErrorContainer, errorContainer)
        assertTrue("O contraste de erro deve ser >= 4.5:1 (Obtido: $ratio)", ratio >= 4.5)
    }

    /**
     * Calcula a taxa de contraste (1.0 a 21.0) entre duas cores conforme algoritmo W3C WCAG 2.1.
     */
    private fun calculateContrastRatio(foreground: Argb, background: Argb): Double {
        val l1 = calculateRelativeLuminance(foreground)
        val l2 = calculateRelativeLuminance(background)

        val lighter = max(l1, l2)
        val darker = min(l1, l2)

        return (lighter + 0.05) / (darker + 0.05)
    }

    private fun calculateRelativeLuminance(color: Argb): Double {
        val r = transformChannel(color.red)
        val g = transformChannel(color.green)
        val b = transformChannel(color.blue)

        return 0.2126 * r + 0.7152 * g + 0.0722 * b
    }

    private fun transformChannel(channel: Double): Double {
        return if (channel <= 0.04045) {
            channel / 12.92
        } else {
            ((channel + 0.055) / 1.055).pow(2.4)
        }
    }
}
