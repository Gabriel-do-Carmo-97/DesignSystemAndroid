package br.com.wgc.ds_templates.screens.apparel.cart

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcApparelCartItemCard
import br.com.wgc.ds_templates.screens.apparel.model.ClotheeCartItem
import br.com.wgc.ds_templates.screens.apparel.model.ApparelMockData

/**
 * Tela do carrinho do ecossistema Clothee (WgcClotheeCartTemplate).
 * Apresenta itens selecionados, campo de cupom com botão circular de aplicar,
 * detalhamento de subtotal/frete/impostos/total e CTA "Checkout".
 */
@Composable
fun WgcClotheeCartTemplate(
    modifier: Modifier = Modifier,
    cartItems: List<ClotheeCartItem> = ApparelMockData.cartItems,
    couponCode: String = "",
    shippingCost: Double = 8.0,
    taxCost: Double = 0.0,
    onCouponCodeChange: (String) -> Unit = {},
    onApplyCoupon: () -> Unit = {},
    onQuantityChange: (ClotheeCartItem, Int) -> Unit = { _, _ -> },
    onRemoveAll: () -> Unit = {},
    onCheckoutClick: () -> Unit = {},
    onBackClick: () -> Unit = {},
    customHeaderSlot: (@Composable () -> Unit)? = null,
    customBottomBarSlot: (@Composable () -> Unit)? = null
) {
    val subtotal = cartItems.sumOf { it.totalPrice }
    val total = subtotal + shippingCost + taxCost

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        bottomBar = {
            if (customBottomBarSlot != null) {
                customBottomBarSlot()
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(horizontal = WgcCoreDsSpacing.lg24.dp, vertical = WgcCoreDsSpacing.md16.dp)
                ) {
                    Button(
                        onClick = onCheckoutClick,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(54.dp),
                        shape = RoundedCornerShape(100.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(WgcCoreDsColors.apparelPrimary)
                        )
                    ) {
                        Text(
                            text = "Checkout",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        )
                    }
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            if (customHeaderSlot != null) {
                customHeaderSlot()
            } else {
                // Header com Voltar, título e botão "Remove All"
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.lg24.dp, vertical = WgcCoreDsSpacing.md16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = onBackClick,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(Color(WgcCoreDsColors.apparelSurface))
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar",
                            tint = Color(WgcCoreDsColors.apparelDark)
                        )
                    }

                    Text(
                        text = "Cart",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.apparelDark)
                    )

                    TextButton(onClick = onRemoveAll) {
                        Text(
                            text = "Remove All",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color(WgcCoreDsColors.apparelAlertRed)
                        )
                    }
                }
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = WgcCoreDsSpacing.lg24.dp),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
            ) {
                // Lista de itens do carrinho
                items(cartItems) { item ->
                    WgcApparelCartItemCard(
                        title = item.product.title,
                        size = item.size,
                        colorName = item.colorName,
                        price = item.product.price,
                        quantity = item.quantity,
                        imageUrl = item.product.imageUrl,
                        onQuantityChange = { newCount -> onQuantityChange(item, newCount) }
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                    // Campo de Cupom
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(100.dp))
                            .background(Color(WgcCoreDsColors.apparelSurface))
                            .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xxs4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        OutlinedTextField(
                            value = couponCode,
                            onValueChange = onCouponCodeChange,
                            modifier = Modifier.weight(1f),
                            placeholder = {
                                Text(
                                    text = "Enter Coupon Code",
                                    color = Color(WgcCoreDsColors.apparelSecondaryText)
                                )
                            },
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent,
                                focusedBorderColor = Color.Transparent,
                                unfocusedBorderColor = Color.Transparent
                            ),
                            singleLine = true
                        )

                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(Color(WgcCoreDsColors.apparelPrimary))
                                .clickable(onClick = onApplyCoupon),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                                contentDescription = "Aplicar Cupom",
                                tint = Color.White,
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }
                }

                item {
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                    // Detalhamento financeiro
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                    ) {
                        SummaryRow(title = "Subtotal", value = "$${"%.2f".format(subtotal)}")
                        SummaryRow(title = "Shipping Cost", value = "$${"%.2f".format(shippingCost)}")
                        SummaryRow(title = "Tax", value = "$${"%.2f".format(taxCost)}")

                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                        SummaryRow(
                            title = "Total",
                            value = "$${"%.2f".format(total)}",
                            isBold = true
                        )
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))
                }
            }
        }
    }
}

@Composable
private fun SummaryRow(
    title: String,
    value: String,
    isBold: Boolean = false
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            style = if (isBold) MaterialTheme.typography.titleMedium else MaterialTheme.typography.bodyMedium,
            fontWeight = if (isBold) FontWeight.Bold else FontWeight.Normal,
            color = if (isBold) Color(WgcCoreDsColors.apparelDark) else Color(WgcCoreDsColors.apparelSecondaryText)
        )
        Text(
            text = value,
            style = if (isBold) MaterialTheme.typography.titleMedium else MaterialTheme.typography.bodyMedium,
            fontWeight = if (isBold) FontWeight.Bold else FontWeight.Medium,
            color = Color(WgcCoreDsColors.apparelDark)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcClotheeCartTemplatePreview() {
    WgcClotheeCartTemplate()
}
