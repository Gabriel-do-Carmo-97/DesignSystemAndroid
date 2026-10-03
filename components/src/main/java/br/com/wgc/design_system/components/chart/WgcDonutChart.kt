@file:Suppress("LongMethod", "MagicNumber", "MatchingDeclarationName")

package br.com.wgc.design_system.components.chart

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Fatia individual do gráfico Donut.
 */
data class WgcDonutSlice(
    val value: Float,
    val color: Color,
    val label: String = ""
)

/**
 * WgcDonutChart
 *
 * Gráfico de rosca (Donut Chart) desenhado em Canvas para composição percentual de dados e despesas.
 */
@Composable
fun WgcDonutChart(
    slices: List<WgcDonutSlice>,
    modifier: Modifier = Modifier,
    size: Dp = 140.dp,
    strokeWidth: Dp = 20.dp,
    centerContentSlot: (@Composable () -> Unit)? = null
) {
    val total = slices.sumOf { it.value.toDouble() }.toFloat().takeIf { it > 0f } ?: 1f
    val animatedFraction by animateFloatAsState(targetValue = 1f, label = "donut_anim")

    Box(
        modifier = modifier.size(size),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.size(size)) {
            var currentStartAngle = -90f
            val strokePx = strokeWidth.toPx()

            slices.forEach { slice ->
                val sweepAngle = (slice.value / total) * 360f * animatedFraction
                drawArc(
                    color = slice.color,
                    startAngle = currentStartAngle,
                    sweepAngle = sweepAngle,
                    useCenter = false,
                    style = Stroke(width = strokePx, cap = StrokeCap.Butt)
                )
                currentStartAngle += sweepAngle
            }
        }

        centerContentSlot?.invoke()
    }
}
