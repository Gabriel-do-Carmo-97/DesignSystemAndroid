package br.com.wgc.ds_templates.screens.netflix

data class NetflixTitle(val id: String, val title: String, val matchPercentage: String, val maturity: String, val genre: String)

object NetflixMockData {
    val sampleTop10 = listOf(
        NetflixTitle("1", "Stranger Things 5", "98% relevante", "16+", "Ficção Científica, Suspense"),
        NetflixTitle("2", "Round 6 • Temporada 2", "95% relevante", "18+", "Drama, Suspense"),
        NetflixTitle("3", "O Gambito da Rainha", "92% relevante", "16+", "Drama")
    )
}
