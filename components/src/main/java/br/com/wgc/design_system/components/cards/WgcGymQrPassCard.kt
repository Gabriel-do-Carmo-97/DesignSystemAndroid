package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Sync
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
 * Cartão Virtual de Acesso e Catraca Gym & Fitness (Digital Pass).
 *
 * Apresenta a carteirinha digital do aluno, selo do plano (ex: Plano Black),
 * código QR simulado para catraca com contador de atualização e botão de liberação rápida.
 *
 * 100% tokenizado e com State Hoisting.
 */
@Composable
fun WgcGymQrPassCard(
    studentName: String,
    planTitle: String,
    membershipId: String,
    modifier: Modifier = Modifier,
    unitName: String = "Gym & Fitness - Paulista",
    isValid: Boolean = true,
    expiresInSeconds: Int = 45,
    onRefreshCode: (() -> Unit)? = null,
    onCheckInClick: (() -> Unit)? = null,
    slotAction: (@Composable () -> Unit)? = null
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(WgcCoreDsColors.gymDarkGray)
        ),
        border = BorderStroke(WgcCoreDsSize.s1.dp, Color(WgcCoreDsColors.gymYellow)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level6.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            // Cabeçalho da carteirinha
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "GYM PASS ACCESS",
                        color = Color(WgcCoreDsColors.gymYellow),
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Black,
                        letterSpacing = 1.sp
                    )
                    Text(
                        text = studentName,
                        color = Color(WgcCoreDsColors.gymTextPrimary),
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Unidade Base: $unitName",
                        color = Color(WgcCoreDsColors.gymTextSecondary),
                        fontSize = 11.sp
                    )
                }

                // Badge do Plano Black
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                        .background(Color(WgcCoreDsColors.gymYellow))
                        .padding(
                            horizontal = WgcCoreDsSpacing.sm12.dp,
                            vertical = WgcCoreDsSpacing.xxs4.dp
                        )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.gymTextInverse),
                            modifier = Modifier.size(WgcCoreDsSize.s12.dp)
                        )
                        Text(
                            text = planTitle.uppercase(),
                            color = Color(WgcCoreDsColors.gymTextInverse),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Black
                        )
                    }
                }
            }

            // Bloco central do QR Code
            Box(
                modifier = Modifier
                    .size(WgcCoreDsSize.s180.dp)
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp))
                    .background(Color.White)
                    .padding(WgcCoreDsSpacing.md16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.QrCode,
                        contentDescription = "QR Code Catraca",
                        tint = Color.Black,
                        modifier = Modifier.size(WgcCoreDsSize.s140.dp)
                    )
                }
            }

            // Rodapé do QR Code com expiração
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Sync,
                    contentDescription = null,
                    tint = Color(WgcCoreDsColors.gymTextSecondary),
                    modifier = Modifier
                        .size(WgcCoreDsSize.s16.dp)
                        .clickable(enabled = onRefreshCode != null) { onRefreshCode?.invoke() }
                )
                Text(
                    text = " Atualiza em ${expiresInSeconds}s • Matrícula: $membershipId",
                    color = Color(WgcCoreDsColors.gymTextSecondary),
                    fontSize = 11.sp
                )
            }

            // Botão de liberação rápida / slot
            if (slotAction != null) {
                slotAction()
            } else if (onCheckInClick != null) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(WgcCoreDsSize.s48.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                        .background(Color(WgcCoreDsColors.gymYellow))
                        .clickable { onCheckInClick() },
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.gymTextInverse),
                            modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                        )
                        Text(
                            text = "LIBERAR CATRACA AGORA",
                            color = Color(WgcCoreDsColors.gymTextInverse),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Preview(name = "GymFitness Pass - Preview")
@Composable
fun WgcGymFitnessQrPassCardPreview() {
    WgcGymQrPassCard(
        studentName = "Gabriel do Carmo",
        planTitle = "Plano Black",
        membershipId = "BR-984321",
        unitName = "Gym & Fitness - Paulista",
        expiresInSeconds = 52
    )
}
