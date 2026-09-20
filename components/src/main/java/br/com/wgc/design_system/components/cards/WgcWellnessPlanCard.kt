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
import androidx.compose.material.icons.filled.Star
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
 * Card de Plano Corporativo Corporate Wellness (Wellness Network).
 *
 * Apresenta faixa do plano, valor mensal corporativo, benefícios inclusos e
 * botão de seleção/upgrade de plano.
 *
 * 100% tokenizado com WgcCoreDs e State Hoisting.
 */
@Composable
fun WgcWellnessPlanCard(
    tier: WgcCorporateWellnessPlanTier,
    monthlyPrice: String,
    gymCountLabel: String,
    benefits: List<String>,
    modifier: Modifier = Modifier,
    isCurrentPlan: Boolean = false,
    discountBadge: String? = "Economia corporativa",
    onSelectPlan: (() -> Unit)? = null,
    slotAction: (@Composable () -> Unit)? = null
) {
    val tierColor = Color(tier.colorHex)
    val borderColor = if (isCurrentPlan) Color(WgcCoreDsColors.wellnessCoral) else Color(WgcCoreDsColors.wellnessBorder)

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.wellnessSurface)),
        border = BorderStroke(if (isCurrentPlan) WgcCoreDsSize.s2.dp else WgcCoreDsSize.s1.dp, borderColor),
        elevation = CardDefaults.cardElevation(defaultElevation = if (isCurrentPlan) WgcCoreDsElevation.level6.dp else WgcCoreDsElevation.level1.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
        ) {
            // Cabeçalho do Plano
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
                            .size(WgcCoreDsSize.s16.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                            .background(tierColor)
                    )
                    Text(
                        text = "Plano ${tier.label}",
                        color = Color(WgcCoreDsColors.wellnessDark),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                if (isCurrentPlan) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                            .background(Color(WgcCoreDsColors.wellnessCoralLight))
                            .padding(horizontal = WgcCoreDsSpacing.sm12.dp, vertical = WgcCoreDsSpacing.xxs4.dp)
                    ) {
                        Text(
                            text = "SEU PLANO ATUAL",
                            color = Color(WgcCoreDsColors.wellnessCoral),
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Black
                        )
                    }
                } else if (discountBadge != null) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                            .background(Color(WgcCoreDsColors.wellnessForestLight))
                            .padding(horizontal = WgcCoreDsSpacing.sm12.dp, vertical = WgcCoreDsSpacing.xxs4.dp)
                    ) {
                        Text(
                            text = discountBadge,
                            color = Color(WgcCoreDsColors.wellnessForest),
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            // Preço mensal
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
            ) {
                Text(
                    text = monthlyPrice,
                    color = Color(WgcCoreDsColors.wellnessDark),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Black
                )
                Text(
                    text = "/ mês",
                    color = Color(WgcCoreDsColors.wellnessSecondaryText),
                    fontSize = 13.sp,
                    modifier = Modifier.padding(bottom = WgcCoreDsSpacing.xxs4.dp)
                )
            }

            Text(
                text = gymCountLabel,
                color = Color(WgcCoreDsColors.wellnessForest),
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold
            )

            // Lista de Benefícios
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
            ) {
                benefits.forEach { benefit ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(WgcCoreDsSize.s16.dp)
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                                .background(Color(WgcCoreDsColors.wellnessCheckInGreen).copy(alpha = 0.15f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.wellnessCheckInGreen),
                                modifier = Modifier.size(WgcCoreDsSize.s12.dp)
                            )
                        }
                        Text(
                            text = benefit,
                            color = Color(WgcCoreDsColors.wellnessDark),
                            fontSize = 12.sp
                        )
                    }
                }
            }

            // Ação de Seleção / Slot
            if (slotAction != null) {
                slotAction()
            } else if (onSelectPlan != null && !isCurrentPlan) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                        .background(Color(WgcCoreDsColors.wellnessForest))
                        .clickable { onSelectPlan() }
                        .padding(vertical = WgcCoreDsSpacing.sm12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "MUDAR PARA O PLANO ${tier.label.uppercase()}",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Preview(name = "Corporate Wellness Plan Card - Gold")
@Composable
fun WgcCorporateWellnessPlanCardPreview() {
    WgcWellnessPlanCard(
        tier = WgcCorporateWellnessPlanTier.GOLD,
        monthlyPrice = "R$ 139,90",
        gymCountLabel = "Acesso a mais de 16.000 academias e estúdios",
        benefits = listOf(
            "Inclui todas as academias Gym & Fitness e Bluefit",
            "Acesso à Bio Ritmo e estúdios premium",
            "1 check-in diário em qualquer academia credenciada",
            "Apps de nutrição, meditação e terapia inclusos"
        ),
        isCurrentPlan = true
    )
}
