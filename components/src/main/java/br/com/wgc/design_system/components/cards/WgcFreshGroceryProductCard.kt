package br.com.wgc.design_system.components.cards

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
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Card de produto Shopper:
 * Imagem/placeholder, rating com estrela dourada, botão de wishlist flutuante (coração vermelho),
 * título, preço com desconto e preço original riscado.
 */
@Composable
fun WgcFreshGroceryProductCard(
    title: String,
    price: String,
    originalPrice: String? = null,
    rating: String = "4.8",
    discountBadge: String? = "-20%",
    isFavorite: Boolean = false,
    onFavoriteToggle: () -> Unit = {},
    onClick: () -> Unit = {},
    imageSlot: (@Composable () -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .width(WgcCoreDsSize.s160.dp)
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
            .clickable(onClick = onClick)
            .padding(WgcCoreDsSpacing.xs8.dp)
    ) {
        // Área da Imagem + Badges
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(WgcCoreDsSize.s140.dp)
                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                .background(Color(WgcCoreDsColors.megaStorerSurface))
        ) {
            if (imageSlot != null) {
                imageSlot()
            } else {
                Box(
                    modifier = Modifier
                        .size(WgcCoreDsSize.s80.dp)
                        .align(Alignment.Center)
                        .clip(CircleShape)
                        .background(Color(WgcCoreDsColors.megaStorerPrimaryLight)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "🛍️",
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }

            // Badge de Desconto
            if (discountBadge != null) {
                Box(
                    modifier = Modifier
                        .padding(WgcCoreDsSpacing.xs8.dp)
                        .align(Alignment.TopStart)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                        .background(Color(WgcCoreDsColors.megaStorerAccent))
                        .padding(
                            horizontal = WgcCoreDsSpacing.xs8.dp,
                            vertical = WgcCoreDsSpacing.xxs4.dp
                        )
                ) {
                    Text(
                        text = discountBadge,
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }

            // Botão Wishlist (Coração)
            IconButton(
                onClick = onFavoriteToggle,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(WgcCoreDsSpacing.xxs4.dp)
                    .size(WgcCoreDsSize.s32.dp)
                    .clip(CircleShape)
                    .background(Color.White.copy(alpha = 0.85f))
            ) {
                Icon(
                    imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "Favoritar",
                    tint = if (isFavorite) Color(WgcCoreDsColors.megaStorerAccent) else Color(WgcCoreDsColors.megaStorerSecondaryText),
                    modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

        // Rating
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = Color(WgcCoreDsColors.megaStorerGold),
                modifier = Modifier.size(WgcCoreDsSize.s14.dp)
            )
            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
            Text(
                text = rating,
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.megaStorerDark)
            )
        }

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))

        // Título do Produto
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold,
            color = Color(WgcCoreDsColors.megaStorerDark),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))

        // Preço
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
        ) {
            Text(
                text = price,
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.megaStorerPrimary)
            )

            if (originalPrice != null) {
                Text(
                    text = originalPrice,
                    style = MaterialTheme.typography.labelSmall,
                    textDecoration = TextDecoration.LineThrough,
                    color = Color(WgcCoreDsColors.megaStorerSecondaryText)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcShopperProductCardPreview() {
    WgcFreshGroceryProductCard(
        title = "Casual Green Hoodie",
        price = "$39.00",
        originalPrice = "$55.00",
        discountBadge = "-30%",
        isFavorite = true
    )
}
