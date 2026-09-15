package br.com.wgc.ds_templates.screens.ntc.home

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
import androidx.compose.material3.LinearProgressIndicator
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
import br.com.wgc.design_system.components.cards.WgcNtcProgramCard
import br.com.wgc.design_system.components.cards.WgcNtcWorkoutCard
import br.com.wgc.design_system.components.cards.WgcNtcWorkoutCategory
import br.com.wgc.design_system.components.navigation.WgcNtcBottomNav
import br.com.wgc.design_system.components.navigation.WgcNtcNavItem
import br.com.wgc.ds_templates.screens.ntc.model.NtcMockData
import br.com.wgc.ds_templates.screens.ntc.model.NtcProgramItem
import br.com.wgc.ds_templates.screens.ntc.model.NtcUserProfile
import br.com.wgc.ds_templates.screens.ntc.model.NtcWorkoutItem

/**
 * Template da Tela Principal / Feed do Nike Training Club (NTC).
 *
 * Contém o feed atlético diário com destaque do dia, atalhos de categoria,
 * progresso da meta semanal do atleta, programa ativo e treinos recomendados.
 *
 * 100% tokenizado com WgcCoreDs e State Hoisting.
 */
@Composable
fun WgcNtcHomeTemplate(
    user: NtcUserProfile,
    featuredWorkout: NtcWorkoutItem,
    activeProgram: NtcProgramItem?,
    workouts: List<NtcWorkoutItem>,
    modifier: Modifier = Modifier,
    selectedCategory: WgcNtcWorkoutCategory? = null,
    onSelectCategory: (WgcNtcWorkoutCategory?) -> Unit = {},
    onSelectWorkout: (NtcWorkoutItem) -> Unit = {},
    onStartWorkout: (NtcWorkoutItem) -> Unit = {},
    onOpenProgram: (NtcProgramItem) -> Unit = {},
    onOpenActivity: () -> Unit = {},
    selectedNavItem: WgcNtcNavItem = WgcNtcNavItem.FOR_YOU,
    onNavItemClick: (WgcNtcNavItem) -> Unit = {},
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
                WgcNtcBottomNav(
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
            // Header: Marca NTC + Streak + Notificações
            item {
                if (slotHeader != null) {
                    slotHeader()
                } else {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = WgcCoreDsSpacing.md16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                            ) {
                                Text(
                                    text = "NIKE TRAINING CLUB",
                                    color = Color(WgcCoreDsColors.ntcVolt),
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Black,
                                    letterSpacing = 1.sp
                                )
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                                        .background(Color(WgcCoreDsColors.ntcMediumGray))
                                        .padding(
                                            horizontal = WgcCoreDsSpacing.xs8.dp,
                                            vertical = WgcCoreDsSpacing.xxxs2.dp
                                        )
                                ) {
                                    Text(
                                        text = "PRO",
                                        color = Color(WgcCoreDsColors.ntcWhite),
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                            Text(
                                text = "Olá, ${user.name.split(" ").firstOrNull() ?: "Atleta"}",
                                color = Color(WgcCoreDsColors.ntcWhite),
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                        ) {
                            // Streak Flame Badge
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                                    .background(Color(WgcCoreDsColors.ntcOrange).copy(alpha = 0.2f))
                                    .border(
                                        width = WgcCoreDsSize.s1.dp,
                                        color = Color(WgcCoreDsColors.ntcOrange).copy(alpha = 0.5f),
                                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
                                    )
                                    .clickable { onOpenActivity() }
                                    .padding(
                                        horizontal = WgcCoreDsSpacing.xs8.dp,
                                        vertical = WgcCoreDsSpacing.xxs4.dp
                                    )
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.LocalFireDepartment,
                                        contentDescription = "Streak",
                                        tint = Color(WgcCoreDsColors.ntcOrange),
                                        modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                                    )
                                    Text(
                                        text = "${user.currentStreakDays}d",
                                        color = Color(WgcCoreDsColors.ntcWhite),
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Black
                                    )
                                }
                            }

                            IconButton(onClick = {}) {
                                Icon(
                                    imageVector = Icons.Default.Notifications,
                                    contentDescription = "Notificações",
                                    tint = Color(WgcCoreDsColors.ntcWhite),
                                    modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                                )
                            }
                        }
                    }
                }
            }

            // Widget de Meta Semanal
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.ntcDarkGray)),
                    border = androidx.compose.foundation.BorderStroke(
                        WgcCoreDsSize.s1.dp,
                        Color(WgcCoreDsColors.ntcMediumGray)
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
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
                            Text(
                                text = "META SEMANAL DE TREINO",
                                color = Color(WgcCoreDsColors.ntcSecondaryText),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 0.5.sp
                            )
                            Text(
                                text = "${user.weeklyMinutesProgress} / ${user.weeklyMinutesGoal} MIN",
                                color = Color(WgcCoreDsColors.ntcVolt),
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Black
                            )
                        }

                        val progress = (user.weeklyMinutesProgress.toFloat() / user.weeklyMinutesGoal.toFloat()).coerceIn(0f, 1f)
                        LinearProgressIndicator(
                            progress = { progress },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(WgcCoreDsSize.s6.dp)
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)),
                            color = Color(WgcCoreDsColors.ntcVolt),
                            trackColor = Color(WgcCoreDsColors.ntcMediumGray)
                        )

                        Text(
                            text = "Faltam apenas ${user.weeklyMinutesGoal - user.weeklyMinutesProgress} minutos para atingir sua meta da semana!",
                            color = Color(WgcCoreDsColors.ntcWhite),
                            fontSize = 12.sp
                        )
                    }
                }
            }

            // Categorias Rápidas
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
                                    if (isSelected) Color(WgcCoreDsColors.ntcVolt) else Color(WgcCoreDsColors.ntcDarkGray)
                                )
                                .border(
                                    width = WgcCoreDsSize.s1.dp,
                                    color = if (isSelected) Color(WgcCoreDsColors.ntcVolt) else Color(WgcCoreDsColors.ntcMediumGray),
                                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
                                )
                                .clickable { onSelectCategory(null) }
                                .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp)
                        ) {
                            Text(
                                text = "Todos",
                                color = if (isSelected) Color(WgcCoreDsColors.ntcBlack) else Color(WgcCoreDsColors.ntcWhite),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    items(WgcNtcWorkoutCategory.entries) { category ->
                        val isSelected = selectedCategory == category
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                                .background(
                                    if (isSelected) Color(category.colorHex) else Color(WgcCoreDsColors.ntcDarkGray)
                                )
                                .border(
                                    width = WgcCoreDsSize.s1.dp,
                                    color = if (isSelected) Color(category.colorHex) else Color(WgcCoreDsColors.ntcMediumGray),
                                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
                                )
                                .clickable { onSelectCategory(category) }
                                .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp)
                        ) {
                            Text(
                                text = category.label,
                                color = if (isSelected) Color(WgcCoreDsColors.ntcBlack) else Color(WgcCoreDsColors.ntcWhite),
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
                        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.ntcDarkGray)),
                        border = androidx.compose.foundation.BorderStroke(
                            WgcCoreDsSize.s1.dp,
                            Color(WgcCoreDsColors.ntcVolt).copy(alpha = 0.4f)
                        ),
                        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(WgcCoreDsSpacing.lg24.dp),
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
                                        .background(Color(WgcCoreDsColors.ntcVolt))
                                        .padding(horizontal = WgcCoreDsSpacing.xs8.dp, vertical = WgcCoreDsSpacing.xxxs2.dp)
                                ) {
                                    Text(
                                        text = "TREINO DO DIA",
                                        color = Color(WgcCoreDsColors.ntcBlack),
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Black,
                                        letterSpacing = 1.sp
                                    )
                                }

                                Text(
                                    text = "${featuredWorkout.durationMinutes} MIN • ${featuredWorkout.intensity.label}",
                                    color = Color(WgcCoreDsColors.ntcSecondaryText),
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }

                            Text(
                                text = featuredWorkout.title,
                                color = Color(WgcCoreDsColors.ntcWhite),
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Black,
                                lineHeight = 26.sp
                            )

                            Text(
                                text = featuredWorkout.description,
                                color = Color(WgcCoreDsColors.ntcSecondaryText),
                                fontSize = 12.sp,
                                lineHeight = 16.sp
                            )

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Coach: ${featuredWorkout.trainerName}",
                                    color = Color(WgcCoreDsColors.ntcVolt),
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                )

                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                                        .background(Color(WgcCoreDsColors.ntcVolt))
                                        .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp)
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.PlayArrow,
                                            contentDescription = null,
                                            tint = Color(WgcCoreDsColors.ntcBlack),
                                            modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                                        )
                                        Text(
                                            text = "INICIAR",
                                            color = Color(WgcCoreDsColors.ntcBlack),
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Black
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
                        color = Color(WgcCoreDsColors.ntcWhite),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp
                    )
                }

                item {
                    WgcNtcProgramCard(
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
                        color = Color(WgcCoreDsColors.ntcWhite),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp
                    )
                    Text(
                        text = "Ver todos",
                        color = Color(WgcCoreDsColors.ntcVolt),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable { }
                    )
                }
            }

            // Lista de Treinos
            items(workouts, key = { it.id }) { workout ->
                WgcNtcWorkoutCard(
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

@Preview(name = "NTC Home Template - Preview")
@Composable
fun WgcNtcHomeTemplatePreview() {
    WgcNtcHomeTemplate(
        user = NtcMockData.mockUser,
        featuredWorkout = NtcMockData.mockWorkouts.first(),
        activeProgram = NtcMockData.mockPrograms.first(),
        workouts = NtcMockData.mockWorkouts
    )
}
