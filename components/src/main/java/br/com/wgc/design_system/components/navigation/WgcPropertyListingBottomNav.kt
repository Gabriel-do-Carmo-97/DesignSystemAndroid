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
 * Barra de navegação inferior oficial do Property Listing (WgcPropertyListingBottomNav).
 */
@Deprecated(
    message = "Utilize WgcBottomNavBar com lista dinâmica de WgcNavItem",
    replaceWith = ReplaceWith(
        "WgcBottomNavBar(items = items, selectedRoute = selectedItem.name, onItemSelected = { ... })"
    )
)
@Composable
fun WgcPropertyListingBottomNav(
    modifier: Modifier = Modifier,
    selectedItem: WgcPropertyListingNavItem = WgcPropertyListingNavItem.Search,
    onItemSelected: (WgcPropertyListingNavItem) -> Unit = {},
    messagesBadgeCount: Int = 0,
    favoritesBadgeCount: Int = 0
) {
    val items = remember(messagesBadgeCount, favoritesBadgeCount) {
        WgcPropertyListingNavItem.entries.map { item ->
            val badge = when (item) {
                WgcPropertyListingNavItem.Messages -> if (messagesBadgeCount > 0) messagesBadgeCount else null
                WgcPropertyListingNavItem.Favorites -> if (favoritesBadgeCount > 0) favoritesBadgeCount else null
                else -> null
            }
            WgcNavItem(route = item.name, label = item.title, icon = item.icon, badgeCount = badge)
        }
    }
    WgcBottomNavBar(
        items = items,
        selectedRoute = selectedItem.name,
        onItemSelected = { navItem ->
            val match = WgcPropertyListingNavItem.entries.firstOrNull { it.name == navItem.route }
            if (match != null) onItemSelected(match)
        },
        modifier = modifier,
        containerColor = Color(WgcCoreDsColors.white),
        selectedColor = Color(WgcCoreDsColors.green14),
        unselectedColor = Color(WgcCoreDsColors.blue22),
        indicatorColor = Color.Transparent,
        tonalElevation = WgcCoreDsSpacing.XS8.dp
    )
}

@Preview(showBackground = true)
@Composable
private fun WgcPropertyListingBottomNavPreview() {
    WgcPropertyListingBottomNav(
        selectedItem = WgcPropertyListingNavItem.Search,
        messagesBadgeCount = 2
    )
}
