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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Eco
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsElevation
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import java.util.Locale

@Composable
fun WgcSupermarketProductCard(
    title: String,
    brandOrOrigin: String,
    unit: String,
    originalPrice: Double,
    clienteMaisPrice: Double,
    modifier: Modifier = Modifier,
    imageUrl: String? = null,
    discountBadge: String? = null,
    isOrganic: Boolean = false,
    sommelierRating: Double? = null,
    isFavorite: Boolean = false,
    quantityInCart: Int = 0,
    onCardClick: () -> Unit = {},
    onFavoriteToggle: () -> Unit = {},
    onQuantityChange: (Int) -> Unit = {}
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onCardClick),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.white)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp),
        border = androidx.compose.foundation.BorderStroke(
            width = WgcCoreDsSize.s1.dp,
            color = Color(WgcCoreDsColors.greenLight1)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (discountBadge != null) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                .background(Color(WgcCoreDsColors.pink1))
                                .padding(horizontal = WgcCoreDsSpacing.xs8.dp, vertical = WgcCoreDsSpacing.xxxs2.dp)
                        ) {
                            Text(
                                text = discountBadge,
                                color = Color(WgcCoreDsColors.white),
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }

                    if (isOrganic) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                .background(Color(WgcCoreDsColors.orangeLight10))
                                .padding(horizontal = WgcCoreDsSpacing.xs8.dp, vertical = WgcCoreDsSpacing.xxxs2.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxxs2.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Eco,
                                    contentDescription = null,
                                    tint = Color(WgcCoreDsColors.orange28),
                                    modifier = Modifier.size(WgcCoreDsSize.s12.dp)
                                )
                                Text(
                                    text = "Orgânico",
                                    color = Color(WgcCoreDsColors.orange28),
                                    fontWeight = FontWeight.Bold,
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }
                        }
                    }

                    if (sommelierRating != null) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                .background(Color(WgcCoreDsColors.orangeLight12))
                                .padding(horizontal = WgcCoreDsSpacing.xs8.dp, vertical = WgcCoreDsSpacing.xxxs2.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxxs2.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Star,
                                    contentDescription = null,
                                    tint = Color(WgcCoreDsColors.orange34),
                                    modifier = Modifier.size(WgcCoreDsSize.s12.dp)
                                )
                                Text(
                                    text = String.format(Locale.getDefault(), "%.1f", sommelierRating),
                                    color = Color(WgcCoreDsColors.orange4),
                                    fontWeight = FontWeight.Bold,
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }
                        }
                    }
                }

                IconButton(
                    onClick = onFavoriteToggle,
                    modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                ) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "Favoritar",
                        tint = if (isFavorite) Color(WgcCoreDsColors.pink1) else Color(WgcCoreDsColors.cyan7),
                        modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(WgcCoreDsSize.s80.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                        .background(Color(WgcCoreDsColors.greenLight1)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.ShoppingBag,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.greenDark7),
                        modifier = Modifier.size(WgcCoreDsSize.s32.dp)
                    )
                }

                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))

                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxxs2.dp)
                ) {
                    Text(
                        text = brandOrOrigin.uppercase(),
                        color = Color(WgcCoreDsColors.cyan7),
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = title,
                        color = Color(WgcCoreDsColors.cyanDark3),
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = unit,
                        color = Color(WgcCoreDsColors.cyan7),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Column {
                    Text(
                        text = "R$ " + String.format(Locale.getDefault(), "%.2f", originalPrice) + " (Não sócio)",
                        color = Color(WgcCoreDsColors.cyan7),
                        style = MaterialTheme.typography.bodySmall,
                        textDecoration = TextDecoration.LineThrough
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                    ) {
                        Text(
                            text = "R$ " + String.format(Locale.getDefault(), "%.2f", clienteMaisPrice),
                            color = Color(WgcCoreDsColors.greenDark7),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.ExtraBold
                        )
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                .background(Color(WgcCoreDsColors.orangeLight12))
                                .padding(horizontal = WgcCoreDsSpacing.xs8.dp, vertical = WgcCoreDsSpacing.xxxs2.dp)
                        ) {
                            Text(
                                text = "Cliente Mais",
                                color = Color(WgcCoreDsColors.orange4),
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }

                if (quantityInCart > 0) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                            .background(Color(WgcCoreDsColors.greenLight9))
                            .padding(horizontal = WgcCoreDsSpacing.xs8.dp, vertical = WgcCoreDsSpacing.xxxs2.dp)
                    ) {
                        IconButton(
                            onClick = { onQuantityChange(quantityInCart - 1) },
                            modifier = Modifier.size(WgcCoreDsSize.s28.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Remove,
                                contentDescription = "Diminuir",
                                tint = Color(WgcCoreDsColors.greenDark5)
                            )
                        }
                        Text(
                            text = quantityInCart.toString(),
                            color = Color(WgcCoreDsColors.greenDark5),
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.xs8.dp)
                        )
                        IconButton(
                            onClick = { onQuantityChange(quantityInCart + 1) },
                            modifier = Modifier.size(WgcCoreDsSize.s28.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Aumentar",
                                tint = Color(WgcCoreDsColors.greenDark5)
                            )
                        }
                    }
                } else {
                    br.com.wgc.design_system.components.buttons.WgcClassicButton(
                        textButton = "Adicionar",
                        onClick = { onQuantityChange(1) }
                    )
                }
            }
        }
    }
}

@Preview(name = "Supermarket Product Card - Preview", showBackground = true)
@Composable
private fun WgcSupermarketProductCardPreview() {
    WgcSupermarketProductCard(
        title = "Azeite de Oliva Extra Virgem Orgânico 500ml",
        brandOrOrigin = "Terra Creta • Grécia",
        unit = "Frasco 500ml",
        originalPrice = 89.90,
        clienteMaisPrice = 69.90,
        discountBadge = "22% OFF",
        isOrganic = true,
        quantityInCart = 1
    )
}
