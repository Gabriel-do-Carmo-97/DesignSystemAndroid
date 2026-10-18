package br.com.wgc.design_system.components.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.commons.previews.components.WgcComponentPreviews

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
