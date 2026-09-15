package br.com.wgc.ds_templates.screens.zap.home

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import br.com.wgc.design_system.components.cards.WgcZapPropertyCard
import br.com.wgc.design_system.components.fields.WgcZapSearchBar
import br.com.wgc.design_system.components.fields.WgcZapSearchRadius
import br.com.wgc.design_system.components.navigation.WgcZapBottomNav
import br.com.wgc.design_system.components.navigation.WgcZapNavDestination
import br.com.wgc.ds_templates.screens.zap.model.ZapMockData
import br.com.wgc.ds_templates.screens.zap.model.ZapPropertyModel
import br.com.wgc.ds_templates.screens.zap.model.ZapTransactionType

/**
 * Template da Tela Principal (Home / Feed de Imóveis) do Zap Imóveis.
 */
@Composable
fun WgcZapHomeTemplate(
    properties: List<ZapPropertyModel> = ZapMockData.sampleProperties,
    selectedTransaction: ZapTransactionType = ZapTransactionType.BUY,
    onTransactionSelect: (ZapTransactionType) -> Unit = {},
    searchQuery: String = "",
    onSearchQueryChange: (String) -> Unit = {},
    selectedRadius: WgcZapSearchRadius = WgcZapSearchRadius.RADIUS_5KM,
    onRadiusSelect: (WgcZapSearchRadius) -> Unit = {},
    onPropertyClick: (ZapPropertyModel) -> Unit = {},
    onFavoriteToggle: (ZapPropertyModel) -> Unit = {},
    onFipeBannerClick: () -> Unit = {},
    onFilterClick: () -> Unit = {},
    currentNavDestination: WgcZapNavDestination = WgcZapNavDestination.SEARCH,
    onNavSelect: (WgcZapNavDestination) -> Unit = {},
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            WgcZapBottomNav(
                selectedDestination = currentNavDestination,
                onDestinationSelect = onNavSelect
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(bottom = WgcCoreDsSpacing.lg24.dp)
        ) {
            // Header: TopBar Oficial do Zap Imóveis
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(WgcCoreDsColors.zapSurface))
                        .padding(
                            horizontal = WgcCoreDsSpacing.md16.dp,
                            vertical = WgcCoreDsSpacing.sm12.dp
                        )
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Logotipo ZAP Imóveis
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "ZAP",
                                style = MaterialTheme.typography.headlineSmall,
                                fontWeight = FontWeight.Black,
                                color = Color(WgcCoreDsColors.zapPrimary)
                            )
                            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                    .background(Color(WgcCoreDsColors.zapOrange))
                                    .padding(
                                        horizontal = WgcCoreDsSpacing.xxs4.dp,
                                        vertical = WgcCoreDsSpacing.xxxs2.dp
                                    )
                            ) {
                                Text(
                                    text = "IMÓVEIS",
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }
                        }

                        // Seletor de Cidade / Notificações
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Row(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                                    .background(Color(WgcCoreDsColors.zapBackground))
                                    .padding(
                                        horizontal = WgcCoreDsSpacing.xs8.dp,
                                        vertical = WgcCoreDsSpacing.xxs4.dp
                                    ),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "São Paulo, SP",
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color(WgcCoreDsColors.zapDark)
                                )
                                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowDown,
                                    contentDescription = null,
                                    tint = Color(WgcCoreDsColors.zapSecondaryText),
                                    modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                                )
                            }

                            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))

                            IconButton(
                                onClick = {},
                                modifier = Modifier.size(WgcCoreDsSize.s32.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.NotificationsNone,
                                    contentDescription = "Notificações",
                                    tint = Color(WgcCoreDsColors.zapDark),
                                    modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                    // Alternador de Transação: Comprar / Alugar / Lançamentos
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                            .background(Color(WgcCoreDsColors.zapBackground))
                            .padding(WgcCoreDsSpacing.xxs4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        ZapTransactionType.entries.forEach { transaction ->
                            val isSelected = transaction == selectedTransaction
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                    .background(
                                        if (isSelected) {
                                            Color(WgcCoreDsColors.zapPrimary)
                                        } else {
                                            Color.Transparent
                                        }
                                    )
                                    .clickable { onTransactionSelect(transaction) }
                                    .padding(vertical = WgcCoreDsSpacing.xs8.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = transaction.label,
                                    style = MaterialTheme.typography.labelMedium,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                    color = if (isSelected) Color.White else Color(WgcCoreDsColors.zapSecondaryText)
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                    // Barra de Busca Oficial Zap com Raio Geográfico
                    WgcZapSearchBar(
                        query = searchQuery,
                        onQueryChange = onSearchQueryChange,
                        selectedRadius = selectedRadius,
                        onRadiusSelect = onRadiusSelect,
                        onFilterClick = onFilterClick,
                        onClearQuery = { onSearchQueryChange("") }
                    )
                }
            }

            item { Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp)) }

            // Banner Interativo do Índice FipeZAP
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp))
                        .background(Color(WgcCoreDsColors.zapPrimary))
                        .clickable(onClick = onFipeBannerClick)
                        .padding(WgcCoreDsSpacing.md16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(WgcCoreDsSize.s40.dp)
                                    .clip(CircleShape)
                                    .background(Color(WgcCoreDsColors.zapBlue))
                                    .padding(WgcCoreDsSpacing.xs8.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Analytics,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))
                            Column {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        text = "Índice FipeZAP",
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    )
                                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                            .background(Color(WgcCoreDsColors.zapFipeGreen))
                                            .padding(
                                                horizontal = WgcCoreDsSpacing.xxs4.dp,
                                                vertical = WgcCoreDsSpacing.xxxs2.dp
                                            )
                                    ) {
                                        Text(
                                            text = "+5,8% em 12m",
                                            style = MaterialTheme.typography.labelSmall,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.White
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxxs2.dp))
                                Text(
                                    text = "Descubra o valor real do m² por bairro em SP",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Color.White.copy(alpha = 0.85f)
                                )
                            }
                        }

                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = "Ver índice completo",
                            tint = Color.White,
                            modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                        )
                    }
                }
            }

            item { Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp)) }

            // Seção Super Destaques em Carrossel
            item {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = WgcCoreDsSpacing.md16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "⭐ Super Destaques Zap",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.zapDark)
                        )
                        Text(
                            text = "Ver todos",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.zapBlue)
                        )
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                    LazyRow(
                        contentPadding = PaddingValues(horizontal = WgcCoreDsSpacing.md16.dp),
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
                    ) {
                        items(properties.filter { it.badgeText == "Super Destaque" }) { prop ->
                            Box(modifier = Modifier.width(WgcCoreDsSize.s300.dp)) {
                                WgcZapPropertyCard(
                                    title = prop.title,
                                    price = prop.price,
                                    pricePerSquareMeter = prop.pricePerSquareMeter,
                                    condoAndIptu = prop.condoAndIptu,
                                    neighborhood = prop.neighborhood,
                                    address = prop.address,
                                    areaM2 = prop.areaM2,
                                    bedrooms = prop.bedrooms,
                                    suites = prop.suites,
                                    bathrooms = prop.bathrooms,
                                    parkingSpaces = prop.parkingSpaces,
                                    fipeStatus = prop.fipeStatus,
                                    badgeText = prop.badgeText,
                                    advertiserName = prop.advertiserName,
                                    hasVirtualTour = prop.hasVirtualTour,
                                    isFavorite = prop.isFavorite,
                                    onCardClick = { onPropertyClick(prop) },
                                    onFavoriteClick = { onFavoriteToggle(prop) }
                                )
                            }
                        }
                    }
                }
            }

            item { Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp)) }

            // Feed Geral de Imóveis Recomendados
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Imóveis recomendados",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.zapDark)
                    )
                    Text(
                        text = "${properties.size} imóveis",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(WgcCoreDsColors.zapSecondaryText)
                    )
                }
            }

            item { Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp)) }

            items(properties) { prop ->
                Box(modifier = Modifier.padding(
                    horizontal = WgcCoreDsSpacing.md16.dp,
                    vertical = WgcCoreDsSpacing.xs8.dp
                )) {
                    WgcZapPropertyCard(
                        title = prop.title,
                        price = prop.price,
                        pricePerSquareMeter = prop.pricePerSquareMeter,
                        condoAndIptu = prop.condoAndIptu,
                        neighborhood = prop.neighborhood,
                        address = prop.address,
                        areaM2 = prop.areaM2,
                        bedrooms = prop.bedrooms,
                        suites = prop.suites,
                        bathrooms = prop.bathrooms,
                        parkingSpaces = prop.parkingSpaces,
                        fipeStatus = prop.fipeStatus,
                        badgeText = prop.badgeText,
                        advertiserName = prop.advertiserName,
                        hasVirtualTour = prop.hasVirtualTour,
                        isFavorite = prop.isFavorite,
                        onCardClick = { onPropertyClick(prop) },
                        onFavoriteClick = { onFavoriteToggle(prop) }
                    )
                }
            }
        }
    }
}

@Preview(name = "WgcZapHomeTemplate - Default", showBackground = true)
@Composable
private fun WgcZapHomeTemplatePreview() {
    MaterialTheme {
        var query by remember { mutableStateOf("") }
        var transaction by remember { mutableStateOf(ZapTransactionType.BUY) }
        WgcZapHomeTemplate(
            searchQuery = query,
            onSearchQueryChange = { query = it },
            selectedTransaction = transaction,
            onTransactionSelect = { transaction = it }
        )
    }
}
