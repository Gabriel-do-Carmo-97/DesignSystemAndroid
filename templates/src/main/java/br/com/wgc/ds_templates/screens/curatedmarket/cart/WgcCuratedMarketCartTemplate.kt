package br.com.wgc.ds_templates.screens.curatedmarket.cart

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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DeleteOutline
import androidx.compose.material.icons.filled.Remove
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
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.images.AsyncImageDefault
import br.com.wgc.design_system.components.navigation.WgcCuratedBottomNav
import br.com.wgc.ds_templates.screens.curatedmarket.model.CuratedMarketMockData
import br.com.wgc.ds_templates.screens.curatedmarket.model.TasselProduct

/**
 * Tela de sacola de compras (Bag/Cart) oficial do Tassel (WgcTasselCartTemplate).
 * Apresenta lista de produtos na sacola com ajustes de quantidade, campo de cupom promocional,
 * detalhamento dos custos e botão fixo de checkout.
 */
@Composable
fun WgcTasselCartTemplate(
    modifier: Modifier = Modifier,
    items: List<TasselProduct> = listOf(CuratedMarketMockData.products[0], CuratedMarketMockData.products[1]),
    selectedNavIndex: Int = 2, // Bag
    subtotal: String = "$93.00",
    deliveryFee: String = "Free",
    total: String = "$93.00",
    promoCode: String = "",
    onPromoCodeChange: (String) -> Unit = {},
    onApplyPromoClick: () -> Unit = {},
    onBackClick: () -> Unit = {},
    onCheckoutClick: () -> Unit = {},
    onNavItemSelected: (Int) -> Unit = {},
    customListSlot: (@Composable () -> Unit)? = null,
    customSummarySlot: (@Composable () -> Unit)? = null,
    customBottomBarSlot: (@Composable () -> Unit)? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        bottomBar = {
            if (customBottomBarSlot != null) {
                customBottomBarSlot()
            } else {
                Column(modifier = Modifier.fillMaxWidth().background(Color.White)) {
                    Box(modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.lg24.dp, vertical = WgcCoreDsSpacing.sm12.dp)) {
                        Button(
                            onClick = onCheckoutClick,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(WgcCoreDsSize.s52.dp),
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(WgcCoreDsColors.curatedMarketPrimary),
                                contentColor = Color.White
                            )
                        ) {
                            Text(
                                text = "Proceed to Checkout",
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    WgcCuratedBottomNav(
                        selectedIndex = selectedNavIndex,
                        onItemSelected = onNavItemSelected
                    )
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = WgcCoreDsSpacing.lg24.dp)
                .verticalScroll(rememberScrollState())
        ) {
            // Top Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = WgcCoreDsSpacing.md16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier
                        .size(WgcCoreDsSize.s40.dp)
                        .clip(CircleShape)
                        .background(Color(WgcCoreDsColors.curatedMarketSurface))
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Voltar",
                        tint = Color(WgcCoreDsColors.curatedMarketDark),
                        modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "Bag",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.curatedMarketDark)
                )

                Spacer(modifier = Modifier.weight(1f))

                // Balanceador
                Spacer(modifier = Modifier.size(WgcCoreDsSize.s40.dp))
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            // Lista de Itens
            if (customListSlot != null) {
                customListSlot()
            } else {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
                ) {
                    items.forEach { product ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                                .background(Color(WgcCoreDsColors.curatedMarketSurface))
                                .padding(WgcCoreDsSpacing.sm12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(WgcCoreDsSize.s72.dp)
                                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                    .background(Color.White),
                                contentAlignment = Alignment.Center
                            ) {
                                if (!product.imageUrl.isNullOrEmpty()) {
                                    AsyncImageDefault(
                                        image = product.imageUrl,
                                        contentDescription = product.title,
                                        modifier = Modifier.fillMaxSize()
                                    )
                                } else {
                                    Text(
                                        text = product.title.take(2).uppercase(),
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(WgcCoreDsColors.curatedMarketPrimary)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))

                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = product.title,
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(WgcCoreDsColors.curatedMarketDark)
                                )
                                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxxs2.dp))
                                Text(
                                    text = "${product.brand} | Size: M",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = Color(WgcCoreDsColors.curatedMarketSecondaryText)
                                )
                                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
                                Text(
                                    text = product.price,
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(WgcCoreDsColors.curatedMarketDark)
                                )
                            }

                            // Stepper vertical ou botão de remover
                            IconButton(onClick = {}) {
                                Icon(
                                    imageVector = Icons.Default.DeleteOutline,
                                    contentDescription = "Remover item",
                                    tint = Color(WgcCoreDsColors.curatedMarketSecondaryText),
                                    modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            // Cupom Promocional
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
            ) {
                OutlinedTextField(
                    value = promoCode,
                    onValueChange = onPromoCodeChange,
                    placeholder = {
                        Text(
                            text = "Promo code",
                            color = Color(WgcCoreDsColors.curatedMarketSecondaryText)
                        )
                    },
                    modifier = Modifier.weight(1f).height(WgcCoreDsSize.s48.dp),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color(WgcCoreDsColors.curatedMarketSurface),
                        unfocusedContainerColor = Color(WgcCoreDsColors.curatedMarketSurface),
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent
                    )
                )

                Button(
                    onClick = onApplyPromoClick,
                    modifier = Modifier.height(WgcCoreDsSize.s48.dp),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(WgcCoreDsColors.curatedMarketDark),
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Apply", fontWeight = FontWeight.Bold)
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            // Detalhamento de Custos
            if (customSummarySlot != null) {
                customSummarySlot()
            } else {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Subtotal",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(WgcCoreDsColors.curatedMarketSecondaryText)
                        )
                        Text(
                            text = subtotal,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.curatedMarketDark)
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Delivery",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(WgcCoreDsColors.curatedMarketSecondaryText)
                        )
                        Text(
                            text = deliveryFee,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.curatedMarketDark)
                        )
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Total",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.curatedMarketDark)
                        )
                        Text(
                            text = total,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.curatedMarketPrimary)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcTasselCartTemplatePreview() {
    WgcTasselCartTemplate()
}
