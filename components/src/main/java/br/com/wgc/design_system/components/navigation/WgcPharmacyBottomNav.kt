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
 * Barra de navegação inferior Farmácia.
 */
@Deprecated(
    message = "Utilize WgcBottomNavBar com WgcNavPresets.pharmacy ou lista dinâmica de WgcNavItem",
    replaceWith = ReplaceWith(
        "WgcBottomNavBar(items = WgcNavPresets.pharmacy, selectedRoute = selectedTab.name, onItemSelected = { ... })"
    )
)
@Composable
fun WgcPharmacyBottomNav(
    selectedTab: PharmacyNavTab,
    onTabSelected: (PharmacyNavTab) -> Unit,
    modifier: Modifier = Modifier,
    cartBadgeCount: Int = 0
) {
    val items = remember(cartBadgeCount) {
        PharmacyNavTab.entries.map { tab ->
            WgcNavItem(
                route = tab.name,
                label = tab.title,
                icon = tab.icon,
                badgeCount = if (tab == PharmacyNavTab.CART && cartBadgeCount > 0) cartBadgeCount else null
            )
        }
    }
    WgcBottomNavBar(
        items = items,
        selectedRoute = selectedTab.name,
        onItemSelected = { navItem ->
            val match = PharmacyNavTab.entries.firstOrNull { it.name == navItem.route }
            if (match != null) onTabSelected(match)
        },
        modifier = modifier,
        containerColor = Color(WgcCoreDsColors.white),
        selectedColor = Color(WgcCoreDsColors.red8),
        unselectedColor = Color(WgcCoreDsColors.blue20),
        indicatorColor = Color(WgcCoreDsColors.pinkLight4),
        tonalElevation = WgcCoreDsElevation.LEVEL3.dp
    )
}

@Preview(showBackground = true)
@Composable
private fun WgcPharmacyBottomNavPreview() {
    WgcPharmacyBottomNav(
        selectedTab = PharmacyNavTab.HOME,
        onTabSelected = {},
        cartBadgeCount = 2
    )
}
