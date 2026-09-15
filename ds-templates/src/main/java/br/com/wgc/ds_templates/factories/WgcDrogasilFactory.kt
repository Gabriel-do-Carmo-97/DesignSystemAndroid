package br.com.wgc.ds_templates.factories

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import br.com.wgc.design_system.components.cards.WgcDrogasilLoyaltyCard
import br.com.wgc.design_system.components.cards.WgcDrogasilVaccineCard

enum class WgcDrogasilScreen {
    HOME,
    VACCINES,
    LOYALTY,
    CART,
    PROFILE
}

@Composable
fun WgcDrogasilFactory(
    modifier: Modifier = Modifier,
    screen: WgcDrogasilScreen = WgcDrogasilScreen.HOME,
    onNavigate: (WgcDrogasilScreen) -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color(WgcCoreDsColors.drogasilBackground)
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            item {
                WgcDrogasilLoyaltyCard(
                    userName = "Mariana Alves",
                    cpfMasked = "123.***.***-00",
                    pointsBalance = 420
                )
            }
            item {
                Text(
                    text = "Vacinas e Serviços Farmacêuticos",
                    fontSize = WgcCoreDsFontSize.lg18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.drogasilTextPrimary)
                )
            }
            item {
                WgcDrogasilVaccineCard(
                    vaccineName = "Vacina Gripe Tetravalente",
                    targetAudience = "Adultos e Crianças a partir de 6 meses",
                    price = 79.90
                )
            }
            item {
                WgcDrogasilVaccineCard(
                    vaccineName = "Teste Rápido Dengue Igg/Igm",
                    targetAudience = "Resultado em até 15 minutos na farmácia",
                    price = 49.90,
                    nextAvailableSlot = "Disponível agora"
                )
            }
        }
    }
}
