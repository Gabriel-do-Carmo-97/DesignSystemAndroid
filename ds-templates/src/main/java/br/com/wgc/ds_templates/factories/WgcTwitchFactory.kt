package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.twitch.*

enum class WgcTwitchScreen {
    LIVE,
    BROWSE,
    CHAT,
    SUBS,
    PROFILE
}

@Composable
fun WgcTwitchFactory(
    screen: WgcTwitchScreen = WgcTwitchScreen.LIVE,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcTwitchScreen.LIVE -> WgcTwitchLiveTemplate(modifier = modifier)
        WgcTwitchScreen.BROWSE -> WgcTwitchBrowseTemplate(modifier = modifier)
        WgcTwitchScreen.CHAT -> WgcTwitchChatTemplate(modifier = modifier)
        WgcTwitchScreen.SUBS -> WgcTwitchSubsTemplate(modifier = modifier)
        WgcTwitchScreen.PROFILE -> WgcTwitchProfileTemplate(modifier = modifier)
    }
}
