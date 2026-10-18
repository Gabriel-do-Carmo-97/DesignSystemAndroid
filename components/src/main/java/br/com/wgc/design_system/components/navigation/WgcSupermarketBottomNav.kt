package br.com.wgc.design_system.components.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.WineBar
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.design_system.core.theme.WgcCoreDsColors
import br.com.wgc.design_system.core.tokens.WgcCoreDsElevation
import br.com.wgc.design_system.core.tokens.WgcCoreDsSize

@Composable
fun WgcSupermarketBottomNav(
    selectedItem: WgcSupermarketNavItem,
    onItemSelected: (WgcSupermarketNavItem) -> Unit,
    modifier: Modifier = Modifier,
    cartBadgeCount: Int = 0
) {
    NavigationBar(
        modifier = modifier.background(Color(WgcCoreDsColors.white)),
        tonalElevation = WgcCoreDsElevation.LEVEL3.dp,
        containerColor = Color(WgcCoreDsColors.white)
    ) {
        WgcSupermarketNavItem.entries.forEach { item ->
            val isSelected = selectedItem == item
            NavigationBarItem(
                selected = isSelected,
                onClick = { onItemSelected(item) },
                icon = {
                    if (item == WgcSupermarketNavItem.CART && cartBadgeCount > 0) {
                        BadgedBox(
                            badge = {
                                Badge(containerColor = Color(WgcCoreDsColors.greenDark7)) {
                                    Text(text = cartBadgeCount.toString())
                                }
                            }
                        ) {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.label,
                                modifier = Modifier.size(WgcCoreDsSize.S24.dp)
                            )
                        }
                    } else {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.label,
                            modifier = Modifier.size(WgcCoreDsSize.S24.dp)
                        )
                    }
                },
                label = {
                    Text(
                        text = item.label,
                        fontSize = 9.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(WgcCoreDsColors.greenDark7),
                    selectedTextColor = Color(WgcCoreDsColors.greenDark7),
                    indicatorColor = Color(WgcCoreDsColors.greenLight9),
                    unselectedIconColor = Color(WgcCoreDsColors.cyan7),
                    unselectedTextColor = Color(WgcCoreDsColors.cyan7)
                )
            )
        }
    }
}

@Preview(name = "Supermarket Bottom Nav - Selected Adega", showBackground = true)
@Composable
private fun WgcSupermarketBottomNavPreview() {
    WgcSupermarketBottomNav(
        selectedItem = WgcSupermarketNavItem.ADEGA,
        onItemSelected = {},
        cartBadgeCount = 3
    )
}
