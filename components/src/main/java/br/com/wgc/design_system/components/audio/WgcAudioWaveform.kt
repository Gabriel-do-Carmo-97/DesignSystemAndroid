@file:Suppress("LongMethod", "MagicNumber")

package br.com.wgc.design_system.components.audio

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * WgcAudioWaveform
 *
 * Visualizador de ondas sonoras de áudio corporativo desenhado em Canvas.
 *
 * @param amplitudes Lista normalizada de amplitudes (0.0f a 1.0f).
 * @param playbackProgress Progresso da reprodução de 0.0f a 1.0f.
 * @param modifier Modificador de layout.
 * @param height Altura do visualizador.
 * @param playedColor Cor das barras já tocadas.
 * @param unplayedColor Cor das barras pendentes.
 */
@Composable
fun WgcAudioWaveform(
    amplitudes: List<Float>,
    playbackProgress: Float,
    modifier: Modifier = Modifier,
    height: Dp = 48.dp,
    playedColor: Color = MaterialTheme.colorScheme.primary,
    unplayedColor: Color = MaterialTheme.colorScheme.outlineVariant
) {
    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
    ) {
        val count = amplitudes.size
        if (count == 0) return@Canvas

        val barWidth = 4.dp.toPx()
        val spacing = 3.dp.toPx()
        val totalBarSpace = barWidth + spacing
        val startX = (size.width - (count * totalBarSpace - spacing)) / 2f

        amplitudes.forEachIndexed { index, amp ->
            val fraction = (index.toFloat() / count.toFloat())
            val isPlayed = fraction <= playbackProgress
            val barHeight = (size.height * amp.coerceIn(0.1f, 1.0f))
            val x = startX + index * totalBarSpace
            val y = (size.height - barHeight) / 2f

            drawRoundRect(
                color = if (isPlayed) playedColor else unplayedColor,
                topLeft = Offset(x, y),
                size = Size(barWidth, barHeight),
                cornerRadius = CornerRadius(4f, 4f)
            )
        }
    }
}
