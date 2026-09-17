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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bathtub
import androidx.compose.material.icons.filled.Bed
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.TrendingDown
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
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
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * Status de precificação em relação ao Índice FipeZAP.
 */
enum class WgcZapFipeStatus(val label: String) {
    BELOW_AVERAGE("Preço abaixo da média"),
    ON_AVERAGE("Preço na média"),
    ABOVE_AVERAGE("Preço acima da média")
}

/**
 * Card oficial de Imóvel do Zap Imóveis.
 *
 * Exibe foto simulada, selos de destaque, tag FipeZAP, valores de venda/locação,
 * metragem quadrada com valor por m², especificações e contato com o anunciante.
 */
@Composable
fun WgcPropertyClassifiedsCard(
    title: String,
    price: String,
    pricePerSquareMeter: String? = null,
    condoAndIptu: String? = null,
    neighborhood: String,
    address: String,
    areaM2: Int,
    bedrooms: Int,
    suites: Int = 0,
    bathrooms: Int,
    parkingSpaces: Int,
    fipeStatus: WgcZapFipeStatus? = WgcZapFipeStatus.ON_AVERAGE,
    badgeText: String? = "Super Destaque",
    advertiserName: String = "Zap Prime Imóveis",
    hasVirtualTour: Boolean = false,
    isFavorite: Boolean = false,
    onCardClick: () -> Unit = {},
    onFavoriteClick: () -> Unit = {},
    onContactClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onCardClick),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.propertyClassifiedsSurface)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
    ) {
        Column {
            // Imagem Placeholder com Tags e Ações
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(WgcCoreDsSize.s200.dp)
                    .background(Color(WgcCoreDsColors.propertyClassifiedsCardPlaceholder))
            ) {
                // Ícone ilustrativo de imóvel no centro do placeholder
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null,
                    tint = Color(WgcCoreDsColors.propertyClassifiedsBorder),
                    modifier = Modifier
                        .size(WgcCoreDsSize.s56.dp)
                        .align(Alignment.Center)
                )

                // Selos Super Destaque / Destaque Zap no topo esquerdo
                Row(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(WgcCoreDsSpacing.sm12.dp),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                ) {
                    if (badgeText != null) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                .background(Color(WgcCoreDsColors.propertyClassifiedsOrange))
                                .padding(
                                    horizontal = WgcCoreDsSpacing.xs8.dp,
                                    vertical = WgcCoreDsSpacing.xxs4.dp
                                )
                        ) {
                            Text(
                                text = badgeText.uppercase(),
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }

                    if (hasVirtualTour) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                .background(Color(WgcCoreDsColors.propertyClassifiedsBlue))
                                .padding(
                                    horizontal = WgcCoreDsSpacing.xs8.dp,
                                    vertical = WgcCoreDsSpacing.xxs4.dp
                                )
                        ) {
                            Text(
                                text = "TOUR 360°",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }
                }

                // Botão de Favoritar no topo direito
                IconButton(
                    onClick = onFavoriteClick,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(WgcCoreDsSpacing.xs8.dp)
                        .size(WgcCoreDsSize.s36.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.9f))
                ) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "Favoritar imóvel",
                        tint = if (isFavorite) Color(WgcCoreDsColors.propertyClassifiedsOrange) else Color(WgcCoreDsColors.propertyClassifiedsDark),
                        modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                    )
                }

                // Selo FipeZAP no rodapé da imagem
                if (fipeStatus != null) {
                    val fipeBg = when (fipeStatus) {
                        WgcZapFipeStatus.BELOW_AVERAGE -> Color(WgcCoreDsColors.propertyClassifiedsFipeGreen)
                        WgcZapFipeStatus.ON_AVERAGE -> Color(WgcCoreDsColors.propertyClassifiedsBlue)
                        WgcZapFipeStatus.ABOVE_AVERAGE -> Color(WgcCoreDsColors.propertyClassifiedsOrange)
                    }
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(WgcCoreDsSpacing.sm12.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                            .background(fipeBg)
                            .padding(
                                horizontal = WgcCoreDsSpacing.xs8.dp,
                                vertical = WgcCoreDsSpacing.xxs4.dp
                            )
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.TrendingDown,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(WgcCoreDsSize.s12.dp)
                            )
                            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                            Text(
                                text = "FipeZAP: ${fipeStatus.label}",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }
                }
            }

            // Corpo de Informações do Imóvel
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(WgcCoreDsSpacing.md16.dp)
            ) {
                // Preço Principal e Preço m²
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = price,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(WgcCoreDsColors.propertyClassifiedsPrimary)
                    )
                    if (pricePerSquareMeter != null) {
                        Text(
                            text = pricePerSquareMeter,
                            style = MaterialTheme.typography.bodySmall,
                            fontWeight = FontWeight.Medium,
                            color = Color(WgcCoreDsColors.propertyClassifiedsSecondaryText)
                        )
                    }
                }

                if (condoAndIptu != null) {
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                    Text(
                        text = condoAndIptu,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(WgcCoreDsColors.propertyClassifiedsSecondaryText)
                    )
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                // Título do Imóvel
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(WgcCoreDsColors.propertyClassifiedsDark),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                // Localização
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = WgcCoreDsSpacing.xxs4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.propertyClassifiedsSecondaryText),
                        modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                    )
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                    Text(
                        text = "$neighborhood • $address",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(WgcCoreDsColors.propertyClassifiedsSecondaryText),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                // Faixa de Especificações Estruturais
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                        .background(Color(WgcCoreDsColors.propertyClassifiedsBackground))
                        .border(
                            width = WgcCoreDsSpacing.xxxs2.dp,
                            color = Color(WgcCoreDsColors.propertyClassifiedsBorder),
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp)
                        )
                        .padding(
                            horizontal = WgcCoreDsSpacing.sm12.dp,
                            vertical = WgcCoreDsSpacing.xs8.dp
                        ),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Área m²
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "${areaM2}m²",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.propertyClassifiedsDark)
                        )
                    }

                    // Quartos
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Bed,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.propertyClassifiedsSecondaryText),
                            modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                        )
                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                        Text(
                            text = if (suites > 0) "$bedrooms ($suites suíte)" else "$bedrooms qts",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Medium,
                            color = Color(WgcCoreDsColors.propertyClassifiedsDark)
                        )
                    }

                    // Banheiros
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Bathtub,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.propertyClassifiedsSecondaryText),
                            modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                        )
                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                        Text(
                            text = "$bathrooms",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Medium,
                            color = Color(WgcCoreDsColors.propertyClassifiedsDark)
                        )
                    }

                    // Vagas
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.DirectionsCar,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.propertyClassifiedsSecondaryText),
                            modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                        )
                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                        Text(
                            text = "$parkingSpaces vagas",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Medium,
                            color = Color(WgcCoreDsColors.propertyClassifiedsDark)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))
                HorizontalDivider(color = Color(WgcCoreDsColors.propertyClassifiedsBorder))
                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                // Rodapé: Anunciante e Ação Rápida de Contato
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Verified,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.propertyClassifiedsBlue),
                            modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                        )
                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                        Text(
                            text = advertiserName,
                            style = MaterialTheme.typography.bodySmall,
                            fontWeight = FontWeight.Medium,
                            color = Color(WgcCoreDsColors.propertyClassifiedsSecondaryText)
                        )
                    }

                    // Botão Laranja Zap de Contato
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                            .background(Color(WgcCoreDsColors.propertyClassifiedsOrange))
                            .clickable(onClick = onContactClick)
                            .padding(
                                horizontal = WgcCoreDsSpacing.sm12.dp,
                                vertical = WgcCoreDsSpacing.xxs4.dp
                            )
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Phone,
                                contentDescription = "Contatar anunciante",
                                tint = Color.White,
                                modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                            )
                            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                            Text(
                                text = "Contatar",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(name = "WgcPropertyClassifiedsCard - Default", showBackground = true)
@Composable
private fun WgcZapPropertyCardPreview() {
    MaterialTheme {
        Box(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
            WgcPropertyClassifiedsCard(
                title = "Apartamento Alto Padrão com Varanda Gourmet",
                price = "R$ 1.850.000",
                pricePerSquareMeter = "R$ 13.703/m²",
                condoAndIptu = "Condomínio R$ 1.650 • IPTU R$ 680",
                neighborhood = "Itaim Bibi",
                address = "Rua Joaquim Floriano",
                areaM2 = 135,
                bedrooms = 3,
                suites = 2,
                bathrooms = 4,
                parkingSpaces = 2,
                hasVirtualTour = true,
                fipeStatus = WgcZapFipeStatus.BELOW_AVERAGE
            )
        }
    }
}
