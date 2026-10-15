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
import androidx.compose.material.icons.filled.Description
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
import br.com.wgc.design_system.components.buttons.WgcClassicButton

@Composable
fun WgcPharmacyPrescriptionCard(
    modifier: Modifier = Modifier,
    onUploadPrescription: () -> Unit = {},
    onTalkToPharmacist: () -> Unit = {}
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.XL16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.blueLight13)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.LEVEL0.dp),
        border = BorderStroke(WgcCoreDsSize.S1.dp, Color(WgcCoreDsColors.blueLight8))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.MD16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(WgcCoreDsSize.S40.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.MD8.dp))
                        .background(Color(WgcCoreDsColors.blueDark16)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Description,
                        contentDescription = "Receita Médica",
                        tint = Color(WgcCoreDsColors.white),
                        modifier = Modifier.size(WgcCoreDsSize.S24.dp)
                    )
                }

                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.SM12.dp))

                Column {
                    Text(
                        text = "Enviar Receita Médica Digital",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.blueDark1)
                    )
                    Text(
                        text = "PDF, foto de receita ou link SMS com certificado",
                        fontSize = 14.sp,
                        color = Color(WgcCoreDsColors.blue20)
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.MD16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.XS8.dp)
            ) {
                WgcClassicButton(
                    textButton = "Enviar Receita",
                    onClick = onUploadPrescription,
                    modifier = Modifier.weight(1f)
                )

                WgcClassicButton(
                    textButton = "Farmacêutico",
                    onClick = onTalkToPharmacist,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcPharmacyPrescriptionCardPreview() {
    WgcPharmacyPrescriptionCard()
}
