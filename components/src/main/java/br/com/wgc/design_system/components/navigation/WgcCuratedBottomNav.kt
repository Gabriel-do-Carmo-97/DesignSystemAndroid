package br.com.wgc.design_system.components.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material.icons.outlined.Storefront
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.theme.WgcCoreDsColors
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing

/**
 * Barra de navegação inferior oficial do ecossistema Tassel (WgcCuratedBottomNav).
 */
@Deprecated(
    message = "Utilize WgcBottomNavBar com lista dinâmica de WgcNavItem",
    replaceWith = ReplaceWith("WgcBottomNavBar(items = items, selectedIndex = selectedIndex, onItemSelected = onItemSelected)")
)
@Composable
fun WgcCuratedBottomNav(
    modifier: Modifier = Modifier,
    selectedIndex: Int = 1,
    onItemSelected: (Int) -> Unit = {}
) {
    val items = remember {
        listOf(
            WgcNavItem("home", "Home", Icons.Outlined.Home, Icons.Filled.Home),
            WgcNavItem("market", "Market", Icons.Outlined.Storefront, Icons.Filled.Storefront),
            WgcNavItem("bag", "Bag", Icons.Outlined.ShoppingBag, Icons.Filled.ShoppingBag),
            WgcNavItem("profile", "Profile", Icons.Outlined.Person, Icons.Filled.Person)
        )
    }
    WgcBottomNavBar(
        items = items,
        selectedIndex = selectedIndex,
        onItemSelected = onItemSelected,
        modifier = modifier,
        containerColor = Color.White,
        selectedColor = Color(WgcCoreDsColors.blue37),
        unselectedColor = Color(WgcCoreDsColors.gray10),
        indicatorColor = Color.Transparent,
        tonalElevation = WgcCoreDsSpacing.NONE0.dp
    )
}

@Preview(showBackground = true)
@Composable
private fun WgcTasselBottomNavPreview() {
    WgcCuratedBottomNav()
}
