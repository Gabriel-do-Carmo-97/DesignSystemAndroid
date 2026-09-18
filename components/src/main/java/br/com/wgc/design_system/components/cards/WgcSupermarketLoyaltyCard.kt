package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Diamond
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material.icons.filled.Star
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
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import java.util.Locale

@Composable
fun WgcSupermarketLoyaltyCard(
    clientName: String,
    cpfMasked: String,
    tier: String,
    coinsBalance: Int,
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
                            tint = Color(WgcCoreDsColors.premiumGroceryGold),
                            modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                        )
                    }
                    Column {
                        Text(
                            text = "Fidelidade VIP • $tier",
                            color = Color(WgcCoreDsColors.premiumGroceryGold),
                            fontWeight = FontWeight.Bold,
                            style = androidx.compose.material3.MaterialTheme.typography.bodySmall
                        )
                        Text(
                            text = clientName,
                            color = Color(WgcCoreDsColors.premiumGrocerySurface),
                            fontWeight = FontWeight.Bold,
                            style = androidx.compose.material3.MaterialTheme.typography.titleMedium
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                        .background(Color(WgcCoreDsColors.premiumGrocerySurface))
                        .clickable(onClick = onShowQrCode)
                        .padding(horizontal = WgcCoreDsSpacing.sm12.dp, vertical = WgcCoreDsSpacing.xs8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.QrCode,
                            contentDescription = "QR Code",
                            tint = Color(WgcCoreDsColors.premiumGroceryGreenDark),
                            modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                        )
                        Text(
                            text = "Apresentar",
                            color = Color(WgcCoreDsColors.premiumGroceryGreenDark),
                            fontWeight = FontWeight.Bold,
                            style = androidx.compose.material3.MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Moedas Acumuladas",
                        color = Color(WgcCoreDsColors.premiumGroceryTextSecondary),
                        style = androidx.compose.material3.MaterialTheme.typography.bodySmall
                    )
                    Text(
                        text = "$coinsBalance Stillo Coins",
                        color = Color(WgcCoreDsColors.premiumGroceryGold),
                        fontWeight = FontWeight.ExtraBold,
                        style = androidx.compose.material3.MaterialTheme.typography.titleMedium
                    )
                }

                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = "Economia no Mês",
                        color = Color(WgcCoreDsColors.premiumGroceryTextSecondary),
                        style = androidx.compose.material3.MaterialTheme.typography.bodySmall
                    )
                    Text(
                        text = "R$ " + String.format(Locale.getDefault(), "%.2f", monthlySavings),
                        color = Color(WgcCoreDsColors.premiumGrocerySurface),
                        fontWeight = FontWeight.ExtraBold,
                        style = androidx.compose.material3.MaterialTheme.typography.titleMedium
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Progresso para Black Diamond",
                        color = Color(WgcCoreDsColors.premiumGroceryTextSecondary),
                        style = androidx.compose.material3.MaterialTheme.typography.bodySmall
                    )
                    Text(
                        text = "${(progressToNextTier * 100).toInt()}%",
                        color = Color(WgcCoreDsColors.premiumGroceryGold),
                        fontWeight = FontWeight.Bold,
                        style = androidx.compose.material3.MaterialTheme.typography.bodySmall
                    )
                }
                LinearProgressIndicator(
                    progress = { progressToNextTier },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(WgcCoreDsSize.s6.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)),
                    color = Color(WgcCoreDsColors.premiumGroceryGold),
                    trackColor = Color(WgcCoreDsColors.premiumGroceryGreenDark)
                )
            }
        }
    }
}

@Preview(name = "Supermarket Loyalty Card - Preview", showBackground = true)
@Composable
private fun WgcSupermarketLoyaltyCardPreview() {
    WgcSupermarketLoyaltyCard(
        clientName = "Beatriz Mendonça",
        cpfMasked = "321.***.***-99",
        tier = "Gold Member",
        coinsBalance = 1420,
        monthlySavings = 384.50
    )
}
