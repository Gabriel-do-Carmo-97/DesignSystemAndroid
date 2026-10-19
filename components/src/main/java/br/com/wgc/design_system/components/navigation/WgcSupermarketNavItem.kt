package br.com.wgc.design_system.components.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.WineBar
import androidx.compose.ui.graphics.vector.ImageVector

enum class WgcSupermarketNavItem(val label: String, val icon: ImageVector) {
    HOME("Início", Icons.Default.Home),
    ADEGA("Adega", Icons.Default.WineBar),
    DISCOUNTS("Descontos", Icons.Default.LocalOffer),
    CART("Carrinho", Icons.Default.ShoppingBag),
    PROFILE("Cliente Mais", Icons.Default.Person)
}
