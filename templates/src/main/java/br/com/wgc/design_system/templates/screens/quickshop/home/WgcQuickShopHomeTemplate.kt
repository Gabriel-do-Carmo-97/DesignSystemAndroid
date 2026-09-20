package br.com.wgc.design_system.templates.screens.quickshop.home

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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
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
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcQuickShopOfferBanner
import br.com.wgc.design_system.components.cards.WgcQuickShopProductCard
import br.com.wgc.design_system.components.navigation.WgcQuickShopBottomNav
import br.com.wgc.design_system.components.navigation.WgcShopEaseNavItem
import br.com.wgc.design_system.templates.screens.quickshop.model.ShopEaseMockData
import br.com.wgc.design_system.templates.screens.quickshop.model.ShopEaseProduct

/**
 * Tela Home do ShopEase:
 * - Header com ícone de menu drawer, logo "ShopEase" e sacola de compras
 * - Barra de pesquisa com filtro
 * - Banner promocional "Free Delivery" / Sunset Orange
 * - Abas / chips de categorias (All, Shoes, Clothes, Watches)
 * - Vitrine de produtos em cards pastéis coloridos em 2 colunas
 * - Bottom Navigation fixa
 */
@Composable
fun WgcShopEaseHomeTemplate(
    searchQuery: String = "",
    onSearchChange: (String) -> Unit = {},
    selectedCategory: String = "All",
    onCategorySelect: (String) -> Unit = {},
    products: List<ShopEaseProduct> = ShopEaseMockData.products,
    selectedNav: WgcShopEaseNavItem = WgcShopEaseNavItem.Home,
    onNavSelect: (WgcShopEaseNavItem) -> Unit = {},
    onProductClick: (ShopEaseProduct) -> Unit = {},
    onFavoriteToggle: (ShopEaseProduct) -> Unit = {},
    onCartClick: () -> Unit = {},
    onMenuClick: () -> Unit = {},
    bottomNavSlot: (@Composable () -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    val categories = listOf("All", "Shoes", "Clothes", "Watches", "Bags")

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        bottomBar = {
            if (bottomNavSlot != null) {
                bottomNavSlot()
            } else {
                WgcQuickShopBottomNav(
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
            // Top Bar com Menu e Cart
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = WgcCoreDsSpacing.lg24.dp,
                        vertical = WgcCoreDsSpacing.md16.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onMenuClick,
                    modifier = Modifier
                        .size(WgcCoreDsSize.s40.dp)
                        .clip(CircleShape)
                        .background(Color(WgcCoreDsColors.quickShopSurface))
                ) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu",
                        tint = Color(WgcCoreDsColors.quickShopDark),
                        modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                    )
                }

                Text(
                    text = "ShopEase",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(WgcCoreDsColors.quickShopPrimaryDark)
                )

                IconButton(
                    onClick = onCartClick,
                    modifier = Modifier
                        .size(WgcCoreDsSize.s40.dp)
                        .clip(CircleShape)
                        .background(Color(WgcCoreDsColors.quickShopSurface))
                ) {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "Cart",
                        tint = Color(WgcCoreDsColors.quickShopDark),
                        modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                    )
                }
            }

            // Barra de Busca
            OutlinedTextField(
                value = searchQuery,
                onValueChange = onSearchChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.lg24.dp)
                    .height(WgcCoreDsSize.s48.dp),
                placeholder = {
                    Text(
                        text = "Search product...",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(WgcCoreDsColors.quickShopSecondaryText)
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.quickShopSecondaryText),
                        modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                    )
                },
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color(WgcCoreDsColors.quickShopSurface),
                    unfocusedContainerColor = Color(WgcCoreDsColors.quickShopSurface),
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent
                ),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            // Banner Promocional de Ofertas
            Box(modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.lg24.dp)) {
                WgcQuickShopOfferBanner(
                    title = "Free Delivery",
                    subtitle = "For your first item ordered",
                    badgeText = "FREE"
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            // Categorias (Pílulas / Chips)
            LazyRow(
                contentPadding = PaddingValues(horizontal = WgcCoreDsSpacing.lg24.dp),
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
            ) {
                items(categories) { cat ->
                    val isSelected = cat == selectedCategory
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                            .background(
                                if (isSelected) Color(WgcCoreDsColors.quickShopPrimary)
                                else Color(WgcCoreDsColors.quickShopSurface)
                            )
                            .clickable { onCategorySelect(cat) }
                            .padding(
                                horizontal = WgcCoreDsSpacing.md16.dp,
                                vertical = WgcCoreDsSpacing.xs8.dp
                            )
                    ) {
                        Text(
                            text = cat,
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                            color = if (isSelected) Color.White else Color(WgcCoreDsColors.quickShopDark)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            // Grid de Produtos em 2 Colunas
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.lg24.dp)
            ) {
                Text(
                    text = "New Arrivals",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.quickShopDark)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

                // Linha 1 de Produtos
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
                ) {
                    products.take(2).forEach { prod ->
                        Box(modifier = Modifier.weight(1f)) {
                            WgcQuickShopProductCard(
                                title = prod.title,
                                price = prod.price,
                                originalPrice = prod.originalPrice,
                                discountBadge = prod.discountBadge,
                                backgroundColor = prod.backgroundColor,
                                isFavorite = prod.isFavorite,
                                onFavoriteToggle = { onFavoriteToggle(prod) },
                                onClick = { onProductClick(prod) },
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

                // Linha 2 de Produtos
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
                ) {
                    products.drop(2).take(2).forEach { prod ->
                        Box(modifier = Modifier.weight(1f)) {
                            WgcQuickShopProductCard(
                                title = prod.title,
                                price = prod.price,
                                originalPrice = prod.originalPrice,
                                discountBadge = prod.discountBadge,
                                backgroundColor = prod.backgroundColor,
                                isFavorite = prod.isFavorite,
                                onFavoriteToggle = { onFavoriteToggle(prod) },
                                onClick = { onProductClick(prod) },
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
private fun WgcShopEaseHomeTemplatePreview() {
    WgcShopEaseHomeTemplate()
}
