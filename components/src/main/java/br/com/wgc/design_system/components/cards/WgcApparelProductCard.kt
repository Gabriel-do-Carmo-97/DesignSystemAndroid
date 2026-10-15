package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
 * Card de produto esportivo/casual do ecossistema Clothee (WgcApparelProductCard).
 * Exibe imagem com fundo suave arredondado (#F4F4F4), botão de favoritar no canto superior direito,
 * título em negrito, preço atual e preço promocional opcional.
 */
@Composable
fun WgcApparelProductCard(
    modifier: Modifier = Modifier,
    title: String,
    price: String,
    originalPrice: String? = null,
    imageUrl: String? = null,
    isFavorite: Boolean = false,
    onFavoriteClick: () -> Unit = {},
    onClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .width(160.dp)
            .clickable(onClick = onClick)
    ) {
        // Container da imagem com cantos arredondados
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.MD8.dp))
                .background(Color(WgcCoreDsColors.grayLight8))
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
                        .background(Color(WgcCoreDsColors.purpleLight2)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = title.take(2).uppercase(),
                        style = MaterialTheme.typography.titleLarge,
                        color = Color(WgcCoreDsColors.purple7),
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // Botão de favoritar circular
            IconButton(
                onClick = onFavoriteClick,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(WgcCoreDsSpacing.XS8.dp)
                    .size(28.dp)
                    .clip(CircleShape)
                    .background(Color.White.copy(alpha = 0.85f))
            ) {
                Icon(
                    imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = if (isFavorite) "Remover dos favoritos" else "Adicionar aos favoritos",
                    tint = if (isFavorite) Color(WgcCoreDsColors.red24) else Color(WgcCoreDsColors.grayDark18),
                    modifier = Modifier.size(16.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XS8.dp))

        // Nome do produto
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium,
            color = Color(WgcCoreDsColors.grayDark18),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XXS4.dp))

        // Preço e Preço Antigo
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = price,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.grayDark18)
            )

            if (!originalPrice.isNullOrEmpty()) {
                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.XS8.dp))
                Text(
                    text = originalPrice,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(WgcCoreDsColors.gray12),
                    textDecoration = TextDecoration.LineThrough
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcClotheeProductCardPreview() {
    WgcApparelProductCard(
        title = "Men's Harrington Jacket",
        price = "$148.00",
        originalPrice = "$198.00",
        isFavorite = false
    )
}

@Preview(showBackground = true)
@Composable
private fun WgcClotheeProductCardFavoritePreview() {
    WgcApparelProductCard(
        title = "Cotton Fleece Hoodie",
        price = "$95.00",
        isFavorite = true
    )
}
