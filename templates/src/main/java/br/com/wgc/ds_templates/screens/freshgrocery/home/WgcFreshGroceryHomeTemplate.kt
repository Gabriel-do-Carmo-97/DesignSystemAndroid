package br.com.wgc.ds_templates.screens.freshgrocery.home

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import br.com.wgc.design_system.components.cards.WgcFreshGroceryCategoryItem
import br.com.wgc.design_system.components.cards.WgcFreshGroceryProductCard
import br.com.wgc.design_system.components.cards.WgcFreshGroceryPromoBanner
import br.com.wgc.design_system.components.navigation.WgcFreshGroceryBottomNav
import br.com.wgc.design_system.components.navigation.WgcShopperNavItem
import br.com.wgc.ds_templates.screens.freshgrocery.model.ShopperCategory
import br.com.wgc.ds_templates.screens.freshgrocery.model.FreshGroceryMockData
import br.com.wgc.ds_templates.screens.freshgrocery.model.ShopperProduct

/**
 * Tela Home do Shopper:
 * - Header verde esmeralda com logo "Shopper", ícones de notificação/carrinho e barra de busca integrada
 * - Banner promocional em destaque ("Don't Miss Out! Get discount up to 50%")
 * - Grid de categorias 5x2 de ícones circulares com "More" em destaque verde
 * - Seção "Flash Deal" com contador regressivo e lista horizontal de produtos
 * - Seção "Popular Products" em grid
 * - Bottom Navigation Bar fixa
 */
@Composable
fun WgcShopperHomeTemplate(
    searchQuery: String = "",
    onSearchChange: (String) -> Unit = {},
    categories: List<ShopperCategory> = FreshGroceryMockData.categories,
    products: List<ShopperProduct> = FreshGroceryMockData.products,
    countdown: String = "08:21:30",
    selectedNav: WgcShopperNavItem = WgcShopperNavItem.Home,
    onNavSelect: (WgcShopperNavItem) -> Unit = {},
    onCategoryClick: (ShopperCategory) -> Unit = {},
    onProductClick: (ShopperProduct) -> Unit = {},
    onFavoriteToggle: (ShopperProduct) -> Unit = {},
    onCartClick: () -> Unit = {},
    onNotificationClick: () -> Unit = {},
    bannerSlot: (@Composable () -> Unit)? = null,
    bottomNavSlot: (@Composable () -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            if (bottomNavSlot != null) {
                bottomNavSlot()
            } else {
                WgcFreshGroceryBottomNav(
                    selectedItem = selectedNav,
                    onItemSelected = onNavSelect
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            // Header Verde Esmeralda
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            bottomStart = WgcCoreDsBorderRadius.xxl24.dp,
                            bottomEnd = WgcCoreDsBorderRadius.xxl24.dp
                        )
                    )
                    .background(Color(WgcCoreDsColors.megaStorerPrimary))
                    .padding(
                        horizontal = WgcCoreDsSpacing.md16.dp,
                        vertical = WgcCoreDsSpacing.md16.dp
                    )
            ) {
                Column {
                    // Barra Superior com Logo e Ações
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(WgcCoreDsSize.s32.dp)
                                    .clip(CircleShape)
                                    .background(Color.White.copy(alpha = 0.2f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ShoppingBag,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                            Text(
                                text = "Shopper",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }

                        Row(horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)) {
                            IconButton(onClick = onNotificationClick) {
                                Icon(
                                    imageVector = Icons.Default.Notifications,
                                    contentDescription = "Alerts",
                                    tint = Color.White,
                                    modifier = Modifier.size(WgcCoreDsSize.s22.dp)
                                )
                            }
                            IconButton(onClick = onCartClick) {
                                Icon(
                                    imageVector = Icons.Default.ShoppingCart,
                                    contentDescription = "Cart",
                                    tint = Color.White,
                                    modifier = Modifier.size(WgcCoreDsSize.s22.dp)
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                    // Campo de Pesquisa Branco
                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = onSearchChange,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(WgcCoreDsSize.s48.dp),
                        placeholder = {
                            Text(
                                text = "Search product...",
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color(WgcCoreDsColors.megaStorerSecondaryText)
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.megaStorerSecondaryText),
                                modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                            )
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            disabledContainerColor = Color.White,
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp),
                        singleLine = true
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            // Banner Promocional
            Box(modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.md16.dp)) {
                if (bannerSlot != null) {
                    bannerSlot()
                } else {
                    WgcFreshGroceryPromoBanner(
                        title = "Don't Miss Out!",
                        subtitle = "Get discount up to 50%",
                        buttonText = "Check Now"
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            // Categorias em Grid Horizontal / 2 Linhas
            Column(modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.md16.dp)) {
                Text(
                    text = "Categories",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.megaStorerDark)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                // Linha 1 de Categorias
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    categories.take(5).forEach { cat ->
                        WgcFreshGroceryCategoryItem(
                            title = cat.name,
                            icon = cat.icon,
                            isHighlighted = cat.isHighlighted,
                            onClick = { onCategoryClick(cat) }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                // Linha 2 de Categorias
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    categories.drop(5).take(5).forEach { cat ->
                        WgcFreshGroceryCategoryItem(
                            title = cat.name,
                            icon = cat.icon,
                            isHighlighted = cat.isHighlighted,
                            onClick = { onCategoryClick(cat) }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            // Flash Deal com Countdown
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                    ) {
                        Text(
                            text = "Flash Deal",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.megaStorerDark)
                        )

                        // Timer Badge
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                .background(Color(WgcCoreDsColors.megaStorerAccent))
                                .padding(
                                    horizontal = WgcCoreDsSpacing.xs8.dp,
                                    vertical = WgcCoreDsSpacing.xxs4.dp
                                )
                        ) {
                            Text(
                                text = countdown,
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }

                    Text(
                        text = "See All",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.megaStorerPrimary),
                        modifier = Modifier.clickable { /* see all */ }
                    )
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                LazyRow(
                    contentPadding = PaddingValues(horizontal = WgcCoreDsSpacing.md16.dp),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
                ) {
                    items(products) { product ->
                        WgcFreshGroceryProductCard(
                            title = product.title,
                            price = product.price,
                            originalPrice = product.originalPrice,
                            rating = product.rating,
                            discountBadge = product.discountPercent,
                            isFavorite = product.isFavorite,
                            onFavoriteToggle = { onFavoriteToggle(product) },
                            onClick = { onProductClick(product) }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            // Popular Products
            Column(modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.md16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Popular Products",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.megaStorerDark)
                    )

                    Text(
                        text = "See All",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.megaStorerPrimary),
                        modifier = Modifier.clickable { /* see all */ }
                    )
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
                ) {
                    products.take(2).forEach { product ->
                        Box(modifier = Modifier.weight(1f)) {
                            WgcFreshGroceryProductCard(
                                title = product.title,
                                price = product.price,
                                originalPrice = product.originalPrice,
                                rating = product.rating,
                                discountBadge = product.discountPercent,
                                isFavorite = product.isFavorite,
                                onFavoriteToggle = { onFavoriteToggle(product) },
                                onClick = { onProductClick(product) },
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcShopperHomeTemplatePreview() {
    WgcShopperHomeTemplate()
}
