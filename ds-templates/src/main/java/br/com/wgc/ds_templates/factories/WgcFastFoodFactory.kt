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
import br.com.wgc.design_system.components.cards.WgcFastFoodMealCard

enum class WgcFastFoodScreen {
    MCDONALDS,
    BURGER_KING,
    DOMINOS
}

@Composable
fun WgcFastFoodFactory(
    modifier: Modifier = Modifier,
    screen: WgcFastFoodScreen = WgcFastFoodScreen.MCDONALDS
) {
    Scaffold(
        modifier = modifier.fillMaxSize()) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            item {
                WgcFastFoodMealCard(
                    comboName = "McOferta Média Big Mac",
                    description = "Dois hambúrgueres, alface, queijo, molho especial, cebola e picles",
                    price = 36.90
                )
            }
        }
    }
}
