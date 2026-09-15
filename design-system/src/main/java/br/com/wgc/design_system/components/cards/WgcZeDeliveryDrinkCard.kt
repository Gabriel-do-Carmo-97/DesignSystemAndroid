package br.com.wgc.design_system.components.cards

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SportsBar
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
fun WgcZeDeliveryDrinkCard(
    drinkName: String,
    volume: String,
    temperatureText: String,
    price: Double,
    isReturnable: Boolean = false,
    modifier: Modifier = Modifier,
    onAddClick: () -> Unit = {}
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
    ) {
        Row(
            modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(WgcCoreDsSize.s48.dp)
                    .clip(CircleShape)
                    .background(Color(WgcCoreDsColors.zeDeliveryYellow)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.SportsBar,
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                )
            }
            Spacer(modifier = Modifier.size(WgcCoreDsSpacing.md16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = drinkName, fontWeight = FontWeight.Bold, fontSize = 15.sp)
                Text(text = "$volume • ❄️ $temperatureText", fontSize = 12.sp, color = Color(WgcCoreDsColors.decolarBlue))
                if (isReturnable) {
                    Text(text = "♻️ Casco Retornável", fontSize = 11.sp, color = Color(WgcCoreDsColors.cdtGreen), fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
                Text(text = "R$ " + String.format("%.2f", price), fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
            WgcClassicButton(
                textButton = "+ Adicionar",
                onClick = onAddClick
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcZeDeliveryDrinkCardPreview() {
    WgcZeDeliveryDrinkCard(
        drinkName = "Cerveja Spaten 600ml",
        volume = "600ml",
        temperatureText = "Estupidamente Gelada",
        price = 8.29,
        isReturnable = true
    )
}
