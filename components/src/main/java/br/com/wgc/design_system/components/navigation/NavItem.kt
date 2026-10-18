package br.com.wgc.design_system.components.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(
    val label: String,
    val icon: ImageVector,
    val badgeCount: Int = 0,
    val isProminent: Boolean = false,
    val onClick: () -> Unit
)
