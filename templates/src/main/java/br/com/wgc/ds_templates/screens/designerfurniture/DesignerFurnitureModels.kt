package br.com.wgc.ds_templates.screens.designerfurniture

data class TokStokItem(val id: String, val title: String, val room: String, val price: Double)

object TokStokMockData {
    val sampleItems = listOf(
        TokStokItem("1", "Poltrona Giratória Design Nórdico", "Sala de Estar", 899.90),
        TokStokItem("2", "Mesa de Cabeceira Madeira Maciça", "Quarto", 459.90)
    )
}
