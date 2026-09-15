package br.com.wgc.ds_templates.screens.riachuelo

data class RiachueloProduct(val id: String, val title: String, val department: String, val price: Double)

object RiachueloMockData {
    val sampleProducts = listOf(
        RiachueloProduct("1", "Jogo de Cama 4 Peças Casa Riachuelo", "Casa Riachuelo", 189.90),
        RiachueloProduct("2", "Blazer Alfaiataria Feminino", "Moda Feminina", 219.90)
    )
}
