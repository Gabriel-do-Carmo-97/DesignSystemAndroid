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
import br.com.wgc.design_system.components.cards.WgcInterSuperAppCard

enum class WgcInterScreen {
    HOME,
    SHOP,
    INVEST
}

@Composable
fun WgcInterFactory(
    modifier: Modifier = Modifier,
    screen: WgcInterScreen = WgcInterScreen.HOME
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color(WgcCoreDsColors.interBackground)
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            item {
                WgcInterSuperAppCard(
                    partnerStore = "Magalu",
                    cashbackPercentage = 8,
                    offerTitle = "Eletrônicos & Informática"
                )
            }
            item {
                WgcInterSuperAppCard(
                    partnerStore = "Amazon Brasil",
                    cashbackPercentage = 5,
                    offerTitle = "Livros, Kindles e Casa"
                )
            }
        }
    }
}
