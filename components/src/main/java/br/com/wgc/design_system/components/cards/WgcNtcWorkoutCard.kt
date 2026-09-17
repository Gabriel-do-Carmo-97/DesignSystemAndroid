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
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * Nível de intensidade do treino NTC.
 */
enum class WgcNtcWorkoutIntensity(val label: String, val level: Int) {
    LOW("Leve", 1),
    MODERATE("Intermediário", 2),
    HIGH("Avançado", 3),
    EXTREME("Atleta", 4)
}

/**
 * Categoria / Foco do treino NTC.
 */
enum class WgcNtcWorkoutCategory(val label: String, val colorHex: Int) {
    HIIT("HIIT", WgcCoreDsColors.trainingOrange),
    STRENGTH("FORÇA", WgcCoreDsColors.trainingVolt),
    YOGA("YOGA", WgcCoreDsColors.trainingBlue),
    MOBILITY("MOBILIDADE", WgcCoreDsColors.trainingPurple),
    ENDURANCE("RESISTÊNCIA", WgcCoreDsColors.trainingVolt)
}

/**
 * Card de Treino do Nike Training Club (NTC).
 *
 * Exibe título do treino, instrutor parceiro Nike, categoria energética,
 * duração, intensidade, equipamento necessário e controle de favoritos.
 *
 * 100% tokenizado com WgcCoreDs e State Hoisting.
 */
@Composable
fun WgcNtcWorkoutCard(
    title: String,
    trainerName: String,
    category: WgcNtcWorkoutCategory,
    durationMinutes: Int,
    intensity: WgcNtcWorkoutIntensity,
    equipment: String,
    modifier: Modifier = Modifier,
    isSaved: Boolean = false,
    onSaveToggle: (() -> Unit)? = null,
    onClick: () -> Unit = {},
    slotThumbnail: (@Composable () -> Unit)? = null
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
            // Header: Categoria Badge + Salvar
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                        .background(Color(category.colorHex).copy(alpha = 0.18f))
                        .border(
                            width = WgcCoreDsSize.s1.dp,
                            color = Color(category.colorHex).copy(alpha = 0.5f),
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp)
                        )
                        .padding(
                            horizontal = WgcCoreDsSpacing.xs8.dp,
                            vertical = WgcCoreDsSpacing.xxxs2.dp
                        )
                ) {
                    Text(
                        text = category.label,
                        color = Color(category.colorHex),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Black,
                        letterSpacing = 1.sp
                    )
                }

                if (onSaveToggle != null) {
                    IconButton(
                        onClick = onSaveToggle,
                        modifier = Modifier.size(WgcCoreDsSize.s28.dp)
                    ) {
                        Icon(
                            imageVector = if (isSaved) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                            contentDescription = if (isSaved) "Salvo" else "Salvar treino",
                            tint = if (isSaved) Color(WgcCoreDsColors.trainingVolt) else Color(WgcCoreDsColors.trainingSecondaryText),
                            modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                        )
                    }
                }
            }

            // Slot de Thumbnail ou Área Visual
            if (slotThumbnail != null) {
                slotThumbnail()
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(WgcCoreDsSize.s80.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                        .background(Color(WgcCoreDsColors.trainingMediumGray)),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.trainingVolt),
                            modifier = Modifier.size(WgcCoreDsSize.s32.dp)
                        )
                        Text(
                            text = "ASSISTIR PRÉVIA",
                            color = Color(WgcCoreDsColors.trainingWhite),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 0.5.sp
                        )
                    }
                }
            }

            // Título e Treinador
            Column(verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)) {
                Text(
                    text = title,
                    color = Color(WgcCoreDsColors.trainingWhite),
                    fontSize = 17.sp,
                    fontWeight = FontWeight.ExtraBold,
                    lineHeight = 22.sp
                )
                Text(
                    text = "Treinador: $trainerName",
                    color = Color(WgcCoreDsColors.trainingSecondaryText),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            // Footer de Metadados: Duração + Intensidade + Equipamento
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = WgcCoreDsSpacing.xxs4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Duração
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Schedule,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.trainingSecondaryText),
                        modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                    )
                    Text(
                        text = "$durationMinutes min",
                        color = Color(WgcCoreDsColors.trainingWhite),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                // Barras de Intensidade
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                ) {
                    Text(
                        text = intensity.label,
                        color = Color(WgcCoreDsColors.trainingSecondaryText),
                        fontSize = 11.sp
                    )
                    Row(horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxxs2.dp)) {
                        val maxIntensityBars = 4
                        for (i in 1..maxIntensityBars) {
                            Box(
                                modifier = Modifier
                                    .width(WgcCoreDsSize.s4.dp)
                                    .height(WgcCoreDsSize.s10.dp)
                                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                    .background(
                                        if (i <= intensity.level) {
                                            Color(WgcCoreDsColors.trainingVolt)
                                        } else {
                                            Color(WgcCoreDsColors.trainingLightGray)
                                        }
                                    )
                            )
                        }
                    }
                }

                // Equipamento
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.FitnessCenter,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.trainingSecondaryText),
                        modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                    )
                    Text(
                        text = equipment,
                        color = Color(WgcCoreDsColors.trainingSecondaryText),
                        fontSize = 11.sp
                    )
                }
            }
        }
    }
}

@Preview(name = "NTC Workout Card - Default")
@Composable
fun WgcNtcWorkoutCardPreview() {
    WgcNtcWorkoutCard(
        title = "Força Total e Explosão Funcional",
        trainerName = "Kirsty Godso",
        category = WgcNtcWorkoutCategory.HIIT,
        durationMinutes = 22,
        intensity = WgcNtcWorkoutIntensity.HIGH,
        equipment = "Sem pesos",
        isSaved = true
    )
}
