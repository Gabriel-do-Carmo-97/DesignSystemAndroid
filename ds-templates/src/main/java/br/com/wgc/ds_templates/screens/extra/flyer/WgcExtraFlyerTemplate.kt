package br.com.wgc.ds_templates.screens.extra.flyer

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.Share
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
import br.com.wgc.design_system.components.navigation.WgcExtraBottomNav
import br.com.wgc.design_system.components.navigation.WgcExtraNavItem
import br.com.wgc.ds_templates.screens.extra.model.ExtraMockData
import br.com.wgc.ds_templates.screens.extra.model.ExtraProductItem

/**
 * Template do Folheto Digital / Tabloide de Ofertas do Clube Extra.
 *
 * Apresenta o catálogo impresso em versão interativa digital com navegação
 * por páginas temáticas e adição instantânea de ofertas ao carrinho.
 *
 * 100% tokenizado com WgcCoreDs e State Hoisting.
 */
@Composable
fun WgcExtraFlyerTemplate(
    products: List<ExtraProductItem>,
    modifier: Modifier = Modifier,
    selectedPageIndex: Int = 0,
    onSelectPage: (Int) -> Unit = {},
    onAddToCart: (ExtraProductItem) -> Unit = {},
    selectedNavItem: WgcExtraNavItem = WgcExtraNavItem.FLYER,
    onNavItemClick: (WgcExtraNavItem) -> Unit = {},
    slotHeader: (@Composable () -> Unit)? = null,
    slotBottomNav: (@Composable () -> Unit)? = null
) {
    val pages = listOf(
        "Pág 1 • Destaques da Semana",
        "Pág 2 • Açougue & Churrasco",
        "Pág 3 • SuperFeira Hortifrúti",
        "Pág 4 • Limpeza & Higiene"
    )

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
            // Header
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
                        Column {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                            ) {
                                Icon(
                                    imageVector = androidx.compose.material.icons.Icons.AutoMirrored.Filled.MenuBook,
                                    contentDescription = null,
                                    tint = Color(WgcCoreDsColors.extraRed),
                                    modifier = Modifier.size(WgcCoreDsSize.s22.dp)
                                )
                                Text(
                                    text = "FOLHETO DIGITAL",
                                    color = Color(WgcCoreDsColors.extraRed),
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Black,
                                    letterSpacing = 1.sp
                                )
                            }
                            Text(
                                text = "Ofertas da Semana Extra",
                                color = Color(WgcCoreDsColors.extraDark),
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Black
                            )
                        }

                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Default.Share,
                                contentDescription = "Compartilhar folheto",
                                tint = Color(WgcCoreDsColors.extraDark),
                                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                            )
                        }
                    }
                }
            }

            // Banner da Edição
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
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
                        Text(
                            text = "EDIÇÃO VÁLIDA ATÉ DOMINGO, 21 DE SETEMBRO",
                            color = Color(WgcCoreDsColors.extraYellow),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Black,
                            letterSpacing = 0.5.sp
                        )
                        Text(
                            text = "Preços válidos para todas as lojas de São Paulo e compras pelo App.",
                            color = Color.White,
                            fontSize = 13.sp
                        )
                    }
                }
            }

            // Seletor de Páginas do Folheto
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    items(pages.indices.toList()) { index ->
                        val isSelected = index == selectedPageIndex
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                                .background(
                                    if (isSelected) Color(WgcCoreDsColors.extraRed) else Color(WgcCoreDsColors.extraSurface)
                                )
                                .border(
                                    width = WgcCoreDsSize.s1.dp,
                                    color = if (isSelected) Color(WgcCoreDsColors.extraRed) else Color(WgcCoreDsColors.extraBorder),
                                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
                                )
                                .clickable { onSelectPage(index) }
                                .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp)
                        ) {
                            Text(
                                text = pages[index],
                                color = if (isSelected) Color.White else Color(WgcCoreDsColors.extraDark),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            // Produtos da Página Selecionada
            items(products, key = { it.id }) { product ->
                WgcExtraProductCard(
                    name = product.name,
                    unitDescription = product.unitDescription,
                    regularPrice = product.regularPrice,
                    clubPrice = product.clubPrice,
                    discountPercentage = product.discountPercentage,
                    isDiscountActivated = product.isDiscountActivated,
                    quantityInCart = product.quantityInCart,
                    onAddToCart = { onAddToCart(product) }
                )
            }
        }
    }
}

@Preview(name = "Clube Extra Flyer Template - Preview")
@Composable
fun WgcExtraFlyerTemplatePreview() {
    WgcExtraFlyerTemplate(
        products = ExtraMockData.mockProducts
    )
}
