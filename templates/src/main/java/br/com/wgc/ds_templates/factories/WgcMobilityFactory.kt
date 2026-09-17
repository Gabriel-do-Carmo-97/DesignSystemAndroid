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
import br.com.wgc.design_system.components.cards.WgcMobilityRideCard

enum class WgcMobilityScreen {
    URBAN,
    BIDDING,
    BUS
}

@Composable
fun WgcMobilityFactory(
    modifier: Modifier = Modifier,
    screen: WgcMobilityScreen = WgcMobilityScreen.URBAN
) {
    Scaffold(
        modifier = modifier.fillMaxSize()) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            item {
                WgcMobilityRideCard(
                    categoryName = "Pop Express",
                    estimatedTime = "3 min",
                    price = 18.50
                )
            }
            item {
                WgcMobilityRideCard(
                    categoryName = "Comfort Plus",
                    estimatedTime = "5 min",
                    price = 24.90
                )
            }
        }
    }
}
