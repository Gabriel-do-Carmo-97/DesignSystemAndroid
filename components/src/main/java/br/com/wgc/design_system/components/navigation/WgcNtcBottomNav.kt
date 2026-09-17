package br.com.wgc.design_system.components.navigation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ViewAgenda
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
 * Itens de navegação inferior do Nike Training Club (NTC).
 */
enum class WgcNtcNavItem(val label: String, val icon: ImageVector) {
    FOR_YOU("Para Você", Icons.Default.Home),
    WORKOUTS("Treinos", Icons.Default.FitnessCenter),
    PROGRAMS("Programas", Icons.Default.ViewAgenda),
    ACTIVITY("Atividade", Icons.Default.EmojiEvents),
    PROFILE("Perfil", Icons.Default.Person)
}

/**
 * Barra de navegação inferior do Nike Training Club (NTC).
 *
 * Estilo dark de alto contraste com indicador de seleção no icônico tom Volt da Nike.
 *
 * 100% tokenizado com WgcCoreDs e State Hoisting.
 */
@Composable
fun WgcNtcBottomNav(
    selectedItem: WgcNtcNavItem,
    onItemSelected: (WgcNtcNavItem) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier.border(
            width = WgcCoreDsSize.s1.dp,
            color = Color(WgcCoreDsColors.trainingMediumGray)
        )) {
        WgcNtcNavItem.entries.forEach { item ->
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
                    selectedIconColor = Color(WgcCoreDsColors.trainingBlack),
                    selectedTextColor = Color(WgcCoreDsColors.trainingVolt),
                    indicatorColor = Color(WgcCoreDsColors.trainingVolt),
                    unselectedIconColor = Color(WgcCoreDsColors.trainingSecondaryText),
                    unselectedTextColor = Color(WgcCoreDsColors.trainingSecondaryText)
                )
            )
        }
    }
}

@Preview(name = "NTC Bottom Nav - Preview")
@Composable
fun WgcNtcBottomNavPreview() {
    WgcNtcBottomNav(
        selectedItem = WgcNtcNavItem.WORKOUTS,
        onItemSelected = {}
    )
}
