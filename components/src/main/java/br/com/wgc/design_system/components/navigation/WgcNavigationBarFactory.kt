package br.com.wgc.design_system.components.navigation

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Item de navegação para a barra inferior.
 */
data class WgcNavItem(
    val route: String,
    val label: String,
    val icon: ImageVector,
    val selectedIcon: ImageVector = icon,
    val badgeCount: Int? = null
)

/**
 * Fábrica universal de navegação inferior (WgcNavigationBarFactory).
 */
object WgcNavigationBarFactory {

    @Composable
    fun Standard(
        items: List<WgcNavItem>,
        selectedRoute: String,
        onItemSelected: (WgcNavItem) -> Unit,
        modifier: Modifier = Modifier
    ) {
        NavigationBar(modifier = modifier) {
            items.forEach { item ->
                val isSelected = item.route == selectedRoute
                NavigationBarItem(
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
}
