package br.com.wgc.ds_templates.screens.drogaraia.cart

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DeleteOutline
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.Storefront
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
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.components.navigation.DrogaRaiaNavTab
import br.com.wgc.design_system.components.navigation.WgcDrogaRaiaBottomNav

@Composable
fun WgcDrogaRaiaCartTemplate(
    modifier: Modifier = Modifier,
    activeTab: DrogaRaiaNavTab = DrogaRaiaNavTab.CART,
    onTabSelected: (DrogaRaiaNavTab) -> Unit = {},
    onCheckout: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            Column {
                CartBottomBar(total = 64.40, onCheckout = onCheckout)
                WgcDrogaRaiaBottomNav(
                    selectedTab = activeTab,
                    onTabSelected = onTabSelected,
                    cartBadgeCount = 2
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            item {
                Text(
                    text = "Sua Sacola (2 itens)",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.drogaRaiaTextPrimary)
                )
            }

            // Entrega vs Retirada
            item {
                DeliverySelectorCard()
            }

            // Itens
            item {
                CartItemCard(
                    title = "Dipirona Monoidratada 500mg/mL",
                    laboratory = "EMS Genéricos",
                    price = 9.90,
                    quantity = 2
                )
            }
            item {
                CartItemCard(
                    title = "Amoxicilina + Clavulanato 875mg",
                    laboratory = "Eurofarma",
                    price = 44.60,
                    quantity = 1,
                    requiresPrescription = true
                )
            }
        }
    }
}

@Composable
private fun DeliverySelectorCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.drogaRaiaSurface)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Storefront,
                contentDescription = null,
                tint = Color(WgcCoreDsColors.drogaRaiaRed),
                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
            )
            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Retire em 15 min na Raia Pinheiros",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.drogaRaiaTextPrimary)
                )
                Text(
                    text = "Grátis • Rua Teodoro Sampaio, 1800",
                    fontSize = 10.sp,
                    color = Color(WgcCoreDsColors.drogaRaiaTextSecondary)
                )
            }
        }
    }
}

@Composable
private fun CartItemCard(
    title: String,
    laboratory: String,
    price: Double,
    quantity: Int,
    requiresPrescription: Boolean = false
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.drogaRaiaSurface)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.drogaRaiaTextPrimary)
                )
                Text(
                    text = laboratory,
                    fontSize = 10.sp,
                    color = Color(WgcCoreDsColors.drogaRaiaTextSecondary)
                )
                if (requiresPrescription) {
                    Text(
                        text = "Receita retida no momento da entrega",
                        fontSize = 9.sp,
                        color = Color(WgcCoreDsColors.drogaRaiaRed),
                        fontWeight = FontWeight.Bold
                    )
                }
                Text(
                    text = "R$ " + String.format("%.2f", price),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.drogaRaiaNavy)
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = {}, modifier = Modifier.size(WgcCoreDsSize.s28.dp)) {
                    Icon(
                        imageVector = if (quantity > 1) Icons.Default.Remove else Icons.Default.DeleteOutline,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.drogaRaiaRed),
                        modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                    )
                }
                Text(
                    text = quantity.toString(),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.xs8.dp)
                )
                IconButton(onClick = {}, modifier = Modifier.size(WgcCoreDsSize.s28.dp)) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.drogaRaiaNavy),
                        modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun CartBottomBar(total: Double, onCheckout: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(
            topStart = WgcCoreDsBorderRadius.xl16.dp,
            topEnd = WgcCoreDsBorderRadius.xl16.dp,
            bottomStart = WgcCoreDsBorderRadius.none0.dp,
            bottomEnd = WgcCoreDsBorderRadius.none0.dp
        ),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.drogaRaiaSurface)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level6.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Total:",
                    fontSize = 10.sp,
                    color = Color(WgcCoreDsColors.drogaRaiaTextSecondary)
                )
                Text(
                    text = "R$ " + String.format("%.2f", total),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.drogaRaiaNavy)
                )
            }

            WgcClassicButton(
                textButton = "Finalizar Pedido",
                onClick = onCheckout
                )
            
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcDrogaRaiaCartTemplatePreview() {
    WgcDrogaRaiaCartTemplate()
}
