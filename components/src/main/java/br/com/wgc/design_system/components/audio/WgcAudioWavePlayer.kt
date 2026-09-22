@file:Suppress("UnusedPrivateMember", "MagicNumber")

package br.com.wgc.design_system.components.audio

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing

private const val WAVEFORM_HEIGHT_DP = 48
private const val BAR_WIDTH_DP = 3
private const val BAR_GAP_DP = 2
private const val SPEED_NORMAL = 1.0f
private const val SPEED_FAST = 1.5f
private const val SPEED_DOUBLE = 2.0f

/**
 * Componente corporativo de reprodução de áudio e notas de voz com visualizador de ondas sonoras (waveform).
 *
 * @param modifier Modificador de layout
 * @param isPlaying Se o áudio está em reprodução ativa
 * @param progress Progresso da reprodução entre 0.0f e 1.0f
 * @param currentTimeText Texto formatado do tempo atual (ex: "01:23")
 * @param durationText Texto formatado da duração total (ex: "03:45")
 * @param amplitudes Lista de amplitudes normalizadas entre 0.0f e 1.0f
 * @param playbackSpeed Velocidade atual da reprodução (1.0f, 1.5f, 2.0f)
 * @param onPlayPauseClick Callback para alternar reprodução
 * @param onSeek Callback acionado ao tocar na barra de ondas
 * @param onSpeedChange Callback para alteração da velocidade
 */
@Composable
fun WgcAudioWavePlayer(
    modifier: Modifier = Modifier,
    isPlaying: Boolean = false,
    progress: Float = 0f,
    currentTimeText: String = "00:00",
    durationText: String = "00:00",
    amplitudes: List<Float> = defaultAmplitudes(),
    playbackSpeed: Float = SPEED_NORMAL,
    onPlayPauseClick: () -> Unit = {},
    onSeek: (Float) -> Unit = {},
    onSpeedChange: (Float) -> Unit = {}
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
            ) {
                PlayPauseButton(
                    isPlaying = isPlaying,
                    onClick = onPlayPauseClick
                )

                WaveformView(
                    modifier = Modifier.weight(1f),
                    amplitudes = amplitudes,
                    progress = progress,
                    activeColor = MaterialTheme.colorScheme.primary,
                    inactiveColor = MaterialTheme.colorScheme.outlineVariant,
                    onSeek = onSeek
                )
            }

            AudioTimeAndSpeedRow(
                currentTimeText = currentTimeText,
                durationText = durationText,
                playbackSpeed = playbackSpeed,
                onSpeedChange = onSpeedChange
            )
        }
    }
}

@Composable
private fun PlayPauseButton(
    isPlaying: Boolean,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        shape = CircleShape,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.size(WgcCoreDsSpacing.xxl40.dp)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Icon(
                imageVector = if (isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                contentDescription = if (isPlaying) "Pausar" else "Reproduzir",
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Composable
private fun WaveformView(
    amplitudes: List<Float>,
    progress: Float,
    activeColor: Color,
    inactiveColor: Color,
    onSeek: (Float) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(WAVEFORM_HEIGHT_DP.dp)
            .pointerInput(Unit) {
                detectTapGestures { offset ->
                    val ratio = (offset.x / size.width).coerceIn(0f, 1f)
                    onSeek(ratio)
                }
            }
    ) {
        Canvas(modifier = Modifier.fillMaxWidth().height(WAVEFORM_HEIGHT_DP.dp)) {
            val totalBars = amplitudes.size
            if (totalBars == 0) return@Canvas

            val barWidthPx = BAR_WIDTH_DP.dp.toPx()
            val gapPx = BAR_GAP_DP.dp.toPx()
            val totalNeededWidth = totalBars * (barWidthPx + gapPx)
            val step = size.width / totalBars

            val currentProgressX = size.width * progress

            for (i in 0 until totalBars) {
                val amplitude = amplitudes[i].coerceIn(0.1f, 1f)
                val barHeightPx = size.height * amplitude
                val x = i * step + (step - barWidthPx) / 2
                val y = (size.height - barHeightPx) / 2

                val color = if (x <= currentProgressX) activeColor else inactiveColor

                drawRoundRect(
                    color = color,
                    topLeft = Offset(x, y),
                    size = Size(barWidthPx, barHeightPx),
                    cornerRadius = CornerRadius(barWidthPx / 2, barWidthPx / 2)
                )
            }
        }
    }
}

@Composable
private fun AudioTimeAndSpeedRow(
    currentTimeText: String,
    durationText: String,
    playbackSpeed: Float,
    onSpeedChange: (Float) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$currentTimeText / $durationText",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Row(horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)) {
            val speeds = listOf(SPEED_NORMAL, SPEED_FAST, SPEED_DOUBLE)
            for (speed in speeds) {
                FilterChip(
                    selected = playbackSpeed == speed,
                    onClick = { onSpeedChange(speed) },
                    label = { Text("${speed}x", style = MaterialTheme.typography.labelSmall) },
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp),
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                        selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                )
            }
        }
    }
}

private fun defaultAmplitudes(): List<Float> {
    return listOf(
        0.2f, 0.4f, 0.7f, 0.3f, 0.9f, 0.5f, 0.8f, 0.4f, 0.6f, 0.3f,
        0.9f, 0.7f, 0.5f, 0.2f, 0.6f, 0.8f, 0.4f, 0.7f, 0.9f, 0.3f,
        0.5f, 0.8f, 0.2f, 0.6f, 0.7f, 0.4f, 0.8f, 0.9f, 0.5f, 0.3f
    )
}

@Preview(name = "WgcAudioWavePlayer Preview", showBackground = true)
@Composable
private fun WgcAudioWavePlayerPreview() {
    MaterialTheme {
        WgcAudioWavePlayer(
            isPlaying = true,
            progress = 0.45f,
            currentTimeText = "01:15",
            durationText = "02:40"
        )
    }
}
