package br.com.wgc.design_system.components.tabs

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryScrollableTabRow
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.commons.WgcComponentPreviews

/**
 * Modelo de dados para aba no WgcTabRow.
 */
data class WgcTabItem(
    val id: String,
    val title: String,
    val icon: ImageVector? = null,
    val badgeCount: Int? = null
)

/**
 * WgcTabRow
 *
 * Barra de abas corporativa com suporte a layout fixo ou rolável.
 *
 * @param selectedTabIndex Índice da aba atualmente ativa (0-based).
 * @param tabs Lista de abas a serem renderizadas.
 * @param onTabSelected Callback disparado ao selecionar uma aba.
 * @param modifier Modificador de layout.
 * @param isScrollable Define se a barra de abas permite rolagem horizontal.
 */
@Composable
fun WgcTabRow(
    selectedTabIndex: Int,
    tabs: List<WgcTabItem>,
    onTabSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
    isScrollable: Boolean = false
) {
    if (isScrollable) {
        PrimaryScrollableTabRow(
            selectedTabIndex = selectedTabIndex,
            modifier = modifier.fillMaxWidth(),
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.primary,
            edgePadding = WgcCoreDsSpacing.md16.dp
        ) {
            tabs.forEachIndexed { index, tab ->
                WgcTab(
                    tab = tab,
                    selected = selectedTabIndex == index,
                    onClick = { onTabSelected(index) }
                )
            }
        }
    } else {
        PrimaryTabRow(
            selectedTabIndex = selectedTabIndex,
            modifier = modifier.fillMaxWidth(),
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.primary
        ) {
            tabs.forEachIndexed { index, tab ->
                WgcTab(
                    tab = tab,
                    selected = selectedTabIndex == index,
                    onClick = { onTabSelected(index) }
                )
            }
        }
    }
}

/**
 * Aba individual customizada com suporte a ícone, texto e contadores de badge.
 */
@Composable
fun WgcTab(
    tab: WgcTabItem,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Tab(
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        selectedContentColor = MaterialTheme.colorScheme.primary,
        unselectedContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
        text = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
            ) {
                Text(
                    text = tab.title,
                    style = MaterialTheme.typography.titleSmall
                )
                if (tab.badgeCount != null && tab.badgeCount > 0) {
                    Badge(
                        containerColor = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant,
                        contentColor = if (selected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant
                    ) {
                        Text(
                            text = if (tab.badgeCount > 99) "99+" else tab.badgeCount.toString(),
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                }
            }
        },
        icon = tab.icon?.let { icon ->
            {
                Icon(
                    imageVector = icon,
                    contentDescription = tab.title
                )
            }
        }
    )
}

/**
 * WgcHorizontalPagerIndicator
 *
 * Indicador de paginação por pontos para carrosséis e fluxos horizontais.
 *
 * @param pageCount Quantidade total de páginas.
 * @param currentPage Índice da página ativa.
 * @param modifier Modificador de layout.
 * @param activeColor Cor do ponto ativo.
 * @param inactiveColor Cor dos pontos inativos.
 * @param indicatorHeight Altura do ponto.
 * @param activeIndicatorWidth Largura expandida do ponto ativo.
 * @param inactiveIndicatorWidth Largura do ponto inativo.
 * @param spacing Espaçamento entre pontos.
 */
@Composable
fun WgcHorizontalPagerIndicator(
    pageCount: Int,
    currentPage: Int,
    modifier: Modifier = Modifier,
    activeColor: Color = MaterialTheme.colorScheme.primary,
    inactiveColor: Color = MaterialTheme.colorScheme.outlineVariant,
    indicatorHeight: Dp = WgcCoreDsSpacing.xs8.dp,
    activeIndicatorWidth: Dp = WgcCoreDsSpacing.lg24.dp,
    inactiveIndicatorWidth: Dp = WgcCoreDsSpacing.xs8.dp,
    spacing: Dp = WgcCoreDsSpacing.xs8.dp
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(spacing),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(pageCount) { index ->
            val isSelected = index == currentPage
            val width by animateDpAsState(
                targetValue = if (isSelected) activeIndicatorWidth else inactiveIndicatorWidth,
                label = "indicator_width"
            )
            val color by animateColorAsState(
                targetValue = if (isSelected) activeColor else inactiveColor,
                label = "indicator_color"
            )

            Box(
                modifier = Modifier
                    .height(indicatorHeight)
                    .width(width)
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                    .background(color)
            )
        }
    }
}

@WgcComponentPreviews
@Composable
private fun WgcTabsPreview() {
    val sampleTabs = listOf(
        WgcTabItem(id = "1", title = "Destaques", icon = Icons.Default.Home),
        WgcTabItem(id = "2", title = "Favoritos", icon = Icons.Default.Favorite, badgeCount = 3),
        WgcTabItem(id = "3", title = "Mais Vendidos", icon = Icons.Default.Star)
    )

    MaterialTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(WgcCoreDsSpacing.md16.dp),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.lg24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                WgcTabRow(
                    selectedTabIndex = 1,
                    tabs = sampleTabs,
                    onTabSelected = {}
                )

                WgcHorizontalPagerIndicator(
                    pageCount = 5,
                    currentPage = 2
                )
            }
        }
    }
}
