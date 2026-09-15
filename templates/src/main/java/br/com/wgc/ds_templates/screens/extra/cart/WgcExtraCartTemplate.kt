package br.com.wgc.ds_templates.screens.extra.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import br.com.wgc.design_system.components.navigation.WgcExtraBottomNav
import br.com.wgc.design_system.components.navigation.WgcExtraNavItem
import br.com.wgc.ds_templates.screens.extra.model.ExtraCartItem
import br.com.wgc.ds_templates.screens.extra.model.ExtraMockData

/**
 * Template do Carrinho de Supermercado e Economômetro do Clube Extra.
 *
 * Apresenta o somatório de itens, substituição inteligente de faltas,
 * cálculo em tempo real da economia exclusiva Clube Extra e fechamento de pedido.
 *
 * 100% tokenizado com WgcCoreDs e State Hoisting.
 */
@Composable
fun WgcExtraCartTemplate(
    cartItems: List<ExtraCartItem>,
    modifier: Modifier = Modifier,
    deliveryFee: String = "R$ 9,90",
    totalSavings: String = "R$ 42,40",
    totalAmount: String = "R$ 132,20",
    onIncrementItem: (ExtraCartItem) -> Unit = {},
    onDecrementItem: (ExtraCartItem) -> Unit = {},
    onCheckoutClick: () -> Unit = {},
    selectedNavItem: WgcExtraNavItem = WgcExtraNavItem.CART,
    onNavItemClick: (WgcExtraNavItem) -> Unit = {},
    slotHeader: (@Composable () -> Unit)? = null,
    slotBottomNav: (@Composable () -> Unit)? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            if (slotBottomNav != null) {
                slotBottomNav()
            } else {
                WgcExtraBottomNav(
                    selectedItem = selectedNavItem,
                    onItemSelected = onNavItemClick
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            // Header
            item {
                if (slotHeader != null) {
                    slotHeader()
                } else {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = WgcCoreDsSpacing.md16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "MEU CARRINHO",
                                color = Color(WgcCoreDsColors.extraRed),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Black,
                                letterSpacing = 1.sp
                            )
                            Text(
                                text = "Itens Selecionados",
                                color = Color(WgcCoreDsColors.extraDark),
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Black
                            )
                        }

                        Text(
                            text = "${cartItems.sumOf { it.quantity }} itens",
                            color = Color(WgcCoreDsColors.extraSecondaryText),
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }

            // Banner do Economômetro Clube Extra
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.extraYellowLight)),
                    border = androidx.compose.foundation.BorderStroke(
                        width = WgcCoreDsSize.s1.dp,
                        color = Color(WgcCoreDsColors.extraYellow)
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(
                                text = "ECONOMIA CLUBE EXTRA",
                                color = Color(WgcCoreDsColors.extraRed),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Black,
                                letterSpacing = 0.5.sp
                            )
                            Text(
                                text = "Você está economizando $totalSavings",
                                color = Color(WgcCoreDsColors.extraDark),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Black
                            )
                            Text(
                                text = "Descontos aplicados automaticamente pelo seu CPF",
                                color = Color(WgcCoreDsColors.extraSecondaryText),
                                fontSize = 11.sp
                            )
                        }
                    }
                }
            }

            // Critério de Substituição de Faltas
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.extraSurface)),
                    border = androidx.compose.foundation.BorderStroke(
                        width = WgcCoreDsSize.s1.dp,
                        color = Color(WgcCoreDsColors.extraBorder)
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.SwapHoriz,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.extraBlue),
                            modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                        )
                        Column {
                            Text(
                                text = "Substituição Inteligente de Faltas",
                                color = Color(WgcCoreDsColors.extraDark),
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Caso algum item falte na gôndola, substituiremos por similar da mesma qualidade ou superior.",
                                color = Color(WgcCoreDsColors.extraSecondaryText),
                                fontSize = 11.sp,
                                lineHeight = 15.sp
                            )
                        }
                    }
                }
            }

            // Lista de Itens do Carrinho
            items(cartItems, key = { it.product.id }) { cartItem ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.extraSurface)),
                    border = androidx.compose.foundation.BorderStroke(
                        width = WgcCoreDsSize.s1.dp,
                        color = Color(WgcCoreDsColors.extraBorder)
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.sm12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = cartItem.product.name,
                                color = Color(WgcCoreDsColors.extraDark),
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "${cartItem.product.unitDescription} • ${cartItem.product.clubPrice}",
                                color = Color(WgcCoreDsColors.extraSecondaryText),
                                fontSize = 11.sp
                            )
                        }

                        // Stepper de Quantidade
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                        ) {
                            IconButton(
                                onClick = { onDecrementItem(cartItem) },
                                modifier = Modifier.size(WgcCoreDsSize.s28.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Remove,
                                    contentDescription = "Diminuir",
                                    tint = Color(WgcCoreDsColors.extraRed),
                                    modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                                )
                            }

                            Text(
                                text = "${cartItem.quantity}",
                                color = Color(WgcCoreDsColors.extraDark),
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold
                            )

                            IconButton(
                                onClick = { onIncrementItem(cartItem) },
                                modifier = Modifier.size(WgcCoreDsSize.s28.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = "Aumentar",
                                    tint = Color(WgcCoreDsColors.extraRed),
                                    modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                                )
                            }
                        }
                    }
                }
            }

            // Resumo de Valores e Checkout
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.extraSurface)),
                    border = androidx.compose.foundation.BorderStroke(
                        width = WgcCoreDsSize.s1.dp,
                        color = Color(WgcCoreDsColors.extraBorder)
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp),
                        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Entrega Expressa",
                                color = Color(WgcCoreDsColors.extraSecondaryText),
                                fontSize = 12.sp
                            )
                            Text(
                                text = deliveryFee,
                                color = Color(WgcCoreDsColors.extraDark),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Descontos Clube Extra",
                                color = Color(WgcCoreDsColors.extraSuccessGreen),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "- $totalSavings",
                                color = Color(WgcCoreDsColors.extraSuccessGreen),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(WgcCoreDsSize.s1.dp)
                                .background(Color(WgcCoreDsColors.extraBorder))
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "TOTAL A PAGAR",
                                color = Color(WgcCoreDsColors.extraDark),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Black
                            )
                            Text(
                                text = totalAmount,
                                color = Color(WgcCoreDsColors.extraRed),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Black
                            )
                        }

                        Button(
                            onClick = onCheckoutClick,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = WgcCoreDsSpacing.xs8.dp)
                                .height(WgcCoreDsSize.s48.dp),
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(WgcCoreDsColors.extraRed),
                                contentColor = Color.White
                            )
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.LocalShipping,
                                    contentDescription = null,
                                    modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                                )
                                Text(
                                    text = "FINALIZAR COMPRA",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Black,
                                    letterSpacing = 0.5.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(name = "Clube Extra Cart Template - Preview")
@Composable
fun WgcExtraCartTemplatePreview() {
    WgcExtraCartTemplate(
        cartItems = listOf(
            ExtraCartItem(ExtraMockData.mockProducts[0], 1),
            ExtraCartItem(ExtraMockData.mockProducts[1], 2),
            ExtraCartItem(ExtraMockData.mockProducts[2], 6)
        )
    )
}
