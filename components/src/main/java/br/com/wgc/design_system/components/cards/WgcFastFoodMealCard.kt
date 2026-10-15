package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.design_system.core.tokens.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.theme.WgcCoreDsColors
import br.com.wgc.design_system.core.tokens.WgcCoreDsElevation
import br.com.wgc.design_system.core.tokens.WgcCoreDsSize
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.theme.WgcTheme

@Composable
fun WgcFastFoodMealCard(
    comboName: String,
    description: String,
    price: Double,
    modifier: Modifier = Modifier,
    onAddMeal: () -> Unit = {}
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.XL16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.LEVEL1.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(WgcCoreDsSpacing.MD16.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(WgcCoreDsSize.S100.dp)
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.MD8.dp))
                    .background(Color.LightGray)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.SM12.dp))

            Text(
                text = comboName,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = description,
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XS8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "R$ " + String.format("%.2f", price),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.red14),
                    modifier = Modifier.weight(1f)
                )
                WgcClassicButton(
                    textButton = "Pedir Combo",
                    onClick = onAddMeal
                    )
            }
        }
    }
}

@Preview(name = "WgcFastFoodMealCard Preview", showBackground = true)
@Composable
private fun WgcFastFoodMealCardPreview() {
    WgcTheme {
        Column(modifier = Modifier.padding(WgcCoreDsSpacing.MD16.dp)) {
            WgcFastFoodMealCard(
                comboName = "Combo X-Burguer Duplo",
                description = "Hambúrguer duplo com queijo, batata frita média e refrigerante 500ml",
                price = 34.90,
                onAddMeal = {}
            )
        }
    }
}
