package br.com.wgc.design_system.templates.screens.propertyclassifieds.favorites

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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DeleteOutline
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsElevation
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcPropertyClassifiedsCard
import br.com.wgc.design_system.templates.screens.propertyclassifieds.model.PropertyClassifiedsMockData
import br.com.wgc.design_system.templates.screens.propertyclassifieds.model.ZapPropertyModel
import br.com.wgc.design_system.templates.screens.propertyclassifieds.model.ZapSearchAlertModel

/**
 * Template da Tela de Favoritos e Alertas de Busca do Zap Imóveis.
 */
@Composable
fun WgcZapFavoritesTemplate(
    favoriteProperties: List<ZapPropertyModel> = PropertyClassifiedsMockData.sampleProperties.filter { it.isFavorite },
    searchAlerts: List<ZapSearchAlertModel> = PropertyClassifiedsMockData.sampleSearchAlerts,
    onPropertyClick: (ZapPropertyModel) -> Unit = {},
    onRemoveFavorite: (ZapPropertyModel) -> Unit = {},
    onAlertToggle: (ZapSearchAlertModel, Boolean) -> Unit = { _, _ -> },
    onDeleteAlert: (ZapSearchAlertModel) -> Unit = {},
    modifier: Modifier = Modifier
) {
    var selectedTab by remember { mutableIntStateOf(0) } // 0: Imóveis, 1: Alertas

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(WgcCoreDsColors.propertyClassifiedsSurface))
                    .padding(WgcCoreDsSpacing.md16.dp)
            ) {
                Text(
                    text = "Favoritos & Alertas",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.propertyClassifiedsDark)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                // Switcher em Pílula
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                        .background(Color(WgcCoreDsColors.propertyClassifiedsBackground))
                        .padding(WgcCoreDsSpacing.xxs4.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                            .background(
                                if (selectedTab == 0) Color(WgcCoreDsColors.propertyClassifiedsPrimary) else Color.Transparent
                            )
                            .clickable { selectedTab = 0 }
                            .padding(vertical = WgcCoreDsSpacing.xs8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Imóveis Salvos (${favoriteProperties.size})",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = if (selectedTab == 0) FontWeight.Bold else FontWeight.Medium,
                            color = if (selectedTab == 0) Color.White else Color(WgcCoreDsColors.propertyClassifiedsSecondaryText)
                        )
                    }

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                            .background(
                                if (selectedTab == 1) Color(WgcCoreDsColors.propertyClassifiedsPrimary) else Color.Transparent
                            )
                            .clickable { selectedTab = 1 }
                            .padding(vertical = WgcCoreDsSpacing.xs8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Alertas de Busca (${searchAlerts.size})",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = if (selectedTab == 1) FontWeight.Bold else FontWeight.Medium,
                            color = if (selectedTab == 1) Color.White else Color(WgcCoreDsColors.propertyClassifiedsSecondaryText)
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        if (selectedTab == 0) {
            // Aba 0: Imóveis Salvos
            if (favoriteProperties.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.propertyClassifiedsSecondaryText),
                            modifier = Modifier.size(WgcCoreDsSize.s48.dp)
                        )
                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))
                        Text(
                            text = "Nenhum imóvel favoritado ainda",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.propertyClassifiedsDark)
                        )
                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                        Text(
                            text = "Toque no coração dos anúncios para salvar seus imóveis prediletos",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color(WgcCoreDsColors.propertyClassifiedsSecondaryText)
                        )
                    }
                }
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentPadding = PaddingValues(
                        horizontal = WgcCoreDsSpacing.md16.dp,
                        vertical = WgcCoreDsSpacing.md16.dp
                    ),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
                ) {
                    items(favoriteProperties) { prop ->
                        WgcPropertyClassifiedsCard(
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
                            isFavorite = true,
                            onCardClick = { onPropertyClick(prop) },
                            onFavoriteClick = { onRemoveFavorite(prop) }
                        )
                    }
                }
            }
        } else {
            // Aba 1: Alertas de Busca
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentPadding = PaddingValues(
                    horizontal = WgcCoreDsSpacing.md16.dp,
                    vertical = WgcCoreDsSpacing.md16.dp
                ),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
            ) {
                items(searchAlerts) { alert ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.propertyClassifiedsSurface)),
                        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
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
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(WgcCoreDsSize.s40.dp)
                                            .clip(CircleShape)
                                            .background(Color(WgcCoreDsColors.propertyClassifiedsPrimaryLight)),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.NotificationsActive,
                                            contentDescription = null,
                                            tint = Color(WgcCoreDsColors.propertyClassifiedsPrimary),
                                            modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                                        )
                                    }

                                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))

                                    Column {
                                        Text(
                                            text = alert.title,
                                            style = MaterialTheme.typography.titleSmall,
                                            fontWeight = FontWeight.Bold,
                                            color = Color(WgcCoreDsColors.propertyClassifiedsDark)
                                        )
                                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxxs2.dp))
                                        Text(
                                            text = alert.criteria,
                                            style = MaterialTheme.typography.bodySmall,
                                            color = Color(WgcCoreDsColors.propertyClassifiedsSecondaryText)
                                        )
                                    }
                                }

                                IconButton(onClick = { onDeleteAlert(alert) }) {
                                    Icon(
                                        imageVector = Icons.Default.DeleteOutline,
                                        contentDescription = "Excluir alerta",
                                        tint = Color(WgcCoreDsColors.propertyClassifiedsSecondaryText),
                                        modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                    .background(Color(WgcCoreDsColors.propertyClassifiedsBackground))
                                    .padding(
                                        horizontal = WgcCoreDsSpacing.sm12.dp,
                                        vertical = WgcCoreDsSpacing.xs8.dp
                                    ),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "${alert.newPropertiesCount} novos imóveis nesta semana",
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(WgcCoreDsColors.propertyClassifiedsPrimary)
                                )

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        text = "Notificações",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = Color(WgcCoreDsColors.propertyClassifiedsSecondaryText)
                                    )
                                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                                    Switch(
                                        checked = alert.notificationsEnabled,
                                        onCheckedChange = { onAlertToggle(alert, it) },
                                        colors = SwitchDefaults.colors(
                                            checkedThumbColor = Color.White,
                                            checkedTrackColor = Color(WgcCoreDsColors.propertyClassifiedsOrange)
                                        )
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(name = "WgcZapFavoritesTemplate - Default", showBackground = true)
@Composable
private fun WgcZapFavoritesTemplatePreview() {
    MaterialTheme {
        WgcZapFavoritesTemplate()
    }
}
