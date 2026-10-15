package br.com.wgc.design_system.coordinators.checkout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.factories.address.WgcAddressSelectionFactory
import br.com.wgc.design_system.factories.checkout.WgcCheckoutScreenFactory
import br.com.wgc.design_system.factories.checkout.WgcCheckoutVariant
import br.com.wgc.design_system.factories.payment.WgcPaymentMethodSelectionFactory
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Coordenador do Fluxo de Checkout (WgcCheckoutFlowCoordinator).
 */
@Composable
fun WgcCheckoutFlowCoordinator(
    step: WgcCheckoutFlowStep = WgcCheckoutFlowStep.Review,
    modifier: Modifier = Modifier,
    variant: WgcCheckoutVariant = WgcCheckoutVariant.STANDARD,
    onFinishOrder: () -> Unit = {},
    reviewScreen: @Composable () -> Unit = {
        WgcCheckoutScreenFactory(
            modifier = modifier,
            variant = variant,
            onFinishOrder = onFinishOrder
        )
    },
    addressScreen: @Composable () -> Unit = {
        WgcAddressSelectionFactory(modifier = modifier)
    },
    paymentScreen: @Composable () -> Unit = {
        WgcPaymentMethodSelectionFactory(modifier = modifier)
    },
    confirmationScreen: @Composable () -> Unit = {
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Pedido Realizado com Sucesso!")
        }
    }
) {
    when (step) {
        WgcCheckoutFlowStep.Review -> reviewScreen()
        WgcCheckoutFlowStep.Address -> addressScreen()
        WgcCheckoutFlowStep.Payment -> paymentScreen()
        WgcCheckoutFlowStep.Confirmation -> confirmationScreen()
    }
}

@Preview(name = "WgcCheckoutFlowCoordinator - Preview", showBackground = true)
@Composable
private fun WgcCheckoutFlowCoordinatorPreview() {
    WgcTheme {
        WgcCheckoutFlowCoordinator()
    }
}
