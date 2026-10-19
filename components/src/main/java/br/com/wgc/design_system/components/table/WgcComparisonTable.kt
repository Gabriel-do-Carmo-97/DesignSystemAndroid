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
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.core.tokens.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing
import br.com.wgc.design_system.theme.WgcTheme

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
                    Modifier.border(2.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(WgcCoreDsBorderRadius.MD.dp))
                } else Modifier
            ),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.MD.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (plan.isHighlighted) MaterialTheme.colorScheme.surfaceVariant else MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier.padding(WgcCoreDsSpacing.LG.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.MD.dp),
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
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.SM.dp)
            ) {
                plan.features.forEach { feature ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.SM.dp),
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

@Preview(name = "WgcComparisonCard - Preview", showBackground = true)
@Composable
private fun WgcComparisonCardPreview() {
    WgcTheme {
        WgcComparisonCard(
            modifier = Modifier.padding(16.dp),
            plan = WgcPricingPlan(
                id = "plan_pro",
                name = "Plano Profissional",
                price = "R$ 49,90/mês",
                isHighlighted = true,
                features = listOf(
                    WgcPlanFeature(name = "Acesso ilimitado a todos os recursos", included = true),
                    WgcPlanFeature(name = "Suporte prioritário 24/7", included = true),
                    WgcPlanFeature(name = "Exportação avançada em PDF", included = false)
                ),
                buttonLabel = "Escolher Plano"
            ),
            onSelectPlan = {}
        )
    }
}
