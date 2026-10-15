package br.com.wgc.design_system.factories.checkout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.components.buttons.WgcButton
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.factories.checkout.templates.FakeCheckoutViewModel
import br.com.wgc.design_system.factories.checkout.templates.WgcCheckoutTemplate
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Fábrica Universal de Telas de Checkout (WgcCheckoutScreenFactory).
 */
@Composable
fun WgcCheckoutScreenFactory(
    modifier: Modifier = Modifier,
    variant: WgcCheckoutVariant = WgcCheckoutVariant.STANDARD,
    summarySlot: (@Composable () -> Unit)? = null,
    addressSlot: (@Composable () -> Unit)? = null,
    paymentSlot: (@Composable () -> Unit)? = null,
    finishButtonSlot: (@Composable () -> Unit)? = null,
    onFinishOrder: () -> Unit = {}
) {
    if (hasCustomCheckoutSlots(summarySlot, addressSlot, paymentSlot, finishButtonSlot)) {
        CustomSlotsCheckoutLayout(
            modifier = modifier,
            summarySlot = summarySlot,
            addressSlot = addressSlot,
            paymentSlot = paymentSlot,
            finishButtonSlot = finishButtonSlot,
            onFinishOrder = onFinishOrder
        )
    } else {
        RenderCheckoutVariant(modifier = modifier, variant = variant)
    }
}

@Composable
private fun CustomSlotsCheckoutLayout(
    modifier: Modifier,
    summarySlot: (@Composable () -> Unit)?,
    addressSlot: (@Composable () -> Unit)?,
    paymentSlot: (@Composable () -> Unit)?,
    finishButtonSlot: (@Composable () -> Unit)?,
    onFinishOrder: () -> Unit
) {
    Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            Text("Revisão do Pedido")
            summarySlot?.invoke()
            addressSlot?.invoke()
            paymentSlot?.invoke()
            finishButtonSlot?.invoke() ?: WgcButton(
                text = "Finalizar Pedido",
                onClick = onFinishOrder,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
private fun RenderCheckoutVariant(modifier: Modifier, variant: WgcCheckoutVariant) {
    when (variant) {
        WgcCheckoutVariant.STANDARD,
        WgcCheckoutVariant.GADGET_SHOP,
        WgcCheckoutVariant.MEGA_STORE,
        WgcCheckoutVariant.QUICK_SHOP,
        WgcCheckoutVariant.RETAIL,
        WgcCheckoutVariant.TREND_FASHION -> WgcCheckoutTemplate(
            modifier = modifier,
            viewModel = FakeCheckoutViewModel()
        )
    }
}

private fun hasCustomCheckoutSlots(
    summarySlot: (@Composable () -> Unit)?,
    addressSlot: (@Composable () -> Unit)?,
    paymentSlot: (@Composable () -> Unit)?,
    finishButtonSlot: (@Composable () -> Unit)?
): Boolean {
    val hasTop = summarySlot != null || addressSlot != null
    val hasBottom = paymentSlot != null || finishButtonSlot != null
    return hasTop || hasBottom
}

@Preview(name = "WgcCheckoutScreenFactory - Preview", showBackground = true)
@Composable
private fun WgcCheckoutScreenFactoryPreview() {
    WgcTheme {
        WgcCheckoutScreenFactory()
    }
}
