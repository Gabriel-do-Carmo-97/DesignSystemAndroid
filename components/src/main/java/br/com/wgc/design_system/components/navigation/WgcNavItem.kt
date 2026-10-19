package br.com.wgc.design_system.components.navigation

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Item de navegação para a barra inferior.
 */
data class WgcNavItem(
    val route: String,
    val label: String,
    val icon: ImageVector,
    val selectedIcon: ImageVector = icon,
    val badgeCount: Int? = null,
    val onClick: (() -> Unit)? = null
)
