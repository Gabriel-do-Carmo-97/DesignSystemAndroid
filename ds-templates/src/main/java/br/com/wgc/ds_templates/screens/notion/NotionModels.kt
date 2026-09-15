package br.com.wgc.ds_templates.screens.notion

data class NotionDoc(val id: String, val icon: String, val title: String, val workspace: String)

object NotionMockData {
    val sampleDocs = listOf(
        NotionDoc("1", "🚀", "Roadmap de Features Q4", "WGC Tech"),
        NotionDoc("2", "📐", "Guia de Tokens & Arquitetura", "Design System"),
        NotionDoc("3", "💡", "Ideias para Próximos Sprints", "Pessoal")
    )
}
