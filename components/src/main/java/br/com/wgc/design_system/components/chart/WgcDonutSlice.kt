@file:Suppress("LongMethod", "MagicNumber", "MatchingDeclarationName")

package br.com.wgc.design_system.components.chart

import androidx.compose.ui.graphics.Color

/**
 * Fatia individual do gráfico Donut.
 */
data class WgcDonutSlice(
    val value: Float,
    val color: Color,
    val label: String = ""
)
