package br.com.wgc.design_system.components.colorpicker

import androidx.compose.ui.graphics.Color
import br.com.wgc.design_system.core.colors.WgcCoreDsColorsPrimitive
import br.com.wgc.design_system.core.colors.brands.WgcBrandEcommerce
import br.com.wgc.design_system.core.colors.brands.WgcBrandFoodDelivery
import br.com.wgc.design_system.core.colors.brands.WgcBrandMarketplace
import java.util.Locale
import kotlin.math.abs
import kotlin.math.roundToInt

/**
 * Modo de apresentação visual do seletor de cores WgcColorPicker.
 */
enum class WgcColorPickerPresentation {
    DIALOG,
    BOTTOM_SHEET
}

/**
 * Tipo de gatilho padrão do WgcColorPicker quando nenhum slot customizado é fornecido.
 */
enum class WgcColorPickerTriggerType {
    ICON,
    BADGE
}

/**
 * Utilitários matemáticos para conversão e manipulação no espaço de cor HSV.
 */
object WgcColorPickerUtils {

    /**
     * Converte coordenadas HSV (Hue, Saturation, Value) para [Color].
     */
    @Suppress("MagicNumber")
    fun hsvToColor(hue: Float, saturation: Float, value: Float, alpha: Float = 1f): Color {
        val h = (hue % 360f + 360f) % 360f
        val s = saturation.coerceIn(0f, 1f)
        val v = value.coerceIn(0f, 1f)
        val c = v * s
        val x = c * (1f - abs((h / 60f) % 2f - 1f))
        val m = v - c

        val (rPrime, gPrime, bPrime) = when ((h / 60f).toInt()) {
            0 -> Triple(c, x, 0f)
            1 -> Triple(x, c, 0f)
            2 -> Triple(0f, c, x)
            3 -> Triple(0f, x, c)
            4 -> Triple(x, 0f, c)
            else -> Triple(c, 0f, x)
        }

        return Color(
            red = (rPrime + m).coerceIn(0f, 1f),
            green = (gPrime + m).coerceIn(0f, 1f),
            blue = (bPrime + m).coerceIn(0f, 1f),
            alpha = alpha.coerceIn(0f, 1f)
        )
    }

    /**
     * Converte uma [Color] para coordenadas HSV (Hue, Saturation, Value).
     */
    fun colorToHsv(color: Color): Triple<Float, Float, Float> {
        val r = color.red
        val g = color.green
        val b = color.blue

        val max = maxOf(r, g, b)
        val min = minOf(r, g, b)
        val delta = max - min

        val hue = when {
            delta == 0f -> 0f
            max == r -> ((g - b) / delta * 60f + 360f) % 360f
            max == g -> ((b - r) / delta * 60f + 120f) % 360f
            else -> ((r - g) / delta * 60f + 240f) % 360f
        }

        val saturation = if (max == 0f) 0f else delta / max
        val value = max

        return Triple(hue, saturation, value)
    }

    /**
     * Converte [Color] para String hexadecimal formatada.
     */
    fun colorToHex(color: Color, includeAlpha: Boolean = false): String {
        val red = (color.red * 255f).roundToInt()
        val green = (color.green * 255f).roundToInt()
        val blue = (color.blue * 255f).roundToInt()
        val alpha = (color.alpha * 255f).roundToInt()

        return if (includeAlpha) {
            String.format(Locale.ROOT, "#%02X%02X%02X%02X", alpha, red, green, blue)
        } else {
            String.format(Locale.ROOT, "#%02X%02X%02X", red, green, blue)
        }
    }
}

/**
 * Defaults corporativos sensatos para o WgcColorPicker.
 */
object WgcColorPickerDefaults {
    /**
     * Paleta rápida de cores oficiais SSOT extraídas de [WgcCoreDsColors].
     */
    val quickPalette: List<Color> = listOf(
        Color(WgcBrandFoodDelivery.foodDeliveryRed),
        Color(WgcBrandEcommerce.dealMarketplaceOrange),
        Color(WgcBrandMarketplace.marketplaceYellow),
        Color(WgcBrandMarketplace.marketplaceGreen),
        Color(WgcBrandMarketplace.marketplaceBlue),
        Color(WgcBrandEcommerce.trendFashionPink),
        Color(WgcCoreDsColorsPrimitive.blue500),
        Color(WgcCoreDsColorsPrimitive.red500),
        Color(WgcCoreDsColorsPrimitive.black),
        Color(WgcCoreDsColorsPrimitive.white)
    )
}
