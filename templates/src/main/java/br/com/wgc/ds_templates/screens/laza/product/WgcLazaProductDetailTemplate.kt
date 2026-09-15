package br.com.wgc.ds_templates.screens.laza.product

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcLazaBottomNavButton
import br.com.wgc.design_system.components.images.AsyncImageDefault
import br.com.wgc.ds_templates.screens.laza.model.LazaMockData
import br.com.wgc.ds_templates.screens.laza.model.LazaProduct
import br.com.wgc.ds_templates.screens.laza.model.LazaReview

/**
 * Tela de detalhes de produto oficial do Laza (WgcLazaProductDetailTemplate).
 * Apresenta galeria de imagens ampla com carrossel de miniaturas, título, categoria,
 * seletor de tamanhos em pills, descrição, prévia da avaliação com estrelas douradas
 * e barra fixa inferior com preço total e CTA "Add to Cart".
 */
@Composable
fun WgcLazaProductDetailTemplate(
    modifier: Modifier = Modifier,
    product: LazaProduct = LazaMockData.products[0],
    cartCount: Int = 2,
    selectedSize: String = "M",
    selectedImageIndex: Int = 0,
    reviews: List<LazaReview> = LazaMockData.reviews,
    onBackClick: () -> Unit = {},
    onFavoriteToggle: () -> Unit = {},
    onCartClick: () -> Unit = {},
    onSizeSelected: (String) -> Unit = {},
    onImageSelected: (Int) -> Unit = {},
    onViewAllReviews: () -> Unit = {},
    onAddToCartClick: () -> Unit = {},
    customGallerySlot: (@Composable () -> Unit)? = null,
    customSizeSelectorSlot: (@Composable () -> Unit)? = null,
    customReviewsSlot: (@Composable () -> Unit)? = null,
    customBottomBarSlot: (@Composable () -> Unit)? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        bottomBar = {
            if (customBottomBarSlot != null) {
                customBottomBarSlot()
            } else {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                horizontal = WgcCoreDsSpacing.lg24.dp,
                                vertical = WgcCoreDsSpacing.sm12.dp
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "Total Price",
                                style = MaterialTheme.typography.labelSmall,
                                color = Color(WgcCoreDsColors.lazaSecondaryText)
                            )
                            Text(
                                text = "with VAT,SD",
                                style = MaterialTheme.typography.labelSmall,
                                color = Color(WgcCoreDsColors.lazaSecondaryText)
                            )
                        }

                        Text(
                            text = product.price,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.lazaDark)
                        )
                    }

                    WgcLazaBottomNavButton(
                        label = "Add to Cart",
                        onClick = onAddToCartClick
                    )
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {
            // Top Bar com Back, Favorite e Cart
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

                Row(horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
                    IconButton(
                        onClick = onFavoriteToggle,
                        modifier = Modifier
                            .size(WgcCoreDsSize.s44.dp)
                            .clip(CircleShape)
                            .background(Color(WgcCoreDsColors.lazaSurface))
                    ) {
                        Icon(
                            imageVector = if (product.isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                            contentDescription = "Favoritar",
                            tint = if (product.isFavorite) Color(WgcCoreDsColors.lazaAlertRed) else Color(WgcCoreDsColors.lazaDark),
                            modifier = Modifier.size(WgcCoreDsSize.s22.dp)
                        )
                    }

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
            }

            // Galeria de imagens
            if (customGallerySlot != null) {
                customGallerySlot()
            } else {
                val gallery = if (product.galleryImages.isNotEmpty()) product.galleryImages else listOfNotNull(product.imageUrl)
                val activeImage = gallery.getOrNull(selectedImageIndex) ?: product.imageUrl

                // Imagem Principal
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(WgcCoreDsSize.s280.dp)
                        .padding(horizontal = WgcCoreDsSpacing.lg24.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                        .background(Color(WgcCoreDsColors.lazaSurface)),
                    contentAlignment = Alignment.Center
                ) {
                    if (!activeImage.isNullOrEmpty()) {
                        AsyncImageDefault(
                            image = activeImage,
                            contentDescription = product.title,
                            modifier = Modifier.fillMaxSize()
                        )
                    } else {
                        Text(
                            text = product.title.take(2).uppercase(),
                            style = MaterialTheme.typography.displaySmall,
                            color = Color(WgcCoreDsColors.lazaPrimary),
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                // Carrossel de Miniaturas
                if (gallery.size > 1) {
                    LazyRow(
                        modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.lg24.dp),
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                    ) {
                        items(gallery.indices.toList()) { index ->
                            val isCurrent = index == selectedImageIndex
                            Box(
                                modifier = Modifier
                                    .size(WgcCoreDsSize.s64.dp)
                                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                                    .background(Color(WgcCoreDsColors.lazaSurface))
                                    .border(
                                        width = if (isCurrent) WgcCoreDsSpacing.xxxs2.dp else WgcCoreDsSpacing.none0.dp,
                                        color = if (isCurrent) Color(WgcCoreDsColors.lazaPrimary) else Color.Transparent,
                                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp)
                                    )
                                    .clickable { onImageSelected(index) },
                                contentAlignment = Alignment.Center
                            ) {
                                AsyncImageDefault(
                                    image = gallery[index],
                                    contentDescription = "Miniatura $index",
                                    modifier = Modifier.fillMaxSize().padding(WgcCoreDsSpacing.xxs4.dp)
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            // Informações do Produto (Título e Preço)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.lg24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = product.category,
                        style = MaterialTheme.typography.labelSmall,
                        color = Color(WgcCoreDsColors.lazaSecondaryText)
                    )
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxxs2.dp))
                    Text(
                        text = product.title,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.lazaDark)
                    )
                }

                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md16.dp))

                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = "Price",
                        style = MaterialTheme.typography.labelSmall,
                        color = Color(WgcCoreDsColors.lazaSecondaryText)
                    )
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxxs2.dp))
                    Text(
                        text = product.price,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.lazaDark)
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            // Seletor de Tamanhos
            if (customSizeSelectorSlot != null) {
                customSizeSelectorSlot()
            } else {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.lg24.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Size",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.lazaDark)
                        )

                        Text(
                            text = "Size Guide",
                            style = MaterialTheme.typography.labelMedium,
                            color = Color(WgcCoreDsColors.lazaSecondaryText)
                        )
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                    ) {
                        product.availableSizes.forEach { size ->
                            val isChosen = size == selectedSize
                            Box(
                                modifier = Modifier
                                    .size(WgcCoreDsSize.s48.dp)
                                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                                    .background(
                                        if (isChosen) Color(WgcCoreDsColors.lazaPrimary)
                                        else Color(WgcCoreDsColors.lazaSurface)
                                    )
                                    .clickable { onSizeSelected(size) },
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = size,
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isChosen) Color.White else Color(WgcCoreDsColors.lazaDark)
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            // Descrição do Produto
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.lg24.dp)
            ) {
                Text(
                    text = "Description",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.lazaDark)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                Text(
                    text = product.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(WgcCoreDsColors.lazaSecondaryText)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            // Avaliações (Reviews)
            if (customReviewsSlot != null) {
                customReviewsSlot()
            } else {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.lg24.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Reviews",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.lazaDark)
                        )

                        TextButton(onClick = onViewAllReviews) {
                            Text(
                                text = "View All",
                                style = MaterialTheme.typography.labelMedium,
                                color = Color(WgcCoreDsColors.lazaSecondaryText)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                    val topReview = reviews.firstOrNull()
                    if (topReview != null) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                                .background(Color(WgcCoreDsColors.lazaSurface))
                                .padding(WgcCoreDsSpacing.md16.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Box(
                                        modifier = Modifier
                                            .size(WgcCoreDsSize.s40.dp)
                                            .clip(CircleShape)
                                            .background(Color.White),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        if (!topReview.avatarUrl.isNullOrEmpty()) {
                                            AsyncImageDefault(
                                                image = topReview.avatarUrl,
                                                contentDescription = topReview.authorName,
                                                modifier = Modifier.fillMaxSize()
                                            )
                                        } else {
                                            Text(
                                                text = topReview.authorName.take(1),
                                                fontWeight = FontWeight.Bold,
                                                color = Color(WgcCoreDsColors.lazaPrimary)
                                            )
                                        }
                                    }

                                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))

                                    Column {
                                        Text(
                                            text = topReview.authorName,
                                            style = MaterialTheme.typography.bodyMedium,
                                            fontWeight = FontWeight.Bold,
                                            color = Color(WgcCoreDsColors.lazaDark)
                                        )
                                        Text(
                                            text = topReview.date,
                                            style = MaterialTheme.typography.labelSmall,
                                            color = Color(WgcCoreDsColors.lazaSecondaryText)
                                        )
                                    }
                                }

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        text = "${topReview.rating}",
                                        style = MaterialTheme.typography.bodySmall,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(WgcCoreDsColors.lazaDark)
                                    )
                                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "Estrela",
                                        tint = Color(WgcCoreDsColors.lazaGold),
                                        modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                            Text(
                                text = topReview.comment,
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(WgcCoreDsColors.lazaSecondaryText)
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
private fun WgcLazaProductDetailTemplatePreview() {
    WgcLazaProductDetailTemplate()
}
