package br.com.wgc.design_system.templates.screens.quickshop.favorites

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.DeleteOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.navigation.WgcQuickShopBottomNav
import br.com.wgc.design_system.components.navigation.WgcShopEaseNavItem
import br.com.wgc.design_system.templates.screens.quickshop.model.ShopEaseMockData
import br.com.wgc.design_system.templates.screens.quickshop.model.ShopEaseProduct

/**
 * Tela Favourites / Wishlist ShopEase:
 * - Curva de topo sunset orange com título "Favourites"
 * - Lista de cards de produtos favoritos com opções de remover e comprar
 */
@Composable
fun WgcShopEaseFavoritesTemplate(
    favoriteProducts: List<ShopEaseProduct> = ShopEaseMockData.products.filter { it.isFavorite },
    onProductClick: (ShopEaseProduct) -> Unit = {},
    onRemoveFavorite: (ShopEaseProduct) -> Unit = {},
    onBackClick: () -> Unit = {},
    selectedNav: WgcShopEaseNavItem = WgcShopEaseNavItem.Favourites,
    onNavSelect: (WgcShopEaseNavItem) -> Unit = {},
    bottomNavSlot: (@Composable () -> Unit)? = null,
    modifier: Modifier = Modifier
) {
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
        ) {
            // Header Curvo Sunset
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            bottomStart = WgcCoreDsBorderRadius.xxl24.dp,
                            bottomEnd = WgcCoreDsBorderRadius.xxl24.dp
                        )
                    )
                    .background(Color(WgcCoreDsColors.quickShopPrimary))
                    .padding(
                        horizontal = WgcCoreDsSpacing.lg24.dp,
                        vertical = WgcCoreDsSpacing.md16.dp
                    )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = onBackClick,
                        modifier = Modifier
                            .size(WgcCoreDsSize.s40.dp)
                            .clip(CircleShape)
                            .background(Color.White.copy(alpha = 0.2f))
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md16.dp))

                    Text(
                        text = "Favourites",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = WgcCoreDsSpacing.lg24.dp)
            ) {
                items(favoriteProducts) { prod ->
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                            .background(prod.backgroundColor)
                            .padding(WgcCoreDsSpacing.md16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "👟",
                            style = MaterialTheme.typography.headlineMedium
                        )

                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md16.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = prod.title,
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold,
                                color = Color(WgcCoreDsColors.quickShopDark)
                            )
                            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                            Text(
                                text = prod.price,
                                style = MaterialTheme.typography.labelLarge,
                                fontWeight = FontWeight.Bold,
                                color = Color(WgcCoreDsColors.quickShopPrimaryDark)
                            )
                        }

                        IconButton(
                            onClick = { onRemoveFavorite(prod) },
                            modifier = Modifier
                                .size(WgcCoreDsSize.s32.dp)
                                .clip(CircleShape)
                                .background(Color.White)
                        ) {
                            Icon(
                                imageVector = Icons.Default.DeleteOutline,
                                contentDescription = "Remove",
                                tint = Color.Red,
                                modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                            )
                        }
                    }
                }

                item {
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcShopEaseFavoritesTemplatePreview() {
    WgcShopEaseFavoritesTemplate()
}
