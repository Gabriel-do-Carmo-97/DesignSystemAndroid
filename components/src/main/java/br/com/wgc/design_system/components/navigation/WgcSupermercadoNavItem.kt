package br.com.wgc.design_system.components.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

enum class WgcSupermercadoNavItem(val label: String, val icon: ImageVector) {
    HOME("Início", Icons.Default.Home),
    COUPONS("Cupons", Icons.Default.LocalOffer),
    FLYER("Folheto", Icons.AutoMirrored.Filled.MenuBook),
    CART("Carrinho", Icons.Default.ShoppingCart),
    LOYALTY("Fidelidade", Icons.Default.CreditCard)
}
