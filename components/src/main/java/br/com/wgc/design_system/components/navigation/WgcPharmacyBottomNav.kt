package br.com.wgc.design_system.components.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.EventRepeat
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingBag
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
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize

enum class PharmacyNavTab(val title: String, val icon: ImageVector) {
    HOME("Início", Icons.Default.Home),
    PRESCRIPTIONS("Receitas", Icons.Default.Description),
    SUBSCRIPTION("Assinatura", Icons.Default.EventRepeat),
    CART("Sacola", Icons.Default.ShoppingBag),
    PROFILE("Meu Perfil", Icons.Default.Person)
}

@Composable
fun WgcPharmacyBottomNav(
    selectedTab: PharmacyNavTab,
    onTabSelected: (PharmacyNavTab) -> Unit,
    modifier: Modifier = Modifier,
    cartBadgeCount: Int = 0
) {
    NavigationBar(
        modifier = modifier.background(Color(WgcCoreDsColors.pharmacyChainSurface)),
        tonalElevation = WgcCoreDsElevation.level3.dp
    ) {
        PharmacyNavTab.entries.forEach { tab ->
            val isSelected = selectedTab == tab
            NavigationBarItem(
                selected = isSelected,
                onClick = { onTabSelected(tab) },
                icon = {
                    if (tab == PharmacyNavTab.CART && cartBadgeCount > 0) {
                        BadgedBox(
                            badge = {
                                Badge(
                                    containerColor = Color(WgcCoreDsColors.pharmacyChainRed)) {
                                    Text(text = cartBadgeCount.toString())
                                }
                            }
                        ) {
                            Icon(
                                imageVector = tab.icon,
                                contentDescription = tab.title,
                                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                            )
                        }
                    } else {
                        Icon(
                            imageVector = tab.icon,
                            contentDescription = tab.title,
                            modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                        )
                    }
                },
                label = {
                    Text(
                        text = tab.title,
                        fontSize = 9.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(WgcCoreDsColors.pharmacyChainRed),
                    selectedTextColor = Color(WgcCoreDsColors.pharmacyChainRed),
                    unselectedIconColor = Color(WgcCoreDsColors.pharmacyChainTextSecondary),
                    unselectedTextColor = Color(WgcCoreDsColors.pharmacyChainTextSecondary),
                    indicatorColor = Color(WgcCoreDsColors.pharmacyChainRedLight)
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcPharmacyBottomNavPreview() {
    WgcPharmacyBottomNav(
        selectedTab = PharmacyNavTab.HOME,
        onTabSelected = {},
        cartBadgeCount = 2
    )
}
