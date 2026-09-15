package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.trello.*

enum class WgcTrelloScreen {
    BOARD,
    CARD_DETAIL,
    CALENDAR,
    POWERUPS,
    PROFILE
}

@Composable
fun WgcTrelloFactory(
    screen: WgcTrelloScreen = WgcTrelloScreen.BOARD,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcTrelloScreen.BOARD -> WgcTrelloBoardTemplate(modifier = modifier)
        WgcTrelloScreen.CARD_DETAIL -> WgcTrelloCardDetailTemplate(modifier = modifier)
        WgcTrelloScreen.CALENDAR -> WgcTrelloCalendarTemplate(modifier = modifier)
        WgcTrelloScreen.POWERUPS -> WgcTrelloPowerupsTemplate(modifier = modifier)
        WgcTrelloScreen.PROFILE -> WgcTrelloProfileTemplate(modifier = modifier)
    }
}
