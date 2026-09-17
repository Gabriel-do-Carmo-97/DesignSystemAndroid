package br.com.wgc.ds_templates.screens.trendapparel

data class TrendApparelProduct(val id: String, val title: String, val department: String, val price: Double)

object TrendApparelMockData {
    val sampleProducts = listOf(
        TrendApparelProduct("1", "Jogo de Cama 4 Peças Casa & Conforto", "Linha Casa Fashion", 189.90),
        TrendApparelProduct("2", "Blazer Alfaiataria Feminino", "Moda Feminina", 219.90)
    )
}
