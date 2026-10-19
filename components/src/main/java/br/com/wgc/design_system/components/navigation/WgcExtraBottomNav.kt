package br.com.wgc.design_system.components.navigation

import androidx.compose.foundation.border
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.theme.WgcCoreDsColors
import br.com.wgc.design_system.core.tokens.WgcCoreDsSize

/**
 * Barra de navegação inferior do Clube Extra.
 */
@Deprecated(
    message = "Utilize WgcBottomNavBar com lista dinâmica de WgcNavItem",
    replaceWith = ReplaceWith(
        "WgcBottomNavBar(items = items, selectedRoute = selectedItem.name, onItemSelected = { ... })"
    )
)
@Composable
fun WgcExtraBottomNav(
    selectedItem: WgcExtraNavItem,
    onItemSelected: (WgcExtraNavItem) -> Unit,
    modifier: Modifier = Modifier
) {
    val items = remember {
        WgcExtraNavItem.entries.map { item ->
            WgcNavItem(route = item.name, label = item.label, icon = item.icon)
        }
    }
    WgcBottomNavBar(
        items = items,
        selectedRoute = selectedItem.name,
        onItemSelected = { navItem ->
            val match = WgcExtraNavItem.entries.firstOrNull { it.name == navItem.route }
            if (match != null) onItemSelected(match)
        },
        modifier = modifier.border(
            width = WgcCoreDsSize.S1.dp,
            color = Color(WgcCoreDsColors.blueLight6)
        ),
        selectedColor = Color(WgcCoreDsColors.red12),
        unselectedColor = Color(WgcCoreDsColors.blue27),
        indicatorColor = Color(WgcCoreDsColors.redLight4)
    )
}

@Preview(name = "Clube Extra Bottom Nav - Preview")
@Composable
fun WgcExtraBottomNavPreview() {
    WgcExtraBottomNav(
        selectedItem = WgcExtraNavItem.HOME,
        onItemSelected = {}
    )
}
