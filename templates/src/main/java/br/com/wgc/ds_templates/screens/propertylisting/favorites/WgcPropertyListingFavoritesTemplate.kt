package br.com.wgc.ds_templates.screens.propertylisting.favorites

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import br.com.wgc.design_system.components.cards.WgcPropertyListingCard
import br.com.wgc.design_system.components.navigation.WgcPropertyListingBottomNav
import br.com.wgc.design_system.components.navigation.WgcPropertyListingNavItem
import br.com.wgc.ds_templates.screens.propertylisting.model.PropertyListingMockData
import br.com.wgc.ds_templates.screens.propertylisting.model.PropertyListingPropertyModel

enum class PropertyListingSavedTab {
    Properties,
    Alerts
}

/**
 * Template de Favoritos e Alertas de Busca do Property Listing:
 * - Alternância entre Imóveis Salvos e Alertas de Bairros
 * - Listagem com cards completos e contato rápido
 * - Estado vazio informativo com botão de exploração
 */
@Composable
fun WgcPropertyListingFavoritesTemplate(
    modifier: Modifier = Modifier,
    savedProperties: List<PropertyListingPropertyModel> = PropertyListingMockData.properties.filter { it.isFavorite },
    onPropertyClick: (PropertyListingPropertyModel) -> Unit = {},
    onFavoriteToggle: (String) -> Unit = {},
    onWhatsAppClick: (PropertyListingPropertyModel) -> Unit = {},
    onExploreClick: () -> Unit = {},
    selectedNavItem: WgcPropertyListingNavItem = WgcPropertyListingNavItem.Favorites,
    onNavItemSelect: (WgcPropertyListingNavItem) -> Unit = {},
    topBarSlot: (@Composable () -> Unit)? = null,
    bottomBarSlot: (@Composable () -> Unit)? = null
) {
    var currentTab by remember { mutableStateOf(PropertyListingSavedTab.Properties) }

    val mockAlerts = listOf(
        "Apartamentos em Moema até R$ 900.000",
        "Casas em Perdizes com 3+ quartos para alugar",
        "Studios na Vila Olímpia com Tour Virtual"
    )

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            if (topBarSlot != null) {
                topBarSlot()
            } else {
                PropertyListingFavoritesTopBar(
                    currentTab = currentTab,
                    onTabSelect = { currentTab = it },
                    propertiesCount = savedProperties.size,
                    alertsCount = mockAlerts.size
                )
            }
        },
        bottomBar = {
            if (bottomBarSlot != null) {
                bottomBarSlot()
            } else {
                WgcPropertyListingBottomNav(
                    selectedItem = selectedNavItem,
                    onItemSelected = onNavItemSelect,
                    messagesBadgeCount = 2
                )
            }
        }
    ) { innerPadding ->
        if (currentTab == PropertyListingSavedTab.Properties) {
            if (savedProperties.isEmpty()) {
                FavoritesEmptyState(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    onExploreClick = onExploreClick
                )
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    contentPadding = PaddingValues(
                        horizontal = WgcCoreDsSpacing.md16.dp,
                        vertical = WgcCoreDsSpacing.md16.dp
                    ),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
                ) {
                    items(savedProperties, key = { it.id }) { property ->
                        WgcPropertyListingCard(
                            title = property.title,
                            neighborhood = property.neighborhood,
                            address = property.address,
                            price = property.price,
                            condoAndIptu = "${property.condoPrice} • ${property.iptuPrice}",
                            areaM2 = property.areaM2,
                            bedrooms = property.bedrooms,
                            suites = property.suites,
                            bathrooms = property.bathrooms,
                            parkingSpots = property.parkingSpots,
                            agencyName = property.agencyName,
                            badgeText = property.badgeText,
                            isFavorite = true,
                            onFavoriteToggle = { onFavoriteToggle(property.id) },
                            onWhatsAppClick = { onWhatsAppClick(property) },
                            onClick = { onPropertyClick(property) }
                        )
                    }
                }
            }
        } else {
            // Aba de Alertas de Busca
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentPadding = PaddingValues(
                    horizontal = WgcCoreDsSpacing.md16.dp,
                    vertical = WgcCoreDsSpacing.md16.dp
                ),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
            ) {
                items(mockAlerts) { alertTitle ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.propertyListingSurface))
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(WgcCoreDsSpacing.md16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(WgcCoreDsSize.s40.dp)
                                    .clip(CircleShape)
                                    .background(Color(WgcCoreDsColors.propertyListingPrimaryLight)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.NotificationsActive,
                                    contentDescription = null,
                                    tint = Color(WgcCoreDsColors.propertyListingPrimary),
                                    modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md16.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = alertTitle,
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(WgcCoreDsColors.propertyListingDark)
                                )
                                Text(
                                    text = "Notificações ativas por e-mail e app",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Color(WgcCoreDsColors.propertyListingSecondaryText)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun PropertyListingFavoritesTopBar(
    currentTab: PropertyListingSavedTab,
    onTabSelect: (PropertyListingSavedTab) -> Unit,
    propertiesCount: Int,
    alertsCount: Int
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color(WgcCoreDsColors.propertyListingSurface),
        shadowElevation = WgcCoreDsSpacing.xxs4.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp)
        ) {
            Text(
                text = "Salvos & Alertas",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.propertyListingDark)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            // Switcher Pílula
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                    .background(Color(WgcCoreDsColors.propertyListingBackground))
                    .padding(WgcCoreDsSpacing.xxs4.dp)
            ) {
                TabPill(
                    label = "Imóveis ($propertiesCount)",
                    isSelected = currentTab == PropertyListingSavedTab.Properties,
                    onClick = { onTabSelect(PropertyListingSavedTab.Properties) }
                )
                TabPill(
                    label = "Alertas de Busca ($alertsCount)",
                    isSelected = currentTab == PropertyListingSavedTab.Alerts,
                    onClick = { onTabSelect(PropertyListingSavedTab.Alerts) }
                )
            }
        }
    }
}

@Composable
private fun TabPill(
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
            .background(
                if (isSelected) Color(WgcCoreDsColors.propertyListingPrimary) else Color.Transparent
            )
            .clickable(onClick = onClick)
            .padding(
                horizontal = WgcCoreDsSpacing.md16.dp,
                vertical = WgcCoreDsSpacing.xs8.dp
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
            color = if (isSelected) Color.White else Color(WgcCoreDsColors.propertyListingSecondaryText)
        )
    }
}

@Composable
private fun FavoritesEmptyState(
    modifier: Modifier = Modifier,
    onExploreClick: () -> Unit
) {
    Box(
        modifier = modifier.padding(WgcCoreDsSpacing.xl32.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(WgcCoreDsSize.s80.dp)
                    .clip(CircleShape)
                    .background(Color(WgcCoreDsColors.propertyListingPrimaryLight)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = null,
                    tint = Color(WgcCoreDsColors.propertyListingOrange),
                    modifier = Modifier.size(WgcCoreDsSize.s40.dp)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            Text(
                text = "Nenhum imóvel favoritado",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.propertyListingDark)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            Text(
                text = "Salve os imóveis que você mais gostou para comparar preços e contatar corretores com facilidade.",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(WgcCoreDsColors.propertyListingSecondaryText)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            Button(
                onClick = onExploreClick,
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(WgcCoreDsColors.propertyListingPrimary),
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Buscar Imóveis",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcPropertyListingFavoritesTemplatePreview() {
    WgcPropertyListingFavoritesTemplate()
}
