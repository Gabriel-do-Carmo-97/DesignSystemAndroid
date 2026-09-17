package br.com.wgc.ds_templates.factories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcTravelStayCard

enum class WgcTravelScreen {
    FLIGHT,
    LODGING,
    HOTEL
}

@Composable
fun WgcTravelFactory(
    modifier: Modifier = Modifier,
    screen: WgcTravelScreen = WgcTravelScreen.LODGING
) {
    Scaffold(
        modifier = modifier.fillMaxSize()) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            item {
                WgcTravelStayCard(
                    title = "Loft Design com Vista para o Mar",
                    location = "Ipanema, Rio de Janeiro",
                    rating = 4.98,
                    nightPrice = 350.0
                )
            }
            item {
                WgcTravelStayCard(
                    title = "Chalé Aconchegante na Serra",
                    location = "Campos do Jordão, SP",
                    rating = 4.92,
                    nightPrice = 420.0
                )
            }
        }
    }
}
