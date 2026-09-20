package br.com.wgc.design_system.templates.screens.premiumgrocery.adega

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalBar
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.filled.WineBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.unit.sp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsElevation
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcWineStoreCard
import br.com.wgc.design_system.components.navigation.WgcSupermarketBottomNav
import br.com.wgc.design_system.components.navigation.WgcSupermarketNavItem
import br.com.wgc.design_system.templates.screens.premiumgrocery.model.PremiumGroceryMockData
import br.com.wgc.design_system.templates.screens.premiumgrocery.model.PdaWineItem

@Composable
fun WgcPdaAdegaTemplate(
    modifier: Modifier = Modifier,
    wines: List<PdaWineItem> = PremiumGroceryMockData.sommelierWines,
    selectedNavItem: WgcSupermarketNavItem = WgcSupermarketNavItem.ADEGA,
    onNavItemClick: (WgcSupermarketNavItem) -> Unit = {},
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
            footerSlot?.invoke() ?: WgcSupermarketBottomNav(
                selectedItem = selectedNavItem,
                onItemSelected = onNavItemClick
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(bottom = WgcCoreDsSpacing.xl32.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            item {
                if (headerSlot != null) {
                    headerSlot()
                } else {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(WgcCoreDsColors.premiumGroceryWineRedDark))
                            .padding(WgcCoreDsSpacing.md16.dp)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
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
                                        imageVector = Icons.Default.WineBar,
                                        contentDescription = null,
                                        tint = Color(WgcCoreDsColors.premiumGroceryGold),
                                        modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                                    )
                                    Text(
                                        text = "ADEGA & SOMMELIER",
                                        color = Color(WgcCoreDsColors.premiumGroceryGold),
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Black,
                                        letterSpacing = 1.sp
                                    )
                                }
                                IconButton(onClick = {}) {
                                    Icon(
                                        imageVector = Icons.Default.Tune,
                                        contentDescription = "Filtros",
                                        tint = Color(WgcCoreDsColors.premiumGrocerySurface)
                                    )
                                }
                            }

                            OutlinedTextField(
                                value = "",
                                onValueChange = {},
                                modifier = Modifier.fillMaxWidth(),
                                placeholder = {
                                    Text(
                                        text = "Buscar por uva, país, safra ou vinícola...",
                                        fontSize = 12.sp
                                    )
                                },
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Search,
                                        contentDescription = "Buscar",
                                        tint = Color(WgcCoreDsColors.premiumGroceryTextSecondary),
                                        modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                                    )
                                },
                                shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedContainerColor = Color(WgcCoreDsColors.premiumGrocerySurface),
                                    unfocusedContainerColor = Color(WgcCoreDsColors.premiumGrocerySurface),
                                    focusedBorderColor = Color(WgcCoreDsColors.premiumGrocerySurface),
                                    unfocusedBorderColor = Color(WgcCoreDsColors.premiumGrocerySurface)
                                ),
                                singleLine = true,
                                readOnly = true
                            )
                        }
                    }
                }
            }

            // Filtros por Estilo
            item {
                Column(verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
                    Text(
                        text = "ESTILO DO VINHO",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.premiumGroceryTextPrimary),
                        modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.md16.dp)
                    )
                    LazyRow(
                        contentPadding = PaddingValues(horizontal = WgcCoreDsSpacing.md16.dp),
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                    ) {
                        items(wineTypes.size) { index ->
                            val isSelected = selectedTypeIndex == index
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                                    .background(
                                        if (isSelected) Color(WgcCoreDsColors.premiumGroceryWineRed) else Color(WgcCoreDsColors.premiumGrocerySurface)
                                    )
                                    .border(
                                        width = WgcCoreDsSize.s1.dp,
                                        color = if (isSelected) Color(WgcCoreDsColors.premiumGroceryWineRed) else Color(WgcCoreDsColors.premiumGroceryBorder),
                                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
                                    )
                                    .clickable { selectedTypeIndex = index }
                                    .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp)
                            ) {
                                Text(
                                    text = wineTypes[index],
                                    color = if (isSelected) Color(WgcCoreDsColors.premiumGrocerySurface) else Color(WgcCoreDsColors.premiumGroceryTextPrimary),
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }

            // Banner Harmonização
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.premiumGroceryGoldLight)),
                    border = androidx.compose.foundation.BorderStroke(
                        WgcCoreDsSize.s1.dp,
                        Color(WgcCoreDsColors.premiumGroceryGold).copy(alpha = 0.5f)
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp),
                        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                    ) {
                        Text(
                            text = "🍷 O que você vai comer hoje?",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.premiumGroceryGoldDark)
                        )
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                        ) {
                            items(pairings.size) { index ->
                                val isSelected = selectedPairingIndex == index
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                                        .background(if (isSelected) Color(WgcCoreDsColors.premiumGroceryGold) else Color(WgcCoreDsColors.premiumGrocerySurface))
                                        .border(
                                            width = WgcCoreDsSize.s1.dp,
                                            color = if (isSelected) Color(WgcCoreDsColors.premiumGroceryGold) else Color(WgcCoreDsColors.premiumGroceryBorder),
                                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
                                        )
                                        .clickable { selectedPairingIndex = index }
                                        .padding(horizontal = WgcCoreDsSpacing.sm12.dp, vertical = WgcCoreDsSpacing.xs8.dp)
                                ) {
                                    Text(
                                        text = pairings[index],
                                        color = if (isSelected) Color(WgcCoreDsColors.premiumGrocerySurface) else Color(WgcCoreDsColors.premiumGroceryTextPrimary),
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
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
                        WgcWineStoreCard(
                            wineName = wine.wineName,
                            winery = wine.countryOrigin,
                            countryAndRegion = wine.countryOrigin,
                            year = 2021,
                            rating = wine.rating,
                            originalPrice = wine.price,
                            clienteMaisPrice = wine.clienteMaisPrice,
                            grape = wine.grape,
                            sommelierNote = wine.pairingTip,
                            quantityInCart = wine.quantity,
                            onQuantityChange = { qty -> onWineQuantityChange(wine.id, qty) }
                        )
                    }
                }
            }
        }
    }
}

@Preview(name = "Wine Store Adega Template", showBackground = true)
@Composable
private fun WgcPdaAdegaTemplatePreview() {
    WgcPdaAdegaTemplate()
}
