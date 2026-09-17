package br.com.wgc.ds_templates.screens.premiumgrocery.home

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.BakeryDining
import androidx.compose.material.icons.filled.CenterFocusWeak
import androidx.compose.material.icons.filled.Eco
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.LocalBar
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SetMeal
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcPdaClienteMaisLoyaltyCard
import br.com.wgc.design_system.components.cards.WgcPdaProductCard
import br.com.wgc.design_system.components.cards.WgcPdaSommelierWineCard
import br.com.wgc.design_system.components.navigation.WgcPdaBottomNav
import br.com.wgc.ds_templates.screens.premiumgrocery.model.PremiumGroceryMockData
import br.com.wgc.ds_templates.screens.premiumgrocery.model.PdaProductItem
import br.com.wgc.ds_templates.screens.premiumgrocery.model.PdaUserProfile
import br.com.wgc.ds_templates.screens.premiumgrocery.model.PdaWineItem

private data class PdaDepartmentCategory(val title: String, val icon: ImageVector, val color: Int)

/**
 * Template da Tela Principal do Supermercado Gourmet.
 *
 * Vitrine premium com seletor de loja física/delivery, busca com scanner de código de barras,
 * card VIP Cliente Mais, departamentos gourmet, festival de queijos & vinhos e curadoria sommelier.
 */
@Composable
fun WgcPdaHomeTemplate(
    modifier: Modifier = Modifier,
    userProfile: PdaUserProfile = PremiumGroceryMockData.defaultUser,
    featuredProducts: List<PdaProductItem> = PremiumGroceryMockData.gourmetProducts,
    sommelierPicks: List<PdaWineItem> = PremiumGroceryMockData.sommelierWines,
    selectedNavIndex: Int = 0,
    onNavSelect: (Int) -> Unit = {},
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
            // Header: Seletor de Loja & Notificações
            item {
                headerSlot?.invoke() ?: Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(WgcCoreDsColors.premiumGrocerySurface))
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.sm12.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "ENTREGAR EM",
                                color = Color(WgcCoreDsColors.premiumGroceryTextSecondary),
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                            ) {
                                Text(
                                    text = userProfile.selectedStore,
                                    color = Color(WgcCoreDsColors.premiumGroceryTextPrimary),
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.Bold
                                )
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowDown,
                                    contentDescription = "Trocar Loja",
                                    tint = Color(WgcCoreDsColors.premiumGroceryGreenDark),
                                    modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                                )
                            }
                        }

                        IconButton(
                            onClick = {},
                            modifier = Modifier.size(WgcCoreDsSize.s36.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Notifications,
                                contentDescription = "Notificações",
                                tint = Color(WgcCoreDsColors.premiumGroceryGreenDark),
                                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                    // Janela de Entrega Express
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                            .background(Color(WgcCoreDsColors.premiumGroceryGreenLight))
                            .padding(horizontal = WgcCoreDsSpacing.sm12.dp, vertical = WgcCoreDsSpacing.xs8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Timer,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.premiumGroceryGreenDark),
                            modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                        )
                        Text(
                            text = userProfile.deliveryWindow,
                            color = Color(WgcCoreDsColors.premiumGroceryGreenDark),
                            style = MaterialTheme.typography.bodySmall,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                    // Barra de Busca Sofisticada com Scanner de Código de Barras
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(WgcCoreDsSize.s48.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                            .background(Color(WgcCoreDsColors.premiumGroceryBackground))
                            .border(
                                width = WgcCoreDsSize.s1.dp,
                                color = Color(WgcCoreDsColors.premiumGroceryBorder),
                                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp)
                            )
                            .padding(horizontal = WgcCoreDsSpacing.sm12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.premiumGroceryTextSecondary),
                                modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                            )
                            Text(
                                text = "Buscar azeites, vinhos, queijos ou Taeq...",
                                color = Color(WgcCoreDsColors.premiumGroceryTextSecondary),
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                        ) {
                            IconButton(
                                onClick = onScanBarcodeClick,
                                modifier = Modifier.size(WgcCoreDsSize.s32.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.CenterFocusWeak,
                                    contentDescription = "Escanear Código de Barras",
                                    tint = Color(WgcCoreDsColors.premiumGroceryGreenDark),
                                    modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                                )
                            }
                            IconButton(
                                onClick = {},
                                modifier = Modifier.size(WgcCoreDsSize.s32.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Mic,
                                    contentDescription = "Busca por Voz",
                                    tint = Color(WgcCoreDsColors.premiumGroceryTextSecondary),
                                    modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                                )
                            }
                        }
                    }
                }
            }

            // Card VIP Cliente Mais Black/Gold
            item {
                Box(
                    modifier = Modifier.padding(
                        horizontal = WgcCoreDsSpacing.md16.dp,
                        vertical = WgcCoreDsSpacing.sm12.dp
                    )
                ) {
                    loyaltyCardSlot?.invoke() ?: WgcPdaClienteMaisLoyaltyCard(
                        clientName = userProfile.name,
                        cpfMasked = userProfile.cpfMasked,
                        tier = userProfile.tier,
                        stilloCoins = userProfile.stilloCoins,
                        monthlySavings = userProfile.monthlySavings,
                        onShowQrCode = onShowQrCodeClick
                    )
                }
            }

            // Departamentos Gourmet em Círculos
            item {
                Column(modifier = Modifier.padding(vertical = WgcCoreDsSpacing.xs8.dp)) {
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp),
                        contentPadding = androidx.compose.foundation.layout.PaddingValues(
                            horizontal = WgcCoreDsSpacing.md16.dp
                        )
                    ) {
                        items(departments) { dept ->
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.width(WgcCoreDsSize.s64.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(WgcCoreDsSize.s56.dp)
                                        .clip(CircleShape)
                                        .background(Color(WgcCoreDsColors.premiumGrocerySurface))
                                        .border(
                                            width = WgcCoreDsSize.s1.dp,
                                            color = Color(dept.color).copy(alpha = 0.4f),
                                            shape = CircleShape
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = dept.icon,
                                        contentDescription = dept.title,
                                        tint = Color(dept.color),
                                        modifier = Modifier.size(WgcCoreDsSize.s28.dp)
                                    )
                                }

                                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))

                                Text(
                                    text = dept.title,
                                    color = Color(WgcCoreDsColors.premiumGroceryTextPrimary),
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.Medium,
                                    maxLines = 1,
                                    overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                                )
                            }
                        }
                    }
                }
            }

            // Banner Festival de Queijos & Vinhos
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(WgcCoreDsColors.premiumGroceryWineRed)
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = WgcCoreDsElevation.level3.dp
                    )
                ) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                    .background(Color(WgcCoreDsColors.premiumGroceryGold))
                                    .padding(
                                        horizontal = WgcCoreDsSpacing.xs8.dp,
                                        vertical = WgcCoreDsSpacing.xxs4.dp
                                    )
                            ) {
                                Text(
                                    text = "FESTIVAL GOURMET",
                                    color = Color(WgcCoreDsColors.premiumGroceryTextPrimary),
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.Black
                                )
                            }

                            Text(
                                text = "Até 35% OFF",
                                color = Color(WgcCoreDsColors.premiumGroceryGoldLight),
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                        Text(
                            text = "Festival de Queijos Nobres & Vinhos Europeus",
                            color = Color.White,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Harmonizações selecionadas por nossos sommeliers com descontos exclusivos no app.",
                            color = Color.White.copy(alpha = 0.85f),
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }

            // Seção: Seleção do Sommelier
            item {
                Column(modifier = Modifier.padding(top = WgcCoreDsSpacing.md16.dp)) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = WgcCoreDsSpacing.md16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "ADEGA GOURMET SOMMELIER",
                                color = Color(WgcCoreDsColors.premiumGroceryWineRed),
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Black
                            )
                            Text(
                                text = "Curadoria dos Sommeliers",
                                color = Color(WgcCoreDsColors.premiumGroceryTextPrimary),
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp),
                            modifier = Modifier.clickable { onNavSelect(1) }
                        ) {
                            Text(
                                text = "Ver Adega",
                                color = Color(WgcCoreDsColors.premiumGroceryGreenDark),
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold
                            )
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.premiumGroceryGreenDark),
                                modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                    Column(
                        modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.md16.dp),
                        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                    ) {
                        sommelierPicks.take(2).forEach { wine ->
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

            // Seção: Produtos Gourmet & Taeq Orgânicos
            item {
                Column(modifier = Modifier.padding(top = WgcCoreDsSpacing.lg24.dp, bottom = WgcCoreDsSpacing.lg24.dp)) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = WgcCoreDsSpacing.md16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "EXCLUSIVOS & ORGÂNICOS",
                                color = Color(WgcCoreDsColors.premiumGroceryGreenDark),
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Black
                            )
                            Text(
                                text = "Ofertas Cliente Mais",
                                color = Color(WgcCoreDsColors.premiumGroceryTextPrimary),
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Text(
                            text = "Ver Todos",
                            color = Color(WgcCoreDsColors.premiumGroceryGreenDark),
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp),
                        contentPadding = androidx.compose.foundation.layout.PaddingValues(
                            horizontal = WgcCoreDsSpacing.md16.dp
                        )
                    ) {
                        items(featuredProducts) { product ->
                            WgcPdaProductCard(
                                title = product.title,
                                brandOrOrigin = product.brandOrOrigin,
                                unit = product.unit,
                                originalPrice = product.originalPrice,
                                clienteMaisPrice = product.clienteMaisPrice,
                                badgeText = product.badgeText,
                                isOrganic = product.isOrganic,
                                quantity = product.quantity,
                                isFavorite = product.isFavorite,
                                onQuantityChange = { qty -> onProductQuantityChange(product.id, qty) },
                                onFavoriteToggle = { onProductFavoriteToggle(product.id) }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(name = "PDA Home Template - Production", showBackground = true)
@Composable
private fun WgcPdaHomeTemplatePreview() {
    WgcPdaHomeTemplate()
}
