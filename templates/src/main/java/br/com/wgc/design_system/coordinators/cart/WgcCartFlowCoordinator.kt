package br.com.wgc.design_system.coordinators.cart

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.factories.cart.WgcCartScreenFactory
import br.com.wgc.design_system.factories.cart.WgcCartVariant
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Coordenador do Fluxo de Carrinho (WgcCartFlowCoordinator).
 */
@Composable
fun WgcCartFlowCoordinator(
    step: WgcCartFlowStep = WgcCartFlowStep.Cart,
    modifier: Modifier = Modifier,
    variant: WgcCartVariant = WgcCartVariant.STANDARD,
    cartScreen: @Composable () -> Unit = {
        WgcCartScreenFactory(modifier = modifier, variant = variant)
    },
    couponScreen: @Composable () -> Unit = {
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Aplicar Cupons de Desconto")
        }
    },
    deliveryEstimateScreen: @Composable () -> Unit = {
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Estimativa de Frete e Prazos")
        }
    }
) {
    when (step) {
        WgcCartFlowStep.Cart -> cartScreen()
        WgcCartFlowStep.Coupon -> couponScreen()
        WgcCartFlowStep.DeliveryEstimate -> deliveryEstimateScreen()
    }
}

@Preview(name = "WgcCartFlowCoordinator - Preview", showBackground = true)
@Composable
private fun WgcCartFlowCoordinatorPreview() {
    WgcTheme {
        WgcCartFlowCoordinator()
    }
}
