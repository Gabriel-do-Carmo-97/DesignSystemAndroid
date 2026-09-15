package br.com.wgc.design_system.components.navigation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Diamond
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalBar
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * Itens da barra de navegação inferior do Pão de Açúcar Mais.
 */
enum class WgcPdaNavItem(val label: String, val icon: ImageVector) {
    HOME("Início", Icons.Default.Home),
    ADEGA("Adega", Icons.Default.LocalBar),
    DISCOUNTS("Descontos", Icons.Default.LocalOffer),
    CART("Carrinho", Icons.Default.ShoppingCart),
    CLIENTE_MAIS("Cliente Mais", Icons.Default.Diamond)
}

/**
 * Barra de navegação inferior do Pão de Açúcar Mais.
 *
 * Apresenta design premium com acabamento verde floresta e detalhes dourados.
 */
@Composable
fun WgcPdaBottomNav(
    selectedItem: Int,
    onItemSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier.border(
            width = WgcCoreDsSize.s1.dp,
            color = Color(WgcCoreDsColors.pdaBorder)
        ),
        containerColor = Color(WgcCoreDsColors.pdaSurface),
        contentColor = Color(WgcCoreDsColors.pdaGreenDark)
    ) {
        WgcPdaNavItem.entries.forEachIndexed { index, item ->
            val isSelected = selectedItem == index
            NavigationBarItem(
                selected = isSelected,
                onClick = { onItemSelected(index) },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label,
                        modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                    )
                },
                label = {
                    Text(
                        text = item.label,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        style = MaterialTheme.typography.labelSmall
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(WgcCoreDsColors.pdaGreenDark),
                    selectedTextColor = Color(WgcCoreDsColors.pdaGreenDark),
                    unselectedIconColor = Color(WgcCoreDsColors.pdaTextSecondary),
                    unselectedTextColor = Color(WgcCoreDsColors.pdaTextSecondary),
                    indicatorColor = Color(WgcCoreDsColors.pdaGreenLight)
                )
            )
        }
    }
}

@Preview(name = "PDA Bottom Nav - Selected Adega", showBackground = true)
@Composable
private fun WgcPdaBottomNavPreview() {
    WgcPdaBottomNav(
        selectedItem = 1,
        onItemSelected = {}
    )
}
