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
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
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
import br.com.wgc.design_system.core.tokens.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.theme.WgcCoreDsColors
import br.com.wgc.design_system.core.tokens.WgcCoreDsSize
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing

/**
 * Card de Imóvel no estilo portal de classificados Property Listing:
 * - Imagem de capa com selo "Super Destaque" ou "Destaque" e contador de fotos
 * - Preço principal com valores de Condomínio e IPTU
 * - Endereço e bairro com destaque visual
 * - Linha de especificações: m², quartos, suítes, banheiros e vagas
 * - Rodapé com identificação da Imobiliária / Anunciante e botão de contato direto
 */
@Composable
fun WgcPropertyListingCard(
    title: String,
    neighborhood: String,
    address: String,
    price: String,
    condoAndIptu: String? = "Condomínio R$ 550 • IPTU R$ 130",
    areaM2: Int = 68,
    bedrooms: Int = 2,
    suites: Int = 1,
    bathrooms: Int = 2,
    parkingSpots: Int = 1,
    agencyName: String = "Lopes Imóveis",
    badgeText: String? = "Super Destaque",
    photoCountText: String = "1/18",
    isFavorite: Boolean = false,
    onFavoriteToggle: () -> Unit = {},
    onWhatsAppClick: () -> Unit = {},
    onClick: () -> Unit = {},
    imageSlot: (@Composable () -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.XL16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(WgcCoreDsColors.white)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsSpacing.XXXS2.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // Imagem / Slot de fotos
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(WgcCoreDsSize.S180.dp)
                    .background(Color(WgcCoreDsColors.blueLight1))
            ) {
                if (imageSlot != null) {
                    imageSlot()
                } else {
                    Box(
                        modifier = Modifier
                            .matchParentSize()
                            .background(Color(WgcCoreDsColors.greenLight13)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.green14),
                            modifier = Modifier.size(WgcCoreDsSize.S48.dp)
                        )
                    }
                }

                // Badge Super Destaque / Destaque
                if (badgeText != null) {
                    val isSuper = badgeText.contains("Super", ignoreCase = true)
                    val badgeBg = if (isSuper) {
                        Color(WgcCoreDsColors.red17)
                    } else {
                        Color(WgcCoreDsColors.orange18)
                    }

                    Box(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(WgcCoreDsSpacing.SM12.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.SM4.dp))
                            .background(badgeBg)
                            .padding(
                                horizontal = WgcCoreDsSpacing.XS8.dp,
                                vertical = WgcCoreDsSpacing.XXS4.dp
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

                // Botão Favoritar
                IconButton(
                    onClick = onFavoriteToggle,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(WgcCoreDsSpacing.SM12.dp)
                        .size(WgcCoreDsSize.S36.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.9f))
                ) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                        contentDescription = "Favoritar imóvel",
                        tint = if (isFavorite) Color(WgcCoreDsColors.orange18) else Color(WgcCoreDsColors.blueDark23),
                        modifier = Modifier.size(WgcCoreDsSize.S20.dp)
                    )
                }

                // Contador de fotos no canto inferior direito
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(WgcCoreDsSpacing.SM12.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.SM4.dp))
                        .background(Color.Black.copy(alpha = 0.6f))
                        .padding(
                            horizontal = WgcCoreDsSpacing.XS8.dp,
                            vertical = WgcCoreDsSpacing.XXS4.dp
                        )
                ) {
                    Text(
                        text = photoCountText,
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }

            // Informações do Imóvel
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(WgcCoreDsSpacing.MD16.dp)
            ) {
                // Preço
                Text(
                    text = price,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.green14)
                )

                if (condoAndIptu != null) {
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XXS4.dp))
                    Text(
                        text = condoAndIptu,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(WgcCoreDsColors.blue22)
                    )
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XS8.dp))

                // Título
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(WgcCoreDsColors.blueDark23),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                // Endereço
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = WgcCoreDsSpacing.XXS4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.blue22),
                        modifier = Modifier.size(WgcCoreDsSize.S14.dp)
                    )
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.XXS4.dp))
                    Text(
                        text = "$neighborhood • $address",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(WgcCoreDsColors.blue22),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.SM12.dp))

                // Especificações: m² | quartos | suítes | banheiros | vagas
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.MD8.dp))
                        .background(Color(WgcCoreDsColors.blueLight37))
                        .border(
                            width = WgcCoreDsSpacing.XXXS2.dp,
                            color = Color(WgcCoreDsColors.blueLight8),
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.MD8.dp)
                        )
                        .padding(
                            horizontal = WgcCoreDsSpacing.SM12.dp,
                            vertical = WgcCoreDsSpacing.XS8.dp
                        ),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${areaM2}m²",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.blueDark23)
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Bed,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.blueDark23),
                            modifier = Modifier.size(WgcCoreDsSize.S16.dp)
                        )
                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.XXS4.dp))
                        Text(
                            text = "$bedrooms qts",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Medium,
                            color = Color(WgcCoreDsColors.blueDark23)
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Bathtub,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.blueDark23),
                            modifier = Modifier.size(WgcCoreDsSize.S16.dp)
                        )
                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.XXS4.dp))
                        Text(
                            text = "$bathrooms ban",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Medium,
                            color = Color(WgcCoreDsColors.blueDark23)
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.DirectionsCar,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.blueDark23),
                            modifier = Modifier.size(WgcCoreDsSize.S16.dp)
                        )
                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.XXS4.dp))
                        Text(
                            text = "$parkingSpots vag",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Medium,
                            color = Color(WgcCoreDsColors.blueDark23)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.SM12.dp))
                HorizontalDivider(color = Color(WgcCoreDsColors.blueLight8))
                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XS8.dp))

                // Rodapé com Imobiliária Anunciante e CTA Chat
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(WgcCoreDsSize.S28.dp)
                                .clip(CircleShape)
                                .background(Color(WgcCoreDsColors.greenLight13)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Business,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.green14),
                                modifier = Modifier.size(WgcCoreDsSize.S16.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.XS8.dp))
                        Text(
                            text = agencyName,
                            style = MaterialTheme.typography.bodySmall,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(WgcCoreDsColors.blueDark23)
                        )
                    }

                    // Botão de Chat rápido
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.CIRCULAR999.dp))
                            .background(Color(WgcCoreDsColors.green25))
                            .clickable(onClick = onWhatsAppClick)
                            .padding(
                                horizontal = WgcCoreDsSpacing.SM12.dp,
                                vertical = WgcCoreDsSpacing.XXS4.dp
                            )
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Phone,
                                contentDescription = "Contatar por Chat Direto",
                                tint = Color.White,
                                modifier = Modifier.size(WgcCoreDsSize.S14.dp)
                            )
                            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.XXS4.dp))
                            Text(
                                text = "Chat",
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

@Preview(showBackground = true)
@Composable
private fun WgcPropertyListingPropertyCardPreview() {
    WgcPropertyListingCard(
        title = "Apartamento à venda com varanda gourmet",
        neighborhood = "Moema",
        address = "Alameda dos Maracatins, 450",
        price = "R$ 890.000",
        condoAndIptu = "Condomínio R$ 780 • IPTU R$ 220",
        areaM2 = 78,
        bedrooms = 2,
        suites = 1,
        bathrooms = 2,
        parkingSpots = 1,
        agencyName = "Lopes Prime",
        badgeText = "Super Destaque",
        isFavorite = false
    )
}
