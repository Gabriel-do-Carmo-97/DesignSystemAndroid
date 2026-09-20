@file:Suppress("MatchingDeclarationName")

package br.com.wgc.design_system.templates.factories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.commons.WgcDevicePreviews
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsElevation
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.templates.screens.gadgetshop.checkout.WgcNexkartCheckoutTemplate
import br.com.wgc.design_system.templates.screens.megastore.checkout.WgcShoppePaymentScreenTemplate
import br.com.wgc.design_system.templates.screens.quickshop.checkout.WgcShopEaseCheckoutTemplate
import br.com.wgc.design_system.templates.screens.retail.checkout.WgcKutukuPaymentScreen
import br.com.wgc.design_system.templates.screens.trendfashion.checkout.WgcStylishCheckoutScreenTemplate

/**
 * Variantes de Checkout suportadas pela [WgcCheckoutFactory].
 */
enum class WgcCheckoutType {
    STANDARD,
    GADGET_SHOP,
    MEGA_STORE,
    QUICK_SHOP,
    RETAIL,
    TREND_FASHION
}

/**
 * Fábrica Universal de Telas de Checkout (WgcCheckoutFactory).
 *
 * Expõe um ponto de entrada unificado para todos os fluxos de checkout e fechamento de pedidos,
 * preservando 100% dos layouts concretos existentes através de [type] e oferecendo defaults sensatos
 * de produção com suporte cirúrgico a slots customizados.
 */
@Suppress("LongMethod", "CyclomaticComplexMethod", "ReturnCount")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcCheckoutFactory(
    modifier: Modifier = Modifier,
    type: WgcCheckoutType = WgcCheckoutType.STANDARD,
    topBarSlot: (@Composable () -> Unit)? = null,
    addressSlot: (@Composable () -> Unit)? = null,
    paymentMethodSlot: (@Composable () -> Unit)? = null,
    orderSummarySlot: (@Composable () -> Unit)? = null,
    bottomActionSlot: (@Composable () -> Unit)? = null,
    onBackClick: () -> Unit = {},
    onConfirmOrderClick: () -> Unit = {}
) {
    val hasCustomSlots = topBarSlot != null || addressSlot != null ||
        paymentMethodSlot != null || orderSummarySlot != null || bottomActionSlot != null

    if (!hasCustomSlots) {
        when (type) {
            WgcCheckoutType.GADGET_SHOP -> {
                WgcNexkartCheckoutTemplate(
                    modifier = modifier,
                    onBackClick = onBackClick,
                    onConfirmOrderClick = onConfirmOrderClick
                )
                return
            }
            WgcCheckoutType.MEGA_STORE -> {
                WgcShoppePaymentScreenTemplate(
                    modifier = modifier,
                    onBackClick = onBackClick,
                    onPayNowClick = onConfirmOrderClick
                )
                return
            }
            WgcCheckoutType.QUICK_SHOP -> {
                WgcShopEaseCheckoutTemplate(
                    modifier = modifier,
                    onBackClick = onBackClick,
                    onConfirmOrderClick = onConfirmOrderClick
                )
                return
            }
            WgcCheckoutType.RETAIL -> {
                WgcKutukuPaymentScreen(
                    modifier = modifier,
                    onBackClick = onBackClick,
                    onCheckoutNowClick = onConfirmOrderClick
                )
                return
            }
            WgcCheckoutType.TREND_FASHION -> {
                WgcStylishCheckoutScreenTemplate(
                    modifier = modifier,
                    onBackClick = onBackClick,
                    onProceedToPaymentClick = onConfirmOrderClick
                )
                return
            }
            WgcCheckoutType.STANDARD -> Unit
        }
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            topBarSlot?.invoke() ?: TopAppBar(
                title = {
                    Text(
                        text = "Checkout",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                }
            )
        },
        bottomBar = {
            bottomActionSlot?.invoke() ?: Surface(
                tonalElevation = WgcCoreDsElevation.level2.dp,
                shadowElevation = WgcCoreDsElevation.level2.dp,
                color = MaterialTheme.colorScheme.surface
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(WgcCoreDsSpacing.md16.dp)
                ) {
                    WgcClassicButton(
                        textButton = "Confirmar Pedido",
                        onClick = onConfirmOrderClick,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = WgcCoreDsSpacing.md16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            // 1. Endereço de Entrega
            addressSlot?.invoke() ?: Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(WgcCoreDsSpacing.md16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Endereço de Entrega",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Av. Paulista, 1000, Apto 42 - Bela Vista, São Paulo - SP",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            // 2. Método de Pagamento
            paymentMethodSlot?.invoke() ?: Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(WgcCoreDsSpacing.md16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.CreditCard,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Forma de Pagamento",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Cartão de Crédito •••• 4242 (Mastercard)",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            // 3. Resumo do Pedido
            orderSummarySlot?.invoke() ?: Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(WgcCoreDsSpacing.md16.dp),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    Text(
                        text = "Resumo do Pedido",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold
                    )
                    HorizontalDivider(modifier = Modifier.padding(vertical = WgcCoreDsSpacing.xxs4.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Subtotal", style = MaterialTheme.typography.bodyMedium)
                        Text(text = "R$ 189,90", style = MaterialTheme.typography.bodyMedium)
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Frete", style = MaterialTheme.typography.bodyMedium)
                        Text(
                            text = "Grátis",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                    HorizontalDivider(modifier = Modifier.padding(vertical = WgcCoreDsSpacing.xxs4.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Total",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "R$ 189,90",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))
        }
    }
}

@WgcDevicePreviews
@androidx.compose.ui.tooling.preview.Preview(showBackground = true)
@Composable
private fun WgcCheckoutFactoryPreview() {
    MaterialTheme {
        WgcCheckoutFactory(type = WgcCheckoutType.STANDARD)
    }
}
