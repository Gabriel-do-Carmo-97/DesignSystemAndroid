package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.LocalBar
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Thermostat
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
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import java.util.Locale

/**
 * Card especializado da "Adega Pão de Açúcar / Sommelier".
 *
 * Apresenta notas de harmonização, uvas, safra, pontuação de sommelier
 * e temperatura recomendada de serviço.
 */
@Composable
fun WgcPdaSommelierWineCard(
    wineName: String,
    countryOrigin: String,
    grape: String,
    vintage: String,
    rating: Double,
    sommelierPoints: Int,
    pairingTip: String,
    servingTemp: String,
    price: Double,
    clienteMaisPrice: Double,
    modifier: Modifier = Modifier,
    quantity: Int = 0,
    onQuantityChange: (Int) -> Unit = {},
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(WgcCoreDsColors.pdaSurface)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = WgcCoreDsElevation.level1.dp
        ),
        border = androidx.compose.foundation.BorderStroke(
            width = WgcCoreDsSize.s1.dp,
            color = Color(WgcCoreDsColors.pdaBorder)
        )
    ) {
        Column(
            modifier = Modifier.padding(WgcCoreDsSpacing.sm12.dp)
        ) {
            // Linha Superior: Origem, Safra e Pontuação do Sommelier
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                            .background(Color(WgcCoreDsColors.pdaWineRedLight))
                            .padding(
                                horizontal = WgcCoreDsSpacing.xs8.dp,
                                vertical = WgcCoreDsSpacing.xxxs2.dp
                            )
                    ) {
                        Text(
                            text = countryOrigin.uppercase(Locale.ROOT),
                            color = Color(WgcCoreDsColors.pdaWineRed),
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Text(
                        text = vintage,
                        color = Color(WgcCoreDsColors.pdaTextSecondary),
                        style = MaterialTheme.typography.labelSmall
                    )
                }

                // Badge de Pontuação do Sommelier PDA
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                        .background(Color(WgcCoreDsColors.pdaGoldLight))
                        .border(
                            width = WgcCoreDsSize.s1.dp,
                            color = Color(WgcCoreDsColors.pdaGold),
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp)
                        )
                        .padding(horizontal = WgcCoreDsSpacing.xs8.dp, vertical = WgcCoreDsSpacing.xxxs2.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.pdaGoldDark),
                            modifier = Modifier.size(WgcCoreDsSize.s12.dp)
                        )
                        Text(
                            text = "$sommelierPoints pts Sommelier",
                            color = Color(WgcCoreDsColors.pdaGoldDark),
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            // Corpo Central: Imagem/Ícone e Informações do Vinho
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Ilustração / Mock da Garrafa de Vinho
                Box(
                    modifier = Modifier
                        .size(WgcCoreDsSize.s80.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                        .background(Color(WgcCoreDsColors.pdaBackground)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.LocalBar,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.pdaWineRed),
                        modifier = Modifier.size(WgcCoreDsSize.s40.dp)
                    )
                }

                // Descrição, Uvas e Notas
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = wineName,
                        color = Color(WgcCoreDsColors.pdaTextPrimary),
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxxs2.dp))

                    Text(
                        text = "Uvas: $grape",
                        color = Color(WgcCoreDsColors.pdaTextSecondary),
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Thermostat,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.pdaTextSecondary),
                            modifier = Modifier.size(WgcCoreDsSize.s12.dp)
                        )
                        Text(
                            text = "Servir a $servingTemp",
                            color = Color(WgcCoreDsColors.pdaTextSecondary),
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            // Dica de Harmonização do Sommelier
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                    .background(Color(WgcCoreDsColors.pdaBackground))
                    .padding(WgcCoreDsSpacing.xs8.dp)
            ) {
                Text(
                    text = "🍷 Harmonização: $pairingTip",
                    color = Color(WgcCoreDsColors.pdaTextPrimary),
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            // Linha Inferior: Preços e Ação de Compra
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = String.format(Locale.GERMANY, "R$ %.2f", price),
                        color = Color(WgcCoreDsColors.pdaTextSecondary),
                        style = MaterialTheme.typography.labelSmall,
                        textDecoration = TextDecoration.LineThrough
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                    ) {
                        Text(
                            text = String.format(Locale.GERMANY, "R$ %.2f", clienteMaisPrice),
                            color = Color(WgcCoreDsColors.pdaGreenDark),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Black
                        )
                        Text(
                            text = "Cliente Mais",
                            color = Color(WgcCoreDsColors.pdaGoldDark),
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                // Botão Adicionar ou Stepper de Quantidade
                if (quantity == 0) {
                    Box(
                        modifier = Modifier
                            .height(WgcCoreDsSize.s32.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                            .background(Color(WgcCoreDsColors.pdaWineRed))
                            .clickable { onQuantityChange(1) }
                            .padding(horizontal = WgcCoreDsSpacing.sm12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "COMPRAR",
                            color = Color.White,
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold
                        )
                    }
                } else {
                    Row(
                        modifier = Modifier
                            .height(WgcCoreDsSize.s32.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                            .border(
                                width = WgcCoreDsSize.s1.dp,
                                color = Color(WgcCoreDsColors.pdaWineRed),
                                shape = RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp)
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = { onQuantityChange(quantity - 1) },
                            modifier = Modifier.size(WgcCoreDsSize.s32.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Remove,
                                contentDescription = "Diminuir",
                                tint = Color(WgcCoreDsColors.pdaWineRed),
                                modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                            )
                        }

                        Text(
                            text = "$quantity",
                            color = Color(WgcCoreDsColors.pdaWineRed),
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.xs8.dp)
                        )

                        IconButton(
                            onClick = { onQuantityChange(quantity + 1) },
                            modifier = Modifier.size(WgcCoreDsSize.s32.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Aumentar",
                                tint = Color(WgcCoreDsColors.pdaWineRed),
                                modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(name = "Sommelier Wine Card - Default", showBackground = true)
@Composable
private fun WgcPdaSommelierWineCardPreview() {
    WgcPdaSommelierWineCard(
        wineName = "Marqués de Riscal Gran Reserva Rioja",
        countryOrigin = "Espanha • D.O.Ca Rioja",
        grape = "Tempranillo, Graciano",
        vintage = "Safra 2018",
        rating = 4.4,
        sommelierPoints = 94,
        pairingTip = "Carnes nobres grelhadas, cordeiro e queijos curados.",
        servingTemp = "16°C a 18°C",
        price = 289.90,
        clienteMaisPrice = 229.90,
        quantity = 0
    )
}
