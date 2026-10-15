package br.com.wgc.design_system.components.cards

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.design_system.commons.previews.components.WgcComponentPreviews
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.core.tokens.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.theme.WgcCoreDsColors
import br.com.wgc.design_system.core.tokens.WgcCoreDsElevation
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing
import br.com.wgc.design_system.theme.WgcTheme

@Composable
fun WgcHomeImprovementCard(
    productName: String,
    department: String,
    price: Double,
    modifier: Modifier = Modifier,
    onAddToCart: () -> Unit = {}
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.XL16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.LEVEL1.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(WgcCoreDsSpacing.MD16.dp)) {
            Text(
                text = department.uppercase(),
                fontSize = 14.sp,
                color = Color(WgcCoreDsColors.green22),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = productName,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.SM12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "R$ " + String.format("%.2f", price),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.weight(1f)
                )

                WgcClassicButton(
                    textButton = "Comprar",
                    onClick = onAddToCart
                )
            }
        }
    }
}

@WgcComponentPreviews
@Composable
private fun WgcHomeImprovementCardPreview() {
    WgcTheme {
        WgcHomeImprovementCard(
            productName = "Furadeira e Parafusadeira de Impacto Bivolt",
            department = "Ferramentas Elétricas",
            price = 349.90,
            modifier = Modifier.padding(WgcCoreDsSpacing.MD16.dp),
            onAddToCart = {}
        )
    }
}
