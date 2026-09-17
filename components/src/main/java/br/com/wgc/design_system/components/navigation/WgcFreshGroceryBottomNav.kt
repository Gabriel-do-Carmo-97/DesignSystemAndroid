package br.com.wgc.design_system.components.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing

enum class WgcShopperNavItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
) {
    Home("Home", Icons.Filled.Home, Icons.Outlined.Home),
    Wishlist("Wishlist", Icons.Filled.Favorite, Icons.Outlined.FavoriteBorder),
    Notification("Alerts", Icons.Filled.Notifications, Icons.Outlined.Notifications),
    Profile("Profile", Icons.Filled.Person, Icons.Outlined.Person)
}

/**
 * Bottom Navigation Bar Shopper:
 * Limpa, com ícones minimalistas e destaque verde esmeralda no item ativo.
 */
@Composable
fun WgcFreshGroceryBottomNav(
    selectedItem: WgcShopperNavItem = WgcShopperNavItem.Home,
    onItemSelected: (WgcShopperNavItem) -> Unit = {},
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = Color.White,
        shadowElevation = WgcCoreDsElevation.level1.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding()
                .height(WgcCoreDsSize.s64.dp)
                .padding(horizontal = WgcCoreDsSpacing.md16.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            WgcShopperNavItem.entries.forEach { item ->
                val isSelected = item == selectedItem
                val iconColor = if (isSelected) {
                    Color(WgcCoreDsColors.megaStorerPrimary)
                } else {
                    Color(WgcCoreDsColors.megaStorerSecondaryText)
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .clip(CircleShape)
                        .clickable { onItemSelected(item) }
                        .padding(horizontal = WgcCoreDsSpacing.sm12.dp, vertical = WgcCoreDsSpacing.xxs4.dp)
                ) {
                    Icon(
                        imageVector = if (isSelected) item.selectedIcon else item.unselectedIcon,
                        contentDescription = item.title,
                        tint = iconColor,
                        modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                    )

                    if (isSelected) {
                        Box(
                            modifier = Modifier
                                .padding(top = WgcCoreDsSpacing.xxs4.dp)
                                .size(WgcCoreDsSize.s4.dp)
                                .clip(CircleShape)
                                .background(Color(WgcCoreDsColors.megaStorerPrimary))
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcShopperBottomNavPreview() {
    WgcFreshGroceryBottomNav()
}
