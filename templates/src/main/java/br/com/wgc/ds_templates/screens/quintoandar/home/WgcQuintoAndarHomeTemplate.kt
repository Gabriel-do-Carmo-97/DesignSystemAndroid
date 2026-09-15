package br.com.wgc.ds_templates.screens.quintoandar.home

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
import androidx.compose.material.icons.filled.Bed
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DirectionsSubway
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Weekend
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
import br.com.wgc.design_system.components.cards.WgcQuintoAndarPropertyCard
import br.com.wgc.design_system.components.chip.WgcQuintoAndarFilterChip
import br.com.wgc.design_system.components.fields.WgcQuintoAndarContractType
import br.com.wgc.design_system.components.fields.WgcQuintoAndarSearchBar
import br.com.wgc.design_system.components.navigation.WgcQuintoAndarBottomNav
import br.com.wgc.design_system.components.navigation.WgcQuintoAndarNavItem
import br.com.wgc.ds_templates.screens.quintoandar.model.QuintoAndarMockData
import br.com.wgc.ds_templates.screens.quintoandar.model.QuintoAndarPropertyModel

/**
 * Template da Tela Inicial / Explorar do QuintoAndar:
 * - TopBar institucional com logotipo e notificações
 * - Seletor Alugar / Comprar e busca de bairros
 * - Carrossel de filtros rápidos (Preço, 2+ quartos, Pet friendly, Metrô, Mobiliado)
 * - Banner informativo "Sem Fiador, Sem Caução"
 * - Feed de imóveis disponíveis
 */
@Composable
fun WgcQuintoAndarHomeTemplate(
    modifier: Modifier = Modifier,
    properties: List<QuintoAndarPropertyModel> = QuintoAndarMockData.properties,
    searchQuery: String = "",
    onSearchQueryChange: (String) -> Unit = {},
    contractType: WgcQuintoAndarContractType = WgcQuintoAndarContractType.Rent,
    onContractTypeChange: (WgcQuintoAndarContractType) -> Unit = {},
    selectedNavItem: WgcQuintoAndarNavItem = WgcQuintoAndarNavItem.Explore,
    onNavItemSelect: (WgcQuintoAndarNavItem) -> Unit = {},
    onPropertyClick: (QuintoAndarPropertyModel) -> Unit = {},
    onFavoriteToggle: (String) -> Unit = {},
    onFilterClick: () -> Unit = {},
    onNotificationsClick: () -> Unit = {},
    topBarSlot: (@Composable () -> Unit)? = null,
    bottomBarSlot: (@Composable () -> Unit)? = null
) {
    var selectedFilterPet by remember { mutableStateOf(false) }
    var selectedFilterMetro by remember { mutableStateOf(false) }
    var selectedFilterBedrooms by remember { mutableStateOf(false) }
    var selectedFilterFurnished by remember { mutableStateOf(false) }

    val filteredProperties = properties.filter { prop ->
        val matchesSearch = searchQuery.isBlank() ||
                prop.neighborhood.contains(searchQuery, ignoreCase = true) ||
                prop.address.contains(searchQuery, ignoreCase = true) ||
                prop.title.contains(searchQuery, ignoreCase = true)
        val matchesPet = !selectedFilterPet || prop.petFriendly
        val matchesMetro = !selectedFilterMetro || prop.nearMetro
        val matchesBed = !selectedFilterBedrooms || prop.bedrooms >= 2
        val matchesFurnished = !selectedFilterFurnished || prop.isFurnished
        matchesSearch && matchesPet && matchesMetro && matchesBed && matchesFurnished
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            if (topBarSlot != null) {
                topBarSlot()
            } else {
                QuintoAndarHomeTopBar(onNotificationsClick = onNotificationsClick)
            }
        },
        bottomBar = {
            if (bottomBarSlot != null) {
                bottomBarSlot()
            } else {
                WgcQuintoAndarBottomNav(
                    selectedItem = selectedNavItem,
                    onItemSelected = onNavItemSelect,
                    visitsBadgeCount = 1
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
            // Seletor de Modalidade e Campo de Busca
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(WgcCoreDsColors.quintoAndarSurface))
                        .padding(WgcCoreDsSpacing.md16.dp)
                ) {
                    WgcQuintoAndarSearchBar(
                        contractType = contractType,
                        onContractTypeChange = onContractTypeChange,
                        query = searchQuery,
                        onQueryChange = onSearchQueryChange,
                        activeFilterCount = listOf(
                            selectedFilterPet,
                            selectedFilterMetro,
                            selectedFilterBedrooms,
                            selectedFilterFurnished
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
                        WgcQuintoAndarFilterChip(
                            label = "2+ quartos",
                            isSelected = selectedFilterBedrooms,
                            leadingIcon = Icons.Default.Bed,
                            onClick = { selectedFilterBedrooms = !selectedFilterBedrooms }
                        )
                    }
                    item {
                        WgcQuintoAndarFilterChip(
                            label = "Perto do metrô",
                            isSelected = selectedFilterMetro,
                            leadingIcon = Icons.Default.DirectionsSubway,
                            onClick = { selectedFilterMetro = !selectedFilterMetro }
                        )
                    }
                    item {
                        WgcQuintoAndarFilterChip(
                            label = "Aceita pet",
                            isSelected = selectedFilterPet,
                            leadingIcon = Icons.Default.Pets,
                            onClick = { selectedFilterPet = !selectedFilterPet }
                        )
                    }
                    item {
                        WgcQuintoAndarFilterChip(
                            label = "Mobiliado",
                            isSelected = selectedFilterFurnished,
                            leadingIcon = Icons.Default.Weekend,
                            onClick = { selectedFilterFurnished = !selectedFilterFurnished }
                        )
                    }
                }
            }

            // Banner Sem Fiador / Vantagens
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp))
                        .background(Color(WgcCoreDsColors.quintoAndarPrimaryLight))
                        .padding(WgcCoreDsSpacing.md16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(WgcCoreDsSize.s40.dp)
                                .clip(CircleShape)
                                .background(Color(WgcCoreDsColors.quintoAndarYellow)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.quintoAndarPrimary),
                                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Alugue sem fiador e sem caução",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = Color(WgcCoreDsColors.quintoAndarDark)
                            )
                            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                            Text(
                                text = "Aprovação de crédito rápida e 100% digital em minutos.",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(WgcCoreDsColors.quintoAndarSecondaryText)
                            )
                        }
                    }
                }
            }

            // Cabeçalho da Lista de Imóveis
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Imóveis recomendados (${filteredProperties.size})",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.quintoAndarDark)
                    )
                }
            }

            // Lista de Cards de Imóveis
            items(filteredProperties, key = { it.id }) { property ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp)
                ) {
                    WgcQuintoAndarPropertyCard(
                        title = property.title,
                        neighborhood = property.neighborhood,
                        address = property.address,
                        price = "${property.rentPrice} /mês",
                        totalPrice = property.totalPrice,
                        areaM2 = property.areaM2,
                        bedrooms = property.bedrooms,
                        bathrooms = property.bathrooms,
                        parkingSpots = property.parkingSpots,
                        badgeText = property.tags.firstOrNull(),
                        metroProximity = if (property.nearMetro) property.metroDistanceText else null,
                        isFavorite = property.isFavorite,
                        onFavoriteToggle = { onFavoriteToggle(property.id) },
                        onClick = { onPropertyClick(property) }
                    )
                }
            }
        }
    }
}

@Composable
private fun QuintoAndarHomeTopBar(
    onNotificationsClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(WgcCoreDsColors.quintoAndarSurface))
            .padding(
                horizontal = WgcCoreDsSpacing.md16.dp,
                vertical = WgcCoreDsSpacing.sm12.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Logo QuintoAndar
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(WgcCoreDsSize.s32.dp)
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                    .background(Color(WgcCoreDsColors.quintoAndarPrimary)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "5",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Black,
                    color = Color(WgcCoreDsColors.quintoAndarYellow)
                )
            }

            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))

            Column {
                Text(
                    text = "QuintoAndar",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.quintoAndarPrimary)
                )
                Text(
                    text = "Aluguel e Venda",
                    style = MaterialTheme.typography.labelSmall,
                    color = Color(WgcCoreDsColors.quintoAndarSecondaryText)
                )
            }
        }

        // Ícone de Notificações
        IconButton(
            onClick = onNotificationsClick,
            modifier = Modifier
                .size(WgcCoreDsSize.s40.dp)
                .clip(CircleShape)
                .background(Color(WgcCoreDsColors.quintoAndarBackground))
        ) {
            Icon(
                imageVector = Icons.Default.NotificationsNone,
                contentDescription = "Notificações",
                tint = Color(WgcCoreDsColors.quintoAndarDark),
                modifier = Modifier.size(WgcCoreDsSize.s22.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcQuintoAndarHomeTemplatePreview() {
    WgcQuintoAndarHomeTemplate()
}
