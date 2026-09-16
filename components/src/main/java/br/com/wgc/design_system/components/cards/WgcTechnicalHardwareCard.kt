package br.com.wgc.design_system.components.cards

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
import br.com.wgc.design_system.components.buttons.WgcClassicButton

@Composable
fun WgcTechnicalHardwareCard(
    category: String,
    name: String,
    originalPrice: Double,
    discountPrice: Double,
    socket: String,
    tdpWatts: Int,
    benchmarkScore: Int,
    modifier: Modifier = Modifier,
    buttonText: String = "Comprar",
    onBuyClick: () -> Unit = {}
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
    ) {
        Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
            Text(text = category, color = Color(WgcCoreDsColors.hardwareOrange), fontWeight = FontWeight.Bold, fontSize = 12.sp)
            Text(text = name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
            Text(text = "De R$ " + String.format("%.2f", originalPrice), fontSize = 12.sp, color = Color.Gray)
            Text(
                text = "Por R$ " + String.format("%.2f", discountPrice) + " no PIX",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color(WgcCoreDsColors.hardwareOrange)
            )
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
            Text(text = "Socket: $socket • TDP: ${tdpWatts}W • Score: $benchmarkScore pts", fontSize = 12.sp, color = Color.DarkGray)
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))
            WgcClassicButton(
                textButton = buttonText,
                onClick = onBuyClick,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcTechnicalHardwareCardPreview() {
    WgcTechnicalHardwareCard(
        category = "Placa de Vídeo (GPU)",
        name = "RTX 4070 Super 12GB GDDR6X",
        originalPrice = 4599.90,
        discountPrice = 3999.99,
        socket = "PCIe 4.0 16x",
        tdpWatts = 220,
        benchmarkScore = 21450
    )
}
