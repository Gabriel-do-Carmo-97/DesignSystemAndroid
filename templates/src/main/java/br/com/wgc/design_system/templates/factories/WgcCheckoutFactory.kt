package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.factories.checkout.WgcCheckoutScreenFactory
import br.com.wgc.design_system.factories.checkout.WgcCheckoutVariant
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Fábrica Universal de Telas de Checkout (WgcCheckoutFactory).
 */
@Deprecated(
    message = "Utilize WgcCheckoutScreenFactory diretamente",
    replaceWith = ReplaceWith("WgcCheckoutScreenFactory(modifier, variant)")
)
@Composable
fun WgcCheckoutFactory(
    modifier: Modifier = Modifier,
    variant: WgcCheckoutVariant = WgcCheckoutVariant.STANDARD,
    summarySlot: (@Composable () -> Unit)? = null,
    addressSlot: (@Composable () -> Unit)? = null,
    paymentSlot: (@Composable () -> Unit)? = null,
    finishButtonSlot: (@Composable () -> Unit)? = null,
    onFinishOrder: () -> Unit = {}
) {
    WgcCheckoutScreenFactory(
        modifier = modifier,
        variant = variant,
        summarySlot = summarySlot,
        addressSlot = addressSlot,
        paymentSlot = paymentSlot,
        finishButtonSlot = finishButtonSlot,
        onFinishOrder = onFinishOrder
    )
}

@Preview(name = "WgcCheckoutFactory Preview", showBackground = true)
@Composable
private fun WgcCheckoutFactoryPreview() {
    WgcTheme {
        WgcCheckoutFactory()
    }
}
