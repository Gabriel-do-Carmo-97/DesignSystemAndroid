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
import br.com.wgc.design_system.components.cards.WgcBeautyCosmeticCard

enum class WgcBeautyScreen {
    BOTICARIO,
    NATURA,
    SEPHORA
}

@Composable
fun WgcBeautyFactory(
    modifier: Modifier = Modifier,
    screen: WgcBeautyScreen = WgcBeautyScreen.BOTICARIO
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color(0xFFF7F8FA)
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            item {
                WgcBeautyCosmeticCard(
                    perfumeOrBrand = "O Boticário",
                    productName = "Lily Eau de Parfum",
                    volume = "75ml",
                    price = 289.90
                )
            }
        }
    }
}
