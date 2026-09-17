package br.com.wgc.ds_templates.screens.boutique.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcBoutiqueBottomNavButton
import br.com.wgc.design_system.components.cards.WgcBoutiqueCartItemRow
import br.com.wgc.ds_templates.screens.boutique.model.LazaAddress
import br.com.wgc.ds_templates.screens.boutique.model.LazaCartItem
import br.com.wgc.ds_templates.screens.boutique.model.BoutiqueMockData
import br.com.wgc.ds_templates.screens.boutique.model.LazaPaymentCard

/**
 * Tela de carrinho e resumo oficial do Laza (WgcLazaCartTemplate).
 * Apresenta Top Bar com título centralizado, lista de produtos no carrinho,
 * cartão de endereço de entrega, método de pagamento selecionado, detalhamento de preços
 * e botão inferior fixo de checkout.
 */
@Composable
fun WgcLazaCartTemplate(
    modifier: Modifier = Modifier,
    items: List<LazaCartItem> = BoutiqueMockData.cartItems,
    address: LazaAddress = BoutiqueMockData.defaultAddress,
    paymentCard: LazaPaymentCard = BoutiqueMockData.defaultCard,
    subtotal: String = "$110",
    shippingCost: String = "$10",
    totalCost: String = "$120",
    onBackClick: () -> Unit = {},
    onIncreaseQuantity: (LazaCartItem) -> Unit = {},
    onDecreaseQuantity: (LazaCartItem) -> Unit = {},
    onDeleteItem: (LazaCartItem) -> Unit = {},
    onAddressClick: () -> Unit = {},
    onPaymentMethodClick: () -> Unit = {},
    onCheckoutClick: () -> Unit = {},
    customAddressSlot: (@Composable () -> Unit)? = null,
    customPaymentSlot: (@Composable () -> Unit)? = null,
    customBottomBarSlot: (@Composable () -> Unit)? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        bottomBar = {
            if (customBottomBarSlot != null) {
                customBottomBarSlot()
            } else {
                WgcBoutiqueBottomNavButton(
                    label = "Checkout",
                    onClick = onCheckoutClick
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {
            // Top Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = WgcCoreDsSpacing.lg24.dp,
                        vertical = WgcCoreDsSpacing.md16.dp
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier
                        .size(WgcCoreDsSize.s44.dp)
                        .clip(CircleShape)
                        .background(Color(WgcCoreDsColors.boutiqueSurface))
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Voltar",
                        tint = Color(WgcCoreDsColors.boutiqueDark),
                        modifier = Modifier.size(WgcCoreDsSize.s22.dp)
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "Cart",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.boutiqueDark)
                )

                Spacer(modifier = Modifier.weight(1f))

                // Spacer balanceador do botão de voltar
                Spacer(modifier = Modifier.size(WgcCoreDsSize.s44.dp))
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            // Lista de Itens do Carrinho
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.lg24.dp),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
            ) {
                items.forEach { cartItem ->
                    WgcBoutiqueCartItemRow(
                        title = cartItem.product.title,
                        price = cartItem.product.price,
                        taxInfo = cartItem.taxInfo,
                        quantity = cartItem.quantity,
                        imageUrl = cartItem.product.imageUrl,
                        onIncreaseQuantity = { onIncreaseQuantity(cartItem) },
                        onDecreaseQuantity = { onDecreaseQuantity(cartItem) },
                        onDeleteClick = { onDeleteItem(cartItem) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            // Delivery Address
            if (customAddressSlot != null) {
                customAddressSlot()
            } else {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.lg24.dp)
                ) {
                    Text(
                        text = "Delivery Address",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.boutiqueDark)
                    )

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                            .background(Color(WgcCoreDsColors.boutiqueSurface))
                            .clickable(onClick = onAddressClick)
                            .padding(WgcCoreDsSpacing.md16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(WgcCoreDsSize.s44.dp)
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                .background(Color.White),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.LocationOn,
                                contentDescription = "Endereço",
                                tint = Color(WgcCoreDsColors.boutiquePrimary),
                                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = address.city,
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold,
                                color = Color(WgcCoreDsColors.boutiqueDark)
                            )
                            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxxs2.dp))
                            Text(
                                text = address.country,
                                style = MaterialTheme.typography.labelSmall,
                                color = Color(WgcCoreDsColors.boutiqueSecondaryText)
                            )
                        }

                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                            contentDescription = "Alterar endereço",
                            tint = Color(WgcCoreDsColors.boutiqueSecondaryText),
                            modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            // Payment Method
            if (customPaymentSlot != null) {
                customPaymentSlot()
            } else {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.lg24.dp)
                ) {
                    Text(
                        text = "Payment Method",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.boutiqueDark)
                    )

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                            .background(Color(WgcCoreDsColors.boutiqueSurface))
                            .clickable(onClick = onPaymentMethodClick)
                            .padding(WgcCoreDsSpacing.md16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(WgcCoreDsSize.s44.dp)
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                .background(Color.White),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.CreditCard,
                                contentDescription = "Cartão de pagamento",
                                tint = Color(WgcCoreDsColors.boutiquePrimary),
                                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = paymentCard.cardType,
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold,
                                color = Color(WgcCoreDsColors.boutiqueDark)
                            )
                            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxxs2.dp))
                            Text(
                                text = paymentCard.cardNumber,
                                style = MaterialTheme.typography.labelSmall,
                                color = Color(WgcCoreDsColors.boutiqueSecondaryText)
                            )
                        }

                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                            contentDescription = "Alterar cartão",
                            tint = Color(WgcCoreDsColors.boutiqueSecondaryText),
                            modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            // Order Info (Price Breakdown)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.lg24.dp)
            ) {
                Text(
                    text = "Order Info",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.boutiqueDark)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Subtotal",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(WgcCoreDsColors.boutiqueSecondaryText)
                    )
                    Text(
                        text = subtotal,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.boutiqueDark)
                    )
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Shipping Cost",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(WgcCoreDsColors.boutiqueSecondaryText)
                    )
                    Text(
                        text = shippingCost,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.boutiqueDark)
                    )
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Total",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.boutiqueDark)
                    )
                    Text(
                        text = totalCost,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.boutiqueDark)
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcLazaCartTemplatePreview() {
    WgcLazaCartTemplate()
}
