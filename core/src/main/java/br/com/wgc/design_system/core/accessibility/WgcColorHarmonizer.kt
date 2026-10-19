package br.com.wgc.design_system.core.accessibility

import kotlin.math.max
import kotlin.math.min

/**
 * Utilitário matemático para harmonização cromática e geração procedural de paletas no espaço HSL.
 * Exemplo: `val hsl = WgcColorHarmonizer.argbToHsl(colorArgb)`.
 * Quando usar: escolha esta API quando converter cores ARGB para HSL ou derivar tons harmônicos.
 */
@Suppress("MagicNumber")
object WgcColorHarmonizer {

    /**
     * Converte ARGB de 32 bits para HSL (Hue: 0..360, Saturation: 0..1, Lightness: 0..1).
     * Quando usar: chame este método ao converter uma cor ARGB para os componentes HSL.
     */
    fun argbToHsl(argb: Int): WgcHslColor {
        val r = ((argb shr 16) and 0xFF) / 255f
        val g = ((argb shr 8) and 0xFF) / 255f
        val b = (argb and 0xFF) / 255f

        val max = max(r, max(g, b))
        val min = min(r, min(g, b))
        val delta = max - min

        val l = (max + min) / 2f

        if (delta == 0f) {
            return WgcHslColor(0f, 0f, l)
        }

        val s = if (l > 0.5f) delta / (2f - max - min) else delta / (max + min)

        val h = when (max) {
            r -> ((g - b) / delta + (if (g < b) 6f else 0f)) * 60f
            g -> ((b - r) / delta + 2f) * 60f
            else -> ((r - g) / delta + 4f) * 60f
        }

        return WgcHslColor(h, s, l)
    }

    /**
     * Gera a cor complementar direta (inversão de 180 graus de matiz).
     * Quando usar: chame este método ao derivar o matiz oposto para criar uma cor complementar.
     */
    fun getComplementaryHue(hsl: WgcHslColor): Float {
        return (hsl.hue + 180f) % 360f
    }
}
