package br.com.wgc.ds_templates.screens.megastore.checkout

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
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcButton
import br.com.wgc.design_system.components.cards.WgcAddressCard
import br.com.wgc.design_system.components.cards.WgcPaymentMethodRadioCard
import br.com.wgc.design_system.components.cards.WgcMegaStoreVoucherCard
import br.com.wgc.design_system.components.inputs.WgcQuantityStepper
import br.com.wgc.ds_templates.screens.megastore.model.ShoppeCartItem
import br.com.wgc.ds_templates.screens.megastore.model.ShoppeProductItem
import coil3.compose.AsyncImage

/**
 * Telas 42 a 59: Carrinho, Cupons, Pagamento e Acompanhamento de Entrega ("To Receive").
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcShoppeCartScreenTemplate(
    modifier: Modifier = Modifier,
    cartItems: List<ShoppeCartItem> = listOf(
        ShoppeCartItem("c1", ShoppeProductItem("1", "Pastel Long Sleeve", "Clothing", "$34.00", "$45.00", 25), quantity = 1),
        ShoppeCartItem("c2", ShoppeProductItem("2", "Casual Oversized Hoodie", "Hoodies", "$49.00", "$70.00", 30), quantity = 2)
    ),
    onBackClick: () -> Unit = {},
    onCheckoutClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Cart", fontWeight = FontWeight.Black) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        },
        bottomBar = {
            Surface(modifier = Modifier.fillMaxWidth(), shadowElevation = 8.dp, color = Color.White) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(WgcCoreDsSpacing.md.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(text = "Total Price", fontSize = 12.sp, color = Color(WgcCoreDsColors.megaStoreSecondaryText))
                        Text(text = "$132.00", style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Black), color = Color(WgcCoreDsColors.megaStorePrimary))
                    }
                    WgcButton(
                        text = "Checkout",
                        onClick = onCheckoutClick,
                        modifier = Modifier.width(180.dp)
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
            cartItems.forEach { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = WgcCoreDsSpacing.xs.dp),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.white)),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.sm.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        AsyncImage(
                            model = item.product.imageUrl,
                            contentDescription = item.product.title,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(72.dp)
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm.dp))
                        )

                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = item.product.title, fontWeight = FontWeight.Bold, maxLines = 1)
                            Text(text = "Size: ${item.selectedSize}", fontSize = 12.sp, color = Color(WgcCoreDsColors.megaStoreSecondaryText))
                            Text(text = item.product.price, fontWeight = FontWeight.Black, color = Color(WgcCoreDsColors.megaStorePrimary))
                        }

                        WgcQuantityStepper(
                            quantity = item.quantity,
                            onQuantityChange = {}
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))

            // Voucher Section
            WgcMegaStoreVoucherCard(
                discountTitle = "$15 OFF Applied",
                minSpend = "Code: SHOPPE15",
                isCollected = true
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcShoppePaymentScreenTemplate(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    onPayNowClick: () -> Unit = {}
) {
    var selectedMethod by remember { mutableIntStateOf(0) }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                title = { Text("Payment", fontWeight = FontWeight.Black) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        },
        bottomBar = {
            Surface(modifier = Modifier.fillMaxWidth(), shadowElevation = 8.dp, color = Color.White) {
                Box(modifier = Modifier.padding(WgcCoreDsSpacing.md.dp)) {
                    WgcButton(
                        text = "Pay Now ($117.00)",
                        onClick = onPayNowClick
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
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md.dp)
        ) {
            Text("Delivery Address", fontWeight = FontWeight.Bold)
            WgcAddressCard(
                title = "Home Address",
                address = "742 Evergreen Terrace, Springfield, OR",
                onChangeClick = {}
            )

            Text("Payment Method", fontWeight = FontWeight.Bold)
            WgcPaymentMethodRadioCard(
                title = "Credit Card (Mastercard)",
                subtitle = "•••• •••• •••• 4242",
                icon = Icons.Default.CreditCard,
                isSelected = selectedMethod == 0,
                onSelect = { selectedMethod = 0 }
            )
            WgcPaymentMethodRadioCard(
                title = "Cash on Delivery",
                subtitle = "Pay upon receiving your items",
                icon = Icons.Default.LocalAtm,
                isSelected = selectedMethod == 1,
                onSelect = { selectedMethod = 1 }
            )
        }
    }
}

@Composable
fun WgcShoppeToReceiveTrackingScreenTemplate(
    modifier: Modifier = Modifier,
    orderId: String = "#SH-94821",
    onContinueShoppingClick: () -> Unit = {}
) {
    Scaffold(modifier = modifier.fillMaxSize(), containerColor = Color.White) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(WgcCoreDsSpacing.lg.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(96.dp)
                    .clip(CircleShape)
                    .background(Color(WgcCoreDsColors.megaStorePrimaryLight)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.LocalShipping,
                    contentDescription = null,
                    tint = Color(WgcCoreDsColors.megaStorePrimary),
                    modifier = Modifier.size(52.dp)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg.dp))

            Text(
                text = "Order Dispatched!",
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Black),
                color = Color(WgcCoreDsColors.megaStoreDark)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs.dp))

            Text(
                text = "Order $orderId is currently out for delivery.",
                color = Color(WgcCoreDsColors.megaStoreSecondaryText),
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl.dp))

            WgcButton(
                text = "Continue Shopping",
                onClick = onContinueShoppingClick
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcShoppeCartScreenTemplatePreview() {
    MaterialTheme {
        WgcShoppeCartScreenTemplate()
    }
}
