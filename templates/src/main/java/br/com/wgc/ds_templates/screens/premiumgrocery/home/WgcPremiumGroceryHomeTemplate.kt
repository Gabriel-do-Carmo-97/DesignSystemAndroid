package br.com.wgc.ds_templates.screens.premiumgrocery.home

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
import androidx.compose.material.icons.filled.BakeryDining
import androidx.compose.material.icons.filled.Eco
import androidx.compose.material.icons.filled.LocalBar
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SetMeal
import androidx.compose.material.icons.filled.Storefront
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcSupermarketLoyaltyCard
import br.com.wgc.design_system.components.cards.WgcSupermarketProductCard
import br.com.wgc.design_system.components.cards.WgcWineStoreCard
import br.com.wgc.design_system.components.navigation.WgcSupermarketBottomNav
import br.com.wgc.design_system.components.navigation.WgcSupermarketNavItem
import br.com.wgc.ds_templates.screens.premiumgrocery.model.PremiumGroceryMockData
import br.com.wgc.ds_templates.screens.premiumgrocery.model.PdaProductItem
import br.com.wgc.ds_templates.screens.premiumgrocery.model.PdaUserProfile
import br.com.wgc.ds_templates.screens.premiumgrocery.model.PdaWineItem

private data class PdaDepartmentCategory(val title: String, val icon: ImageVector, val color: Int)

@Composable
fun WgcPdaHomeTemplate(
    modifier: Modifier = Modifier,
    userProfile: PdaUserProfile = PremiumGroceryMockData.defaultUser,
    featuredProducts: List<PdaProductItem> = PremiumGroceryMockData.gourmetProducts,
    sommelierPicks: List<PdaWineItem> = PremiumGroceryMockData.sommelierWines,
    selectedNavItem: WgcSupermarketNavItem = WgcSupermarketNavItem.HOME,
    onNavItemClick: (WgcSupermarketNavItem) -> Unit = {},
    onProductQuantityChange: (String, Int) -> Unit = { _, _ -> },
    onWineQuantityChange: (String, Int) -> Unit = { _, _ -> },
    onProductFavoriteToggle: (String) -> Unit = {},
    onScanBarcodeClick: () -> Unit = {},
    onShowQrCodeClick: () -> Unit = {},
    headerSlot: (@Composable () -> Unit)? = null,
    loyaltyCardSlot: (@Composable () -> Unit)? = null,
    footerSlot: (@Composable () -> Unit)? = null
) {
    val departments = listOf(
        PdaDepartmentCategory("Adega", Icons.Default.LocalBar, WgcCoreDsColors.premiumGroceryWineRed),
        PdaDepartmentCategory("Queijos Nobres", Icons.Default.Restaurant, WgcCoreDsColors.premiumGroceryGoldDark),
        PdaDepartmentCategory("Orgânicos", Icons.Default.Eco, WgcCoreDsColors.premiumGroceryGreen),
        PdaDepartmentCategory("Padaria Artesanal", Icons.Default.BakeryDining, WgcCoreDsColors.premiumGroceryOrangeOrganic),
        PdaDepartmentCategory("Peixaria Fresca", Icons.Default.SetMeal, WgcCoreDsColors.premiumGroceryGreenDark)
    )

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
                            .background(Color(WgcCoreDsColors.premiumGroceryGreenDark))
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
                                        imageVector = Icons.Default.Storefront,
                                        contentDescription = null,
                                        tint = Color(WgcCoreDsColors.premiumGroceryGold),
                                        modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                                    )
                                    Column {
                                        Text(
                                            text = "SUPERMERCADO • LOJA SELECIONADA",
                                            color = Color(WgcCoreDsColors.premiumGroceryGold),
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                        Text(
                                            text = userProfile.selectedStore,
                                            color = Color(WgcCoreDsColors.premiumGrocerySurface),
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                }

                                IconButton(onClick = onScanBarcodeClick) {
                                    Icon(
                                        imageVector = Icons.Default.QrCodeScanner,
                                        contentDescription = "Scanner",
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
                                        text = "Buscar vinhos, queijos, orgânicos, carnes...",
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

            // Cartão Fidelidade Cliente Mais VIP
            item {
                Box(modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.md16.dp)) {
                    if (loyaltyCardSlot != null) {
                        loyaltyCardSlot()
                    } else {
                        WgcSupermarketLoyaltyCard(
                            clientName = userProfile.name,
                            cpfMasked = userProfile.cpfMasked,
                            tier = userProfile.tier,
                            coinsBalance = userProfile.stilloCoins,
                            monthlySavings = userProfile.monthlySavings,
                            onShowQrCode = onShowQrCodeClick
                        )
                    }
                }
            }

            // Departamentos Gourmet
            item {
                Column(verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
                    Text(
                        text = "DEPARTAMENTOS GOURMET",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.premiumGroceryTextPrimary),
                        modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.md16.dp)
                    )
                    LazyRow(
                        contentPadding = PaddingValues(horizontal = WgcCoreDsSpacing.md16.dp),
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                    ) {
                        items(departments) { dept ->
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp),
                                modifier = Modifier.clickable { }
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(WgcCoreDsSize.s56.dp)
                                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp))
                                        .background(Color(dept.color).copy(alpha = 0.15f))
                                        .border(
                                            width = WgcCoreDsSize.s1.dp,
                                            color = Color(dept.color).copy(alpha = 0.4f),
                                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp)
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = dept.icon,
                                        contentDescription = dept.title,
                                        tint = Color(dept.color),
                                        modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                                    )
                                }
                                Text(
                                    text = dept.title,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = Color(WgcCoreDsColors.premiumGroceryTextPrimary)
                                )
                            }
                        }
                    }
                }
            }

            // Produtos Gourmet em Destaque
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "ESPECIAIS DA SEMANA",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.premiumGroceryTextPrimary)
                    )
                    Text(
                        text = "Ver todos",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.premiumGroceryGreen),
                        modifier = Modifier.clickable { }
                    )
                }
            }

            items(featuredProducts, key = { it.id }) { product ->
                Box(modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.md16.dp)) {
                    WgcSupermarketProductCard(
                        title = product.title,
                        brandOrOrigin = product.brandOrOrigin,
                        unit = product.unit,
                        originalPrice = product.originalPrice,
                        clienteMaisPrice = product.clienteMaisPrice,
                        discountBadge = product.badgeText,
                        isOrganic = product.isOrganic,
                        isFavorite = product.isFavorite,
                        quantityInCart = product.quantity,
                        onQuantityChange = { qty -> onProductQuantityChange(product.id, qty) },
                        onFavoriteToggle = { onProductFavoriteToggle(product.id) }
                    )
                }
            }

            // Seleção Sommelier
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp),
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
                            tint = Color(WgcCoreDsColors.premiumGroceryWineRed),
                            modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                        )
                        Text(
                            text = "CURADORIA SOMMELIER",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.premiumGroceryTextPrimary)
                        )
                    }
                    Text(
                        text = "Explorar Adega",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.premiumGroceryWineRed),
                        modifier = Modifier.clickable { }
                    )
                }
            }

            items(sommelierPicks, key = { it.id }) { wine ->
                Box(modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.md16.dp)) {
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

@Preview(name = "Supermarket Home Template", showBackground = true)
@Composable
private fun WgcPdaHomeTemplatePreview() {
    WgcPdaHomeTemplate()
}
