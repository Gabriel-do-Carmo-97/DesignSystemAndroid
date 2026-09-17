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
import androidx.compose.material.icons.automirrored.filled.DirectionsWalk
import androidx.compose.material.icons.filled.Bathtub
import androidx.compose.material.icons.filled.Bed
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * Card de Imóvel no estilo Property Rental:
 * - Imagem de capa com selo "Sem Fiador" e botão de Favoritar
 * - Preço principal com etiqueta de total estimado (aluguel + condomínio + IPTU)
 * - Endereço e bairro com destaque visual
 * - Especificações do imóvel: área m², quartos, banheiros e vagas de garagem
 * - Badge opcional de proximidade com o metrô
 */
@Composable
fun WgcPropertyRentalCard(
    title: String,
    neighborhood: String,
    address: String,
    price: String,
    totalPrice: String? = null,
    areaM2: Int = 65,
    bedrooms: Int = 2,
    bathrooms: Int = 1,
    parkingSpots: Int = 1,
    badgeText: String? = "Sem Fiador",
    metroProximity: String? = "350m do Metrô",
    isFavorite: Boolean = false,
    onFavoriteToggle: () -> Unit = {},
    onClick: () -> Unit = {},
    imageSlot: (@Composable () -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(WgcCoreDsColors.propertyRentalSurface)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsSpacing.xxxs2.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // Imagem / Slot superior com badges flutuantes
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(WgcCoreDsSize.s180.dp)
                    .background(Color(WgcCoreDsColors.propertyRentalCardPlaceholder))
            ) {
                if (imageSlot != null) {
                    imageSlot()
                } else {
                    Box(
                        modifier = Modifier
                            .matchParentSize()
                            .background(Color(WgcCoreDsColors.propertyRentalPrimaryLight)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.propertyRentalPrimary),
                            modifier = Modifier.size(WgcCoreDsSize.s48.dp)
                        )
                    }
                }

                // Tag Sem Fiador (ou custom) no canto superior esquerdo
                if (badgeText != null) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(WgcCoreDsSpacing.sm12.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                            .background(Color(WgcCoreDsColors.propertyRentalCoral))
                            .padding(
                                horizontal = WgcCoreDsSpacing.xs8.dp,
                                vertical = WgcCoreDsSpacing.xxs4.dp
                            )
                    ) {
                        Text(
                            text = badgeText,
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }

                // Botão de Favoritar circular no canto superior direito
                IconButton(
                    onClick = onFavoriteToggle,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(WgcCoreDsSpacing.sm12.dp)
                        .size(WgcCoreDsSize.s36.dp)
                        .clip(CircleShape)
                        .background(Color(WgcCoreDsColors.propertyRentalSurface).copy(alpha = 0.9f))
                ) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                        contentDescription = "Favoritar imóvel",
                        tint = if (isFavorite) Color(WgcCoreDsColors.propertyRentalCoral) else Color(WgcCoreDsColors.propertyRentalDark),
                        modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                    )
                }

                // Tag de Metrô no canto inferior esquerdo da foto
                if (metroProximity != null) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(WgcCoreDsSpacing.sm12.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                            .background(Color(WgcCoreDsColors.propertyRentalPrimary).copy(alpha = 0.85f))
                            .padding(
                                horizontal = WgcCoreDsSpacing.xs8.dp,
                                vertical = WgcCoreDsSpacing.xxs4.dp
                            )
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.DirectionsWalk,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.propertyRentalYellow),
                                modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                            )
                            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                            Text(
                                text = metroProximity,
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White
                            )
                        }
                    }
                }
            }

            // Conteúdo informativo
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(WgcCoreDsSpacing.md16.dp)
            ) {
                // Preço principal
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = price,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.propertyRentalPrimary)
                    )
                    if (totalPrice != null) {
                        Text(
                            text = totalPrice,
                            style = MaterialTheme.typography.bodySmall,
                            fontWeight = FontWeight.Medium,
                            color = Color(WgcCoreDsColors.propertyRentalSecondaryText)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                // Título e Bairro
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(WgcCoreDsColors.propertyRentalDark),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = WgcCoreDsSpacing.xxs4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.propertyRentalSecondaryText),
                        modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                    )
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                    Text(
                        text = "$neighborhood • $address",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(WgcCoreDsColors.propertyRentalSecondaryText),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                // Linha de especificações: m² | quartos | banheiros | vagas
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                        .background(Color(WgcCoreDsColors.propertyRentalBackground))
                        .border(
                            width = WgcCoreDsSpacing.xxxs2.dp,
                            color = Color(WgcCoreDsColors.propertyRentalBorder),
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp)
                        )
                        .padding(
                            horizontal = WgcCoreDsSpacing.sm12.dp,
                            vertical = WgcCoreDsSpacing.xs8.dp
                        ),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Área m²
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "${areaM2}m²",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.propertyRentalDark)
                        )
                    }

                    // Quartos
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Bed,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.propertyRentalDark),
                            modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                        )
                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                        Text(
                            text = "$bedrooms qts",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Medium,
                            color = Color(WgcCoreDsColors.propertyRentalDark)
                        )
                    }

                    // Banheiros
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Bathtub,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.propertyRentalDark),
                            modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                        )
                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                        Text(
                            text = "$bathrooms ban",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Medium,
                            color = Color(WgcCoreDsColors.propertyRentalDark)
                        )
                    }

                    // Vagas
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.DirectionsCar,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.propertyRentalDark),
                            modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                        )
                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                        Text(
                            text = "$parkingSpots vag",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Medium,
                            color = Color(WgcCoreDsColors.propertyRentalDark)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcPropertyRentalPropertyCardPreview() {
    WgcPropertyRentalCard(
        title = "Apartamento amplo e iluminado",
        neighborhood = "Pinheiros",
        address = "Rua Mourato Coelho, 700",
        price = "R$ 3.200 /mês",
        totalPrice = "Total R$ 4.050 /mês",
        areaM2 = 72,
        bedrooms = 2,
        bathrooms = 2,
        parkingSpots = 1,
        badgeText = "Sem Fiador",
        metroProximity = "300m do Metrô Fradique Coutinho",
        isFavorite = false
    )
}

@Preview(showBackground = true)
@Composable
private fun WgcPropertyRentalPropertyCardFavoritedPreview() {
    WgcPropertyRentalCard(
        title = "Studio mobiliado de alto padrão",
        neighborhood = "Vila Madalena",
        address = "Rua Fradique Coutinho, 1200",
        price = "R$ 2.700 /mês",
        totalPrice = "Total R$ 3.350 /mês",
        areaM2 = 45,
        bedrooms = 1,
        bathrooms = 1,
        parkingSpots = 0,
        badgeText = "Destaque",
        metroProximity = "150m do Metrô",
        isFavorite = true
    )
}
