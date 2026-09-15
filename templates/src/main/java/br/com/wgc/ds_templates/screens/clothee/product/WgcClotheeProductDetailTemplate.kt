package br.com.wgc.ds_templates.screens.clothee.product

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.images.AsyncImageDefault
import br.com.wgc.design_system.components.stepper.WgcClotheeQuantityStepper
import br.com.wgc.ds_templates.screens.clothee.model.ClotheeColorOption
import br.com.wgc.ds_templates.screens.clothee.model.ClotheeMockData
import br.com.wgc.ds_templates.screens.clothee.model.ClotheeProduct
import br.com.wgc.ds_templates.screens.clothee.model.ClotheeReview

/**
 * Tela de detalhes do produto Clothee (WgcClotheeProductDetailTemplate).
 * Apresenta carrossel de fotos, seletor de tamanhos e cores, seletor de quantidade com stepper,
 * avaliações e CTA fixo no rodapé com valor e ação "Add to Bag".
 */
@Composable
fun WgcClotheeProductDetailTemplate(
    modifier: Modifier = Modifier,
    product: ClotheeProduct = ClotheeMockData.products[0],
    selectedSize: String = "M",
    selectedColor: ClotheeColorOption = product.availableColors[0],
    quantity: Int = 1,
    reviews: List<ClotheeReview> = ClotheeMockData.reviews,
    onSizeSelected: (String) -> Unit = {},
    onColorSelected: (ClotheeColorOption) -> Unit = {},
    onQuantityChange: (Int) -> Unit = {},
    onFavoriteToggle: () -> Unit = {},
    onAddToCart: () -> Unit = {},
    onBackClick: () -> Unit = {},
    customBottomBarSlot: (@Composable () -> Unit)? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        bottomBar = {
            if (customBottomBarSlot != null) {
                customBottomBarSlot()
            } else {
                SurfaceBottomBar(
                    price = product.price,
                    quantity = quantity,
                    onAddToCart = onAddToCart
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
            // Imagem do produto com botões flutuantes de Voltar e Favorito
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(320.dp)
                    .background(Color(WgcCoreDsColors.clotheeSurface))
            ) {
                if (!product.imageUrl.isNullOrEmpty()) {
                    AsyncImageDefault(
                        image = product.imageUrl,
                        contentDescription = product.title,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                // Botão Voltar (topo esquerdo)
                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(WgcCoreDsSpacing.lg24.dp)
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.9f))
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Voltar",
                        tint = Color(WgcCoreDsColors.clotheeDark)
                    )
                }

                // Botão Favorito (topo direito)
                IconButton(
                    onClick = onFavoriteToggle,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(WgcCoreDsSpacing.lg24.dp)
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.9f))
                ) {
                    Icon(
                        imageVector = if (product.isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                        contentDescription = "Favoritar",
                        tint = if (product.isFavorite) Color(WgcCoreDsColors.clotheeAlertRed) else Color(WgcCoreDsColors.clotheeDark)
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.lg24.dp, vertical = WgcCoreDsSpacing.md16.dp)
            ) {
                // Título e Preço
                Text(
                    text = product.title,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.clotheeDark)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))

                Text(
                    text = product.price,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.clotheePrimary)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

                // Seletor de Tamanho
                Text(
                    text = "Size",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.clotheeDark)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                Row(horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
                    product.availableSizes.forEach { size ->
                        val isSelected = size == selectedSize
                        Box(
                            modifier = Modifier
                                .size(44.dp)
                                .clip(CircleShape)
                                .background(
                                    if (isSelected) Color(WgcCoreDsColors.clotheePrimary)
                                    else Color(WgcCoreDsColors.clotheeSurface)
                                )
                                .clickable { onSizeSelected(size) },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = size,
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold,
                                color = if (isSelected) Color.White else Color(WgcCoreDsColors.clotheeDark)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

                // Seletor de Cores
                Text(
                    text = "Color",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.clotheeDark)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                Row(horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
                    product.availableColors.forEach { colorOption ->
                        val isSelected = colorOption.name == selectedColor.name
                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .clip(CircleShape)
                                .background(colorOption.color)
                                .border(
                                    width = if (isSelected) 3.dp else 1.dp,
                                    color = if (isSelected) Color(WgcCoreDsColors.clotheePrimary) else Color(WgcCoreDsColors.clotheeBorder),
                                    shape = CircleShape
                                )
                                .clickable { onColorSelected(colorOption) }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

                // Quantidade com Stepper
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Quantity",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.clotheeDark)
                    )

                    WgcClotheeQuantityStepper(
                        count = quantity,
                        onCountChange = onQuantityChange
                    )
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

                // Descrição do Produto
                Text(
                    text = "Description",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.clotheeDark)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                Text(
                    text = product.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(WgcCoreDsColors.clotheeSecondaryText),
                    lineHeight = MaterialTheme.typography.bodyLarge.lineHeight
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))

                // Seção de Avaliações
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Reviews",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.clotheeDark)
                    )

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Avaliação",
                            tint = Color(0xFFFFB800),
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "${product.rating} (${product.reviewCount} Reviews)",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.clotheeDark)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

                reviews.forEach { review ->
                    ReviewCard(review = review)
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))
                }
            }
        }
    }
}

@Composable
private fun ReviewCard(review: ClotheeReview) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
            .background(Color(WgcCoreDsColors.clotheeSurface))
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
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    if (!review.avatarUrl.isNullOrEmpty()) {
                        AsyncImageDefault(
                            image = review.avatarUrl,
                            contentDescription = review.authorName,
                            modifier = Modifier.fillMaxSize()
                        )
                    } else {
                        Text(
                            text = review.authorName.take(1),
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.clotheePrimary)
                        )
                    }
                }

                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))

                Text(
                    text = review.authorName,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.clotheeDark)
                )
            }

            Text(
                text = review.date,
                style = MaterialTheme.typography.bodySmall,
                color = Color(WgcCoreDsColors.clotheeSecondaryText)
            )
        }

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

        Text(
            text = review.comment,
            style = MaterialTheme.typography.bodySmall,
            color = Color(WgcCoreDsColors.clotheeDark)
        )
    }
}

@Composable
private fun SurfaceBottomBar(
    price: String,
    quantity: Int,
    onAddToCart: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = WgcCoreDsSpacing.lg24.dp, vertical = WgcCoreDsSpacing.md16.dp)
    ) {
        Button(
            onClick = onAddToCart,
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            shape = RoundedCornerShape(100.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(WgcCoreDsColors.clotheePrimary)
            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = price,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Text(
                    text = "Add to Bag",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcClotheeProductDetailTemplatePreview() {
    WgcClotheeProductDetailTemplate()
}
