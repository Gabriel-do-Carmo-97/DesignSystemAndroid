package br.com.wgc.ds_templates.screens.quintoandar.detail

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
import androidx.compose.material.icons.automirrored.filled.DirectionsWalk
import androidx.compose.material.icons.filled.Bathtub
import androidx.compose.material.icons.filled.Bed
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Share
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
import androidx.compose.material3.Surface
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
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.ds_templates.screens.quintoandar.model.QuintoAndarMockData
import br.com.wgc.ds_templates.screens.quintoandar.model.QuintoAndarPropertyModel

/**
 * Template da Tela de Detalhes do Imóvel do QuintoAndar:
 * - Galeria de fotos de alta fidelidade com contador
 * - Discriminação completa de custos (Aluguel, Condomínio, IPTU, Seguro, Taxa de serviço)
 * - Especificações estruturais (área m², quartos, suítes, banheiros, vagas)
 * - Lista de comodidades e itens do condomínio
 * - Localização e facilidades do bairro
 * - Barra fixa inferior com ações "Agendar Visita" e "Fazer Proposta"
 */
@Composable
fun WgcQuintoAndarPropertyDetailTemplate(
    modifier: Modifier = Modifier,
    property: QuintoAndarPropertyModel = QuintoAndarMockData.sampleDetailProperty,
    onBackClick: () -> Unit = {},
    onShareClick: () -> Unit = {},
    onFavoriteToggle: () -> Unit = {},
    onScheduleVisitClick: () -> Unit = {},
    onMakeProposalClick: () -> Unit = {},
    photoSlot: (@Composable () -> Unit)? = null,
    bottomBarSlot: (@Composable () -> Unit)? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color(WgcCoreDsColors.quintoAndarBackground),
        bottomBar = {
            if (bottomBarSlot != null) {
                bottomBarSlot()
            } else {
                QuintoAndarDetailBottomBar(
                    totalPrice = property.totalPrice,
                    onScheduleVisitClick = onScheduleVisitClick,
                    onMakeProposalClick = onMakeProposalClick
                )
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(bottom = WgcCoreDsSpacing.xl32.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            // Hero Photo Area com botões flutuantes
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(WgcCoreDsSize.s240.dp)
                        .background(Color(WgcCoreDsColors.quintoAndarCardPlaceholder))
                ) {
                    if (photoSlot != null) {
                        photoSlot()
                    } else {
                        Box(
                            modifier = Modifier
                                .matchParentSize()
                                .background(Color(WgcCoreDsColors.quintoAndarPrimaryLight)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.quintoAndarPrimary),
                                modifier = Modifier.size(WgcCoreDsSize.s64.dp)
                            )
                        }
                    }

                    // Botão Voltar
                    IconButton(
                        onClick = onBackClick,
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(WgcCoreDsSpacing.md16.dp)
                            .size(WgcCoreDsSize.s40.dp)
                            .clip(CircleShape)
                            .background(Color.White.copy(alpha = 0.9f))
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar",
                            tint = Color(WgcCoreDsColors.quintoAndarDark),
                            modifier = Modifier.size(WgcCoreDsSize.s22.dp)
                        )
                    }

                    // Ações Top Right: Compartilhar & Favoritar
                    Row(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(WgcCoreDsSpacing.md16.dp),
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                    ) {
                        IconButton(
                            onClick = onShareClick,
                            modifier = Modifier
                                .size(WgcCoreDsSize.s40.dp)
                                .clip(CircleShape)
                                .background(Color.White.copy(alpha = 0.9f))
                        ) {
                            Icon(
                                imageVector = Icons.Default.Share,
                                contentDescription = "Compartilhar",
                                tint = Color(WgcCoreDsColors.quintoAndarDark),
                                modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                            )
                        }

                        IconButton(
                            onClick = onFavoriteToggle,
                            modifier = Modifier
                                .size(WgcCoreDsSize.s40.dp)
                                .clip(CircleShape)
                                .background(Color.White.copy(alpha = 0.9f))
                        ) {
                            Icon(
                                imageVector = if (property.isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                                contentDescription = "Favoritar",
                                tint = if (property.isFavorite) Color(WgcCoreDsColors.quintoAndarCoral) else Color(WgcCoreDsColors.quintoAndarDark),
                                modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                            )
                        }
                    }

                    // Contador de fotos no canto inferior direito
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(WgcCoreDsSpacing.md16.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                            .background(Color.Black.copy(alpha = 0.65f))
                            .padding(
                                horizontal = WgcCoreDsSpacing.xs8.dp,
                                vertical = WgcCoreDsSpacing.xxs4.dp
                            )
                    ) {
                        Text(
                            text = "1/15 fotos",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }

            // Título, Endereço e Bairro
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(WgcCoreDsColors.quintoAndarSurface))
                        .padding(WgcCoreDsSpacing.md16.dp)
                ) {
                    // Tag Sem Fiador
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                            .background(Color(WgcCoreDsColors.quintoAndarCoral))
                            .padding(
                                horizontal = WgcCoreDsSpacing.xs8.dp,
                                vertical = WgcCoreDsSpacing.xxs4.dp
                            )
                    ) {
                        Text(
                            text = "Sem Fiador e Sem Caução",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                    Text(
                        text = property.title,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.quintoAndarDark)
                    )

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.quintoAndarSecondaryText),
                            modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                        )
                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                        Text(
                            text = "${property.address}, ${property.neighborhood} - ${property.city}",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(WgcCoreDsColors.quintoAndarSecondaryText)
                        )
                    }
                }
            }

            // Grade de Especificações Básicas (Área, Quartos, Suítes, Banheiros, Vagas)
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.quintoAndarSurface))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        DetailSpecItem(label = "Área", value = "${property.areaM2} m²")
                        DetailSpecItem(label = "Quartos", value = "${property.bedrooms}")
                        DetailSpecItem(label = "Suítes", value = "${property.suites}")
                        DetailSpecItem(label = "Banheiros", value = "${property.bathrooms}")
                        DetailSpecItem(label = "Vagas", value = "${property.parkingSpots}")
                    }
                }
            }

            // Card Detalhado de Composição de Valores (Aluguel, Condomínio, IPTU, Seguro, Taxa)
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.quintoAndarSurface))
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
                            Text(
                                text = "Composição de Valores",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = Color(WgcCoreDsColors.quintoAndarDark)
                            )
                            Icon(
                                imageVector = Icons.Default.Info,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.quintoAndarSecondaryText),
                                modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

                        CostRow(label = "Aluguel", value = property.rentPrice)
                        CostRow(label = "Condomínio estimado", value = property.condoPrice)
                        CostRow(label = "IPTU", value = property.iptuPrice)
                        CostRow(label = "Taxa de serviço QuintoAndar", value = property.serviceFee)
                        CostRow(label = "Seguro incêndio", value = property.fireInsurance)

                        HorizontalDivider(
                            modifier = Modifier.padding(vertical = WgcCoreDsSpacing.xs8.dp),
                            color = Color(WgcCoreDsColors.quintoAndarBorder)
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Total mensal previsto",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = Color(WgcCoreDsColors.quintoAndarPrimary)
                            )
                            Text(
                                text = property.totalPrice.replace("Total ", ""),
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color(WgcCoreDsColors.quintoAndarPrimary)
                            )
                        }
                    }
                }
            }

            // Proximidade com Transporte / Metrô
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.quintoAndarSurface))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(WgcCoreDsSize.s44.dp)
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                                .background(Color(WgcCoreDsColors.quintoAndarYellowLight)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.DirectionsWalk,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.quintoAndarPrimary),
                                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Localização privilegiada",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = Color(WgcCoreDsColors.quintoAndarDark)
                            )
                            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                            Text(
                                text = property.metroDistanceText,
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(WgcCoreDsColors.quintoAndarSecondaryText)
                            )
                        }
                    }
                }
            }

            // Comodidades do Imóvel e Condomínio
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.quintoAndarSurface))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp)
                    ) {
                        Text(
                            text = "Comodidades e Lazer",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.quintoAndarDark)
                        )

                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                        property.amenities.chunked(2).forEach { rowAmenities ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = WgcCoreDsSpacing.xxs4.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                rowAmenities.forEach { amenity ->
                                    Row(
                                        modifier = Modifier.weight(1f),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Check,
                                            contentDescription = null,
                                            tint = Color(WgcCoreDsColors.quintoAndarGreen),
                                            modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                                        )
                                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                                        Text(
                                            text = amenity,
                                            style = MaterialTheme.typography.bodyMedium,
                                            color = Color(WgcCoreDsColors.quintoAndarDark)
                                        )
                                    }
                                }
                                if (rowAmenities.size == 1) {
                                    Spacer(modifier = Modifier.weight(1f))
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun DetailSpecItem(label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = value,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color(WgcCoreDsColors.quintoAndarDark)
        )
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = Color(WgcCoreDsColors.quintoAndarSecondaryText)
        )
    }
}

@Composable
private fun CostRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = WgcCoreDsSpacing.xxs4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = Color(WgcCoreDsColors.quintoAndarSecondaryText)
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold,
            color = Color(WgcCoreDsColors.quintoAndarDark)
        )
    }
}

@Composable
private fun QuintoAndarDetailBottomBar(
    totalPrice: String,
    onScheduleVisitClick: () -> Unit,
    onMakeProposalClick: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color(WgcCoreDsColors.quintoAndarSurface),
        shadowElevation = WgcCoreDsSpacing.md16.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = WgcCoreDsSpacing.md16.dp,
                    vertical = WgcCoreDsSpacing.sm12.dp
                ),
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Botão Fazer Proposta (Outlined)
            OutlinedButton(
                onClick = onMakeProposalClick,
                modifier = Modifier
                    .weight(1f)
                    .height(WgcCoreDsSize.s48.dp),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                border = androidx.compose.foundation.BorderStroke(
                    width = WgcCoreDsSpacing.xxxs2.dp,
                    color = Color(WgcCoreDsColors.quintoAndarPrimary)
                )
            ) {
                Text(
                    text = "Fazer Proposta",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.quintoAndarPrimary)
                )
            }

            // Botão Agendar Visita (Amarelo QuintoAndar)
            Button(
                onClick = onScheduleVisitClick,
                modifier = Modifier
                    .weight(1f)
                    .height(WgcCoreDsSize.s48.dp),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(WgcCoreDsColors.quintoAndarYellow),
                    contentColor = Color(WgcCoreDsColors.quintoAndarDark)
                )
            ) {
                Text(
                    text = "Agendar Visita",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcQuintoAndarPropertyDetailTemplatePreview() {
    WgcQuintoAndarPropertyDetailTemplate()
}
