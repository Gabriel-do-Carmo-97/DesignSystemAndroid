package br.com.wgc.design_system.components.navigation

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

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
