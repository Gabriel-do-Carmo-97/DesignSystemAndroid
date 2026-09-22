@file:Suppress("UnusedPrivateMember")

package br.com.wgc.design_system.components.timeline

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.HourglassTop
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
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
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing

private const val LINE_WIDTH_DP = 2
private const val NODE_SIZE_DP = 28
private const val MINI_ICON_SIZE_DP = 16

/**
 * Estados possíveis para uma etapa na linha do tempo.
 */
enum class WgcTimelineState {
    Completed,
    InProgress,
    Pending,
    Failed
}

/**
 * Orientação da linha do tempo corporativa.
 */
enum class WgcTimelineOrientation {
    Vertical,
    Horizontal
}

/**
 * Modelo de dados de um item da linha do tempo.
 */
data class WgcTimelineStep(
    val id: String,
    val title: String,
    val description: String? = null,
    val timestamp: String? = null,
    val state: WgcTimelineState = WgcTimelineState.Pending
)

/**
 * Componente corporativo de rastreamento de etapas e esteiras (pedidos, empréstimos, entregas).
 *
 * @param items Lista de etapas ordenadas cronologicamente
 * @param modifier Modificador de layout
 * @param orientation Orientação vertical ou horizontal
 */
@Composable
fun WgcTimelineTracker(
    items: List<WgcTimelineStep>,
    modifier: Modifier = Modifier,
    orientation: WgcTimelineOrientation = WgcTimelineOrientation.Vertical
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp)
        ) {
            if (orientation == WgcTimelineOrientation.Vertical) {
                VerticalTimeline(items = items)
            } else {
                HorizontalTimeline(items = items)
            }
        }
    }
}

@Composable
private fun VerticalTimeline(items: List<WgcTimelineStep>) {
    val total = items.size
    for (i in 0 until total) {
        val item = items[i]
        val isLast = i == total - 1

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                TimelineNodeIndicator(state = item.state)
                if (!isLast) {
                    Box(
                        modifier = Modifier
                            .width(LINE_WIDTH_DP.dp)
                            .height(WgcCoreDsSpacing.xxxl48.dp)
                            .background(resolveLineColor(item.state))
                    )
                }
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = if (isLast) 0.dp else WgcCoreDsSpacing.md16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    if (item.timestamp != null) {
                        Text(
                            text = item.timestamp,
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.outline
                        )
                    }
                }
                if (item.description != null) {
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                    Text(
                        text = item.description,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

@Composable
private fun HorizontalTimeline(items: List<WgcTimelineStep>) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val total = items.size
        for (i in 0 until total) {
            val item = items[i]
            val isLast = i == total - 1

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                TimelineNodeIndicator(state = item.state)
                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Medium,
                    maxLines = 1
                )
            }

            if (!isLast) {
                Box(
                    modifier = Modifier
                        .height(LINE_WIDTH_DP.dp)
                        .weight(1f)
                        .background(resolveLineColor(item.state))
                )
            }
        }
    }
}

@Composable
private fun TimelineNodeIndicator(state: WgcTimelineState) {
    val (bgColor, contentColor) = when (state) {
        WgcTimelineState.Completed -> Pair(MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.onPrimary)
        WgcTimelineState.InProgress -> Pair(MaterialTheme.colorScheme.primaryContainer, MaterialTheme.colorScheme.onPrimaryContainer)
        WgcTimelineState.Pending -> Pair(MaterialTheme.colorScheme.outlineVariant, MaterialTheme.colorScheme.onSurfaceVariant)
        WgcTimelineState.Failed -> Pair(MaterialTheme.colorScheme.error, MaterialTheme.colorScheme.onError)
    }

    Box(
        modifier = Modifier
            .size(NODE_SIZE_DP.dp)
            .clip(CircleShape)
            .background(bgColor),
        contentAlignment = Alignment.Center
    ) {
        when (state) {
            WgcTimelineState.Completed -> Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "Concluído",
                tint = contentColor,
                modifier = Modifier.size(MINI_ICON_SIZE_DP.dp)
            )
            WgcTimelineState.InProgress -> CircularProgressIndicator(
                modifier = Modifier.size(MINI_ICON_SIZE_DP.dp),
                color = contentColor,
                strokeWidth = LINE_WIDTH_DP.dp
            )
            WgcTimelineState.Failed -> Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Falha",
                tint = contentColor,
                modifier = Modifier.size(MINI_ICON_SIZE_DP.dp)
            )
            WgcTimelineState.Pending -> Icon(
                imageVector = Icons.Default.HourglassTop,
                contentDescription = "Pendente",
                tint = contentColor,
                modifier = Modifier.size(MINI_ICON_SIZE_DP.dp)
            )
        }
    }
}

@Composable
private fun resolveLineColor(state: WgcTimelineState): Color {
    return when (state) {
        WgcTimelineState.Completed -> MaterialTheme.colorScheme.primary
        WgcTimelineState.InProgress -> MaterialTheme.colorScheme.primary
        WgcTimelineState.Failed -> MaterialTheme.colorScheme.error
        WgcTimelineState.Pending -> MaterialTheme.colorScheme.outlineVariant
    }
}

@Preview(name = "WgcTimelineTracker Preview", showBackground = true)
@Composable
private fun WgcTimelineTrackerPreview() {
    MaterialTheme {
        WgcTimelineTracker(
            items = listOf(
                WgcTimelineStep(id = "1", title = "Pedido Confirmado", timestamp = "10:30", state = WgcTimelineState.Completed),
                WgcTimelineStep(id = "2", title = "Em Separação", timestamp = "11:00", state = WgcTimelineState.Completed),
                WgcTimelineStep(id = "3", title = "Em Trânsito", timestamp = "14:15", state = WgcTimelineState.InProgress),
                WgcTimelineStep(id = "4", title = "Entregue", state = WgcTimelineState.Pending)
            )
        )
    }
}
