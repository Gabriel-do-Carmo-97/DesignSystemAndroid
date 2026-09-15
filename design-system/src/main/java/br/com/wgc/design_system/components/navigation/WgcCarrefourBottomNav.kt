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
 * Itens da barra de navegação inferior do Carrefour Brasil.
 */
enum class CarrefourNavTab {
    HOME,
    COUPONS,
    FLYER,
    CART,
    MEU_CARREFOUR
}

enum class WgcCarrefourNavItem(val label: String, val icon: ImageVector) {
    HOME("Início", Icons.Default.Home),
    COUPONS("Cupons", Icons.Default.LocalOffer),
    FLYER("Folheto", Icons.AutoMirrored.Filled.MenuBook),
    CART("Carrinho", Icons.Default.ShoppingCart),
    MEU_CARREFOUR("Meu Carrefour", Icons.Default.CreditCard)
}

/**
 * Barra de navegação inferior do Carrefour Brasil.
 */
@Composable
fun WgcCarrefourBottomNav(
    selectedItem: Int,
    onItemSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier.border(
            width = WgcCoreDsSize.s1.dp,
            color = Color(WgcCoreDsColors.carrefourBorder)
        )) {
        WgcCarrefourNavItem.entries.forEachIndexed { index, item ->
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
                    selectedIconColor = Color(WgcCoreDsColors.carrefourBlue),
                    selectedTextColor = Color(WgcCoreDsColors.carrefourBlue),
                    unselectedIconColor = Color(WgcCoreDsColors.carrefourTextSecondary),
                    unselectedTextColor = Color(WgcCoreDsColors.carrefourTextSecondary),
                    indicatorColor = Color(WgcCoreDsColors.carrefourBlueLight)
                )
            )
        }
    }
}

@Preview(name = "Carrefour Bottom Nav - Selected Coupons", showBackground = true)
@Composable
private fun WgcCarrefourBottomNavPreview() {
    WgcCarrefourBottomNav(
        selectedItem = 1,
        onItemSelected = {}
    )
}

@Composable
fun WgcCarrefourBottomNav(
    selectedTab: CarrefourNavTab,
    onTabSelected: (CarrefourNavTab) -> Unit,
    modifier: Modifier = Modifier,
    cartBadgeCount: Int = 0
) {
    val selectedIndex = when (selectedTab) {
        CarrefourNavTab.HOME -> 0
        CarrefourNavTab.COUPONS -> 1
        CarrefourNavTab.FLYER -> 2
        CarrefourNavTab.CART -> 3
        CarrefourNavTab.MEU_CARREFOUR -> 4
    }
    WgcCarrefourBottomNav(
        selectedItem = selectedIndex,
        onItemSelected = { idx ->
            val tab = when (idx) {
                0 -> CarrefourNavTab.HOME
                1 -> CarrefourNavTab.COUPONS
                2 -> CarrefourNavTab.FLYER
                3 -> CarrefourNavTab.CART
                else -> CarrefourNavTab.MEU_CARREFOUR
            }
            onTabSelected(tab)
        },
        modifier = modifier
    )
}

