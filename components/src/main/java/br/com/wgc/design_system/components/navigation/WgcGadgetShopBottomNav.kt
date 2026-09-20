package br.com.wgc.design_system.components.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Barra de navegação inferior oficial do ecossistema Nexkart (WgcGadgetShopBottomNav).
 * Suporta 4 abas: Home, Wishlist, Cart (com badge circular rosa de contagem) e Profile.
 */
@Composable
fun WgcGadgetShopBottomNav(
    modifier: Modifier = Modifier,
    selectedIndex: Int = 0,
    cartItemCount: Int = 3,
    onItemSelected: (Int) -> Unit = {}
) {
    NavigationBar(
        modifier = modifier,
        containerColor = Color.White,
        tonalElevation = WgcCoreDsSpacing.none0.dp
    ) {
        val navItems = listOf(
            Triple("Home", Icons.Outlined.Home to Icons.Filled.Home, 0),
            Triple("Wishlist", Icons.Outlined.FavoriteBorder to Icons.Filled.Favorite, 1),
            Triple("Cart", Icons.Outlined.ShoppingBag to Icons.Filled.ShoppingBag, 2),
            Triple("Profile", Icons.Outlined.Person to Icons.Filled.Person, 3)
        )

        navItems.forEach { (title, icons, index) ->
            val isSelected = selectedIndex == index
            NavigationBarItem(
                selected = isSelected,
                onClick = { onItemSelected(index) },
                icon = {
                    if (index == 2 && cartItemCount > 0) {
                        BadgedBox(
                            badge = {
                                Box(
                                    modifier = Modifier
                                        .size(16.dp)
                                        .clip(CircleShape)
                                        .background(Color(WgcCoreDsColors.gadgetShopAccentPink)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = cartItemCount.toString(),
                                        style = MaterialTheme.typography.labelSmall,
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        ) {
                            Icon(
                                imageVector = if (isSelected) icons.second else icons.first,
                                contentDescription = title,
                                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                            )
                        }
                    } else {
                        Icon(
                            imageVector = if (isSelected) icons.second else icons.first,
                            contentDescription = title,
                            modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                        )
                    }
                },
                label = {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(WgcCoreDsColors.gadgetShopPrimary),
                    selectedTextColor = Color(WgcCoreDsColors.gadgetShopPrimary),
                    unselectedIconColor = Color(WgcCoreDsColors.gadgetShopSecondaryText),
                    unselectedTextColor = Color(WgcCoreDsColors.gadgetShopSecondaryText),
                    indicatorColor = Color(WgcCoreDsColors.gadgetShopPrimaryLight)
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcNexkartBottomNavPreview() {
    WgcGadgetShopBottomNav()
}
