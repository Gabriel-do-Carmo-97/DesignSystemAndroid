package br.com.wgc.design_system.templates.factories

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
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcGameStoreCard

enum class WgcGamesScreen {
    STORE,
    LIVE,
    COMMUNITY
}

@Composable
fun WgcGamesFactory(
    modifier: Modifier = Modifier,
    screen: WgcGamesScreen = WgcGamesScreen.STORE
) {
    Scaffold(
        modifier = modifier.fillMaxSize()) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            item {
                WgcGameStoreCard(
                    gameTitle = "Elden Ring: Shadow of the Erdtree",
                    genre = "RPG de Ação",
                    price = 199.90,
                    discountPercentage = 20
                )
            }
        }
    }
}
