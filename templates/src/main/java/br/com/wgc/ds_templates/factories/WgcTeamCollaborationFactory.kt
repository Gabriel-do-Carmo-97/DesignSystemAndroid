package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.teamcollaboration.*

enum class WgcTeamCollaborationScreen {
    CHANNELS,
    THREADS,
    DIRECT,
    SEARCH,
    PROFILE
}

@Composable
fun WgcTeamCollaborationFactory(
    screen: WgcTeamCollaborationScreen = WgcTeamCollaborationScreen.CHANNELS,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcTeamCollaborationScreen.CHANNELS -> WgcSlackChannelsTemplate(modifier = modifier)
        WgcTeamCollaborationScreen.THREADS -> WgcSlackThreadsTemplate(modifier = modifier)
        WgcTeamCollaborationScreen.DIRECT -> WgcSlackDirectTemplate(modifier = modifier)
        WgcTeamCollaborationScreen.SEARCH -> WgcSlackSearchTemplate(modifier = modifier)
        WgcTeamCollaborationScreen.PROFILE -> WgcSlackProfileTemplate(modifier = modifier)
    }
}
