package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.kanbantasks.*

enum class WgcKanbanTasksScreen {
    BOARD,
    CARD_DETAIL,
    CALENDAR,
    POWERUPS,
    PROFILE
}

@Composable
fun WgcKanbanTasksFactory(
    screen: WgcKanbanTasksScreen = WgcKanbanTasksScreen.BOARD,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcKanbanTasksScreen.BOARD -> WgcTrelloBoardTemplate(modifier = modifier)
        WgcKanbanTasksScreen.CARD_DETAIL -> WgcTrelloCardDetailTemplate(modifier = modifier)
        WgcKanbanTasksScreen.CALENDAR -> WgcTrelloCalendarTemplate(modifier = modifier)
        WgcKanbanTasksScreen.POWERUPS -> WgcTrelloPowerupsTemplate(modifier = modifier)
        WgcKanbanTasksScreen.PROFILE -> WgcTrelloProfileTemplate(modifier = modifier)
    }
}
