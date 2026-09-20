package br.com.wgc.design_system.templates.screens.guidedtraining.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Schedule
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
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsElevation
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.templates.screens.guidedtraining.model.GuidedTrainingMockData
import br.com.wgc.design_system.templates.screens.guidedtraining.model.NtcWorkoutItem

/**
 * Template de Detalhes e Preparação do Treino Nike Training Club (NTC).
 *
 * Apresenta a visão geral dos exercícios, perfil do treinador Nike,
 * estimativa calórica e botão de início de alta performance.
 *
 * 100% tokenizado com WgcCoreDs e State Hoisting.
 */
@Composable
fun WgcNtcWorkoutDetailTemplate(
    workout: NtcWorkoutItem,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    onSaveToggle: () -> Unit = {},
    onStartWorkout: () -> Unit = {},
    slotHero: (@Composable () -> Unit)? = null,
    slotBottomAction: (@Composable () -> Unit)? = null
) {
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
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Voltar",
                        tint = Color(WgcCoreDsColors.trainingWhite),
                        modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                    )
                }

                Text(
                    text = "DETALHES DO TREINO",
                    color = Color(WgcCoreDsColors.trainingWhite),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )

                IconButton(onClick = onSaveToggle) {
                    Icon(
                        imageVector = if (workout.isSaved) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                        contentDescription = "Salvar",
                        tint = if (workout.isSaved) Color(WgcCoreDsColors.trainingVolt) else Color(WgcCoreDsColors.trainingWhite),
                        modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                    )
                }
            }
        },
        bottomBar = {
            if (slotBottomAction != null) {
                slotBottomAction()
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(WgcCoreDsColors.trainingBlack))
                        .border(
                            width = WgcCoreDsSize.s1.dp,
                            color = Color(WgcCoreDsColors.trainingMediumGray)
                        )
                        .padding(WgcCoreDsSpacing.md16.dp)
                ) {
                    Button(
                        onClick = onStartWorkout,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(WgcCoreDsSize.s52.dp),
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(WgcCoreDsColors.trainingVolt))
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.PlayArrow,
                                contentDescription = null,
                                modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                            )
                            Text(
                                text = "INICIAR TREINO",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Black,
                                letterSpacing = 1.sp
                            )
                        }
                    }
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
            // Hero / Resumo
            item {
                if (slotHero != null) {
                    slotHero()
                } else {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.trainingDarkGray)),
                        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(WgcCoreDsSpacing.lg24.dp),
                            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                    .background(Color(workout.category.colorHex).copy(alpha = 0.2f))
                                    .padding(horizontal = WgcCoreDsSpacing.xs8.dp, vertical = WgcCoreDsSpacing.xxxs2.dp)
                            ) {
                                Text(
                                    text = workout.category.label,
                                    color = Color(workout.category.colorHex),
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Black,
                                    letterSpacing = 1.sp
                                )
                            }

                            Text(
                                text = workout.title,
                                color = Color(WgcCoreDsColors.trainingWhite),
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Black,
                                lineHeight = 28.sp
                            )

                            Text(
                                text = workout.description,
                                color = Color(WgcCoreDsColors.trainingSecondaryText),
                                fontSize = 13.sp,
                                lineHeight = 18.sp
                            )

                            // Métricas Chave (Tempo, Calorias, Equipamento)
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = WgcCoreDsSpacing.xs8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Schedule,
                                        contentDescription = null,
                                        tint = Color(WgcCoreDsColors.trainingVolt),
                                        modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                                    )
                                    Text(
                                        text = "${workout.durationMinutes} min",
                                        color = Color(WgcCoreDsColors.trainingWhite),
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }

                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.LocalFireDepartment,
                                        contentDescription = null,
                                        tint = Color(WgcCoreDsColors.trainingOrange),
                                        modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                                    )
                                    Text(
                                        text = "${workout.estimatedCalories} kcal",
                                        color = Color(WgcCoreDsColors.trainingWhite),
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }

                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.FitnessCenter,
                                        contentDescription = null,
                                        tint = Color(WgcCoreDsColors.trainingSecondaryText),
                                        modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                                    )
                                    Text(
                                        text = workout.equipment,
                                        color = Color(WgcCoreDsColors.trainingSecondaryText),
                                        fontSize = 12.sp
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // Bloco do Treinador Nike Master
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.trainingDarkGray)),
                    border = androidx.compose.foundation.BorderStroke(
                        WgcCoreDsSize.s1.dp,
                        Color(WgcCoreDsColors.trainingMediumGray)
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(WgcCoreDsSize.s48.dp)
                                .clip(CircleShape)
                                .background(Color(WgcCoreDsColors.trainingMediumGray)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.trainingVolt),
                                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                            )
                        }

                        Column {
                            Text(
                                text = workout.trainerName,
                                color = Color(WgcCoreDsColors.trainingWhite),
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Nike Master Trainer • Áudio Coaching incluso",
                                color = Color(WgcCoreDsColors.trainingSecondaryText),
                                fontSize = 12.sp
                            )
                        }
                    }
                }
            }

            // Título Seção Exercícios
            item {
                Text(
                    text = "EXERCÍCIOS INCLUSOS (${workout.exercises.size})",
                    color = Color(WgcCoreDsColors.trainingWhite),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.5.sp
                )
            }

            // Lista de Movimentos Detalhada
            itemsIndexed(workout.exercises) { index, exercise ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.trainingDarkGray)),
                    border = androidx.compose.foundation.BorderStroke(
                        WgcCoreDsSize.s1.dp,
                        Color(WgcCoreDsColors.trainingMediumGray)
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.sm12.dp),
                        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(WgcCoreDsSize.s24.dp)
                                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                        .background(Color(WgcCoreDsColors.trainingMediumGray)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "${index + 1}",
                                        color = Color(WgcCoreDsColors.trainingWhite),
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                                Text(
                                    text = exercise.name,
                                    color = Color(WgcCoreDsColors.trainingWhite),
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }

                            Text(
                                text = "${exercise.durationSeconds}s",
                                color = Color(WgcCoreDsColors.trainingVolt),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Text(
                            text = exercise.coachTip,
                            color = Color(WgcCoreDsColors.trainingSecondaryText),
                            fontSize = 12.sp,
                            lineHeight = 16.sp
                        )
                    }
                }
            }
        }
    }
}

@Preview(name = "NTC Workout Detail - Preview")
@Composable
fun WgcNtcWorkoutDetailTemplatePreview() {
    WgcNtcWorkoutDetailTemplate(
        workout = GuidedTrainingMockData.mockWorkouts.first()
    )
}
