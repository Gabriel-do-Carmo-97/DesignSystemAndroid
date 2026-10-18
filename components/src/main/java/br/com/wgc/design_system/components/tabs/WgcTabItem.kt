package br.com.wgc.design_system.components.tabs

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Modelo de dados para aba no WgcTabRow.
 */
data class WgcTabItem(
    val id: String,
    val title: String,
    val icon: ImageVector? = null,
    val badgeCount: Int? = null
)
