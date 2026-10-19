package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
fun WgcFashionItemCard(
    brandName: String,
    itemTitle: String,
    price: Double,
    installments: String,
    modifier: Modifier = Modifier,
    onBuy: () -> Unit = {}
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
                    .height(WgcCoreDsSize.S120.dp)
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.MD8.dp))
                    .background(Color.LightGray)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.SM12.dp))

            Text(
                text = brandName.uppercase(),
                fontSize = 14.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = itemTitle,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XS8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "R$ " + String.format("%.2f", price),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.red8)
                    )
                    Text(
                        text = installments,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }

                WgcClassicButton(
                    textButton = "Comprar",
                    onClick = onBuy
                    )
            }
        }
    }
}

@Preview(name = "WgcFashionItemCard Preview", showBackground = true)
@Composable
private fun WgcFashionItemCardPreview() {
    WgcTheme {
        Column(modifier = Modifier.padding(WgcCoreDsSpacing.MD16.dp)) {
            WgcFashionItemCard(
                brandName = "Zara",
                itemTitle = "Jaqueta de Couro Slim Fit",
                price = 299.90,
                installments = "6x de R$ 49,98 sem juros"
            )
        }
    }
}
