package br.com.wgc.ds_templates.screens.paguemenos.clinic

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
import br.com.wgc.core_ds.WgcCoreDsFontSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcPagueMenosClinicCard
import br.com.wgc.ds_templates.screens.paguemenos.model.ClinicService
import br.com.wgc.ds_templates.screens.paguemenos.model.PagueMenosMockData

@Composable
fun WgcPagueMenosClinicTemplate(
    modifier: Modifier = Modifier,
    services: List<ClinicService> = PagueMenosMockData.clinicServices
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color(WgcCoreDsColors.pagueMenosBackground)
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            item {
                Text(
                    text = "Consultório Clinic Farma",
                    fontSize = WgcCoreDsFontSize.xl20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.pagueMenosTextPrimary)
                )
                Text(
                    text = "Acompanhamento de saúde com farmacêuticos especialistas",
                    fontSize = WgcCoreDsFontSize.xs12.sp,
                    color = Color(WgcCoreDsColors.pagueMenosTextSecondary)
                )
            }

            items(services) { s ->
                WgcPagueMenosClinicCard(
                    serviceTitle = s.title,
                    description = s.desc,
                    price = s.price,
                    estimatedDuration = s.duration
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcPagueMenosClinicTemplatePreview() {
    WgcPagueMenosClinicTemplate()
}
