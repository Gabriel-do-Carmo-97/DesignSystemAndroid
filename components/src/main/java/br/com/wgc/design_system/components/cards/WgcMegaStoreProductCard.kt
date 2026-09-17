package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
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
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing
import coil3.compose.AsyncImage

/**
 * Card Oficial de Moda e Vestuário do Shoppe (WgcMegaStoreProductCard).
 * Exibe imagem vertical com cantos arredondados, tag de desconto, botão de like flutuante e preços.
 */
@Composable
fun WgcMegaStoreProductCard(
    modifier: Modifier = Modifier,
    title: String = "Pastel Long Sleeve",
    category: String = "Clothing",
    price: String = "$34.00",
    originalPrice: String? = "$45.00",
    discountPercent: Int? = 25,
    rating: Float = 4.8f,
    imageUrl: String = "https://images.unsplash.com/photo-1515886657613-9f3515b0c78f?w=600",
    isFavorite: Boolean = false,
    onFavoriteToggle: () -> Unit = {},
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.white)),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(0.85f)
                    .clip(RoundedCornerShape(topStart = WgcCoreDsBorderRadius.md.dp, topEnd = WgcCoreDsBorderRadius.md.dp))
                    .background(Color(WgcCoreDsColors.megaStoreBackground))
            ) {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.matchParentSize()
                )

                if (discountPercent != null && discountPercent > 0) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(WgcCoreDsSpacing.sm.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xs.dp))
                            .background(Color(WgcCoreDsColors.megaStorePrimary))
                            .padding(horizontal = WgcCoreDsSpacing.xs.dp, vertical = WgcCoreDsSpacing.xxs.dp)
                    ) {
                        Text(
                            text = "-$discountPercent%",
                            color = Color(WgcCoreDsColors.white),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                IconButton(
                    onClick = onFavoriteToggle,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(WgcCoreDsSpacing.xs.dp)
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.85f))
                ) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "Favoritar",
                        tint = if (isFavorite) Color(WgcCoreDsColors.red500) else Color(WgcCoreDsColors.megaStoreDark),
                        modifier = Modifier.size(18.dp)
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(WgcCoreDsSpacing.sm.dp)
            ) {
                Text(
                    text = category.uppercase(),
                    style = MaterialTheme.typography.labelSmall,
                    color = Color(WgcCoreDsColors.megaStoreSecondaryText),
                    fontSize = 10.sp
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs.dp))

                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                    color = Color(WgcCoreDsColors.megaStoreDark),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = price,
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = Color(WgcCoreDsColors.megaStorePrimary)
                    )

                    if (!originalPrice.isNullOrBlank()) {
                        Spacer(modifier = Modifier.size(WgcCoreDsSpacing.xs.dp))
                        Text(
                            text = originalPrice,
                            style = MaterialTheme.typography.bodySmall.copy(textDecoration = TextDecoration.LineThrough),
                            color = Color(WgcCoreDsColors.megaStoreSecondaryText)
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Rating",
                        tint = Color(WgcCoreDsColors.megaStoreGold),
                        modifier = Modifier.size(14.dp)
                    )
                    Text(
                        text = rating.toString(),
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.megaStoreDark),
                        modifier = Modifier.padding(start = 2.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 200)
@Composable
private fun WgcShoppeProductCardPreview() {
    MaterialTheme {
        Box(modifier = Modifier.padding(16.dp)) {
            WgcMegaStoreProductCard()
        }
    }
}
