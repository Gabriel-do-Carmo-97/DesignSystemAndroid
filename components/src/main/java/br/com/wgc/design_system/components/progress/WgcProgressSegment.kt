package br.com.wgc.design_system.components.progress

import androidx.compose.ui.graphics.Color

/**
 * Item individual para grupo de progresso em barras agrupadas.
 */
data class WgcProgressSegment(
    val label: String,
    val value: Float,
    val color: Color
)
