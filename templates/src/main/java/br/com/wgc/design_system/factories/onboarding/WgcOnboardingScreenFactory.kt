package br.com.wgc.design_system.factories.onboarding

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.templates.factories.WgcOnboardingFactory
import br.com.wgc.design_system.templates.factories.WgcOnboardingType
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Fábrica Universal de Telas de Onboarding (WgcOnboardingScreenFactory).
 */
@Composable
fun WgcOnboardingScreenFactory(
    modifier: Modifier = Modifier,
    variant: WgcOnboardingVariant = WgcOnboardingVariant.STANDARD,
    step: Int = 1,
    totalSteps: Int = 3,
    title: String = "Bem-vindo ao Design System",
    description: String = "Descubra uma experiência consistente, moderna e acessível para seus fluxos corporativos.",
    illustrationSlot: (@Composable () -> Unit)? = null,
    headerSlot: (@Composable () -> Unit)? = null,
    actionSlot: (@Composable () -> Unit)? = null,
    onNextClick: () -> Unit = {},
    onSkipClick: () -> Unit = {},
    onGetStartedClick: () -> Unit = {}
) {
    val type = when (variant) {
        WgcOnboardingVariant.STANDARD -> WgcOnboardingType.STANDARD
        WgcOnboardingVariant.GADGET_SHOP -> WgcOnboardingType.GADGET_SHOP
        WgcOnboardingVariant.PERSONAL_FINANCE -> WgcOnboardingType.PERSONAL_FINANCE
        WgcOnboardingVariant.QUICK_SHOP -> WgcOnboardingType.QUICK_SHOP
        WgcOnboardingVariant.TREND_FASHION -> WgcOnboardingType.TREND_FASHION
    }

    WgcOnboardingFactory(
        modifier = modifier,
        type = type,
        step = step,
        totalSteps = totalSteps,
        title = title,
        description = description,
        illustrationSlot = illustrationSlot,
        headerSlot = headerSlot,
        actionSlot = actionSlot,
        onNextClick = onNextClick,
        onSkipClick = onSkipClick,
        onGetStartedClick = onGetStartedClick
    )
}

@Preview(name = "WgcOnboardingScreenFactory - Preview", showBackground = true)
@Composable
private fun WgcOnboardingScreenFactoryPreview() {
    WgcTheme {
        WgcOnboardingScreenFactory()
    }
}
