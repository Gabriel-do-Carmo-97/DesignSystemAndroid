package br.com.wgc.ds_templates.screens.guidedtraining.player

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
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
import br.com.wgc.design_system.components.fitness.WgcNtcTimerDisplay
import br.com.wgc.ds_templates.screens.guidedtraining.model.GuidedTrainingMockData
import br.com.wgc.ds_templates.screens.guidedtraining.model.NtcWorkoutItem

/**
 * Template do Player Interativo de Treino Nike Training Club (NTC).
 *
 * Oferece cronômetro de alta visibilidade em tom Volt, fila de exercícios
 * com status dinâmico (concluído, ativo, seguinte) e controle guiado por áudio.
 *
 * 100% tokenizado com WgcCoreDs e State Hoisting.
 */
@Composable
fun WgcNtcWorkoutPlayerTemplate(
    workout: NtcWorkoutItem,
    currentExerciseIndex: Int,
    timeRemainingFormatted: String,
    progressFraction: Float,
    isPlaying: Boolean,
    modifier: Modifier = Modifier,
    onCloseClick: () -> Unit = {},
    onPlayPauseToggle: () -> Unit = {},
    onPreviousClick: () -> Unit = {},
    onNextClick: () -> Unit = {},
    onFinishWorkout: () -> Unit = {},
    slotTimer: (@Composable () -> Unit)? = null
) {
    val currentExercise = workout.exercises.getOrNull(currentExerciseIndex)
        ?: workout.exercises.firstOrNull()
    val nextExercise = workout.exercises.getOrNull(currentExerciseIndex + 1)

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.sm12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onCloseClick) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Encerrar treino",
                        tint = Color(WgcCoreDsColors.trainingWhite),
                        modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                    )
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = workout.title.uppercase(),
                        color = Color(WgcCoreDsColors.trainingWhite),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp
                    )
                    Text(
                        text = "${workout.trainerName} • NTC",
                        color = Color(WgcCoreDsColors.trainingSecondaryText),
                        fontSize = 10.sp
                    )
                }

                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.VolumeUp,
                        contentDescription = "Áudio do Coach",
                        tint = Color(WgcCoreDsColors.trainingVolt),
                        modifier = Modifier.size(WgcCoreDsSize.s22.dp)
                    )
                }
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            // Display do Cronômetro Central
            item {
                if (slotTimer != null) {
                    slotTimer()
                } else {
                    WgcNtcTimerDisplay(
                        exerciseName = currentExercise?.name ?: "Exercício",
                        exerciseIndex = currentExerciseIndex + 1,
                        totalExercises = workout.exercises.size,
                        timeRemainingFormatted = timeRemainingFormatted,
                        progressFraction = progressFraction,
                        isPlaying = isPlaying,
                        nextExerciseName = nextExercise?.let { "${it.name} • ${it.durationSeconds}s" }
                            ?: "Fim do Treino!",
                        coachTip = currentExercise?.coachTip
                            ?: "Mantenha o ritmo e a postura firme!",
                        onPlayPauseToggle = onPlayPauseToggle,
                        onPreviousClick = onPreviousClick,
                        onNextClick = onNextClick
                    )
                }
            }

            // Título da Fila de Exercícios
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "ROTEIRO DO TREINO",
                        color = Color(WgcCoreDsColors.trainingWhite),
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp
                    )
                    Text(
                        text = "${workout.exercises.size} Movimentos",
                        color = Color(WgcCoreDsColors.trainingSecondaryText),
                        fontSize = 11.sp
                    )
                }
            }

            // Lista de Exercícios com Indicadores de Status
            itemsIndexed(workout.exercises) { index, exercise ->
                val isCompleted = index < currentExerciseIndex
                val isCurrent = index == currentExerciseIndex

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = when {
                            isCurrent -> Color(WgcCoreDsColors.trainingDarkGray)
                            isCompleted -> Color(WgcCoreDsColors.trainingBlack)
                            else -> Color(WgcCoreDsColors.trainingDarkGray).copy(alpha = 0.6f)
                        }
                    ),
                    border = androidx.compose.foundation.BorderStroke(
                        width = WgcCoreDsSize.s1.dp,
                        color = when {
                            isCurrent -> Color(WgcCoreDsColors.trainingVolt)
                            isCompleted -> Color(WgcCoreDsColors.trainingMediumGray)
                            else -> Color(WgcCoreDsColors.trainingMediumGray).copy(alpha = 0.5f)
                        }
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.sm12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                    ) {
                        // Indicador Numérico ou Check
                        Box(
                            modifier = Modifier
                                .size(WgcCoreDsSize.s28.dp)
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                .background(
                                    when {
                                        isCurrent -> Color(WgcCoreDsColors.trainingVolt)
                                        isCompleted -> Color(WgcCoreDsColors.trainingMediumGray)
                                        else -> Color(WgcCoreDsColors.trainingLightGray)
                                    }
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            if (isCompleted) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "Concluído",
                                    tint = Color(WgcCoreDsColors.trainingVolt),
                                    modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                                )
                            } else {
                                Text(
                                    text = "${index + 1}",
                                    color = if (isCurrent) Color(WgcCoreDsColors.trainingBlack) else Color(WgcCoreDsColors.trainingWhite),
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Black
                                )
                            }
                        }

                        // Nome e Foco Muscular
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = exercise.name,
                                color = if (isCurrent) Color(WgcCoreDsColors.trainingWhite) else Color(WgcCoreDsColors.trainingSecondaryText),
                                fontSize = 14.sp,
                                fontWeight = if (isCurrent) FontWeight.Bold else FontWeight.Medium
                            )
                            Text(
                                text = exercise.muscleGroup,
                                color = Color(WgcCoreDsColors.trainingSecondaryText),
                                fontSize = 11.sp
                            )
                        }

                        // Duração
                        Text(
                            text = "${exercise.durationSeconds}s",
                            color = if (isCurrent) Color(WgcCoreDsColors.trainingVolt) else Color(WgcCoreDsColors.trainingSecondaryText),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            // Botão Concluir Treino
            item {
                Button(
                    onClick = onFinishWorkout,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = WgcCoreDsSpacing.md16.dp)
                        .height(WgcCoreDsSize.s52.dp),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(WgcCoreDsColors.trainingVolt))
                ) {
                    Text(
                        text = "CONCLUIR TREINO",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Black,
                        letterSpacing = 1.sp
                    )
                }
            }
        }
    }
}

@Preview(name = "NTC Workout Player - Preview")
@Composable
fun WgcNtcWorkoutPlayerTemplatePreview() {
    WgcNtcWorkoutPlayerTemplate(
        workout = GuidedTrainingMockData.mockWorkouts.first(),
        currentExerciseIndex = 2,
        timeRemainingFormatted = "00:45",
        progressFraction = 0.60f,
        isPlaying = true
    )
}
