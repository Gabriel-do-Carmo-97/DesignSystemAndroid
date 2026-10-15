package br.com.wgc.design_system.coordinators.payment

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.factories.payment.WgcCardScreenFactory
import br.com.wgc.design_system.factories.payment.WgcPaymentMethodSelectionFactory
import br.com.wgc.design_system.factories.payment.WgcPaymentMethodVariant
import br.com.wgc.design_system.factories.payment.WgcPixScreenFactory
import br.com.wgc.design_system.factories.payment.WgcPixScreenVariant
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Coordenador do Fluxo de Pagamento (WgcPaymentFlowCoordinator).
 */
@Composable
fun WgcPaymentFlowCoordinator(
    step: WgcPaymentFlowStep = WgcPaymentFlowStep.MethodSelection,
    modifier: Modifier = Modifier,
    selectedMethod: WgcPaymentMethodVariant = WgcPaymentMethodVariant.CREDIT_CARD,
    pixVariant: WgcPixScreenVariant = WgcPixScreenVariant.QR_CODE_PAYMENT,
    onMethodSelected: (WgcPaymentMethodVariant) -> Unit = {},
    methodSelectionScreen: @Composable () -> Unit = {
        WgcPaymentMethodSelectionFactory(
            modifier = modifier,
            selectedMethod = selectedMethod,
            onMethodSelected = onMethodSelected
        )
    },
    cardScreen: @Composable () -> Unit = {
        WgcCardScreenFactory(modifier = modifier)
    },
    pixScreen: @Composable () -> Unit = {
        WgcPixScreenFactory(modifier = modifier, variant = pixVariant)
    },
    boletoScreen: @Composable () -> Unit = {
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Boleto Bancário Gerado com Sucesso")
        }
    },
    successScreen: @Composable () -> Unit = {
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Pagamento Confirmado com Sucesso!")
        }
    }
) {
    when (step) {
        WgcPaymentFlowStep.MethodSelection -> methodSelectionScreen()
        WgcPaymentFlowStep.CardInput -> cardScreen()
        WgcPaymentFlowStep.PixQrCode -> pixScreen()
        WgcPaymentFlowStep.Boleto -> boletoScreen()
        WgcPaymentFlowStep.Success -> successScreen()
    }
}

@Preview(name = "WgcPaymentFlowCoordinator - Preview", showBackground = true)
@Composable
private fun WgcPaymentFlowCoordinatorPreview() {
    WgcTheme {
        WgcPaymentFlowCoordinator()
    }
}
