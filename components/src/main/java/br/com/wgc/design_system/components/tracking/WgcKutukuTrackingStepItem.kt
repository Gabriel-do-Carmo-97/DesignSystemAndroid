package br.com.wgc.design_system.components.tracking

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Modelo de dado para um item da timeline do Kutuku.
 */
data class WgcKutukuTrackingStepItem(
    val title: String,
    val subtitle: String,
    val time: String,
    val status: WgcKutukuStepStatus,
    val icon: ImageVector? = null
)
