package br.com.wgc.design_system.templates.screens.trendfashion.checkout

import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.LocalAtm
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcButton
import br.com.wgc.design_system.components.cards.WgcAddressCard
import br.com.wgc.design_system.components.cards.WgcPaymentMethodRadioCard
import br.com.wgc.design_system.components.inputs.WgcQuantityStepper
import br.com.wgc.design_system.templates.screens.trendfashion.model.StylishCartItem
import br.com.wgc.design_system.templates.screens.trendfashion.model.StylishProductItem

/**
 * Tela 12: Checkout (Sacola de compras e conferência de entrega).
 * (Figma ID: 1:17482)
 */
@Composable
fun WgcStylishCheckoutScreenTemplate(
    modifier: Modifier = Modifier,
    cartItems: List<StylishCartItem> = listOf(
        StylishCartItem(
            id = "c1",
            product = StylishProductItem("1", "Nike Sneakers", "Vision Alta Men's Shoes", "₹1,500", "₹2,499", 40),
            selectedSize = "7 UK",
            quantity = 1
        ),
        StylishCartItem(
            id = "c2",
            product = StylishProductItem("2", "Jordan Retro 4", "Basketball Shoes", "₹3,999", "₹6,999", 43),
            selectedSize = "8 UK",
            quantity = 1
        )
    ),
    onQuantityChange: (String, Int) -> Unit = { _, _ -> },
    onBackClick: () -> Unit = {},
    onChangeAddressClick: () -> Unit = {},
    onProceedToPaymentClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.md.dp, vertical = WgcCoreDsSpacing.sm.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Voltar",
                        tint = Color(WgcCoreDsColors.trendFashionDark)
                    )
                }
                Text(
                    text = "Checkout",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                    color = Color(WgcCoreDsColors.trendFashionDark)
                )
            }
        },
        bottomBar = {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shadowElevation = 8.dp,
                color = Color.White
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(WgcCoreDsSpacing.md.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Total Price",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color(WgcCoreDsColors.textSecondary)
                        )
                        Text(
                            text = "₹5,499",
                            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                            color = Color(WgcCoreDsColors.trendFashionDark)
                        )
                    }
                    WgcButton(
                        text = "Proceed to Payment",
                        onClick = onProceedToPaymentClick
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = WgcCoreDsSpacing.md.dp)
        ) {
            WgcAddressCard(
                title = "Delivery Address",
                address = "216 St Paul's Rd, London N1 2LL, UK",
                contactPhone = "+44-784232",
                onChangeClick = onChangeAddressClick
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg.dp))

            Text(
                text = "Shopping List",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                color = Color(WgcCoreDsColors.trendFashionDark)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

            cartItems.forEach { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = WgcCoreDsSpacing.xs.dp),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.trendFashionLightGray))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.sm.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(64.dp)
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm.dp))
                                .background(Color.White),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.ShoppingBag,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.trendFashionPink),
                                modifier = Modifier.size(32.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = item.product.title,
                                style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                                color = Color(WgcCoreDsColors.trendFashionDark)
                            )
                            Text(
                                text = "Size: ${item.selectedSize}",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(WgcCoreDsColors.textSecondary)
                            )
                            Text(
                                text = item.product.price,
                                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                                color = Color(WgcCoreDsColors.trendFashionDark)
                            )
                        }

                        WgcQuantityStepper(
                            quantity = item.quantity,
                            onQuantityChange = { onQuantityChange(item.id, it) }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl.dp))
        }
    }
}

/**
 * Tela 13: Place Order (Seleção de métodos de pagamento).
 * (Figma ID: 1:17606)
 */
@Composable
fun WgcStylishPlaceOrderScreenTemplate(
    modifier: Modifier = Modifier,
    selectedPaymentMethod: String = "Visa",
    onPaymentMethodSelect: (String) -> Unit = {},
    onBackClick: () -> Unit = {},
    onContinueClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.md.dp, vertical = WgcCoreDsSpacing.sm.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Voltar",
                        tint = Color(WgcCoreDsColors.trendFashionDark)
                    )
                }
                Text(
                    text = "Checkout",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                    color = Color(WgcCoreDsColors.trendFashionDark)
                )
            }
        },
        bottomBar = {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shadowElevation = 8.dp,
                color = Color.White
            ) {
                Box(modifier = Modifier.padding(WgcCoreDsSpacing.md.dp)) {
                    WgcButton(
                        text = "Continue",
                        onClick = onContinueClick,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = WgcCoreDsSpacing.md.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

            Text(
                text = "Select Payment Method",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                color = Color(WgcCoreDsColors.trendFashionDark)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))

            WgcPaymentMethodRadioCard(
                title = "VISA",
                subtitle = "********* 2109",
                icon = Icons.Default.CreditCard,
                isSelected = selectedPaymentMethod == "Visa",
                onSelect = { onPaymentMethodSelect("Visa") }
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

            WgcPaymentMethodRadioCard(
                title = "Mastercard",
                subtitle = "********* 4532",
                icon = Icons.Default.CreditCard,
                isSelected = selectedPaymentMethod == "Mastercard",
                onSelect = { onPaymentMethodSelect("Mastercard") }
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

            WgcPaymentMethodRadioCard(
                title = "PayPal",
                subtitle = "user@example.com",
                icon = Icons.Default.CreditCard,
                isSelected = selectedPaymentMethod == "PayPal",
                onSelect = { onPaymentMethodSelect("PayPal") }
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

            WgcPaymentMethodRadioCard(
                title = "Cash on Delivery",
                subtitle = "Pay with cash upon delivery",
                icon = Icons.Default.LocalAtm,
                isSelected = selectedPaymentMethod == "Cash",
                onSelect = { onPaymentMethodSelect("Cash") }
            )
        }
    }
}

/**
 * Tela 14: Shipping (Detalhamento final de custos e taxas).
 * (Figma ID: 1:17703)
 */
@Composable
fun WgcStylishShippingScreenTemplate(
    modifier: Modifier = Modifier,
    orderAmount: String = "₹5,499",
    shippingCost: String = "₹50",
    discountAmount: String = "- ₹200",
    totalAmount: String = "₹5,349",
    onBackClick: () -> Unit = {},
    onConfirmPaymentClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.md.dp, vertical = WgcCoreDsSpacing.sm.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Voltar",
                        tint = Color(WgcCoreDsColors.trendFashionDark)
                    )
                }
                Text(
                    text = "Checkout",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                    color = Color(WgcCoreDsColors.trendFashionDark)
                )
            }
        },
        bottomBar = {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shadowElevation = 8.dp,
                color = Color.White
            ) {
                Box(modifier = Modifier.padding(WgcCoreDsSpacing.md.dp)) {
                    WgcButton(
                        text = "Pay $totalAmount",
                        onClick = onConfirmPaymentClick,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = WgcCoreDsSpacing.md.dp)
        ) {
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))

            Text(
                text = "Order Summary",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                color = Color(WgcCoreDsColors.trendFashionDark)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md.dp),
                colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.trendFashionLightGray))
            ) {
                Column(modifier = Modifier.padding(WgcCoreDsSpacing.md.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Order", style = MaterialTheme.typography.bodyMedium, color = Color(WgcCoreDsColors.textSecondary))
                        Text(text = orderAmount, style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold), color = Color(WgcCoreDsColors.trendFashionDark))
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Shipping", style = MaterialTheme.typography.bodyMedium, color = Color(WgcCoreDsColors.textSecondary))
                        Text(text = shippingCost, style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold), color = Color(WgcCoreDsColors.trendFashionDark))
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Discount", style = MaterialTheme.typography.bodyMedium, color = Color(WgcCoreDsColors.textSecondary))
                        Text(text = discountAmount, style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold), color = Color(WgcCoreDsColors.trendFashionPink))
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))
                    HorizontalDivider()
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Total", style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold), color = Color(WgcCoreDsColors.trendFashionDark))
                        Text(text = totalAmount, style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold), color = Color(WgcCoreDsColors.trendFashionDark))
                    }
                }
            }
        }
    }
}

/**
 * Tela 15: Sucessfully (Feedback de confirmação de pagamento).
 * (Figma ID: 1:17780)
 */
@Composable
fun WgcStylishSuccessScreenTemplate(
    modifier: Modifier = Modifier,
    title: String = "Payment done successfully.",
    message: String = "Your order has been placed successfully and is being processed.",
    onContinueShoppingClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = WgcCoreDsSpacing.xl.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color(WgcCoreDsColors.trendFashionPink)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Sucesso",
                    tint = Color.White,
                    modifier = Modifier.size(52.dp)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl.dp))

            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                color = Color(WgcCoreDsColors.trendFashionDark),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

            Text(
                text = message,
                style = MaterialTheme.typography.bodyMedium,
                color = Color(WgcCoreDsColors.textSecondary),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxl.dp))

            WgcButton(
                text = "Continue Shopping",
                onClick = onContinueShoppingClick,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(name = "Checkout Screen Preview", showBackground = true)
@Composable
private fun WgcStylishCheckoutPreview() {
    WgcStylishCheckoutScreenTemplate()
}

@Preview(name = "Place Order Preview", showBackground = true)
@Composable
private fun WgcStylishPlaceOrderPreview() {
    WgcStylishPlaceOrderScreenTemplate()
}

@Preview(name = "Shipping Screen Preview", showBackground = true)
@Composable
private fun WgcStylishShippingPreview() {
    WgcStylishShippingScreenTemplate()
}

@Preview(name = "Success Screen Preview", showBackground = true)
@Composable
private fun WgcStylishSuccessPreview() {
    WgcStylishSuccessScreenTemplate()
}
