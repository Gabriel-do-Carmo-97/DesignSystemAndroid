@file:Suppress("MatchingDeclarationName")

package br.com.wgc.design_system.components.navigation

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Modelo de item para menus suspensos corporativos (WgcDropdownItem).
 */
data class WgcDropdownItem(
    val id: String,
    val title: String,
    val leadingIcon: ImageVector? = null,
    val badgeCount: Int? = null,
    val isDestructive: Boolean = false,
    val enabled: Boolean = true,
    val onClick: () -> Unit = {}
)
