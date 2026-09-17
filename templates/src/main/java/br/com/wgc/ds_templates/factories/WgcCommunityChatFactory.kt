package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.communitychat.*

enum class WgcCommunityChatScreen {
    SERVERS,
    VOICE,
    DIRECT,
    EXPLORE,
    PROFILE
}

@Composable
fun WgcCommunityChatFactory(
    screen: WgcCommunityChatScreen = WgcCommunityChatScreen.SERVERS,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcCommunityChatScreen.SERVERS -> WgcDiscordServersTemplate(modifier = modifier)
        WgcCommunityChatScreen.VOICE -> WgcDiscordVoiceTemplate(modifier = modifier)
        WgcCommunityChatScreen.DIRECT -> WgcDiscordDirectTemplate(modifier = modifier)
        WgcCommunityChatScreen.EXPLORE -> WgcDiscordExploreTemplate(modifier = modifier)
        WgcCommunityChatScreen.PROFILE -> WgcDiscordProfileTemplate(modifier = modifier)
    }
}
