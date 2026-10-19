package br.com.wgc.design_system.components.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.theme.WgcCoreDsColors
import br.com.wgc.design_system.core.tokens.WgcCoreDsElevation

/**
 * Barra de navegação inferior Supermarket.
 */
@Deprecated(
    message = "Utilize WgcBottomNavBar com lista dinâmica de WgcNavItem",
    replaceWith = ReplaceWith(
        "WgcBottomNavBar(items = items, selectedRoute = selectedItem.name, onItemSelected = { ... })"
    )
)
@Composable
fun WgcSupermarketBottomNav(
    selectedItem: WgcSupermarketNavItem,
    onItemSelected: (WgcSupermarketNavItem) -> Unit,
    modifier: Modifier = Modifier,
    cartBadgeCount: Int = 0
) {
    val items = remember(cartBadgeCount) {
        WgcSupermarketNavItem.entries.map { item ->
            WgcNavItem(
                route = item.name,
                label = item.label,
                icon = item.icon,
                badgeCount = if (item == WgcSupermarketNavItem.CART && cartBadgeCount > 0) cartBadgeCount else null
            )
        }
    }
    WgcBottomNavBar(
        items = items,
        selectedRoute = selectedItem.name,
        onItemSelected = { navItem ->
            val match = WgcSupermarketNavItem.entries.firstOrNull { it.name == navItem.route }
            if (match != null) onItemSelected(match)
        },
        modifier = modifier,
        containerColor = Color(WgcCoreDsColors.white),
        selectedColor = Color(WgcCoreDsColors.greenDark7),
        unselectedColor = Color(WgcCoreDsColors.cyan7),
        indicatorColor = Color(WgcCoreDsColors.greenLight9),
        tonalElevation = WgcCoreDsElevation.LEVEL3.dp
    )
}

@Preview(name = "Supermarket Bottom Nav - Selected Adega", showBackground = true)
@Composable
private fun WgcSupermarketBottomNavPreview() {
    WgcSupermarketBottomNav(
        selectedItem = WgcSupermarketNavItem.ADEGA,
        onItemSelected = {},
        cartBadgeCount = 3
    )
}
