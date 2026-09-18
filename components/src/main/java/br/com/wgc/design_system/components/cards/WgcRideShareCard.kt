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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
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
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = if (isSelected) Color(WgcCoreDsColors.urbanMobilityYellow).copy(alpha = 0.15f) else Color.White),
        border = if (isSelected) BorderStroke(WgcCoreDsSize.s2.dp, Color(WgcCoreDsColors.urbanMobilityYellow)) else BorderStroke(WgcCoreDsSize.s1.dp, Color(WgcCoreDsColors.gray200))
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(WgcCoreDsSpacing.md16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp), verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.DirectionsCar, contentDescription = null, tint = Color(WgcCoreDsColors.urbanMobilityYellow), modifier = Modifier.size(WgcCoreDsSize.s32.dp))
                Column {
                    Text(name, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    Text("Chega em $eta", fontSize = 14.sp, color = Color.Gray)
                    discount?.let {
                        Text(it, fontSize = 14.sp, color = Color(WgcCoreDsColors.premiumGrocerySuccessGreen), fontWeight = FontWeight.SemiBold)
                    }
                }
            }
            Text("R$ " + String.format(Locale.getDefault(), "%,.2f", price), fontWeight = FontWeight.ExtraBold, fontSize = 14.sp)
        }
    }
}
