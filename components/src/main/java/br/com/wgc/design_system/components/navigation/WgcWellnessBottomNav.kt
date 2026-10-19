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
 * Barra de Navegação Inferior Corporate Wellness (Wellness Network).
 */
@Deprecated(
    message = "Utilize WgcBottomNavBar com WgcNavPresets.wellness ou lista dinâmica de WgcNavItem",
    replaceWith = ReplaceWith(
        "WgcBottomNavBar(items = WgcNavPresets.wellness, selectedRoute = selectedItem.name, onItemSelected = { ... })"
    )
)
@Composable
fun WgcWellnessBottomNav(
    selectedItem: WgcCorporateWellnessNavItem,
    onItemSelected: (WgcCorporateWellnessNavItem) -> Unit,
    modifier: Modifier = Modifier
) {
    val items = remember {
        WgcCorporateWellnessNavItem.values().map { item ->
            WgcNavItem(route = item.name, label = item.label, icon = item.icon)
        }
    }
    WgcBottomNavBar(
        items = items,
        selectedRoute = selectedItem.name,
        onItemSelected = { navItem ->
            val match = WgcCorporateWellnessNavItem.values().firstOrNull { it.name == navItem.route }
            if (match != null) onItemSelected(match)
        },
        modifier = modifier,
        containerColor = Color(WgcCoreDsColors.white),
        selectedColor = Color(WgcCoreDsColors.red26),
        unselectedColor = Color(WgcCoreDsColors.gray7),
        indicatorColor = Color.Transparent,
        tonalElevation = WgcCoreDsElevation.LEVEL8.dp
    )
}

@Preview(name = "Corporate Wellness Bottom Nav Preview")
@Composable
fun WgcCorporateWellnessBottomNavPreview() {
    WgcWellnessBottomNav(
        selectedItem = WgcCorporateWellnessNavItem.HOME,
        onItemSelected = {}
    )
}
