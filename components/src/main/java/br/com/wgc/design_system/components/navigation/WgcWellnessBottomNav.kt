package br.com.wgc.design_system.components.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material3.Icon
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
import androidx.compose.ui.unit.sp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsElevation
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Abas de navegação do Corporate Wellness (Wellness Network).
 */
enum class WgcCorporateWellnessNavItem(val label: String, val icon: ImageVector) {
    HOME("Início", Icons.Default.Home),
    EXPLORE("Academias", Icons.Default.Search),
    CHECKIN("Check-in", Icons.Default.CheckCircle),
    WELLNESS("Bem-estar", Icons.Default.Spa),
    PROFILE("Perfil", Icons.Default.Person)
}

/**
 * Barra de Navegação Inferior Corporate Wellness (Wellness Network).
 *
 * 100% tokenizada com WgcCoreDs e State Hoisting.
 */
@Composable
fun WgcWellnessBottomNav(
    selectedItem: WgcCorporateWellnessNavItem,
    onItemSelected: (WgcCorporateWellnessNavItem) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(WgcCoreDsSize.s64.dp),
        color = Color(WgcCoreDsColors.wellnessSurface),
        shadowElevation = WgcCoreDsElevation.level8.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = WgcCoreDsSpacing.xs8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            WgcCorporateWellnessNavItem.values().forEach { item ->
                val isSelected = item == selectedItem
                val itemColor = if (isSelected) Color(WgcCoreDsColors.wellnessCoral)
                else Color(WgcCoreDsColors.wellnessSecondaryText)

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                        .clickable { onItemSelected(item) }
                        .padding(horizontal = WgcCoreDsSpacing.xs8.dp, vertical = WgcCoreDsSpacing.xxs4.dp)
                ) {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label,
                        tint = itemColor,
                        modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                    )
                    Text(
                        text = item.label,
                        color = itemColor,
                        fontSize = 10.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        modifier = Modifier.padding(top = WgcCoreDsSpacing.xxxs2.dp)
                    )
                }
            }
        }
    }
}

@Preview(name = "Corporate Wellness Bottom Nav Preview")
@Composable
fun WgcCorporateWellnessBottomNavPreview() {
    WgcWellnessBottomNav(
        selectedItem = WgcCorporateWellnessNavItem.HOME,
        onItemSelected = {}
    )
}
