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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DeleteOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.images.AsyncImageDefault

/**
 * Linha de item do carrinho do ecossistema Nexkart (WgcNexkartCartItemRow).
 * Exibe imagem do produto, título, variante/categoria, preço destacado em azul royal,
 * controles de quantidade (+ / -) e ação de remoção.
 */
@Composable
fun WgcNexkartCartItemRow(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    price: String,
    quantity: Int = 1,
    imageUrl: String? = null,
    onQuantityChange: (Int) -> Unit = {},
    onRemoveClick: () -> Unit = {},
    onClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp))
            .background(Color(WgcCoreDsColors.nexkartSurface))
            .clickable(onClick = onClick)
            .padding(WgcCoreDsSpacing.sm12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Thumbnail do produto
        Box(
            modifier = Modifier
                .size(72.dp)
                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp))
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
                    color = Color(WgcCoreDsColors.nexkartPrimary),
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))

        // Dados do produto
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = Color(WgcCoreDsColors.nexkartDark),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxxs2.dp))

            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = Color(WgcCoreDsColors.nexkartSecondaryText),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))

            Text(
                text = price,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.nexkartPrimary)
            )
        }

        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))

        // Controles de quantidade e exclusão
        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
        ) {
            IconButton(
                onClick = onRemoveClick,
                modifier = Modifier.size(24.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.DeleteOutline,
                    contentDescription = "Remover item",
                    tint = Color(WgcCoreDsColors.nexkartAccentPink),
                    modifier = Modifier.size(18.dp)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .clickable(enabled = quantity > 1) { onQuantityChange(quantity - 1) },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "–",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = if (quantity > 1) Color(WgcCoreDsColors.nexkartDark) else Color(WgcCoreDsColors.nexkartSecondaryText)
                    )
                }

                Text(
                    text = quantity.toString(),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.nexkartDark),
                    modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.xxs4.dp)
                )

                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .background(Color(WgcCoreDsColors.nexkartPrimary))
                        .clickable { onQuantityChange(quantity + 1) },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Adicionar",
                        tint = Color.White,
                        modifier = Modifier.size(14.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcNexkartCartItemRowPreview() {
    WgcNexkartCartItemRow(
        title = "Nike Air Max 95 Premium",
        subtitle = "Men's Shoes / Size: 42",
        price = "USD 180.00",
        quantity = 2
    )
}
