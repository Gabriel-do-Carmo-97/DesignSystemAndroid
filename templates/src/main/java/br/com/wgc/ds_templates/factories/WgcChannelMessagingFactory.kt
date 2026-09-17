package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.channelmessaging.*

enum class WgcChannelMessagingScreen {
    CHATS,
    SAVED,
    SECRET,
    FOLDERS,
    SETTINGS
}

@Composable
fun WgcChannelMessagingFactory(
    screen: WgcChannelMessagingScreen = WgcChannelMessagingScreen.CHATS,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcChannelMessagingScreen.CHATS -> WgcTelegramChatsTemplate(modifier = modifier)
        WgcChannelMessagingScreen.SAVED -> WgcTelegramSavedTemplate(modifier = modifier)
        WgcChannelMessagingScreen.SECRET -> WgcTelegramSecretTemplate(modifier = modifier)
        WgcChannelMessagingScreen.FOLDERS -> WgcTelegramFoldersTemplate(modifier = modifier)
        WgcChannelMessagingScreen.SETTINGS -> WgcTelegramSettingsTemplate(modifier = modifier)
    }
}
