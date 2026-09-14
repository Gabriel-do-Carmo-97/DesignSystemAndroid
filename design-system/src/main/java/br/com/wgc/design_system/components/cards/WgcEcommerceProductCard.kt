package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.feedback.WgcRatingBar
import br.com.wgc.design_system.components.images.AsyncImageDefault

/**
 * Card vertical oficial para catálogo e-commerce (WgcEcommerceProductCard).
 * Exibe imagem com botão de favoritar, badge de desconto, título, descrição,
 * preço de/por e avaliação por estrelas.
 */
@Composable
fun WgcEcommerceProductCard(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String? = null,
    price: String,
    originalPrice: String? = null,
    discountPercent: Int? = null,
    imageUrl: String? = null,
    rating: Float? = 4.5f,
    reviewCount: Int? = 56890,
    isFavorite: Boolean = false,
    onFavoriteToggle: (() -> Unit)? = null,
    onClick: () -> Unit
) {
    val shape = RoundedCornerShape(WgcCoreDsBorderRadius.md.dp)
    val borderColor = Color(WgcCoreDsColors.stylishBorderGray).copy(alpha = 0.25f)

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape)
            .clickable(onClick = onClick),
        shape = shape,
        border = BorderStroke(1.dp, borderColor),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column {
            // Top Image Container with Favorite & Discount Badge
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .background(Color(WgcCoreDsColors.stylishLightGray))
            ) {
                AsyncImageDefault(
                    image = imageUrl,
                    contentDescription = title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                )

                if (discountPercent != null && discountPercent > 0) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(WgcCoreDsSpacing.xs.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xs.dp))
                            .background(Color(WgcCoreDsColors.stylishPink))
                            .padding(horizontal = WgcCoreDsSpacing.xs.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = "$discountPercent% OFF",
                            style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                            color = Color.White
                        )
                    }
                }

                if (onFavoriteToggle != null) {
                    IconButton(
                        onClick = onFavoriteToggle,
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(WgcCoreDsSpacing.xxs.dp)
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(Color.White.copy(alpha = 0.8f))
                    ) {
                        Icon(
                            imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                            contentDescription = if (isFavorite) "Remover dos favoritos" else "Adicionar aos favoritos",
                            tint = if (isFavorite) Color(WgcCoreDsColors.stylishPink) else Color(WgcCoreDsColors.stylishDark),
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }

            // Info Content
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(WgcCoreDsSpacing.sm.dp)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                    color = Color(WgcCoreDsColors.stylishDark),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                if (subtitle != null) {
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = subtitle,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(WgcCoreDsColors.textSecondary),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs.dp))

                // Price Row
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = price,
                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                        color = Color(WgcCoreDsColors.stylishDark)
                    )

                    if (originalPrice != null) {
                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs.dp))
                        Text(
                            text = originalPrice,
                            style = MaterialTheme.typography.bodySmall.copy(
                                textDecoration = TextDecoration.LineThrough
                            ),
                            color = Color(WgcCoreDsColors.textSecondary)
                        )
                    }
                }

                if (rating != null) {
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs.dp))
                    WgcRatingBar(
                        rating = rating,
                        reviewCount = reviewCount,
                        showRatingText = false
                    )
                }
            }
        }
    }
}

@Preview(name = "Product Card Preview", showBackground = true)
@Composable
private fun WgcEcommerceProductCardPreview() {
    Box(
        modifier = Modifier
            .width(180.dp)
            .padding(WgcCoreDsSpacing.sm.dp)
    ) {
        WgcEcommerceProductCard(
            title = "Nike Sneakers",
            subtitle = "Vision Alta Men's Shoes Size (All Colours)",
            price = "₹1,500",
            originalPrice = "₹2,499",
            discountPercent = 40,
            rating = 4.5f,
            reviewCount = 56890,
            isFavorite = true,
            onFavoriteToggle = {},
            onClick = {}
        )
    }
}
