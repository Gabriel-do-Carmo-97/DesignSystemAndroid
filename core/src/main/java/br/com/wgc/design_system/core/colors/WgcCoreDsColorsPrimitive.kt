package br.com.wgc.design_system.core.colors

import android.graphics.Color
import androidx.core.graphics.toColorInt

/**
 * Cores primitivas do Design System WGC.
 * Estas são as cores fundamentais que servem como base para todas as outras paletas.
 */
object WgcCoreDsColorsPrimitive {
    // Red tones
    val red500 = "#F44336".toColorInt()
    val red700 = "#D32F2F".toColorInt()

    // Blue tones
    val blue500 = "#2196F3".toColorInt()

    // Orange tones
    val orange500 = "#FF5722".toColorInt()

    // Grey tones
    val grey50 = "#FAFAFA".toColorInt()
    val grey100 = "#F5F5F5".toColorInt()
    val grey900 = "#212121".toColorInt()

    // Standard colors
    const val white = Color.WHITE
    const val black = Color.BLACK
    const val transparent = Color.TRANSPARENT
}