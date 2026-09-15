package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.discord.*

enum class WgcDiscordScreen {
    SERVERS,
    VOICE,
    DIRECT,
    EXPLORE,
    PROFILE
}

@Composable
fun WgcDiscordFactory(
    screen: WgcDiscordScreen = WgcDiscordScreen.SERVERS,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcDiscordScreen.SERVERS -> WgcDiscordServersTemplate(modifier = modifier)
        WgcDiscordScreen.VOICE -> WgcDiscordVoiceTemplate(modifier = modifier)
        WgcDiscordScreen.DIRECT -> WgcDiscordDirectTemplate(modifier = modifier)
        WgcDiscordScreen.EXPLORE -> WgcDiscordExploreTemplate(modifier = modifier)
        WgcDiscordScreen.PROFILE -> WgcDiscordProfileTemplate(modifier = modifier)
    }
}
