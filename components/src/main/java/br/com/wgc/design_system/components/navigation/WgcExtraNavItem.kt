package br.com.wgc.design_system.components.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Itens da barra de navegação inferior do Clube Extra.
 */
enum class WgcExtraNavItem(val label: String, val icon: ImageVector) {
    HOME("Início", Icons.Default.Home),
    DISCOUNTS("Descontos", Icons.Default.LocalOffer),
    FLYER("Folheto", Icons.AutoMirrored.Filled.MenuBook),
    CART("Carrinho", Icons.Default.ShoppingCart),
    PROFILE("Meu Perfil", Icons.Default.Person)
}
