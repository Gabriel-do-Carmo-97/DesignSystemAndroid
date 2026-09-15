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
import br.com.wgc.design_system.components.cards.WgcStreamingMediaCard

enum class WgcStreamingScreen {
    NETFLIX,
    SPOTIFY,
    GLOBOPLAY
}

@Composable
fun WgcStreamingFactory(
    modifier: Modifier = Modifier,
    screen: WgcStreamingScreen = WgcStreamingScreen.SPOTIFY
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color(0xFF121212)
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            item {
                WgcStreamingMediaCard(
                    title = "As It Was",
                    artistOrCreator = "Harry Styles",
                    duration = "2:47"
                )
            }
            item {
                WgcStreamingMediaCard(
                    title = "Blinding Lights",
                    artistOrCreator = "The Weeknd",
                    duration = "3:20"
                )
            }
        }
    }
}
