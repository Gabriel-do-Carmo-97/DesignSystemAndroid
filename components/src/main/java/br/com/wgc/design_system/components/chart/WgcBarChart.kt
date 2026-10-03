@file:Suppress("LongMethod", "MagicNumber", "MatchingDeclarationName")

package br.com.wgc.design_system.components.chart

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Ponto de dado para barra vertical.
 */
data class WgcBarData(
    val label: String,
    val value: Float
)

/**
 * WgcBarChart
 *
 * Gráfico de barras verticais corporativo desenhado em Canvas.
 */
@Composable
fun WgcBarChart(
    data: List<WgcBarData>,
    modifier: Modifier = Modifier,
    height: Dp = 180.dp,
    barColor: Color = MaterialTheme.colorScheme.primary,
    maxManualValue: Float? = null
) {
    val maxValue = maxManualValue ?: (data.maxOfOrNull { it.value }?.takeIf { it > 0f } ?: 1f)
    val animatedProgress by animateFloatAsState(targetValue = 1f, label = "bar_chart_anim")

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs.dp)
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(height)
        ) {
            val barCount = data.size
            if (barCount == 0) return@Canvas
            val totalSpacing = size.width * 0.2f
            val spacingPerBar = totalSpacing / (barCount + 1)
            val barWidth = (size.width - totalSpacing) / barCount

            data.forEachIndexed { index, item ->
                val fraction = (item.value / maxValue).coerceIn(0f, 1f) * animatedProgress
                val barHeight = size.height * fraction
                val topLeftX = spacingPerBar + index * (barWidth + spacingPerBar)
                val topLeftY = size.height - barHeight

                drawRoundRect(
                    color = barColor,
                    topLeft = Offset(topLeftX, topLeftY),
                    size = Size(barWidth, barHeight),
                    cornerRadius = CornerRadius(8f, 8f)
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            data.forEach { item ->
                Text(
                    text = item.label,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
