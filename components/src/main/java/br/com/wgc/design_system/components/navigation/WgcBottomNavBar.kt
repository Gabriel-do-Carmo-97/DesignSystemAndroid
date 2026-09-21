package br.com.wgc.design_system.components.navigation

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(
    val label: String,
    val icon: ImageVector,
    val badgeCount: Int = 0,
    val isProminent: Boolean = false,
    val onClick: () -> Unit
)

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

