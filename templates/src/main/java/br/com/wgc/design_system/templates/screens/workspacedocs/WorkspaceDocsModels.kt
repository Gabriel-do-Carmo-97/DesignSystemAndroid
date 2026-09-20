package br.com.wgc.design_system.templates.screens.workspacedocs

data class NotionDoc(val id: String, val icon: String, val title: String, val workspace: String)

object WorkspaceDocsMockData {
    val sampleDocs = listOf(
        NotionDoc("1", "🚀", "Roadmap de Features Q4", "WGC Tech"),
        NotionDoc("2", "📐", "Guia de Tokens & Arquitetura", "Design System"),
        NotionDoc("3", "💡", "Ideias para Próximos Sprints", "Pessoal")
    )
}
