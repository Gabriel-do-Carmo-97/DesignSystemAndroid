package br.com.wgc.design_system.components.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsElevation
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Variantes de menu suportadas pela WgcMenuFactory.
 */
enum class WgcMenuType {
    ClassicBottomBar,
    FloatingPill,
    CollapsibleHeader
}

/**
 * Item de menu universal para fábricas de navegação.
 */
data class WgcMenuItem(
    val id: String = "",
    val label: String,
    val icon: ImageVector,
    val badgeCount: Int = 0,
    val onClick: () -> Unit = {}
)

/**
 * Retorna os itens de navegação padrão de produção.
 */
fun defaultWgcMenuItems(): List<WgcMenuItem> = listOf(
    WgcMenuItem(id = "home", label = "Início", icon = Icons.Default.Home),
    WgcMenuItem(id = "search", label = "Buscar", icon = Icons.Default.Search),
    WgcMenuItem(id = "orders", label = "Pedidos", icon = Icons.Default.Receipt),
    WgcMenuItem(id = "profile", label = "Perfil", icon = Icons.Default.Person)
)

/**
 * Fábrica Universal de Menus do Design System (WgcMenuFactory).
 * Provê alternância imediata entre [WgcMenuType] com defaults completos
 * e suporte a custom slot replacement ([customMenuSlot]).
 */
@Composable
fun WgcMenuFactory(
    modifier: Modifier = Modifier,
    type: WgcMenuType = WgcMenuType.ClassicBottomBar,
    items: List<WgcMenuItem> = defaultWgcMenuItems(),
    selectedIndex: Int = 0,
    onItemSelected: (Int) -> Unit = {},
    customMenuSlot: (@Composable () -> Unit)? = null
) {
    if (customMenuSlot != null) {
        customMenuSlot()
        return
    }

    when (type) {
        WgcMenuType.ClassicBottomBar -> {
            NavigationBar(
                modifier = modifier.fillMaxWidth(),
                containerColor = MaterialTheme.colorScheme.surface,
                tonalElevation = WgcCoreDsElevation.level3.dp
            ) {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = {
                            onItemSelected(index)
                            item.onClick()
                        },
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.label
                            )
                        },
                        label = { Text(text = item.label) }
                    )
                }
            }
        }
        WgcMenuType.FloatingPill -> {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(WgcCoreDsSpacing.md16.dp),
                contentAlignment = Alignment.Center
            ) {
                Surface(
                    shape = CircleShape,
                    shadowElevation = WgcCoreDsElevation.level6.dp,
                    color = MaterialTheme.colorScheme.surface
                ) {
                    Row(
                        modifier = Modifier.padding(
                            horizontal = WgcCoreDsSpacing.sm12.dp,
                            vertical = WgcCoreDsSpacing.xs8.dp
                        ),
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        items.forEachIndexed { index, item ->
                            val isSelected = selectedIndex == index
                            val backgroundModifier = if (isSelected) {
                                Modifier
                                    .clip(CircleShape)
                                    .background(MaterialTheme.colorScheme.primary)
                            } else {
                                Modifier.clip(CircleShape)
                            }

                            Row(
                                modifier = Modifier
                                    .then(backgroundModifier)
                                    .clickable {
                                        onItemSelected(index)
                                        item.onClick()
                                    }
                                    .padding(
                                        horizontal = WgcCoreDsSpacing.sm12.dp,
                                        vertical = WgcCoreDsSpacing.xs8.dp
                                    ),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                            ) {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.label,
                                    tint = if (isSelected) MaterialTheme.colorScheme.onPrimary
                                    else MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                if (isSelected) {
                                    Text(
                                        text = item.label,
                                        color = MaterialTheme.colorScheme.onPrimary,
                                        style = MaterialTheme.typography.labelMedium
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
        WgcMenuType.CollapsibleHeader -> {
            @Suppress("DEPRECATION")
            ScrollableTabRow(
                selectedTabIndex = selectedIndex.coerceIn(0, (items.size - 1).coerceAtLeast(0)),
                modifier = modifier.fillMaxWidth(),
                edgePadding = WgcCoreDsSpacing.md16.dp,
                containerColor = MaterialTheme.colorScheme.surface
            ) {
                items.forEachIndexed { index, item ->
                    Tab(
                        selected = selectedIndex == index,
                        onClick = {
                            onItemSelected(index)
                            item.onClick()
                        },
                        text = { Text(item.label) },
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.label
                            )
                        }
                    )
                }
            }
        }
    }
}

@Preview(name = "WgcMenuFactory - ClassicBottomBar", showBackground = true)
@Composable
private fun WgcMenuClassicPreview() {
    MaterialTheme {
        WgcMenuFactory(
            type = WgcMenuType.ClassicBottomBar,
            selectedIndex = 0
        )
    }
}

@Preview(name = "WgcMenuFactory - FloatingPill", showBackground = true)
@Composable
private fun WgcMenuFloatingPillPreview() {
    MaterialTheme {
        WgcMenuFactory(
            type = WgcMenuType.FloatingPill,
            selectedIndex = 1
        )
    }
}

@Preview(name = "WgcMenuFactory - CollapsibleHeader", showBackground = true)
@Composable
private fun WgcMenuHeaderPreview() {
    MaterialTheme {
        WgcMenuFactory(
            type = WgcMenuType.CollapsibleHeader,
            selectedIndex = 2
        )
    }
}
