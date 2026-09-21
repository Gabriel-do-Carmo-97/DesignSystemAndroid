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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import br.com.wgc.design_system.components.badge.WgcBadge
import br.com.wgc.design_system.components.badge.WgcBadgedBox
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsElevation
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Variantes de menu suportadas pela WgcMenuFactory.
 */
enum class WgcMenuType {
    ClassicBottomBar,
    FloatingPill,
    CollapsibleHeader,
    ProminentCenter
}

/**
 * Item de menu universal para fábricas de navegação.
 *
 * @param id Identificador único do item
 * @param label Rótulo textual
 * @param icon Ícone visual
 * @param badgeCount Contagem opcional para notificação/carrinho
 * @param isProminent Se verdadeiro, eleva o ícone em formato FAB na barra estilo e-commerce
 * @param onClick Ação executada ao clicar no item
 */
data class WgcMenuItem(
    val id: String = "",
    val label: String,
    val icon: ImageVector,
    val badgeCount: Int = 0,
    val isProminent: Boolean = false,
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
 * Retorna itens padrão para e-commerce com botão central de carrinho elevado.
 */
fun defaultWgcProminentMenuItems(): List<WgcMenuItem> = listOf(
    WgcMenuItem(id = "home", label = "Início", icon = Icons.Default.Home),
    WgcMenuItem(id = "search", label = "Buscar", icon = Icons.Default.Search),
    WgcMenuItem(id = "cart", label = "Carrinho", icon = Icons.Default.ShoppingCart, isProminent = true, badgeCount = 2),
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
                            if (item.badgeCount > 0) {
                                WgcBadgedBox(badge = { WgcBadge(count = item.badgeCount) }) {
                                    Icon(
                                        imageVector = item.icon,
                                        contentDescription = item.label
                                    )
                                }
                            } else {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.label
                                )
                            }
                        },
                        label = { Text(text = item.label) }
                    )
                }
            }
        }
        WgcMenuType.ProminentCenter -> {
            WgcProminentBottomBar(
                modifier = modifier,
                items = items,
                selectedIndex = selectedIndex,
                onItemSelected = onItemSelected
            )
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

/**
 * Barra de navegação inferior estilo e-commerce com botão central proeminente/elevado (Dock).
 * Ajusta-se dinamicamente para 2, 3, 4 ou 5 itens.
 *
 * @param modifier Modificador de layout
 * @param items Lista de itens de navegação (2 a 5 itens)
 * @param selectedIndex Índice do item selecionado atualmente
 * @param onItemSelected Callback acionado quando um item é selecionado
 */
@Composable
fun WgcProminentBottomBar(
    modifier: Modifier = Modifier,
    items: List<WgcMenuItem> = defaultWgcProminentMenuItems(),
    selectedIndex: Int = 0,
    onItemSelected: (Int) -> Unit = {}
) {
    val prominentIndex = remember(items) {
        val explicit = items.indexOfFirst { it.isProminent }
        if (explicit >= 0) explicit else if (items.size % 2 != 0) items.size / 2 else -1
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .align(Alignment.BottomCenter),
            color = MaterialTheme.colorScheme.surface,
            shadowElevation = WgcCoreDsElevation.level3.dp,
            shape = RoundedCornerShape(
                topStart = WgcCoreDsBorderRadius.lg12.dp,
                topEnd = WgcCoreDsBorderRadius.lg12.dp
            )
        ) {}

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(82.dp)
                .align(Alignment.BottomCenter),
            verticalAlignment = Alignment.Bottom
        ) {
            items.forEachIndexed { index, item ->
                val isSelected = selectedIndex == index
                if (index == prominentIndex) {
                    WgcProminentDockItem(
                        item = item,
                        isSelected = isSelected,
                        onClick = {
                            onItemSelected(index)
                            item.onClick()
                        },
                        modifier = Modifier.weight(1f)
                    )
                } else {
                    WgcProminentStandardItem(
                        item = item,
                        isSelected = isSelected,
                        onClick = {
                            onItemSelected(index)
                            item.onClick()
                        },
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Composable
private fun WgcProminentDockItem(
    item: WgcMenuItem,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.height(82.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Surface(
            shape = CircleShape,
            color = MaterialTheme.colorScheme.surface,
            shadowElevation = WgcCoreDsElevation.level8.dp,
            modifier = Modifier.size(62.dp)
        ) {
            Box(
                modifier = Modifier.padding(WgcCoreDsSpacing.xxs4.dp),
                contentAlignment = Alignment.Center
            ) {
                val buttonColor = if (isSelected) MaterialTheme.colorScheme.primary
                else MaterialTheme.colorScheme.primaryContainer
                val contentColor = if (isSelected) MaterialTheme.colorScheme.onPrimary
                else MaterialTheme.colorScheme.onPrimaryContainer

                Surface(
                    shape = CircleShape,
                    color = buttonColor,
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable(onClick = onClick)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        val iconContent = @Composable {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.label,
                                tint = contentColor,
                                modifier = Modifier.size(28.dp)
                            )
                        }
                        if (item.badgeCount > 0) {
                            WgcBadgedBox(badge = { WgcBadge(count = item.badgeCount) }) {
                                iconContent()
                            }
                        } else {
                            iconContent()
                        }
                    }
                }
            }
        }
        Text(
            text = item.label,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            color = if (isSelected) MaterialTheme.colorScheme.primary
            else MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = WgcCoreDsSpacing.xxs4.dp)
        )
    }
}

@Composable
private fun WgcProminentStandardItem(
    item: WgcMenuItem,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val tintColor = if (isSelected) MaterialTheme.colorScheme.primary
    else MaterialTheme.colorScheme.onSurfaceVariant

    Column(
        modifier = modifier
            .height(64.dp)
            .clickable(onClick = onClick)
            .padding(vertical = WgcCoreDsSpacing.xs8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val iconContent = @Composable {
            Icon(
                imageVector = item.icon,
                contentDescription = item.label,
                tint = tintColor
            )
        }
        if (item.badgeCount > 0) {
            WgcBadgedBox(badge = { WgcBadge(count = item.badgeCount) }) {
                iconContent()
            }
        } else {
            iconContent()
        }
        Text(
            text = item.label,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            color = tintColor
        )
    }
}

@Preview(name = "WgcMenuFactory - ProminentCenter 5 Items (E-Commerce Dock)", showBackground = true)
@Composable
private fun WgcMenuProminent5Preview() {
    MaterialTheme {
        WgcMenuFactory(
            type = WgcMenuType.ProminentCenter,
            items = defaultWgcProminentMenuItems(),
            selectedIndex = 2
        )
    }
}

@Preview(name = "WgcMenuFactory - ProminentCenter 3 Items", showBackground = true)
@Composable
private fun WgcMenuProminent3Preview() {
    MaterialTheme {
        WgcMenuFactory(
            type = WgcMenuType.ProminentCenter,
            items = listOf(
                WgcMenuItem(id = "home", label = "Início", icon = Icons.Default.Home),
                WgcMenuItem(id = "cart", label = "Pedir", icon = Icons.Default.ShoppingCart, isProminent = true, badgeCount = 1),
                WgcMenuItem(id = "profile", label = "Perfil", icon = Icons.Default.Person)
            ),
            selectedIndex = 1
        )
    }
}

