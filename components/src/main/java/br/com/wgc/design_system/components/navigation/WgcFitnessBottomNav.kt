package br.com.wgc.design_system.components.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material.icons.filled.Search
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
fun WgcFitnessBottomNav(
    selectedItem: WgcFitnessNavItem,
    onItemSelected: (WgcFitnessNavItem) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier.background(Color(WgcCoreDsColors.grayDark11)),
        tonalElevation = WgcCoreDsElevation.LEVEL3.dp,
        containerColor = Color(WgcCoreDsColors.grayDark11)
    ) {
        WgcFitnessNavItem.entries.forEach { item ->
            val isSelected = selectedItem == item
            NavigationBarItem(
                selected = isSelected,
                onClick = { onItemSelected(item) },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label,
                        modifier = Modifier.size(WgcCoreDsSize.S24.dp)
                    )
                },
                label = {
                    Text(
                        text = item.label,
                        fontSize = 9.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(WgcCoreDsColors.grayDark3),
                    selectedTextColor = Color(WgcCoreDsColors.green28),
                    indicatorColor = Color(WgcCoreDsColors.green28),
                    unselectedIconColor = Color(WgcCoreDsColors.gray12),
                    unselectedTextColor = Color(WgcCoreDsColors.gray12)
                )
            )
        }
    }
}

@Preview(name = "Fitness Bottom Nav - Preview", showBackground = true)
@Composable
private fun WgcFitnessBottomNavPreview() {
    WgcFitnessBottomNav(
        selectedItem = WgcFitnessNavItem.WORKOUTS,
        onItemSelected = {}
    )
}
