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
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Vaccines
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
fun WgcHealthVaccineCard(
    vaccineName: String,
    targetAudience: String,
    price: Double,
    modifier: Modifier = Modifier,
    nextAvailableSlot: String = "Hoje disponível",
    onScheduleClick: () -> Unit = {}
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.XL16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.white)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.LEVEL1.dp),
        border = BorderStroke(WgcCoreDsSize.S1.dp, Color(WgcCoreDsColors.blueLight11))
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
                            .background(Color(WgcCoreDsColors.greenLight5)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Vaccines,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.cyan1),
                            modifier = Modifier.size(WgcCoreDsSize.S20.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.XS8.dp))
                    Column {
                        Text(
                            text = "Serviços Farmacêuticos",
                            fontSize = 14.sp,
                            color = Color(WgcCoreDsColors.cyan1),
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = vaccineName,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.blueDark15)
                        )
                    }
                }

                Text(
                    text = "R$ " + String.format(Locale.getDefault(), "%.2f", price),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.red12)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XS8.dp))

            Text(
                text = "Público: $targetAudience",
                fontSize = 14.sp,
                color = Color(WgcCoreDsColors.gray5)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XS8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.CalendarMonth,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.blue3),
                        modifier = Modifier.size(WgcCoreDsSize.S16.dp)
                    )
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.XXS4.dp))
                    Text(
                        text = nextAvailableSlot,
                        fontSize = 14.sp,
                        color = Color(WgcCoreDsColors.blue3),
                        fontWeight = FontWeight.SemiBold
                    )
                }

                WgcClassicButton(
                    textButton = "Agendar",
                    onClick = onScheduleClick
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcHealthVaccineCardPreview() {
    WgcHealthVaccineCard(
        vaccineName = "Vacina Gripe Tetravalente",
        targetAudience = "Adultos e Crianças a partir de 6 meses",
        price = 79.90
    )
}
