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
import br.com.wgc.design_system.components.cards.WgcFashionItemCard

enum class WgcFashionScreen {
    RENNER,
    CEA,
    RIACHUELO
}

@Composable
fun WgcFashionFactory(
    modifier: Modifier = Modifier,
    screen: WgcFashionScreen = WgcFashionScreen.RENNER
) {
    Scaffold(
        modifier = modifier.fillMaxSize()) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            item {
                WgcFashionItemCard(
                    brandName = "Renner Jeans",
                    itemTitle = "Calça Jeans Wide Leg Cintura Alta",
                    price = 179.90,
                    installments = "4x de R$ 44,97 sem juros"
                )
            }
        }
    }
}
