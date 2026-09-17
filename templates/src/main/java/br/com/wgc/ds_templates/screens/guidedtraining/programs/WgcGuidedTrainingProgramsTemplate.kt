package br.com.wgc.ds_templates.screens.guidedtraining.programs

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.ViewAgenda
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcNtcProgramCard
import br.com.wgc.design_system.components.navigation.WgcNtcBottomNav
import br.com.wgc.design_system.components.navigation.WgcNtcNavItem
import br.com.wgc.ds_templates.screens.guidedtraining.model.GuidedTrainingMockData
import br.com.wgc.ds_templates.screens.guidedtraining.model.NtcProgramItem

/**
 * Template da Tela de Programas Estruturados Nike Training Club (NTC).
 *
 * Apresenta o catálogo de programas de treinamento de várias semanas,
 * acompanhamento de metas a longo prazo e status de inscrição do atleta.
 *
 * 100% tokenizado com WgcCoreDs e State Hoisting.
 */
@Composable
fun WgcNtcProgramsTemplate(
    programs: List<NtcProgramItem>,
    modifier: Modifier = Modifier,
    onSelectProgram: (NtcProgramItem) -> Unit = {},
    selectedNavItem: WgcNtcNavItem = WgcNtcNavItem.PROGRAMS,
    onNavItemClick: (WgcNtcNavItem) -> Unit = {},
    slotHeader: (@Composable () -> Unit)? = null,
    slotBottomNav: (@Composable () -> Unit)? = null
) {
    val enrolledPrograms = programs.filter { it.isEnrolled }
    val availablePrograms = programs.filter { !it.isEnrolled }

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
            // Header
            item {
                if (slotHeader != null) {
                    slotHeader()
                } else {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = WgcCoreDsSpacing.md16.dp),
                        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.ViewAgenda,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.trainingVolt),
                                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                            )
                            Text(
                                text = "PROGRAMAS GUIADOS",
                                color = Color(WgcCoreDsColors.trainingVolt),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Black,
                                letterSpacing = 1.sp
                            )
                        }

                        Text(
                            text = "Evolução Semana a Semana",
                            color = Color(WgcCoreDsColors.trainingWhite),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Black
                        )
                    }
                }
            }

            // Banner Informativo
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
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
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.trainingVolt),
                            modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                        )
                        Text(
                            text = "Os programas do NTC combinam treinos de força, mobilidade e recuperação ativa criados por Master Trainers da Nike.",
                            color = Color(WgcCoreDsColors.trainingSecondaryText),
                            fontSize = 12.sp,
                            lineHeight = 16.sp
                        )
                    }
                }
            }

            // Programas Ativos
            if (enrolledPrograms.isNotEmpty()) {
                item {
                    Text(
                        text = "EM ANDAMENTO",
                        color = Color(WgcCoreDsColors.trainingWhite),
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp
                    )
                }

                items(enrolledPrograms, key = { it.id }) { program ->
                    WgcNtcProgramCard(
                        title = program.title,
                        goal = program.goal,
                        trainerName = program.trainerName,
                        totalWeeks = program.totalWeeks,
                        currentWeek = program.currentWeek,
                        completedWorkouts = program.completedWorkouts,
                        totalWorkouts = program.totalWorkouts,
                        isEnrolled = true,
                        onClick = { onSelectProgram(program) },
                        onActionClick = { onSelectProgram(program) }
                    )
                }
            }

            // Programas Disponíveis para Explorar
            item {
                Text(
                    text = "TODOS OS PROGRAMAS",
                    color = Color(WgcCoreDsColors.trainingWhite),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.5.sp
                )
            }

            items(availablePrograms, key = { it.id }) { program ->
                WgcNtcProgramCard(
                    title = program.title,
                    goal = program.goal,
                    trainerName = program.trainerName,
                    totalWeeks = program.totalWeeks,
                    currentWeek = program.currentWeek,
                    completedWorkouts = program.completedWorkouts,
                    totalWorkouts = program.totalWorkouts,
                    isEnrolled = false,
                    onClick = { onSelectProgram(program) },
                    onActionClick = { onSelectProgram(program) }
                )
            }
        }
    }
}

@Preview(name = "NTC Programs Template - Preview")
@Composable
fun WgcNtcProgramsTemplatePreview() {
    WgcNtcProgramsTemplate(
        programs = GuidedTrainingMockData.mockPrograms
    )
}
