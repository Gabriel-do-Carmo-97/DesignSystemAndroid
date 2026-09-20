package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.livestreaming.*

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
        WgcLiveStreamingScreen.LIVE -> WgcLiveStreamingLiveTemplate(modifier = modifier)
        WgcLiveStreamingScreen.BROWSE -> WgcLiveStreamingBrowseTemplate(modifier = modifier)
        WgcLiveStreamingScreen.CHAT -> WgcLiveStreamingChatTemplate(modifier = modifier)
        WgcLiveStreamingScreen.SUBS -> WgcLiveStreamingSubsTemplate(modifier = modifier)
        WgcLiveStreamingScreen.PROFILE -> WgcLiveStreamingProfileTemplate(modifier = modifier)
    }
}
