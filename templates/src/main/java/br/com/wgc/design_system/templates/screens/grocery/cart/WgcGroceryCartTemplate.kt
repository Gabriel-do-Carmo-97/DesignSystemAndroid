package br.com.wgc.design_system.templates.screens.grocery.cart

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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.DeleteOutline
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
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
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsElevation
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.components.navigation.GroceryNavTab
import br.com.wgc.design_system.components.navigation.WgcGroceryBottomNav
import br.com.wgc.design_system.templates.screens.grocery.model.SupermercadoCartItem
import br.com.wgc.design_system.templates.screens.grocery.model.GroceryMockData

@Composable
fun WgcSupermercadoCartTemplate(
    modifier: Modifier = Modifier,
    cartItems: List<SupermercadoCartItem> = GroceryMockData.sampleCartItems,
    deliveryFee: Double = 9.90,
    activeTab: GroceryNavTab = GroceryNavTab.CART,
    onTabSelected: (GroceryNavTab) -> Unit = {},
    onQuantityChange: (String, Int) -> Unit = { _, _ -> },
    onRemoveItem: (String) -> Unit = {},
    onCheckout: () -> Unit = {}
) {
    val subtotal = cartItems.sumOf { it.product.price * it.quantity }
    val groceryCardSubtotal = cartItems.sumOf { (it.product.groceryCardPrice ?: it.product.price) * it.quantity }
    val total = subtotal + deliveryFee
    val groceryCardTotal = groceryCardSubtotal + deliveryFee
    val economyWithGroceryCard = total - groceryCardTotal

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            Column {
                CartSummaryBottomBar(
                    total = total,
                    groceryCardTotal = groceryCardTotal,
                    economy = economyWithGroceryCard,
                    onCheckout = onCheckout
                )
                WgcGroceryBottomNav(
                    selectedTab = activeTab,
                    onTabSelected = onTabSelected,
                    cartBadgeCount = cartItems.sumOf { it.quantity }
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(
                horizontal = WgcCoreDsSpacing.md16.dp,
                vertical = WgcCoreDsSpacing.md16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
        ) {
            item {
                CartHeaderInfo(itemCount = cartItems.sumOf { it.quantity })
            }

            items(cartItems) { item ->
                CartItemRow(
                    cartItem = item,
                    onQuantityChange = { q -> onQuantityChange(item.product.id, q) },
                    onRemove = { onRemoveItem(item.product.id) }
                )
            }

            item {
                CartaoSupermercadoInstallmentSimulator(
                    total = groceryCardTotal,
                    maxInstallments = 10
                )
            }

            item {
                DeliveryTypeCard()
            }
        }
    }
}

@Composable
private fun CartHeaderInfo(itemCount: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Meu Carrinho ($itemCount itens)",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(WgcCoreDsColors.groceryTextPrimary)
        )
    }
}

@Composable
private fun CartItemRow(
    cartItem: SupermercadoCartItem,
    onQuantityChange: (Int) -> Unit,
    onRemove: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.grocerySurface)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.sm12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(WgcCoreDsSize.s64.dp)
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                    .background(Color(WgcCoreDsColors.groceryPlaceholder))
            )

            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = cartItem.product.title,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.groceryTextPrimary),
                    maxLines = 2
                )
                Text(
                    text = "R$ " + String.format("%.2f", cartItem.product.price),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(WgcCoreDsColors.groceryTextSecondary)
                )
                if (cartItem.product.groceryCardPrice != null) {
                    Text(
                        text = "R$ " + String.format("%.2f", cartItem.product.groceryCardPrice) + " no Cartão Supermercado",
                        fontSize = 10.sp,
                        color = Color(WgcCoreDsColors.groceryBlue),
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(
                    onClick = {
                        if (cartItem.quantity > 1) {
                            onQuantityChange(cartItem.quantity - 1)
                        } else {
                            onRemove()
                        }
                    },
                    modifier = Modifier.size(WgcCoreDsSize.s28.dp)
                ) {
                    Icon(
                        imageVector = if (cartItem.quantity > 1) Icons.Default.Remove else Icons.Default.DeleteOutline,
                        contentDescription = "Diminuir",
                        tint = Color(WgcCoreDsColors.groceryRed),
                        modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                    )
                }

                Text(
                    text = cartItem.quantity.toString(),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.xs8.dp)
                )

                IconButton(
                    onClick = { onQuantityChange(cartItem.quantity + 1) },
                    modifier = Modifier.size(WgcCoreDsSize.s28.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Aumentar",
                        tint = Color(WgcCoreDsColors.groceryBlue),
                        modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun CartaoSupermercadoInstallmentSimulator(
    total: Double,
    maxInstallments: Int
) {
    val installmentVal = total / maxInstallments
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.groceryBlueLight)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.CreditCard,
                contentDescription = null,
                tint = Color(WgcCoreDsColors.groceryBlue),
                modifier = Modifier.size(WgcCoreDsSize.s32.dp)
            )
            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))
            Column {
                Text(
                    text = "Com Cartão Supermercado parcele em até:",
                    fontSize = 10.sp,
                    color = Color(WgcCoreDsColors.groceryBlueDark),
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "${maxInstallments}x de R$ " + String.format("%.2f", installmentVal) + " sem juros",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.groceryBlue)
                )
            }
        }
    }
}

@Composable
private fun DeliveryTypeCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
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
            Icon(
                imageVector = Icons.Default.LocalShipping,
                contentDescription = null,
                tint = Color(WgcCoreDsColors.groceryBlue),
                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
            )
            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))
            Column {
                Text(
                    text = "Entrega Expressa Supermercado",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.groceryTextPrimary)
                )
                Text(
                    text = "Receba em até 2 horas na sua casa",
                    fontSize = 10.sp,
                    color = Color(WgcCoreDsColors.groceryTextSecondary)
                )
            }
        }
    }
}

@Composable
private fun CartSummaryBottomBar(
    total: Double,
    groceryCardTotal: Double,
    economy: Double,
    onCheckout: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(
            topStart = WgcCoreDsBorderRadius.xl16.dp,
            topEnd = WgcCoreDsBorderRadius.xl16.dp,
            bottomStart = WgcCoreDsBorderRadius.none0.dp,
            bottomEnd = WgcCoreDsBorderRadius.none0.dp
        ),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.grocerySurface)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level6.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp)
        ) {
            if (economy > 0) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Economia Cartão Supermercado:",
                        fontSize = 10.sp,
                        color = Color(WgcCoreDsColors.groceryNutriScoreA),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "- R$ " + String.format("%.2f", economy),
                        fontSize = 10.sp,
                        color = Color(WgcCoreDsColors.groceryNutriScoreA),
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Total:",
                        fontSize = 10.sp,
                        color = Color(WgcCoreDsColors.groceryTextSecondary)
                    )
                    Text(
                        text = "R$ " + String.format("%.2f", total),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.groceryTextPrimary)
                    )
                }

                WgcClassicButton(
                    textButton = "Fechar Pedido",
                    onClick = onCheckout
                    )
                
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcSupermercadoCartTemplatePreview() {
    WgcSupermercadoCartTemplate()
}
