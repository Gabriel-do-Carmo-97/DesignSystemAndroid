package br.com.wgc.ds_templates.screens.quickshop.checkout

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
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.ds_templates.screens.quickshop.model.ShopEaseCartItem
import br.com.wgc.ds_templates.screens.quickshop.model.ShopEaseMockData

/**
 * Tela Confirm Order / Checkout ShopEase:
 * - Curva superior laranja com título "Confirm Order"
 * - Lista de produtos em cards arredondados
 * - Seleção de método de pagamento
 * - Resumo financeiro (Subtotal, Shipping, Total)
 * - Botão "Confirm Order" sunset orange
 */
@Composable
fun WgcShopEaseCheckoutTemplate(
    cartItems: List<ShopEaseCartItem> = ShopEaseMockData.cartItems,
    selectedPaymentMethod: String = "MasterCard",
    onPaymentMethodSelect: (String) -> Unit = {},
    onIncrement: (ShopEaseCartItem) -> Unit = {},
    onDecrement: (ShopEaseCartItem) -> Unit = {},
    onBackClick: () -> Unit = {},
    onConfirmOrderClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        bottomBar = {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shadowElevation = WgcCoreDsElevation.level3.dp,
                color = Color.White
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .navigationBarsPadding()
                        .padding(WgcCoreDsSpacing.lg24.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Total Amount",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color(WgcCoreDsColors.quickShopSecondaryText)
                        )
                        Text(
                            text = "$119.00",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(WgcCoreDsColors.quickShopPrimaryDark)
                        )
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

                    Button(
                        onClick = onConfirmOrderClick,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(WgcCoreDsColors.quickShopPrimary),
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(WgcCoreDsSize.s56.dp)
                    ) {
                        Text(
                            text = "Confirm Order",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Header com Curva Sunset
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            bottomStart = WgcCoreDsBorderRadius.xxl24.dp,
                            bottomEnd = WgcCoreDsBorderRadius.xxl24.dp
                        )
                    )
                    .background(Color(WgcCoreDsColors.quickShopPrimary))
                    .padding(
                        horizontal = WgcCoreDsSpacing.lg24.dp,
                        vertical = WgcCoreDsSpacing.md16.dp
                    )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = onBackClick,
                        modifier = Modifier
                            .size(WgcCoreDsSize.s40.dp)
                            .clip(CircleShape)
                            .background(Color.White.copy(alpha = 0.2f))
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md16.dp))

                    Text(
                        text = "Confirm Order",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = WgcCoreDsSpacing.lg24.dp)
            ) {
                // Lista de Itens
                items(cartItems) { item ->
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                            .background(item.product.backgroundColor)
                            .padding(WgcCoreDsSpacing.md16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "👟",
                            style = MaterialTheme.typography.headlineMedium
                        )

                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md16.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = item.product.title,
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold,
                                color = Color(WgcCoreDsColors.quickShopDark)
                            )
                            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                            Text(
                                text = "Size: ${item.selectedSize} | Color: ${item.selectedColor}",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(WgcCoreDsColors.quickShopSecondaryText)
                            )
                            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
                            Text(
                                text = item.product.price,
                                style = MaterialTheme.typography.labelLarge,
                                fontWeight = FontWeight.Bold,
                                color = Color(WgcCoreDsColors.quickShopPrimaryDark)
                            )
                        }

                        // Quantidade
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(WgcCoreDsSize.s24.dp)
                                    .clip(CircleShape)
                                    .background(Color.White)
                                    .clickable { onDecrement(item) },
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Remove,
                                    contentDescription = "Remove",
                                    tint = Color(WgcCoreDsColors.quickShopDark),
                                    modifier = Modifier.size(WgcCoreDsSize.s12.dp)
                                )
                            }

                            Text(
                                text = item.quantity.toString(),
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold
                            )

                            Box(
                                modifier = Modifier
                                    .size(WgcCoreDsSize.s24.dp)
                                    .clip(CircleShape)
                                    .background(Color.White)
                                    .clickable { onIncrement(item) },
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = "Add",
                                    tint = Color(WgcCoreDsColors.quickShopDark),
                                    modifier = Modifier.size(WgcCoreDsSize.s12.dp)
                                )
                            }
                        }
                    }
                }

                // Método de Pagamento
                item {
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

                    Text(
                        text = "Payment Method",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.quickShopDark)
                    )

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                            .background(Color(WgcCoreDsColors.quickShopSurface))
                            .padding(WgcCoreDsSpacing.md16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.CreditCard,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.quickShopPrimary),
                            modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                        )

                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md16.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "MasterCard",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold,
                                color = Color(WgcCoreDsColors.quickShopDark)
                            )
                            Text(
                                text = "**** **** **** 4321",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(WgcCoreDsColors.quickShopSecondaryText)
                            )
                        }

                        Text(
                            text = "Change",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.quickShopPrimary),
                            modifier = Modifier.clickable { /* change payment */ }
                        )
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))
                }

                // Resumo do Pedido
                item {
                    Text(
                        text = "Order Breakdown",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.quickShopDark)
                    )

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Subtotal",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(WgcCoreDsColors.quickShopSecondaryText)
                        )
                        Text(
                            text = "$119.00",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(WgcCoreDsColors.quickShopDark)
                        )
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Delivery Fee",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(WgcCoreDsColors.quickShopSecondaryText)
                        )
                        Text(
                            text = "Free",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.quickShopSuccessGreen)
                        )
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcShopEaseCheckoutTemplatePreview() {
    WgcShopEaseCheckoutTemplate()
}
