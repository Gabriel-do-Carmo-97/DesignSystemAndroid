package br.com.wgc.ds_templates.screens.megastore.home

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
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcMegaStoreFlashSaleBanner
import br.com.wgc.design_system.components.cards.WgcMegaStoreProductCard
import br.com.wgc.design_system.components.chip.WgcChip
import br.com.wgc.design_system.components.fields.SearchTextField
import br.com.wgc.design_system.components.navigation.NavItem
import br.com.wgc.design_system.components.navigation.WgcBottomNavBar
import br.com.wgc.design_system.components.story.WgcMegaStoreStoryAvatar
import br.com.wgc.ds_templates.screens.megastore.model.ShoppeCategoryItem
import br.com.wgc.ds_templates.screens.megastore.model.ShoppeProductItem
import br.com.wgc.ds_templates.screens.megastore.model.ShoppeStoryItem

/**
 * Telas 13 a 28: Vitrine Oficial Shoppe (Shop, Flash Sale, Story Commerce, Categorias).
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcShoppeHomeScreenTemplate(
    modifier: Modifier = Modifier,
    searchQuery: String = "",
    onSearchQueryChange: (String) -> Unit = {},
    onCameraSearchClick: () -> Unit = {},
    stories: List<ShoppeStoryItem> = listOf(
        ShoppeStoryItem("1", "Live Show", "https://images.unsplash.com/photo-1534528741775-53994a69daeb?w=300", isLive = true),
        ShoppeStoryItem("2", "Summer", "https://images.unsplash.com/photo-1517841905240-472988babdf9?w=300"),
        ShoppeStoryItem("3", "Accessories", "https://images.unsplash.com/photo-1539571696357-5a69c17a67c6?w=300"),
        ShoppeStoryItem("4", "Denim Style", "https://images.unsplash.com/photo-1524504388940-b1c1722653e1?w=300"),
        ShoppeStoryItem("5", "Shoes Sale", "https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?w=300")
    ),
    categories: List<String> = listOf("All", "Women", "Men", "Shoes", "Bags", "Kids"),
    selectedCategoryIndex: Int = 0,
    onCategorySelect: (Int) -> Unit = {},
    products: List<ShoppeProductItem> = listOf(
        ShoppeProductItem("1", "Pastel Long Sleeve", "Clothing", "$34.00", "$45.00", 25, 4.8f),
        ShoppeProductItem("2", "Casual Oversized Hoodie", "Hoodies", "$49.00", "$70.00", 30, 4.9f),
        ShoppeProductItem("3", "Slim Straight Jeans", "Denim", "$58.00", null, null, 4.7f),
        ShoppeProductItem("4", "Summer Floral Dress", "Dresses", "$42.00", "$60.00", 30, 4.6f)
    ),
    selectedBottomTab: Int = 0,
    onBottomTabSelect: (Int) -> Unit = {},
    onProductClick: (ShoppeProductItem) -> Unit = {},
    topBarSlot: (@Composable () -> Unit)? = null,
    bottomBarSlot: (@Composable () -> Unit)? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            topBarSlot?.invoke() ?: TopAppBar(
                title = {
                    Text(
                        text = "Shoppe",
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Black),
                        color = Color(WgcCoreDsColors.megaStorePrimary)
                    )
                },
                actions = {
                    IconButton(onClick = onCameraSearchClick) {
                        Icon(
                            imageVector = Icons.Default.CameraAlt,
                            contentDescription = "Visual Search",
                            tint = Color(WgcCoreDsColors.megaStoreDark)
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "Notificações",
                            tint = Color(WgcCoreDsColors.megaStoreDark)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        },
        bottomBar = {
            bottomBarSlot?.invoke() ?: WgcBottomNavBar(
                items = listOf(
                    NavItem("Shop", Icons.Default.ShoppingBag) { onBottomTabSelect(0) },
                    NavItem("Explore", Icons.Default.Tune) { onBottomTabSelect(1) },
                    NavItem("Camera", Icons.Default.CameraAlt) { onCameraSearchClick() },
                    NavItem("Profile", Icons.Default.Person) { onBottomTabSelect(3) }
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
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md.dp)
        ) {
            // 1. Search Field
            item(span = { GridItemSpan(2) }) {
                SearchTextField(
                    value = searchQuery,
                    onValueChange = onSearchQueryChange,
                    label = "Search fashion, items, brands..",
                    leadingIcon = Icons.Default.Search
                )
            }

            // 2. Story Commerce Tray
            item(span = { GridItemSpan(2) }) {
                Column {
                    Text(
                        text = "Live & Stories",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = Color(WgcCoreDsColors.megaStoreDark)
                    )
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs.dp))
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md.dp),
                        contentPadding = PaddingValues(vertical = WgcCoreDsSpacing.xs.dp)
                    ) {
                        items(stories) { story ->
                            WgcMegaStoreStoryAvatar(
                                name = story.name,
                                imageUrl = story.imageUrl,
                                isLive = story.isLive,
                                hasUnseenStory = story.hasUnseen
                            )
                        }
                    }
                }
            }

            // 3. Flash Sale Countdown Banner
            item(span = { GridItemSpan(2) }) {
                WgcMegaStoreFlashSaleBanner()
            }

            // 4. Categories Chips
            item(span = { GridItemSpan(2) }) {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs.dp)) {
                    items(categories.size) { index ->
                        WgcChip(
                            label = categories[index],
                            selected = selectedCategoryIndex == index,
                            onClick = { onCategorySelect(index) }
                        )
                    }
                }
            }

            // 5. Popular Products Feed
            items(products) { product ->
                WgcMegaStoreProductCard(
                    title = product.title,
                    category = product.category,
                    price = product.price,
                    originalPrice = product.originalPrice,
                    discountPercent = product.discountPercent,
                    rating = product.rating,
                    imageUrl = product.imageUrl,
                    onClick = { onProductClick(product) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcShoppeHomeScreenTemplatePreview() {
    MaterialTheme {
        WgcShoppeHomeScreenTemplate()
    }
}
