package br.com.wgc.ds_templates.screens.drogasil.vaccines

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcDrogasilVaccineCard
import br.com.wgc.ds_templates.screens.drogasil.model.DrogasilMockData
import br.com.wgc.ds_templates.screens.drogasil.model.DrogasilVaccine

@Composable
fun WgcDrogasilVaccinesTemplate(
    modifier: Modifier = Modifier,
    vaccines: List<DrogasilVaccine> = DrogasilMockData.sampleVaccines,
    onScheduleVaccine: (DrogasilVaccine) -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize()) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            item {
                Text(
                    text = "Vacinação & Serviços Farmacêuticos",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.drogasilTextPrimary)
                )
                Text(
                    text = "Aplicação em sala privativa por farmacêuticos habilitados com registro no RNDS",
                    fontSize = 10.sp,
                    color = Color(WgcCoreDsColors.drogasilTextSecondary)
                )
            }

            items(vaccines) { vaccine ->
                WgcDrogasilVaccineCard(
                    vaccineName = vaccine.name,
                    targetAudience = vaccine.audience,
                    price = vaccine.price,
                    nextAvailableSlot = vaccine.slot,
                    onScheduleClick = { onScheduleVaccine(vaccine) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcDrogasilVaccinesTemplatePreview() {
    WgcDrogasilVaccinesTemplate()
}
