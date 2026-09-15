package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.notion.*

enum class WgcNotionScreen {
    WORKSPACE,
    KANBAN,
    EDITOR,
    HISTORY,
    PROFILE
}

@Composable
fun WgcNotionFactory(
    screen: WgcNotionScreen = WgcNotionScreen.WORKSPACE,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcNotionScreen.WORKSPACE -> WgcNotionWorkspaceTemplate(modifier = modifier)
        WgcNotionScreen.KANBAN -> WgcNotionKanbanTemplate(modifier = modifier)
        WgcNotionScreen.EDITOR -> WgcNotionEditorTemplate(modifier = modifier)
        WgcNotionScreen.HISTORY -> WgcNotionHistoryTemplate(modifier = modifier)
        WgcNotionScreen.PROFILE -> WgcNotionProfileTemplate(modifier = modifier)
    }
}
