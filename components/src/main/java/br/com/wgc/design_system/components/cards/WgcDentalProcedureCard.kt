package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.HealthAndSafety
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
import br.com.wgc.design_system.core.tokens.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.theme.WgcCoreDsColors
import br.com.wgc.design_system.core.tokens.WgcCoreDsElevation
import br.com.wgc.design_system.core.tokens.WgcCoreDsSize
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing

@Composable
fun WgcDentalProcedureCard(
    toothNumber: Int,
    toothName: String,
    statusText: String,
    statusColor: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier.fillMaxWidth().clickable { onClick() },
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.MD8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.LEVEL1.dp)
    ) {
        Row(
            modifier = Modifier.padding(WgcCoreDsSpacing.MD16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(WgcCoreDsSize.S40.dp)
                    .clip(CircleShape)
                    .background(Color(WgcCoreDsColors.cyanLight3)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.HealthAndSafety,
                    contentDescription = null,
                    tint = Color(WgcCoreDsColors.cyan5),
                    modifier = Modifier.size(WgcCoreDsSize.S24.dp)
                )
            }
            Spacer(modifier = Modifier.size(WgcCoreDsSpacing.MD16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Dente $toothNumber - $toothName",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Color(WgcCoreDsColors.cyanDark4)
                )
                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XXXS2.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(modifier = Modifier.size(WgcCoreDsSize.S8.dp).clip(CircleShape).background(statusColor))
                    Spacer(modifier = Modifier.size(WgcCoreDsSpacing.XXS4.dp))
                    Text(text = statusText, fontSize = 13.sp, color = Color.Gray)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcDentalProcedureCardPreview() {
    WgcDentalProcedureCard(
        toothNumber = 16,
        toothName = "Primeiro Molar Superior D",
        statusText = "Restauração Estética",
        statusColor = Color(WgcCoreDsColors.blue500)
    )
}
