package br.com.wgc.design_system.components.tracking

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * Estado de uma etapa de rastreamento.
 */
enum class WgcKutukuStepStatus {
    COMPLETED,
    IN_PROGRESS,
    PENDING
}

/**
 * Modelo de dado para um item da timeline do Kutuku.
 */
data class WgcKutukuTrackingStepItem(
    val title: String,
    val subtitle: String,
    val time: String,
    val status: WgcKutukuStepStatus,
    val icon: ImageVector? = null
)

/**
 * Linha do tempo vertical oficial de rastreamento do Kutuku (WgcKutukuOrderTrackingStepper).
 */
@Composable
fun WgcKutukuOrderTrackingStepper(
    modifier: Modifier = Modifier,
    steps: List<WgcKutukuTrackingStepItem>
) {
    Column(modifier = modifier.fillMaxWidth()) {
        steps.forEachIndexed { index, step ->
            val isLast = index == steps.lastIndex
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ) {
                // Coluna do Ícone + Linha vertical
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val (circleBg, iconColor) = when (step.status) {
                        WgcKutukuStepStatus.COMPLETED,
                        WgcKutukuStepStatus.IN_PROGRESS -> Pair(
                            Color(WgcCoreDsColors.kutukuPrimary),
                            Color.White
                        )
                        WgcKutukuStepStatus.PENDING -> Pair(
                            Color(WgcCoreDsColors.kutukuBackground),
                            Color(WgcCoreDsColors.kutukuSecondaryText)
                        )
                    }

                    Box(
                        modifier = Modifier
                            .size(44.dp)
                            .clip(CircleShape)
                            .background(circleBg),
                        contentAlignment = Alignment.Center
                    ) {
                        val iconVector = step.icon ?: when (index) {
                            0 -> Icons.Filled.Storefront
                            1 -> Icons.Filled.LocalShipping
                            else -> Icons.Filled.LocationOn
                        }
                        Icon(
                            imageVector = iconVector,
                            contentDescription = step.title,
                            tint = iconColor,
                            modifier = Modifier.size(20.dp)
                        )
                    }

                    if (!isLast) {
                        val lineColor = if (step.status == WgcKutukuStepStatus.COMPLETED) {
                            Color(WgcCoreDsColors.kutukuPrimary)
                        } else {
                            Color(WgcCoreDsColors.kutukuBorder)
                        }
                        Box(
                            modifier = Modifier
                                .width(2.dp)
                                .height(36.dp)
                                .background(lineColor)
                        )
                    }
                }

                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md.dp))

                // Texto da etapa
                Column(
                    modifier = Modifier
                        .padding(top = WgcCoreDsSpacing.xs.dp)
                        .weight(1f)
                ) {
                    Text(
                        text = step.title,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.kutukuDark)
                    )
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxxs.dp))
                    Text(
                        text = "${step.subtitle} • ${step.time}",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(WgcCoreDsColors.kutukuSecondaryText)
                    )
                    if (!isLast) {
                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcKutukuOrderTrackingStepperPreview() {
    WgcKutukuOrderTrackingStepper(
        steps = listOf(
            WgcKutukuTrackingStepItem(
                title = "Upbox Bag",
                subtitle = "Shop",
                time = "02:50 PM",
                status = WgcKutukuStepStatus.COMPLETED
            ),
            WgcKutukuTrackingStepItem(
                title = "On the way",
                subtitle = "Delivery",
                time = "03:20 PM",
                status = WgcKutukuStepStatus.IN_PROGRESS
            ),
            WgcKutukuTrackingStepItem(
                title = "5482 Adobe Falls Rd #15San Diego",
                subtitle = "Houser",
                time = "03:45 PM",
                status = WgcKutukuStepStatus.PENDING
            )
        )
    )
}
