package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.broadcaststreaming.*

enum class WgcBroadcastStreamingScreen {
    HOME,
    LIVE,
    NOVELAS,
    CHANNELS,
    PROFILE
}

@Composable
fun WgcBroadcastStreamingFactory(
    screen: WgcBroadcastStreamingScreen = WgcBroadcastStreamingScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcBroadcastStreamingScreen.HOME -> WgcGloboplayHomeTemplate(modifier = modifier)
        WgcBroadcastStreamingScreen.LIVE -> WgcGloboplayLiveTemplate(modifier = modifier)
        WgcBroadcastStreamingScreen.NOVELAS -> WgcGloboplayNovelasTemplate(modifier = modifier)
        WgcBroadcastStreamingScreen.CHANNELS -> WgcGloboplayChannelsTemplate(modifier = modifier)
        WgcBroadcastStreamingScreen.PROFILE -> WgcGloboplayProfileTemplate(modifier = modifier)
    }
}
