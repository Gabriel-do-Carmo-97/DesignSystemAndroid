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
import androidx.compose.foundation.shape.RoundedCornerShape
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
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.images.AsyncImageDefault
import br.com.wgc.design_system.components.stepper.WgcApparelQuantityStepper

/**
 * Card de item do carrinho do ecossistema Clothee (WgcApparelCartItemCard).
 * Exibe thumbnail com cantos arredondados, título, variações (tamanho e cor), preço e seletor de quantidade.
 */
@Composable
fun WgcApparelCartItemCard(
    modifier: Modifier = Modifier,
    title: String,
    size: String = "M",
    colorName: String = "Lemon",
    price: String,
    quantity: Int = 1,
    imageUrl: String? = null,
    onQuantityChange: (Int) -> Unit = {},
    onClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
            .background(Color(WgcCoreDsColors.apparelSurface))
            .clickable(onClick = onClick)
            .padding(WgcCoreDsSpacing.sm12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Thumbnail do produto
        Box(
            modifier = Modifier
                .size(64.dp)
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
                    color = Color(WgcCoreDsColors.apparelPrimary),
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
                color = Color(WgcCoreDsColors.apparelDark),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = "Size - $size   Color - $colorName",
                style = MaterialTheme.typography.bodySmall,
                color = Color(WgcCoreDsColors.apparelSecondaryText)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxxs2.dp))

            Text(
                text = price,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.apparelDark)
            )
        }

        // Stepper de quantidade
        WgcApparelQuantityStepper(
            count = quantity,
            onCountChange = onQuantityChange
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcClotheeCartItemCardPreview() {
    WgcApparelCartItemCard(
        title = "Men's Harrington Jacket",
        size = "M",
        colorName = "Lemon",
        price = "$148.00",
        quantity = 1
    )
}
