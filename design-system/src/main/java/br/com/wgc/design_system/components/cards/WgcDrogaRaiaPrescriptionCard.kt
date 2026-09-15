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
import androidx.compose.material.icons.filled.FileUpload
import androidx.compose.material.icons.filled.SupportAgent
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
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcClassicButton

@Composable
fun WgcDrogaRaiaPrescriptionCard(
    modifier: Modifier = Modifier,
    onUploadPrescription: () -> Unit = {},
    onTalkToPharmacist: () -> Unit = {}
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.drogaRaiaNavyLight)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.none0.dp),
        border = BorderStroke(WgcCoreDsSize.s1.dp, Color(WgcCoreDsColors.drogaRaiaBorder))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(WgcCoreDsSize.s40.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                        .background(Color(WgcCoreDsColors.drogaRaiaNavy)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Description,
                        contentDescription = "Receita Médica",
                        tint = Color(WgcCoreDsColors.drogaRaiaSurface),
                        modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                    )
                }

                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))

                Column {
                    Text(
                        text = "Enviar Receita Médica Digital",
                        fontSize = 14.sp.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.drogaRaiaNavyDark)
                    )
                    Text(
                        text = "PDF, foto de receita ou link SMS com certificado",
                        fontSize = 14.sp.sp,
                        color = Color(WgcCoreDsColors.drogaRaiaTextSecondary)
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
            ) {
                WgcClassicButton(
                    text = "Enviar Receita",
                    onClick = onUploadPrescription,
                    modifier = Modifier.weight(1f),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.FileUpload,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.drogaRaiaSurface),
                            modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                        )
                    },
                    containerColor = Color(WgcCoreDsColors.drogaRaiaRed),
                    contentColor = Color(WgcCoreDsColors.drogaRaiaSurface)
                )

                WgcClassicButton(
                    text = "Farmacêutico",
                    onClick = onTalkToPharmacist,
                    modifier = Modifier.weight(1f),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.SupportAgent,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.drogaRaiaNavy),
                            modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                        )
                    },
                    containerColor = Color(WgcCoreDsColors.drogaRaiaSurface),
                    contentColor = Color(WgcCoreDsColors.drogaRaiaNavy)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcDrogaRaiaPrescriptionCardPreview() {
    WgcDrogaRaiaPrescriptionCard()
}
