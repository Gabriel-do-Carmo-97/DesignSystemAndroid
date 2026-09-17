package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * Card de Exercício de Treino do Gym & Fitness Design System.
 *
 * Exibe nome do exercício, músculo alvo, séries, repetições, carga em kg,
 * tempo de descanso e checkbox circular interativo para marcação de conclusão.
 *
 * 100% aderente aos tokens WgcCoreDs e regras de State Hoisting do AGENTS.md.
 */
@Composable
fun WgcGymWorkoutCard(
    exerciseName: String,
    targetMuscle: String,
    setsAndReps: String,
    weightKg: String,
    modifier: Modifier = Modifier,
    restSeconds: Int = 60,
    isCompleted: Boolean = false,
    onToggleCompleted: ((Boolean) -> Unit)? = null,
    onEditWeight: (() -> Unit)? = null,
    onClick: (() -> Unit)? = null,
    slotAction: (@Composable () -> Unit)? = null
) {
    val cardBackground = if (isCompleted) {
        Color(WgcCoreDsColors.gymDarkGray).copy(alpha = 0.6f)
    } else {
        Color(WgcCoreDsColors.gymDarkGray)
    }

    val borderColor = if (isCompleted) {
        Color(WgcCoreDsColors.gymCrowdLow).copy(alpha = 0.5f)
    } else {
        Color(WgcCoreDsColors.gymMediumGray)
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(enabled = onClick != null) { onClick?.invoke() },
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
        colors = CardDefaults.cardColors(containerColor = cardBackground),
        border = BorderStroke(WgcCoreDsSize.s1.dp, borderColor),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            // Ícone circular com estado visual
            Box(
                modifier = Modifier
                    .size(WgcCoreDsSize.s48.dp)
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                    .background(
                        if (isCompleted) Color(WgcCoreDsColors.gymCrowdLow).copy(alpha = 0.2f)
                        else Color(WgcCoreDsColors.gymMediumGray)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.FitnessCenter,
                    contentDescription = null,
                    tint = if (isCompleted) Color(WgcCoreDsColors.gymCrowdLow)
                    else Color(WgcCoreDsColors.gymYellow),
                    modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                )
            }

            // Informações do exercício
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    Text(
                        text = exerciseName,
                        color = if (isCompleted) Color(WgcCoreDsColors.gymTextSecondary)
                        else Color(WgcCoreDsColors.gymTextPrimary),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        textDecoration = if (isCompleted) TextDecoration.LineThrough else TextDecoration.None
                    )
                }

                Text(
                    text = targetMuscle,
                    color = Color(WgcCoreDsColors.gymYellow),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )

                // Séries, peso e descanso
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp),
                    modifier = Modifier.padding(top = WgcCoreDsSpacing.xxs4.dp)
                ) {
                    Text(
                        text = setsAndReps,
                        color = Color(WgcCoreDsColors.gymTextSecondary),
                        fontSize = 12.sp
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp),
                        modifier = Modifier.clickable(enabled = onEditWeight != null) {
                            onEditWeight?.invoke()
                        }
                    ) {
                        Text(
                            text = weightKg,
                            color = Color(WgcCoreDsColors.gymTextPrimary),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Timer,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.gymTextSecondary),
                            modifier = Modifier.size(WgcCoreDsSize.s12.dp)
                        )
                        Text(
                            text = "${restSeconds}s",
                            color = Color(WgcCoreDsColors.gymTextSecondary),
                            fontSize = 11.sp
                        )
                    }
                }
            }

            // Slot de ação ou Botão de Conclusão / Checkbox Circular
            if (slotAction != null) {
                slotAction()
            } else {
                Box(
                    modifier = Modifier
                        .size(WgcCoreDsSize.s36.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                        .background(
                            if (isCompleted) Color(WgcCoreDsColors.gymCrowdLow)
                            else Color(WgcCoreDsColors.gymLightGray).copy(alpha = 0.3f)
                        )
                        .clickable(enabled = onToggleCompleted != null) {
                            onToggleCompleted?.invoke(!isCompleted)
                        },
                    contentAlignment = Alignment.Center
                ) {
                    if (isCompleted) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Exercício Concluído",
                            tint = Color(WgcCoreDsColors.gymTextInverse),
                            modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(name = "GymFitness Workout Card - Default")
@Composable
fun WgcGymFitnessWorkoutCardDefaultPreview() {
    WgcGymWorkoutCard(
        exerciseName = "Supino Reto com Barra",
        targetMuscle = "Peitoral Maior",
        setsAndReps = "4 séries × 10 reps",
        weightKg = "32 kg",
        restSeconds = 60,
        isCompleted = false
    )
}

@Preview(name = "GymFitness Workout Card - Completed")
@Composable
fun WgcGymFitnessWorkoutCardCompletedPreview() {
    WgcGymWorkoutCard(
        exerciseName = "Puxada Frontal Aberta",
        targetMuscle = "Dorsal e Bíceps",
        setsAndReps = "3 séries × 12 reps",
        weightKg = "45 kg",
        restSeconds = 45,
        isCompleted = true
    )
}
