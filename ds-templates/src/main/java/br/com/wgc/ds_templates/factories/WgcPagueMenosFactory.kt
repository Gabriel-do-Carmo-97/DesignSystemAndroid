package br.com.wgc.ds_templates.factories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsFontSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcPagueMenosClinicCard
import br.com.wgc.design_system.components.cards.WgcPagueMenosConvenioCard

enum class WgcPagueMenosScreen {
    HOME,
    CLINIC,
    CONVENIO,
    CART,
    PROFILE
}

@Composable
fun WgcPagueMenosFactory(
    modifier: Modifier = Modifier,
    screen: WgcPagueMenosScreen = WgcPagueMenosScreen.HOME,
    onNavigate: (WgcPagueMenosScreen) -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color(WgcCoreDsColors.pagueMenosBackground)
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            item {
                WgcPagueMenosConvenioCard(
                    convenioName = "Bradesco Saúde / Orizon",
                    cardNumberMasked = "9874 **** **** 1029",
                    discountPercentage = 45
                )
            }
            item {
                Text(
                    text = "Clinic Farma • Salas de Atendimento",
                    fontSize = WgcCoreDsFontSize.lg18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.pagueMenosTextPrimary)
                )
            }
            item {
                WgcPagueMenosClinicCard(
                    serviceTitle = "Aferição de Pressão + Bioimpedância",
                    description = "Acompanhamento profissional com farmacêutico em sala exclusiva climatizada.",
                    price = 0.0,
                    estimatedDuration = "15 min"
                )
            }
            item {
                WgcPagueMenosClinicCard(
                    serviceTitle = "Aplicação de Injetáveis",
                    description = "Com apresentação da prescrição médica válida.",
                    price = 12.0,
                    estimatedDuration = "10 min"
                )
            }
        }
    }
}
