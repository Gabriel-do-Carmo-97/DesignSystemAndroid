package br.com.wgc.design_system.components.navigation

import androidx.compose.foundation.border
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.theme.WgcCoreDsColors
import br.com.wgc.design_system.core.tokens.WgcCoreDsSize

/**
 * Barra de navegação inferior do Supermercado Brasil.
 */
@Deprecated(
    message = "Utilize WgcBottomNavBar com WgcNavPresets.grocery ou lista dinâmica de WgcNavItem",
    replaceWith = ReplaceWith(
        "WgcBottomNavBar(items = WgcNavPresets.grocery, selectedIndex = selectedItem, onItemSelected = onItemSelected)"
    )
)
@Composable
fun WgcGroceryBottomNav(
    selectedItem: Int,
    onItemSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val items = remember {
        WgcSupermercadoNavItem.entries.map { item ->
            WgcNavItem(route = item.name, label = item.label, icon = item.icon)
        }
    }
    WgcBottomNavBar(
        items = items,
        selectedIndex = selectedItem,
        onItemSelected = onItemSelected,
        modifier = modifier.border(
            width = WgcCoreDsSize.S1.dp,
            color = Color(WgcCoreDsColors.blueLight4)
        ),
        selectedColor = Color(WgcCoreDsColors.blueDark32),
        unselectedColor = Color(WgcCoreDsColors.gray5),
        indicatorColor = Color(WgcCoreDsColors.blueLight20)
    )
}

@Preview(name = "Supermercado Bottom Nav - Selected Coupons", showBackground = true)
@Composable
private fun WgcSupermercadoBottomNavPreview() {
    WgcGroceryBottomNav(
        selectedItem = 1,
        onItemSelected = {}
    )
}

/**
 * Sobrecarga tipada de [WgcGroceryBottomNav] com [GroceryNavTab].
 */
@Deprecated(
    message = "Utilize WgcBottomNavBar com WgcNavPresets.grocery ou lista dinâmica de WgcNavItem"
)
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
