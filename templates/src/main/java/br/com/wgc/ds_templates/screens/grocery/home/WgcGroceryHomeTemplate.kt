package br.com.wgc.ds_templates.screens.grocery.home

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
import androidx.compose.material.icons.filled.CenterFocusWeak
import androidx.compose.material.icons.filled.CleaningServices
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.LocalGasStation
import androidx.compose.material.icons.filled.LocalPharmacy
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.Tv
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
import br.com.wgc.design_system.components.cards.WgcGroceryLoyaltyCard
import br.com.wgc.design_system.components.cards.WgcGroceryNutriScoreCard
import br.com.wgc.design_system.components.cards.WgcGroceryProductCard
import br.com.wgc.design_system.components.navigation.WgcGroceryBottomNav
import br.com.wgc.design_system.components.navigation.GroceryNavTab
import br.com.wgc.ds_templates.screens.grocery.model.GroceryMockData
import br.com.wgc.ds_templates.screens.grocery.model.SupermercadoProductItem
import br.com.wgc.ds_templates.screens.grocery.model.SupermercadoUserProfile

private data class SupermercadoDepartmentCategory(val title: String, val icon: ImageVector, val color: Int)

/**
 * Template da Tela Principal do Supermercado Brasil.
 *
 * Apresenta navegação de hipermercado, seletor de loja/express, card do Cartão Supermercado,
 * régua Nutri-Score internacional e vitrine de ofertas com parcelamento exclusivo.
 */
@Composable
fun WgcSupermercadoHomeTemplate(
    modifier: Modifier = Modifier,
    userProfile: SupermercadoUserProfile = GroceryMockData.defaultUser,
    products: List<SupermercadoProductItem> = GroceryMockData.products,
    featuredProducts: List<SupermercadoProductItem> = products,
    coinsBalance: Int = userProfile.coinsBalance,
    currentStore: String = userProfile.selectedStore,
    activeTab: GroceryNavTab = GroceryNavTab.HOME,
    onTabSelected: (GroceryNavTab) -> Unit = {},
    selectedNavIndex: Int = 0,
    onNavSelect: (Int) -> Unit = {},
    onProductQuantityChange: (String, Int) -> Unit = { _, _ -> },
    onProductFavoriteToggle: (String) -> Unit = {},
    onScanBarcodeClick: () -> Unit = {},
    onStoreChangeClick: () -> Unit = {},
    onBarcodeScanClick: () -> Unit = onScanBarcodeClick,
    onViewNutriScoreDetails: () -> Unit = {},
    headerSlot: (@Composable () -> Unit)? = null,
    cardSlot: (@Composable () -> Unit)? = null,
    footerSlot: (@Composable () -> Unit)? = null
) {
    val departments = listOf(
        SupermercadoDepartmentCategory("Mercado", Icons.Default.ShoppingBag, WgcCoreDsColors.groceryBlue),
        SupermercadoDepartmentCategory("Eletro & TV", Icons.Default.Tv, WgcCoreDsColors.groceryRed),
        SupermercadoDepartmentCategory("Drogaria", Icons.Default.LocalPharmacy, WgcCoreDsColors.groceryNutriScoreA),
        SupermercadoDepartmentCategory("Bazar & Limpeza", Icons.Default.CleaningServices, WgcCoreDsColors.groceryOrange),
        SupermercadoDepartmentCategory("Posto Supermercado", Icons.Default.LocalGasStation, WgcCoreDsColors.groceryYellow)
    )

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            footerSlot?.invoke() ?: WgcGroceryBottomNav(
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
            // Header Supermercado com Seletor de Loja e Busca
            item {
                headerSlot?.invoke() ?: Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(WgcCoreDsColors.grocerySurface))
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.sm12.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "VOCÊ ESTÁ COMPRANDO EM",
                                color = Color(WgcCoreDsColors.groceryTextSecondary),
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                            ) {
                                Text(
                                    text = userProfile.selectedStore,
                                    color = Color(WgcCoreDsColors.groceryTextPrimary),
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.Bold
                                )
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowDown,
                                    contentDescription = "Trocar Loja",
                                    tint = Color(WgcCoreDsColors.groceryBlue),
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
                                tint = Color(WgcCoreDsColors.groceryBlue),
                                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                    // Busca com Scanner de Código de Barras
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(WgcCoreDsSize.s48.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                            .background(Color(WgcCoreDsColors.groceryBackground))
                            .border(
                                width = WgcCoreDsSize.s1.dp,
                                color = Color(WgcCoreDsColors.groceryBorder),
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
                                tint = Color(WgcCoreDsColors.groceryTextSecondary),
                                modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                            )
                            Text(
                                text = "Buscar no Supermercado...",
                                color = Color(WgcCoreDsColors.groceryTextSecondary),
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
                                    tint = Color(WgcCoreDsColors.groceryBlue),
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
                                    tint = Color(WgcCoreDsColors.groceryTextSecondary),
                                    modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                                )
                            }
                        }
                    }
                }
            }

            // Card Cartão Supermercado / Meu Supermercado
            item {
                Box(
                    modifier = Modifier.padding(
                        horizontal = WgcCoreDsSpacing.md16.dp,
                        vertical = WgcCoreDsSpacing.sm12.dp
                    )
                ) {
                    cardSlot?.invoke() ?: WgcGroceryLoyaltyCard(
                        holderName = userProfile.name,
                        cardLastDigits = userProfile.cardLastDigits,
                        availableLimit = userProfile.availableLimit,
                        coinsBalance = userProfile.coinsBalance,
                        bestPurchaseDay = userProfile.bestPurchaseDay
                    )
                }
            }

            // Departamentos Supermercado em Círculos
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
                                        .background(Color(WgcCoreDsColors.grocerySurface))
                                        .border(
                                            width = WgcCoreDsSize.s1.dp,
                                            color = Color(dept.color).copy(alpha = 0.35f),
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
                                    color = Color(WgcCoreDsColors.groceryTextPrimary),
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

            // Banner Terça e Quarta do Hortifruti
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(WgcCoreDsColors.groceryNutriScoreA)
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
                                    .background(Color(WgcCoreDsColors.groceryYellow))
                                    .padding(
                                        horizontal = WgcCoreDsSpacing.xs8.dp,
                                        vertical = WgcCoreDsSpacing.xxs4.dp
                                    )
                            ) {
                                Text(
                                    text = "DIAS DE FEIRA",
                                    color = Color(WgcCoreDsColors.groceryTextPrimary),
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.Black
                                )
                            }

                            Text(
                                text = "Até 40% OFF",
                                color = Color.White,
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                        Text(
                            text = "Terça e Quarta do Hortifruti Supermercado",
                            color = Color.White,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Frutas, legumes e verduras fresquinhas direto do produtor com preço especial no app.",
                            color = Color.White.copy(alpha = 0.9f),
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }

            // Card Educativo Nutri-Score
            item {
                Box(modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp)) {
                    WgcGroceryNutriScoreCard(
                        currentScore = "A",
                        explanation = "O Supermercado é pioneiro na adoção voluntária do Nutri-Score no Brasil, ajudando você a fazer compras mais conscientes e saudáveis."
                    )
                }
            }

            // Vitrine de Produtos em Destaque
            item {
                Column(modifier = Modifier.padding(top = WgcCoreDsSpacing.md16.dp, bottom = WgcCoreDsSpacing.lg24.dp)) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = WgcCoreDsSpacing.md16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "OFERTAS DO HIPERMERCADO",
                                color = Color(WgcCoreDsColors.groceryBlue),
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Black
                            )
                            Text(
                                text = "Preço Baixo Todo Dia",
                                color = Color(WgcCoreDsColors.groceryTextPrimary),
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                        ) {
                            Text(
                                text = "Ver Todas",
                                color = Color(WgcCoreDsColors.groceryBlue),
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold
                            )
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.groceryBlue),
                                modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp),
                        contentPadding = androidx.compose.foundation.layout.PaddingValues(
                            horizontal = WgcCoreDsSpacing.md16.dp
                        )
                    ) {
                        items(products) { product ->
                            WgcGroceryProductCard(
                                title = product.title,
                                brandLine = product.brandLine,
                                unit = product.unit,
                                regularPrice = product.regularPrice,
                                cardSupermercadoPrice = product.cardSupermercadoPrice,
                                nutriScore = product.nutriScore,
                                discountPercentage = product.discountPercentage,
                                installmentsText = product.installmentsText,
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

@Preview(name = "Supermercado Home Template", showBackground = true)
@Composable
private fun WgcSupermercadoHomeTemplatePreview() {
    WgcSupermercadoHomeTemplate()
}
