package br.com.wgc.ds_templates.screens.quintoandar.favorites

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import br.com.wgc.design_system.components.cards.WgcQuintoAndarPropertyCard
import br.com.wgc.design_system.components.chip.WgcQuintoAndarFilterChip
import br.com.wgc.design_system.components.navigation.WgcQuintoAndarBottomNav
import br.com.wgc.design_system.components.navigation.WgcQuintoAndarNavItem
import br.com.wgc.ds_templates.screens.quintoandar.model.QuintoAndarMockData
import br.com.wgc.ds_templates.screens.quintoandar.model.QuintoAndarPropertyModel

enum class FavoritesFilter {
    All,
    PriceDropped
}

/**
 * Template de Imóveis Favoritos do QuintoAndar:
 * - Listagem de imóveis favoritados com cards completos
 * - Filtro rápido de imóveis cujo preço baixou
 * - Estado vazio amigável com CTA de busca
 */
@Composable
fun WgcQuintoAndarFavoritesTemplate(
    modifier: Modifier = Modifier,
    favoriteProperties: List<QuintoAndarPropertyModel> = QuintoAndarMockData.properties.filter { it.isFavorite },
    onPropertyClick: (QuintoAndarPropertyModel) -> Unit = {},
    onFavoriteToggle: (String) -> Unit = {},
    onExploreClick: () -> Unit = {},
    selectedNavItem: WgcQuintoAndarNavItem = WgcQuintoAndarNavItem.Favorites,
    onNavItemSelect: (WgcQuintoAndarNavItem) -> Unit = {},
    topBarSlot: (@Composable () -> Unit)? = null,
    bottomBarSlot: (@Composable () -> Unit)? = null
) {
    var filter by remember { mutableStateOf(FavoritesFilter.All) }

    val displayedList = when (filter) {
        FavoritesFilter.All -> favoriteProperties
        FavoritesFilter.PriceDropped -> favoriteProperties.filter { it.tags.contains("Preço Baixou") }
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color(WgcCoreDsColors.quintoAndarBackground),
        topBar = {
            if (topBarSlot != null) {
                topBarSlot()
            } else {
                FavoritesTopBar(count = favoriteProperties.size)
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
        if (favoriteProperties.isEmpty()) {
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
                // Filtros de favoritos
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                    ) {
                        WgcQuintoAndarFilterChip(
                            label = "Todos (${favoriteProperties.size})",
                            isSelected = filter == FavoritesFilter.All,
                            onClick = { filter = FavoritesFilter.All }
                        )
                        WgcQuintoAndarFilterChip(
                            label = "Preço baixou",
                            isSelected = filter == FavoritesFilter.PriceDropped,
                            onClick = { filter = FavoritesFilter.PriceDropped }
                        )
                    }
                }

                // Lista de imóveis favoritados
                items(displayedList, key = { it.id }) { property ->
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
                        isFavorite = true,
                        onFavoriteToggle = { onFavoriteToggle(property.id) },
                        onClick = { onPropertyClick(property) }
                    )
                }
            }
        }
    }
}

@Composable
private fun FavoritesTopBar(count: Int) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color(WgcCoreDsColors.quintoAndarSurface),
        shadowElevation = WgcCoreDsSpacing.xxs4.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = WgcCoreDsSpacing.md16.dp,
                    vertical = WgcCoreDsSpacing.md16.dp
                )
        ) {
            Text(
                text = "Meus Favoritos",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.quintoAndarDark)
            )
            Text(
                text = "$count imóveis salvos para acompanhar",
                style = MaterialTheme.typography.bodySmall,
                color = Color(WgcCoreDsColors.quintoAndarSecondaryText)
            )
        }
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
                    .background(Color(WgcCoreDsColors.quintoAndarPrimaryLight)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = null,
                    tint = Color(WgcCoreDsColors.quintoAndarCoral),
                    modifier = Modifier.size(WgcCoreDsSize.s40.dp)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            Text(
                text = "Você ainda não favoritou nenhum imóvel",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.quintoAndarDark)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            Text(
                text = "Toque no ícone de coração nos imóveis que gostar para salvá-los e receber alertas de desconto.",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(WgcCoreDsColors.quintoAndarSecondaryText)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            Button(
                onClick = onExploreClick,
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(WgcCoreDsColors.quintoAndarYellow),
                    contentColor = Color(WgcCoreDsColors.quintoAndarDark)
                )
            ) {
                Text(
                    text = "Explorar Imóveis",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcQuintoAndarFavoritesTemplatePreview() {
    WgcQuintoAndarFavoritesTemplate()
}
