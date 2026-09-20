package br.com.wgc.design_system.components.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing

enum class WgcOrganizzeNavItem(
    val title: String,
    val icon: ImageVector
) {
    Dashboard("Visão Geral", Icons.Default.Home),
    Transactions("Lançamentos", Icons.AutoMirrored.Filled.List),
    Reports("Relatórios", Icons.Default.PieChart),
    Cards("Cartões", Icons.Default.CreditCard)
}

/**
 * Barra de navegação inferior padrão Organizze com FAB central elevado para novos lançamentos.
 */
@Composable
fun WgcPersonalFinanceBottomNav(
    modifier: Modifier = Modifier,
    selectedItem: WgcOrganizzeNavItem = WgcOrganizzeNavItem.Dashboard,
    onItemSelected: (WgcOrganizzeNavItem) -> Unit = {},
    onAddClick: () -> Unit = {}
) {
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = Color.White,
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
                // Item 1: Visão Geral
                NavItemButton(
                    item = WgcOrganizzeNavItem.Dashboard,
                    isSelected = selectedItem == WgcOrganizzeNavItem.Dashboard,
                    onClick = { onItemSelected(WgcOrganizzeNavItem.Dashboard) }
                )

                // Item 2: Lançamentos
                NavItemButton(
                    item = WgcOrganizzeNavItem.Transactions,
                    isSelected = selectedItem == WgcOrganizzeNavItem.Transactions,
                    onClick = { onItemSelected(WgcOrganizzeNavItem.Transactions) }
                )

                // Espaço para o FAB Central
                Box(modifier = Modifier.size(WgcCoreDsSize.s48.dp))

                // Item 3: Relatórios
                NavItemButton(
                    item = WgcOrganizzeNavItem.Reports,
                    isSelected = selectedItem == WgcOrganizzeNavItem.Reports,
                    onClick = { onItemSelected(WgcOrganizzeNavItem.Reports) }
                )

                // Item 4: Cartões
                NavItemButton(
                    item = WgcOrganizzeNavItem.Cards,
                    isSelected = selectedItem == WgcOrganizzeNavItem.Cards,
                    onClick = { onItemSelected(WgcOrganizzeNavItem.Cards) }
                )
            }
        }

        // FAB Central Elevado "+"
        Box(
            modifier = Modifier
                .offset(y = (-WgcCoreDsSpacing.md16).dp)
                .size(WgcCoreDsSize.s56.dp)
                .shadow(elevation = WgcCoreDsSpacing.xs8.dp, shape = CircleShape)
                .clip(CircleShape)
                .background(Color(WgcCoreDsColors.personalFinancePrimary))
                .clickable(onClick = onAddClick),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Novo lançamento",
                tint = Color.White,
                modifier = Modifier.size(WgcCoreDsSpacing.xl32.dp)
            )
        }
    }
}

@Composable
private fun NavItemButton(
    item: WgcOrganizzeNavItem,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val tint = if (isSelected) {
        Color(WgcCoreDsColors.personalFinancePrimary)
    } else {
        Color(WgcCoreDsColors.personalFinanceSecondaryText)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(WgcCoreDsSpacing.xxs4.dp)
    ) {
        Icon(
            imageVector = item.icon,
            contentDescription = item.title,
            tint = tint,
            modifier = Modifier.size(WgcCoreDsSpacing.lg24.dp)
        )
        Text(
            text = item.title,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            color = tint
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcOrganizzeBottomNavPreview() {
    WgcPersonalFinanceBottomNav()
}
