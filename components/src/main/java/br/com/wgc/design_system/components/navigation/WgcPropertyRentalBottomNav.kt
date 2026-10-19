package br.com.wgc.design_system.components.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.theme.WgcCoreDsColors
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing

/**
 * Barra de navegação inferior oficial do Property Rental (WgcPropertyRentalBottomNav).
 */
@Deprecated(
    message = "Utilize WgcBottomNavBar com lista dinâmica de WgcNavItem",
    replaceWith = ReplaceWith(
        "WgcBottomNavBar(items = items, selectedRoute = selectedItem.name, onItemSelected = { ... })"
    )
)
@Composable
fun WgcPropertyRentalBottomNav(
    modifier: Modifier = Modifier,
    selectedItem: WgcPropertyRentalNavItem = WgcPropertyRentalNavItem.Explore,
    onItemSelected: (WgcPropertyRentalNavItem) -> Unit = {},
    visitsBadgeCount: Int = 0,
    messagesBadgeCount: Int = 0
) {
    val items = remember(visitsBadgeCount, messagesBadgeCount) {
        WgcPropertyRentalNavItem.entries.map { item ->
            val badge = when (item) {
                WgcPropertyRentalNavItem.Visits -> if (visitsBadgeCount > 0) visitsBadgeCount else null
                WgcPropertyRentalNavItem.Messages -> if (messagesBadgeCount > 0) messagesBadgeCount else null
                else -> null
            }
            WgcNavItem(route = item.name, label = item.title, icon = item.icon, badgeCount = badge)
        }
    }
    WgcBottomNavBar(
        items = items,
        selectedRoute = selectedItem.name,
        onItemSelected = { navItem ->
            val match = WgcPropertyRentalNavItem.entries.firstOrNull { it.name == navItem.route }
            if (match != null) onItemSelected(match)
        },
        modifier = modifier,
        containerColor = Color(WgcCoreDsColors.white),
        selectedColor = Color(WgcCoreDsColors.blueDark26),
        unselectedColor = Color(WgcCoreDsColors.blue21),
        indicatorColor = Color(WgcCoreDsColors.yellow6),
        tonalElevation = WgcCoreDsSpacing.XS8.dp
    )
}

@Preview(showBackground = true)
@Composable
private fun WgcPropertyRentalBottomNavPreview() {
    WgcPropertyRentalBottomNav(
        selectedItem = WgcPropertyRentalNavItem.Explore,
        visitsBadgeCount = 1,
        messagesBadgeCount = 2
    )
}
