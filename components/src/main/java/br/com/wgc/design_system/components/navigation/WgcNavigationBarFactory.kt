package br.com.wgc.design_system.components.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

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
        WgcBottomNavBar(
            items = items,
            selectedRoute = selectedRoute,
            onItemSelected = onItemSelected,
            modifier = modifier
        )
    }

    @Composable
    fun Standard(
        items: List<WgcNavItem>,
        selectedIndex: Int,
        onItemSelected: (Int) -> Unit,
        modifier: Modifier = Modifier
    ) {
        WgcBottomNavBar(
            items = items,
            selectedIndex = selectedIndex,
            onItemSelected = onItemSelected,
            modifier = modifier
        )
    }
}
