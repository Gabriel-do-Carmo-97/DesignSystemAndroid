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
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
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
fun WgcDoctoraliaSpecialistCard(
    doctorName: String,
    crm: String,
    specialty: String,
    rating: Double,
    reviewsCount: Int,
    consultationFee: Double,
    nextSlot: String,
    modifier: Modifier = Modifier,
    onBookClick: () -> Unit = {}
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
    ) {
        Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(WgcCoreDsSize.s48.dp)
                        .clip(CircleShape)
                        .background(Color(WgcCoreDsColors.doctoraliaGreenLight)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.doctoraliaGreen),
                        modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                    )
                }
                Spacer(modifier = Modifier.size(WgcCoreDsSpacing.md16.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = doctorName, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text(text = "$specialty • $crm", fontSize = 13.sp, color = Color.Gray)
                }
            }
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Star, contentDescription = null, tint = Color(WgcCoreDsColors.tokstokYellow), modifier = Modifier.size(WgcCoreDsSize.s16.dp))
                    Spacer(modifier = Modifier.size(WgcCoreDsSpacing.xxxs2.dp))
                    Text(text = "$rating ($reviewsCount opiniões)", fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                }
                Text(text = "R$ " + String.format("%.2f", consultationFee), fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color(WgcCoreDsColors.doctoraliaNavy))
            }
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
            Text(text = "Próximo horário: $nextSlot", fontSize = 12.sp, color = Color(WgcCoreDsColors.doctoraliaGreen), fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))
            WgcClassicButton(
                textButton = "Agendar Telemedicina",
                onClick = onBookClick,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcDoctoraliaSpecialistCardPreview() {
    WgcDoctoraliaSpecialistCard(
        doctorName = "Dra. Juliana Mendes",
        crm = "CRM-SP 148.920",
        specialty = "Dermatologia",
        rating = 4.9,
        reviewsCount = 312,
        consultationFee = 280.00,
        nextSlot = "Hoje às 16:30"
    )
}
