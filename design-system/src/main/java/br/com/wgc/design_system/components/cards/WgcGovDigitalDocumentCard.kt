package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing

@Composable
fun WgcGovDigitalDocumentCard(
    documentTitle: String,
    citizenName: String,
    documentNumberMasked: String,
    securityLevel: String = "Conta Ouro Gov.br",
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.govBlue)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.xs2.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(WgcCoreDsSpacing.md16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = null,
                    tint = Color(WgcCoreDsColors.govYellow),
                    modifier = Modifier.size(WgcCoreDsSize.s28.dp)
                )
                Spacer(modifier = Modifier.size(WgcCoreDsSpacing.xs8.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = documentTitle,
                        color = Color.White,
                        fontSize = 14.sp.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = citizenName,
                        color = Color.White.copy(alpha = 0.85f),
                        fontSize = 14.sp.sp
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.VerifiedUser,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.govYellow),
                        modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                    )
                    Spacer(modifier = Modifier.size(WgcCoreDsSpacing.xxs4.dp))
                    Text(
                        text = securityLevel,
                        color = Color(WgcCoreDsColors.govYellow),
                        fontSize = 14.sp.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}
