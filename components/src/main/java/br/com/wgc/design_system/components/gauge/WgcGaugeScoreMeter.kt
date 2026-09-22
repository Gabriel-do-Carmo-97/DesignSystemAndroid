@file:Suppress("UnusedPrivateMember")

package br.com.wgc.design_system.components.gauge

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

private const val START_ANGLE = 180f
private const val SWEEP_ANGLE = 180f
private const val GAUGE_STROKE_WIDTH_DP = 16
private const val ANIMATION_DURATION_MS = 1000
private const val GAUGE_HEIGHT_DP = 160
private const val RADIAN_MULTIPLIER = PI / 180.0

/**
 * Componente corporativo de velocímetro / medidor de score (Gauge) para pontuação de crédito, metas e limites.
 *
 * @param score Pontuação atual
 * @param minScore Pontuação mínima da escala
 * @param maxScore Pontuação máxima da escala
 * @param scoreLabel Classificação da pontuação (ex: "Excelente", "Bom", "Regular", "Baixo")
 * @param subtitle Texto complementar descritivo
 * @param modifier Modificador de layout
 */
@Composable
fun WgcGaugeScoreMeter(
    score: Int,
    modifier: Modifier = Modifier,
    minScore: Int = 0,
    maxScore: Int = 1000,
    scoreLabel: String = "Bom",
    subtitle: String = "Atualizado em tempo real"
) {
    val totalRange = (maxScore - minScore).coerceAtLeast(1)
    val targetRatio = ((score - minScore).toFloat() / totalRange).coerceIn(0f, 1f)

    val animatedRatio by animateFloatAsState(
        targetValue = targetRatio,
        animationSpec = tween(durationMillis = ANIMATION_DURATION_MS, easing = FastOutSlowInEasing),
        label = "GaugeRatio"
    )

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
        ) {
            Text(
                text = "Score Financeiro",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            GaugeCanvas(
                animatedRatio = animatedRatio,
                score = score,
                scoreLabel = scoreLabel
            )

            Text(
                text = subtitle,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.outline
            )
        }
    }
}

@Composable
private fun GaugeCanvas(
    animatedRatio: Float,
    score: Int,
    scoreLabel: String
) {
    val trackColor = MaterialTheme.colorScheme.outlineVariant
    val activeColor = resolveScoreColor(animatedRatio)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(GAUGE_HEIGHT_DP.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Canvas(modifier = Modifier.fillMaxWidth().height(GAUGE_HEIGHT_DP.dp)) {
            val strokeWidthPx = GAUGE_STROKE_WIDTH_DP.dp.toPx()
            val diameter = size.width - strokeWidthPx * 2
            val arcSize = Size(diameter, diameter)
            val topLeft = Offset(strokeWidthPx, size.height - diameter / 2)

            // Arco de Fundo (Track inativo)
            drawArc(
                color = trackColor,
                startAngle = START_ANGLE,
                sweepAngle = SWEEP_ANGLE,
                useCenter = false,
                topLeft = topLeft,
                size = arcSize,
                style = Stroke(width = strokeWidthPx, cap = StrokeCap.Round)
            )

            // Arco Preenchido Dinâmico
            drawArc(
                color = activeColor,
                startAngle = START_ANGLE,
                sweepAngle = SWEEP_ANGLE * animatedRatio,
                useCenter = false,
                topLeft = topLeft,
                size = arcSize,
                style = Stroke(width = strokeWidthPx, cap = StrokeCap.Round)
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(bottom = WgcCoreDsSpacing.sm12.dp)
        ) {
            Text(
                text = score.toString(),
                style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = scoreLabel,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.SemiBold,
                color = activeColor
            )
        }
    }
}

@Composable
private fun resolveScoreColor(ratio: Float): Color {
    val lowThreshold = 0.35f
    val mediumThreshold = 0.70f

    return when {
        ratio < lowThreshold -> MaterialTheme.colorScheme.error
        ratio < mediumThreshold -> MaterialTheme.colorScheme.tertiary
        else -> MaterialTheme.colorScheme.primary
    }
}

@Preview(name = "WgcGaugeScoreMeter Preview", showBackground = true)
@Composable
private fun WgcGaugeScoreMeterPreview() {
    MaterialTheme {
        WgcGaugeScoreMeter(
            score = 785,
            scoreLabel = "Excelente"
        )
    }
}
