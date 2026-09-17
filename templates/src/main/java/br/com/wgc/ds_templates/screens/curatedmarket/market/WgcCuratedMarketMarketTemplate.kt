package br.com.wgc.ds_templates.screens.curatedmarket.market

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcCuratedCollectionCard
import br.com.wgc.design_system.components.fields.WgcCuratedSearchBar
import br.com.wgc.design_system.components.navigation.WgcCuratedBottomNav
import br.com.wgc.ds_templates.screens.curatedmarket.model.TasselCollectionItem
import br.com.wgc.ds_templates.screens.curatedmarket.model.CuratedMarketMockData

/**
 * Tela Market / Coleções oficial do ecossistema Tassel (WgcTasselMarketTemplate).
 * Apresenta barra superior com ícone envelope da marca, campo de busca com filtros,
 * abas de navegação de catálogo e grade minimalista com cartões de coleções (On sale, New in, categorias).
 */
@Composable
fun WgcTasselMarketTemplate(
    modifier: Modifier = Modifier,
    searchQuery: String = "",
    selectedTabIndex: Int = 1, // Default: Collection
    selectedNavIndex: Int = 1, // Market
    collections: List<TasselCollectionItem> = CuratedMarketMockData.collections,
    onSearchChange: (String) -> Unit = {},
    onFilterClick: () -> Unit = {},
    onTabSelect: (Int) -> Unit = {},
    onCollectionClick: (TasselCollectionItem) -> Unit = {},
    onNavItemSelected: (Int) -> Unit = {},
    customTopBarSlot: (@Composable () -> Unit)? = null,
    customSearchSlot: (@Composable () -> Unit)? = null,
    customGridSlot: (@Composable () -> Unit)? = null,
    customBottomNavSlot: (@Composable () -> Unit)? = null
) {
    val tabs = listOf("Featured", "Collection", "Stores", "Tags")

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        bottomBar = {
            if (customBottomNavSlot != null) {
                customBottomNavSlot()
            } else {
                WgcCuratedBottomNav(
                    selectedIndex = selectedNavIndex,
                    onItemSelected = onNavItemSelected
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            // Top Bar
            if (customTopBarSlot != null) {
                customTopBarSlot()
            } else {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.lg24.dp, vertical = WgcCoreDsSpacing.md16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(WgcCoreDsSize.s40.dp)
                            .clip(CircleShape)
                            .background(Color(WgcCoreDsColors.curatedMarketSurface)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Mail,
                            contentDescription = "Tassel Envelope",
                            tint = Color(WgcCoreDsColors.curatedMarketDark),
                            modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = "Market",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.curatedMarketDark)
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    // Balanceador
                    Spacer(modifier = Modifier.size(WgcCoreDsSize.s40.dp))
                }
            }

            // Search Bar
            if (customSearchSlot != null) {
                customSearchSlot()
            } else {
                Box(modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.lg24.dp)) {
                    WgcCuratedSearchBar(
                        query = searchQuery,
                        onQueryChange = onSearchChange,
                        onFilterClick = onFilterClick
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            // Tab Row (Featured, Collection, Stores, Tags)
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = WgcCoreDsSpacing.lg24.dp),
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.lg24.dp)
            ) {
                itemsIndexed(tabs) { index, tabTitle ->
                    val isSelected = selectedTabIndex == index
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.clickable { onTabSelect(index) }
                    ) {
                        Text(
                            text = tabTitle,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                            color = if (isSelected) Color(WgcCoreDsColors.curatedMarketDark) else Color(WgcCoreDsColors.curatedMarketSecondaryText)
                        )

                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))

                        Box(
                            modifier = Modifier
                                .size(
                                    width = if (isSelected) WgcCoreDsSize.s16.dp else WgcCoreDsSize.s0.dp,
                                    height = WgcCoreDsSpacing.xxxs2.dp
                                )
                                .background(
                                    if (isSelected) Color(WgcCoreDsColors.curatedMarketPrimary)
                                    else Color.Transparent
                                )
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            // Grid de Coleções
            if (customGridSlot != null) {
                customGridSlot()
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(
                        horizontal = WgcCoreDsSpacing.lg24.dp,
                        vertical = WgcCoreDsSpacing.xs8.dp
                    ),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
                ) {
                    items(collections, key = { it.id }) { item ->
                        val (bgColor, txtColor) = when (item.type) {
                            "sale" -> Color(WgcCoreDsColors.curatedMarketSalePink) to Color(WgcCoreDsColors.curatedMarketSalePinkText)
                            "new_in" -> Color(WgcCoreDsColors.curatedMarketNewInPurple) to Color(WgcCoreDsColors.curatedMarketNewInPurpleText)
                            else -> Color(WgcCoreDsColors.curatedMarketSurface) to Color(WgcCoreDsColors.curatedMarketDark)
                        }

                        WgcCuratedCollectionCard(
                            title = item.title,
                            backgroundColor = bgColor,
                            textColor = txtColor,
                            onClick = { onCollectionClick(item) }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcTasselMarketTemplatePreview() {
    WgcTasselMarketTemplate()
}
