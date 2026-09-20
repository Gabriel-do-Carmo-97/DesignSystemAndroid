package br.com.wgc.design_system.templates.screens.retail.checkout

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
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
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcRetailCartItemRow
import br.com.wgc.design_system.components.images.AsyncImageDefault
import br.com.wgc.design_system.templates.screens.retail.model.KutukuCartItem
import br.com.wgc.design_system.templates.screens.retail.model.RetailMockData

/**
 * Tela de Carrinho oficial do Kutuku (WgcKutukuCartScreen).
 */
@Composable
fun WgcKutukuCartScreen(
    modifier: Modifier = Modifier,
    initialItems: List<KutukuCartItem> = RetailMockData.sampleCartItems,
    onBackClick: () -> Unit = {},
    onCheckoutClick: (List<KutukuCartItem>) -> Unit = {}
) {
    val cartItems = remember { mutableStateListOf(*initialItems.toTypedArray()) }

    val totalAmount = cartItems
        .filter { it.isSelected }
        .sumOf { it.priceValue * it.quantity }

    Scaffold(
        modifier = modifier,
        bottomBar = {
            Surface(
                color = Color(WgcCoreDsColors.retailSurface),
                tonalElevation = 8.dp,
                shadowElevation = 8.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.lg.dp, vertical = WgcCoreDsSpacing.md.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Total amount",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color(WgcCoreDsColors.retailSecondaryText)
                        )
                        Text(
                            text = "$${String.format("%.2f", totalAmount)}",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.retailDark)
                        )
                    }

                    Button(
                        onClick = { onCheckoutClick(cartItems.toList()) },
                        modifier = Modifier
                            .height(52.dp)
                            .width(160.dp),
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(WgcCoreDsColors.retailPrimary)
                        )
                    ) {
                        Text(
                            text = "Checkout",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(WgcCoreDsColors.retailSurface))
                .padding(paddingValues)
        ) {
            // Top Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.md.dp, vertical = WgcCoreDsSpacing.sm.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Voltar",
                        tint = Color(WgcCoreDsColors.retailDark)
                    )
                }

                Text(
                    text = "My Cart",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.retailDark)
                )

                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.ShoppingBag,
                        contentDescription = "Carrinho",
                        tint = Color(WgcCoreDsColors.retailDark)
                    )
                }
            }

            // Lista de Itens
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(horizontal = WgcCoreDsSpacing.md.dp)
            ) {
                items(cartItems) { item ->
                    val index = cartItems.indexOf(item)
                    WgcRetailCartItemRow(
                        title = item.title,
                        colorVariant = item.colorVariant,
                        price = item.price,
                        quantity = item.quantity,
                        imageUrl = item.imageUrl,
                        isSelected = item.isSelected,
                        onSelectionChange = { checked ->
                            if (index >= 0) {
                                cartItems[index] = item.copy(isSelected = checked)
                            }
                        },
                        onQuantityChange = { qty ->
                            if (index >= 0) {
                                cartItems[index] = item.copy(quantity = qty)
                            }
                        }
                    )
                }
            }
        }
    }
}

/**
 * Tela de Pagamento oficial do Kutuku (WgcKutukuPaymentScreen).
 */
@Composable
fun WgcKutukuPaymentScreen(
    modifier: Modifier = Modifier,
    items: List<KutukuCartItem> = RetailMockData.sampleCartItems,
    addressTitle: String = "House",
    addressSubtitle: String = "5482 Adobe Falls Rd #15San Diego, California(CA), 92120",
    totalPrice: String = "$ 99.00",
    onBackClick: () -> Unit = {},
    onEditAddressClick: () -> Unit = {},
    onChangePaymentMethodClick: () -> Unit = {},
    onCheckoutNowClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier,
        bottomBar = {
            Surface(
                color = Color(WgcCoreDsColors.retailSurface),
                tonalElevation = 8.dp,
                shadowElevation = 8.dp
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.lg.dp, vertical = WgcCoreDsSpacing.md.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Total amount",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(WgcCoreDsColors.retailSecondaryText)
                        )
                        Text(
                            text = totalPrice,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.retailDark)
                        )
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))

                    Button(
                        onClick = onCheckoutNowClick,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(WgcCoreDsColors.retailPrimary)
                        )
                    ) {
                        Text(
                            text = "Checkout Now",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(WgcCoreDsColors.retailSurface))
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
                .padding(horizontal = WgcCoreDsSpacing.lg.dp)
        ) {
            // Top Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = WgcCoreDsSpacing.sm.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Voltar",
                        tint = Color(WgcCoreDsColors.retailDark)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Payment",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.retailDark)
                )
                Spacer(modifier = Modifier.weight(1f))
                Spacer(modifier = Modifier.size(48.dp))
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

            // Seção de Endereço
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Address",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.retailDark)
                )
                Text(
                    text = "Edit",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(WgcCoreDsColors.retailPrimary),
                    modifier = Modifier.clickable(onClick = onEditAddressClick)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

            // Card de Endereço com Mini Mapa
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xl.dp))
                    .background(Color(WgcCoreDsColors.retailBackground))
                    .padding(WgcCoreDsSpacing.md.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(68.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md.dp))
                        .background(Color(WgcCoreDsColors.retailPrimaryLight)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.retailAlertRed),
                        modifier = Modifier.size(32.dp)
                    )
                }

                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = addressTitle,
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.retailDark)
                    )
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxxs.dp))
                    Text(
                        text = addressSubtitle,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(WgcCoreDsColors.retailSecondaryText),
                        lineHeight = MaterialTheme.typography.bodySmall.lineHeight
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg.dp))

            // Produtos
            Text(
                text = "Products (${items.size})",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.retailDark)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

            items.forEach { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = WgcCoreDsSpacing.xs.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md.dp))
                            .background(Color(WgcCoreDsColors.retailBackground)),
                        contentAlignment = Alignment.Center
                    ) {
                        if (!item.imageUrl.isNullOrEmpty()) {
                            AsyncImageDefault(
                                image = item.imageUrl,
                                contentDescription = item.title,
                                modifier = Modifier.fillMaxSize()
                            )
                        } else {
                            Text(item.title.take(2))
                        }
                    }

                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = item.title,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.retailDark)
                        )
                        Text(
                            text = "Color: ${item.colorVariant}",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color(WgcCoreDsColors.retailSecondaryText)
                        )
                    }

                    Text(
                        text = item.price,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.retailDark)
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg.dp))

            // Seção de Método de Pagamento
            Text(
                text = "Payment Method",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.retailDark)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xl.dp))
                    .border(
                        width = 1.dp,
                        color = Color(WgcCoreDsColors.retailBorder),
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl.dp)
                    )
                    .clickable(onClick = onChangePaymentMethodClick)
                    .padding(WgcCoreDsSpacing.md.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(44.dp)
                            .clip(CircleShape)
                            .background(Color(WgcCoreDsColors.retailBackground)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.CreditCard,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.retailPrimary)
                        )
                    }

                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md.dp))

                    Column {
                        Text(
                            text = "Master Card",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.retailDark)
                        )
                        Text(
                            text = "**** **** 1234",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color(WgcCoreDsColors.retailSecondaryText)
                        )
                    }
                }

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                    contentDescription = null,
                    tint = Color(WgcCoreDsColors.retailSecondaryText),
                    modifier = Modifier.size(16.dp)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcKutukuCartScreenPreview() {
    WgcKutukuCartScreen()
}

@Preview(showBackground = true)
@Composable
private fun WgcKutukuPaymentScreenPreview() {
    WgcKutukuPaymentScreen()
}
