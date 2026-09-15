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
import br.com.wgc.design_system.components.cards.WgcNewsHeadlineCard

enum class WgcNewsScreen {
    G1,
    UOL,
    EXAME
}

@Composable
fun WgcNewsFactory(
    modifier: Modifier = Modifier,
    screen: WgcNewsScreen = WgcNewsScreen.G1
) {
    Scaffold(
        modifier = modifier.fillMaxSize()) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            item {
                WgcNewsHeadlineCard(
                    editoria = "Economia & Mercado",
                    headline = "Bolsa brasileira sobe com avanço da tecnologia e dados positivos do varejo",
                    publishedTime = "Há 12 minutos"
                )
            }
        }
    }
}
