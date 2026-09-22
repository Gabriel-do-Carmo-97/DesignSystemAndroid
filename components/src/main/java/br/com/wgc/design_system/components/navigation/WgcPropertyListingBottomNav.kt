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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubbleOutline
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
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
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Destinos oficiais de navegação do PropertyListing.
 */
enum class WgcPropertyListingNavItem(
    val title: String,
    val icon: ImageVector
) {
    Search("Buscar", Icons.Default.Search),
    Favorites("Favoritos", Icons.Default.FavoriteBorder),
    Messages("Mensagens", Icons.Default.ChatBubbleOutline),
    Profile("Menu", Icons.Default.Person)
}

/**
 * Barra de navegação inferior oficial do Property Listing (WgcPropertyListingBottomNav):
 * - 4 abas principais: Buscar, Favoritos, Mensagens, Menu
 * - Indicador de aba selecionada no verde característico do Property Listing (#1C9963)
 * - Suporte a badges de mensagens não lidas e alertas de novos imóveis
 */
@Composable
fun WgcPropertyListingBottomNav(
    modifier: Modifier = Modifier,
    selectedItem: WgcPropertyListingNavItem = WgcPropertyListingNavItem.Search,
    onItemSelected: (WgcPropertyListingNavItem) -> Unit = {},
    messagesBadgeCount: Int = 0,
    favoritesBadgeCount: Int = 0
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = Color(WgcCoreDsColors.propertyListingSurface),
        shadowElevation = WgcCoreDsSpacing.xs8.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = WgcCoreDsSpacing.md16.dp,
                    vertical = WgcCoreDsSpacing.xs8.dp
                ),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            WgcPropertyListingNavItem.entries.forEach { item ->
                val isSelected = selectedItem == item
                val badgeCount = when (item) {
                    WgcPropertyListingNavItem.Messages -> messagesBadgeCount
                    WgcPropertyListingNavItem.Favorites -> favoritesBadgeCount
                    else -> 0
                }

                PropertyListingNavItemButton(
                    item = item,
                    isSelected = isSelected,
                    badgeCount = badgeCount,
                    onClick = { onItemSelected(item) }
                )
            }
        }
    }
}

@Composable
private fun PropertyListingNavItemButton(
    item: WgcPropertyListingNavItem,
    isSelected: Boolean,
    badgeCount: Int,
    onClick: () -> Unit
) {
    val activeColor = Color(WgcCoreDsColors.propertyListingPrimary)
    val inactiveColor = Color(WgcCoreDsColors.propertyListingSecondaryText)
    val contentColor = if (isSelected) activeColor else inactiveColor

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
            .clickable(onClick = onClick)
            .padding(
                horizontal = WgcCoreDsSpacing.sm12.dp,
                vertical = WgcCoreDsSpacing.xxs4.dp
            )
    ) {
        Box(contentAlignment = Alignment.TopEnd) {
            Icon(
                imageVector = item.icon,
                contentDescription = item.title,
                tint = contentColor,
                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
            )

            if (badgeCount > 0) {
                Box(
                    modifier = Modifier
                        .size(WgcCoreDsSize.s14.dp)
                        .clip(CircleShape)
                        .background(Color(WgcCoreDsColors.propertyListingOrange)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = if (badgeCount > 9) "9+" else badgeCount.toString(),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))

        Text(
            text = item.title,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
            color = contentColor
        )

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))

        // Indicador em linha no verde Property Listing
        Box(
            modifier = Modifier
                .size(width = WgcCoreDsSize.s16.dp, height = WgcCoreDsSize.s2.dp)
                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                .background(
                    if (isSelected) activeColor else Color.Transparent
                )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcPropertyListingBottomNavPreview() {
    WgcPropertyListingBottomNav(
        selectedItem = WgcPropertyListingNavItem.Search,
        messagesBadgeCount = 2
    )
}
