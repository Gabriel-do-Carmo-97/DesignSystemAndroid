package br.com.wgc.design_system.components.navigation

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.commons.previews.multi.theme.ThemePreviews
import br.com.wgc.design_system.theme.WgcTheme

/**
 * WgcNavigationRail
 *
 * Barra de navegação vertical para tablets, telas dobráveis e dispositivos com orientação horizontal.
 */
@Composable
fun WgcNavigationRail(
    items: List<WgcNavItem>,
    selectedRoute: String,
    onItemSelected: (WgcNavItem) -> Unit,
    modifier: Modifier = Modifier,
    headerSlot: (@Composable ColumnScope.() -> Unit)? = null
) {
    NavigationRail(
        modifier = modifier,
        header = headerSlot
    ) {
        items.forEach { item ->
            val isSelected = item.route == selectedRoute
            NavigationRailItem(
                selected = isSelected,
                onClick = { onItemSelected(item) },
                icon = {
                    BadgedBox(
                        badge = {
                            if (item.badgeCount != null && item.badgeCount > 0) {
                                Badge { Text(text = if (item.badgeCount > 99) "99+" else item.badgeCount.toString()) }
                            }
                        }
                    ) {
                        Icon(
                            imageVector = if (isSelected) item.selectedIcon else item.icon,
                            contentDescription = item.label
                        )
                    }
                },
                label = { Text(text = item.label) }
            )
        }
    }
}

@ThemePreviews
@Composable
private fun WgcNavigationRailPreview() {
    WgcTheme {
        val sampleItems = listOf(
            WgcNavItem(route = "home", label = "Home", icon = Icons.Outlined.Home, selectedIcon = Icons.Filled.Home),
            WgcNavItem(route = "search", label = "Search", icon = Icons.Outlined.Search, selectedIcon = Icons.Filled.Search),
            WgcNavItem(route = "favorites", label = "Favorites", icon = Icons.Outlined.Favorite, selectedIcon = Icons.Filled.Favorite, badgeCount = 3),
            WgcNavItem(route = "profile", label = "Profile", icon = Icons.Outlined.Person, selectedIcon = Icons.Filled.Person)
        )
        WgcNavigationRail(
            items = sampleItems,
            selectedRoute = "home",
            onItemSelected = {}
        )
    }
}
