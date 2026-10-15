package br.com.wgc.design_system.coordinators.composite

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.coordinators.auth.WgcAuthFlowCoordinator
import br.com.wgc.design_system.coordinators.auth.WgcAuthVariant
import br.com.wgc.design_system.coordinators.home.WgcHomeFlowCoordinator
import br.com.wgc.design_system.coordinators.onboarding.WgcOnboardingFlowCoordinator
import br.com.wgc.design_system.factories.auth.WgcLoginFactory
import br.com.wgc.design_system.factories.auth.WgcLoginVariant
import br.com.wgc.design_system.factories.home.WgcHomeVariant
import br.com.wgc.design_system.factories.onboarding.WgcOnboardingVariant
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Representa um subfluxo completo e independente dentro de uma jornada composta.
 *
 * @property id Identificador único do fluxo (ex: "auth", "onboarding", "home").
 * @property title Título amigável da jornada.
 * @property content Composable que executa o fluxo, recebendo [onNextFlow] e [onCancel].
 */
data class WgcSubFlow(
    val id: String,
    val title: String? = null,
    val content: @Composable (onNextFlow: () -> Unit, onCancel: () -> Unit) -> Unit
)

/**
 * Defaults corporativos para orquestração de jornadas completas compostas.
 */
object WgcCompositeFlowDefaults {
    fun defaultFlows(): List<WgcSubFlow> = listOf(
        WgcSubFlow(id = "auth", title = "Autenticação") { onNextFlow, _ ->
            WgcAuthFlowCoordinator(
                variant = WgcAuthVariant.FOOD_DELIVERY,
                loginScreen = {
                    WgcLoginFactory(
                        variant = WgcLoginVariant.FOOD_DELIVERY,
                        onLoginSuccess = onNextFlow
                    )
                }
            )
        },
        WgcSubFlow(id = "onboarding", title = "Boas-Vindas") { onNextFlow, _ ->
            WgcOnboardingFlowCoordinator(
                variant = WgcOnboardingVariant.STANDARD,
                onCompleted = onNextFlow
            )
        },
        WgcSubFlow(id = "home", title = "Início") { _, _ ->
            WgcHomeFlowCoordinator(
                variant = WgcHomeVariant.FINTECH
            )
        }
    )
}

/**
 * Coordenador Composto de Jornadas (WgcCompositeFlowCoordinator).
 *
 * Encadeia múltiplos fluxos ou coordenadores completos (ex: Auth -> Onboarding -> Home)
 * formando um pipeline contínuo de experiência do usuário.
 *
 * Suporta State Hoisting integral através de [currentFlowIndex] e [onFlowChange],
 * ou controle interno automático.
 */
@Composable
fun WgcCompositeFlowCoordinator(
    modifier: Modifier = Modifier,
    flows: List<WgcSubFlow> = WgcCompositeFlowDefaults.defaultFlows(),
    currentFlowIndex: Int? = null,
    onFlowChange: ((Int) -> Unit)? = null,
    headerSlot: (@Composable (currentFlow: WgcSubFlow, index: Int, total: Int) -> Unit)? = null,
    onAllFlowsFinished: () -> Unit = {},
    onFlowCanceled: () -> Unit = {}
) {
    if (flows.isEmpty()) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Nenhum fluxo configurado na jornada composta.",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        return
    }

    var internalFlowIndex by remember { mutableIntStateOf(0) }
    val activeIndex = (currentFlowIndex ?: internalFlowIndex).coerceIn(0, flows.lastIndex)

    val updateFlow = { newIndex: Int ->
        if (onFlowChange != null) {
            onFlowChange(newIndex)
        } else {
            internalFlowIndex = newIndex
        }
    }

    val handleNextFlow = {
        if (activeIndex < flows.lastIndex) {
            updateFlow(activeIndex + 1)
        } else {
            onAllFlowsFinished()
        }
    }

    val handleCancel = {
        if (activeIndex > 0) {
            updateFlow(activeIndex - 1)
        } else {
            onFlowCanceled()
        }
    }

    val currentFlow = flows[activeIndex]

    Column(modifier = modifier.fillMaxSize()) {
        if (headerSlot != null) {
            headerSlot(currentFlow, activeIndex + 1, flows.size)
        }

        AnimatedContent(
            targetState = activeIndex,
            transitionSpec = { fadeIn() togetherWith fadeOut() },
            label = "WgcCompositeFlowTransition",
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { targetIndex ->
            flows[targetIndex].content(handleNextFlow, handleCancel)
        }
    }
}

@Preview(name = "WgcCompositeFlowCoordinator - Default Journey", showBackground = true)
@Composable
private fun WgcCompositeFlowCoordinatorPreview() {
    WgcTheme {
        WgcCompositeFlowCoordinator()
    }
}
