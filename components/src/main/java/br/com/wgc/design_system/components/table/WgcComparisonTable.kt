@file:Suppress("LongMethod", "MagicNumber")

package br.com.wgc.design_system.components.table

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Feature comparada de um plano.
 */
data class WgcPlanFeature(
    val name: String,
    val included: Boolean
)

/**
 * Plano comparativo.
 */
data class WgcPricingPlan(
    val id: String,
    val name: String,
    val price: String,
    val isHighlighted: Boolean = false,
    val features: List<WgcPlanFeature>,
    val buttonLabel: String = "Escolher Plano"
)

/**
 * WgcComparisonCard
 *
 * Card de comparação de preços e funcionalidades para planos de assinatura.
 */
@Composable
fun WgcComparisonCard(
    plan: WgcPricingPlan,
    onSelectPlan: (WgcPricingPlan) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .then(
                if (plan.isHighlighted) {
                    Modifier.border(2.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(WgcCoreDsBorderRadius.md.dp))
                } else Modifier
            ),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (plan.isHighlighted) MaterialTheme.colorScheme.surfaceVariant else MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier.padding(WgcCoreDsSpacing.lg.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = plan.name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = plan.price,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            HorizontalDivider()

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm.dp)
            ) {
                plan.features.forEach { feature ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = if (feature.included) Icons.Default.Check else Icons.Default.Close,
                            contentDescription = null,
                            tint = if (feature.included) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline
                        )
                        Text(
                            text = feature.name,
                            style = MaterialTheme.typography.bodyMedium,
                            color = if (feature.included) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            WgcClassicButton(
                text = plan.buttonLabel,
                onClick = { onSelectPlan(plan) },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
