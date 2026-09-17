package br.com.wgc.ds_templates.screens.gadgetshop.cart

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.FlashOn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcGadgetShopCartItemRow
import br.com.wgc.ds_templates.screens.gadgetshop.model.NexkartCartItem
import br.com.wgc.ds_templates.screens.gadgetshop.model.GadgetShopMockData

/**
 * Tela de Carrinho de Compras oficial do ecossistema Nexkart (WgcNexkartCartTemplate).
 * Apresenta cabeçalho "My Cart" com badge de contagem rosa, banner de cupom de desconto,
 * seção Flash Sales com countdown, lista de itens com botões de incremento/decremento e CTA de checkout.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcNexkartCartTemplate(
    modifier: Modifier = Modifier,
    cartItems: List<NexkartCartItem> = GadgetShopMockData.initialCart,
    subtotal: String = "USD 271.00",
    discount: String = "- USD 20.00",
    total: String = "USD 251.00",
    onQuantityChange: (NexkartCartItem, Int) -> Unit = { _, _ -> },
    onRemoveItem: (NexkartCartItem) -> Unit = {},
    onCheckoutClick: () -> Unit = {},
    onBackClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "My Cart",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.gadgetShopDark)
                        )
                        Spacer(modifier = Modifier.padding(start = WgcCoreDsSpacing.xs8.dp))
                        Box(
                            modifier = Modifier
                                .size(22.dp)
                                .clip(CircleShape)
                                .background(Color(WgcCoreDsColors.gadgetShopAccentPink)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = cartItems.size.toString(),
                                style = MaterialTheme.typography.labelSmall,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar",
                            tint = Color(WgcCoreDsColors.gadgetShopDark)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        },
        bottomBar = {
            Surface(
                color = Color.White,
                shadowElevation = 8.dp
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.sm12.dp)
                ) {
                    // Discriminação de Subtotal e Desconto
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Subtotal",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(WgcCoreDsColors.gadgetShopSecondaryText)
                        )
                        Text(
                            text = subtotal,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(WgcCoreDsColors.gadgetShopDark)
                        )
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Discount",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(WgcCoreDsColors.gadgetShopSecondaryText)
                        )
                        Text(
                            text = discount,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(WgcCoreDsColors.gadgetShopAccentPink)
                        )
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Total",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.gadgetShopDark)
                        )
                        Text(
                            text = total,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.gadgetShopPrimary)
                        )
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

                    // Botão de Checkout
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp))
                            .background(Color(WgcCoreDsColors.gadgetShopPrimary))
                            .clickable(onClick = onCheckoutClick),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Checkout",
                            style = MaterialTheme.typography.titleSmall,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.sm12.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
        ) {
            // Banner Promocional ("NEW YEAR, NEW ME - BEST DEALS UP TO 80% OFF")
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp))
                        .background(
                            Brush.horizontalGradient(
                                colors = listOf(
                                    Color(WgcCoreDsColors.gadgetShopPrimary),
                                    Color(WgcCoreDsColors.gadgetShopPrimaryDark)
                                )
                            )
                        )
                        .padding(WgcCoreDsSpacing.md16.dp)
                ) {
                    Column {
                        Text(
                            text = "NEW YEAR, NEW ME",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.gadgetShopGold)
                        )
                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                        Text(
                            text = "BEST DEALS UP TO 80% OFF",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }

            // Seção Flash Sales com Timer
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = WgcCoreDsSpacing.xs8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                .background(Color(WgcCoreDsColors.gadgetShopAccentPink))
                                .padding(horizontal = WgcCoreDsSpacing.xs8.dp, vertical = WgcCoreDsSpacing.xxxs2.dp)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.FlashOn,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(14.dp)
                                )
                                Text(
                                    text = "Flash Sales",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }

                    Text(
                        text = "Ends in 02:45:18",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(WgcCoreDsColors.gadgetShopSecondaryText)
                    )
                }
            }

            // Lista de itens do carrinho
            items(cartItems) { item ->
                WgcGadgetShopCartItemRow(
                    title = item.product.title,
                    subtitle = "Category: ${item.product.category} / Size: ${item.size}",
                    price = item.product.price,
                    quantity = item.quantity,
                    imageUrl = item.product.imageUrl,
                    onQuantityChange = { newQuantity -> onQuantityChange(item, newQuantity) },
                    onRemoveClick = { onRemoveItem(item) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcNexkartCartTemplatePreview() {
    WgcNexkartCartTemplate()
}
