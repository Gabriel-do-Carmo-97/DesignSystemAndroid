package br.com.wgc.design_system.components.navigation

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material.icons.outlined.Storefront
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * Barra de navegação inferior oficial do ecossistema Tassel (WgcTasselBottomNav).
 * Suporta 4 abas minimalistas: Home, Market, Bag, Profile.
 */
@Composable
fun WgcTasselBottomNav(
    modifier: Modifier = Modifier,
    selectedIndex: Int = 1,
    onItemSelected: (Int) -> Unit = {}
) {
    NavigationBar(
        modifier = modifier,
        containerColor = Color.White,
        tonalElevation = WgcCoreDsSpacing.none0.dp
    ) {
        val navItems = listOf(
            Triple("Home", Icons.Outlined.Home to Icons.Filled.Home, 0),
            Triple("Market", Icons.Outlined.Storefront to Icons.Filled.Storefront, 1),
            Triple("Bag", Icons.Outlined.ShoppingBag to Icons.Filled.ShoppingBag, 2),
            Triple("Profile", Icons.Outlined.Person to Icons.Filled.Person, 3)
        )

        navItems.forEach { (title, icons, index) ->
            val isSelected = selectedIndex == index
            NavigationBarItem(
                selected = isSelected,
                onClick = { onItemSelected(index) },
                icon = {
                    Icon(
                        imageVector = if (isSelected) icons.second else icons.first,
                        contentDescription = title,
                        modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                    )
                },
                label = {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(WgcCoreDsColors.tasselPrimary),
                    selectedTextColor = Color(WgcCoreDsColors.tasselPrimary),
                    unselectedIconColor = Color(WgcCoreDsColors.tasselSecondaryText),
                    unselectedTextColor = Color(WgcCoreDsColors.tasselSecondaryText),
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcTasselBottomNavPreview() {
    WgcTasselBottomNav()
}
