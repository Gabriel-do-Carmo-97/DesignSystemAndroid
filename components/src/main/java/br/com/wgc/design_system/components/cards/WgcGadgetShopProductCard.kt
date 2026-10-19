package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FavoriteBorder
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
import br.com.wgc.design_system.core.tokens.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.theme.WgcCoreDsColors
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing
import br.com.wgc.design_system.components.images.AsyncImageDefault

/**
 * Card de produto oficial do ecossistema Nexkart (WgcGadgetShopProductCard).
 * Exibe imagem sobre container cinza suave (#F8F9FD), tag opcional (Featured / Desconto),
 * botão flutuante de coração com contador de curtidas, título, avaliação em estrelas,
 * preço destacado em azul primário (#2D60FF) e preço original riscado.
 */
@Composable
fun WgcGadgetShopProductCard(
    modifier: Modifier = Modifier,
    title: String,
    price: String,
    originalPrice: String? = null,
    rating: Double? = null,
    reviewCount: Int? = null,
    tag: String? = null,
    imageUrl: String? = null,
    isFavorite: Boolean = false,
    onFavoriteClick: () -> Unit = {},
    onClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .width(164.dp)
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.XL16.dp))
            .background(Color(WgcCoreDsColors.blueLight38))
            .clickable(onClick = onClick)
            .padding(WgcCoreDsSpacing.XS8.dp)
    ) {
        // Container da imagem com cantos arredondados
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.LG12.dp))
                .background(Color.White)
        ) {
            if (!imageUrl.isNullOrEmpty()) {
                AsyncImageDefault(
                    image = imageUrl,
                    contentDescription = title,
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(WgcCoreDsColors.blueLight31)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = title.take(2).uppercase(),
                        style = MaterialTheme.typography.headlineSmall,
                        color = Color(WgcCoreDsColors.blue39),
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // Tag opcional superior esquerda (Featured ou % off)
            if (!tag.isNullOrEmpty()) {
                Box(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(WgcCoreDsSpacing.XXS4.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.SM4.dp))
                        .background(
                            if (tag.contains("%") || tag.contains("Sale", ignoreCase = true)) {
                                Color(WgcCoreDsColors.pink5)
                            } else {
                                Color(WgcCoreDsColors.blue39)
                            }
                        )
                        .padding(horizontal = WgcCoreDsSpacing.XS8.dp, vertical = WgcCoreDsSpacing.XXXS2.dp)
                ) {
                    Text(
                        text = tag,
                        style = MaterialTheme.typography.labelSmall,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // Botão de favoritar circular superior direito
            IconButton(
                onClick = onFavoriteClick,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(WgcCoreDsSpacing.XXS4.dp)
                    .size(28.dp)
                    .clip(CircleShape)
                    .background(Color.White.copy(alpha = 0.9f))
            ) {
                Icon(
                    imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = if (isFavorite) "Remover favorito" else "Favoritar",
                    tint = if (isFavorite) Color(WgcCoreDsColors.pink5) else Color(WgcCoreDsColors.blue41),
                    modifier = Modifier.size(16.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XS8.dp))

        // Nome do produto
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold,
            color = Color(WgcCoreDsColors.blueDark6),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        // Linha de avaliação opcional
        if (rating != null) {
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XXXS2.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = null,
                    tint = Color(WgcCoreDsColors.orange23),
                    modifier = Modifier.size(12.dp)
                )
                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.XXXS2.dp))
                Text(
                    text = rating.toString(),
                    style = MaterialTheme.typography.labelSmall,
                    color = Color(WgcCoreDsColors.blueDark6),
                    fontWeight = FontWeight.Bold
                )
                if (reviewCount != null) {
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.XXS4.dp))
                    Text(
                        text = "($reviewCount)",
                        style = MaterialTheme.typography.labelSmall,
                        color = Color(WgcCoreDsColors.blue41)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XXS4.dp))

        // Linha de Preços
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = price,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.blue39)
                )
                if (!originalPrice.isNullOrEmpty()) {
                    Text(
                        text = originalPrice,
                        style = MaterialTheme.typography.labelSmall,
                        color = Color(WgcCoreDsColors.blue41),
                        textDecoration = TextDecoration.LineThrough
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcNexkartProductCardPreview() {
    WgcGadgetShopProductCard(
        title = "Nike Air Max 95",
        price = "USD 180.00",
        originalPrice = "USD 220.00",
        rating = 4.8,
        reviewCount = 308,
        tag = "Featured",
        isFavorite = false
    )
}

@Preview(showBackground = true)
@Composable
private fun WgcNexkartProductCardSalePreview() {
    WgcGadgetShopProductCard(
        title = "Samsung Galaxy S10",
        price = "USD 860.00",
        originalPrice = "USD 1000.00",
        rating = 4.9,
        reviewCount = 52,
        tag = "-40%",
        isFavorite = true
    )
}
