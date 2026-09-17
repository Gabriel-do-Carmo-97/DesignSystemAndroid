package br.com.wgc.ds_templates.screens.propertyclassifieds.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Bathtub
import androidx.compose.material.icons.filled.Bed
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.NearMe
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcPropertyClassifiedsIndexCard
import br.com.wgc.ds_templates.screens.propertyclassifieds.model.PropertyClassifiedsMockData
import br.com.wgc.ds_templates.screens.propertyclassifieds.model.ZapPropertyModel

/**
 * Template da Tela de Detalhes do Imóvel do Zap Imóveis.
 */
@Composable
fun WgcZapPropertyDetailTemplate(
    property: ZapPropertyModel = PropertyClassifiedsMockData.sampleProperties.first(),
    onBackClick: () -> Unit = {},
    onFavoriteToggle: () -> Unit = {},
    onShareClick: () -> Unit = {},
    onCallClick: () -> Unit = {},
    onSendMessageClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(WgcCoreDsColors.propertyClassifiedsSurface))
                    .padding(
                        horizontal = WgcCoreDsSpacing.sm12.dp,
                        vertical = WgcCoreDsSpacing.xs8.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Voltar",
                        tint = Color(WgcCoreDsColors.propertyClassifiedsDark)
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = onShareClick) {
                        Icon(
                            imageVector = Icons.Default.Share,
                            contentDescription = "Compartilhar imóvel",
                            tint = Color(WgcCoreDsColors.propertyClassifiedsDark)
                        )
                    }
                    IconButton(onClick = onFavoriteToggle) {
                        Icon(
                            imageVector = if (property.isFavorite) {
                                Icons.Default.Favorite
                            } else {
                                Icons.Default.FavoriteBorder
                            },
                            contentDescription = "Favoritar imóvel",
                            tint = if (property.isFavorite) {
                                Color(WgcCoreDsColors.propertyClassifiedsOrange)
                            } else {
                                Color(WgcCoreDsColors.propertyClassifiedsDark)
                            }
                        )
                    }
                }
            }
        },
        bottomBar = {
            // Barra Fixa de Contato Duplo (Ligar e Mensagem)
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(
                    topStart = WgcCoreDsBorderRadius.lg12.dp,
                    topEnd = WgcCoreDsBorderRadius.lg12.dp
                ),
                colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.propertyClassifiedsSurface)),
                elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(WgcCoreDsSpacing.md16.dp),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Botão Ligar (Azul Zap)
                    OutlinedButton(
                        onClick = onCallClick,
                        modifier = Modifier
                            .weight(1f)
                            .height(WgcCoreDsSize.s48.dp),
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = Color(WgcCoreDsColors.propertyClassifiedsPrimary)
                        ),
                        border = androidx.compose.foundation.BorderStroke(
                            width = WgcCoreDsSpacing.xxxs2.dp,
                            color = Color(WgcCoreDsColors.propertyClassifiedsPrimary)
                        )
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Phone,
                                contentDescription = null,
                                modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                            )
                            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                            Text(
                                text = "Ligar",
                                style = MaterialTheme.typography.labelLarge,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    // Botão Enviar Mensagem (Laranja Zap Oficial)
                    Button(
                        onClick = onSendMessageClick,
                        modifier = Modifier
                            .weight(1f)
                            .height(WgcCoreDsSize.s48.dp),
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(WgcCoreDsColors.propertyClassifiedsOrange),
                            contentColor = Color.White
                        )
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = null,
                                modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                            )
                            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                            Text(
                                text = "Mensagem",
                                style = MaterialTheme.typography.labelLarge,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(bottom = WgcCoreDsSpacing.lg24.dp)
        ) {
            // Imagem Principal com Tags e Contador
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(WgcCoreDsSize.s240.dp)
                        .background(Color(WgcCoreDsColors.propertyClassifiedsCardPlaceholder))
                ) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.propertyClassifiedsBorder),
                        modifier = Modifier
                            .size(WgcCoreDsSize.s72.dp)
                            .align(Alignment.Center)
                    )

                    // Selos no topo
                    Row(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(WgcCoreDsSpacing.md16.dp),
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                    ) {
                        if (property.badgeText != null) {
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
                                    text = property.badgeText.uppercase(),
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }
                        }

                        if (property.hasVirtualTour) {
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

                    // Contador de fotos
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(WgcCoreDsSpacing.md16.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                            .background(Color.Black.copy(alpha = 0.65f))
                            .padding(
                                horizontal = WgcCoreDsSpacing.sm12.dp,
                                vertical = WgcCoreDsSpacing.xxs4.dp
                            )
                    ) {
                        Text(
                            text = "1 de 24 fotos",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }

            // Bloco de Preço e Dados Principais
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(WgcCoreDsColors.propertyClassifiedsSurface))
                        .padding(WgcCoreDsSpacing.md16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Text(
                            text = property.price,
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(WgcCoreDsColors.propertyClassifiedsPrimary)
                        )
                        Text(
                            text = property.pricePerSquareMeter,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(WgcCoreDsColors.propertyClassifiedsSecondaryText)
                        )
                    }

                    if (property.condoAndIptu != null) {
                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                        Text(
                            text = property.condoAndIptu,
                            style = MaterialTheme.typography.bodySmall,
                            color = Color(WgcCoreDsColors.propertyClassifiedsSecondaryText)
                        )
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                    Text(
                        text = property.title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.propertyClassifiedsDark)
                    )

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.propertyClassifiedsSecondaryText),
                            modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                        )
                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                        Text(
                            text = "${property.neighborhood} • ${property.address}",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(WgcCoreDsColors.propertyClassifiedsSecondaryText)
                        )
                    }
                }
            }

            item { Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp)) }

            // Medidor Oficial do Índice FipeZAP
            item {
                Box(modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.md16.dp)) {
                    WgcPropertyClassifiedsIndexCard(
                        neighborhood = property.neighborhood,
                        propertyM2Price = property.pricePerSquareMeter,
                        neighborhoodAverageM2Price = "R$ 15.420/m²",
                        status = property.fipeStatus,
                        historicalVariation12m = "+6,4%",
                        insightText = "Preço altamente competitivo: oportunidade de compra com valor por m² " +
                            "abaixo da média apurada pela Fipe para este bairro."
                    )
                }
            }

            item { Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp)) }

            // Especificações Estruturais em Grade
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(WgcCoreDsColors.propertyClassifiedsSurface))
                        .padding(WgcCoreDsSpacing.md16.dp)
                ) {
                    Text(
                        text = "Características do Imóvel",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.propertyClassifiedsDark)
                    )

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        DetailSpecItem(
                            icon = Icons.Default.Home,
                            value = "${property.areaM2}m²",
                            label = "Área útil"
                        )
                        DetailSpecItem(
                            icon = Icons.Default.Bed,
                            value = "${property.bedrooms}",
                            label = if (property.suites > 0) "${property.suites} suíte(s)" else "Quartos"
                        )
                        DetailSpecItem(
                            icon = Icons.Default.Bathtub,
                            value = "${property.bathrooms}",
                            label = "Banheiros"
                        )
                        DetailSpecItem(
                            icon = Icons.Default.DirectionsCar,
                            value = "${property.parkingSpaces}",
                            label = "Vagas cobertas"
                        )
                    }
                }
            }

            item { Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp)) }

            // Comodidades & Lazer do Condomínio
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(WgcCoreDsColors.propertyClassifiedsSurface))
                        .padding(WgcCoreDsSpacing.md16.dp)
                ) {
                    Text(
                        text = "Comodidades e Condomínio",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.propertyClassifiedsDark)
                    )

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                    property.amenities.chunked(2).forEach { pair ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = WgcCoreDsSpacing.xxs4.dp),
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
                        ) {
                            pair.forEach { amenity ->
                                Row(
                                    modifier = Modifier.weight(1f),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Check,
                                        contentDescription = null,
                                        tint = Color(WgcCoreDsColors.propertyClassifiedsFipeGreen),
                                        modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                                    )
                                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                                    Text(
                                        text = amenity,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = Color(WgcCoreDsColors.propertyClassifiedsDark)
                                    )
                                }
                            }
                            if (pair.size == 1) {
                                Spacer(modifier = Modifier.weight(1f))
                            }
                        }
                    }
                }
            }

            item { Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp)) }

            // Descrição Detalhada
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(WgcCoreDsColors.propertyClassifiedsSurface))
                        .padding(WgcCoreDsSpacing.md16.dp)
                ) {
                    Text(
                        text = "Sobre este imóvel",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.propertyClassifiedsDark)
                    )

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                    Text(
                        text = property.description,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(WgcCoreDsColors.propertyClassifiedsSecondaryText)
                    )
                }
            }

            item { Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp)) }

            // Anunciante / Imobiliária
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(WgcCoreDsColors.propertyClassifiedsSurface))
                        .padding(WgcCoreDsSpacing.md16.dp)
                ) {
                    Text(
                        text = "Anunciante",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.propertyClassifiedsDark)
                    )

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(WgcCoreDsSize.s48.dp)
                                .clip(CircleShape)
                                .background(Color(WgcCoreDsColors.propertyClassifiedsPrimaryLight)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Verified,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.propertyClassifiedsPrimary),
                                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))

                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = property.advertiserName,
                                    style = MaterialTheme.typography.titleSmall,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(WgcCoreDsColors.propertyClassifiedsDark)
                                )
                                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                        .background(Color(WgcCoreDsColors.propertyClassifiedsBlueLight))
                                        .padding(
                                            horizontal = WgcCoreDsSpacing.xxs4.dp,
                                            vertical = WgcCoreDsSpacing.xxxs2.dp
                                        )
                                ) {
                                    Text(
                                        text = "Verificado",
                                        style = MaterialTheme.typography.labelSmall,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(WgcCoreDsColors.propertyClassifiedsBlue)
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxxs2.dp))
                            Text(
                                text = "${property.advertiserCreci} • ${property.advertiserPhone}",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(WgcCoreDsColors.propertyClassifiedsSecondaryText)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun DetailSpecItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    value: String,
    label: String
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(WgcCoreDsColors.propertyClassifiedsPrimary),
            modifier = Modifier.size(WgcCoreDsSize.s24.dp)
        )
        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
        Text(
            text = value,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
            color = Color(WgcCoreDsColors.propertyClassifiedsDark)
        )
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = Color(WgcCoreDsColors.propertyClassifiedsSecondaryText)
        )
    }
}

@Preview(name = "WgcZapPropertyDetailTemplate - Default", showBackground = true)
@Composable
private fun WgcZapPropertyDetailTemplatePreview() {
    MaterialTheme {
        WgcZapPropertyDetailTemplate()
    }
}
