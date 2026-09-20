package br.com.wgc.design_system.templates.screens.retail.home

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcRetailCategoryCard
import br.com.wgc.design_system.components.cards.WgcRetailProductCard
import br.com.wgc.design_system.components.images.AsyncImageDefault
import br.com.wgc.design_system.templates.screens.retail.model.KutukuCategoryItem
import br.com.wgc.design_system.templates.screens.retail.model.RetailMockData
import br.com.wgc.design_system.templates.screens.retail.model.KutukuProduct

/**
 * Header superior com saudação, avatar do usuário, busca e notificações.
 */
@Composable
fun WgcKutukuHeader(
    modifier: Modifier = Modifier,
    userName: String = "Jonathan",
    subtitle: String = "Let's go shopping",
    avatarUrl: String? = null,
    hasUnreadNotification: Boolean = true,
    onSearchClick: () -> Unit = {},
    onNotificationClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = WgcCoreDsSpacing.md.dp, vertical = WgcCoreDsSpacing.sm.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(Color(WgcCoreDsColors.retailPrimaryLight)),
                contentAlignment = Alignment.Center
            ) {
                if (!avatarUrl.isNullOrEmpty()) {
                    AsyncImageDefault(
                        image = avatarUrl,
                        contentDescription = userName,
                        modifier = Modifier.fillMaxSize()
                    )
                } else {
                    Text(
                        text = userName.take(1).uppercase(),
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.retailPrimary)
                    )
                }
            }

            Column {
                Text(
                    text = "Hi, $userName",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.retailDark)
                )
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(WgcCoreDsColors.retailSecondaryText)
                )
            }
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onSearchClick) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Buscar",
                    tint = Color(WgcCoreDsColors.retailDark)
                )
            }

            Box(contentAlignment = Alignment.TopEnd) {
                IconButton(onClick = onNotificationClick) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = "Notificações",
                        tint = Color(WgcCoreDsColors.retailDark)
                    )
                }
                if (hasUnreadNotification) {
                    Box(
                        modifier = Modifier
                            .padding(top = WgcCoreDsSpacing.xs.dp, end = WgcCoreDsSpacing.xs.dp)
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(Color(WgcCoreDsColors.retailAlertRed))
                    )
                }
            }
        }
    }
}

/**
 * Banner Promocional com estilo Kutuku (fundo lilás pastel e detalhes gráficos).
 */
@Composable
fun WgcKutukuPromoBanner(
    modifier: Modifier = Modifier,
    title: String = "24% off shipping today on bag purchases",
    subtitle: String = "By Kutuku Store",
    imageUrl: String? = null,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = WgcCoreDsSpacing.md.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xl.dp))
                .background(Color(WgcCoreDsColors.retailBackground))
                .clickable(onClick = onClick)
        ) {
            // Detalhe gráfico lateral esquerdo
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color(WgcCoreDsColors.retailSecondary).copy(alpha = 0.6f))
            )

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(WgcCoreDsSpacing.md.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.retailDark)
                    )
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs.dp))
                    Text(
                        text = subtitle,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(WgcCoreDsColors.retailSecondaryText)
                    )
                }

                if (!imageUrl.isNullOrEmpty()) {
                    AsyncImageDefault(
                        image = imageUrl,
                        contentDescription = "Promoção",
                        modifier = Modifier
                            .size(110.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md.dp))
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs.dp))

        // Indicadores em Dots
        Row(
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(6.dp)
                    .clip(CircleShape)
                    .background(Color(WgcCoreDsColors.retailPrimary))
            )
            Box(
                modifier = Modifier
                    .size(6.dp)
                    .clip(CircleShape)
                    .background(Color(WgcCoreDsColors.retailBorder))
            )
            Box(
                modifier = Modifier
                    .size(6.dp)
                    .clip(CircleShape)
                    .background(Color(WgcCoreDsColors.retailBorder))
            )
        }
    }
}

/**
 * Bottom Bar com ícones oficiais Kutuku (Home, Order, Favorite, Profile).
 */
@Composable
fun WgcKutukuBottomBar(
    selectedIndex: Int = 0,
    onItemSelected: (Int) -> Unit = {}
) {
    val items = listOf(
        Pair("Home", Icons.Default.Home),
        Pair("My Order", Icons.Default.LocalShipping),
        Pair("Favorite", Icons.Default.Favorite),
        Pair("My Profile", Icons.Default.Person)
    )

    NavigationBar(
        containerColor = Color(WgcCoreDsColors.retailSurface),
        tonalElevation = 8.dp
    ) {
        items.forEachIndexed { index, item ->
            val isSelected = selectedIndex == index
            NavigationBarItem(
                selected = isSelected,
                onClick = { onItemSelected(index) },
                icon = {
                    Icon(
                        imageVector = item.second,
                        contentDescription = item.first,
                        tint = if (isSelected) Color(WgcCoreDsColors.retailPrimary) else Color(WgcCoreDsColors.retailSecondaryText)
                    )
                },
                label = {
                    Text(
                        text = item.first,
                        style = MaterialTheme.typography.labelSmall,
                        color = if (isSelected) Color(WgcCoreDsColors.retailPrimary) else Color(WgcCoreDsColors.retailSecondaryText)
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color(WgcCoreDsColors.retailPrimaryLight)
                )
            )
        }
    }
}

/**
 * Tela Inicial (Home Feed) oficial do Kutuku.
 */
@Composable
fun WgcKutukuHomeScreen(
    modifier: Modifier = Modifier,
    userName: String = "Jonathan",
    products: List<KutukuProduct> = RetailMockData.sampleProducts,
    onCategoryTabSelected: () -> Unit = {},
    onProductClick: (KutukuProduct) -> Unit = {},
    onFavoriteToggle: (KutukuProduct) -> Unit = {},
    onSeeAllClick: () -> Unit = {}
) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    var selectedBottomNavIndex by remember { mutableIntStateOf(0) }

    Scaffold(
        modifier = modifier,
        bottomBar = {
            WgcKutukuBottomBar(
                selectedIndex = selectedBottomNavIndex,
                onItemSelected = { selectedBottomNavIndex = it }
            )
        }
    ) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .background(Color(WgcCoreDsColors.retailSurface))
                .padding(paddingValues),
            contentPadding = PaddingValues(WgcCoreDsSpacing.md.dp),
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md.dp)
        ) {
            // Header e Tabs ocupam toda a largura
            item(span = { GridItemSpan(2) }) {
                Column {
                    WgcKutukuHeader(userName = userName)

                    TabRow(
                        selectedTabIndex = selectedTabIndex,
                        containerColor = Color.Transparent,
                        indicator = { tabPositions ->
                            TabRowDefaults.SecondaryIndicator(
                                Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                                color = Color(WgcCoreDsColors.retailPrimary)
                            )
                        },
                        divider = {}
                    ) {
                        Tab(
                            selected = selectedTabIndex == 0,
                            onClick = { selectedTabIndex = 0 },
                            text = {
                                Text(
                                    "Home",
                                    fontWeight = if (selectedTabIndex == 0) FontWeight.Bold else FontWeight.Normal,
                                    color = if (selectedTabIndex == 0) Color(WgcCoreDsColors.retailDark) else Color(WgcCoreDsColors.retailSecondaryText)
                                )
                            }
                        )
                        Tab(
                            selected = selectedTabIndex == 1,
                            onClick = {
                                selectedTabIndex = 1
                                onCategoryTabSelected()
                            },
                            text = {
                                Text(
                                    "Category",
                                    fontWeight = if (selectedTabIndex == 1) FontWeight.Bold else FontWeight.Normal,
                                    color = if (selectedTabIndex == 1) Color(WgcCoreDsColors.retailDark) else Color(WgcCoreDsColors.retailSecondaryText)
                                )
                            }
                        )
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))

                    WgcKutukuPromoBanner()

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "New Arrivals 🔥",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.retailDark)
                        )
                        TextButton(onClick = onSeeAllClick) {
                            Text(
                                text = "See All",
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.SemiBold,
                                color = Color(WgcCoreDsColors.retailPrimary)
                            )
                        }
                    }
                }
            }

            // Grade de Produtos
            items(products) { product ->
                WgcRetailProductCard(
                    title = product.title,
                    subtitle = product.subtitle,
                    price = product.price,
                    imageUrl = product.imageUrl,
                    isFavorite = product.isFavorite,
                    onFavoriteClick = { onFavoriteToggle(product) },
                    onClick = { onProductClick(product) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

/**
 * Tela de Categorias oficial do Kutuku.
 */
@Composable
fun WgcKutukuCategoryScreen(
    modifier: Modifier = Modifier,
    categories: List<KutukuCategoryItem> = RetailMockData.sampleCategories,
    onHomeTabSelected: () -> Unit = {},
    onCategoryClick: (KutukuCategoryItem) -> Unit = {}
) {
    var selectedBottomNavIndex by remember { mutableIntStateOf(0) }

    Scaffold(
        modifier = modifier,
        bottomBar = {
            WgcKutukuBottomBar(
                selectedIndex = selectedBottomNavIndex,
                onItemSelected = { selectedBottomNavIndex = it }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(WgcCoreDsColors.retailSurface))
                .padding(paddingValues),
            contentPadding = PaddingValues(WgcCoreDsSpacing.md.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md.dp)
        ) {
            item {
                WgcKutukuHeader()

                TabRow(
                    selectedTabIndex = 1,
                    containerColor = Color.Transparent,
                    indicator = { tabPositions ->
                        TabRowDefaults.SecondaryIndicator(
                            Modifier.tabIndicatorOffset(tabPositions[1]),
                            color = Color(WgcCoreDsColors.retailPrimary)
                        )
                    },
                    divider = {}
                ) {
                    Tab(
                        selected = false,
                        onClick = onHomeTabSelected,
                        text = {
                            Text(
                                "Home",
                                color = Color(WgcCoreDsColors.retailSecondaryText)
                            )
                        }
                    )
                    Tab(
                        selected = true,
                        onClick = {},
                        text = {
                            Text(
                                "Category",
                                fontWeight = FontWeight.Bold,
                                color = Color(WgcCoreDsColors.retailDark)
                            )
                        }
                    )
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))
            }

            items(categories) { category ->
                WgcRetailCategoryCard(
                    title = category.title,
                    productCountText = category.productCountText,
                    imageUrl = category.imageUrl,
                    isImageOnLeft = category.isImageOnLeft,
                    onClick = { onCategoryClick(category) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcKutukuHomeScreenPreview() {
    WgcKutukuHomeScreen()
}

@Preview(showBackground = true)
@Composable
private fun WgcKutukuCategoryScreenPreview() {
    WgcKutukuCategoryScreen()
}
