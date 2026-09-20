package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.workspacedocs.*

enum class WgcWorkspaceDocsScreen {
    WORKSPACE,
    KANBAN,
    EDITOR,
    HISTORY,
    PROFILE
}

@Composable
fun WgcWorkspaceDocsFactory(
    screen: WgcWorkspaceDocsScreen = WgcWorkspaceDocsScreen.WORKSPACE,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcWorkspaceDocsScreen.WORKSPACE -> WgcNotionWorkspaceTemplate(modifier = modifier)
        WgcWorkspaceDocsScreen.KANBAN -> WgcNotionKanbanTemplate(modifier = modifier)
        WgcWorkspaceDocsScreen.EDITOR -> WgcNotionEditorTemplate(modifier = modifier)
        WgcWorkspaceDocsScreen.HISTORY -> WgcNotionHistoryTemplate(modifier = modifier)
        WgcWorkspaceDocsScreen.PROFILE -> WgcNotionProfileTemplate(modifier = modifier)
    }
}
