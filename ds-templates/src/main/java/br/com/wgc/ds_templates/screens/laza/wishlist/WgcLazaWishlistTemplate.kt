package br.com.wgc.ds_templates.screens.laza.wishlist

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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
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
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcLazaProductCard
import br.com.wgc.ds_templates.screens.laza.home.LazaBottomNavigation
import br.com.wgc.ds_templates.screens.laza.model.LazaMockData
import br.com.wgc.ds_templates.screens.laza.model.LazaProduct

/**
 * Tela de lista de desejos oficial do Laza (WgcLazaWishlistTemplate).
 * Apresenta Top Bar com título centralizado e carrinho com badge,
 * sub-barra com contagem total de itens e botão "Edit", grade de 2 colunas com produtos favoritados
 * e barra de navegação inferior integrada.
 */
@Composable
fun WgcLazaWishlistTemplate(
    modifier: Modifier = Modifier,
    products: List<LazaProduct> = LazaMockData.products.filter { it.isFavorite || it.id == "laza-1" },
    cartCount: Int = 2,
    selectedNavIndex: Int = 1,
    onBackClick: () -> Unit = {},
    onCartClick: () -> Unit = {},
    onEditClick: () -> Unit = {},
    onProductClick: (LazaProduct) -> Unit = {},
    onFavoriteToggle: (LazaProduct) -> Unit = {},
    onNavItemSelected: (Int) -> Unit = {},
    customHeaderSlot: (@Composable () -> Unit)? = null,
    customGridSlot: (@Composable () -> Unit)? = null,
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
            // Top Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = WgcCoreDsSpacing.lg24.dp,
                        vertical = WgcCoreDsSpacing.md16.dp
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier
                        .size(WgcCoreDsSize.s44.dp)
                        .clip(CircleShape)
                        .background(Color(WgcCoreDsColors.lazaSurface))
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Voltar",
                        tint = Color(WgcCoreDsColors.lazaDark),
                        modifier = Modifier.size(WgcCoreDsSize.s22.dp)
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "Wishlist",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.lazaDark)
                )

                Spacer(modifier = Modifier.weight(1f))

                IconButton(
                    onClick = onCartClick,
                    modifier = Modifier
                        .size(WgcCoreDsSize.s44.dp)
                        .clip(CircleShape)
                        .background(Color(WgcCoreDsColors.lazaSurface))
                ) {
                    BadgedBox(
                        badge = {
                            if (cartCount > 0) {
                                Badge(
                                    containerColor = Color(WgcCoreDsColors.lazaPrimary),
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
                            tint = Color(WgcCoreDsColors.lazaDark),
                            modifier = Modifier.size(WgcCoreDsSize.s22.dp)
                        )
                    }
                }
            }

            // Sub-barra informativa (Contagem e Botão Edit)
            if (customHeaderSlot != null) {
                customHeaderSlot()
            } else {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.lg24.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "${products.size} Items",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.lazaDark)
                        )
                        Text(
                            text = "in wishlist",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color(WgcCoreDsColors.lazaSecondaryText)
                        )
                    }

                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                            .background(Color(WgcCoreDsColors.lazaSurface))
                            .clickable(onClick = onEditClick)
                            .padding(
                                horizontal = WgcCoreDsSpacing.md16.dp,
                                vertical = WgcCoreDsSpacing.xs8.dp
                            ),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Editar",
                            tint = Color(WgcCoreDsColors.lazaDark),
                            modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                        )
                        Text(
                            text = "Edit",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium,
                            color = Color(WgcCoreDsColors.lazaDark)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            // Grade de Produtos Favoritados
            if (customGridSlot != null) {
                customGridSlot()
            } else {
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
                    items(products, key = { it.id }) { product ->
                        WgcLazaProductCard(
                            modifier = Modifier.fillMaxWidth(),
                            title = product.title,
                            price = product.price,
                            imageUrl = product.imageUrl,
                            isFavorite = true,
                            onFavoriteClick = { onFavoriteToggle(product) },
                            onClick = { onProductClick(product) }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcLazaWishlistTemplatePreview() {
    WgcLazaWishlistTemplate()
}
