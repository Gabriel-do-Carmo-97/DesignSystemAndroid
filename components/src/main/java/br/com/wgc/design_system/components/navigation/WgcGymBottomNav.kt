package br.com.wgc.design_system.components.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.theme.WgcCoreDsColors
import br.com.wgc.design_system.core.tokens.WgcCoreDsElevation

/**
 * Barra de navegação inferior Gym & Fitness.
 */
@Deprecated(
    message = "Utilize WgcBottomNavBar com WgcNavPresets.gym ou lista dinâmica de WgcNavItem",
    replaceWith = ReplaceWith(
        "WgcBottomNavBar(items = WgcNavPresets.gym, selectedRoute = selectedItem.name, onItemSelected = { ... })"
    )
)
@Composable
fun WgcGymBottomNav(
    selectedItem: WgcGymFitnessNavItem,
    onItemSelected: (WgcGymFitnessNavItem) -> Unit,
    modifier: Modifier = Modifier
) {
    val items = remember {
        WgcGymFitnessNavItem.values().map { item ->
            WgcNavItem(route = item.name, label = item.label, icon = item.icon)
        }
    }
    WgcBottomNavBar(
        items = items,
        selectedRoute = selectedItem.name,
        onItemSelected = { navItem ->
            val match = WgcGymFitnessNavItem.values().firstOrNull { it.name == navItem.route }
            if (match != null) onItemSelected(match)
        },
        modifier = modifier,
        containerColor = Color(WgcCoreDsColors.grayDark7),
        selectedColor = Color(WgcCoreDsColors.orange23),
        unselectedColor = Color(WgcCoreDsColors.gray16),
        indicatorColor = Color.Transparent,
        tonalElevation = WgcCoreDsElevation.LEVEL8.dp
    )
}

@Preview(name = "GymFitness Bottom Nav Preview")
@Composable
fun WgcGymFitnessBottomNavPreview() {
    WgcGymBottomNav(
        selectedItem = WgcGymFitnessNavItem.HOME,
        onItemSelected = {}
    )
}
