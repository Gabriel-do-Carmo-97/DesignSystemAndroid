package br.com.wgc.design_system.components.navigation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSize

/**
 * Itens da barra de navegação inferior do Supermercado Brasil.
 */
enum class GroceryNavTab {
    HOME,
    COUPONS,
    FLYER,
    CART,
    LOYALTY
}

enum class WgcSupermercadoNavItem(val label: String, val icon: ImageVector) {
    HOME("Início", Icons.Default.Home),
    COUPONS("Cupons", Icons.Default.LocalOffer),
    FLYER("Folheto", Icons.AutoMirrored.Filled.MenuBook),
    CART("Carrinho", Icons.Default.ShoppingCart),
    LOYALTY("Fidelidade", Icons.Default.CreditCard)
}

/**
 * Barra de navegação inferior do Supermercado Brasil.
 */
@Composable
fun WgcGroceryBottomNav(
    selectedItem: Int,
    onItemSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier.border(
            width = WgcCoreDsSize.s1.dp,
            color = Color(WgcCoreDsColors.groceryBorder)
        )) {
        WgcSupermercadoNavItem.entries.forEachIndexed { index, item ->
            val isSelected = selectedItem == index
            NavigationBarItem(
                selected = isSelected,
                onClick = { onItemSelected(index) },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label,
                        modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                    )
                },
                label = {
                    Text(
                        text = item.label,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        style = MaterialTheme.typography.labelSmall
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(WgcCoreDsColors.groceryBlue),
                    selectedTextColor = Color(WgcCoreDsColors.groceryBlue),
                    unselectedIconColor = Color(WgcCoreDsColors.groceryTextSecondary),
                    unselectedTextColor = Color(WgcCoreDsColors.groceryTextSecondary),
                    indicatorColor = Color(WgcCoreDsColors.groceryBlueLight)
                )
            )
        }
    }
}

@Preview(name = "Supermercado Bottom Nav - Selected Coupons", showBackground = true)
@Composable
private fun WgcSupermercadoBottomNavPreview() {
    WgcGroceryBottomNav(
        selectedItem = 1,
        onItemSelected = {}
    )
}

@Composable
fun WgcGroceryBottomNav(
    selectedTab: GroceryNavTab,
    onTabSelected: (GroceryNavTab) -> Unit,
    modifier: Modifier = Modifier,
    cartBadgeCount: Int = 0
) {
    val selectedIndex = when (selectedTab) {
        GroceryNavTab.HOME -> 0
        GroceryNavTab.COUPONS -> 1
        GroceryNavTab.FLYER -> 2
        GroceryNavTab.CART -> 3
        GroceryNavTab.LOYALTY -> 4
    }
    WgcGroceryBottomNav(
        selectedItem = selectedIndex,
        onItemSelected = { idx ->
            val tab = when (idx) {
                0 -> GroceryNavTab.HOME
                1 -> GroceryNavTab.COUPONS
                2 -> GroceryNavTab.FLYER
                3 -> GroceryNavTab.CART
                else -> GroceryNavTab.LOYALTY
            }
            onTabSelected(tab)
        },
        modifier = modifier
    )
}

