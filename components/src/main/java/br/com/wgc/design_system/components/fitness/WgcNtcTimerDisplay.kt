package br.com.wgc.design_system.components.fitness

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material.icons.filled.FastForward
import androidx.compose.material.icons.filled.FastRewind
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * Display de Contagem Regressiva e Player de Treino NTC.
 *
 * Apresenta o exercício em andamento, cronômetro de alta precisão,
 * barra de progresso visual em tom Volt, próxima série e controles
 * de reprodução guiada por áudio.
 *
 * 100% tokenizado com WgcCoreDs e State Hoisting.
 */
@Composable
fun WgcNtcTimerDisplay(
    exerciseName: String,
    exerciseIndex: Int,
    totalExercises: Int,
    timeRemainingFormatted: String,
    progressFraction: Float,
    isPlaying: Boolean,
    nextExerciseName: String,
    coachTip: String,
    modifier: Modifier = Modifier,
    onPlayPauseToggle: () -> Unit = {},
    onPreviousClick: () -> Unit = {},
    onNextClick: () -> Unit = {},
    slotExerciseVisual: (@Composable () -> Unit)? = null
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(WgcCoreDsColors.ntcDarkGray)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.lg24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            // Header: Índice do Exercício e Treinador Áudio
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                        .background(Color(WgcCoreDsColors.ntcMediumGray))
                        .padding(
                            horizontal = WgcCoreDsSpacing.xs8.dp,
                            vertical = WgcCoreDsSpacing.xxxs2.dp
                        )
                ) {
                    Text(
                        text = "MOVIMENTO $exerciseIndex DE $totalExercises",
                        color = Color(WgcCoreDsColors.ntcVolt),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.sp
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.VolumeUp,
                        contentDescription = "Áudio ativo",
                        tint = Color(WgcCoreDsColors.ntcVolt),
                        modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                    )
                    Text(
                        text = "VOZ DO COACH",
                        color = Color(WgcCoreDsColors.ntcSecondaryText),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            // Visual do Exercício / Demonstração
            if (slotExerciseVisual != null) {
                slotExerciseVisual()
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(WgcCoreDsSize.s120.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                        .background(Color(WgcCoreDsColors.ntcBlack))
                        .border(
                            width = WgcCoreDsSize.s1.dp,
                            color = Color(WgcCoreDsColors.ntcMediumGray),
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                    ) {
                        Text(
                            text = exerciseName.uppercase(),
                            color = Color(WgcCoreDsColors.ntcWhite),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Black,
                            letterSpacing = 1.sp
                        )
                        Text(
                            text = "Execute no seu próprio ritmo",
                            color = Color(WgcCoreDsColors.ntcSecondaryText),
                            fontSize = 12.sp
                        )
                    }
                }
            }

            // Cronômetro Gigante
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxxs2.dp)
            ) {
                Text(
                    text = timeRemainingFormatted,
                    color = Color(WgcCoreDsColors.ntcVolt),
                    fontSize = 54.sp,
                    fontWeight = FontWeight.Black,
                    letterSpacing = 2.sp
                )

                // Barra de Progresso
                LinearProgressIndicator(
                    progress = { progressFraction },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(WgcCoreDsSize.s6.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)),
                    color = Color(WgcCoreDsColors.ntcVolt),
                    trackColor = Color(WgcCoreDsColors.ntcMediumGray)
                )
            }

            // Dica do Treinador
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                    .background(Color(WgcCoreDsColors.ntcVoltGlow))
                    .border(
                        width = WgcCoreDsSize.s1.dp,
                        color = Color(WgcCoreDsColors.ntcVolt).copy(alpha = 0.3f),
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp)
                    )
                    .padding(WgcCoreDsSpacing.sm12.dp)
            ) {
                Text(
                    text = "\"$coachTip\"",
                    color = Color(WgcCoreDsColors.ntcWhite),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 16.sp
                )
            }

            // Próximo Exercício
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "A SEGUIR:",
                    color = Color(WgcCoreDsColors.ntcSecondaryText),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = nextExerciseName,
                    color = Color(WgcCoreDsColors.ntcWhite),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            // Controles de Playback (Anterior, Play/Pause, Próximo)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = WgcCoreDsSpacing.xs8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onPreviousClick,
                    modifier = Modifier.size(WgcCoreDsSize.s48.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.FastRewind,
                        contentDescription = "Exercício anterior",
                        tint = Color(WgcCoreDsColors.ntcWhite),
                        modifier = Modifier.size(WgcCoreDsSize.s28.dp)
                    )
                }

                Box(
                    modifier = Modifier
                        .padding(horizontal = WgcCoreDsSpacing.lg24.dp)
                        .size(WgcCoreDsSize.s64.dp)
                        .clip(CircleShape)
                        .background(Color(WgcCoreDsColors.ntcVolt))
                        .clickable { onPlayPauseToggle() },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = if (isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                        contentDescription = if (isPlaying) "Pausar" else "Continuar",
                        tint = Color(WgcCoreDsColors.ntcBlack),
                        modifier = Modifier.size(WgcCoreDsSize.s36.dp)
                    )
                }

                IconButton(
                    onClick = onNextClick,
                    modifier = Modifier.size(WgcCoreDsSize.s48.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.FastForward,
                        contentDescription = "Próximo exercício",
                        tint = Color(WgcCoreDsColors.ntcWhite),
                        modifier = Modifier.size(WgcCoreDsSize.s28.dp)
                    )
                }
            }
        }
    }
}

@Preview(name = "NTC Timer Display - Preview")
@Composable
fun WgcNtcTimerDisplayPreview() {
    WgcNtcTimerDisplay(
        exerciseName = "Mountain Climbers",
        exerciseIndex = 3,
        totalExercises = 12,
        timeRemainingFormatted = "00:45",
        progressFraction = 0.65f,
        isPlaying = true,
        nextExerciseName = "Prancha Dinâmica • 30s",
        coachTip = "Mantenha o quadril alinhado aos ombros e acelere o ritmo nos últimos 10 segundos!"
    )
}
