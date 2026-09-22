@file:Suppress("MatchingDeclarationName")

package br.com.wgc.design_system.templates.factories

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.commons.WgcDevicePreviews
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.templates.screens.gadgetshop.onboarding.WgcNexkartOnboardingTemplate
import br.com.wgc.design_system.templates.screens.personalfinance.onboarding.WgcOrganizzeOnboardingTemplate
import br.com.wgc.design_system.templates.screens.quickshop.onboarding.WgcShopEaseOnboardingTemplate
import br.com.wgc.design_system.templates.screens.trendfashion.onboarding.WgcStylishOnboardingScreenTemplate

/**
 * Variantes de Onboarding suportadas pela [WgcOnboardingFactory].
 */
enum class WgcOnboardingType {
    STANDARD,
    GADGET_SHOP,
    PERSONAL_FINANCE,
    QUICK_SHOP,
    TREND_FASHION
}

/**
 * Fábrica Universal de Telas de Onboarding (WgcOnboardingFactory).
 *
 * Ponto de entrada unificado para fluxos de onboarding, boas-vindas e walkthroughs do aplicativo.
 * Suporta State Hoisting com steps, botões de ação e substituição cirúrgica de slots.
 */
@Suppress("LongMethod", "CyclomaticComplexMethod", "ReturnCount")
@Composable
fun WgcOnboardingFactory(
    modifier: Modifier = Modifier,
    type: WgcOnboardingType = WgcOnboardingType.STANDARD,
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
    val hasCustomSlots = illustrationSlot != null || headerSlot != null || actionSlot != null

    if (!hasCustomSlots) {
        when (type) {
            WgcOnboardingType.GADGET_SHOP -> {
                WgcNexkartOnboardingTemplate(
                    modifier = modifier,
                    onNextClick = if (step >= totalSteps) onGetStartedClick else onNextClick
                )
                return
            }
            WgcOnboardingType.PERSONAL_FINANCE -> {
                WgcOrganizzeOnboardingTemplate(
                    modifier = modifier,
                    onGetStartedClick = onGetStartedClick,
                    onLoginClick = onSkipClick
                )
                return
            }
            WgcOnboardingType.QUICK_SHOP -> {
                WgcShopEaseOnboardingTemplate(
                    modifier = modifier,
                    currentStep = step,
                    title = title,
                    description = description,
                    onNextClick = if (step >= totalSteps) onGetStartedClick else onNextClick
                )
                return
            }
            WgcOnboardingType.TREND_FASHION -> {
                WgcStylishOnboardingScreenTemplate(
                    modifier = modifier,
                    step = step,
                    totalSteps = totalSteps,
                    title = title,
                    description = description,
                    onNextClick = if (step >= totalSteps) onGetStartedClick else onNextClick,
                    onSkipClick = onSkipClick
                )
                return
            }
            WgcOnboardingType.STANDARD -> Unit
        }
    }

    val isLastStep = step >= totalSteps

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            headerSlot?.invoke() ?: Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.sm12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$step/$totalSteps",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                if (!isLastStep) {
                    TextButton(onClick = onSkipClick) {
                        Text(
                            text = "Pular",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        },
        bottomBar = {
            actionSlot?.invoke() ?: Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(WgcCoreDsSpacing.lg24.dp)
            ) {
                WgcClassicButton(
                    textButton = if (isLastStep) "Começar Agora" else "Próximo",
                    onClick = if (isLastStep) onGetStartedClick else onNextClick,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = WgcCoreDsSpacing.lg24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            illustrationSlot?.invoke() ?: Box(
                modifier = Modifier
                    .size(WgcCoreDsSize.s120.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.ShoppingBag,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(WgcCoreDsSize.s56.dp)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))

            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@WgcDevicePreviews
@androidx.compose.ui.tooling.preview.Preview(showBackground = true)
@Composable
private fun WgcOnboardingFactoryPreview() {
    MaterialTheme {
        WgcOnboardingFactory(type = WgcOnboardingType.STANDARD)
    }
}
