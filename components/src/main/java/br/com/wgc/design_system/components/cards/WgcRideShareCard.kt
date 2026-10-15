package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.design_system.core.tokens.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.theme.WgcCoreDsColors
import br.com.wgc.design_system.core.tokens.WgcCoreDsSize
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing
import java.util.Locale

@Composable
fun WgcRideShareCard(
    name: String,
    eta: String,
    price: Double,
    discount: String? = null,
    isSelected: Boolean = false,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth().clickable(onClick = onClick),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.XL16.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) {
                Color(WgcCoreDsColors.yellow4).copy(alpha = 0.15f)
            } else {
                Color.White
            }
        ),
        border = if (isSelected) {
            BorderStroke(WgcCoreDsSize.S2.dp, Color(WgcCoreDsColors.yellow4))
        } else {
            BorderStroke(WgcCoreDsSize.S1.dp, Color(WgcCoreDsColors.grayLight7))
        }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(WgcCoreDsSpacing.MD16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.SM12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Default.DirectionsCar,
                    contentDescription = null,
                    tint = Color(WgcCoreDsColors.yellow4),
                    modifier = Modifier.size(WgcCoreDsSize.S32.dp)
                )
                Column {
                    Text(name, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    Text("Chega em $eta", fontSize = 14.sp, color = Color.Gray)
                    discount?.let {
                        Text(
                            it,
                            fontSize = 14.sp,
                            color = Color(WgcCoreDsColors.green12),
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
            Text(
                "R$ " + String.format(Locale.getDefault(), "%,.2f", price),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 14.sp
            )
        }
    }
}

@Preview(showBackground = true, name = "Default Ride Share Card")
@Composable
private fun WgcRideShareCardPreview() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        WgcRideShareCard(
            name = "Wgc Comfort",
            eta = "3 min",
            price = 24.50,
            discount = "R$ 5,00 de desconto"
        )
        WgcRideShareCard(
            name = "Wgc Black",
            eta = "5 min",
            price = 42.80,
            isSelected = true
        )
    }
}
