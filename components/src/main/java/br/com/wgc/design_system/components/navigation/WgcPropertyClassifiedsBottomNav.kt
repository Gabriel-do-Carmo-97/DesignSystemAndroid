package br.com.wgc.design_system.components.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import br.com.wgc.design_system.core.tokens.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.theme.WgcCoreDsColors
import br.com.wgc.design_system.core.tokens.WgcCoreDsSize
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing

/**
 * Barra de navegação inferior exclusiva do Zap Imóveis.
 */
@Composable
fun WgcPropertyClassifiedsBottomNav(
    selectedDestination: WgcZapNavDestination,
    onDestinationSelect: (WgcZapNavDestination) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(WgcCoreDsColors.white))
    ) {
        HorizontalDivider(color = Color(WgcCoreDsColors.blueLight8))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = WgcCoreDsSpacing.XS8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            WgcZapNavDestination.entries.forEach { destination ->
                val isSelected = destination == selectedDestination
                val itemColor = if (isSelected) {
                    Color(WgcCoreDsColors.blueDark31)
                } else {
                    Color(WgcCoreDsColors.blue22)
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .clickable { onDestinationSelect(destination) }
                        .padding(horizontal = WgcCoreDsSpacing.SM12.dp)
                ) {
                    Icon(
                        imageVector = destination.icon,
                        contentDescription = destination.label,
                        tint = itemColor,
                        modifier = Modifier.size(WgcCoreDsSize.S24.dp)
                    )

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XXS4.dp))

                    Text(
                        text = destination.label,
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                        color = itemColor
                    )

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XXS4.dp))

                    // Indicador inferior ativo em Azul Zap
                    if (isSelected) {
                        Box(
                            modifier = Modifier
                                .size(width = WgcCoreDsSize.S24.dp, height = WgcCoreDsSize.S4.dp)
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.CIRCULAR999.dp))
                                .background(Color(WgcCoreDsColors.blueDark31))
                        )
                    } else {
                        Box(modifier = Modifier.height(WgcCoreDsSize.S4.dp))
                    }
                }
            }
        }
    }
}

@Preview(name = "WgcPropertyClassifiedsBottomNav - Search Selected", showBackground = true)
@Composable
private fun WgcZapBottomNavPreview() {
    MaterialTheme {
        WgcPropertyClassifiedsBottomNav(
            selectedDestination = WgcZapNavDestination.SEARCH,
            onDestinationSelect = {}
        )
    }
}
