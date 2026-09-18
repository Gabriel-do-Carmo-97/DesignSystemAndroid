package br.com.wgc.ds_templates.screens.guidedtraining.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PlayArrow
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
import br.com.wgc.design_system.components.cards.WgcFitnessProgramCard
import br.com.wgc.design_system.components.cards.WgcFitnessWorkoutCard
import br.com.wgc.design_system.components.cards.WgcFitnessWorkoutCategory
import br.com.wgc.design_system.components.navigation.WgcFitnessBottomNav
import br.com.wgc.design_system.components.navigation.WgcFitnessNavItem
import br.com.wgc.ds_templates.screens.guidedtraining.model.GuidedTrainingMockData
import br.com.wgc.ds_templates.screens.guidedtraining.model.NtcProgramItem
import br.com.wgc.ds_templates.screens.guidedtraining.model.NtcUserProfile
import br.com.wgc.ds_templates.screens.guidedtraining.model.NtcWorkoutItem

@Composable
fun WgcNtcHomeTemplate(
    user: NtcUserProfile,
    featuredWorkout: NtcWorkoutItem,
    activeProgram: NtcProgramItem?,
    workouts: List<NtcWorkoutItem>,
    modifier: Modifier = Modifier,
    selectedCategory: WgcFitnessWorkoutCategory? = null,
    onSelectCategory: (WgcFitnessWorkoutCategory?) -> Unit = {},
    onSelectWorkout: (NtcWorkoutItem) -> Unit = {},
    onStartWorkout: (NtcWorkoutItem) -> Unit = {},
    onOpenProgram: (NtcProgramItem) -> Unit = {},
    onOpenActivity: () -> Unit = {},
    selectedNavItem: WgcFitnessNavItem = WgcFitnessNavItem.HOME,
    onNavItemClick: (WgcFitnessNavItem) -> Unit = {},
    slotHeader: (@Composable () -> Unit)? = null,
    slotHeroWorkout: (@Composable () -> Unit)? = null,
    slotBottomNav: (@Composable () -> Unit)? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            if (slotBottomNav != null) {
                slotBottomNav()
            } else {
                WgcFitnessBottomNav(
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
            item {
                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
                if (slotHeader != null) {
                    slotHeader()
                } else {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(WgcCoreDsSize.s40.dp)
                                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                                    .background(Color(WgcCoreDsColors.trainingVolt)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = user.name.take(2).uppercase(),
                                    color = Color(WgcCoreDsColors.trainingBlack),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp
                                )
                            }
                            Column {
                                Text(
                                    text = "BEM-VINDO DE VOLTA",
                                    color = Color(WgcCoreDsColors.trainingSecondaryText),
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = user.name,
                                    color = Color(WgcCoreDsColors.trainingWhite),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }

                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Default.Notifications,
                                contentDescription = "Notificações",
                                tint = Color(WgcCoreDsColors.trainingWhite)
                            )
                        }
                    }
                }
            }

            // Streak Card & Weekly Goal
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.trainingDarkGray)),
                    elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(WgcCoreDsSize.s40.dp)
                                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                                    .background(Color(WgcCoreDsColors.trainingOrange).copy(alpha = 0.2f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.LocalFireDepartment,
                                    contentDescription = null,
                                    tint = Color(WgcCoreDsColors.trainingOrange),
                                    modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                                )
                            }
                            Column {
                                Text(
                                    text = "${user.currentStreakDays} DIAS DE SEQUÊNCIA",
                                    color = Color(WgcCoreDsColors.trainingOrange),
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "Mantenha o foco esta semana!",
                                    color = Color(WgcCoreDsColors.trainingSecondaryText),
                                    fontSize = 10.sp
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                                .background(Color(WgcCoreDsColors.trainingMediumGray))
                                .clickable { onOpenActivity() }
                                .padding(horizontal = WgcCoreDsSpacing.sm12.dp, vertical = WgcCoreDsSpacing.xs8.dp)
                        ) {
                            Text(
                                text = "Placar",
                                color = Color(WgcCoreDsColors.trainingVolt),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            // Categorias Atalhos
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    item {
                        val isSelected = selectedCategory == null
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                                .background(
                                    if (isSelected) Color(WgcCoreDsColors.trainingVolt) else Color(WgcCoreDsColors.trainingDarkGray)
                                )
                                .border(
                                    width = WgcCoreDsSize.s1.dp,
                                    color = if (isSelected) Color(WgcCoreDsColors.trainingVolt) else Color(WgcCoreDsColors.trainingMediumGray),
                                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
                                )
                                .clickable { onSelectCategory(null) }
                                .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp)
                        ) {
                            Text(
                                text = "Todos",
                                color = if (isSelected) Color(WgcCoreDsColors.trainingBlack) else Color(WgcCoreDsColors.trainingWhite),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    items(WgcFitnessWorkoutCategory.entries) { category ->
                        val isSelected = selectedCategory == category
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                                .background(
                                    if (isSelected) Color(category.colorHex) else Color(WgcCoreDsColors.trainingDarkGray)
                                )
                                .border(
                                    width = WgcCoreDsSize.s1.dp,
                                    color = if (isSelected) Color(category.colorHex) else Color(WgcCoreDsColors.trainingMediumGray),
                                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
                                )
                                .clickable { onSelectCategory(category) }
                                .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp)
                        ) {
                            Text(
                                text = category.label,
                                color = if (isSelected) Color(WgcCoreDsColors.trainingBlack) else Color(WgcCoreDsColors.trainingWhite),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            // Hero: Treino do Dia
            item {
                if (slotHeroWorkout != null) {
                    slotHeroWorkout()
                } else {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onStartWorkout(featuredWorkout) },
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.trainingDarkGray)),
                        border = androidx.compose.foundation.BorderStroke(
                            WgcCoreDsSize.s1.dp,
                            Color(WgcCoreDsColors.trainingVolt).copy(alpha = 0.4f)
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(WgcCoreDsSpacing.md16.dp),
                            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                        .background(Color(WgcCoreDsColors.trainingVolt).copy(alpha = 0.2f))
                                        .padding(horizontal = WgcCoreDsSpacing.xs8.dp, vertical = WgcCoreDsSpacing.xxxs2.dp)
                                ) {
                                    Text(
                                        text = "DESTAQUE DE HOJE",
                                        color = Color(WgcCoreDsColors.trainingVolt),
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                                Text(
                                    text = "${featuredWorkout.durationMinutes} min • ${featuredWorkout.intensity.label}",
                                    color = Color(WgcCoreDsColors.trainingSecondaryText),
                                    fontSize = 12.sp
                                )
                            }

                            Column(verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)) {
                                Text(
                                    text = featuredWorkout.title,
                                    color = Color(WgcCoreDsColors.trainingWhite),
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.ExtraBold
                                )
                                Text(
                                    text = "Com ${featuredWorkout.trainerName}",
                                    color = Color(WgcCoreDsColors.trainingSecondaryText),
                                    fontSize = 14.sp
                                )
                            }

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.End,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                                        .background(Color(WgcCoreDsColors.trainingVolt))
                                        .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.PlayArrow,
                                            contentDescription = null,
                                            tint = Color(WgcCoreDsColors.trainingBlack),
                                            modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                                        )
                                        Text(
                                            text = "Iniciar Treino",
                                            color = Color(WgcCoreDsColors.trainingBlack),
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 12.sp
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // Programa Ativo
            if (activeProgram != null) {
                item {
                    Text(
                        text = "PROGRAMA EM ANDAMENTO",
                        color = Color(WgcCoreDsColors.trainingWhite),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp
                    )
                }

                item {
                    WgcFitnessProgramCard(
                        title = activeProgram.title,
                        goal = activeProgram.goal,
                        trainerName = activeProgram.trainerName,
                        totalWeeks = activeProgram.totalWeeks,
                        currentWeek = activeProgram.currentWeek,
                        completedWorkouts = activeProgram.completedWorkouts,
                        totalWorkouts = activeProgram.totalWorkouts,
                        isEnrolled = activeProgram.isEnrolled,
                        onClick = { onOpenProgram(activeProgram) },
                        onActionClick = { onOpenProgram(activeProgram) }
                    )
                }
            }

            // Título Seção de Treinos
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "RECOMENDADOS PARA VOCÊ",
                        color = Color(WgcCoreDsColors.trainingWhite),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp
                    )
                    Text(
                        text = "Ver todos",
                        color = Color(WgcCoreDsColors.trainingVolt),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable { }
                    )
                }
            }

            // Lista de Treinos
            items(workouts, key = { it.id }) { workout ->
                WgcFitnessWorkoutCard(
                    title = workout.title,
                    trainerName = workout.trainerName,
                    category = workout.category,
                    durationMinutes = workout.durationMinutes,
                    intensity = workout.intensity,
                    equipment = workout.equipment,
                    isSaved = workout.isSaved,
                    onClick = { onSelectWorkout(workout) }
                )
            }
        }
    }
}

@Preview(name = "Fitness Home Template - Preview")
@Composable
fun WgcNtcHomeTemplatePreview() {
    WgcNtcHomeTemplate(
        user = GuidedTrainingMockData.mockUser,
        featuredWorkout = GuidedTrainingMockData.mockWorkouts.first(),
        activeProgram = GuidedTrainingMockData.mockPrograms.first(),
        workouts = GuidedTrainingMockData.mockWorkouts
    )
}
