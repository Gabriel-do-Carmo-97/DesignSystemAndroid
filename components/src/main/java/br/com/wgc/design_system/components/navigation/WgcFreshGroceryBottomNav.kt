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
 * Bottom Navigation Bar Fresh Grocery.
 */
@Deprecated(
    message = "Utilize WgcBottomNavBar com lista dinâmica de WgcNavItem",
    replaceWith = ReplaceWith(
        "WgcBottomNavBar(items = items, selectedRoute = selectedItem.name, onItemSelected = { ... })"
    )
)
@Composable
fun WgcFreshGroceryBottomNav(
    selectedItem: WgcFreshGroceryNavItem = WgcFreshGroceryNavItem.Home,
    onItemSelected: (WgcFreshGroceryNavItem) -> Unit = {},
    modifier: Modifier = Modifier
) {
    val items = remember {
        WgcFreshGroceryNavItem.entries.map { item ->
            WgcNavItem(
                route = item.name,
                label = item.title,
                icon = item.unselectedIcon,
                selectedIcon = item.selectedIcon
            )
        }
    }
    WgcBottomNavBar(
        items = items,
        selectedRoute = selectedItem.name,
        onItemSelected = { navItem ->
            val match = WgcFreshGroceryNavItem.entries.firstOrNull { it.name == navItem.route }
            if (match != null) onItemSelected(match)
        },
        modifier = modifier,
        containerColor = Color.White,
        selectedColor = Color(WgcCoreDsColors.green13),
        unselectedColor = Color.Gray,
        indicatorColor = Color.Transparent,
        tonalElevation = WgcCoreDsElevation.LEVEL2.dp
    )
}

@Preview(name = "Fresh Grocery Bottom Nav", showBackground = true)
@Composable
private fun WgcFreshGroceryBottomNavPreview() {
    WgcFreshGroceryBottomNav()
}
