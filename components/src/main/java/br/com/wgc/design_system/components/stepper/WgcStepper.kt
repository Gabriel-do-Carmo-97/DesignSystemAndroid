package br.com.wgc.design_system.components.stepper

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.commons.previews.components.WgcComponentPreviews
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Ponto de entrada e alias corporativo para o componente de etapas WgcStepIndicator.
 *
 * @param steps Lista de etapas com seus respectivos estados (COMPLETED, CURRENT, UPCOMING).
 * @param modifier Modificador de layout.
 */
@Composable
fun WgcStepper(
    steps: List<WgcStepItem>,
    modifier: Modifier = Modifier
) {
    WgcStepIndicator(
        steps = steps,
        modifier = modifier
    )
}

@Preview(showBackground = true, name = "WgcStepper Preview")
@WgcComponentPreviews
@Composable
private fun WgcStepperPreview() {
    MaterialTheme {
        Surface(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
            val sampleSteps = listOf(
                WgcStepItem(title = "Dados", state = WgcStepState.COMPLETED),
                WgcStepItem(title = "Endereço", state = WgcStepState.CURRENT),
                WgcStepItem(title = "Pagamento", state = WgcStepState.UPCOMING)
            )
            WgcStepper(steps = sampleSteps)
        }
    }
}

