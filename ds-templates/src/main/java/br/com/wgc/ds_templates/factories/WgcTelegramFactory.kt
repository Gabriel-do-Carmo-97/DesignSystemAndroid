package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.telegram.*

enum class WgcTelegramScreen {
    CHATS,
    SAVED,
    SECRET,
    FOLDERS,
    SETTINGS
}

@Composable
fun WgcTelegramFactory(
    screen: WgcTelegramScreen = WgcTelegramScreen.CHATS,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcTelegramScreen.CHATS -> WgcTelegramChatsTemplate(modifier = modifier)
        WgcTelegramScreen.SAVED -> WgcTelegramSavedTemplate(modifier = modifier)
        WgcTelegramScreen.SECRET -> WgcTelegramSecretTemplate(modifier = modifier)
        WgcTelegramScreen.FOLDERS -> WgcTelegramFoldersTemplate(modifier = modifier)
        WgcTelegramScreen.SETTINGS -> WgcTelegramSettingsTemplate(modifier = modifier)
    }
}
