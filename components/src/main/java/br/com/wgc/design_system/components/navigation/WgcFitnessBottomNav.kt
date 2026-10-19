package br.com.wgc.design_system.components.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.core.theme.WgcCoreDsColors
import br.com.wgc.design_system.core.tokens.WgcCoreDsElevation
import androidx.compose.ui.unit.dp

/**
 * Barra de navegação inferior Fitness.
 */
@Deprecated(
    message = "Utilize WgcBottomNavBar diretamente com WgcNavPresets.fitness ou lista dinâmica de WgcNavItem",
    replaceWith = ReplaceWith(
        "WgcBottomNavBar(items = WgcNavPresets.fitness, selectedRoute = selectedItem.name, onItemSelected = { ... })"
    )
)
@Composable
fun WgcFitnessBottomNav(
    selectedItem: WgcFitnessNavItem,
    onItemSelected: (WgcFitnessNavItem) -> Unit,
    modifier: Modifier = Modifier
) {
    val items = remember {
        WgcFitnessNavItem.entries.map { item ->
            WgcNavItem(route = item.name, label = item.label, icon = item.icon)
        }
    }
    WgcBottomNavBar(
        items = items,
        selectedRoute = selectedItem.name,
        onItemSelected = { navItem ->
            val match = WgcFitnessNavItem.entries.firstOrNull { it.name == navItem.route }
            if (match != null) onItemSelected(match)
        },
        modifier = modifier,
        containerColor = Color(WgcCoreDsColors.grayDark11),
        selectedColor = Color(WgcCoreDsColors.green28),
        unselectedColor = Color(WgcCoreDsColors.gray12),
        indicatorColor = Color(WgcCoreDsColors.green28),
        tonalElevation = WgcCoreDsElevation.LEVEL3.dp
    )
}

@Preview(name = "Fitness Bottom Nav - Preview", showBackground = true)
@Composable
private fun WgcFitnessBottomNavPreview() {
    WgcFitnessBottomNav(
        selectedItem = WgcFitnessNavItem.WORKOUTS,
        onItemSelected = {}
    )
}
