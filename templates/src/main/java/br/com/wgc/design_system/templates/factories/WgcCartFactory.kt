package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.factories.cart.WgcCartScreenFactory
import br.com.wgc.design_system.factories.cart.WgcCartVariant
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Fábrica Universal de Carrinhos de Compra (WgcCartFactory).
 */
@Deprecated(
    message = "Utilize WgcCartScreenFactory ou WgcCartFlowCoordinator",
    replaceWith = ReplaceWith("WgcCartScreenFactory(modifier, variant)")
)
@Composable
fun WgcCartFactory(
    modifier: Modifier = Modifier,
    variant: WgcCartVariant = WgcCartVariant.STANDARD,
    itemsSlot: (@Composable () -> Unit)? = null,
    summarySlot: (@Composable () -> Unit)? = null,
    checkoutButtonSlot: (@Composable () -> Unit)? = null,
    onCheckoutClick: () -> Unit = {}
) {
    WgcCartScreenFactory(
        modifier = modifier,
        variant = variant,
        itemsSlot = itemsSlot,
        summarySlot = summarySlot,
        checkoutButtonSlot = checkoutButtonSlot,
        onNavigateToCheckout = onCheckoutClick
    )
}

@Preview(name = "WgcCartFactory - Standard Preview", showBackground = true)
@Composable
private fun WgcCartFactoryPreview() {
    WgcTheme {
        WgcCartFactory()
    }
}
