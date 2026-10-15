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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.tokens.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.theme.WgcCoreDsColors
import br.com.wgc.design_system.core.tokens.WgcCoreDsSize
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing
import br.com.wgc.design_system.components.images.AsyncImageDefault

/**
 * Card de produto oficial do ecossistema Laza (WgcBoutiqueProductCard).
 * Apresenta recipiente com fundo cinza suave (#F5F6FA), botão circular de favoritar translúcido,
 * título em negrito e preço de destaque.
 */
@Composable
fun WgcBoutiqueProductCard(
    modifier: Modifier = Modifier,
    title: String,
    price: String,
    subtitle: String? = null,
    imageUrl: String? = null,
    isFavorite: Boolean = false,
    onFavoriteClick: () -> Unit = {},
    onClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .width(WgcCoreDsSize.S160.dp)
            .clickable(onClick = onClick)
    ) {
        // Container da foto com cantos arredondados
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(WgcCoreDsSize.S180.dp)
                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.MD8.dp))
                .background(Color(WgcCoreDsColors.blueLight32))
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
                        color = Color(WgcCoreDsColors.purple8),
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
                    .size(WgcCoreDsSize.S32.dp)
                    .clip(CircleShape)
                    .background(Color.White.copy(alpha = 0.9f))
            ) {
                Icon(
                    imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = if (isFavorite) "Remover favorito" else "Adicionar favorito",
                    tint = if (isFavorite) Color(WgcCoreDsColors.red22) else Color(WgcCoreDsColors.gray13),
                    modifier = Modifier.size(WgcCoreDsSize.S16.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XS8.dp))

        // Título do produto
        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Medium,
            color = Color(WgcCoreDsColors.grayDark13),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        if (!subtitle.isNullOrEmpty()) {
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XXXS2.dp))
            Text(
                text = subtitle,
                style = MaterialTheme.typography.labelSmall,
                color = Color(WgcCoreDsColors.gray13),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XXS4.dp))

        // Preço
        Text(
            text = price,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = Color(WgcCoreDsColors.grayDark13)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcLazaProductCardPreview() {
    WgcBoutiqueProductCard(
        title = "Nike Sportswear Club Fleece",
        price = "$99",
        subtitle = "Men's Pullover Hoodie",
        isFavorite = false
    )
}

@Preview(showBackground = true)
@Composable
private fun WgcLazaProductCardFavoritePreview() {
    WgcBoutiqueProductCard(
        title = "Trail Running Jacket Nike Windrunner",
        price = "$130",
        isFavorite = true
    )
}
