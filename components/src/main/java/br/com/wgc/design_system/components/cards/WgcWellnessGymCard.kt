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
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.LocationOn
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
import br.com.wgc.design_system.core.tokens.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.theme.WgcCoreDsColors
import br.com.wgc.design_system.core.tokens.WgcCoreDsElevation
import br.com.wgc.design_system.core.tokens.WgcCoreDsSize
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing

/**
 * Card de Academia / Estúdio Credenciado Corporate Wellness (Wellness Network).
 *
 * Exibe nome da rede, modalidade, distância, avaliação, badge de plano elegível
 * e botão de check-in direto.
 *
 * 100% tokenizado com WgcCoreDs e State Hoisting.
 */
@Composable
fun WgcWellnessGymCard(
    name: String,
    category: String,
    address: String,
    distance: String,
    rating: Double,
    reviewsCount: String,
    requiredTier: WgcCorporateWellnessPlanTier,
    modifier: Modifier = Modifier,
    isIncludedInUserPlan: Boolean = true,
    onClick: (() -> Unit)? = null,
    onCheckInClick: (() -> Unit)? = null,
    slotAction: (@Composable () -> Unit)? = null
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(enabled = onClick != null) { onClick?.invoke() },
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.LG12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.white)),
        border = BorderStroke(WgcCoreDsSize.S1.dp, Color(WgcCoreDsColors.blueLight6)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.LEVEL1.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.MD16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.SM12.dp)
        ) {
            // Header do card: Ícone/Logo, Nome e Badge do Plano
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.SM12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .size(WgcCoreDsSize.S44.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.MD8.dp))
                            .background(Color(WgcCoreDsColors.greenLight4)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.FitnessCenter,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.cyanDark2),
                            modifier = Modifier.size(WgcCoreDsSize.S24.dp)
                        )
                    }

                    Column(verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.XXXS2.dp)) {
                        Text(
                            text = name,
                            color = Color(WgcCoreDsColors.grayDark7),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = category,
                            color = Color(WgcCoreDsColors.gray7),
                            fontSize = 12.sp
                        )
                    }
                }

                // Badge de Plano Exigido
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.CIRCULAR999.dp))
                        .background(Color(requiredTier.colorHex).copy(alpha = 0.12f))
                        .padding(horizontal = WgcCoreDsSpacing.XS8.dp, vertical = WgcCoreDsSpacing.XXS4.dp)
                ) {
                    Text(
                        text = "Plano ${requiredTier.label}",
                        color = Color(requiredTier.colorHex),
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // Localização e Avaliação
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.XXS4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.red26),
                        modifier = Modifier.size(WgcCoreDsSize.S14.dp)
                    )
                    Text(
                        text = "$distance • $address",
                        color = Color(WgcCoreDsColors.gray7),
                        fontSize = 12.sp
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.XXXS2.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.orange5),
                        modifier = Modifier.size(WgcCoreDsSize.S14.dp)
                    )
                    Text(
                        text = "$rating ($reviewsCount)",
                        color = Color(WgcCoreDsColors.grayDark7),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            // Rodapé: Status de inclusão e Botão Check-in
            if (slotAction != null) {
                slotAction()
            } else {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.XXS4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = null,
                            tint = if (isIncludedInUserPlan) Color(WgcCoreDsColors.green17)
                            else Color(WgcCoreDsColors.gray7),
                            modifier = Modifier.size(WgcCoreDsSize.S16.dp)
                        )
                        Text(
                            text = if (isIncludedInUserPlan) "Incluso no seu plano" else "Requer upgrade de plano",
                            color = if (isIncludedInUserPlan) Color(WgcCoreDsColors.green17)
                            else Color(WgcCoreDsColors.gray7),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    if (onCheckInClick != null && isIncludedInUserPlan) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.MD8.dp))
                                .background(Color(WgcCoreDsColors.red26))
                                .clickable { onCheckInClick() }
                                .padding(horizontal = WgcCoreDsSpacing.MD16.dp, vertical = WgcCoreDsSpacing.XS8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "CHECK-IN",
                                color = Color.White,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(name = "Corporate Wellness Gym Card - Included")
@Composable
fun WgcCorporateWellnessGymCardPreview() {
    WgcWellnessGymCard(
        name = "Gym & Fitness - Paulista Bela Cintra",
        category = "Musculação • Aeróbico",
        address = "Av. Paulista, 2064",
        distance = "350 m",
        rating = 4.8,
        reviewsCount = "1.4k",
        requiredTier = WgcCorporateWellnessPlanTier.BASIC,
        isIncludedInUserPlan = true
    )
}
