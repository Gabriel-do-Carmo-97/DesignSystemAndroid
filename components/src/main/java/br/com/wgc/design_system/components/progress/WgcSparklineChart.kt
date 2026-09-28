package br.com.wgc.design_system.components.progress

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.commons.WgcComponentPreviews
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Mini Gráfico de Linha (Sparkline) Corporativo (WgcSparklineChart).
 * Renderiza tendências e séries temporais de forma leve sem dependências externas via Canvas.
 *
 * @param dataPoints Lista de valores numéricos para plotagem.
 * @param modifier Modificador de layout.
 * @param lineColor Cor da linha do gráfico.
 * @param strokeWidth Espessura da linha em dp.
 */
@Composable
fun WgcSparklineChart(
    dataPoints: List<Float>,
    modifier: Modifier = Modifier,
    lineColor: Color = MaterialTheme.colorScheme.primary,
    strokeWidth: Float = 4f
) {
    if (dataPoints.size < 2) return

    val minVal = dataPoints.minOrNull() ?: 0f
    val maxVal = dataPoints.maxOrNull() ?: 1f
    val range = if (maxVal == minVal) 1f else maxVal - minVal

    Canvas(modifier = modifier.height(48.dp).fillMaxWidth()) {
        val width = size.width
        val height = size.height
        val stepX = width / (dataPoints.size - 1)

        val path = Path()
        dataPoints.forEachIndexed { index, point ->
            val x = index * stepX
            val normalizedY = (point - minVal) / range
            val y = height - (normalizedY * height)

            if (index == 0) {
                path.moveTo(x, y)
            } else {
                path.lineTo(x, y)
            }
        }

        drawPath(
            path = path,
            color = lineColor,
            style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
        )
    }
}

/**
 * Item individual para grupo de progresso em barras agrupadas.
 */
data class WgcProgressSegment(
    val label: String,
    val value: Float,
    val color: Color
)

/**
 * Grupo de Barras de Progresso Corporativo (WgcProgressBarGroup).
 */
@Composable
fun WgcProgressBarGroup(
    segments: List<WgcProgressSegment>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
    ) {
        segments.forEach { segment ->
            Column(verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxxs2.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = segment.label, style = MaterialTheme.typography.bodySmall)
                    Text(
                        text = "${(segment.value * 100).toInt()}%",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                LinearProgressIndicator(
                    progress = { segment.value },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)),
                    color = segment.color,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant
                )
            }
        }
    }
}

@Suppress("MagicNumber")
@Preview(showBackground = true)
@WgcComponentPreviews
@Composable
private fun WgcSparklineChartPreview() {
    MaterialTheme {
        Surface(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
            Column(verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)) {
                WgcSparklineChart(dataPoints = listOf(10f, 25f, 15f, 40f, 35f, 60f, 85f))
                WgcProgressBarGroup(
                    segments = listOf(
                        WgcProgressSegment("Meta de Vendas", 0.75f, MaterialTheme.colorScheme.primary),
                        WgcProgressSegment("Conversão", 0.45f, MaterialTheme.colorScheme.secondary)
                    )
                )
            }
        }
    }
}
