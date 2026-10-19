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
import br.com.wgc.design_system.core.tokens.WgcCoreDsSize
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing

/**
 * Card de Produto ShopEase com fundo pastel colorido:
 * - Fundo com cantos arredondados suaves e tons pastéis (ex: vermelho/rosa, verde, roxo, laranja)
 * - Badge de desconto circular (ex: 20% off)
 * - Botão de wishlist (coração)
 * - Título, subtítulo/categoria, preço atual e preço riscado
 */
@Composable
@Suppress("LongMethod")
fun WgcQuickShopProductCard(
    title: String,
    price: String,
    originalPrice: String? = null,
    discountBadge: String? = "20% off",
    backgroundColor: Color = Color(WgcCoreDsColors.redLight7),
    isFavorite: Boolean = false,
    onFavoriteToggle: () -> Unit = {},
    onClick: () -> Unit = {},
    illustrationSlot: (@Composable () -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .width(WgcCoreDsSize.S160.dp)
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.XL16.dp))
            .background(backgroundColor)
            .clickable(onClick = onClick)
            .padding(WgcCoreDsSpacing.SM12.dp)
    ) {
        // Topo: Badge de desconto à esquerda, Coração à direita
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (discountBadge != null) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.Black)
                        .padding(
                            horizontal = WgcCoreDsSpacing.XS8.dp,
                            vertical = WgcCoreDsSpacing.XXS4.dp
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = discountBadge,
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            } else {
                Spacer(modifier = Modifier.size(WgcCoreDsSize.S16.dp))
            }

            IconButton(
                onClick = onFavoriteToggle,
                modifier = Modifier
                    .size(WgcCoreDsSize.S32.dp)
                    .clip(CircleShape)
                    .background(Color.White.copy(alpha = 0.8f))
            ) {
                Icon(
                    imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "Favorite",
                    tint = if (isFavorite) Color.Red else Color(WgcCoreDsColors.gray6),
                    modifier = Modifier.size(WgcCoreDsSize.S16.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XS8.dp))

        // Área Central: Imagem / Ícone ilustrativo
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(WgcCoreDsSize.S100.dp),
            contentAlignment = Alignment.Center
        ) {
            if (illustrationSlot != null) {
                illustrationSlot()
            } else {
                Text(
                    text = "👟",
                    style = MaterialTheme.typography.displayMedium
                )
            }
        }

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XS8.dp))

        // Título
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = Color(WgcCoreDsColors.grayDark19),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XXS4.dp))

        // Preço Atual e Preço Riscado
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.XS8.dp)
        ) {
            Text(
                text = price,
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.ExtraBold,
                color = Color(WgcCoreDsColors.orange27)
            )

            if (originalPrice != null) {
                Text(
                    text = originalPrice,
                    style = MaterialTheme.typography.labelSmall,
                    textDecoration = TextDecoration.LineThrough,
                    color = Color(WgcCoreDsColors.gray6)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcShopEaseProductCardPreview() {
    WgcQuickShopProductCard(
        title = "Red Running Sneaker",
        price = "$35.00",
        originalPrice = "$50.00",
        discountBadge = "30% off",
        backgroundColor = Color(WgcCoreDsColors.redLight7)
    )
}
