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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Estado de cada etapa do rastreamento Clothee.
 */
enum class WgcClotheeStepState {
    COMPLETED,
    IN_PROGRESS,
    PENDING
}

/**
 * Modelo de etapa para a timeline Clothee.
 */
data class WgcClotheeTimelineStep(
    val title: String,
    val subtitle: String,
    val state: WgcClotheeStepState
)

/**
 * Linha do tempo vertical do ecossistema Clothee (WgcApparelOrderTimeline).
 * Exibe ícones circulares em roxo (#8E6CEF) com checkmarks para etapas completadas
 * e linhas verticais conectando os estágios da entrega.
 */
@Composable
fun WgcApparelOrderTimeline(
    modifier: Modifier = Modifier,
    steps: List<WgcClotheeTimelineStep>
) {
    Column(modifier = modifier.fillMaxWidth()) {
        steps.forEachIndexed { index, step ->
            val isLast = index == steps.lastIndex
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ) {
                // Coluna do círculo e linha conectora
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val circleBg = when (step.state) {
                        WgcClotheeStepState.COMPLETED,
                        WgcClotheeStepState.IN_PROGRESS -> Color(WgcCoreDsColors.apparelPrimary)
                        WgcClotheeStepState.PENDING -> Color(WgcCoreDsColors.apparelSurface)
                    }

                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(circleBg),
                        contentAlignment = Alignment.Center
                    ) {
                        if (step.state == WgcClotheeStepState.COMPLETED) {
                            Icon(
                                imageVector = Icons.Filled.Check,
                                contentDescription = "Concluído",
                                tint = Color.White,
                                modifier = Modifier.size(18.dp)
                            )
                        } else if (step.state == WgcClotheeStepState.IN_PROGRESS) {
                            Box(
                                modifier = Modifier
                                    .size(10.dp)
                                    .clip(CircleShape)
                                    .background(Color.White)
                            )
                        }
                    }

                    if (!isLast) {
                        val lineColor = if (step.state == WgcClotheeStepState.COMPLETED) {
                            Color(WgcCoreDsColors.apparelPrimary)
                        } else {
                            Color(WgcCoreDsColors.apparelBorder)
                        }
                        Box(
                            modifier = Modifier
                                .width(2.dp)
                                .height(36.dp)
                                .background(lineColor)
                        )
                    }
                }

                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md16.dp))

                // Detalhes da etapa
                Column(
                    modifier = Modifier
                        .padding(top = WgcCoreDsSpacing.xxs4.dp)
                        .weight(1f)
                ) {
                    Text(
                        text = step.title,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        color = if (step.state == WgcClotheeStepState.PENDING) {
                            Color(WgcCoreDsColors.apparelSecondaryText)
                        } else {
                            Color(WgcCoreDsColors.apparelDark)
                        }
                    )
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxxs2.dp))
                    Text(
                        text = step.subtitle,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(WgcCoreDsColors.apparelSecondaryText)
                    )
                    if (!isLast) {
                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcClotheeOrderTimelinePreview() {
    WgcApparelOrderTimeline(
        steps = listOf(
            WgcClotheeTimelineStep(
                title = "Order Placed",
                subtitle = "28 May 2026, 10:30 AM",
                state = WgcClotheeStepState.COMPLETED
            ),
            WgcClotheeTimelineStep(
                title = "Order Confirmed",
                subtitle = "28 May 2026, 11:00 AM",
                state = WgcClotheeStepState.COMPLETED
            ),
            WgcClotheeTimelineStep(
                title = "Order Shipped",
                subtitle = "29 May 2026, 08:15 AM",
                state = WgcClotheeStepState.IN_PROGRESS
            ),
            WgcClotheeTimelineStep(
                title = "Delivered",
                subtitle = "Estimated 31 May 2026",
                state = WgcClotheeStepState.PENDING
            )
        )
    )
}
