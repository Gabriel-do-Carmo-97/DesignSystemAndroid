package br.com.wgc.design_system.components.navigation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
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
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSize

/**
 * Itens da barra de navegação inferior do Clube Extra.
 */
enum class WgcExtraNavItem(val label: String, val icon: ImageVector) {
    HOME("Início", Icons.Default.Home),
    DISCOUNTS("Descontos", Icons.Default.LocalOffer),
    FLYER("Folheto", Icons.AutoMirrored.Filled.MenuBook),
    CART("Carrinho", Icons.Default.ShoppingCart),
    PROFILE("Meu Perfil", Icons.Default.Person)
}

/**
 * Barra de navegação inferior do Clube Extra.
 *
 * Consome os tokens oficiais Clube Extra (`extraRed`, `extraSurface`, etc.).
 *
 * 100% tokenizado com WgcCoreDs e State Hoisting.
 */
@Composable
fun WgcExtraBottomNav(
    selectedItem: WgcExtraNavItem,
    onItemSelected: (WgcExtraNavItem) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier.border(
            width = WgcCoreDsSize.s1.dp,
            color = Color(WgcCoreDsColors.extraBorder)
        )) {
        WgcExtraNavItem.entries.forEach { item ->
            val isSelected = item == selectedItem
            NavigationBarItem(
                selected = isSelected,
                onClick = { onItemSelected(item) },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label,
                        modifier = Modifier.size(WgcCoreDsSize.s22.dp)
                    )
                },
                label = {
                    Text(
                        text = item.label,
                        fontSize = 10.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(WgcCoreDsColors.extraRed),
                    selectedTextColor = Color(WgcCoreDsColors.extraRed),
                    indicatorColor = Color(WgcCoreDsColors.extraRedLight),
                    unselectedIconColor = Color(WgcCoreDsColors.extraSecondaryText),
                    unselectedTextColor = Color(WgcCoreDsColors.extraSecondaryText)
                )
            )
        }
    }
}

@Preview(name = "Clube Extra Bottom Nav - Preview")
@Composable
fun WgcExtraBottomNavPreview() {
    WgcExtraBottomNav(
        selectedItem = WgcExtraNavItem.HOME,
        onItemSelected = {}
    )
}
