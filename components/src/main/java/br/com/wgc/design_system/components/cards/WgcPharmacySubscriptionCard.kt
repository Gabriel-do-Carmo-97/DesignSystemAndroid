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
import br.com.wgc.design_system.core.tokens.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.theme.WgcCoreDsColors
import br.com.wgc.design_system.core.tokens.WgcCoreDsElevation
import br.com.wgc.design_system.core.tokens.WgcCoreDsSize
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import java.util.Locale

@Composable
fun WgcPharmacySubscriptionCard(
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
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.XL16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.white)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.LEVEL1.dp),
        border = BorderStroke(WgcCoreDsSize.S1.dp, Color(WgcCoreDsColors.blueLight8))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.MD16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(WgcCoreDsSize.S36.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.MD8.dp))
                            .background(Color(WgcCoreDsColors.greenLight6)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.EventRepeat,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.green3),
                            modifier = Modifier.size(WgcCoreDsSize.S20.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.XS8.dp))
                    Column {
                        Text(
                            text = "Assinatura Ativa",
                            fontSize = 14.sp,
                            color = Color(WgcCoreDsColors.green3),
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = medicineName,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.blueDark28)
                        )
                    }
                }

                Text(
                    text = "R$ " + String.format(Locale.getDefault(), "%.2f", monthlyPrice) + "/mês",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.blueDark16)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.SM12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.CalendarToday,
                    contentDescription = null,
                    tint = Color(WgcCoreDsColors.blue20),
                    modifier = Modifier.size(WgcCoreDsSize.S16.dp)
                )
                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.XXS4.dp))
                Text(
                    text = "Frequência: $dosageFrequency",
                    fontSize = 14.sp,
                    color = Color(WgcCoreDsColors.blue20)
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Próxima Entrega: $nextDeliveryDate",
                    fontSize = 14.sp,
                    color = Color(WgcCoreDsColors.red8),
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.SM12.dp))

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
private fun WgcPharmacySubscriptionCardPreview() {
    WgcPharmacySubscriptionCard(
        medicineName = "Losartana Potássica 50mg",
        dosageFrequency = "1 comprimido ao dia (30 comp)",
        nextDeliveryDate = "05/10/2026",
        monthlyPrice = 18.90
    )
}
