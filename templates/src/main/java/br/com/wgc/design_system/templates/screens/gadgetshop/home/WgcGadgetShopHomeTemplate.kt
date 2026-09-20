package br.com.wgc.design_system.templates.screens.gadgetshop.home

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcGadgetShopProductCard
import br.com.wgc.design_system.components.cards.WgcGadgetShopTopProductRow
import br.com.wgc.design_system.components.chip.WgcGadgetShopCategoryPill
import br.com.wgc.design_system.components.navigation.WgcGadgetShopBottomNav
import br.com.wgc.design_system.templates.screens.gadgetshop.model.NexkartCategory
import br.com.wgc.design_system.templates.screens.gadgetshop.model.GadgetShopMockData
import br.com.wgc.design_system.templates.screens.gadgetshop.model.NexkartProduct

/**
 * Tela principal de descoberta oficial do ecossistema Nexkart (WgcNexkartHomeTemplate).
 * Apresenta carrossel superior de categorias pastéis, seção de descontos "Bulk Discounts!",
 * tabs de filtro (Featured, Best Sellers, New Arrival), carrossel horizontal de produtos,
 * seção "Top Products in March" com badges numéricas e bottom nav bar com contagem de carrinho.
 */
@Composable
fun WgcNexkartHomeTemplate(
    modifier: Modifier = Modifier,
    categories: List<NexkartCategory> = GadgetShopMockData.categories,
    featuredProducts: List<NexkartProduct> = GadgetShopMockData.products,
    topProducts: List<NexkartProduct> = GadgetShopMockData.topProducts,
    selectedCategory: String = "Beauty",
    selectedTab: String = "Featured",
    cartItemCount: Int = 3,
    onCategoryClick: (NexkartCategory) -> Unit = {},
    onTabSelected: (String) -> Unit = {},
    onProductClick: (NexkartProduct) -> Unit = {},
    onViewAllDiscountsClick: () -> Unit = {},
    onNavItemSelected: (Int) -> Unit = {},
    headerSlot: (@Composable () -> Unit)? = null,
    bottomNavSlot: (@Composable () -> Unit)? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        bottomBar = {
            if (bottomNavSlot != null) {
                bottomNavSlot()
            } else {
                WgcGadgetShopBottomNav(
                    selectedIndex = 0,
                    cartItemCount = cartItemCount,
                    onItemSelected = onNavItemSelected
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(vertical = WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.lg24.dp)
        ) {
            // Slot opcional de cabeçalho
            if (headerSlot != null) {
                item { headerSlot() }
            }

            // 1. Carrossel de Categorias Pastéis (Beauty, Gadgets, Games, Cine, Fashion)
            item {
                LazyRow(
                    contentPadding = PaddingValues(horizontal = WgcCoreDsSpacing.md16.dp),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    items(categories) { category ->
                        WgcGadgetShopCategoryPill(
                            title = category.name,
                            backgroundColor = category.color,
                            isSelected = selectedCategory == category.name,
                            onClick = { onCategoryClick(category) }
                        )
                    }
                }
            }

            // 2. Seção "Bulk Discounts!" com link "View All"
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Bulk Discounts!",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.gadgetShopDark)
                        )
                        Text(
                            text = "View All",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(WgcCoreDsColors.gadgetShopPrimary),
                            modifier = Modifier.clickable(onClick = onViewAllDiscountsClick)
                        )
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                    // Tabs de Filtro (Featured, Best Sellers, New Arrival)
                    val tabs = listOf("Featured", "Best Sellers", "New Arrival")
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                    ) {
                        tabs.forEach { tab ->
                            val isSelected = selectedTab == tab
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp))
                                    .background(
                                        if (isSelected) Color(WgcCoreDsColors.gadgetShopPrimary) else Color(WgcCoreDsColors.gadgetShopSurface)
                                    )
                                    .clickable { onTabSelected(tab) }
                                    .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = tab,
                                    style = MaterialTheme.typography.labelMedium,
                                    color = if (isSelected) Color.White else Color(WgcCoreDsColors.gadgetShopDark),
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                                )
                            }
                        }
                    }
                }
            }

            // 3. Carrossel Horizontal de Produtos Featured
            item {
                LazyRow(
                    contentPadding = PaddingValues(horizontal = WgcCoreDsSpacing.md16.dp),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                ) {
                    items(featuredProducts) { product ->
                        WgcGadgetShopProductCard(
                            title = product.title,
                            price = product.price,
                            originalPrice = product.originalPrice,
                            rating = product.rating,
                            reviewCount = product.reviewCount,
                            tag = product.tag,
                            imageUrl = product.imageUrl,
                            isFavorite = product.isFavorite,
                            onClick = { onProductClick(product) }
                        )
                    }
                }
            }

            // 4. Seção "Top Products in March" com ranking numérico
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                ) {
                    Text(
                        text = "Top Products in March",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.gadgetShopDark)
                    )

                    topProducts.forEachIndexed { index, topProduct ->
                        WgcGadgetShopTopProductRow(
                            rank = index + 1,
                            title = topProduct.title,
                            description = topProduct.description,
                            price = topProduct.price,
                            imageUrl = topProduct.imageUrl,
                            onClick = { onProductClick(topProduct) }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcNexkartHomeTemplatePreview() {
    WgcNexkartHomeTemplate()
}
