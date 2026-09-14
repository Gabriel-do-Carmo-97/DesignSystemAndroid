package br.com.wgc.ds_templates.screens.vivareal.detail

import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import br.com.wgc.ds_templates.screens.vivareal.model.VivaRealMockData
import br.com.wgc.ds_templates.screens.vivareal.model.VivaRealPropertyModel

/**
 * Template da Tela de Detalhes do Imóvel do Viva Real:
 * - Galeria de fotos com selo Tour Virtual e contador
 * - Preço principal com discriminação de Condomínio e IPTU
 * - Card do anunciante/imobiliária com CRECI e selo de anunciante verificado
 * - Especificações e descrição do anunciante
 * - Lista de comodidades do condomínio
 * - Sticky bottom bar com CTAs diretos: WhatsApp (Verde) e Enviar Mensagem (Laranja)
 */
@Composable
fun WgcVivaRealPropertyDetailTemplate(
    modifier: Modifier = Modifier,
    property: VivaRealPropertyModel = VivaRealMockData.sampleProperty,
    onBackClick: () -> Unit = {},
    onShareClick: () -> Unit = {},
    onFavoriteToggle: () -> Unit = {},
    onWhatsAppClick: () -> Unit = {},
    onSendMessageClick: () -> Unit = {},
    photoSlot: (@Composable () -> Unit)? = null,
    bottomBarSlot: (@Composable () -> Unit)? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color(WgcCoreDsColors.vivaRealBackground),
        bottomBar = {
            if (bottomBarSlot != null) {
                bottomBarSlot()
            } else {
                VivaRealDetailBottomBar(
                    onWhatsAppClick = onWhatsAppClick,
                    onSendMessageClick = onSendMessageClick
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
            // Hero Photo Area
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(WgcCoreDsSize.s240.dp)
                        .background(Color(WgcCoreDsColors.vivaRealCardPlaceholder))
                ) {
                    if (photoSlot != null) {
                        photoSlot()
                    } else {
                        Box(
                            modifier = Modifier
                                .matchParentSize()
                                .background(Color(WgcCoreDsColors.vivaRealPrimaryLight)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.vivaRealPrimary),
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
                            tint = Color(WgcCoreDsColors.vivaRealDark),
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
                                tint = Color(WgcCoreDsColors.vivaRealDark),
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
                                tint = if (property.isFavorite) Color(WgcCoreDsColors.vivaRealOrange) else Color(WgcCoreDsColors.vivaRealDark),
                                modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                            )
                        }
                    }

                    // Badges inferiores: Tour Virtual e Contador
                    Row(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(WgcCoreDsSpacing.md16.dp),
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                    ) {
                        if (property.hasVirtualTour) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                    .background(Color(WgcCoreDsColors.vivaRealPrimary))
                                    .padding(
                                        horizontal = WgcCoreDsSpacing.xs8.dp,
                                        vertical = WgcCoreDsSpacing.xxs4.dp
                                    )
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        imageVector = Icons.Default.Videocam,
                                        contentDescription = null,
                                        tint = Color.White,
                                        modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                                    )
                                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                                    Text(
                                        text = "Tour Virtual",
                                        style = MaterialTheme.typography.labelSmall,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    )
                                }
                            }
                        }
                    }

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
                            text = "1/24 fotos",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }

            // Bloco de Preço e Endereço
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(WgcCoreDsColors.vivaRealSurface))
                        .padding(WgcCoreDsSpacing.md16.dp)
                ) {
                    Text(
                        text = property.price,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.vivaRealPrimary)
                    )

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))

                    Text(
                        text = "${property.condoPrice} • ${property.iptuPrice}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(WgcCoreDsColors.vivaRealSecondaryText)
                    )

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                    Text(
                        text = property.title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.vivaRealDark)
                    )

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.vivaRealSecondaryText),
                            modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                        )
                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                        Text(
                            text = "${property.address}, ${property.neighborhood} - ${property.city}",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color(WgcCoreDsColors.vivaRealSecondaryText)
                        )
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                    Text(
                        text = "Código do imóvel: ${property.code}",
                        style = MaterialTheme.typography.labelSmall,
                        color = Color(WgcCoreDsColors.vivaRealSecondaryText)
                    )
                }
            }

            // Especificações Estruturais
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.vivaRealSurface))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        SpecColumn(label = "Área útil", value = "${property.areaM2} m²")
                        SpecColumn(label = "Quartos", value = "${property.bedrooms}")
                        SpecColumn(label = "Suítes", value = "${property.suites}")
                        SpecColumn(label = "Banheiros", value = "${property.bathrooms}")
                        SpecColumn(label = "Vagas", value = "${property.parkingSpots}")
                    }
                }
            }

            // Card da Imobiliária / Anunciante
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.vivaRealSurface))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(WgcCoreDsSize.s48.dp)
                                .clip(CircleShape)
                                .background(Color(WgcCoreDsColors.vivaRealPrimaryLight)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Business,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.vivaRealPrimary),
                                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md16.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = property.agencyName,
                                    style = MaterialTheme.typography.titleSmall,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(WgcCoreDsColors.vivaRealDark)
                                )
                                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                                Icon(
                                    imageVector = Icons.Default.Verified,
                                    contentDescription = "Anunciante Verificado",
                                    tint = Color(WgcCoreDsColors.vivaRealPrimary),
                                    modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                                )
                            }
                            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                            Text(
                                text = property.agencyCreci,
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(WgcCoreDsColors.vivaRealSecondaryText)
                            )
                        }
                    }
                }
            }

            // Descrição do Imóvel
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.vivaRealSurface))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp)
                    ) {
                        Text(
                            text = "Sobre este imóvel",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.vivaRealDark)
                        )
                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
                        Text(
                            text = property.description,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(WgcCoreDsColors.vivaRealSecondaryText)
                        )
                    }
                }
            }

            // Comodidades e Lazer
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.vivaRealSurface))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp)
                    ) {
                        Text(
                            text = "Características do imóvel e condomínio",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.vivaRealDark)
                        )

                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                        property.amenities.chunked(2).forEach { rowItems ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = WgcCoreDsSpacing.xxs4.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                rowItems.forEach { amenity ->
                                    Row(
                                        modifier = Modifier.weight(1f),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Check,
                                            contentDescription = null,
                                            tint = Color(WgcCoreDsColors.vivaRealPrimary),
                                            modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                                        )
                                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                                        Text(
                                            text = amenity,
                                            style = MaterialTheme.typography.bodyMedium,
                                            color = Color(WgcCoreDsColors.vivaRealDark)
                                        )
                                    }
                                }
                                if (rowItems.size == 1) {
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
private fun SpecColumn(label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = value,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color(WgcCoreDsColors.vivaRealDark)
        )
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = Color(WgcCoreDsColors.vivaRealSecondaryText)
        )
    }
}

@Composable
private fun VivaRealDetailBottomBar(
    onWhatsAppClick: () -> Unit,
    onSendMessageClick: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color(WgcCoreDsColors.vivaRealSurface),
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
            // Botão WhatsApp (Verde WhatsApp)
            Button(
                onClick = onWhatsAppClick,
                modifier = Modifier
                    .weight(1f)
                    .height(WgcCoreDsSize.s48.dp),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(WgcCoreDsColors.vivaRealWhatsApp),
                    contentColor = Color.White
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
                        text = "WhatsApp",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // Botão Enviar Mensagem (Laranja Viva Real)
            Button(
                onClick = onSendMessageClick,
                modifier = Modifier
                    .weight(1f)
                    .height(WgcCoreDsSize.s48.dp),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(WgcCoreDsColors.vivaRealOrange),
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

@Preview(showBackground = true)
@Composable
private fun WgcVivaRealPropertyDetailTemplatePreview() {
    WgcVivaRealPropertyDetailTemplate()
}
