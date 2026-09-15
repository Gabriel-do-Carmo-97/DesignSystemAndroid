package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.whatsapp.*

enum class WgcWhatsAppScreen {
    CHATS,
    STATUS,
    CALLS,
    COMMUNITIES,
    SETTINGS
}

@Composable
fun WgcWhatsAppFactory(
    screen: WgcWhatsAppScreen = WgcWhatsAppScreen.CHATS,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcWhatsAppScreen.CHATS -> WgcWhatsAppChatsTemplate(modifier = modifier)
        WgcWhatsAppScreen.STATUS -> WgcWhatsAppStatusTemplate(modifier = modifier)
        WgcWhatsAppScreen.CALLS -> WgcWhatsAppCallsTemplate(modifier = modifier)
        WgcWhatsAppScreen.COMMUNITIES -> WgcWhatsAppCommunitiesTemplate(modifier = modifier)
        WgcWhatsAppScreen.SETTINGS -> WgcWhatsAppSettingsTemplate(modifier = modifier)
    }
}
