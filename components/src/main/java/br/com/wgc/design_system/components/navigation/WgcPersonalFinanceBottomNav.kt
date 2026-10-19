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
import br.com.wgc.design_system.core.theme.WgcCoreDsColors
import br.com.wgc.design_system.core.tokens.WgcCoreDsSize
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing

/**
 * Barra de navegação inferior padrão Organizze com FAB central elevado para novos lançamentos.
 */
@Deprecated(
    message = "Utilize WgcMenuFactory com WgcMenuType.ProminentCenter ou WgcBottomNavBar",
    replaceWith = ReplaceWith("WgcMenuFactory(type = WgcMenuType.ProminentCenter)")
)
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
            shadowElevation = WgcCoreDsSpacing.XS8.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = WgcCoreDsSpacing.MD16.dp,
                        vertical = WgcCoreDsSpacing.XS8.dp
                    ),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                NavItemButton(
                    item = WgcOrganizzeNavItem.Dashboard,
                    isSelected = selectedItem == WgcOrganizzeNavItem.Dashboard,
                    onClick = { onItemSelected(WgcOrganizzeNavItem.Dashboard) }
                )
                NavItemButton(
                    item = WgcOrganizzeNavItem.Transactions,
                    isSelected = selectedItem == WgcOrganizzeNavItem.Transactions,
                    onClick = { onItemSelected(WgcOrganizzeNavItem.Transactions) }
                )
                Box(modifier = Modifier.size(WgcCoreDsSize.S48.dp))
                NavItemButton(
                    item = WgcOrganizzeNavItem.Reports,
                    isSelected = selectedItem == WgcOrganizzeNavItem.Reports,
                    onClick = { onItemSelected(WgcOrganizzeNavItem.Reports) }
                )
                NavItemButton(
                    item = WgcOrganizzeNavItem.Cards,
                    isSelected = selectedItem == WgcOrganizzeNavItem.Cards,
                    onClick = { onItemSelected(WgcOrganizzeNavItem.Cards) }
                )
            }
        }
        WgcPersonalFinanceFab(onAddClick = onAddClick)
    }
}

@Composable
private fun WgcPersonalFinanceFab(onAddClick: () -> Unit) {
    Box(
        modifier = Modifier
            .offset(y = (-WgcCoreDsSpacing.MD16).dp)
            .size(WgcCoreDsSize.S56.dp)
            .shadow(elevation = WgcCoreDsSpacing.XS8.dp, shape = CircleShape)
            .clip(CircleShape)
            .background(Color(WgcCoreDsColors.cyan3))
            .clickable(onClick = onAddClick),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Novo lançamento",
            tint = Color.White,
            modifier = Modifier.size(WgcCoreDsSpacing.XL32.dp)
        )
    }
}

@Composable
private fun NavItemButton(
    item: WgcOrganizzeNavItem,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val tint = if (isSelected) {
        Color(WgcCoreDsColors.cyan3)
    } else {
        Color(WgcCoreDsColors.gray11)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(WgcCoreDsSpacing.XXS4.dp)
    ) {
        Icon(
            imageVector = item.icon,
            contentDescription = item.title,
            tint = tint,
            modifier = Modifier.size(WgcCoreDsSpacing.LG24.dp)
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
