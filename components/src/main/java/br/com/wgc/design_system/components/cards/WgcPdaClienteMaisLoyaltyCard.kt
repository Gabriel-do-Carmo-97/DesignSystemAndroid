package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Diamond
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import java.util.Locale

/**
 * Card de Fidelidade VIP "Cliente VIP Gourmet".
 *
 * Apresenta categoria VIP (Black/Gold), saldo de Stillo Moedas, economia acumulada
 * e atalho rápido para o QR Code de identificação no caixa físico.
 */
@Composable
fun WgcPdaClienteMaisLoyaltyCard(
    clientName: String,
    cpfMasked: String,
    tier: String,
    stilloCoins: Int,
    monthlySavings: Double,
    modifier: Modifier = Modifier,
    progressToNextTier: Float = 0.85f,
    onShowQrCode: () -> Unit = {},
    onClick: () -> Unit = {}
) {
    val isBlackTier = tier.contains("Black", ignoreCase = true)

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isBlackTier) Color(WgcCoreDsColors.premiumGroceryTextPrimary) else Color(WgcCoreDsColors.premiumGroceryGreenDark)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = WgcCoreDsElevation.level3.dp
        ),
        border = androidx.compose.foundation.BorderStroke(
            width = WgcCoreDsSize.s1.dp,
            color = Color(WgcCoreDsColors.premiumGroceryGold)
        )
    ) {
        Column(
            modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)
        ) {
            // Linha Superior: Logo / Nome do Programa e Ícone QR Code
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
                            .size(WgcCoreDsSize.s32.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                            .background(Color(WgcCoreDsColors.premiumGroceryGoldLight)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = if (isBlackTier) Icons.Default.Diamond else Icons.Default.Star,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.premiumGroceryGoldDark),
                            modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                        )
                    }

                    Column {
                        Text(
                            text = tier.uppercase(Locale.ROOT),
                            color = Color(WgcCoreDsColors.premiumGroceryGold),
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Black
                        )
                        Text(
                            text = clientName,
                            color = Color.White,
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                // Botão QR Code para o Caixa
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                        .background(Color.White)
                        .clickable(onClick = onShowQrCode)
                        .padding(horizontal = WgcCoreDsSpacing.xs8.dp, vertical = WgcCoreDsSpacing.xxs4.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.QrCode,
                            contentDescription = "QR Code Caixa",
                            tint = Color(WgcCoreDsColors.premiumGroceryGreenDark),
                            modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                        )
                        Text(
                            text = "NO CAIXA",
                            color = Color(WgcCoreDsColors.premiumGroceryGreenDark),
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            // Métricas: Saldo Stillo Moedas & Economia no Mês
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                    .background(Color.White.copy(alpha = 0.08f))
                    .padding(WgcCoreDsSpacing.sm12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "STILLO MOEDAS",
                        color = Color(WgcCoreDsColors.premiumGroceryGoldLight),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "$stilloCoins pts",
                        color = Color.White,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Black
                    )
                }

                Box(
                    modifier = Modifier
                        .width(WgcCoreDsSize.s1.dp)
                        .height(WgcCoreDsSize.s28.dp)
                        .background(Color.White.copy(alpha = 0.2f))
                )

                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = "ECONOMIA DO MÊS",
                        color = Color(WgcCoreDsColors.premiumGroceryGoldLight),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = String.format(Locale.GERMANY, "R$ %.2f", monthlySavings),
                        color = Color(WgcCoreDsColors.premiumGroceryGold),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Black
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            // Barra de Progresso do Nível VIP
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Manutenção do Nível Black",
                        color = Color.White.copy(alpha = 0.8f),
                        style = MaterialTheme.typography.labelSmall
                    )
                    Text(
                        text = "${(progressToNextTier * 100).toInt()}%",
                        color = Color(WgcCoreDsColors.premiumGroceryGold),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))

                LinearProgressIndicator(
                    progress = { progressToNextTier },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(WgcCoreDsSpacing.xs8.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)),
                    color = Color(WgcCoreDsColors.premiumGroceryGold),
                    trackColor = Color.White.copy(alpha = 0.2f)
                )
            }
        }
    }
}

@Preview(name = "Cliente Mais Loyalty Card - Black Tier", showBackground = true)
@Composable
private fun WgcPdaClienteMaisLoyaltyCardPreview() {
    WgcPdaClienteMaisLoyaltyCard(
        clientName = "Gabriel do Carmo",
        cpfMasked = "***.458.918-**",
        tier = "Cliente Mais Black",
        stilloCoins = 2840,
        monthlySavings = 428.50,
        progressToNextTier = 0.82f
    )
}
