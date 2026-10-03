package br.com.wgc.design_system.components.stepper

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

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
