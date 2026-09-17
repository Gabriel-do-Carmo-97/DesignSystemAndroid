package br.com.wgc.ds_templates.screens.trendfashion.catalog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.FilterList
import androidx.compose.material.icons.outlined.Sort
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcButton
import br.com.wgc.design_system.components.buttons.WgcSecondaryClassicButton
import br.com.wgc.design_system.components.cards.WgcEcommerceProductCard
import br.com.wgc.design_system.components.chip.WgcChip
import br.com.wgc.design_system.components.chip.WgcSizeSelectorChip
import br.com.wgc.design_system.components.feedback.WgcRatingBar
import br.com.wgc.design_system.components.fields.SearchTextField
import br.com.wgc.design_system.components.navigation.NavItem
import br.com.wgc.design_system.components.navigation.WgcBottomNavBar
import br.com.wgc.ds_templates.screens.trendfashion.model.StylishProductItem

/**
 * Tela 10: Trending Products (Catálogo em Grid com filtros e ordenação).
 * (Figma ID: 1:17150)
 */
@Composable
fun WgcStylishTrendingScreenTemplate(
    modifier: Modifier = Modifier,
    searchQuery: String = "",
    onSearchQueryChange: (String) -> Unit = {},
    products: List<StylishProductItem> = listOf(
        StylishProductItem("1", "Nike Sneakers", "Vision Alta Men's Shoes", "₹1,500", "₹2,499", 40, rating = 4.5f),
        StylishProductItem("2", "Jordan Retro 4", "Men's High Top Basketball Shoes", "₹3,999", "₹6,999", 43, rating = 4.8f),
        StylishProductItem("3", "Adidas Ultraboost", "Light Running Performance", "₹2,200", "₹3,500", 37, rating = 4.6f),
        StylishProductItem("4", "Puma RS-X", "Futuristic Chunky Sneakers", "₹1,800", "₹3,000", 40, rating = 4.3f),
        StylishProductItem("5", "New Balance 574", "Classic Everyday Suede", "₹2,400", "₹3,800", 36, rating = 4.7f),
        StylishProductItem("6", "Converse All Star", "Chuck Taylor High Tops", "₹1,200", "₹1,999", 40, rating = 4.4f)
    ),
    selectedFilter: String = "All",
    onFilterSelect: (String) -> Unit = {},
    selectedBottomTab: Int = 1,
    onBottomTabSelect: (Int) -> Unit = {},
    onProductClick: (StylishProductItem) -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.md.dp, vertical = WgcCoreDsSpacing.sm.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "52,082+ Items",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = Color(WgcCoreDsColors.trendFashionDark)
                    )

                    Row {
                        WgcChip(
                            label = "Sort",
                            leadingIcon = Icons.Outlined.Sort,
                            onClick = {}
                        )
                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs.dp))
                        WgcChip(
                            label = "Filter",
                            leadingIcon = Icons.Outlined.FilterList,
                            onClick = {}
                        )
                    }
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

                SearchTextField(
                    value = searchQuery,
                    onValueChange = onSearchQueryChange,
                    label = "Search in Trending Products..",
                    leadingIcon = Icons.Default.Search
                )
            }
        },
        bottomBar = {
            WgcBottomNavBar(
                items = listOf(
                    NavItem("Home", Icons.Default.Home) { onBottomTabSelect(0) },
                    NavItem("Wishlist", Icons.Default.FavoriteBorder) { onBottomTabSelect(1) },
                    NavItem("Cart", Icons.Default.ShoppingCart) { onBottomTabSelect(2) },
                    NavItem("Search", Icons.Default.Search) { onBottomTabSelect(3) },
                    NavItem("Settings", Icons.Default.Settings) { onBottomTabSelect(4) }
                ),
                selectedIndex = selectedBottomTab
            )
        }
    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(WgcCoreDsSpacing.md.dp),
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm.dp)
        ) {
            items(products, key = { it.id }) { product ->
                WgcEcommerceProductCard(
                    title = product.title,
                    subtitle = product.subtitle,
                    price = product.price,
                    originalPrice = product.originalPrice,
                    discountPercent = product.discountPercent,
                    rating = product.rating,
                    reviewCount = product.reviewCount,
                    onClick = { onProductClick(product) }
                )
            }
        }
    }
}

/**
 * Tela 11: Shop Page / Product Details (Detalhes do Produto).
 * (Figma ID: 1:17220)
 */
@Composable
fun WgcStylishProductDetailsScreenTemplate(
    modifier: Modifier = Modifier,
    title: String = "NIke Sneakers",
    subtitle: String = "Vision Alta Men's Shoes Size (All Colours)",
    price: String = "₹1,500",
    originalPrice: String = "₹2,499",
    discountPercent: Int = 40,
    rating: Float = 4.5f,
    reviewCount: Int = 56890,
    selectedSize: String = "7 UK",
    sizes: List<String> = listOf("6 UK", "7 UK", "8 UK", "9 UK", "10 UK"),
    onSizeSelect: (String) -> Unit = {},
    onBackClick: () -> Unit = {},
    onGoToCartClick: () -> Unit = {},
    onBuyNowClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.md.dp, vertical = WgcCoreDsSpacing.sm.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Voltar",
                        tint = Color(WgcCoreDsColors.trendFashionDark)
                    )
                }
                IconButton(onClick = onGoToCartClick) {
                    Icon(
                        imageVector = Icons.Default.ShoppingBag,
                        contentDescription = "Carrinho",
                        tint = Color(WgcCoreDsColors.trendFashionDark)
                    )
                }
            }
        },
        bottomBar = {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shadowElevation = 8.dp,
                color = Color.White
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(WgcCoreDsSpacing.md.dp),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md.dp)
                ) {
                    WgcSecondaryClassicButton(
                        textButton = "Go to cart",
                        onClick = onGoToCartClick,
                        modifier = Modifier.weight(1f)
                    )
                    WgcButton(
                        text = "Buy Now",
                        onClick = onBuyNowClick,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = WgcCoreDsSpacing.lg.dp)
        ) {
            // Big Product Preview Hero
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md.dp))
                    .background(Color(WgcCoreDsColors.trendFashionLightGray)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.ShoppingBag,
                    contentDescription = null,
                    tint = Color(WgcCoreDsColors.trendFashionPink),
                    modifier = Modifier.size(90.dp)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))

            // Size Selector Section
            Text(
                text = "Size: $selectedSize",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                color = Color(WgcCoreDsColors.trendFashionDark)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

            Row(
                modifier = Modifier.horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs.dp)
            ) {
                sizes.forEach { size ->
                    WgcSizeSelectorChip(
                        size = size,
                        isSelected = size == selectedSize,
                        onClick = { onSizeSelect(size) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))

            // Title & Description
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                color = Color(WgcCoreDsColors.trendFashionDark)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs.dp))

            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = Color(WgcCoreDsColors.textSecondary)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

            // Rating
            WgcRatingBar(
                rating = rating,
                reviewCount = reviewCount
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))

            // Price Details
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = price,
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                    color = Color(WgcCoreDsColors.trendFashionDark)
                )
                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm.dp))
                Text(
                    text = originalPrice,
                    style = MaterialTheme.typography.titleMedium.copy(textDecoration = TextDecoration.LineThrough),
                    color = Color(WgcCoreDsColors.textSecondary)
                )
                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs.dp))
                Text(
                    text = "$discountPercent% OFF",
                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                    color = Color(WgcCoreDsColors.trendFashionPink)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))

            Text(
                text = "Product Details",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                color = Color(WgcCoreDsColors.trendFashionDark)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs.dp))

            Text(
                text = "Perhaps the most iconic sneaker of all-time, this original 'Chicago' colorway is the cornerstone to any sneaker collection. Crafted with premium materials, cushioned sole and timeless design.",
                style = MaterialTheme.typography.bodySmall,
                color = Color(WgcCoreDsColors.textSecondary)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl.dp))
        }
    }
}

@Preview(name = "Trending Products Preview", showBackground = true)
@Composable
private fun WgcStylishTrendingPreview() {
    WgcStylishTrendingScreenTemplate()
}

@Preview(name = "Product Details Preview", showBackground = true)
@Composable
private fun WgcStylishProductDetailsPreview() {
    WgcStylishProductDetailsScreenTemplate()
}
