package br.com.wgc.design_system.coordinators.dynamic

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.components.buttons.WgcSecondaryClassicButton
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Representa um passo individual dentro de um fluxo dinâmico sequencial.
 *
 * @property id Identificador único da etapa.
 * @property title Título legível da etapa (usado em headers ou acessibilidade).
 * @property canSkip Indica se o passo pode ser ignorado opcionalmente.
 * @property content Composable que renderiza a tela e recebe os callbacks de navegação [onNext] e [onBack].
 */
data class WgcFlowStep(
    val id: String,
    val title: String? = null,
    val canSkip: Boolean = false,
    val content: @Composable (onNext: () -> Unit, onBack: () -> Unit) -> Unit
)

/**
 * Defaults corporativos sensatos para o [WgcDynamicFlowCoordinator].
 */
object WgcDynamicFlowDefaults {
    fun defaultSteps(): List<WgcFlowStep> = listOf(
        WgcFlowStep(
            id = "step_welcome",
            title = "Boas-Vindas"
        ) { onNext, _ ->
            WgcDefaultStepPlaceholder(
                stepIndex = 1,
                totalSteps = 2,
                title = "Etapa 1: Boas-Vindas",
                description = "Configure sua conta e personalize as preferências iniciais.",
                buttonText = "Avançar",
                onNext = onNext
            )
        },
        WgcFlowStep(
            id = "step_confirm",
            title = "Confirmação"
        ) { onNext, onBack ->
            WgcDefaultStepPlaceholder(
                stepIndex = 2,
                totalSteps = 2,
                title = "Etapa 2: Confirmação",
                description = "Revise todos os dados antes de finalizar o fluxo.",
                buttonText = "Finalizar",
                onNext = onNext,
                onBack = onBack
            )
        }
    )
}

/**
 * Coordenador Universal de Fluxo Dinâmico (WgcDynamicFlowCoordinator).
 *
 * Orquestra qualquer jornada sequencial contendo de 1 a N telas com controle de avanço,
 * retrocesso, barra de progresso e slots customizáveis para cabeçalhos e indicadores.
 *
 * Suporta State Hoisting integral através de [currentStepIndex] e [onStepChange],
 * operando com estado interno autogerenciado caso esses parâmetros não sejam fornecidos.
 */
@Composable
fun WgcDynamicFlowCoordinator(
    modifier: Modifier = Modifier,
    steps: List<WgcFlowStep> = WgcDynamicFlowDefaults.defaultSteps(),
    currentStepIndex: Int? = null,
    onStepChange: ((Int) -> Unit)? = null,
    showProgressBar: Boolean = true,
    progressSlot: (@Composable (current: Int, total: Int) -> Unit)? = null,
    headerSlot: (@Composable (currentStep: WgcFlowStep, current: Int, total: Int) -> Unit)? = null,
    onFlowComplete: () -> Unit = {},
    onFlowCanceled: () -> Unit = {}
) {
    if (steps.isEmpty()) {
        WgcDynamicFlowEmptyState(modifier = modifier)
        return
    }

    var internalStepIndex by remember { mutableIntStateOf(0) }
    val activeIndex = (currentStepIndex ?: internalStepIndex).coerceIn(0, steps.lastIndex)

    val updateStep = { newIndex: Int ->
        if (onStepChange != null) {
            onStepChange(newIndex)
        } else {
            internalStepIndex = newIndex
        }
    }

    val handleNext = {
        if (activeIndex < steps.lastIndex) {
            updateStep(activeIndex + 1)
        } else {
            onFlowComplete()
        }
    }

    val handleBack = {
        if (activeIndex > 0) {
            updateStep(activeIndex - 1)
        } else {
            onFlowCanceled()
        }
    }

    Column(modifier = modifier.fillMaxSize()) {
        WgcDynamicFlowProgressBar(
            activeIndex = activeIndex,
            totalSteps = steps.size,
            showProgressBar = showProgressBar,
            progressSlot = progressSlot
        )

        headerSlot?.invoke(steps[activeIndex], activeIndex + 1, steps.size)

        AnimatedContent(
            targetState = activeIndex,
            transitionSpec = { fadeIn() togetherWith fadeOut() },
            label = "WgcDynamicFlowStepTransition",
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { targetIndex ->
            steps[targetIndex].content(handleNext, handleBack)
        }
    }
}

@Composable
private fun WgcDynamicFlowEmptyState(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Nenhuma etapa configurada no fluxo.",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun WgcDynamicFlowProgressBar(
    activeIndex: Int,
    totalSteps: Int,
    showProgressBar: Boolean,
    progressSlot: (@Composable (current: Int, total: Int) -> Unit)?
) {
    if (progressSlot != null) {
        progressSlot(activeIndex + 1, totalSteps)
    } else if (showProgressBar && totalSteps > 1) {
        val progressFraction = (activeIndex + 1).toFloat() / totalSteps.toFloat()
        LinearProgressIndicator(
            progress = { progressFraction },
            modifier = Modifier
                .fillMaxWidth()
                .height(WgcCoreDsSpacing.xxs4.dp)
                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular.dp)),
            color = MaterialTheme.colorScheme.primary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant
        )
    }
}

/**
 * Placeholder corporativo padrão utilizado em etapas vazias ou de demonstração.
 */
@Composable
internal fun WgcDefaultStepPlaceholder(
    stepIndex: Int,
    totalSteps: Int,
    title: String,
    description: String,
    buttonText: String,
    onNext: () -> Unit,
    onBack: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.surface
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(WgcCoreDsSpacing.lg24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            WgcStepBadge(stepIndex = stepIndex, totalSteps = totalSteps)

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            Text(
                text = title,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))

            WgcStepButtonsRow(buttonText = buttonText, onNext = onNext, onBack = onBack)
        }
    }
}

@Composable
private fun WgcStepBadge(stepIndex: Int, totalSteps: Int) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.lg.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(
                horizontal = WgcCoreDsSpacing.md16.dp,
                vertical = WgcCoreDsSpacing.xs8.dp
            )
    ) {
        Text(
            text = "Passo $stepIndex de $totalSteps",
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}

@Composable
private fun WgcStepButtonsRow(
    buttonText: String,
    onNext: () -> Unit,
    onBack: (() -> Unit)?
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
    ) {
        if (onBack != null) {
            WgcSecondaryClassicButton(
                textButton = "Voltar",
                onClick = onBack,
                modifier = Modifier.weight(1f)
            )
        }

        WgcClassicButton(
            textButton = buttonText,
            onClick = onNext,
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview(name = "WgcDynamicFlowCoordinator - Default", showBackground = true)
@Composable
private fun WgcDynamicFlowCoordinatorPreview() {
    WgcTheme {
        WgcDynamicFlowCoordinator()
    }
}
