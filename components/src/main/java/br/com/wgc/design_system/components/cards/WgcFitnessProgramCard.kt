package br.com.wgc.design_system.components.cards

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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

@Composable
fun WgcFitnessProgramCard(
    title: String,
    goal: String,
    trainerName: String,
    totalWeeks: Int,
    currentWeek: Int,
    completedWorkouts: Int,
    totalWorkouts: Int,
    modifier: Modifier = Modifier,
    isEnrolled: Boolean = false,
    onClick: () -> Unit = {},
    onActionClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(WgcCoreDsColors.trainingDarkGray)
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
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                        .background(
                            if (isEnrolled) {
                                Color(WgcCoreDsColors.trainingVolt).copy(alpha = 0.18f)
                            } else {
                                Color(WgcCoreDsColors.trainingMediumGray)
                            }
                        )
                        .border(
                            width = WgcCoreDsSize.s1.dp,
                            color = if (isEnrolled) {
                                Color(WgcCoreDsColors.trainingVolt).copy(alpha = 0.5f)
                            } else {
                                Color(WgcCoreDsColors.trainingLightGray)
                            },
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp)
                        )
                        .padding(horizontal = WgcCoreDsSpacing.xs8.dp, vertical = WgcCoreDsSpacing.xxxs2.dp)
                ) {
                    Text(
                        text = if (isEnrolled) "EM ANDAMENTO • SEMANA $currentWeek DE $totalWeeks" else "PROGRAMA • $totalWeeks SEMANAS",
                        color = if (isEnrolled) Color(WgcCoreDsColors.trainingVolt) else Color(WgcCoreDsColors.trainingWhite),
                        fontSize = 14.sp,
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
                        tint = Color(WgcCoreDsColors.trainingLightGray),
                        modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                    )
                    Text(
                        text = "$totalWorkouts treinos",
                        color = Color(WgcCoreDsColors.trainingLightGray),
                        fontSize = 14.sp
                    )
                }
            }

            Column(verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)) {
                Text(
                    text = title,
                    color = Color(WgcCoreDsColors.trainingWhite),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = goal,
                    color = Color(WgcCoreDsColors.trainingVolt),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "Treinador: $trainerName",
                    color = Color(WgcCoreDsColors.trainingLightGray),
                    fontSize = 14.sp
                )
            }

            if (isEnrolled) {
                Column(verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Progresso Geral",
                            color = Color(WgcCoreDsColors.trainingLightGray),
                            fontSize = 14.sp
                        )
                        Text(
                            text = "$completedWorkouts / $totalWorkouts concluídos",
                            color = Color(WgcCoreDsColors.trainingWhite),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    LinearProgressIndicator(
                        progress = { if (totalWorkouts > 0) completedWorkouts.toFloat() / totalWorkouts.toFloat() else 0f },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(WgcCoreDsSize.s8.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)),
                        color = Color(WgcCoreDsColors.trainingVolt),
                        trackColor = Color(WgcCoreDsColors.trainingMediumGray)
                    )
                }
            }

            Button(
                onClick = onActionClick,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isEnrolled) Color(WgcCoreDsColors.trainingMediumGray) else Color(WgcCoreDsColors.trainingVolt)
                ),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp)
            ) {
                Text(
                    text = if (isEnrolled) "Continuar Programa" else "Iniciar Programa",
                    color = if (isEnrolled) Color(WgcCoreDsColors.trainingWhite) else Color(WgcCoreDsColors.trainingDarkGray),
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Preview(name = "Fitness Program Card - Enrolled", showBackground = true)
@Composable
private fun WgcFitnessProgramCardPreview() {
    WgcFitnessProgramCard(
        title = "Força Total 6 Semanas",
        goal = "Desenvolvimento de massa magra e resistência",
        trainerName = "Alexandre Costa",
        totalWeeks = 6,
        currentWeek = 3,
        completedWorkouts = 14,
        totalWorkouts = 24,
        isEnrolled = true
    )
}
