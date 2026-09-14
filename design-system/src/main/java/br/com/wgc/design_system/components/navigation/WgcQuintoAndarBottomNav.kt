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
import androidx.compose.material.icons.filled.CalendarToday
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
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * Destinos de navegação oficiais do ecossistema QuintoAndar.
 */
enum class WgcQuintoAndarNavItem(
    val title: String,
    val icon: ImageVector
) {
    Explore("Explorar", Icons.Default.Search),
    Favorites("Favoritos", Icons.Default.FavoriteBorder),
    Visits("Visitas", Icons.Default.CalendarToday),
    Messages("Mensagens", Icons.Default.ChatBubbleOutline),
    Profile("Perfil", Icons.Default.Person)
}

/**
 * Barra de navegação inferior oficial do QuintoAndar (WgcQuintoAndarBottomNav):
 * - 5 abas principais: Explorar, Favoritos, Visitas, Mensagens, Perfil
 * - Indicador de aba selecionada com ponto/barra de destaque amarela QuintoAndar
 * - Suporte a badge de contagem de visitas ou mensagens não lidas
 */
@Composable
fun WgcQuintoAndarBottomNav(
    modifier: Modifier = Modifier,
    selectedItem: WgcQuintoAndarNavItem = WgcQuintoAndarNavItem.Explore,
    onItemSelected: (WgcQuintoAndarNavItem) -> Unit = {},
    visitsBadgeCount: Int = 0,
    messagesBadgeCount: Int = 0
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = Color(WgcCoreDsColors.quintoAndarSurface),
        shadowElevation = WgcCoreDsSpacing.xs8.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = WgcCoreDsSpacing.xs8.dp,
                    vertical = WgcCoreDsSpacing.xs8.dp
                ),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            WgcQuintoAndarNavItem.entries.forEach { item ->
                val isSelected = selectedItem == item
                val badgeCount = when (item) {
                    WgcQuintoAndarNavItem.Visits -> visitsBadgeCount
                    WgcQuintoAndarNavItem.Messages -> messagesBadgeCount
                    else -> 0
                }

                QuintoAndarNavItemButton(
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
private fun QuintoAndarNavItemButton(
    item: WgcQuintoAndarNavItem,
    isSelected: Boolean,
    badgeCount: Int,
    onClick: () -> Unit
) {
    val activeColor = Color(WgcCoreDsColors.quintoAndarPrimary)
    val inactiveColor = Color(WgcCoreDsColors.quintoAndarSecondaryText)
    val contentColor = if (isSelected) activeColor else inactiveColor

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
            .clickable(onClick = onClick)
            .padding(
                horizontal = WgcCoreDsSpacing.xs8.dp,
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
                        .background(Color(WgcCoreDsColors.quintoAndarCoral)),
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

        // Barra de destaque amarela na aba ativa
        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
        Box(
            modifier = Modifier
                .size(width = WgcCoreDsSize.s16.dp, height = WgcCoreDsSize.s2.dp)
                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                .background(
                    if (isSelected) Color(WgcCoreDsColors.quintoAndarYellow) else Color.Transparent
                )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcQuintoAndarBottomNavPreview() {
    WgcQuintoAndarBottomNav(
        selectedItem = WgcQuintoAndarNavItem.Explore,
        visitsBadgeCount = 1,
        messagesBadgeCount = 2
    )
}
