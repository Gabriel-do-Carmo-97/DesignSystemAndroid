@file:Suppress("LongMethod", "CyclomaticComplexMethod", "TooManyFunctions", "UnusedPrivateMember")

package br.com.wgc.design_system.templates.screens.checkout

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Discount
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material.icons.automirrored.filled.ReceiptLong
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import br.com.wgc.design_system.commons.WgcDevicePreviews
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsElevation
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Item individual do pedido no Checkout.
 */
data class WgcCheckoutItem(
    val id: String,
    val name: String,
    val price: String,
    val quantity: Int,
    val imageUrl: String? = null
)

/**
 * Estado da interface do Checkout corporativo.
 */
data class WgcCheckoutUiState(
    val shippingAddress: String = "Av. Paulista, 1000 - Bela Vista, São Paulo - SP, 01310-100",
    val paymentMethodName: String = "Cartão de Crédito •••• 4242",
    val paymentMethodType: String = "credit_card",
    val items: List<WgcCheckoutItem> = listOf(
        WgcCheckoutItem("item_1", "Smartphone WGC Pro Max 256GB", "R$ 4.299,00", 1),
        WgcCheckoutItem("item_2", "Capa Protetora Silicone Titanium", "R$ 149,00", 1)
    ),
    val subtotal: String = "R$ 4.448,00",
    val shippingFee: String = "Grátis",
    val discount: String? = "- R$ 100,00",
    val totalPrice: String = "R$ 4.348,00",
    val couponCode: String = "WGC10",
    val isCouponApplied: Boolean = true,
    val isLoading: Boolean = false,
    val isProcessingPayment: Boolean = false
)

/**
 * ViewModel base para a tela de Checkout.
 */
abstract class BaseCheckoutViewModel : ViewModel() {
    abstract val uiState: StateFlow<WgcCheckoutUiState>
    abstract fun onChangeAddressClick()
    abstract fun onChangePaymentMethodClick()
    abstract fun onApplyCoupon(code: String)
    abstract fun onRemoveCoupon()
    abstract fun onConfirmOrderClick()
}

/**
 * Fake ViewModel para Preview e Testes.
 */
class FakeCheckoutViewModel(
    initialState: WgcCheckoutUiState = WgcCheckoutUiState()
) : BaseCheckoutViewModel() {
    private val _uiState = MutableStateFlow(initialState)
    override val uiState: StateFlow<WgcCheckoutUiState> = _uiState.asStateFlow()

    override fun onChangeAddressClick() = Unit
    override fun onChangePaymentMethodClick() = Unit
    override fun onApplyCoupon(code: String) {
        _uiState.value = _uiState.value.copy(
            couponCode = code,
            isCouponApplied = true,
            discount = "- R$ 100,00",
            totalPrice = "R$ 4.348,00"
        )
    }

    override fun onRemoveCoupon() {
        _uiState.value = _uiState.value.copy(
            couponCode = "",
            isCouponApplied = false,
            discount = null,
            totalPrice = "R$ 4.448,00"
        )
    }

    override fun onConfirmOrderClick() {
        _uiState.value = _uiState.value.copy(isProcessingPayment = true)
    }
}

/**
 * Template Oficial de Checkout corporativo do Design System WGC.
 */
@Composable
fun WgcCheckoutTemplate(
    modifier: Modifier = Modifier,
    viewModel: BaseCheckoutViewModel = remember { FakeCheckoutViewModel() },
    topBarSlot: (@Composable () -> Unit)? = null,
    addressSlot: (@Composable () -> Unit)? = null,
    itemsSlot: (@Composable () -> Unit)? = null,
    paymentSlot: (@Composable () -> Unit)? = null,
    summarySlot: (@Composable () -> Unit)? = null,
    ctaSlot: (@Composable () -> Unit)? = null,
    onBackClick: () -> Unit = {}
) {
    val state by viewModel.uiState.collectAsState()

    WgcCheckoutContent(
        modifier = modifier,
        state = state,
        topBarSlot = topBarSlot,
        addressSlot = addressSlot,
        itemsSlot = itemsSlot,
        paymentSlot = paymentSlot,
        summarySlot = summarySlot,
        ctaSlot = ctaSlot,
        onBackClick = onBackClick,
        onChangeAddress = { viewModel.onChangeAddressClick() },
        onChangePayment = { viewModel.onChangePaymentMethodClick() },
        onApplyCoupon = { viewModel.onApplyCoupon(it) },
        onRemoveCoupon = { viewModel.onRemoveCoupon() },
        onConfirmOrder = { viewModel.onConfirmOrderClick() }
    )
}

/**
 * Conteúdo puramente visual e desacoplado do Checkout (Stateless).
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcCheckoutContent(
    modifier: Modifier = Modifier,
    state: WgcCheckoutUiState,
    topBarSlot: (@Composable () -> Unit)? = null,
    addressSlot: (@Composable () -> Unit)? = null,
    itemsSlot: (@Composable () -> Unit)? = null,
    paymentSlot: (@Composable () -> Unit)? = null,
    summarySlot: (@Composable () -> Unit)? = null,
    ctaSlot: (@Composable () -> Unit)? = null,
    onBackClick: () -> Unit = {},
    onChangeAddress: () -> Unit = {},
    onChangePayment: () -> Unit = {},
    onApplyCoupon: (String) -> Unit = {},
    onRemoveCoupon: () -> Unit = {},
    onConfirmOrder: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            topBarSlot?.invoke() ?: TopAppBar(
                title = {
                    Text(
                        text = "Finalizar Compra",
                        style = MaterialTheme.typography.titleMedium,
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
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        },
        bottomBar = {
            ctaSlot?.invoke() ?: Surface(
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
                        textButton = "Confirmar Pedido • ${state.totalPrice}",
                        onClick = onConfirmOrder,
                        isLoading = state.isProcessingPayment,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    ) { padding ->
        if (state.isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentPadding = PaddingValues(
                    horizontal = WgcCoreDsSpacing.md16.dp,
                    vertical = WgcCoreDsSpacing.md16.dp
                ),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
            ) {
                // 1. Endereço de Entrega
                item {
                    addressSlot?.invoke() ?: WgcCheckoutAddressCard(
                        address = state.shippingAddress,
                        onChangeClick = onChangeAddress
                    )
                }

                // 2. Itens do Pedido
                item {
                    itemsSlot?.invoke() ?: WgcCheckoutItemsSection(items = state.items)
                }

                // 3. Forma de Pagamento
                item {
                    paymentSlot?.invoke() ?: WgcCheckoutPaymentCard(
                        methodName = state.paymentMethodName,
                        methodType = state.paymentMethodType,
                        onChangeClick = onChangePayment
                    )
                }

                // 4. Cupom de Desconto
                item {
                    WgcCheckoutCouponSection(
                        couponCode = state.couponCode,
                        isApplied = state.isCouponApplied,
                        onApply = onApplyCoupon,
                        onRemove = onRemoveCoupon
                    )
                }

                // 5. Resumo de Valores
                item {
                    summarySlot?.invoke() ?: WgcCheckoutOrderSummary(state = state)
                }
            }
        }
    }
}

@Composable
private fun WgcCheckoutAddressCard(
    address: String,
    onChangeClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onChangeClick),
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
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(WgcCoreDsSpacing.lg24.dp)
            )
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Endereço de Entrega",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = address,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                contentDescription = "Alterar endereço",
                modifier = Modifier.size(WgcCoreDsSpacing.md16.dp),
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun WgcCheckoutPaymentCard(
    methodName: String,
    methodType: String,
    onChangeClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onChangeClick),
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
                imageVector = resolvePaymentIcon(methodType),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(WgcCoreDsSpacing.lg24.dp)
            )
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Forma de Pagamento",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = methodName,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                contentDescription = "Alterar forma de pagamento",
                modifier = Modifier.size(WgcCoreDsSpacing.md16.dp),
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun WgcCheckoutItemsSection(items: List<WgcCheckoutItem>) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
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
                    text = "Itens do Pedido",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "${items.sumOf { it.quantity }} item(ns)",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
            items.forEach { item ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(br.com.wgc.design_system.core.WgcCoreDsSize.s36.dp)
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xs2.dp))
                                .background(MaterialTheme.colorScheme.surface),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.ShoppingBag,
                                contentDescription = null,
                                modifier = Modifier.size(WgcCoreDsSpacing.md16.dp),
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        Column {
                            Text(
                                text = item.name,
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.SemiBold,
                                maxLines = 1
                            )
                            Text(
                                text = "Qtd: ${item.quantity}",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                    Text(
                        text = item.price,
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
private fun WgcCheckoutCouponSection(
    couponCode: String,
    isApplied: Boolean,
    onApply: (String) -> Unit,
    onRemove: () -> Unit
) {
    var inputCode by remember { mutableStateOf(couponCode) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Discount,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(WgcCoreDsSpacing.lg24.dp)
            )

            if (isApplied) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Cupom Aplicado: $couponCode",
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "Desconto ativo no total",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                TextButton(onClick = onRemove) {
                    Text("Remover", color = MaterialTheme.colorScheme.error)
                }
            } else {
                OutlinedTextField(
                    value = inputCode,
                    onValueChange = { inputCode = it },
                    placeholder = { Text("Código de cupom") },
                    modifier = Modifier.weight(1f),
                    singleLine = true,
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp)
                )
                WgcClassicButton(
                    textButton = "Aplicar",
                    onClick = { onApply(inputCode) },
                    isEnabled = inputCode.isNotBlank()
                )
            }
        }
    }
}

@Composable
private fun WgcCheckoutOrderSummary(state: WgcCheckoutUiState) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
        ) {
            Text(
                text = "Resumo Financeiro",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.SemiBold
            )
            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Subtotal",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(text = state.subtotal, style = MaterialTheme.typography.bodySmall)
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Frete",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = state.shippingFee,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.SemiBold
                )
            }

            state.discount?.let { discountText ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Desconto",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = discountText,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Total a Pagar",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = state.totalPrice,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

private fun resolvePaymentIcon(type: String): ImageVector {
    return when (type.lowercase()) {
        "pix" -> Icons.Default.QrCode
        "boleto" -> Icons.AutoMirrored.Filled.ReceiptLong
        else -> Icons.Default.CreditCard
    }
}

@WgcDevicePreviews
@Composable
private fun WgcCheckoutTemplatePreview() {
    MaterialTheme {
        WgcCheckoutContent(
            state = WgcCheckoutUiState()
        )
    }
}
