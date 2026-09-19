package br.com.wgc.core_ds.colors

import androidx.core.graphics.toColorInt

/**
 * Cores semânticas do Design System WGC.
 * Estas cores têm significado de negócio e são usadas em toda a aplicação.
 */
object WgcCoreDsColorsSemantic {
    // Core semantic colors
    val primary = WgcCoreDsColorsPrimitive.orange500
    val secondary = WgcCoreDsColorsPrimitive.white
    val background = WgcCoreDsColorsPrimitive.grey50

    // Status colors
    val error = WgcCoreDsColorsPrimitive.red500
    val success = "#4CAF50".toColorInt()
    val warning = "#FFC107".toColorInt()

    // Text colors
    val textPrimary = WgcCoreDsColorsPrimitive.grey900
    val textSecondary = "#757575".toColorInt()
}