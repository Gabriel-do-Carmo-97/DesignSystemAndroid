package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.EventRepeat
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
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcClassicButton

@Composable
fun WgcDrogaRaiaSubscriptionCard(
    medicineName: String,
    dosageFrequency: String,
    nextDeliveryDate: String,
    monthlyPrice: Double,
    modifier: Modifier = Modifier,
    isActive: Boolean = true,
    onManageClick: () -> Unit = {}
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.pharmacyChainSurface)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp),
        border = BorderStroke(WgcCoreDsSize.s1.dp, Color(WgcCoreDsColors.pharmacyChainBorder))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(WgcCoreDsSize.s36.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                            .background(Color(WgcCoreDsColors.pharmacyChainGreenLight)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.EventRepeat,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.pharmacyChainGreen),
                            modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                    Column {
                        Text(
                            text = "Assinatura Raia Ativa",
                            fontSize = 14.sp,
                            color = Color(WgcCoreDsColors.pharmacyChainGreen),
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = medicineName,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.pharmacyChainTextPrimary)
                        )
                    }
                }

                Text(
                    text = "R$ " + String.format("%.2f", monthlyPrice) + "/mês",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.pharmacyChainNavy)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.CalendarToday,
                    contentDescription = null,
                    tint = Color(WgcCoreDsColors.pharmacyChainTextSecondary),
                    modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                )
                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                Text(
                    text = "Frequência: $dosageFrequency",
                    fontSize = 14.sp,
                    color = Color(WgcCoreDsColors.pharmacyChainTextSecondary)
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Próxima Entrega: $nextDeliveryDate",
                    fontSize = 14.sp,
                    color = Color(WgcCoreDsColors.pharmacyChainRed),
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            WgcClassicButton(
                textButton = "Gerenciar Assinatura",
                onClick = onManageClick,
                modifier = Modifier.fillMaxWidth()
                
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcDrogaRaiaSubscriptionCardPreview() {
    WgcDrogaRaiaSubscriptionCard(
        medicineName = "Losartana Potássica 50mg",
        dosageFrequency = "1 comprimido ao dia (30 comp)",
        nextDeliveryDate = "05/10/2026",
        monthlyPrice = 18.90
    )
}
