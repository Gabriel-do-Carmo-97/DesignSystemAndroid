package br.com.wgc.ds_templates.screens.grocery.coupons

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
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.components.navigation.GroceryNavTab
import br.com.wgc.design_system.components.navigation.WgcGroceryBottomNav
import br.com.wgc.ds_templates.screens.grocery.model.SupermercadoCouponItem
import br.com.wgc.ds_templates.screens.grocery.model.GroceryMockData

@Composable
fun WgcSupermercadoCouponsTemplate(
    modifier: Modifier = Modifier,
    coupons: List<SupermercadoCouponItem> = GroceryMockData.sampleCoupons,
    coinsBalance: Int = 180,
    activeTab: GroceryNavTab = GroceryNavTab.COUPONS,
    onTabSelected: (GroceryNavTab) -> Unit = {},
    onActivateCoupon: (String) -> Unit = {},
    onViewCashierCode: () -> Unit = {}
) {
    var selectedCategory by remember { mutableStateOf("Todos") }
    val categories = listOf("Todos", "Hortifrúti", "Bebidas", "Limpeza", "Mercearia", "Marca Própria")

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            WgcGroceryBottomNav(
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
                MeuSupermercadoHeaderCard(
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
                                    fontSize = 12.sp,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                                )
                            },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = Color(WgcCoreDsColors.groceryBlue),
                                selectedLabelColor = Color(WgcCoreDsColors.grocerySurface),
                                labelColor = Color(WgcCoreDsColors.groceryTextPrimary)
                            ),
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
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
private fun MeuSupermercadoHeaderCard(
    coinsBalance: Int,
    onViewCashierCode: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(WgcCoreDsSpacing.md16.dp),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.groceryBlue)),
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
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.MonetizationOn,
                        contentDescription = "Moedas",
                        tint = Color(WgcCoreDsColors.groceryYellow),
                        modifier = Modifier.size(WgcCoreDsSize.s28.dp)
                    )
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                    Column {
                        Text(
                            text = "Minhas Moedas",
                            color = Color(WgcCoreDsColors.grocerySurface).copy(alpha = 0.85f),
                            fontSize = 10.sp
                        )
                        Text(
                            text = "$coinsBalance moedas",
                            color = Color(WgcCoreDsColors.grocerySurface),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                WgcClassicButton(
                    textButton = "QR no Caixa",
                    onClick = onViewCashierCode
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
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.grocerySurface)),
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
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Stars,
                        contentDescription = "Missão",
                        tint = Color(WgcCoreDsColors.groceryRed),
                        modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                    )
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                    Text(
                        text = "Missão do Mês: Gaste R$ 300",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.groceryTextPrimary)
                    )
                }
                Text(
                    text = "R$ 210 / 300",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(WgcCoreDsColors.groceryBlue)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            LinearProgressIndicator(
                progress = { 0.7f },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(WgcCoreDsSize.s8.dp)
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)),
                color = Color(WgcCoreDsColors.groceryRed),
                trackColor = Color(WgcCoreDsColors.groceryBorder)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            Text(
                text = "Complete para desbloquear 50 moedas extras e desconto de 15% na padaria!",
                fontSize = 10.sp,
                color = Color(WgcCoreDsColors.groceryTextSecondary)
            )
        }
    }
}

@Composable
private fun CouponRowCard(
    coupon: SupermercadoCouponItem,
    onActivate: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.grocerySurface)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
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
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                    .background(Color(WgcCoreDsColors.groceryBlueLight)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.ConfirmationNumber,
                    contentDescription = null,
                    tint = Color(WgcCoreDsColors.groceryBlue),
                    modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                )
            }

            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = coupon.title,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.groceryTextPrimary)
                )
                Text(
                    text = coupon.description,
                    fontSize = 10.sp,
                    color = Color(WgcCoreDsColors.groceryTextSecondary)
                )
                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                Text(
                    text = "Válido até " + coupon.validUntil,
                    fontSize = 10.sp,
                    color = Color(WgcCoreDsColors.groceryRed),
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))

            if (coupon.isActivated) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "Ativado",
                        tint = Color(WgcCoreDsColors.groceryNutriScoreA),
                        modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                    )
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                    Text(
                        text = "Ativo",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.groceryNutriScoreA)
                    )
                }
            } else {
                WgcClassicButton(
                    textButton = "Ativar",
                    onClick = onActivate
                    )
                
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcSupermercadoCouponsTemplatePreview() {
    WgcSupermercadoCouponsTemplate()
}
