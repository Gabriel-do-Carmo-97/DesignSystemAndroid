@file:Suppress("LongMethod", "MatchingDeclarationName")

package br.com.wgc.design_system.components.tooltip

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.core.tokens.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing

/**
 * Balão de Walkthrough e Onboarding interativo para guiar novos usuários pelas funcionalidades.
 */
@Composable
fun WgcWalkthroughCard(
    step: WgcTourStep,
    onNext: () -> Unit,
    onPrevious: () -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.MD.dp),
        color = MaterialTheme.colorScheme.surfaceVariant,
        tonalElevation = 6.dp
    ) {
        Column(
            modifier = Modifier.padding(WgcCoreDsSpacing.MD.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.SM.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${step.stepIndex + 1} de ${step.totalSteps}",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary
                )
                TextButton(onClick = onDismiss) {
                    Text(
                        text = "Pular",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Text(
                text = step.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = step.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (step.stepIndex > 0) {
                    TextButton(onClick = onPrevious) {
                        Text(text = "Anterior")
                    }
                } else {
                    Box(modifier = Modifier)
                }

                WgcClassicButton(
                    text = if (step.stepIndex == step.totalSteps - 1) "Concluir" else "Próximo",
                    onClick = onNext
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcWalkthroughCardPreview() {
    MaterialTheme {
        WgcWalkthroughCard(
            step = WgcTourStep(
                stepIndex = 0,
                title = "Bem-vindo ao app",
                description = "Este é um tour guiado pelas principais funcionalidades do sistema.",
                totalSteps = 3
            ),
            onNext = {},
            onPrevious = {},
            onDismiss = {}
        )
    }
}
