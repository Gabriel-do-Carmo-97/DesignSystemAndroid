package br.com.wgc.design_system.factories.cart

import androidx.compose.foundation.layout.Box
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
import br.com.wgc.design_system.templates.screens.apparel.cart.WgcClotheeCartTemplate
import br.com.wgc.design_system.templates.screens.boutique.cart.WgcLazaCartTemplate
import br.com.wgc.design_system.templates.screens.carepharmacy.cart.WgcDrogasilCartTemplate
import br.com.wgc.design_system.templates.screens.cart.FakeStandardCartViewModel
import br.com.wgc.design_system.templates.screens.cart.StandardCartScreenTemplate
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Fábrica Universal de Telas de Carrinho (WgcCartScreenFactory).
 */
@Composable
fun WgcCartScreenFactory(
    modifier: Modifier = Modifier,
    variant: WgcCartVariant = WgcCartVariant.STANDARD,
    itemsSlot: (@Composable () -> Unit)? = null,
    summarySlot: (@Composable () -> Unit)? = null,
    checkoutButtonSlot: (@Composable () -> Unit)? = null,
    onNavigateToCheckout: () -> Unit = {}
) {
    val hasCustomSlots = itemsSlot != null || summarySlot != null || checkoutButtonSlot != null

    if (hasCustomSlots) {
        CustomSlotsCartLayout(
            modifier = modifier,
            itemsSlot = itemsSlot,
            summarySlot = summarySlot,
            checkoutButtonSlot = checkoutButtonSlot,
            onNavigateToCheckout = onNavigateToCheckout
        )
    } else {
        RenderCartVariant(modifier = modifier, variant = variant)
    }
}

@Composable
private fun CustomSlotsCartLayout(
    modifier: Modifier,
    itemsSlot: (@Composable () -> Unit)?,
    summarySlot: (@Composable () -> Unit)?,
    checkoutButtonSlot: (@Composable () -> Unit)?,
    onNavigateToCheckout: () -> Unit
) {
    Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(WgcCoreDsSpacing.md16.dp)
        ) {
            Box(modifier = Modifier.weight(1f)) {
                itemsSlot?.invoke() ?: Text("Itens do Carrinho")
            }
            summarySlot?.invoke()
            checkoutButtonSlot?.invoke() ?: WgcButton(
                text = "Continuar para Checkout",
                onClick = onNavigateToCheckout,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
private fun RenderCartVariant(modifier: Modifier, variant: WgcCartVariant) {
    when (variant) {
        WgcCartVariant.BOUTIQUE -> WgcLazaCartTemplate(modifier = modifier)
        WgcCartVariant.APPAREL -> WgcClotheeCartTemplate(modifier = modifier)
        WgcCartVariant.CARE_PHARMACY -> WgcDrogasilCartTemplate(modifier = modifier)
        else -> StandardCartScreenTemplate(viewModel = FakeStandardCartViewModel())
    }
}

@Preview(name = "WgcCartScreenFactory - Preview", showBackground = true)
@Composable
private fun WgcCartScreenFactoryPreview() {
    WgcTheme {
        WgcCartScreenFactory()
    }
}
