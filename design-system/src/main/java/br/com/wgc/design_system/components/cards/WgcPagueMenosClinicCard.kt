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
import androidx.compose.material.icons.filled.HealthAndSafety
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
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcClassicButton

@Composable
fun WgcPagueMenosClinicCard(
    serviceTitle: String,
    description: String,
    price: Double,
    estimatedDuration: String,
    modifier: Modifier = Modifier,
    onBookClick: () -> Unit = {}
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.pagueMenosSurface)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp),
        border = BorderStroke(WgcCoreDsSize.s1.dp, Color(WgcCoreDsColors.pagueMenosBorder))
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
                            .background(Color(WgcCoreDsColors.pagueMenosClinicTealLight)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.MonitorHeart,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.pagueMenosClinicTeal),
                            modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                    Column {
                        Text(
                            text = "Clinic Farma • Pague Menos",
                            fontSize = 14.sp,
                            color = Color(WgcCoreDsColors.pagueMenosClinicTeal),
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = serviceTitle,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.pagueMenosTextPrimary)
                        )
                    }
                }

                Text(
                    text = if (price > 0) "R$ " + String.format("%.2f", price) else "Gratuito",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.pagueMenosGreen)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            Text(
                text = description,
                fontSize = 14.sp,
                color = Color(WgcCoreDsColors.pagueMenosTextSecondary)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.AccessTime,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.pagueMenosTextSecondary),
                        modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                    )
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                    Text(
                        text = estimatedDuration,
                        fontSize = 14.sp,
                        color = Color(WgcCoreDsColors.pagueMenosTextSecondary)
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
private fun WgcPagueMenosClinicCardPreview() {
    WgcPagueMenosClinicCard(
        serviceTitle = "Aferição de Pressão + Bioimpedância",
        description = "Acompanhamento profissional com farmacêutico em sala exclusiva climatizada.",
        price = 0.0,
        estimatedDuration = "15 min"
    )
}
