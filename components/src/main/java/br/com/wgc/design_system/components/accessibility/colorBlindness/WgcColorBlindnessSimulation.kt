@file:Suppress("MagicNumber")

package br.com.wgc.design_system.components.accessibility.colorBlindness

import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix

/**
 * Matrizes de transformação de cor para simulação de daltonismo baseadas nas fórmulas de Brettel et al.
 */
object WgcColorBlindnessSimulation {

    fun getColorFilter(mode: WgcColorBlindnessMode): ColorFilter? {
        return when (mode) {
            WgcColorBlindnessMode.NONE -> null
            WgcColorBlindnessMode.PROTANOPIA -> ColorFilter.colorMatrix(
                ColorMatrix(
                    floatArrayOf(
                        0.567f, 0.433f, 0f, 0f, 0f,
                        0.558f, 0.442f, 0f, 0f, 0f,
                        0f, 0.242f, 0.758f, 0f, 0f,
                        0f, 0f, 0f, 1f, 0f
                    )
                )
            )
            WgcColorBlindnessMode.DEUTERANOPIA -> ColorFilter.colorMatrix(
                ColorMatrix(
                    floatArrayOf(
                        0.625f, 0.375f, 0f, 0f, 0f,
                        0.7f, 0.3f, 0f, 0f, 0f,
                        0f, 0.3f, 0.7f, 0f, 0f,
                        0f, 0f, 0f, 1f, 0f
                    )
                )
            )
            WgcColorBlindnessMode.TRITANOPIA -> ColorFilter.colorMatrix(
                ColorMatrix(
                    floatArrayOf(
                        0.95f, 0.05f, 0f, 0f, 0f,
                        0f, 0.433f, 0.567f, 0f, 0f,
                        0f, 0.475f, 0.525f, 0f, 0f,
                        0f, 0f, 0f, 1f, 0f
                    )
                )
            )
        }
    }
}
