package br.com.wgc.ds_templates.screens.gadgetshop.checkout

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Payment
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * Tela de Checkout e Pagamento oficial do ecossistema Nexkart (WgcNexkartCheckoutTemplate).
 * Apresenta seleção de endereço de entrega, opções de forma de pagamento, detalhamento de custos e CTA de confirmação.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcNexkartCheckoutTemplate(
    modifier: Modifier = Modifier,
    address: String = "248 Avenue Road, Suite 400\nSan Francisco, CA 94107",
    selectedPaymentMethod: String = "Credit Card",
    subtotal: String = "USD 271.00",
    shipping: String = "Free",
    tax: String = "USD 14.00",
    total: String = "USD 285.00",
    onPaymentMethodSelected: (String) -> Unit = {},
    onChangeAddressClick: () -> Unit = {},
    onConfirmOrderClick: () -> Unit = {},
    onBackClick: () -> Unit = {}
) {
    val scrollState = rememberScrollState()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Checkout",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.gadgetShopDark)
                    )
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
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.md16.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp))
                            .background(Color(WgcCoreDsColors.gadgetShopPrimary))
                            .clickable(onClick = onConfirmOrderClick),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Pay $total",
                            style = MaterialTheme.typography.titleSmall,
                            color = Color.White,
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
                .verticalScroll(scrollState)
                .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.lg24.dp)
        ) {
            // 1. Seção Endereço de Entrega
            Column(
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Shipping Address",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.gadgetShopDark)
                    )
                    Text(
                        text = "Change",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(WgcCoreDsColors.gadgetShopPrimary),
                        modifier = Modifier.clickable(onClick = onChangeAddressClick)
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp))
                        .background(Color(WgcCoreDsColors.gadgetShopSurface))
                        .padding(WgcCoreDsSpacing.md16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(Color(WgcCoreDsColors.gadgetShopPrimaryLight)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.gadgetShopPrimary),
                            modifier = Modifier.size(20.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))

                    Text(
                        text = address,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(WgcCoreDsColors.gadgetShopDark)
                    )
                }
            }

            // 2. Seção Método de Pagamento
            Column(
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
            ) {
                Text(
                    text = "Payment Method",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.gadgetShopDark)
                )

                val paymentMethods = listOf("Credit Card", "Apple Pay", "PayPal")
                paymentMethods.forEach { method ->
                    val isSelected = selectedPaymentMethod == method
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp))
                            .border(
                                width = if (isSelected) 1.5.dp else 1.dp,
                                color = if (isSelected) Color(WgcCoreDsColors.gadgetShopPrimary) else Color(WgcCoreDsColors.gadgetShopBorder),
                                shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp)
                            )
                            .background(if (isSelected) Color(WgcCoreDsColors.gadgetShopPrimaryLight) else Color.White)
                            .clickable { onPaymentMethodSelected(method) }
                            .padding(WgcCoreDsSpacing.md16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = if (method == "Credit Card") Icons.Default.CreditCard else Icons.Default.Payment,
                                contentDescription = null,
                                tint = if (isSelected) Color(WgcCoreDsColors.gadgetShopPrimary) else Color(WgcCoreDsColors.gadgetShopSecondaryText),
                                modifier = Modifier.size(22.dp)
                            )
                            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))
                            Text(
                                text = method,
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                color = Color(WgcCoreDsColors.gadgetShopDark)
                            )
                        }

                        // Radio dot indicador
                        Box(
                            modifier = Modifier
                                .size(18.dp)
                                .clip(CircleShape)
                                .border(
                                    2.dp,
                                    if (isSelected) Color(WgcCoreDsColors.gadgetShopPrimary) else Color(WgcCoreDsColors.gadgetShopBorder),
                                    CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            if (isSelected) {
                                Box(
                                    modifier = Modifier
                                        .size(10.dp)
                                        .clip(CircleShape)
                                        .background(Color(WgcCoreDsColors.gadgetShopPrimary))
                                )
                            }
                        }
                    }
                }
            }

            // 3. Resumo Financeiro
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp))
                    .background(Color(WgcCoreDsColors.gadgetShopSurface))
                    .padding(WgcCoreDsSpacing.md16.dp),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
            ) {
                Text(
                    text = "Order Summary",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.gadgetShopDark)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Subtotal", style = MaterialTheme.typography.bodySmall, color = Color(WgcCoreDsColors.gadgetShopSecondaryText))
                    Text(text = subtotal, style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.SemiBold, color = Color(WgcCoreDsColors.gadgetShopDark))
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Shipping", style = MaterialTheme.typography.bodySmall, color = Color(WgcCoreDsColors.gadgetShopSecondaryText))
                    Text(text = shipping, style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.SemiBold, color = Color(WgcCoreDsColors.gadgetShopSuccessGreen))
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Tax", style = MaterialTheme.typography.bodySmall, color = Color(WgcCoreDsColors.gadgetShopSecondaryText))
                    Text(text = tax, style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.SemiBold, color = Color(WgcCoreDsColors.gadgetShopDark))
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Total", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, color = Color(WgcCoreDsColors.gadgetShopDark))
                    Text(text = total, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, color = Color(WgcCoreDsColors.gadgetShopPrimary))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcNexkartCheckoutTemplatePreview() {
    WgcNexkartCheckoutTemplate()
}
