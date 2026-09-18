package br.com.wgc.ds_templates.screens.freshgrocery.cart

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
import androidx.compose.material.icons.filled.DeleteOutline
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import br.com.wgc.ds_templates.screens.freshgrocery.model.FreshGroceryCartItem
import br.com.wgc.ds_templates.screens.freshgrocery.model.FreshGroceryMockData

/**
 * Tela de Carrinho / Checkout Fresh Grocery:
 * - Lista de itens no carrinho com controle de quantidade (+/-) e botão remover
 * - Campo de cupom de desconto com botão "Apply"
 * - Resumo financeiro (Subtotal, Desconto, Entrega, Total)
 * - Botão de Checkout fixo no rodapé
 */
@Composable
fun WgcFreshGroceryCartTemplate(
    cartItems: List<FreshGroceryCartItem> = listOf(
        FreshGroceryCartItem(FreshGroceryMockData.products[0], quantity = 1),
        FreshGroceryCartItem(FreshGroceryMockData.products[1], quantity = 2)
    ),
    promoCode: String = "",
    onPromoCodeChange: (String) -> Unit = {},
    onApplyPromo: () -> Unit = {},
    onIncrement: (FreshGroceryCartItem) -> Unit = {},
    onDecrement: (FreshGroceryCartItem) -> Unit = {},
    onRemoveItem: (FreshGroceryCartItem) -> Unit = {},
    onBackClick: () -> Unit = {},
    onCheckoutClick: () -> Unit = {},
    bottomBarSlot: (@Composable () -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        bottomBar = {
            if (bottomBarSlot != null) {
                bottomBarSlot()
            } else {
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
                                text = "Total",
                                style = MaterialTheme.typography.titleMedium,
                                color = Color(WgcCoreDsColors.megaStorerSecondaryText)
                            )
                            Text(
                                text = "$114.00",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                color = Color(WgcCoreDsColors.megaStorerDark)
                            )
                        }

                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

                        Button(
                            onClick = onCheckoutClick,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(WgcCoreDsColors.megaStorerPrimary),
                                contentColor = Color.White
                            ),
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(WgcCoreDsSize.s56.dp)
                        ) {
                            Text(
                                text = "Proceed to Checkout",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                        }
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
            // TopBar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = WgcCoreDsSpacing.md16.dp,
                        vertical = WgcCoreDsSpacing.xs8.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color(WgcCoreDsColors.megaStorerDark)
                    )
                }

                Text(
                    text = "My Cart",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.megaStorerDark)
                )

                Spacer(modifier = Modifier.size(WgcCoreDsSize.s40.dp))
            }

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = WgcCoreDsSpacing.lg24.dp)
            ) {
                items(cartItems) { item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = WgcCoreDsSpacing.sm12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Imagem Placeholder
                        Box(
                            modifier = Modifier
                                .size(WgcCoreDsSize.s72.dp)
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                                .background(Color(WgcCoreDsColors.megaStorerSurface)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "👕", style = MaterialTheme.typography.titleLarge)
                        }

                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md16.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = item.product.title,
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold,
                                color = Color(WgcCoreDsColors.megaStorerDark),
                                maxLines = 1
                            )

                            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))

                            Text(
                                text = "${item.selectedColor} | Size ${item.selectedSize}",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(WgcCoreDsColors.megaStorerSecondaryText)
                            )

                            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                            Text(
                                text = item.product.price,
                                style = MaterialTheme.typography.labelLarge,
                                fontWeight = FontWeight.Bold,
                                color = Color(WgcCoreDsColors.megaStorerPrimary)
                            )
                        }

                        // Controles de Quantidade
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(WgcCoreDsSize.s28.dp)
                                    .clip(CircleShape)
                                    .background(Color(WgcCoreDsColors.megaStorerSurface))
                                    .clickable { onDecrement(item) },
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Remove,
                                    contentDescription = "Decrement",
                                    tint = Color(WgcCoreDsColors.megaStorerDark),
                                    modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                                )
                            }

                            Text(
                                text = item.quantity.toString(),
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold,
                                color = Color(WgcCoreDsColors.megaStorerDark)
                            )

                            Box(
                                modifier = Modifier
                                    .size(WgcCoreDsSize.s28.dp)
                                    .clip(CircleShape)
                                    .background(Color(WgcCoreDsColors.megaStorerPrimary))
                                    .clickable { onIncrement(item) },
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = "Increment",
                                    tint = Color.White,
                                    modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                                )
                            }
                        }
                    }

                    HorizontalDivider(color = Color(WgcCoreDsColors.megaStorerBorder))
                }

                // Cupom de Desconto
                item {
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        OutlinedTextField(
                            value = promoCode,
                            onValueChange = onPromoCodeChange,
                            modifier = Modifier
                                .weight(1f)
                                .height(WgcCoreDsSize.s48.dp),
                            placeholder = {
                                Text(
                                    text = "Promo code",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = Color(WgcCoreDsColors.megaStorerSecondaryText)
                                )
                            },
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color(WgcCoreDsColors.megaStorerPrimary),
                                unfocusedBorderColor = Color(WgcCoreDsColors.megaStorerBorder)
                            ),
                            singleLine = true
                        )

                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))

                        Button(
                            onClick = onApplyPromo,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(WgcCoreDsColors.megaStorerPrimary),
                                contentColor = Color.White
                            ),
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                            modifier = Modifier.height(WgcCoreDsSize.s48.dp)
                        ) {
                            Text(
                                text = "Apply",
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))
                }

                // Resumo do Pedido
                item {
                    Text(
                        text = "Order Summary",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.megaStorerDark)
                    )

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Subtotal",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(WgcCoreDsColors.megaStorerSecondaryText)
                        )
                        Text(
                            text = "$114.00",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(WgcCoreDsColors.megaStorerDark)
                        )
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Shipping Fee",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(WgcCoreDsColors.megaStorerSecondaryText)
                        )
                        Text(
                            text = "Free",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.megaStorerSuccessGreen)
                        )
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcFreshGroceryCartTemplatePreview() {
    WgcFreshGroceryCartTemplate()
}
