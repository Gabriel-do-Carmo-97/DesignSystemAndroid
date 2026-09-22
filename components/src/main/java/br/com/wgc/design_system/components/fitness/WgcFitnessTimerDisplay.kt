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
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsElevation
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing

@Composable
fun WgcFitnessTimerDisplay(
    exerciseName: String,
    exerciseIndex: Int,
    totalExercises: Int,
    timeRemainingFormatted: String,
    progressFraction: Float,
    isPlaying: Boolean,
    nextExerciseName: String,
    modifier: Modifier = Modifier,
    onPlayPauseToggle: () -> Unit = {},
    onSkip: () -> Unit = {},
    onRewind: () -> Unit = {},
    onAudioToggle: () -> Unit = {}
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(WgcCoreDsColors.trainingDarkGray)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level3.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                        .background(Color(WgcCoreDsColors.trainingMediumGray))
                        .padding(horizontal = WgcCoreDsSpacing.xs8.dp, vertical = WgcCoreDsSpacing.xxxs2.dp)
                ) {
                    Text(
                        text = "EXERCÍCIO $exerciseIndex DE $totalExercises",
                        color = Color(WgcCoreDsColors.trainingVolt),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                IconButton(
                    onClick = onAudioToggle,
                    modifier = Modifier.size(WgcCoreDsSize.s32.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.VolumeUp,
                        contentDescription = "Áudio Guia",
                        tint = Color(WgcCoreDsColors.trainingVolt)
                    )
                }
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
            ) {
                Text(
                    text = exerciseName,
                    color = Color(WgcCoreDsColors.trainingSecondaryText),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = timeRemainingFormatted,
                    color = Color(WgcCoreDsColors.trainingWhite),
                    fontSize = 40.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
            ) {
                LinearProgressIndicator(
                    progress = { progressFraction },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(WgcCoreDsSize.s8.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)),
                    color = Color(WgcCoreDsColors.trainingVolt),
                    trackColor = Color(WgcCoreDsColors.trainingMediumGray)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                    .background(Color(WgcCoreDsColors.trainingBlack))
                    .padding(WgcCoreDsSpacing.sm12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "PRÓXIMO",
                        color = Color(WgcCoreDsColors.trainingMediumGray),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = nextExerciseName,
                        color = Color(WgcCoreDsColors.trainingWhite),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Icon(
                    imageVector = Icons.Default.FastForward,
                    contentDescription = null,
                    tint = Color(WgcCoreDsColors.trainingVolt)
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onRewind,
                    modifier = Modifier.size(WgcCoreDsSize.s40.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.FastRewind,
                        contentDescription = "Voltar 10s",
                        tint = Color(WgcCoreDsColors.trainingWhite)
                    )
                }

                Box(
                    modifier = Modifier
                        .size(WgcCoreDsSize.s56.dp)
                        .clip(CircleShape)
                        .background(Color(WgcCoreDsColors.trainingVolt))
                        .clickable(onClick = onPlayPauseToggle),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = if (isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                        contentDescription = if (isPlaying) "Pausar" else "Reproduzir",
                        tint = Color(WgcCoreDsColors.trainingBlack),
                        modifier = Modifier.size(WgcCoreDsSize.s32.dp)
                    )
                }

                IconButton(
                    onClick = onSkip,
                    modifier = Modifier.size(WgcCoreDsSize.s40.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.FastForward,
                        contentDescription = "Avançar",
                        tint = Color(WgcCoreDsColors.trainingWhite)
                    )
                }
            }
        }
    }
}

@Preview(name = "Fitness Timer Display - Preview", showBackground = true)
@Composable
private fun WgcFitnessTimerDisplayPreview() {
    WgcFitnessTimerDisplay(
        exerciseName = "Prancha Dinâmica com Toque no Ombro",
        exerciseIndex = 4,
        totalExercises = 10,
        timeRemainingFormatted = "00:38",
        progressFraction = 0.62f,
        isPlaying = true,
        nextExerciseName = "Agachamento com Salto Pliométrico"
    )
}
