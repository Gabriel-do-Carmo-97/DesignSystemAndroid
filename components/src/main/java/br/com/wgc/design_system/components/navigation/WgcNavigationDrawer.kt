@file:Suppress("LongMethod")

package br.com.wgc.design_system.components.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing
import br.com.wgc.design_system.commons.previews.components.WgcComponentPreviews
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search

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
                        .padding(WgcCoreDsSpacing.MD.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        headerSlot?.invoke()
                        if (headerSlot != null) {
                            HorizontalDivider(modifier = Modifier.padding(vertical = WgcCoreDsSpacing.MD.dp))
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
                                modifier = Modifier.padding(vertical = WgcCoreDsSpacing.XXS.dp)
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

@WgcComponentPreviews
@Composable
private fun WgcModalNavigationDrawerPreview() {
    MaterialTheme {
        Surface {
            val drawerState = rememberDrawerState(initialValue = DrawerValue.Open)
            val items = listOf(
                WgcNavItem(route = "home", label = "Home", icon = Icons.Outlined.Home, selectedIcon = Icons.Filled.Home),
                WgcNavItem(route = "search", label = "Search", icon = Icons.Outlined.Search, selectedIcon = Icons.Filled.Search),
                WgcNavItem(route = "profile", label = "Profile", icon = Icons.Outlined.Person, selectedIcon = Icons.Filled.Person, badgeCount = 5)
            )
            WgcNavigationDrawer(
                drawerState = drawerState,
                items = items,
                selectedRoute = "home",
                onItemSelected = {},
                headerSlot = {
                    Text(
                        text = "WGC Design System",
                        style = MaterialTheme.typography.titleMedium
                    )
                },
                footerSlot = {
                    Text(
                        text = "Version 1.0.0",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            ) {
                Text(
                    text = "Main Content",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}
