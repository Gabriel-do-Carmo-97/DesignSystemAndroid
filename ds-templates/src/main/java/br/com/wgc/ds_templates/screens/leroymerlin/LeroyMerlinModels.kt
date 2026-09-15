package br.com.wgc.ds_templates.screens.leroymerlin

data class LeroyItem(val id: String, val title: String, val department: String, val price: Double)

object LeroyMerlinMockData {
    val sampleItems = listOf(
        LeroyItem("1", "Piso Porcelanato Polido 84x84cm", "Pisos & Revestimentos", 79.90),
        LeroyItem("2", "Torneira Monocomando Gourmet Escovada", "Cozinha & Torneiras", 249.90)
    )
}
