package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
import br.com.wgc.design_system.core.tokens.WgcCoreDsElevation
import br.com.wgc.design_system.core.tokens.WgcCoreDsSize
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing
import br.com.wgc.design_system.theme.WgcTheme

@Composable
fun WgcLogisticsPackageCard(
    trackingCode: String,
    statusText: String,
    deliveryDate: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.XL16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.LEVEL1.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(WgcCoreDsSpacing.MD16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.LocalShipping,
                contentDescription = null,
                tint = Color(WgcCoreDsColors.blue29),
                modifier = Modifier.size(WgcCoreDsSize.S32.dp)
            )

            Spacer(modifier = Modifier.size(WgcCoreDsSpacing.MD16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Código: $trackingCode",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = statusText,
                    fontSize = 14.sp,
                    color = Color(WgcCoreDsColors.blue29),
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "Previsão: $deliveryDate",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview(name = "WgcLogisticsPackageCard Preview", showBackground = true)
@Composable
private fun WgcLogisticsPackageCardPreview() {
    WgcTheme {
        Column(modifier = Modifier.padding(WgcCoreDsSpacing.MD16.dp)) {
            WgcLogisticsPackageCard(
                trackingCode = "BR123456789X",
                statusText = "Em trânsito para a unidade de distribuição",
                deliveryDate = "18/10/2026"
            )
        }
    }
}
