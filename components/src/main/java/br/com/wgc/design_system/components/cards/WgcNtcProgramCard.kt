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
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.CalendarToday
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

/**
 * Card de Programa Estruturado Multi-semanas NTC.
 *
 * Apresenta planos de treinamento com duração de várias semanas,
 * acompanhamento de progresso percentual, treinador responsável e chamada para ação.
 *
 * 100% tokenizado com WgcCoreDs e State Hoisting.
 */
@Composable
fun WgcNtcProgramCard(
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
            // Header: Status / Duração
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
                        .padding(
                            horizontal = WgcCoreDsSpacing.xs8.dp,
                            vertical = WgcCoreDsSpacing.xxxs2.dp
                        )
                ) {
                    Text(
                        text = if (isEnrolled) "EM ANDAMENTO" else "NOVO PROGRAMA",
                        color = if (isEnrolled) Color(WgcCoreDsColors.trainingVolt) else Color(WgcCoreDsColors.trainingSecondaryText),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.CalendarToday,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.trainingSecondaryText),
                        modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                    )
                    Text(
                        text = "$totalWeeks Semanas",
                        color = Color(WgcCoreDsColors.trainingWhite),
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            // Título e Meta
            Column(verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)) {
                Text(
                    text = title,
                    color = Color(WgcCoreDsColors.trainingWhite),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    text = "Foco: $goal",
                    color = Color(WgcCoreDsColors.trainingSecondaryText),
                    fontSize = 12.sp
                )
                Text(
                    text = "Treinador(a): $trainerName",
                    color = Color(WgcCoreDsColors.trainingVolt),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            // Se estiver inscrito: Barra de Progresso do Programa
            if (isEnrolled && totalWorkouts > 0) {
                val progress = (completedWorkouts.toFloat() / totalWorkouts.toFloat()).coerceIn(0f, 1f)
                Column(verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Semana $currentWeek de $totalWeeks",
                            color = Color(WgcCoreDsColors.trainingWhite),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "$completedWorkouts/$totalWorkouts treinos",
                            color = Color(WgcCoreDsColors.trainingSecondaryText),
                            fontSize = 11.sp
                        )
                    }

                    LinearProgressIndicator(
                        progress = { progress },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(WgcCoreDsSize.s6.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)),
                        color = Color(WgcCoreDsColors.trainingVolt),
                        trackColor = Color(WgcCoreDsColors.trainingMediumGray)
                    )
                }
            }

            // Botão de Ação
            Button(
                onClick = onActionClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(WgcCoreDsSize.s44.dp),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isEnrolled) {
                        Color(WgcCoreDsColors.trainingVolt)
                    } else {
                        Color(WgcCoreDsColors.trainingWhite)
                    })
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.FitnessCenter,
                        contentDescription = null,
                        modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                    )
                    Text(
                        text = if (isEnrolled) "CONTINUAR PROGRAMA" else "INICIAR PROGRAMA",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Black,
                        letterSpacing = 0.5.sp
                    )
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = null,
                        modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                    )
                }
            }
        }
    }
}

@Preview(name = "NTC Program Card - Enrolled")
@Composable
fun WgcNtcProgramCardPreview() {
    WgcNtcProgramCard(
        title = "Força & Condicionamento Funcional",
        goal = "Aumento de força e resistência aeróbica",
        trainerName = "Betina Gozo",
        totalWeeks = 4,
        currentWeek = 2,
        completedWorkouts = 6,
        totalWorkouts = 16,
        isEnrolled = true
    )
}
