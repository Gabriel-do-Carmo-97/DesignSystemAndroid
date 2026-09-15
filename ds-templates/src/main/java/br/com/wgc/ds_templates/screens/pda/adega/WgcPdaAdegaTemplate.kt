package br.com.wgc.ds_templates.screens.pda.adega

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AcUnit
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.LocalBar
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Verified
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
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcPdaSommelierWineCard
import br.com.wgc.design_system.components.navigation.WgcPdaBottomNav
import br.com.wgc.ds_templates.screens.pda.model.PdaMockData
import br.com.wgc.ds_templates.screens.pda.model.PdaWineItem

/**
 * Template da Tela "Adega Pão de Açúcar / Sommelier".
 *
 * Apresenta curadoria profissional de vinhos finos, buscador por harmonização gastronômica
 * ("O que você vai comer hoje?"), filtros por estilo (Tintos, Brancos, Espumantes) e garantia climatizada.
 */
@Composable
fun WgcPdaAdegaTemplate(
    modifier: Modifier = Modifier,
    wines: List<PdaWineItem> = PdaMockData.sommelierWines,
    selectedNavIndex: Int = 1,
    onNavSelect: (Int) -> Unit = {},
    onWineQuantityChange: (String, Int) -> Unit = { _, _ -> },
    headerSlot: (@Composable () -> Unit)? = null,
    footerSlot: (@Composable () -> Unit)? = null
) {
    val wineTypes = listOf("Todos", "Tintos Encorpados", "Brancos & Frescos", "Espumantes", "Rosés", "Orgânicos")
    val pairings = listOf("🥩 Carnes Nobres", "🧀 Queijos & Frios", "🐟 Frutos do Mar", "🍝 Massas & Risotos", "🍫 Sobremesas")

    var selectedTypeIndex by remember { mutableStateOf(0) }
    var selectedPairingIndex by remember { mutableStateOf(0) }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            footerSlot?.invoke() ?: WgcPdaBottomNav(
                selectedItem = selectedNavIndex,
                onItemSelected = onNavSelect
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Header Adega Sofisticado
            item {
                headerSlot?.invoke() ?: Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(WgcCoreDsColors.pdaWineRed))
                        .padding(WgcCoreDsSpacing.md16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.LocalBar,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.pdaGold),
                                modifier = Modifier.size(WgcCoreDsSize.s28.dp)
                            )
                            Column {
                                Text(
                                    text = "ADEGA PÃO DE AÇÚCAR",
                                    color = Color(WgcCoreDsColors.pdaGold),
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.Black
                                )
                                Text(
                                    text = "Curadoria & Sommelier",
                                    color = Color.White,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }

                        IconButton(
                            onClick = {},
                            modifier = Modifier.size(WgcCoreDsSize.s36.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.FilterList,
                                contentDescription = "Filtrar",
                                tint = Color.White,
                                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                    Text(
                        text = "Mais de 1.200 rótulos do mundo inteiro selecionados por Carlos Cabral e equipe de sommeliers PDA.",
                        color = Color.White.copy(alpha = 0.9f),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }

            // Harmonização Gastronômica: "O que vai servir hoje?"
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = WgcCoreDsSpacing.md16.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = WgcCoreDsSpacing.md16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.RestaurantMenu,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.pdaWineRed),
                            modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                        )
                        Text(
                            text = "O QUE VAI SERVIR HOJE? (HARMONIZAÇÃO)",
                            color = Color(WgcCoreDsColors.pdaWineRed),
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp),
                        contentPadding = androidx.compose.foundation.layout.PaddingValues(
                            horizontal = WgcCoreDsSpacing.md16.dp
                        )
                    ) {
                        items(pairings.size) { idx ->
                            val isSelected = selectedPairingIndex == idx
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                                    .background(
                                        if (isSelected) Color(WgcCoreDsColors.pdaWineRed)
                                        else Color(WgcCoreDsColors.pdaSurface)
                                    )
                                    .border(
                                        width = WgcCoreDsSize.s1.dp,
                                        color = if (isSelected) Color(WgcCoreDsColors.pdaWineRed)
                                        else Color(WgcCoreDsColors.pdaBorder),
                                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp)
                                    )
                                    .clickable { selectedPairingIndex = idx }
                                    .padding(
                                        horizontal = WgcCoreDsSpacing.sm12.dp,
                                        vertical = WgcCoreDsSpacing.xs8.dp
                                    )
                            ) {
                                Text(
                                    text = pairings[idx],
                                    color = if (isSelected) Color.White else Color(WgcCoreDsColors.pdaTextPrimary),
                                    style = MaterialTheme.typography.bodySmall,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                                )
                            }
                        }
                    }
                }
            }

            // Tipos de Vinho
            item {
                Column(modifier = Modifier.padding(top = WgcCoreDsSpacing.sm12.dp)) {
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp),
                        contentPadding = androidx.compose.foundation.layout.PaddingValues(
                            horizontal = WgcCoreDsSpacing.md16.dp
                        )
                    ) {
                        items(wineTypes.size) { idx ->
                            val isSelected = selectedTypeIndex == idx
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                                    .background(
                                        if (isSelected) Color(WgcCoreDsColors.pdaGoldLight)
                                        else Color(WgcCoreDsColors.pdaSurface)
                                    )
                                    .border(
                                        width = WgcCoreDsSize.s1.dp,
                                        color = if (isSelected) Color(WgcCoreDsColors.pdaGold)
                                        else Color(WgcCoreDsColors.pdaBorder),
                                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
                                    )
                                    .clickable { selectedTypeIndex = idx }
                                    .padding(
                                        horizontal = WgcCoreDsSpacing.sm12.dp,
                                        vertical = WgcCoreDsSpacing.xs8.dp
                                    )
                            ) {
                                Text(
                                    text = wineTypes[idx],
                                    color = if (isSelected) Color(WgcCoreDsColors.pdaGoldDark)
                                    else Color(WgcCoreDsColors.pdaTextSecondary),
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                                )
                            }
                        }
                    }
                }
            }

            // Selo de Garantia de Transporte Climatizado
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.sm12.dp),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(WgcCoreDsColors.pdaSurface)
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = WgcCoreDsElevation.level1.dp
                    ),
                    border = androidx.compose.foundation.BorderStroke(
                        width = WgcCoreDsSize.s1.dp,
                        color = Color(WgcCoreDsColors.pdaBorder)
                    )
                ) {
                    Row(
                        modifier = Modifier.padding(WgcCoreDsSpacing.sm12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(WgcCoreDsSize.s40.dp)
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                .background(Color(WgcCoreDsColors.pdaGreenLight)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.AcUnit,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.pdaGreenDark),
                                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                            )
                        }

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Garantia de Transporte Climatizado",
                                color = Color(WgcCoreDsColors.pdaGreenDark),
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Seus vinhos e espumantes são entregues em embalagens térmicas protegidas da luz e do calor.",
                                color = Color(WgcCoreDsColors.pdaTextSecondary),
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }
            }

            // Lista de Rótulos Sommelier
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                ) {
                    wines.forEach { wine ->
                        WgcPdaSommelierWineCard(
                            wineName = wine.wineName,
                            countryOrigin = wine.countryOrigin,
                            grape = wine.grape,
                            vintage = wine.vintage,
                            rating = wine.rating,
                            sommelierPoints = wine.sommelierPoints,
                            pairingTip = wine.pairingTip,
                            servingTemp = wine.servingTemp,
                            price = wine.price,
                            clienteMaisPrice = wine.clienteMaisPrice,
                            quantity = wine.quantity,
                            onQuantityChange = { qty -> onWineQuantityChange(wine.id, qty) }
                        )
                    }
                }
            }
        }
    }
}

@Preview(name = "PDA Adega Template", showBackground = true)
@Composable
private fun WgcPdaAdegaTemplatePreview() {
    WgcPdaAdegaTemplate()
}
