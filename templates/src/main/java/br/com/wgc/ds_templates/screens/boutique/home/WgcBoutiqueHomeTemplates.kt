package br.com.wgc.ds_templates.screens.boutique.home

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import br.com.wgc.design_system.components.buttons.WgcBrandPill
import br.com.wgc.design_system.components.cards.WgcBoutiqueProductCard
import br.com.wgc.ds_templates.screens.boutique.model.LazaBrandItem
import br.com.wgc.ds_templates.screens.boutique.model.BoutiqueMockData
import br.com.wgc.ds_templates.screens.boutique.model.LazaProduct

/**
 * Tela principal do ecossistema Laza (WgcLazaHomeTemplate).
 * Apresenta Top Bar com botão de menu e carrinho com badge, saudação "Hello, Welcome to Laza",
 * campo de busca com botão de microfone roxo, seção "Choose Brand" em carrossel horizontal,
 * seção "New Arrival" em grade de 2 colunas e barra de navegação inferior com 4 itens.
 */
@Composable
fun WgcLazaHomeTemplate(
    modifier: Modifier = Modifier,
    searchQuery: String = "",
    selectedBrandId: String = "brand-nike",
    cartCount: Int = 2,
    selectedNavIndex: Int = 0,
    brands: List<LazaBrandItem> = BoutiqueMockData.brands,
    products: List<LazaProduct> = BoutiqueMockData.products,
    onSearchChange: (String) -> Unit = {},
    onVoiceSearchClick: () -> Unit = {},
    onMenuClick: () -> Unit = {},
    onCartClick: () -> Unit = {},
    onBrandClick: (LazaBrandItem) -> Unit = {},
    onProductClick: (LazaProduct) -> Unit = {},
    onProductFavoriteToggle: (LazaProduct) -> Unit = {},
    onSeeAllBrands: () -> Unit = {},
    onSeeAllProducts: () -> Unit = {},
    onNavItemSelected: (Int) -> Unit = {},
    customHeaderSlot: (@Composable () -> Unit)? = null,
    customBrandRowSlot: (@Composable () -> Unit)? = null,
    customProductGridSlot: (@Composable () -> Unit)? = null,
    customBottomNavSlot: (@Composable () -> Unit)? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        bottomBar = {
            if (customBottomNavSlot != null) {
                customBottomNavSlot()
            } else {
                LazaBottomNavigation(
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
            if (customHeaderSlot != null) {
                customHeaderSlot()
            } else {
                // Top Action Bar (Menu & Cart)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.lg24.dp, vertical = WgcCoreDsSpacing.md16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = onMenuClick,
                        modifier = Modifier
                            .size(WgcCoreDsSize.s44.dp)
                            .clip(CircleShape)
                            .background(Color(WgcCoreDsColors.boutiqueSurface))
                    ) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu lateral",
                            tint = Color(WgcCoreDsColors.boutiqueDark),
                            modifier = Modifier.size(WgcCoreDsSize.s22.dp)
                        )
                    }

                    IconButton(
                        onClick = onCartClick,
                        modifier = Modifier
                            .size(WgcCoreDsSize.s44.dp)
                            .clip(CircleShape)
                            .background(Color(WgcCoreDsColors.boutiqueSurface))
                    ) {
                        BadgedBox(
                            badge = {
                                if (cartCount > 0) {
                                    Badge(
                                        containerColor = Color(WgcCoreDsColors.boutiquePrimary),
                                        contentColor = Color.White
                                    ) {
                                        Text(text = cartCount.toString())
                                    }
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.ShoppingBag,
                                contentDescription = "Carrinho",
                                tint = Color(WgcCoreDsColors.boutiqueDark),
                                modifier = Modifier.size(WgcCoreDsSize.s22.dp)
                            )
                        }
                    }
                }

                // Greeting Header
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.lg24.dp)
                ) {
                    Text(
                        text = "Hello",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.boutiqueDark)
                    )
                    Text(
                        text = "Welcome to Laza.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(WgcCoreDsColors.boutiqueSecondaryText)
                    )
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

                // Search Bar + Mic button
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.lg24.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                ) {
                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = onSearchChange,
                        modifier = Modifier
                            .weight(1f)
                            .height(WgcCoreDsSize.s52.dp),
                        placeholder = {
                            Text(
                                text = "Search...",
                                color = Color(WgcCoreDsColors.boutiqueSecondaryText)
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Buscar",
                                tint = Color(WgcCoreDsColors.boutiqueSecondaryText)
                            )
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = Color(WgcCoreDsColors.boutiqueSurface),
                            unfocusedContainerColor = Color(WgcCoreDsColors.boutiqueSurface),
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent
                        )
                    )

                    Box(
                        modifier = Modifier
                            .size(WgcCoreDsSize.s52.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                            .background(Color(WgcCoreDsColors.boutiquePrimary))
                            .clickable(onClick = onVoiceSearchClick),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Mic,
                            contentDescription = "Busca por voz",
                            tint = Color.White,
                            modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            // Main Scrollable Grid containing Brands row and New Arrival items
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
                // Section: Choose Brand (Spans 2 columns)
                item(span = { androidx.compose.foundation.lazy.grid.GridItemSpan(2) }) {
                    if (customBrandRowSlot != null) {
                        customBrandRowSlot()
                    } else {
                        Column {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Choose Brand",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(WgcCoreDsColors.boutiqueDark)
                                )

                                TextButton(onClick = onSeeAllBrands) {
                                    Text(
                                        text = "View All",
                                        style = MaterialTheme.typography.labelMedium,
                                        color = Color(WgcCoreDsColors.boutiqueSecondaryText)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                            LazyRow(
                                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                            ) {
                                items(brands, key = { it.id }) { brand ->
                                    WgcBrandPill(
                                        brandName = brand.name,
                                        logoUrl = brand.logoUrl,
                                        isSelected = brand.id == selectedBrandId,
                                        onClick = { onBrandClick(brand) }
                                    )
                                }
                            }
                        }
                    }
                }

                // Section: New Arrival Header (Spans 2 columns)
                item(span = { androidx.compose.foundation.lazy.grid.GridItemSpan(2) }) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "New Arrival",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.boutiqueDark)
                        )

                        TextButton(onClick = onSeeAllProducts) {
                            Text(
                                text = "View All",
                                style = MaterialTheme.typography.labelMedium,
                                color = Color(WgcCoreDsColors.boutiqueSecondaryText)
                            )
                        }
                    }
                }

                // Product items in 2 columns
                if (customProductGridSlot != null) {
                    item(span = { androidx.compose.foundation.lazy.grid.GridItemSpan(2) }) {
                        customProductGridSlot()
                    }
                } else {
                    items(products, key = { it.id }) { product ->
                        WgcBoutiqueProductCard(
                            modifier = Modifier.fillMaxWidth(),
                            title = product.title,
                            price = product.price,
                            imageUrl = product.imageUrl,
                            isFavorite = product.isFavorite,
                            onFavoriteClick = { onProductFavoriteToggle(product) },
                            onClick = { onProductClick(product) }
                        )
                    }
                }
            }
        }
    }
}

/**
 * Barra de navegação inferior oficial do ecossistema Laza.
 * Suporta 4 abas: Home, Wishlist, Cart, e Wallet.
 */
@Composable
fun LazaBottomNavigation(
    selectedIndex: Int = 0,
    onItemSelected: (Int) -> Unit = {}
) {
    NavigationBar(
        containerColor = Color.White,
        tonalElevation = WgcCoreDsSpacing.none0.dp
    ) {
        val navItems = listOf(
            Triple("Home", Icons.Default.Home, 0),
            Triple("Wishlist", Icons.Outlined.FavoriteBorder, 1),
            Triple("Cart", Icons.Default.ShoppingBag, 2),
            Triple("Wallet", Icons.Default.AccountBalanceWallet, 3)
        )

        navItems.forEach { (title, icon, index) ->
            val isSelected = selectedIndex == index
            NavigationBarItem(
                selected = isSelected,
                onClick = { onItemSelected(index) },
                icon = {
                    Icon(
                        imageVector = if (isSelected && index == 1) Icons.Filled.Favorite else icon,
                        contentDescription = title,
                        modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                    )
                },
                label = {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(WgcCoreDsColors.boutiquePrimary),
                    selectedTextColor = Color(WgcCoreDsColors.boutiquePrimary),
                    unselectedIconColor = Color(WgcCoreDsColors.boutiqueSecondaryText),
                    unselectedTextColor = Color(WgcCoreDsColors.boutiqueSecondaryText),
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcLazaHomeTemplatePreview() {
    WgcLazaHomeTemplate()
}
