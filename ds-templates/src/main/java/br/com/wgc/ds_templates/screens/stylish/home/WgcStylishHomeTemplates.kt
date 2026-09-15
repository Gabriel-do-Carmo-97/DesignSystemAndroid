package br.com.wgc.ds_templates.screens.stylish.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Mic
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.avatar.WgcAvatar
import br.com.wgc.design_system.components.cards.WgcDealOfTheDayCard
import br.com.wgc.design_system.components.cards.WgcEcommerceProductCard
import br.com.wgc.design_system.components.fields.SearchTextField
import br.com.wgc.design_system.components.navigation.NavItem
import br.com.wgc.design_system.components.navigation.WgcBottomNavBar
import br.com.wgc.ds_templates.screens.stylish.model.StylishCategoryItem
import br.com.wgc.ds_templates.screens.stylish.model.StylishProductItem

/**
 * Tela 9: Home Page do Stylish eCommerce UI Kit.
 * (Figma ID: 1:17021)
 */
@Composable
fun WgcStylishHomeScreenTemplate(
    modifier: Modifier = Modifier,
    searchQuery: String = "",
    onSearchQueryChange: (String) -> Unit = {},
    selectedCategory: String = "All",
    onCategorySelect: (String) -> Unit = {},
    selectedBottomTab: Int = 0,
    onBottomTabSelect: (Int) -> Unit = {},
    onProductClick: (StylishProductItem) -> Unit = {},
    onViewAllDealsClick: () -> Unit = {},
    topBarSlot: (@Composable () -> Unit)? = null,
    bannerSlot: (@Composable () -> Unit)? = null,
    categoriesSlot: (@Composable () -> Unit)? = null,
    dealSlot: (@Composable () -> Unit)? = null,
    productsSlot: (@Composable () -> Unit)? = null,
    bottomBarSlot: (@Composable () -> Unit)? = null
) {
    val defaultCategories = listOf(
        StylishCategoryItem("1", "Beauty"),
        StylishCategoryItem("2", "Fashion"),
        StylishCategoryItem("3", "Kids"),
        StylishCategoryItem("4", "Mens"),
        StylishCategoryItem("5", "Womens")
    )

    val sampleProducts = listOf(
        StylishProductItem(
            id = "1",
            title = "Nike Sneakers",
            subtitle = "Vision Alta Men's Shoes",
            price = "₹1,500",
            originalPrice = "₹2,499",
            discountPercent = 40,
            rating = 4.5f,
            reviewCount = 56890
        ),
        StylishProductItem(
            id = "2",
            title = "Jordan Retro 4",
            subtitle = "Men's High Top Basketball Shoes",
            price = "₹3,999",
            originalPrice = "₹6,999",
            discountPercent = 43,
            rating = 4.8f,
            reviewCount = 12430
        ),
        StylishProductItem(
            id = "3",
            title = "Adidas Ultraboost",
            subtitle = "Light Running Performance Shoes",
            price = "₹2,200",
            originalPrice = "₹3,500",
            discountPercent = 37,
            rating = 4.6f,
            reviewCount = 8920
        )
    )

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            topBarSlot?.invoke() ?: Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.md.dp, vertical = WgcCoreDsSpacing.sm.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu Lateral",
                        tint = Color(WgcCoreDsColors.stylishDark)
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm.dp))
                            .background(Color(WgcCoreDsColors.stylishPink)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.ShoppingBag,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs.dp))
                    Text(
                        text = "Stylish",
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Black),
                        color = Color(WgcCoreDsColors.stylishPink)
                    )
                }

                WgcAvatar(
                    initials = "GC",
                    size = 36.dp
                )
            }
        },
        bottomBar = {
            bottomBarSlot?.invoke() ?: WgcBottomNavBar(
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            // 1. Search Bar
            Box(modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.md.dp)) {
                SearchTextField(
                    value = searchQuery,
                    onValueChange = onSearchQueryChange,
                    label = "Search any Product..",
                    leadingIcon = Icons.Default.Search
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))

            // 2. Banner Promocional
            bannerSlot?.invoke() ?: Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.md.dp),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md.dp),
                colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.stylishPink))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(WgcCoreDsSpacing.lg.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "50-40% OFF",
                            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Black),
                            color = Color.White
                        )
                        Text(
                            text = "Now in (product)\nAll colours",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.White.copy(alpha = 0.9f)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm.dp))
                            .background(Color.White)
                            .padding(horizontal = WgcCoreDsSpacing.sm.dp, vertical = WgcCoreDsSpacing.xs.dp)
                    ) {
                        Text(
                            text = "Shop Now ->",
                            style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                            color = Color(WgcCoreDsColors.stylishPink)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg.dp))

            // 3. Categorias Circulares
            categoriesSlot?.invoke() ?: Column(
                modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.md.dp)
            ) {
                Text(
                    text = "All Featured",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    color = Color(WgcCoreDsColors.stylishDark)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

                Row(
                    modifier = Modifier.horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md.dp)
                ) {
                    defaultCategories.forEach { cat ->
                        val isSel = cat.name == selectedCategory
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.clickable { onCategorySelect(cat.name) }
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(56.dp)
                                    .clip(CircleShape)
                                    .background(
                                        if (isSel) Color(WgcCoreDsColors.stylishPink)
                                        else Color(WgcCoreDsColors.stylishLightGray)
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = cat.name.take(1),
                                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                    color = if (isSel) Color.White else Color(WgcCoreDsColors.stylishDark)
                                )
                            }
                            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs.dp))
                            Text(
                                text = cat.name,
                                style = MaterialTheme.typography.labelSmall.copy(
                                    fontWeight = if (isSel) FontWeight.Bold else FontWeight.Normal
                                ),
                                color = Color(WgcCoreDsColors.stylishDark)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg.dp))

            // 4. Deal of the Day Banner
            dealSlot?.invoke() ?: Box(modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.md.dp)) {
                WgcDealOfTheDayCard(
                    title = "Deal of the Day",
                    remainingTime = "22h 55m 20s remaining",
                    onViewAllClick = onViewAllDealsClick
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))

            // 5. Produtos em Destaque (Carrossel Horizontal)
            productsSlot?.invoke() ?: Column(
                modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.md.dp)
            ) {
                Row(
                    modifier = Modifier.horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm.dp)
                ) {
                    sampleProducts.forEach { prod ->
                        Box(modifier = Modifier.width(170.dp)) {
                            WgcEcommerceProductCard(
                                title = prod.title,
                                subtitle = prod.subtitle,
                                price = prod.price,
                                originalPrice = prod.originalPrice,
                                discountPercent = prod.discountPercent,
                                rating = prod.rating,
                                reviewCount = prod.reviewCount,
                                onClick = { onProductClick(prod) }
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl.dp))
        }
    }
}

@Preview(name = "Home Screen Preview", showBackground = true)
@Composable
private fun WgcStylishHomeScreenPreview() {
    var query by remember { mutableStateOf("") }
    WgcStylishHomeScreenTemplate(
        searchQuery = query,
        onSearchQueryChange = { query = it }
    )
}
