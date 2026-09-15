package br.com.wgc.ds_templates.screens.extra.discounts

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.ConfirmationNumber
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import br.com.wgc.design_system.components.cards.WgcExtraDiscountCouponCard
import br.com.wgc.design_system.components.navigation.WgcExtraBottomNav
import br.com.wgc.design_system.components.navigation.WgcExtraNavItem
import br.com.wgc.ds_templates.screens.extra.model.ExtraCouponItem
import br.com.wgc.ds_templates.screens.extra.model.ExtraMockData

/**
 * Template da Tela "Meus Descontos" do Clube Extra.
 *
 * Apresenta a central de cupons personalizados por CPF com filtro
 * de categorias e botão de ativação rápida em lote ("Ativar Todos").
 *
 * 100% tokenizado com WgcCoreDs e State Hoisting.
 */
@Composable
fun WgcExtraDiscountsTemplate(
    coupons: List<ExtraCouponItem>,
    userCpfMasked: String,
    modifier: Modifier = Modifier,
    selectedCategory: String? = null,
    onSelectCategory: (String?) -> Unit = {},
    onActivateAllClick: () -> Unit = {},
    onToggleCoupon: (ExtraCouponItem) -> Unit = {},
    selectedNavItem: WgcExtraNavItem = WgcExtraNavItem.DISCOUNTS,
    onNavItemClick: (WgcExtraNavItem) -> Unit = {},
    slotHeader: (@Composable () -> Unit)? = null,
    slotBottomNav: (@Composable () -> Unit)? = null
) {
    val categories = listOf("Limpeza", "Açougue & Carnes", "Bebidas", "Bebê & Infantil", "Mercearia")
    val filteredCoupons = if (selectedCategory == null) {
        coupons
    } else {
        coupons.filter { it.category == selectedCategory }
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color(WgcCoreDsColors.extraBackground),
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
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = WgcCoreDsSpacing.md16.dp),
                        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.ConfirmationNumber,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.extraRed),
                                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                            )
                            Text(
                                text = "MEUS DESCONTOS EXCLUSIVOS",
                                color = Color(WgcCoreDsColors.extraRed),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Black,
                                letterSpacing = 1.sp
                            )
                        }

                        Text(
                            text = "Economia Direto no Caixa",
                            color = Color(WgcCoreDsColors.extraDark),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Black
                        )

                        Text(
                            text = "Ative aqui os descontos e informe seu CPF ($userCpfMasked) ao pagar.",
                            color = Color(WgcCoreDsColors.extraSecondaryText),
                            fontSize = 12.sp
                        )
                    }
                }
            }

            // Banner "Ativar Todos"
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.extraRedLight)),
                    border = androidx.compose.foundation.BorderStroke(
                        width = WgcCoreDsSize.s1.dp,
                        color = Color(WgcCoreDsColors.extraRed).copy(alpha = 0.3f)
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Economize mais rápido!",
                                color = Color(WgcCoreDsColors.extraRedDark),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Ative todos os cupons disponíveis de uma vez só.",
                                color = Color(WgcCoreDsColors.extraDark),
                                fontSize = 12.sp
                            )
                        }

                        Button(
                            onClick = onActivateAllClick,
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(WgcCoreDsColors.extraRed),
                                contentColor = Color.White
                            ),
                            modifier = Modifier.height(WgcCoreDsSize.s36.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Bolt,
                                    contentDescription = null,
                                    modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                                )
                                Text(
                                    text = "ATIVAR TODOS",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }

            // Filtros de Categoria
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    item {
                        val isSelected = selectedCategory == null
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
                                .clickable { onSelectCategory(null) }
                                .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp)
                        ) {
                            Text(
                                text = "Todos",
                                color = if (isSelected) Color.White else Color(WgcCoreDsColors.extraDark),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    items(categories) { cat ->
                        val isSelected = selectedCategory == cat
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
                                .clickable { onSelectCategory(cat) }
                                .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp)
                        ) {
                            Text(
                                text = cat,
                                color = if (isSelected) Color.White else Color(WgcCoreDsColors.extraDark),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            // Lista de Cupons
            items(filteredCoupons, key = { it.id }) { coupon ->
                WgcExtraDiscountCouponCard(
                    title = coupon.title,
                    category = coupon.category,
                    discountBadge = coupon.discountBadge,
                    limitCondition = coupon.limitCondition,
                    validUntil = coupon.validUntil,
                    isActivated = coupon.isActivated,
                    onActivateToggle = { onToggleCoupon(coupon) }
                )
            }
        }
    }
}

@Preview(name = "Clube Extra Discounts Template - Preview")
@Composable
fun WgcExtraDiscountsTemplatePreview() {
    WgcExtraDiscountsTemplate(
        coupons = ExtraMockData.mockCoupons,
        userCpfMasked = "***.482.918-**"
    )
}
