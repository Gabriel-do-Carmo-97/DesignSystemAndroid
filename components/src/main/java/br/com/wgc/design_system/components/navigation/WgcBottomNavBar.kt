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
 * Barra de navegação inferior do Design System (WgcBottomNavBar).
 * Delega para a fábrica corporativa [WgcMenuFactory] unificando estilos e tokens.
 */
@Composable
fun WgcBottomNavBar(
    modifier: Modifier = Modifier,
    items: List<NavItem>,
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit = {}
) {
    WgcMenuFactory(
        modifier = modifier,
        type = WgcMenuType.ClassicBottomBar,
        items = items.mapIndexed { index, navItem ->
            WgcMenuItem(
                id = index.toString(),
                label = navItem.label,
                icon = navItem.icon,
                onClick = navItem.onClick
            )
        },
        selectedIndex = selectedIndex,
        onItemSelected = { index ->
            onItemSelected(index)
            if (index in items.indices) {
                items[index].onClick()
            }
        }
    )
}

