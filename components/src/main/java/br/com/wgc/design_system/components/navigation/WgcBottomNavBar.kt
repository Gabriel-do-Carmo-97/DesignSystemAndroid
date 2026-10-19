package br.com.wgc.design_system.components.navigation

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.commons.previews.components.WgcComponentPreviews
import br.com.wgc.design_system.core.tokens.WgcCoreDsElevation
import br.com.wgc.design_system.core.tokens.WgcCoreDsSize

/**
 * Barra de navegação inferior dinâmica baseada em rotas (WgcBottomNavBar).
 *
 * @param items Lista de itens dinâmicos de navegação
 * @param selectedRoute Rota ativa no momento
 * @param onItemSelected Callback acionado com o [WgcNavItem] selecionado
 * @param modifier Modificador de layout
 * @param containerColor Cor de fundo da barra
 * @param contentColor Cor padrão do conteúdo
 * @param selectedColor Cor do item ativo
 * @param unselectedColor Cor do item inativo
 * @param indicatorColor Cor do indicador de seleção (pill)
 * @param tonalElevation Elevação tonal da barra
 */
@Composable
fun WgcBottomNavBar(
    items: List<WgcNavItem>,
    selectedRoute: String,
    onItemSelected: (WgcNavItem) -> Unit,
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.surface,
    contentColor: Color = MaterialTheme.colorScheme.onSurface,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unselectedColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
    indicatorColor: Color = MaterialTheme.colorScheme.secondaryContainer,
    tonalElevation: Dp = WgcCoreDsElevation.LEVEL3.dp
) {
    NavigationBar(
        modifier = modifier,
        containerColor = containerColor,
        contentColor = contentColor,
        tonalElevation = tonalElevation
    ) {
        items.forEach { item ->
            val isSelected = item.route == selectedRoute
            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    onItemSelected(item)
                    item.onClick?.invoke()
                },
                icon = {
                    if (item.badgeCount != null && item.badgeCount > 0) {
                        BadgedBox(
                            badge = {
                                Badge {
                                    Text(text = if (item.badgeCount > 99) "99+" else item.badgeCount.toString())
                                }
                            }
                        ) {
                            Icon(
                                imageVector = if (isSelected) item.selectedIcon else item.icon,
                                contentDescription = item.label,
                                modifier = Modifier.size(WgcCoreDsSize.S24.dp)
                            )
                        }
                    } else {
                        Icon(
                            imageVector = if (isSelected) item.selectedIcon else item.icon,
                            contentDescription = item.label,
                            modifier = Modifier.size(WgcCoreDsSize.S24.dp)
                        )
                    }
                },
                label = {
                    Text(
                        text = item.label,
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = selectedColor,
                    selectedTextColor = selectedColor,
                    unselectedIconColor = unselectedColor,
                    unselectedTextColor = unselectedColor,
                    indicatorColor = indicatorColor
                )
            )
        }
    }
}

/**
 * Sobrecarga indexada da barra de navegação inferior dinâmica (WgcBottomNavBar).
 *
 * @param items Lista de itens dinâmicos de navegação
 * @param selectedIndex Índice selecionado atualmente
 * @param onItemSelected Callback acionado com o índice selecionado
 * @param modifier Modificador de layout
 * @param containerColor Cor de fundo da barra
 * @param contentColor Cor padrão do conteúdo
 * @param selectedColor Cor do item ativo
 * @param unselectedColor Cor do item inativo
 * @param indicatorColor Cor do indicador de seleção (pill)
 * @param tonalElevation Elevação tonal da barra
 */
@Composable
fun WgcBottomNavBar(
    items: List<WgcNavItem>,
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.surface,
    contentColor: Color = MaterialTheme.colorScheme.onSurface,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unselectedColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
    indicatorColor: Color = MaterialTheme.colorScheme.secondaryContainer,
    tonalElevation: Dp = WgcCoreDsElevation.LEVEL3.dp
) {
    val selectedRoute = items.getOrNull(selectedIndex)?.route ?: ""
    WgcBottomNavBar(
        items = items,
        selectedRoute = selectedRoute,
        onItemSelected = { item ->
            val index = items.indexOf(item)
            if (index >= 0) {
                onItemSelected(index)
            }
        },
        modifier = modifier,
        containerColor = containerColor,
        contentColor = contentColor,
        selectedColor = selectedColor,
        unselectedColor = unselectedColor,
        indicatorColor = indicatorColor,
        tonalElevation = tonalElevation
    )
}

/**
 * Barra de navegação inferior do Design System (WgcBottomNavBar).
 * Delega para a fábrica corporativa [WgcMenuFactory] unificando estilos e tokens.
 *
 * @param modifier Modificador de layout
 * @param items Lista de itens de navegação (2 a 5 itens com suporte a badge e destaque)
 * @param selectedIndex Índice selecionado atualmente
 * @param type Tipo de menu ([WgcMenuType.ClassicBottomBar], [WgcMenuType.ProminentCenter], etc.)
 * @param onItemSelected Callback acionado na seleção de item
 */
@Composable
fun WgcBottomNavBar(
    modifier: Modifier = Modifier,
    items: List<NavItem>,
    selectedIndex: Int,
    type: WgcMenuType = WgcMenuType.ClassicBottomBar,
    onItemSelected: (Int) -> Unit = {}
) {
    WgcMenuFactory(
        modifier = modifier,
        type = type,
        items = items.mapIndexed { index, navItem ->
            WgcMenuItem(
                id = index.toString(),
                label = navItem.label,
                icon = navItem.icon,
                badgeCount = navItem.badgeCount,
                isProminent = navItem.isProminent,
                onClick = navItem.onClick
            )
        },
        selectedIndex = selectedIndex,
        onItemSelected = { index ->
            onItemSelected(index)
            if (index in items.indices) {
                items[index].onClick()
            }
        }
    )
}

@Preview(showBackground = true)
@WgcComponentPreviews
@Composable
private fun WgcBottomNavBarPreview() {
    MaterialTheme {
        Surface {
            val sampleItems = listOf(
                NavItem(label = "Início", icon = Icons.Default.Home, onClick = {}),
                NavItem(label = "Buscar", icon = Icons.Default.Search, onClick = {}),
                NavItem(label = "Pedidos", icon = Icons.Default.Receipt, badgeCount = 3, onClick = {}),
                NavItem(label = "Perfil", icon = Icons.Default.Person, onClick = {})
            )
            WgcBottomNavBar(
                items = sampleItems,
                selectedIndex = 0,
                type = WgcMenuType.ClassicBottomBar,
                onItemSelected = {}
            )
        }
    }
}
