package br.com.wgc.ds_templates.screens.apparel.home

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
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.automirrored.filled.ReceiptLong
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingBag
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcApparelCategoryAvatar
import br.com.wgc.design_system.components.cards.WgcApparelProductCard
import br.com.wgc.design_system.components.images.AsyncImageDefault
import br.com.wgc.ds_templates.screens.apparel.model.ClotheeCategory
import br.com.wgc.ds_templates.screens.apparel.model.ApparelMockData
import br.com.wgc.ds_templates.screens.apparel.model.ClotheeProduct

/**
 * Tela principal do ecossistema Clothee (WgcClotheeHomeTemplate).
 * Apresenta Top Bar com seletor Men/Women e carrinho, barra de busca arredondada,
 * categorias circulares, seções Top Selling e New In, e Bottom Navigation com 4 abas.
 */
@Composable
fun WgcClotheeHomeTemplate(
    modifier: Modifier = Modifier,
    selectedGender: String = "Men",
    searchQuery: String = "",
    cartCount: Int = 2,
    selectedNavIndex: Int = 0,
    categories: List<ClotheeCategory> = ApparelMockData.categories,
    products: List<ClotheeProduct> = ApparelMockData.products,
    onSearchChange: (String) -> Unit = {},
    onGenderToggle: () -> Unit = {},
    onCartClick: () -> Unit = {},
    onCategoryClick: (ClotheeCategory) -> Unit = {},
    onProductClick: (ClotheeProduct) -> Unit = {},
    onProductFavoriteToggle: (ClotheeProduct) -> Unit = {},
    onSeeAllCategories: () -> Unit = {},
    onSeeAllProducts: () -> Unit = {},
    onNavItemSelected: (Int) -> Unit = {},
    customHeaderSlot: (@Composable () -> Unit)? = null,
    customBottomNavSlot: (@Composable () -> Unit)? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        bottomBar = {
            if (customBottomNavSlot != null) {
                customBottomNavSlot()
            } else {
                ClotheeBottomNavigation(
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
                .verticalScroll(rememberScrollState())
        ) {
            if (customHeaderSlot != null) {
                customHeaderSlot()
            } else {
                // Header superior: Avatar + Gender pill + Cart button
                ClotheeHomeTopBar(
                    selectedGender = selectedGender,
                    cartCount = cartCount,
                    onGenderToggle = onGenderToggle,
                    onCartClick = onCartClick
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            // Barra de busca no formato pílula
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.lg24.dp)
            ) {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = onSearchChange,
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = {
                        Text(
                            text = "Search",
                            color = Color(WgcCoreDsColors.apparelSecondaryText)
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                            tint = Color(WgcCoreDsColors.apparelDark)
                        )
                    },
                    shape = RoundedCornerShape(100.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color(WgcCoreDsColors.apparelSurface),
                        unfocusedContainerColor = Color(WgcCoreDsColors.apparelSurface),
                        focusedBorderColor = Color(WgcCoreDsColors.apparelPrimary),
                        unfocusedBorderColor = Color.Transparent
                    ),
                    singleLine = true
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            // Seção de Categorias
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.lg24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Categories",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.apparelDark)
                )

                Text(
                    text = "See All",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(WgcCoreDsColors.apparelDark),
                    modifier = Modifier.clickable(onClick = onSeeAllCategories)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            // Carrossel horizontal de avatares circulares de categorias
            LazyRow(
                contentPadding = PaddingValues(horizontal = WgcCoreDsSpacing.lg24.dp),
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
            ) {
                items(categories) { category ->
                    WgcApparelCategoryAvatar(
                        name = category.name,
                        imageUrl = category.imageUrl,
                        onClick = { onCategoryClick(category) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            // Seção "Top Selling"
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.lg24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Top Selling",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.apparelDark)
                )

                Text(
                    text = "See All",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(WgcCoreDsColors.apparelDark),
                    modifier = Modifier.clickable(onClick = onSeeAllProducts)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            // Carrossel de produtos Top Selling
            LazyRow(
                contentPadding = PaddingValues(horizontal = WgcCoreDsSpacing.lg24.dp),
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
            ) {
                items(products.take(4)) { product ->
                    WgcApparelProductCard(
                        title = product.title,
                        price = product.price,
                        originalPrice = product.originalPrice,
                        imageUrl = product.imageUrl,
                        isFavorite = product.isFavorite,
                        onFavoriteClick = { onProductFavoriteToggle(product) },
                        onClick = { onProductClick(product) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            // Seção "New In"
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.lg24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "New In",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.apparelPrimary)
                )

                Text(
                    text = "See All",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(WgcCoreDsColors.apparelDark),
                    modifier = Modifier.clickable(onClick = onSeeAllProducts)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            // Carrossel de novos lançamentos
            LazyRow(
                contentPadding = PaddingValues(horizontal = WgcCoreDsSpacing.lg24.dp),
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
            ) {
                items(products.drop(2)) { product ->
                    WgcApparelProductCard(
                        title = product.title,
                        price = product.price,
                        originalPrice = product.originalPrice,
                        imageUrl = product.imageUrl,
                        isFavorite = product.isFavorite,
                        onFavoriteClick = { onProductFavoriteToggle(product) },
                        onClick = { onProductClick(product) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))
        }
    }
}

/**
 * Barra superior da Home com avatar, cápsula seletora de gênero e botão de carrinho com badge.
 */
@Composable
private fun ClotheeHomeTopBar(
    selectedGender: String,
    cartCount: Int,
    onGenderToggle: () -> Unit,
    onCartClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = WgcCoreDsSpacing.lg24.dp, vertical = WgcCoreDsSpacing.sm12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Avatar do usuário
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color(WgcCoreDsColors.apparelSurface)),
            contentAlignment = Alignment.Center
        ) {
            AsyncImageDefault(
                image = "https://images.unsplash.com/photo-1534528741775-53994a69daeb?w=100",
                contentDescription = "User Avatar",
                modifier = Modifier.fillMaxSize()
            )
        }

        // Pílula central com dropdown de gênero
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(100.dp))
                .background(Color(WgcCoreDsColors.apparelSurface))
                .clickable(onClick = onGenderToggle)
                .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = selectedGender,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.apparelDark)
            )
            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "Select Gender",
                tint = Color(WgcCoreDsColors.apparelDark),
                modifier = Modifier.size(18.dp)
            )
        }

        // Botão circular de Carrinho na cor roxa
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color(WgcCoreDsColors.apparelPrimary))
                .clickable(onClick = onCartClick),
            contentAlignment = Alignment.Center
        ) {
            BadgedBox(
                badge = {
                    if (cartCount > 0) {
                        Badge(
                            containerColor = Color(WgcCoreDsColors.apparelAlertRed),
                            contentColor = Color.White
                        ) {
                            Text(text = cartCount.toString())
                        }
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Default.ShoppingBag,
                    contentDescription = "Cart",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}

/**
 * Bottom Navigation com 4 abas do Clothee: Home, Notifications, Orders e Profile.
 */
@Composable
private fun ClotheeBottomNavigation(
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit
) {
    NavigationBar(
        containerColor = Color.White,
        tonalElevation = 8.dp
    ) {
        val items = listOf(
            Triple("Home", Icons.Default.Home, 0),
            Triple("Notifications", Icons.Default.Notifications, 1),
            Triple("Orders", Icons.AutoMirrored.Filled.ReceiptLong, 2),
            Triple("Profile", Icons.Default.Person, 3)
        )

        items.forEach { (label, icon, index) ->
            val isSelected = selectedIndex == index
            NavigationBarItem(
                selected = isSelected,
                onClick = { onItemSelected(index) },
                icon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = label
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(WgcCoreDsColors.apparelPrimary),
                    selectedTextColor = Color(WgcCoreDsColors.apparelPrimary),
                    unselectedIconColor = Color(WgcCoreDsColors.apparelSecondaryText),
                    unselectedTextColor = Color(WgcCoreDsColors.apparelSecondaryText),
                    indicatorColor = Color(WgcCoreDsColors.apparelPrimaryLight)
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcClotheeHomeTemplatePreview() {
    WgcClotheeHomeTemplate()
}
