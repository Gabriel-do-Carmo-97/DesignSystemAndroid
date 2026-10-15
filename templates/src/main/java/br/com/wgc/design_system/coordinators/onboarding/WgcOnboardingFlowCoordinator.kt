package br.com.wgc.design_system.coordinators.onboarding

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.factories.onboarding.WgcOnboardingScreenFactory
import br.com.wgc.design_system.factories.onboarding.WgcOnboardingVariant
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Coordenador do Fluxo de Boas-Vindas / Onboarding (WgcOnboardingFlowCoordinator).
 */
@Composable
fun WgcOnboardingFlowCoordinator(
    modifier: Modifier = Modifier,
    variant: WgcOnboardingVariant = WgcOnboardingVariant.STANDARD,
    onCompleted: () -> Unit = {},
    customScreenSlot: (@Composable () -> Unit)? = null
) {
    if (customScreenSlot != null) {
        customScreenSlot()
    } else {
        WgcOnboardingScreenFactory(
            modifier = modifier,
            variant = variant,
            onGetStartedClick = onCompleted,
            onSkipClick = onCompleted,
            onNextClick = onCompleted
        )
    }
}

@Preview(name = "WgcOnboardingFlowCoordinator - Preview", showBackground = true)
@Composable
private fun WgcOnboardingFlowCoordinatorPreview() {
    WgcTheme {
        WgcOnboardingFlowCoordinator()
    }
}
