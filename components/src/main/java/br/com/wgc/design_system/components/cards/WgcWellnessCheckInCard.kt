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
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material.icons.filled.Timer
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
 * Card de Validação de Check-In Diário Corporate Wellness (Wellness Network).
 *
 * Apresenta o token numérico diário, academia confirmada, dados do colaborador
 * e temporizador de liberação para a recepção/catraca.
 *
 * 100% tokenizado com WgcCoreDs e State Hoisting.
 */
@Composable
fun WgcWellnessCheckInCard(
    gymName: String,
    userName: String,
    planTitle: String,
    tokenCode: String,
    validUntil: String,
    modifier: Modifier = Modifier,
    isConfirmed: Boolean = true,
    onCopyToken: (() -> Unit)? = null,
    onShowQr: (() -> Unit)? = null,
    slotAction: (@Composable () -> Unit)? = null
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.wellnessForest)),
        border = BorderStroke(WgcCoreDsSize.s1.dp, Color(WgcCoreDsColors.wellnessForestDark)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level6.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            // Cabeçalho com selo de status
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.wellnessCheckInGreen),
                        modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                    )
                    Text(
                        text = if (isConfirmed) "CHECK-IN CONFIRMADO" else "CHECK-IN PENDENTE",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Black,
                        letterSpacing = 1.sp
                    )
                }

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                        .background(Color.White.copy(alpha = 0.15f))
                        .padding(horizontal = WgcCoreDsSpacing.sm12.dp, vertical = WgcCoreDsSpacing.xxs4.dp)
                ) {
                    Text(
                        text = planTitle.uppercase(),
                        color = Color.White,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // Informações da Academia & Aluno
            Column(verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxxs2.dp)) {
                Text(
                    text = gymName,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Colaborador: $userName",
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 13.sp
                )
            }

            // Bloco do Token de Validação
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp))
                    .background(Color.White)
                    .padding(WgcCoreDsSpacing.md16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "CÓDIGO DE ACESSO",
                            color = Color(WgcCoreDsColors.wellnessSecondaryText),
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.sp
                        )
                        Text(
                            text = tokenCode,
                            color = Color(WgcCoreDsColors.wellnessForest),
                            fontSize = 26.sp,
                            fontWeight = FontWeight.Black,
                            letterSpacing = 3.sp
                        )
                    }

                    Row(horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
                        if (onCopyToken != null) {
                            Box(
                                modifier = Modifier
                                    .size(WgcCoreDsSize.s40.dp)
                                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                                    .background(Color(WgcCoreDsColors.wellnessCreamBg))
                                    .clickable { onCopyToken() },
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ContentCopy,
                                    contentDescription = "Copiar Código",
                                    tint = Color(WgcCoreDsColors.wellnessForest),
                                    modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                                )
                            }
                        }

                        if (onShowQr != null) {
                            Box(
                                modifier = Modifier
                                    .size(WgcCoreDsSize.s40.dp)
                                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                                    .background(Color(WgcCoreDsColors.wellnessCoral))
                                    .clickable { onShowQr() },
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.QrCode,
                                    contentDescription = "Ver QR Code",
                                    tint = Color.White,
                                    modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                                )
                            }
                        }
                    }
                }
            }

            // Rodapé com validade do check-in
            if (slotAction != null) {
                slotAction()
            } else {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Timer,
                        contentDescription = null,
                        tint = Color.White.copy(alpha = 0.8f),
                        modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                    )
                    Text(
                        text = " Validade do token: $validUntil",
                        color = Color.White.copy(alpha = 0.8f),
                        fontSize = 11.sp
                    )
                }
            }
        }
    }
}

@Preview(name = "Corporate Wellness Check-in Card - Confirmed")
@Composable
fun WgcCorporateWellnessCheckInCardPreview() {
    WgcWellnessCheckInCard(
        gymName = "Bio Ritmo - Unidade Jardins",
        userName = "Gabriel do Carmo",
        planTitle = "Plano Gold",
        tokenCode = "WH-94821",
        validUntil = "23:59 de hoje",
        onCopyToken = {},
        onShowQr = {}
    )
}
