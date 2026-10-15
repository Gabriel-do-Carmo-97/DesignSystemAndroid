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
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.MonitorHeart
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
fun WgcMedicalClinicCard(
    serviceTitle: String,
    description: String,
    price: Double,
    estimatedDuration: String,
    modifier: Modifier = Modifier,
    onBookClick: () -> Unit = {}
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.XL16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.white)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.LEVEL1.dp),
        border = BorderStroke(WgcCoreDsSize.S1.dp, Color(WgcCoreDsColors.blueLight3))
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
                            .background(Color(WgcCoreDsColors.cyanLight1)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.MonitorHeart,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.cyan2),
                            modifier = Modifier.size(WgcCoreDsSize.S20.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.XS8.dp))
                    Column {
                        Text(
                            text = "Clinic Farma • Saúde & Cuidados",
                            fontSize = 14.sp,
                            color = Color(WgcCoreDsColors.cyan2),
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = serviceTitle,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.blueDark21)
                        )
                    }
                }

                Text(
                    text = if (price > 0) "R$ " + String.format(Locale.getDefault(), "%.2f", price) else "Gratuito",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.green10)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XS8.dp))

            Text(
                text = description,
                fontSize = 14.sp,
                color = Color(WgcCoreDsColors.blue19)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.SM12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.AccessTime,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.blue19),
                        modifier = Modifier.size(WgcCoreDsSize.S16.dp)
                    )
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.XXS4.dp))
                    Text(
                        text = estimatedDuration,
                        fontSize = 14.sp,
                        color = Color(WgcCoreDsColors.blue19)
                    )
                }

                WgcClassicButton(
                    textButton = "Agendar Sala",
                    onClick = onBookClick
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcMedicalClinicCardPreview() {
    WgcMedicalClinicCard(
        serviceTitle = "Aferição de Pressão + Bioimpedância",
        description = "Acompanhamento profissional com farmacêutico em sala exclusiva climatizada.",
        price = 0.0,
        estimatedDuration = "15 min"
    )
}
