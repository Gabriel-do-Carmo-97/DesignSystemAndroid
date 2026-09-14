package br.com.wgc.ds_templates.screens.wellhub.explore

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcWellhubGymCard
import br.com.wgc.design_system.components.navigation.WgcWellhubBottomNav
import br.com.wgc.design_system.components.navigation.WgcWellhubNavItem
import br.com.wgc.ds_templates.screens.wellhub.model.WellhubGym
import br.com.wgc.ds_templates.screens.wellhub.model.WellhubMockData

/**
 * Template de Exploração e Busca de Academias Wellhub (Gympass).
 *
 * Permite filtrar por modalidade, proximidade, plano exigido e visualizar lista de parceiros.
 *
 * 100% tokenizado com WgcCoreDs e State Hoisting.
 */
@Composable
fun WgcWellhubExploreGymsTemplate(
    gyms: List<WellhubGym>,
    selectedFilterIndex: Int,
    onSelectFilter: (Int) -> Unit,
    modifier: Modifier = Modifier,
    onBackClick: (() -> Unit)? = null,
    onSelectGym: ((WellhubGym) -> Unit)? = null,
    onCheckInGym: ((WellhubGym) -> Unit)? = null,
    selectedNavItem: WgcWellhubNavItem = WgcWellhubNavItem.EXPLORE,
    onNavItemClick: (WgcWellhubNavItem) -> Unit = {},
    slotHeader: (@Composable () -> Unit)? = null,
    slotBottomNav: (@Composable () -> Unit)? = null
) {
    val filterOptions = listOf("Todos", "Meu Plano (Gold)", "Musculação", "Natação", "Crossfit", "24 Horas", "Pilates")

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color(WgcCoreDsColors.wellhubCreamBg),
        bottomBar = {
            if (slotBottomNav != null) {
                slotBottomNav()
            } else {
                WgcWellhubBottomNav(
                    selectedItem = selectedNavItem,
                    onItemSelected = onNavItemClick
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            // Header
            item {
                if (slotHeader != null) {
                    slotHeader()
                } else {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = WgcCoreDsSpacing.md16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                    ) {
                        if (onBackClick != null) {
                            IconButton(onClick = onBackClick) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Voltar",
                                    tint = Color(WgcCoreDsColors.wellhubDark),
                                    modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                                )
                            }
                        }
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "EXPLORAR REDE",
                                color = Color(WgcCoreDsColors.wellhubCoral),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Black,
                                letterSpacing = 1.sp
                            )
                            Text(
                                text = "Academias & Estúdios",
                                color = Color(WgcCoreDsColors.wellhubDark),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        // Botão de visualização em mapa
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                                .background(Color(WgcCoreDsColors.wellhubForestLight))
                                .clickable { }
                                .padding(horizontal = WgcCoreDsSpacing.sm12.dp, vertical = WgcCoreDsSpacing.xs8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Map,
                                    contentDescription = null,
                                    tint = Color(WgcCoreDsColors.wellhubForest),
                                    modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                                )
                                Text(
                                    text = "Mapa",
                                    color = Color(WgcCoreDsColors.wellhubForest),
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }

            // Barra de busca
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.wellhubSurface)),
                    border = BorderStroke(WgcCoreDsSize.s1.dp, Color(WgcCoreDsColors.wellhubBorder))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.sm12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.wellhubSecondaryText),
                            modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                        )
                        Text(
                            text = "Buscar por nome, bairro ou modalidade...",
                            color = Color(WgcCoreDsColors.wellhubSecondaryText),
                            fontSize = 13.sp,
                            modifier = Modifier.weight(1f)
                        )
                        Icon(
                            imageVector = Icons.Default.FilterList,
                            contentDescription = "Filtros",
                            tint = Color(WgcCoreDsColors.wellhubCoral),
                            modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                        )
                    }
                }
            }

            // Chips de Filtro
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    itemsIndexed(filterOptions) { index, option ->
                        val isSelected = index == selectedFilterIndex
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                                .background(
                                    if (isSelected) Color(WgcCoreDsColors.wellhubForest)
                                    else Color(WgcCoreDsColors.wellhubSurface)
                                )
                                .border(
                                    BorderStroke(
                                        WgcCoreDsSize.s1.dp,
                                        if (isSelected) Color(WgcCoreDsColors.wellhubForest)
                                        else Color(WgcCoreDsColors.wellhubBorder)
                                    ),
                                    RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
                                )
                                .clickable { onSelectFilter(index) }
                                .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp)
                        ) {
                            Text(
                                text = option,
                                color = if (isSelected) Color.White else Color(WgcCoreDsColors.wellhubDark),
                                fontSize = 12.sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                            )
                        }
                    }
                }
            }

            // Contagem de resultados
            item {
                Text(
                    text = "${gyms.size} academias encontradas na região",
                    color = Color(WgcCoreDsColors.wellhubSecondaryText),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            // Lista de Academias
            items(gyms, key = { it.id }) { gym ->
                WgcWellhubGymCard(
                    name = gym.name,
                    category = gym.category,
                    address = gym.address,
                    distance = gym.distance,
                    rating = gym.rating,
                    reviewsCount = gym.reviewsCount,
                    requiredTier = gym.requiredTier,
                    isIncludedInUserPlan = true,
                    onClick = { onSelectGym?.invoke(gym) },
                    onCheckInClick = { onCheckInGym?.invoke(gym) }
                )
            }

            item {
                Box(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))
            }
        }
    }
}

@Preview(name = "Wellhub Explore Gyms - Preview")
@Composable
fun WgcWellhubExploreGymsTemplatePreview() {
    WgcWellhubExploreGymsTemplate(
        gyms = WellhubMockData.mockGyms,
        selectedFilterIndex = 0,
        onSelectFilter = {}
    )
}
