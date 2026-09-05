package br.com.wgc.design_system.components.navigation

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(
    val label: String,
    val icon: ImageVector,
    val onClick: () -> Unit
)

/**
 * Barra de navegação inferior do Design System (WgcBottomNavBar) baseado no Material 3.
 */
@Composable
fun WgcBottomNavBar(
    modifier: Modifier = Modifier,
    items: List<NavItem>,
    selectedIndex: Int
) {
    NavigationBar(modifier = modifier) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedIndex == index,
                onClick = item.onClick,
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(text = item.label) }
            )
        }
    }
}
