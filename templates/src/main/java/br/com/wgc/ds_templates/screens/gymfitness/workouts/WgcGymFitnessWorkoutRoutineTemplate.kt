package br.com.wgc.ds_templates.screens.gymfitness.workouts

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
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
import br.com.wgc.design_system.components.cards.WgcGymWorkoutCard
import br.com.wgc.design_system.components.navigation.WgcGymBottomNav
import br.com.wgc.design_system.components.navigation.WgcGymFitnessNavItem
import br.com.wgc.ds_templates.screens.gymfitness.model.GymFitnessExercise
import br.com.wgc.ds_templates.screens.gymfitness.model.GymFitnessMockData
import br.com.wgc.ds_templates.screens.gymfitness.model.GymFitnessWorkoutRoutine

/**
 * Template da Ficha de Treinos da Gym & Fitness.
 *
 * Permite selecionar entre treinos A/B/C, visualizar exercícios detalhados,
 * marcar repetições concluídas e controlar tempo de descanso.
 *
 * 100% tokenizado com WgcCoreDs e State Hoisting.
 */
@Composable
fun WgcGymFitnessWorkoutRoutineTemplate(
    routines: List<GymFitnessWorkoutRoutine>,
    selectedRoutineIndex: Int,
    onSelectRoutine: (Int) -> Unit,
    modifier: Modifier = Modifier,
    onBackClick: (() -> Unit)? = null,
    onToggleExercise: ((exerciseId: String, completed: Boolean) -> Unit)? = null,
    onFinishWorkout: () -> Unit = {},
    selectedNavItem: WgcGymFitnessNavItem = WgcGymFitnessNavItem.WORKOUTS,
    onNavItemClick: (WgcGymFitnessNavItem) -> Unit = {},
    slotHeader: (@Composable () -> Unit)? = null,
    slotTimerBar: (@Composable () -> Unit)? = null,
    slotBottomNav: (@Composable () -> Unit)? = null
) {
    val currentRoutine = routines.getOrNull(selectedRoutineIndex) ?: routines.first()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            if (slotBottomNav != null) {
                slotBottomNav()
            } else {
                WgcGymBottomNav(
                    selectedItem = selectedNavItem,
                    onItemSelected = onNavItemClick
                )
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
            // Header
            item {
                if (slotHeader != null) {
                    slotHeader()
                } else {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = WgcCoreDsSpacing.md16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                    ) {
                        if (onBackClick != null) {
                            IconButton(onClick = onBackClick) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Voltar",
                                    tint = Color(WgcCoreDsColors.gymTextPrimary),
                                    modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                                )
                            }
                        }
                        Column {
                            Text(
                                text = "FICHAS DE TREINO",
                                color = Color(WgcCoreDsColors.gymYellow),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Black,
                                letterSpacing = 1.sp
                            )
                            Text(
                                text = "Seu Plano Atual",
                                color = Color(WgcCoreDsColors.gymTextPrimary),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            // Seletor de Ficha (Treino A, B, C)
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                ) {
                    routines.forEachIndexed { index, routine ->
                        val isSelected = index == selectedRoutineIndex
                        Card(
                            modifier = Modifier
                                .weight(1f)
                                .clickable { onSelectRoutine(index) },
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = if (isSelected) Color(WgcCoreDsColors.gymYellow)
                                else Color(WgcCoreDsColors.gymDarkGray)
                            ),
                            border = BorderStroke(
                                WgcCoreDsSize.s1.dp,
                                if (isSelected) Color(WgcCoreDsColors.gymYellow)
                                else Color(WgcCoreDsColors.gymMediumGray)
                            )
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = WgcCoreDsSpacing.sm12.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "TREINO ${routine.letter}",
                                    color = if (isSelected) Color(WgcCoreDsColors.gymTextInverse)
                                    else Color(WgcCoreDsColors.gymTextPrimary),
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Black
                                )
                                Text(
                                    text = "${routine.exercises.size} exerc.",
                                    color = if (isSelected) Color(WgcCoreDsColors.gymTextInverse).copy(alpha = 0.8f)
                                    else Color(WgcCoreDsColors.gymTextSecondary),
                                    fontSize = 11.sp
                                )
                            }
                        }
                    }
                }
            }

            // Card resumo do treino selecionado
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(WgcCoreDsColors.gymDarkGray)
                    ),
                    border = BorderStroke(WgcCoreDsSize.s1.dp, Color(WgcCoreDsColors.gymMediumGray))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp),
                        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                    ) {
                        Text(
                            text = currentRoutine.title,
                            color = Color(WgcCoreDsColors.gymTextPrimary),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Foco: ${currentRoutine.focus} • ~${currentRoutine.estimatedMinutes} min",
                            color = Color(WgcCoreDsColors.gymTextSecondary),
                            fontSize = 12.sp
                        )

                        // Barra de Progresso
                        Column(verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Progresso",
                                    color = Color(WgcCoreDsColors.gymTextSecondary),
                                    fontSize = 11.sp
                                )
                                Text(
                                    text = "${currentRoutine.completedCount}/${currentRoutine.totalCount} feitos",
                                    color = Color(WgcCoreDsColors.gymYellow),
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            LinearProgressIndicator(
                                progress = { currentRoutine.progressPercentage },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(WgcCoreDsSize.s8.dp)
                                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)),
                                color = Color(WgcCoreDsColors.gymYellow),
                                trackColor = Color(WgcCoreDsColors.gymMediumGray)
                            )
                        }
                    }
                }
            }

            // Timer de Descanso Rápido
            item {
                if (slotTimerBar != null) {
                    slotTimerBar()
                } else {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(WgcCoreDsColors.gymMediumGray).copy(alpha = 0.5f)
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Timer,
                                    contentDescription = null,
                                    tint = Color(WgcCoreDsColors.gymYellow),
                                    modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                                )
                                Column {
                                    Text(
                                        text = "Cronômetro de Descanso",
                                        color = Color(WgcCoreDsColors.gymTextPrimary),
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = "Recomendado: 60 segundos",
                                        color = Color(WgcCoreDsColors.gymTextSecondary),
                                        fontSize = 10.sp
                                    )
                                }
                            }

                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                                    .background(Color(WgcCoreDsColors.gymYellow))
                                    .clickable { }
                                    .padding(horizontal = WgcCoreDsSpacing.sm12.dp, vertical = WgcCoreDsSpacing.xxs4.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.PlayArrow,
                                        contentDescription = null,
                                        tint = Color(WgcCoreDsColors.gymTextInverse),
                                        modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                                    )
                                    Text(
                                        text = "INICIAR 60s",
                                        color = Color(WgcCoreDsColors.gymTextInverse),
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // Lista de Exercícios
            items(currentRoutine.exercises, key = { it.id }) { exercise ->
                WgcGymWorkoutCard(
                    exerciseName = exercise.name,
                    targetMuscle = exercise.muscleGroup,
                    setsAndReps = "${exercise.sets} séries × ${exercise.reps} reps",
                    weightKg = "${exercise.weightKg.toInt()} kg",
                    restSeconds = exercise.restSeconds,
                    isCompleted = exercise.isCompleted,
                    onToggleCompleted = { completed ->
                        onToggleExercise?.invoke(exercise.id, completed)
                    }
                )
            }

            // Botão Concluir Treino
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(WgcCoreDsSize.s48.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                        .background(Color(WgcCoreDsColors.gymYellow))
                        .clickable { onFinishWorkout() }
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.gymTextInverse),
                            modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                        )
                        Text(
                            text = "CONCLUIR TREINO DE HOJE",
                            color = Color(WgcCoreDsColors.gymTextInverse),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            item {
                Box(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))
            }
        }
    }
}

@Preview(name = "GymFitness Workout Routine Template - Preview")
@Composable
fun WgcGymFitnessWorkoutRoutineTemplatePreview() {
    WgcGymFitnessWorkoutRoutineTemplate(
        routines = GymFitnessMockData.mockRoutines,
        selectedRoutineIndex = 0,
        onSelectRoutine = {}
    )
}
