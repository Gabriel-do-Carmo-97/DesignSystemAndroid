package br.com.wgc.ds_templates.screens.carrefour.coupons

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ConfirmationNumber
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material.icons.filled.Stars
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
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
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsFontSize
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.components.navigation.CarrefourNavTab
import br.com.wgc.design_system.components.navigation.WgcCarrefourBottomNav
import br.com.wgc.ds_templates.screens.carrefour.model.CarrefourCouponItem
import br.com.wgc.ds_templates.screens.carrefour.model.CarrefourMockData

@Composable
fun WgcCarrefourCouponsTemplate(
    modifier: Modifier = Modifier,
    coupons: List<CarrefourCouponItem> = CarrefourMockData.sampleCoupons,
    coinsBalance: Int = 180,
    activeTab: CarrefourNavTab = CarrefourNavTab.COUPONS,
    onTabSelected: (CarrefourNavTab) -> Unit = {},
    onActivateCoupon: (String) -> Unit = {},
    onViewCashierCode: () -> Unit = {}
) {
    var selectedCategory by remember { mutableStateOf("Todos") }
    val categories = listOf("Todos", "Hortifrúti", "Bebidas", "Limpeza", "Mercearia", "Marca Própria")

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color(WgcCoreDsColors.carrefourBackground),
        bottomBar = {
            WgcCarrefourBottomNav(
                selectedTab = activeTab,
                onTabSelected = onTabSelected,
                cartBadgeCount = 3
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(bottom = WgcCoreDsSpacing.xl32.dp)
        ) {
            item {
                MeuCarrefourHeaderCard(
                    coinsBalance = coinsBalance,
                    onViewCashierCode = onViewCashierCode
                )
            }

            item {
                MissionsProgressCard()
            }

            item {
                LazyRow(
                    contentPadding = PaddingValues(
                        horizontal = WgcCoreDsSpacing.md16.dp,
                        vertical = WgcCoreDsSpacing.xs8.dp
                    ),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    items(categories) { category ->
                        val isSelected = selectedCategory == category
                        FilterChip(
                            selected = isSelected,
                            onClick = { selectedCategory = category },
                            label = {
                                Text(
                                    text = category,
                                    fontSize = WgcCoreDsFontSize.sm14.sp,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                                )
                            },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = Color(WgcCoreDsColors.carrefourBlue),
                                selectedLabelColor = Color(WgcCoreDsColors.carrefourSurface),
                                containerColor = Color(WgcCoreDsColors.carrefourSurface),
                                labelColor = Color(WgcCoreDsColors.carrefourTextPrimary)
                            ),
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.full9999.dp)
                        )
                    }
                }
            }

            val filteredCoupons = if (selectedCategory == "Todos") {
                coupons
            } else {
                coupons.filter { it.category == selectedCategory }
            }

            items(filteredCoupons) { coupon ->
                CouponRowCard(
                    coupon = coupon,
                    onActivate = { onActivateCoupon(coupon.id) }
                )
            }
        }
    }
}

@Composable
private fun MeuCarrefourHeaderCard(
    coinsBalance: Int,
    onViewCashierCode: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(WgcCoreDsSpacing.md16.dp),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.carrefourBlue)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.xs2.dp)
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
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.MonetizationOn,
                        contentDescription = "Moedas",
                        tint = Color(WgcCoreDsColors.carrefourYellow),
                        modifier = Modifier.size(WgcCoreDsSize.s28.dp)
                    )
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                    Column {
                        Text(
                            text = "Minhas Moedas",
                            color = Color(WgcCoreDsColors.carrefourSurface).copy(alpha = 0.85f),
                            fontSize = WgcCoreDsFontSize.xs12.sp
                        )
                        Text(
                            text = "$coinsBalance moedas",
                            color = Color(WgcCoreDsColors.carrefourSurface),
                            fontSize = WgcCoreDsFontSize.xl20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                WgcClassicButton(
                    text = "QR no Caixa",
                    onClick = onViewCashierCode,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.QrCode,
                            contentDescription = "QR Code",
                            tint = Color(WgcCoreDsColors.carrefourBlue),
                            modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                        )
                    },
                    containerColor = Color(WgcCoreDsColors.carrefourSurface),
                    contentColor = Color(WgcCoreDsColors.carrefourBlue)
                )
            }
        }
    }
}

@Composable
private fun MissionsProgressCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.carrefourSurface)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.xs2.dp)
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
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Stars,
                        contentDescription = "Missão",
                        tint = Color(WgcCoreDsColors.carrefourRed),
                        modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                    )
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                    Text(
                        text = "Missão do Mês: Gaste R$ 300",
                        fontSize = WgcCoreDsFontSize.sm14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.carrefourTextPrimary)
                    )
                }
                Text(
                    text = "R$ 210 / 300",
                    fontSize = WgcCoreDsFontSize.xs12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(WgcCoreDsColors.carrefourBlue)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            LinearProgressIndicator(
                progress = { 0.7f },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(WgcCoreDsSize.s8.dp)
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.full9999.dp)),
                color = Color(WgcCoreDsColors.carrefourRed),
                trackColor = Color(WgcCoreDsColors.carrefourBorder)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            Text(
                text = "Complete para desbloquear 50 moedas extras e desconto de 15% na padaria!",
                fontSize = WgcCoreDsFontSize.xs12.sp,
                color = Color(WgcCoreDsColors.carrefourTextSecondary)
            )
        }
    }
}

@Composable
private fun CouponRowCard(
    coupon: CarrefourCouponItem,
    onActivate: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.carrefourSurface)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.xs2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(WgcCoreDsSize.s48.dp)
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm8.dp))
                    .background(Color(WgcCoreDsColors.carrefourBlueLight)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.ConfirmationNumber,
                    contentDescription = null,
                    tint = Color(WgcCoreDsColors.carrefourBlue),
                    modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                )
            }

            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = coupon.title,
                    fontSize = WgcCoreDsFontSize.md16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.carrefourTextPrimary)
                )
                Text(
                    text = coupon.description,
                    fontSize = WgcCoreDsFontSize.xs12.sp,
                    color = Color(WgcCoreDsColors.carrefourTextSecondary)
                )
                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                Text(
                    text = "Válido até " + coupon.validUntil,
                    fontSize = WgcCoreDsFontSize.xs12.sp,
                    color = Color(WgcCoreDsColors.carrefourRed),
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))

            if (coupon.isActivated) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "Ativado",
                        tint = Color(WgcCoreDsColors.carrefourNutriScoreA),
                        modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                    )
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                    Text(
                        text = "Ativo",
                        fontSize = WgcCoreDsFontSize.xs12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.carrefourNutriScoreA)
                    )
                }
            } else {
                WgcClassicButton(
                    text = "Ativar",
                    onClick = onActivate,
                    containerColor = Color(WgcCoreDsColors.carrefourBlue),
                    contentColor = Color(WgcCoreDsColors.carrefourSurface)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcCarrefourCouponsTemplatePreview() {
    WgcCarrefourCouponsTemplate()
}
