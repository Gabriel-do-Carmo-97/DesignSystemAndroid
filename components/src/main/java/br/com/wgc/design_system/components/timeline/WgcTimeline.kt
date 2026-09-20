@file:Suppress("MatchingDeclarationName")

package br.com.wgc.design_system.components.timeline

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.commons.WgcComponentPreviews
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Estado de cada etapa da linha do tempo.
 */
enum class WgcTimelineStatus {
    COMPLETED,
    CURRENT,
    PENDING
}

/**
 * Modelo de dados para um item da linha do tempo.
 */
data class WgcTimelineItem(
    val title: String,
    val description: String? = null,
    val timestamp: String? = null,
    val status: WgcTimelineStatus = WgcTimelineStatus.PENDING,
    val icon: (@Composable () -> Unit)? = null
)

/**
 * Componente corporativo de Linha do Tempo (WgcTimeline).
 *
 * Utilizado para rastreamento de entregas, histórico de transações, esteiras de aprovação
 * e acompanhamento de etapas de processos corporativos.
 *
 * @param items Lista sequencial de etapas [WgcTimelineItem].
 * @param modifier Modificador de layout.
 */
@Composable
fun WgcTimeline(
    items: List<WgcTimelineItem>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        items.forEachIndexed { index, item ->
            val isLast = index == items.lastIndex
            WgcTimelineRow(
                item = item,
                isLast = isLast
            )
        }
    }
}

@Suppress("LongMethod", "CyclomaticComplexMethod")
@Composable
private fun WgcTimelineRow(
    item: WgcTimelineItem,
    isLast: Boolean
) {
    val nodeColor = when (item.status) {
        WgcTimelineStatus.COMPLETED -> MaterialTheme.colorScheme.primary
        WgcTimelineStatus.CURRENT -> MaterialTheme.colorScheme.primary
        WgcTimelineStatus.PENDING -> MaterialTheme.colorScheme.outlineVariant
    }

    val lineColor = when (item.status) {
        WgcTimelineStatus.COMPLETED -> MaterialTheme.colorScheme.primary
        else -> MaterialTheme.colorScheme.outlineVariant
    }

    Row(modifier = Modifier.fillMaxWidth()) {
        // Coluna do nó e da linha conectiva
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.width(32.dp)
        ) {
            WgcTimelineNode(item = item, nodeColor = nodeColor)

            // Linha conectiva vertical
            if (!isLast) {
                Box(
                    modifier = Modifier
                        .width(2.dp)
                        .height(48.dp)
                        .background(lineColor)
                )
            }
        }

        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))

        // Conteúdo textual da etapa
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(bottom = if (isLast) 0.dp else WgcCoreDsSpacing.md16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = if (item.status == WgcTimelineStatus.CURRENT) FontWeight.Bold else FontWeight.SemiBold,
                    color = if (item.status == WgcTimelineStatus.PENDING) {
                        MaterialTheme.colorScheme.onSurfaceVariant
                    } else {
                        MaterialTheme.colorScheme.onSurface
                    },
                    modifier = Modifier.weight(1f)
                )

                if (!item.timestamp.isNullOrBlank()) {
                    Text(
                        text = item.timestamp,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
            }

            if (!item.description.isNullOrBlank()) {
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

@Composable
private fun WgcTimelineNode(
    item: WgcTimelineItem,
    nodeColor: Color
) {
    Surface(
        modifier = Modifier
            .size(24.dp)
            .clip(CircleShape),
        shape = CircleShape,
        color = when (item.status) {
            WgcTimelineStatus.COMPLETED -> nodeColor
            WgcTimelineStatus.CURRENT -> MaterialTheme.colorScheme.surface
            WgcTimelineStatus.PENDING -> MaterialTheme.colorScheme.surface
        },
        border = when (item.status) {
            WgcTimelineStatus.CURRENT -> androidx.compose.foundation.BorderStroke(2.dp, nodeColor)
            WgcTimelineStatus.PENDING -> androidx.compose.foundation.BorderStroke(1.dp, nodeColor)
            else -> null
        }
    ) {
        Box(contentAlignment = Alignment.Center) {
            if (item.icon != null) {
                item.icon.invoke()
            } else if (item.status == WgcTimelineStatus.COMPLETED) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(14.dp)
                )
            } else if (item.status == WgcTimelineStatus.CURRENT) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(nodeColor)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@WgcComponentPreviews
@Composable
private fun WgcTimelinePreview() {
    MaterialTheme {
        Column(modifier = Modifier.padding(16.dp)) {
            WgcTimeline(
                items = listOf(
                    WgcTimelineItem(
                        title = "Pedido Confirmado",
                        description = "Pagamento aprovado via PIX.",
                        timestamp = "14:20",
                        status = WgcTimelineStatus.COMPLETED
                    ),
                    WgcTimelineItem(
                        title = "Em Preparação",
                        description = "O restaurante está montando seu pedido.",
                        timestamp = "14:35",
                        status = WgcTimelineStatus.CURRENT
                    ),
                    WgcTimelineItem(
                        title = "Saiu para Entrega",
                        description = "Entregador a caminho do endereço.",
                        timestamp = "14:50",
                        status = WgcTimelineStatus.PENDING
                    ),
                    WgcTimelineItem(
                        title = "Entregue",
                        description = "Pedido recebido pelo cliente.",
                        status = WgcTimelineStatus.PENDING
                    )
                )
            )
        }
    }
}
