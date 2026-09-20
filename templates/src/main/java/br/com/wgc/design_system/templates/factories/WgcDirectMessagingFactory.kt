package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.directmessaging.*

enum class WgcDirectMessagingScreen {
    CHATS,
    STATUS,
    CALLS,
    COMMUNITIES,
    SETTINGS
}

@Composable
fun WgcDirectMessagingFactory(
    screen: WgcDirectMessagingScreen = WgcDirectMessagingScreen.CHATS,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcDirectMessagingScreen.CHATS -> WgcWhatsAppChatsTemplate(modifier = modifier)
        WgcDirectMessagingScreen.STATUS -> WgcWhatsAppStatusTemplate(modifier = modifier)
        WgcDirectMessagingScreen.CALLS -> WgcWhatsAppCallsTemplate(modifier = modifier)
        WgcDirectMessagingScreen.COMMUNITIES -> WgcWhatsAppCommunitiesTemplate(modifier = modifier)
        WgcDirectMessagingScreen.SETTINGS -> WgcWhatsAppSettingsTemplate(modifier = modifier)
    }
}
