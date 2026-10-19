package br.com.wgc.design_system.components.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.theme.WgcCoreDsColors
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing

/**
 * Barra de navegação inferior oficial do ecossistema Nexkart (WgcGadgetShopBottomNav).
 */
@Deprecated(
    message = "Utilize WgcBottomNavBar com lista dinâmica de WgcNavItem",
    replaceWith = ReplaceWith(
        "WgcBottomNavBar(items = items, selectedIndex = selectedIndex, onItemSelected = onItemSelected)"
    )
)
@Composable
fun WgcGadgetShopBottomNav(
    modifier: Modifier = Modifier,
    selectedIndex: Int = 0,
    cartItemCount: Int = 3,
    onItemSelected: (Int) -> Unit = {}
) {
    val items = remember(cartItemCount) {
        listOf(
            WgcNavItem("home", "Home", Icons.Outlined.Home, Icons.Filled.Home),
            WgcNavItem("wishlist", "Wishlist", Icons.Outlined.FavoriteBorder, Icons.Filled.Favorite),
            WgcNavItem(
                route = "cart",
                label = "Cart",
                icon = Icons.Outlined.ShoppingBag,
                selectedIcon = Icons.Filled.ShoppingBag,
                badgeCount = if (cartItemCount > 0) cartItemCount else null
            ),
            WgcNavItem("profile", "Profile", Icons.Outlined.Person, Icons.Filled.Person)
        )
    }
    WgcBottomNavBar(
        items = items,
        selectedIndex = selectedIndex,
        onItemSelected = onItemSelected,
        modifier = modifier,
        containerColor = Color.White,
        selectedColor = Color(WgcCoreDsColors.blue39),
        unselectedColor = Color(WgcCoreDsColors.blue41),
        indicatorColor = Color(WgcCoreDsColors.blueLight31),
        tonalElevation = WgcCoreDsSpacing.NONE0.dp
    )
}

@Preview(showBackground = true)
@Composable
private fun WgcNexkartBottomNavPreview() {
    WgcGadgetShopBottomNav()
}
