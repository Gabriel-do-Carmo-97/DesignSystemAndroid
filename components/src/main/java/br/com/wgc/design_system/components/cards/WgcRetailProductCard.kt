package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.images.AsyncImageDefault

/**
 * Card de produto oficial do ecossistema Kutuku (WgcRetailProductCard).
 * Exibe imagem em container arredondado, botão circular translúcido de favoritar no canto superior direito,
 * título, subtítulo da loja/marca e preço em destaque.
 */
@Composable
fun WgcRetailProductCard(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    price: String,
    imageUrl: String? = null,
    isFavorite: Boolean = false,
    onFavoriteClick: () -> Unit = {},
    onClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .width(168.dp)
            .clickable(onClick = onClick)
    ) {
        // Container da imagem com botão de favorito
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xl.dp))
                .background(Color(WgcCoreDsColors.retailBackground))
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
                        .background(Color(WgcCoreDsColors.retailPrimaryLight)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = title.take(2).uppercase(),
                        style = MaterialTheme.typography.titleLarge,
                        color = Color(WgcCoreDsColors.retailPrimary),
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // Botão circular translúcido de favoritar
            IconButton(
                onClick = onFavoriteClick,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(WgcCoreDsSpacing.xs.dp)
                    .size(WgcCoreDsSpacing.xl.dp)
                    .clip(CircleShape)
                    .background(Color.Black.copy(alpha = 0.35f))
            ) {
                Icon(
                    imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = if (isFavorite) "Remover dos favoritos" else "Adicionar aos favoritos",
                    tint = if (isFavorite) Color(WgcCoreDsColors.retailAlertRed) else Color.White,
                    modifier = Modifier.size(16.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs.dp))

        // Título do produto
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = Color(WgcCoreDsColors.retailDark),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxxs.dp))

        // Subtítulo / Loja
        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodySmall,
            color = Color(WgcCoreDsColors.retailSecondaryText),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs.dp))

        // Preço
        Text(
            text = price,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            color = Color(WgcCoreDsColors.retailDark)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcKutukuProductCardPreview() {
    WgcRetailProductCard(
        title = "The Mirac Jiz",
        subtitle = "Lisa Robber",
        price = "$195.00",
        isFavorite = false
    )
}

@Preview(showBackground = true)
@Composable
private fun WgcKutukuProductCardFavoritePreview() {
    WgcRetailProductCard(
        title = "Meriza Kiles",
        subtitle = "Gazuna Resika",
        price = "$143.45",
        isFavorite = true
    )
}
