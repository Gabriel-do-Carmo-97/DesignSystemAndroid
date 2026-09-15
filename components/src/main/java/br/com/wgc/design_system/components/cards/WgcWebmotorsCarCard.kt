package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSpacing

@Composable
fun WgcWebmotorsCarCard(
    makeModel: String,
    version: String,
    yearModel: String,
    mileageKm: Int,
    price: Double,
    fipePrice: Double,
    cityState: String,
    isReportApproved: Boolean = true,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier.fillMaxWidth().clickable { onClick() },
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
    ) {
        Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
            Text(text = makeModel, fontWeight = FontWeight.Bold, fontSize = 17.sp)
            Text(text = version, fontSize = 12.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "R$ " + String.format("%.2f", price),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color(WgcCoreDsColors.webmotorsRed)
                )
                Text(
                    text = "FIPE: R$ " + String.format("%.2f", fipePrice),
                    fontSize = 12.sp,
                    color = Color(WgcCoreDsColors.cdtGreen),
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
            Text(text = "$yearModel • $mileageKm km • $cityState", fontSize = 12.sp, color = Color.DarkGray)
            if (isReportApproved) {
                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                Text(text = "🛡️ Laudo Cautelar Aprovado", fontSize = 11.sp, color = Color(WgcCoreDsColors.cdtGreen), fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcWebmotorsCarCardPreview() {
    WgcWebmotorsCarCard(
        makeModel = "Honda Civic Touring",
        version = "2.0 Turbo 16V CVT",
        yearModel = "2024/2024",
        mileageKm = 14500,
        price = 189900.00,
        fipePrice = 195400.00,
        cityState = "São Paulo - SP"
    )
}
