package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.slack.*

enum class WgcSlackScreen {
    CHANNELS,
    THREADS,
    DIRECT,
    SEARCH,
    PROFILE
}

@Composable
fun WgcSlackFactory(
    screen: WgcSlackScreen = WgcSlackScreen.CHANNELS,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcSlackScreen.CHANNELS -> WgcSlackChannelsTemplate(modifier = modifier)
        WgcSlackScreen.THREADS -> WgcSlackThreadsTemplate(modifier = modifier)
        WgcSlackScreen.DIRECT -> WgcSlackDirectTemplate(modifier = modifier)
        WgcSlackScreen.SEARCH -> WgcSlackSearchTemplate(modifier = modifier)
        WgcSlackScreen.PROFILE -> WgcSlackProfileTemplate(modifier = modifier)
    }
}
