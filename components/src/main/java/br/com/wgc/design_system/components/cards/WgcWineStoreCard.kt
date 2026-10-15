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
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.WineBar
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
import br.com.wgc.design_system.core.tokens.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.theme.WgcCoreDsColors
import br.com.wgc.design_system.core.tokens.WgcCoreDsElevation
import br.com.wgc.design_system.core.tokens.WgcCoreDsSize
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing
import java.util.Locale

@Composable
fun WgcWineStoreCard(
    wineName: String,
    winery: String,
    countryAndRegion: String,
    year: Int,
    rating: Double,
    originalPrice: Double,
    clienteMaisPrice: Double,
    modifier: Modifier = Modifier,
    grape: String = "Cabernet Sauvignon",
    sommelierNote: String = "Notas de frutas vermelhas maduras com taninos macios.",
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
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.MD8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.white)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.LEVEL1.dp),
        border = androidx.compose.foundation.BorderStroke(
            width = WgcCoreDsSize.S1.dp,
            color = Color(WgcCoreDsColors.greenLight1)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.MD16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.XS8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.SM4.dp))
                            .background(Color(WgcCoreDsColors.pinkLight3))
                            .padding(horizontal = WgcCoreDsSpacing.XS8.dp, vertical = WgcCoreDsSpacing.XXXS2.dp)
                    ) {
                        Text(
                            text = "$countryAndRegion • $year",
                            color = Color(WgcCoreDsColors.pink1),
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.SM4.dp))
                            .background(Color(WgcCoreDsColors.orangeLight12))
                            .padding(horizontal = WgcCoreDsSpacing.XS8.dp, vertical = WgcCoreDsSpacing.XXXS2.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.XXXS2.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.orange34),
                                modifier = Modifier.size(WgcCoreDsSize.S12.dp)
                            )
                            Text(
                                text = String.format(Locale.getDefault(), "%.1f", rating) + " Sommelier",
                                color = Color(WgcCoreDsColors.orange4),
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }

                IconButton(
                    onClick = onFavoriteToggle,
                    modifier = Modifier.size(WgcCoreDsSize.S24.dp)
                ) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "Favoritar",
                        tint = if (isFavorite) Color(WgcCoreDsColors.pink1) else Color(WgcCoreDsColors.cyan7),
                        modifier = Modifier.size(WgcCoreDsSize.S20.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.SM12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(WgcCoreDsSize.S80.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.MD8.dp))
                        .background(Color(WgcCoreDsColors.pinkLight3)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.WineBar,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.pink1),
                        modifier = Modifier.size(WgcCoreDsSize.S32.dp)
                    )
                }

                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.SM12.dp))

                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.XXXS2.dp)
                ) {
                    Text(
                        text = winery.uppercase(),
                        color = Color(WgcCoreDsColors.cyan7),
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = wineName,
                        color = Color(WgcCoreDsColors.cyanDark3),
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "Uva: $grape",
                        color = Color(WgcCoreDsColors.cyan7),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XS8.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.SM4.dp))
                    .background(Color(WgcCoreDsColors.greenLight1).copy(alpha = 0.5f))
                    .padding(WgcCoreDsSpacing.XS8.dp)
            ) {
                Text(
                    text = "Nota do Sommelier: \"$sommelierNote\"",
                    color = Color(WgcCoreDsColors.cyan7),
                    style = MaterialTheme.typography.bodySmall,
                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.MD16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Column {
                    Text(
                        text = "R$ " + String.format(Locale.getDefault(), "%.2f", originalPrice) + " (Preço Regular)",
                        color = Color(WgcCoreDsColors.cyan7),
                        style = MaterialTheme.typography.bodySmall,
                        textDecoration = TextDecoration.LineThrough
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.XS8.dp)
                    ) {
                        Text(
                            text = "R$ " + String.format(Locale.getDefault(), "%.2f", clienteMaisPrice),
                            color = Color(WgcCoreDsColors.pink1),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.ExtraBold
                        )
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.SM4.dp))
                                .background(Color(WgcCoreDsColors.orangeLight12))
                                .padding(horizontal = WgcCoreDsSpacing.XS8.dp, vertical = WgcCoreDsSpacing.XXXS2.dp)
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
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.CIRCULAR999.dp))
                            .background(Color(WgcCoreDsColors.pinkLight3))
                            .padding(horizontal = WgcCoreDsSpacing.XS8.dp, vertical = WgcCoreDsSpacing.XXXS2.dp)
                    ) {
                        IconButton(
                            onClick = { onQuantityChange(quantityInCart - 1) },
                            modifier = Modifier.size(WgcCoreDsSize.S28.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Remove,
                                contentDescription = "Diminuir",
                                tint = Color(WgcCoreDsColors.pink1)
                            )
                        }
                        Text(
                            text = quantityInCart.toString(),
                            color = Color(WgcCoreDsColors.pink1),
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.XS8.dp)
                        )
                        IconButton(
                            onClick = { onQuantityChange(quantityInCart + 1) },
                            modifier = Modifier.size(WgcCoreDsSize.S28.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Aumentar",
                                tint = Color(WgcCoreDsColors.pink1)
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

@Preview(name = "Wine Store Card - Preview", showBackground = true)
@Composable
private fun WgcWineStoreCardPreview() {
    WgcWineStoreCard(
        wineName = "Vinho Tinto Catena Zapata Malbec",
        winery = "Bodega Catena Zapata",
        countryAndRegion = "Argentina • Mendoza",
        year = 2021,
        rating = 95.0,
        originalPrice = 249.90,
        clienteMaisPrice = 189.90,
        quantityInCart = 1
    )
}
