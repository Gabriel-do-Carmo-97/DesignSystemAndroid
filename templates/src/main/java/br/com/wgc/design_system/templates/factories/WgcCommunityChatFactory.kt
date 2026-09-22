package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.communitychat.*

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
        WgcCommunityChatScreen.SERVERS -> WgcCommunityChatServersTemplate(modifier = modifier)
        WgcCommunityChatScreen.VOICE -> WgcCommunityChatVoiceTemplate(modifier = modifier)
        WgcCommunityChatScreen.DIRECT -> WgcCommunityChatDirectTemplate(modifier = modifier)
        WgcCommunityChatScreen.EXPLORE -> WgcCommunityChatExploreTemplate(modifier = modifier)
        WgcCommunityChatScreen.PROFILE -> WgcCommunityChatProfileTemplate(modifier = modifier)
    }
}
