package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.commons.WgcComponentPreviews
import br.com.wgc.design_system.components.avatar.WgcAvatar

/**
 * Card Promocional de Produto em Marketplace (WgcPromotionalProductCard).
 */
@Composable
fun WgcPromotionalProductCard(
    modifier: Modifier = Modifier,
    title: String,
    originalPrice: String = "R$ 1.999",
    currentPrice: String = "R$ 1.499",
    discountPercent: String = "25% OFF",
    installments: String = "em 10x R$ 149,90 sem juros",
    isFreeShipping: Boolean = true,
    accentColor: Color = Color(0xFF00A650),
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .width(180.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(WgcCoreDsSpacing.sm12.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp),
                contentAlignment = Alignment.Center
            ) {
                WgcAvatar(initials = title.take(2), size = 72.dp)
            }

            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                color = MaterialTheme.colorScheme.onSurface
            )

            Column {
                if (originalPrice.isNotBlank()) {
                    Text(
                        text = originalPrice,
                        style = MaterialTheme.typography.labelSmall,
                        textDecoration = TextDecoration.LineThrough,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = currentPrice,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    if (discountPercent.isNotBlank()) {
                        Text(
                            text = discountPercent,
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = accentColor
                        )
                    }
                }

                if (installments.isNotBlank()) {
                    Text(
                        text = installments,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                if (isFreeShipping) {
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Frete Grátis ⚡",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = accentColor
                    )
                }
            }
        }
    }
}

@WgcComponentPreviews
@Composable
private fun WgcPromotionalProductCardPreview() {
    MaterialTheme {
        WgcPromotionalProductCard(
            title = "Smartphone Top 128GB 5G Preto",
            originalPrice = "R$ 2.499",
            currentPrice = "R$ 1.899",
            discountPercent = "24% OFF",
            installments = "10x R$ 189,90 sem juros",
            isFreeShipping = true
        )
    }
}
