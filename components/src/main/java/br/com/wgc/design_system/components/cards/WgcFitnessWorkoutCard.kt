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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import br.com.wgc.design_system.core.tokens.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.theme.WgcCoreDsColors
import br.com.wgc.design_system.core.tokens.WgcCoreDsElevation
import br.com.wgc.design_system.core.tokens.WgcCoreDsSize
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing

enum class WgcFitnessWorkoutIntensity(val label: String, val level: Int) {
    LOW("Leve", 1),
    MODERATE("Intermediário", 2),
    HIGH("Avançado", 3),
    EXTREME("Atleta", 4)
}

enum class WgcFitnessWorkoutCategory(val label: String, val colorHex: Int) {
    HIIT("HIIT", WgcCoreDsColors.orange500),
    STRENGTH("FORÇA", WgcCoreDsColors.green28),
    YOGA("YOGA", WgcCoreDsColors.blue30),
    MOBILITY("MOBILIDADE", WgcCoreDsColors.purple5),
    ENDURANCE("RESISTÊNCIA", WgcCoreDsColors.green28)
}

@Composable
fun WgcFitnessWorkoutCard(
    title: String,
    trainerName: String,
    category: WgcFitnessWorkoutCategory,
    durationMinutes: Int,
    intensity: WgcFitnessWorkoutIntensity,
    equipment: String,
    modifier: Modifier = Modifier,
    isSaved: Boolean = false,
    onClick: () -> Unit = {},
    onSaveToggle: () -> Unit = {},
    onStartWorkout: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.LG12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(WgcCoreDsColors.grayDark11)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.LEVEL1.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.MD16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.SM12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.SM4.dp))
                        .background(Color(category.colorHex).copy(alpha = 0.2f))
                        .border(
                            width = WgcCoreDsSize.S1.dp,
                            color = Color(category.colorHex).copy(alpha = 0.6f),
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.SM4.dp)
                        )
                        .padding(horizontal = WgcCoreDsSpacing.XS8.dp, vertical = WgcCoreDsSpacing.XXXS2.dp)
                ) {
                    Text(
                        text = category.label,
                        color = Color(category.colorHex),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                IconButton(
                    onClick = onSaveToggle,
                    modifier = Modifier.size(WgcCoreDsSize.S32.dp)
                ) {
                    Icon(
                        imageVector = if (isSaved) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                        contentDescription = "Salvar Treino",
                        tint = if (isSaved) Color(WgcCoreDsColors.green28) else Color(WgcCoreDsColors.gray12)
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.MD16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(WgcCoreDsSize.S64.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.MD8.dp))
                        .background(Color(WgcCoreDsColors.grayDark20)),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(onClick = onStartWorkout) {
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = "Iniciar",
                            tint = Color(WgcCoreDsColors.green28),
                            modifier = Modifier.size(WgcCoreDsSize.S32.dp)
                        )
                    }
                }

                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.XXXS2.dp)
                ) {
                    Text(
                        text = title,
                        color = Color(WgcCoreDsColors.white),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Com $trainerName",
                        color = Color(WgcCoreDsColors.gray12),
                        fontSize = 14.sp
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.XS8.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.XXS4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Schedule,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.gray12),
                            modifier = Modifier.size(WgcCoreDsSize.S16.dp)
                        )
                        Text(
                            text = "$durationMinutes min",
                            color = Color(WgcCoreDsColors.white),
                            fontSize = 14.sp
                        )
                    }

                    Text(
                        text = "•",
                        color = Color(WgcCoreDsColors.gray12)
                    )

                    Text(
                        text = intensity.label,
                        color = Color(WgcCoreDsColors.grayDark23),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.SM4.dp))
                        .background(Color(WgcCoreDsColors.grayDark20))
                        .padding(horizontal = WgcCoreDsSpacing.XS8.dp, vertical = WgcCoreDsSpacing.XXXS2.dp)
                ) {
                    Text(
                        text = equipment,
                        color = Color(WgcCoreDsColors.gray12),
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}

@Preview(name = "Fitness Workout Card - Default", showBackground = true)
@Composable
private fun WgcFitnessWorkoutCardPreview() {
    WgcFitnessWorkoutCard(
        title = "Força Explosiva no Core",
        trainerName = "Leandro Carvalho",
        category = WgcFitnessWorkoutCategory.HIIT,
        durationMinutes = 25,
        intensity = WgcFitnessWorkoutIntensity.HIGH,
        equipment = "Peso Corporal"
    )
}
