package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.livestreaming.*

enum class WgcLiveStreamingScreen {
    LIVE,
    BROWSE,
    CHAT,
    SUBS,
    PROFILE
}

@Composable
fun WgcLiveStreamingFactory(
    screen: WgcLiveStreamingScreen = WgcLiveStreamingScreen.LIVE,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcLiveStreamingScreen.LIVE -> WgcTwitchLiveTemplate(modifier = modifier)
        WgcLiveStreamingScreen.BROWSE -> WgcTwitchBrowseTemplate(modifier = modifier)
        WgcLiveStreamingScreen.CHAT -> WgcTwitchChatTemplate(modifier = modifier)
        WgcLiveStreamingScreen.SUBS -> WgcTwitchSubsTemplate(modifier = modifier)
        WgcLiveStreamingScreen.PROFILE -> WgcTwitchProfileTemplate(modifier = modifier)
    }
}
