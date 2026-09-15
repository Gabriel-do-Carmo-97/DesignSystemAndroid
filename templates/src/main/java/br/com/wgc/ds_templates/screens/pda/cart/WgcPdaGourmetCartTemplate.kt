package br.com.wgc.ds_templates.screens.pda.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AcUnit
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.navigation.WgcPdaBottomNav
import br.com.wgc.ds_templates.screens.pda.model.PdaCartItem
import br.com.wgc.ds_templates.screens.pda.model.PdaMockData
import java.util.Locale

/**
 * Template da Tela de Carrinho Gourmet do Pão de Açúcar Mais.
 *
 * Apresenta itens da cesta, controle de substituição inteligente de produtos faltantes,
 * opção de embalagem térmica para vinhos/queijos, cálculo de economia Cliente Mais e checkout.
 */
@Composable
fun WgcPdaGourmetCartTemplate(
    modifier: Modifier = Modifier,
    cartItems: List<PdaCartItem> = PdaMockData.cartItems,
    selectedNavIndex: Int = 3,
    onNavSelect: (Int) -> Unit = {},
    onQuantityChange: (String, Int) -> Unit = { _, _ -> },
    onCheckoutClick: () -> Unit = {},
    headerSlot: (@Composable () -> Unit)? = null,
    footerSlot: (@Composable () -> Unit)? = null
) {
    var includeThermalBag by remember { mutableStateOf(true) }

    val subtotalRegular = cartItems.sumOf { it.product.originalPrice * it.quantity }
    val subtotalMais = cartItems.sumOf { it.product.clienteMaisPrice * it.quantity }
    val totalDiscount = subtotalRegular - subtotalMais
    val deliveryFee = 0.00 // Grátis para Cliente Mais Black
    val finalTotal = subtotalMais + deliveryFee

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            footerSlot?.invoke() ?: WgcPdaBottomNav(
                selectedItem = selectedNavIndex,
                onItemSelected = onNavSelect
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Header da Cesta
            item {
                headerSlot?.invoke() ?: Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(WgcCoreDsColors.pdaSurface))
                        .padding(WgcCoreDsSpacing.md16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.ShoppingBag,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.pdaGreenDark),
                                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                            )
                            Text(
                                text = "MINHA CESTA GOURMET",
                                color = Color(WgcCoreDsColors.pdaGreenDark),
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Text(
                            text = "${cartItems.sumOf { it.quantity }} itens",
                            color = Color(WgcCoreDsColors.pdaTextSecondary),
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }

            // Lista de Itens no Carrinho
            items(cartItems) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(WgcCoreDsColors.pdaSurface)
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = WgcCoreDsElevation.level1.dp
                    ),
                    border = androidx.compose.foundation.BorderStroke(
                        width = WgcCoreDsSize.s1.dp,
                        color = Color(WgcCoreDsColors.pdaBorder)
                    )
                ) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.sm12.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            // Mock Icon
                            Box(
                                modifier = Modifier
                                    .size(WgcCoreDsSize.s56.dp)
                                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                    .background(Color(WgcCoreDsColors.pdaBackground)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ShoppingBag,
                                    contentDescription = null,
                                    tint = Color(WgcCoreDsColors.pdaGreen),
                                    modifier = Modifier.size(WgcCoreDsSize.s28.dp)
                                )
                            }

                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = item.product.title,
                                    color = Color(WgcCoreDsColors.pdaTextPrimary),
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.Bold,
                                    maxLines = 2
                                )
                                Text(
                                    text = "${item.product.brandOrOrigin} • ${item.product.unit}",
                                    color = Color(WgcCoreDsColors.pdaTextSecondary),
                                    style = MaterialTheme.typography.labelSmall
                                )
                                Text(
                                    text = String.format(Locale.GERMANY, "R$ %.2f un", item.product.clienteMaisPrice),
                                    color = Color(WgcCoreDsColors.pdaGreenDark),
                                    style = MaterialTheme.typography.bodySmall,
                                    fontWeight = FontWeight.Bold
                                )
                            }

                            // Stepper de Quantidade
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                    .border(
                                        width = WgcCoreDsSize.s1.dp,
                                        color = Color(WgcCoreDsColors.pdaBorder),
                                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp)
                                    )
                            ) {
                                IconButton(
                                    onClick = { onQuantityChange(item.product.id, item.quantity - 1) },
                                    modifier = Modifier.size(WgcCoreDsSize.s28.dp)
                                ) {
                                    Icon(
                                        imageVector = if (item.quantity == 1) Icons.Default.Delete else Icons.Default.Remove,
                                        contentDescription = "Diminuir",
                                        tint = Color(WgcCoreDsColors.pdaTextSecondary),
                                        modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                                    )
                                }

                                Text(
                                    text = "${item.quantity}",
                                    color = Color(WgcCoreDsColors.pdaTextPrimary),
                                    style = MaterialTheme.typography.bodySmall,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.xs8.dp)
                                )

                                IconButton(
                                    onClick = { onQuantityChange(item.product.id, item.quantity + 1) },
                                    modifier = Modifier.size(WgcCoreDsSize.s28.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Add,
                                        contentDescription = "Aumentar",
                                        tint = Color(WgcCoreDsColors.pdaGreenDark),
                                        modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                        // Regra de Substituição
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                .background(Color(WgcCoreDsColors.pdaBackground))
                                .padding(horizontal = WgcCoreDsSpacing.xs8.dp, vertical = WgcCoreDsSpacing.xxs4.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.SwapHoriz,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.pdaGreenDark),
                                modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                            )
                            Text(
                                text = "Substituição: ${item.substitutionPreference}",
                                color = Color(WgcCoreDsColors.pdaTextSecondary),
                                style = MaterialTheme.typography.labelSmall
                            )
                        }
                    }
                }
            }

            // Opção Gourmet: Embalagem Térmica Climatizada
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(WgcCoreDsColors.pdaSurface)
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = WgcCoreDsElevation.level1.dp
                    ),
                    border = androidx.compose.foundation.BorderStroke(
                        width = WgcCoreDsSize.s1.dp,
                        color = Color(WgcCoreDsColors.pdaBorder)
                    )
                ) {
                    Row(
                        modifier = Modifier.padding(WgcCoreDsSpacing.sm12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(
                                imageVector = Icons.Default.AcUnit,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.pdaWineRed),
                                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                            )
                            Column {
                                Text(
                                    text = "Bolsa Térmica Especial para Vinhos/Queijos",
                                    color = Color(WgcCoreDsColors.pdaTextPrimary),
                                    style = MaterialTheme.typography.bodySmall,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "Grátis para Cliente Mais Black",
                                    color = Color(WgcCoreDsColors.pdaGoldDark),
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                        }

                        Switch(
                            checked = includeThermalBag,
                            onCheckedChange = { includeThermalBag = it },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = Color.White,
                                checkedTrackColor = Color(WgcCoreDsColors.pdaGreenDark)
                            )
                        )
                    }
                }
            }

            // Resumo de Preço & Economia
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(WgcCoreDsColors.pdaSurface)
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = WgcCoreDsElevation.level1.dp
                    ),
                    border = androidx.compose.foundation.BorderStroke(
                        width = WgcCoreDsSize.s1.dp,
                        color = Color(WgcCoreDsColors.pdaBorder)
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
                        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                    ) {
                        Text(
                            text = "RESUMO DO PEDIDO",
                            color = Color(WgcCoreDsColors.pdaTextPrimary),
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Subtotal dos produtos",
                                color = Color(WgcCoreDsColors.pdaTextSecondary),
                                style = MaterialTheme.typography.bodySmall
                            )
                            Text(
                                text = String.format(Locale.GERMANY, "R$ %.2f", subtotalRegular),
                                color = Color(WgcCoreDsColors.pdaTextSecondary),
                                style = MaterialTheme.typography.bodySmall
                            )
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Desconto Cliente Mais",
                                color = Color(WgcCoreDsColors.pdaGreenDark),
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = String.format(Locale.GERMANY, "- R$ %.2f", totalDiscount),
                                color = Color(WgcCoreDsColors.pdaGreenDark),
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Entrega Climatizada Express",
                                color = Color(WgcCoreDsColors.pdaTextSecondary),
                                style = MaterialTheme.typography.bodySmall
                            )
                            Text(
                                text = "GRÁTIS (VIP Black)",
                                color = Color(WgcCoreDsColors.pdaGoldDark),
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(WgcCoreDsSize.s1.dp)
                                .background(Color(WgcCoreDsColors.pdaBorder))
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Total a Pagar",
                                color = Color(WgcCoreDsColors.pdaTextPrimary),
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = String.format(Locale.GERMANY, "R$ %.2f", finalTotal),
                                color = Color(WgcCoreDsColors.pdaGreenDark),
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Black
                            )
                        }
                    }
                }
            }

            // Botão Checkout
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = WgcCoreDsSpacing.md16.dp,
                            vertical = WgcCoreDsSpacing.md16.dp
                        )
                ) {
                    Button(
                        onClick = onCheckoutClick,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(WgcCoreDsSize.s48.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(WgcCoreDsColors.pdaGreenDark)
                        ),
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = null,
                            modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                        )
                        Spacer(modifier = Modifier.size(WgcCoreDsSpacing.xs8.dp))
                        Text(
                            text = "FINALIZAR COMPRA GOURMET",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Preview(name = "PDA Cart Template", showBackground = true)
@Composable
private fun WgcPdaGourmetCartTemplatePreview() {
    WgcPdaGourmetCartTemplate()
}
