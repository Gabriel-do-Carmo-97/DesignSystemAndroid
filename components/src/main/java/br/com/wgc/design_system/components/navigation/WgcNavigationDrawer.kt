@file:Suppress("LongMethod")

package br.com.wgc.design_system.components.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Gaveta de navegação lateral (WgcNavigationDrawer).
 */
@Composable
fun WgcNavigationDrawer(
    drawerState: DrawerState,
    items: List<WgcNavItem>,
    selectedRoute: String,
    onItemSelected: (WgcNavItem) -> Unit,
    modifier: Modifier = Modifier,
    headerSlot: (@Composable () -> Unit)? = null,
    footerSlot: (@Composable () -> Unit)? = null,
    content: @Composable () -> Unit
) {
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(modifier = Modifier.width(300.dp)) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(WgcCoreDsSpacing.md.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        headerSlot?.invoke()
                        if (headerSlot != null) {
                            HorizontalDivider(modifier = Modifier.padding(vertical = WgcCoreDsSpacing.md.dp))
                        }
                        items.forEach { item ->
                            val isSelected = item.route == selectedRoute
                            NavigationDrawerItem(
                                label = { Text(text = item.label) },
                                icon = {
                                    Icon(
                                        imageVector = if (isSelected) item.selectedIcon else item.icon,
                                        contentDescription = item.label
                                    )
                                },
                                selected = isSelected,
                                onClick = { onItemSelected(item) },
                                modifier = Modifier.padding(vertical = WgcCoreDsSpacing.xxs.dp)
                            )
                        }
                    }
                    footerSlot?.invoke()
                }
            }
        },
        modifier = modifier,
        content = content
    )
}
