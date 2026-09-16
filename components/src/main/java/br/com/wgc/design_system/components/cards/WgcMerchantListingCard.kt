package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.commons.WgcComponentPreviews
import br.com.wgc.design_system.components.avatar.WgcAvatar

/**
 * Card Descritivo de Estabelecimento Comercial / Restaurante (WgcMerchantListingCard).
 */
@Composable
fun WgcMerchantListingCard(
    modifier: Modifier = Modifier,
    name: String,
    rating: String = "4.8",
    category: String = "Lanches",
    distance: String = "1.2 km",
    deliveryTime: String = "20-30 min",
    deliveryFee: String = "Grátis",
    isFeatured: Boolean = true,
    accentColor: Color = Color(0xFFEA1D2C),
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            WgcAvatar(initials = name.take(2), size = 56.dp)

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = name,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    if (isFeatured) {
                        Surface(
                            color = accentColor.copy(alpha = 0.1f),
                            shape = RoundedCornerShape(4.dp)
                        ) {
                            Text(
                                text = "★ Super",
                                color = accentColor,
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                            )
                        }
                    }
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = Color(0xFFFFC107),
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = rating,
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFFC107)
                    )
                    Text(text = "•", style = MaterialTheme.typography.bodySmall)
                    Text(text = category, style = MaterialTheme.typography.bodySmall)
                    Text(text = "•", style = MaterialTheme.typography.bodySmall)
                    Text(text = distance, style = MaterialTheme.typography.bodySmall)
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(text = deliveryTime, style = MaterialTheme.typography.bodySmall)
                    Text(text = "•", style = MaterialTheme.typography.bodySmall)
                    Text(
                        text = deliveryFee,
                        style = MaterialTheme.typography.bodySmall,
                        color = if (deliveryFee.equals("Grátis", ignoreCase = true)) Color(0xFF00A650) else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

@WgcComponentPreviews
@Composable
private fun WgcMerchantListingCardPreview() {
    MaterialTheme {
        Column(
            modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            WgcMerchantListingCard(name = "Burger House", rating = "4.8", deliveryFee = "Grátis")
            WgcMerchantListingCard(name = "Pizza Prime", rating = "4.9", deliveryFee = "R$ 7,99", isFeatured = false)
        }
    }
}
