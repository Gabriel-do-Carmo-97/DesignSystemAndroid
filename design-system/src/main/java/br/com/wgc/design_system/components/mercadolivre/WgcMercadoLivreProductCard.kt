package br.com.wgc.design_system.components.mercadolivre

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
 * Card Oficial de Produto do Mercado Livre (WgcMercadoLivreProductCard) com desconto Verde (#00A650) e badge "Frete Grátis⚡".
 */
@Composable
fun WgcMercadoLivreProductCard(
    modifier: Modifier = Modifier,
    title: String,
    originalPrice: String = "R$ 1.999",
    currentPrice: String = "R$ 1.499",
    discountPercent: String = "25% OFF",
    installments: String = "em 10x R$ 149,90 sem juros",
    isFreeShipping: Boolean = true,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .width(180.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
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
                color = Color(0xFF333333)
            )

            Column {
                Text(
                    text = originalPrice,
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.Gray,
                    textDecoration = TextDecoration.LineThrough
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = currentPrice,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF333333)
                    )
                    Text(
                        text = discountPercent,
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF00A650)
                    )
                }

                Text(
                    text = installments,
                    style = MaterialTheme.typography.labelSmall,
                    color = Color(0xFF00A650),
                    fontWeight = FontWeight.Medium
                )
            }

            if (isFreeShipping) {
                Surface(
                    color = Color(0xFF00A650).copy(alpha = 0.1f),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(
                        text = "Frete Grátis⚡",
                        color = Color(0xFF00A650),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }
        }
    }
}

@WgcComponentPreviews
@Composable
private fun WgcMercadoLivreProductCardPreview() {
    MaterialTheme {
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            WgcMercadoLivreProductCard(title = "Smart TV 50\" 4K UHD")
            WgcMercadoLivreProductCard(title = "Smartphone 128GB 5G", originalPrice = "R$ 2.499", currentPrice = "R$ 1.899")
        }
    }
}
