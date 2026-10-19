package br.com.wgc.design_system.components.navigation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.core.theme.WgcCoreDsColors

/**
 * Barra de navegação inferior exclusiva do Zap Imóveis.
 */
@Deprecated(
    message = "Utilize WgcBottomNavBar com lista dinâmica de WgcNavItem",
    replaceWith = ReplaceWith(
        "WgcBottomNavBar(items = items, selectedRoute = selectedDestination.name, onItemSelected = { ... })"
    )
)
@Composable
fun WgcPropertyClassifiedsBottomNav(
    selectedDestination: WgcZapNavDestination,
    onDestinationSelect: (WgcZapNavDestination) -> Unit,
    modifier: Modifier = Modifier
) {
    val items = remember {
        WgcZapNavDestination.entries.map { item ->
            WgcNavItem(route = item.name, label = item.label, icon = item.icon)
        }
    }
    WgcBottomNavBar(
        items = items,
        selectedRoute = selectedDestination.name,
        onItemSelected = { navItem ->
            val match = WgcZapNavDestination.entries.firstOrNull { it.name == navItem.route }
            if (match != null) onDestinationSelect(match)
        },
        modifier = modifier,
        containerColor = Color(WgcCoreDsColors.white),
        selectedColor = Color(WgcCoreDsColors.blueDark31),
        unselectedColor = Color(WgcCoreDsColors.blue22),
        indicatorColor = Color.Transparent
    )
}

@Preview(name = "WgcPropertyClassifiedsBottomNav - Search Selected", showBackground = true)
@Composable
private fun WgcZapBottomNavPreview() {
    MaterialTheme {
        WgcPropertyClassifiedsBottomNav(
            selectedDestination = WgcZapNavDestination.SEARCH,
            onDestinationSelect = {}
        )
    }
}
