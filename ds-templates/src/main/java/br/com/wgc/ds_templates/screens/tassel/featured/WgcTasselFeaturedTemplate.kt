package br.com.wgc.ds_templates.screens.tassel.featured

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Eco
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
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcTasselProductCard
import br.com.wgc.design_system.components.images.AsyncImageDefault
import br.com.wgc.design_system.components.navigation.WgcTasselBottomNav
import br.com.wgc.ds_templates.screens.tassel.model.TasselMockData
import br.com.wgc.ds_templates.screens.tassel.model.TasselProduct
import br.com.wgc.ds_templates.screens.tassel.model.TasselStore

/**
 * Tela de Destaques e Exploração oficial do Tassel (WgcTasselFeaturedTemplate).
 * Apresenta o banner de sustentabilidade "For the love of nature", carrossel de lojas novas
 * e vitrine em grade de 2 colunas com produtos em alta.
 */
@Composable
fun WgcTasselFeaturedTemplate(
    modifier: Modifier = Modifier,
    selectedTabIndex: Int = 0, // Default: Featured
    selectedNavIndex: Int = 0, // Home
    stores: List<TasselStore> = TasselMockData.stores,
    products: List<TasselProduct> = TasselMockData.products,
    onTabSelect: (Int) -> Unit = {},
    onStoreClick: (TasselStore) -> Unit = {},
    onProductClick: (TasselProduct) -> Unit = {},
    onProductBookmarkToggle: (TasselProduct) -> Unit = {},
    onSeeAllStoresClick: () -> Unit = {},
    onNavItemSelected: (Int) -> Unit = {},
    customBannerSlot: (@Composable () -> Unit)? = null,
    customStoresSlot: (@Composable () -> Unit)? = null,
    customProductsSlot: (@Composable () -> Unit)? = null,
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
                WgcTasselBottomNav(
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
            // Top Bar com Logo e Título
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
                        .background(Color(WgcCoreDsColors.tasselSurface)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Mail,
                        contentDescription = "Tassel Envelope",
                        tint = Color(WgcCoreDsColors.tasselDark),
                        modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "Featured",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.tasselDark)
                )

                Spacer(modifier = Modifier.weight(1f))

                // Balanceador
                Spacer(modifier = Modifier.size(WgcCoreDsSize.s40.dp))
            }

            // Tab Row
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
                            color = if (isSelected) Color(WgcCoreDsColors.tasselDark) else Color(WgcCoreDsColors.tasselSecondaryText)
                        )

                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))

                        Box(
                            modifier = Modifier
                                .size(
                                    width = if (isSelected) WgcCoreDsSize.s16.dp else WgcCoreDsSize.s0.dp,
                                    height = WgcCoreDsSpacing.xxxs2.dp
                                )
                                .background(
                                    if (isSelected) Color(WgcCoreDsColors.tasselPrimary)
                                    else Color.Transparent
                                )
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            // Main Grid
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
                // Banner "For the love of nature" (Spans 2 columns)
                item(span = { androidx.compose.foundation.lazy.grid.GridItemSpan(2) }) {
                    if (customBannerSlot != null) {
                        customBannerSlot()
                    } else {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(WgcCoreDsSize.s200.dp)
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp))
                                .background(Color(WgcCoreDsColors.tasselDark))
                        ) {
                            AsyncImageDefault(
                                image = "https://images.unsplash.com/photo-1507525428034-b723cf961d3e?w=800",
                                contentDescription = "Natureza Sustentável",
                                modifier = Modifier.fillMaxSize()
                            )

                            // Overlay escuro suave para leitura do texto
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(Color.Black.copy(alpha = 0.4f))
                            )

                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(WgcCoreDsSpacing.lg24.dp),
                                verticalArrangement = Arrangement.SpaceBetween
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(WgcCoreDsSize.s36.dp)
                                        .clip(CircleShape)
                                        .background(Color(WgcCoreDsColors.tasselPrimary)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Eco,
                                        contentDescription = "Sustentável",
                                        tint = Color.White,
                                        modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                                    )
                                }

                                Column {
                                    Text(
                                        text = "For the love of nature",
                                        style = MaterialTheme.typography.titleLarge,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    )
                                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                                    Text(
                                        text = "Explore what's new on #sustainable",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = Color.White.copy(alpha = 0.8f)
                                    )
                                }
                            }
                        }
                    }
                }

                // Section: New Stores (Spans 2 columns)
                item(span = { androidx.compose.foundation.lazy.grid.GridItemSpan(2) }) {
                    if (customStoresSlot != null) {
                        customStoresSlot()
                    } else {
                        Column {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "New stores",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(WgcCoreDsColors.tasselDark)
                                )

                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                                    contentDescription = "Ver todas as lojas",
                                    tint = Color(WgcCoreDsColors.tasselDark),
                                    modifier = Modifier
                                        .size(WgcCoreDsSize.s20.dp)
                                        .clickable(onClick = onSeeAllStoresClick)
                                )
                            }

                            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                            LazyRow(
                                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
                            ) {
                                items(stores, key = { it.id }) { store ->
                                    Column(
                                        modifier = Modifier
                                            .width(WgcCoreDsSize.s140.dp)
                                            .clickable { onStoreClick(store) }
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(WgcCoreDsSize.s88.dp)
                                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                                                .background(Color(WgcCoreDsColors.tasselSurface)),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            if (!store.coverImageUrl.isNullOrEmpty()) {
                                                AsyncImageDefault(
                                                    image = store.coverImageUrl,
                                                    contentDescription = store.name,
                                                    modifier = Modifier.fillMaxSize()
                                                )
                                            } else {
                                                Text(
                                                    text = store.name.take(2).uppercase(),
                                                    style = MaterialTheme.typography.titleMedium,
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color(WgcCoreDsColors.tasselPrimary)
                                                )
                                            }
                                        }

                                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                                        Text(
                                            text = store.name,
                                            style = MaterialTheme.typography.bodyMedium,
                                            fontWeight = FontWeight.Bold,
                                            color = Color(WgcCoreDsColors.tasselDark)
                                        )
                                        Text(
                                            text = store.category,
                                            style = MaterialTheme.typography.labelSmall,
                                            color = Color(WgcCoreDsColors.tasselSecondaryText)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

                // Section: Trending Products Header (Spans 2 columns)
                item(span = { androidx.compose.foundation.lazy.grid.GridItemSpan(2) }) {
                    Text(
                        text = "Trending items",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.tasselDark)
                    )
                }

                // Products in 2-column grid
                if (customProductsSlot != null) {
                    item(span = { androidx.compose.foundation.lazy.grid.GridItemSpan(2) }) {
                        customProductsSlot()
                    }
                } else {
                    items(products, key = { it.id }) { product ->
                        WgcTasselProductCard(
                            modifier = Modifier.fillMaxWidth(),
                            title = product.title,
                            price = product.price,
                            brand = product.brand,
                            imageUrl = product.imageUrl,
                            isBookmarked = product.isBookmarked,
                            onBookmarkClick = { onProductBookmarkToggle(product) },
                            onClick = { onProductClick(product) }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcTasselFeaturedTemplatePreview() {
    WgcTasselFeaturedTemplate()
}
