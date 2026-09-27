package br.com.wgc.design_system.components.stepper

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.commons.WgcComponentPreviews
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Estado individual de cada etapa no Stepper.
 */
enum class WgcStepState {
    COMPLETED,
    CURRENT,
    UPCOMING
}

/**
 * Item representativo de uma etapa do formulário/fluxo (WgcStepItem).
 */
data class WgcStepItem(
    val title: String,
    val state: WgcStepState
)

/**
 * Indicador de Etapas Corporativo Horizontal (WgcStepIndicator).
 *
 * @param steps Lista ordenada de etapas do fluxo.
 * @param modifier Modificador de layout.
 */
@Composable
fun WgcStepIndicator(
    steps: List<WgcStepItem>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        steps.forEachIndexed { index, step ->
            val circleColor = when (step.state) {
                WgcStepState.COMPLETED -> MaterialTheme.colorScheme.primary
                WgcStepState.CURRENT -> MaterialTheme.colorScheme.primary
                WgcStepState.UPCOMING -> MaterialTheme.colorScheme.surfaceVariant
            }

            val contentColor = when (step.state) {
                WgcStepState.COMPLETED, WgcStepState.CURRENT -> MaterialTheme.colorScheme.onPrimary
                WgcStepState.UPCOMING -> MaterialTheme.colorScheme.onSurfaceVariant
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(circleColor),
                    contentAlignment = Alignment.Center
                ) {
                    if (step.state == WgcStepState.COMPLETED) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Concluído",
                            tint = contentColor,
                            modifier = Modifier.size(16.dp)
                        )
                    } else {
                        Text(
                            text = (index + 1).toString(),
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold,
                            color = contentColor
                        )
                    }
                }

                Text(
                    text = step.title,
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = if (step.state == WgcStepState.CURRENT) FontWeight.Bold else FontWeight.Normal,
                    color = if (step.state == WgcStepState.CURRENT) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            if (index < steps.lastIndex) {
                val dividerColor = if (step.state == WgcStepState.COMPLETED) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.outlineVariant
                }

                HorizontalDivider(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = WgcCoreDsSpacing.xxs4.dp)
                        .padding(bottom = WgcCoreDsSpacing.md16.dp),
                    thickness = 2.dp,
                    color = dividerColor
                )
            }
        }
    }
}

@Preview(showBackground = true)
@WgcComponentPreviews
@Composable
private fun WgcStepIndicatorPreview() {
    MaterialTheme {
        Surface(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
            val sampleSteps = listOf(
                WgcStepItem(title = "Dados", state = WgcStepState.COMPLETED),
                WgcStepItem(title = "Endereço", state = WgcStepState.CURRENT),
                WgcStepItem(title = "Pagamento", state = WgcStepState.UPCOMING)
            )
            WgcStepIndicator(steps = sampleSteps)
        }
    }
}
