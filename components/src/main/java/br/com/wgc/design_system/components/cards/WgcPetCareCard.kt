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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pets
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
fun WgcPetCareCard(
    petProductTitle: String,
    weightOrSize: String,
    subscriberPrice: Double,
    regularPrice: Double,
    modifier: Modifier = Modifier,
    onSubscribeClick: () -> Unit = {}
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.XL16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.LEVEL1.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(WgcCoreDsSpacing.MD16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Pets,
                    contentDescription = null,
                    tint = Color(WgcCoreDsColors.blue6),
                    modifier = Modifier.padding(end = WgcCoreDsSpacing.XS8.dp)
                )
                Text(
                    text = petProductTitle,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                text = "Embalagem: $weightOrSize",
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.SM12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "R$ " + String.format("%.2f", subscriberPrice),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.blue6)
                    )
                    Text(
                        text = "Preço Assinante Pet Care",
                        fontSize = 14.sp,
                        color = Color.DarkGray,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                WgcClassicButton(
                    textButton = "Assinar",
                    onClick = onSubscribeClick
                    )
            }
        }
    }
}

@Preview(name = "WgcPetCareCard Preview", showBackground = true)
@Composable
private fun WgcPetCareCardPreview() {
    WgcTheme {
        Column(modifier = Modifier.padding(WgcCoreDsSpacing.MD16.dp)) {
            WgcPetCareCard(
                petProductTitle = "Ração Premium para Cães Adultos Raças Médias e Grandes 15kg",
                weightOrSize = "15 kg",
                subscriberPrice = 129.90,
                regularPrice = 159.90,
                onSubscribeClick = {}
            )
        }
    }
}
