package br.com.wgc.design_system.components.cards

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Item de status de pedido do Shoppe.
 */
data class ShoppeOrderStatusItem(
    val title: String,
    val icon: ImageVector,
    val badgeCount: Int = 0,
    val onClick: () -> Unit = {}
)
