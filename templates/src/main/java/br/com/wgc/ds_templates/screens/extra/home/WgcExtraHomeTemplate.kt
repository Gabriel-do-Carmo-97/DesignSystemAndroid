package br.com.wgc.ds_templates.screens.extra.home

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
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
import br.com.wgc.design_system.components.cards.WgcExtraProductCard
import br.com.wgc.design_system.components.cards.WgcExtraStampsLoyaltyCard
import br.com.wgc.design_system.components.navigation.WgcExtraBottomNav
import br.com.wgc.design_system.components.navigation.WgcExtraNavItem
import br.com.wgc.ds_templates.screens.extra.model.ExtraMockData
import br.com.wgc.ds_templates.screens.extra.model.ExtraProductItem
import br.com.wgc.ds_templates.screens.extra.model.ExtraUserProfile

/**
 * Template da Tela Principal / Home do Clube Extra.
 *
 * Vitrine de supermercado com seletor de loja física, barra de busca inteligente,
 * banner da promoção "Juntou Ganhou", atalhos de corredores e carrossel de produtos com desconto.
 *
 * 100% tokenizado com WgcCoreDs e State Hoisting.
 */
@Composable
fun WgcExtraHomeTemplate(
    user: ExtraUserProfile,
    products: List<ExtraProductItem>,
    modifier: Modifier = Modifier,
    cartItemCount: Int = 3,
    onSearchClick: () -> Unit = {},
    onChangeStoreClick: () -> Unit = {},
    onOpenDiscounts: () -> Unit = {},
    onOpenFlyer: () -> Unit = {},
    onOpenCart: () -> Unit = {},
    onOpenLoyalty: () -> Unit = {},
    onSelectProduct: (ExtraProductItem) -> Unit = {},
    onAddToCart: (ExtraProductItem) -> Unit = {},
    selectedNavItem: WgcExtraNavItem = WgcExtraNavItem.HOME,
    onNavItemClick: (WgcExtraNavItem) -> Unit = {},
    slotHeader: (@Composable () -> Unit)? = null,
    slotBanner: (@Composable () -> Unit)? = null,
    slotBottomNav: (@Composable () -> Unit)? = null
) {
    val categories = listOf("Hortifrúti", "Carnes", "Bebidas", "Limpeza", "Padaria", "Laticínios", "Congelados")

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            if (slotBottomNav != null) {
                slotBottomNav()
            } else {
                WgcExtraBottomNav(
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
            // Header: Localização da Entrega & Ícones
            item {
                if (slotHeader != null) {
                    slotHeader()
                } else {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = WgcCoreDsSpacing.md16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp),
                            modifier = Modifier.clickable { onChangeStoreClick() }
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(WgcCoreDsSize.s36.dp)
                                    .clip(CircleShape)
                                    .background(Color(WgcCoreDsColors.extraRedLight)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.LocationOn,
                                    contentDescription = null,
                                    tint = Color(WgcCoreDsColors.extraRed),
                                    modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                                )
                            }

                            Column {
                                Text(
                                    text = "Entregar em",
                                    color = Color(WgcCoreDsColors.extraSecondaryText),
                                    fontSize = 11.sp
                                )
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        text = user.selectedStoreName,
                                        color = Color(WgcCoreDsColors.extraDark),
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Icon(
                                        imageVector = Icons.Default.KeyboardArrowDown,
                                        contentDescription = "Trocar loja",
                                        tint = Color(WgcCoreDsColors.extraDark),
                                        modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                                    )
                                }
                            }
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                        ) {
                            IconButton(onClick = {}) {
                                Icon(
                                    imageVector = Icons.Default.Notifications,
                                    contentDescription = "Notificações",
                                    tint = Color(WgcCoreDsColors.extraDark),
                                    modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                                )
                            }

                            Box(modifier = Modifier.clickable { onOpenCart() }) {
                                Icon(
                                    imageVector = Icons.Default.ShoppingCart,
                                    contentDescription = "Carrinho",
                                    tint = Color(WgcCoreDsColors.extraRed),
                                    modifier = Modifier.size(WgcCoreDsSize.s26.dp)
                                )
                                if (cartItemCount > 0) {
                                    Box(
                                        modifier = Modifier
                                            .align(Alignment.TopEnd)
                                            .size(WgcCoreDsSize.s16.dp)
                                            .clip(CircleShape)
                                            .background(Color(WgcCoreDsColors.extraYellow)),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = "$cartItemCount",
                                            color = Color(WgcCoreDsColors.extraDark),
                                            fontSize = 9.sp,
                                            fontWeight = FontWeight.Black
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // Barra de Busca de Supermercado
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onSearchClick() },
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.extraSurface)),
                    border = androidx.compose.foundation.BorderStroke(
                        width = WgcCoreDsSize.s1.dp,
                        color = Color(WgcCoreDsColors.extraBorder)
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.sm12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.extraSecondaryText),
                            modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                        )
                        Text(
                            text = "Buscar produtos, marcas e ofertas no Extra...",
                            color = Color(WgcCoreDsColors.extraSecondaryText),
                            fontSize = 13.sp
                        )
                    }
                }
            }

            // Banner Hero SuperFeira Extra
            item {
                if (slotBanner != null) {
                    slotBanner()
                } else {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onOpenFlyer() },
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.extraRed)),
                        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(WgcCoreDsSpacing.md16.dp),
                            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                    .background(Color(WgcCoreDsColors.extraYellow))
                                    .padding(horizontal = WgcCoreDsSpacing.xs8.dp, vertical = WgcCoreDsSpacing.xxxs2.dp)
                            ) {
                                Text(
                                    text = "SUPERFEIRA EXTRA",
                                    color = Color(WgcCoreDsColors.extraDark),
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Black,
                                    letterSpacing = 0.5.sp
                                )
                            }

                            Text(
                                text = "Frutas, Legumes e Carnes com até 40% OFF!",
                                color = Color.White,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Black,
                                lineHeight = 22.sp
                            )

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                            ) {
                                Text(
                                    text = "Ver folheto de ofertas da semana",
                                    color = Color(WgcCoreDsColors.extraYellow),
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                                    contentDescription = null,
                                    tint = Color(WgcCoreDsColors.extraYellow),
                                    modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                                )
                            }
                        }
                    }
                }
            }

            // Card Fidelidade "Juntou Ganhou"
            item {
                WgcExtraStampsLoyaltyCard(
                    currentStamps = user.loyaltyStamps.currentStamps,
                    targetStamps = user.loyaltyStamps.targetStamps,
                    rewardName = user.loyaltyStamps.rewardName,
                    amountToNextStamp = user.loyaltyStamps.amountToNextStamp,
                    onClick = onOpenLoyalty,
                    onSeeCatalogClick = onOpenLoyalty
                )
            }

            // Corredores / Categorias Rápidas
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    items(categories) { categoryName ->
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                                .background(Color(WgcCoreDsColors.extraSurface))
                                .border(
                                    width = WgcCoreDsSize.s1.dp,
                                    color = Color(WgcCoreDsColors.extraBorder),
                                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
                                )
                                .clickable { }
                                .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp)
                        ) {
                            Text(
                                text = categoryName,
                                color = Color(WgcCoreDsColors.extraDark),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }
            }

            // Header Seção Meus Descontos
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                    ) {
                        Text(
                            text = "MEUS DESCONTOS EXCLUSIVOS",
                            color = Color(WgcCoreDsColors.extraDark),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Black,
                            letterSpacing = 0.5.sp
                        )
                    }

                    Text(
                        text = "Ver todos",
                        color = Color(WgcCoreDsColors.extraRed),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable { onOpenDiscounts() }
                    )
                }
            }

            // Lista de Produtos com Preço Clube
            items(products, key = { it.id }) { product ->
                WgcExtraProductCard(
                    name = product.name,
                    unitDescription = product.unitDescription,
                    regularPrice = product.regularPrice,
                    clubPrice = product.clubPrice,
                    discountPercentage = product.discountPercentage,
                    isDiscountActivated = product.isDiscountActivated,
                    quantityInCart = product.quantityInCart,
                    onClick = { onSelectProduct(product) },
                    onAddToCart = { onAddToCart(product) }
                )
            }
        }
    }
}

@Preview(name = "Clube Extra Home Template - Preview")
@Composable
fun WgcExtraHomeTemplatePreview() {
    WgcExtraHomeTemplate(
        user = ExtraMockData.mockUser,
        products = ExtraMockData.mockProducts
    )
}
