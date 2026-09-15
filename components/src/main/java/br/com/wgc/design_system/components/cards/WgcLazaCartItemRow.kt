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
import androidx.compose.material.icons.filled.DeleteOutline
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
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
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.images.AsyncImageDefault

/**
 * Linha de item do carrinho do ecossistema Laza (WgcLazaCartItemRow).
 * Exibe imagem ampla (100x100), título, preço com impostos, controles verticais de quantidade e botão de exclusão.
 */
@Composable
fun WgcLazaCartItemRow(
    modifier: Modifier = Modifier,
    title: String,
    price: String,
    taxInfo: String? = null,
    quantity: Int = 1,
    imageUrl: String? = null,
    onIncreaseQuantity: () -> Unit = {},
    onDecreaseQuantity: () -> Unit = {},
    onDeleteClick: () -> Unit = {},
    onClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
            .background(Color(WgcCoreDsColors.lazaSurface))
            .clickable(onClick = onClick)
            .padding(WgcCoreDsSpacing.sm12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Thumbnail do produto
        Box(
            modifier = Modifier
                .size(WgcCoreDsSize.s100.dp)
                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            if (!imageUrl.isNullOrEmpty()) {
                AsyncImageDefault(
                    image = imageUrl,
                    contentDescription = title,
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                Text(
                    text = title.take(2).uppercase(),
                    style = MaterialTheme.typography.titleMedium,
                    color = Color(WgcCoreDsColors.lazaPrimary),
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))

        // Informações centrais
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxxs2.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.lazaDark),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = price,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.lazaDark)
                )

                if (!taxInfo.isNullOrEmpty()) {
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                    Text(
                        text = taxInfo,
                        style = MaterialTheme.typography.labelSmall,
                        color = Color(WgcCoreDsColors.lazaSecondaryText)
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            // Controles de quantidade (setas up/down)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
            ) {
                // Diminuir
                Box(
                    modifier = Modifier
                        .size(WgcCoreDsSize.s28.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .clickable(enabled = quantity > 1, onClick = onDecreaseQuantity),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Diminuir",
                        tint = Color(WgcCoreDsColors.lazaDark),
                        modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                    )
                }

                Text(
                    text = quantity.toString(),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.lazaDark)
                )

                // Aumentar
                Box(
                    modifier = Modifier
                        .size(WgcCoreDsSize.s28.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .clickable(onClick = onIncreaseQuantity),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowUp,
                        contentDescription = "Aumentar",
                        tint = Color(WgcCoreDsColors.lazaDark),
                        modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                    )
                }
            }
        }

        // Botão de deletar
        IconButton(
            onClick = onDeleteClick,
            modifier = Modifier
                .size(WgcCoreDsSize.s36.dp)
                .clip(CircleShape)
                .background(Color.White)
        ) {
            Icon(
                imageVector = Icons.Default.DeleteOutline,
                contentDescription = "Remover item",
                tint = Color(WgcCoreDsColors.lazaSecondaryText),
                modifier = Modifier.size(WgcCoreDsSize.s18.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcLazaCartItemRowPreview() {
    WgcLazaCartItemRow(
        title = "Men's Tie-Dye T-Shirt Nike Sportswear",
        price = "$45",
        taxInfo = "(-$4.00 Tax)",
        quantity = 2
    )
}
