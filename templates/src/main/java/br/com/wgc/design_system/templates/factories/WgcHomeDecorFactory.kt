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
import br.com.wgc.design_system.components.cards.WgcHomeImprovementCard

enum class WgcHomeDecorScreen {
    LEROY_MERLIN,
    TOK_STOK,
    MADEIRA_MADEIRA
}

@Composable
fun WgcHomeDecorFactory(
    modifier: Modifier = Modifier,
    screen: WgcHomeDecorScreen = WgcHomeDecorScreen.LEROY_MERLIN
) {
    Scaffold(
        modifier = modifier.fillMaxSize()) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            item {
                WgcHomeImprovementCard(
                    productName = "Pendente Moderno Industrial Preto Fosco",
                    department = "Iluminação & Lustres",
                    price = 149.90
                )
            }
        }
    }
}
