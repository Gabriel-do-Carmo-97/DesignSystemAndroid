package br.com.wgc.ds_templates.screens.propertylisting.home

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apartment
import androidx.compose.material.icons.filled.Bed
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.House
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import br.com.wgc.design_system.components.cards.WgcPropertyListingCard
import br.com.wgc.design_system.components.chip.WgcPropertyListingFilterChip
import br.com.wgc.design_system.components.fields.WgcPropertyListingPurpose
import br.com.wgc.design_system.components.fields.WgcPropertyListingSearchBar
import br.com.wgc.design_system.components.navigation.WgcPropertyListingBottomNav
import br.com.wgc.design_system.components.navigation.WgcPropertyListingNavItem
import br.com.wgc.ds_templates.screens.propertylisting.model.PropertyListingMockData
import br.com.wgc.ds_templates.screens.propertylisting.model.PropertyListingPropertyModel

/**
 * Template da Tela Inicial do portal Property Listing:
 * - TopBar institucional com logotipo Property Listing
 * - Barra de busca por bairros com seleção Comprar / Alugar / Lançamentos
 * - Carrossel de tipos de imóveis e filtros rápidos
 * - Vitrine de Imobiliárias Parceiras
 * - Feed de imóveis com destaques e contato direto com corretor
 */
@Composable
fun WgcPropertyListingHomeTemplate(
    modifier: Modifier = Modifier,
    properties: List<PropertyListingPropertyModel> = PropertyListingMockData.properties,
    searchQuery: String = "",
    onSearchQueryChange: (String) -> Unit = {},
    purpose: WgcPropertyListingPurpose = WgcPropertyListingPurpose.Buy,
    onPurposeChange: (WgcPropertyListingPurpose) -> Unit = {},
    selectedNavItem: WgcPropertyListingNavItem = WgcPropertyListingNavItem.Search,
    onNavItemSelect: (WgcPropertyListingNavItem) -> Unit = {},
    onPropertyClick: (PropertyListingPropertyModel) -> Unit = {},
    onFavoriteToggle: (String) -> Unit = {},
    onWhatsAppClick: (PropertyListingPropertyModel) -> Unit = {},
    onFilterClick: () -> Unit = {},
    onNotificationsClick: () -> Unit = {},
    topBarSlot: (@Composable () -> Unit)? = null,
    bottomBarSlot: (@Composable () -> Unit)? = null
) {
    var selectedTypeApartment by remember { mutableStateOf(false) }
    var selectedTypeHouse by remember { mutableStateOf(false) }
    var selectedFilterVirtualTour by remember { mutableStateOf(false) }
    var selectedFilterBedrooms by remember { mutableStateOf(false) }
    var selectedFilterParking by remember { mutableStateOf(false) }

    val filteredProperties = properties.filter { prop ->
        val matchesSearch = searchQuery.isBlank() ||
                prop.neighborhood.contains(searchQuery, ignoreCase = true) ||
                prop.address.contains(searchQuery, ignoreCase = true) ||
                prop.title.contains(searchQuery, ignoreCase = true) ||
                prop.city.contains(searchQuery, ignoreCase = true)
        val matchesTour = !selectedFilterVirtualTour || prop.hasVirtualTour
        val matchesBedrooms = !selectedFilterBedrooms || prop.bedrooms >= 2
        val matchesParking = !selectedFilterParking || prop.parkingSpots >= 1
        val matchesType = when {
            selectedTypeApartment -> prop.propertyType.contains("Apartamento", ignoreCase = true) || prop.propertyType.contains("Studio", ignoreCase = true)
            selectedTypeHouse -> prop.propertyType.contains("Casa", ignoreCase = true)
            else -> true
        }
        matchesSearch && matchesTour && matchesBedrooms && matchesParking && matchesType
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            if (topBarSlot != null) {
                topBarSlot()
            } else {
                PropertyListingHomeTopBar(onNotificationsClick = onNotificationsClick)
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
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(bottom = WgcCoreDsSpacing.xl32.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            // Busca e Seletor de Finalidade
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(WgcCoreDsColors.propertyListingSurface))
                        .padding(WgcCoreDsSpacing.md16.dp)
                ) {
                    WgcPropertyListingSearchBar(
                        purpose = purpose,
                        onPurposeChange = onPurposeChange,
                        query = searchQuery,
                        onQueryChange = onSearchQueryChange,
                        activeFilterCount = listOf(
                            selectedTypeApartment,
                            selectedTypeHouse,
                            selectedFilterVirtualTour,
                            selectedFilterBedrooms,
                            selectedFilterParking
                        ).count { it },
                        onFilterClick = onFilterClick
                    )
                }
            }

            // Carrossel de Filtros Rápidos
            item {
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(horizontal = WgcCoreDsSpacing.md16.dp),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    item {
                        WgcPropertyListingFilterChip(
                            label = "Apartamento",
                            isSelected = selectedTypeApartment,
                            leadingIcon = Icons.Default.Apartment,
                            onClick = {
                                selectedTypeApartment = !selectedTypeApartment
                                if (selectedTypeApartment) selectedTypeHouse = false
                            }
                        )
                    }
                    item {
                        WgcPropertyListingFilterChip(
                            label = "Casa",
                            isSelected = selectedTypeHouse,
                            leadingIcon = Icons.Default.House,
                            onClick = {
                                selectedTypeHouse = !selectedTypeHouse
                                if (selectedTypeHouse) selectedTypeApartment = false
                            }
                        )
                    }
                    item {
                        WgcPropertyListingFilterChip(
                            label = "Tour Virtual",
                            isSelected = selectedFilterVirtualTour,
                            leadingIcon = Icons.Default.Videocam,
                            onClick = { selectedFilterVirtualTour = !selectedFilterVirtualTour }
                        )
                    }
                    item {
                        WgcPropertyListingFilterChip(
                            label = "2+ quartos",
                            isSelected = selectedFilterBedrooms,
                            leadingIcon = Icons.Default.Bed,
                            onClick = { selectedFilterBedrooms = !selectedFilterBedrooms }
                        )
                    }
                    item {
                        WgcPropertyListingFilterChip(
                            label = "Com vaga",
                            isSelected = selectedFilterParking,
                            leadingIcon = Icons.Default.DirectionsCar,
                            onClick = { selectedFilterParking = !selectedFilterParking }
                        )
                    }
                }
            }

            // Vitrine de Imobiliárias Parceiras
            item {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Imobiliárias em Destaque",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.propertyListingDark),
                        modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.md16.dp)
                    )

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(horizontal = WgcCoreDsSpacing.md16.dp),
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                    ) {
                        val agencies = listOf("Lopes Prime", "Lello Imóveis", "Coelho da Fonseca", "Itambé Imóveis")
                        items(agencies) { agency ->
                            Card(
                                shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                                colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.propertyListingSurface)),
                                elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsSpacing.xxxs2.dp)
                            ) {
                                Row(
                                    modifier = Modifier.padding(
                                        horizontal = WgcCoreDsSpacing.md16.dp,
                                        vertical = WgcCoreDsSpacing.sm12.dp
                                    ),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(WgcCoreDsSize.s32.dp)
                                            .clip(CircleShape)
                                            .background(Color(WgcCoreDsColors.propertyListingPrimaryLight)),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Business,
                                            contentDescription = null,
                                            tint = Color(WgcCoreDsColors.propertyListingPrimary),
                                            modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                                    Text(
                                        text = agency,
                                        style = MaterialTheme.typography.labelMedium,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(WgcCoreDsColors.propertyListingDark)
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // Feed de Imóveis
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Imóveis Encontrados (${filteredProperties.size})",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.propertyListingDark)
                    )
                }
            }

            items(filteredProperties, key = { it.id }) { property ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp)
                ) {
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
                        isFavorite = property.isFavorite,
                        onFavoriteToggle = { onFavoriteToggle(property.id) },
                        onWhatsAppClick = { onWhatsAppClick(property) },
                        onClick = { onPropertyClick(property) }
                    )
                }
            }
        }
    }
}

@Composable
private fun PropertyListingHomeTopBar(
    onNotificationsClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(WgcCoreDsColors.propertyListingSurface))
            .padding(
                horizontal = WgcCoreDsSpacing.md16.dp,
                vertical = WgcCoreDsSpacing.sm12.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Logo Property Listing
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(WgcCoreDsSize.s32.dp)
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                    .background(Color(WgcCoreDsColors.propertyListingPrimary)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "VR",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Black,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))

            Column {
                Text(
                    text = "Property Listing",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.propertyListingPrimary)
                )
                Text(
                    text = "O maior portal de imóveis",
                    style = MaterialTheme.typography.labelSmall,
                    color = Color(WgcCoreDsColors.propertyListingSecondaryText)
                )
            }
        }

        IconButton(
            onClick = onNotificationsClick,
            modifier = Modifier
                .size(WgcCoreDsSize.s40.dp)
                .clip(CircleShape)
                .background(Color(WgcCoreDsColors.propertyListingBackground))
        ) {
            Icon(
                imageVector = Icons.Default.NotificationsNone,
                contentDescription = "Alertas e Notificações",
                tint = Color(WgcCoreDsColors.propertyListingDark),
                modifier = Modifier.size(WgcCoreDsSize.s22.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcPropertyListingHomeTemplatePreview() {
    WgcPropertyListingHomeTemplate()
}
