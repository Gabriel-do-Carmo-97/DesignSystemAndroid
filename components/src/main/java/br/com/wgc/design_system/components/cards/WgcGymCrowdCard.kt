package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.People
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsElevation
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Nível de lotação da unidade Gym & Fitness.
 */
enum class WgcGymFitnessCrowdLevel(val label: String) {
    LOW("Tranquila"),
    MEDIUM("Moderada"),
    HIGH("Movimentada")
}

/**
 * Card de Lotação e Status da Unidade Gym & Fitness.
 *
 * Apresenta o nome da unidade, endereço/distância, horário de funcionamento,
 * badge de lotação em tempo real e gráfico de barras com pico de horários.
 *
 * 100% tokenizado com WgcCoreDs.
 */
@Composable
fun WgcGymCrowdCard(
    unitName: String,
    address: String,
    operatingHours: String,
    crowdLevel: WgcGymFitnessCrowdLevel,
    modifier: Modifier = Modifier,
    crowdPercentage: Int = 35, // 0 a 100%
    hourlyDistribution: List<Float> = listOf(0.3f, 0.6f, 0.4f, 0.5f, 0.9f, 0.7f),
    onClick: (() -> Unit)? = null,
    onNavigateClick: (() -> Unit)? = null,
    slotHeader: (@Composable () -> Unit)? = null,
    slotAction: (@Composable () -> Unit)? = null
) {
    val crowdColor = when (crowdLevel) {
        WgcGymFitnessCrowdLevel.LOW -> Color(WgcCoreDsColors.gymCrowdLow)
        WgcGymFitnessCrowdLevel.MEDIUM -> Color(WgcCoreDsColors.gymCrowdMedium)
        WgcGymFitnessCrowdLevel.HIGH -> Color(WgcCoreDsColors.gymCrowdHigh)
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(enabled = onClick != null) { onClick?.invoke() },
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(WgcCoreDsColors.gymDarkGray)
        ),
        border = BorderStroke(WgcCoreDsSize.s1.dp, Color(WgcCoreDsColors.gymMediumGray)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level3.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
        ) {
            // Slot opcional de cabeçalho
            if (slotHeader != null) {
                slotHeader()
            } else {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = unitName,
                            color = Color(WgcCoreDsColors.gymTextPrimary),
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp),
                            modifier = Modifier.padding(top = WgcCoreDsSpacing.xxs4.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.LocationOn,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.gymYellow),
                                modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                            )
                            Text(
                                text = address,
                                color = Color(WgcCoreDsColors.gymTextSecondary),
                                fontSize = 12.sp
                            )
                        }
                    }

                    // Badge de Lotação
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                            .background(crowdColor.copy(alpha = 0.18f))
                            .padding(
                                horizontal = WgcCoreDsSpacing.sm12.dp,
                                vertical = WgcCoreDsSpacing.xxs4.dp
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(WgcCoreDsSize.s8.dp)
                                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                                    .background(crowdColor)
                            )
                            Text(
                                text = crowdLevel.label,
                                color = crowdColor,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            // Horário de Funcionamento
            Text(
                text = "Funcionamento: $operatingHours",
                color = Color(WgcCoreDsColors.gymTextSecondary),
                fontSize = 12.sp
            )

            // Termômetro de Frequência por Horário (Mini Gráfico de Barras)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                    .background(Color(WgcCoreDsColors.gymBlack))
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
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.People,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.gymYellow),
                            modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                        )
                        Text(
                            text = "Frequência estimada agora: $crowdPercentage%",
                            color = Color(WgcCoreDsColors.gymTextPrimary),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }

                // Barras horárias
                val hours = listOf("06h", "09h", "12h", "15h", "18h", "21h")
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(WgcCoreDsSize.s48.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom
                ) {
                    hourlyDistribution.take(hours.size).forEachIndexed { index, fraction ->
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Bottom,
                            modifier = Modifier.weight(1f)
                        ) {
                            Box(
                                modifier = Modifier
                                    .width(WgcCoreDsSize.s16.dp)
                                    .height((fraction * 36).dp)
                                    .clip(RoundedCornerShape(topStart = WgcCoreDsBorderRadius.xs2.dp, topEnd = WgcCoreDsBorderRadius.xs2.dp))
                                    .background(
                                        if (index == 4) crowdColor // Horário de pico (18h)
                                        else Color(WgcCoreDsColors.gymLightGray)
                                    )
                            )
                            Text(
                                text = hours[index],
                                color = Color(WgcCoreDsColors.gymTextSecondary),
                                fontSize = 10.sp,
                                modifier = Modifier.padding(top = WgcCoreDsSpacing.xxxs2.dp)
                            )
                        }
                    }
                }
            }

            // Slot de ação inferior
            if (slotAction != null) {
                slotAction()
            } else if (onNavigateClick != null) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                        .clickable { onNavigateClick() }
                        .padding(vertical = WgcCoreDsSpacing.xxs4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Ver detalhes e comodidades da unidade",
                        color = Color(WgcCoreDsColors.gymYellow),
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Icon(
                        imageVector = Icons.Default.ChevronRight,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.gymYellow),
                        modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                    )
                }
            }
        }
    }
}

@Preview(name = "GymFitness Crowd Card - Low")
@Composable
fun WgcGymFitnessUnitCrowdCardLowPreview() {
    WgcGymCrowdCard(
        unitName = "Gym & Fitness - Paulista Bela Cintra",
        address = "Av. Paulista, 2064 • 350m",
        operatingHours = "06:00 às 23:00",
        crowdLevel = WgcGymFitnessCrowdLevel.LOW,
        crowdPercentage = 28
    )
}

@Preview(name = "GymFitness Crowd Card - High")
@Composable
fun WgcGymFitnessUnitCrowdCardHighPreview() {
    WgcGymCrowdCard(
        unitName = "Gym & Fitness - Faria Lima",
        address = "Av. Brig. Faria Lima, 1485 • 1.2km",
        operatingHours = "06:00 às 23:00",
        crowdLevel = WgcGymFitnessCrowdLevel.HIGH,
        crowdPercentage = 86
    )
}
