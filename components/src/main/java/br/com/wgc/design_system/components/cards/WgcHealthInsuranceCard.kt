package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.CheckCircle
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
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsElevation
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcClassicButton

@Composable
fun WgcHealthInsuranceCard(
    insuranceName: String,
    cardNumberMasked: String,
    discountPercentage: Int,
    modifier: Modifier = Modifier,
    isLinked: Boolean = true,
    onManageInsurance: () -> Unit = {}
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.popularPharmacyBlueLight)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level0.dp),
        border = BorderStroke(WgcCoreDsSize.s1.dp, Color(WgcCoreDsColors.popularPharmacyBorder))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(WgcCoreDsSize.s40.dp)
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                    .background(Color(WgcCoreDsColors.popularPharmacyBlue)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Badge,
                    contentDescription = null,
                    tint = Color(WgcCoreDsColors.popularPharmacySurface),
                    modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                )
            }

            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = insuranceName,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.popularPharmacyBlueDark)
                    )
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                    if (isLinked) {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = "Vinculado",
                            tint = Color(WgcCoreDsColors.popularPharmacyGreen),
                            modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                        )
                    }
                }
                Text(
                    text = "Carteirinha: $cardNumberMasked",
                    fontSize = 14.sp,
                    color = Color(WgcCoreDsColors.popularPharmacyTextSecondary)
                )
                Text(
                    text = "Até $discountPercentage% de desconto em medicamentos",
                    fontSize = 14.sp,
                    color = Color(WgcCoreDsColors.popularPharmacyGreen),
                    fontWeight = FontWeight.Bold
                )
            }

            WgcClassicButton(
                textButton = "Alterar",
                onClick = onManageInsurance
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcHealthInsuranceCardPreview() {
    WgcHealthInsuranceCard(
        insuranceName = "Bradesco Saúde / Orizon",
        cardNumberMasked = "9874 **** **** 1029",
        discountPercentage = 45
    )
}
