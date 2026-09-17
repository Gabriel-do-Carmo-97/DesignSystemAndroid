package br.com.wgc.ds_templates.screens.kanbantasks

data class TrelloCard(val id: String, val title: String, val list: String, val checklistCount: String)

object KanbanTasksMockData {
    val sampleCards = listOf(
        TrelloCard("1", "Ajustar Contrastes de Acessibilidade", "A Fazer", "3/4 concluído"),
        TrelloCard("2", "Escrever Testes de Screenshot CI", "Em Andamento", "1/2 concluído"),
        TrelloCard("3", "Publicação de Release 2.5.0", "Concluído", "5/5 concluído")
    )
}
