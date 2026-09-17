package br.com.wgc.ds_templates.screens.videostreaming

data class VideoStreamTitle(val id: String, val title: String, val matchPercentage: String, val maturity: String, val genre: String)

object VideoStreamMockData {
    val sampleTop10 = listOf(
        VideoStreamTitle("1", "Stranger Things 5", "98% relevante", "16+", "Ficção Científica, Suspense"),
        VideoStreamTitle("2", "Round 6 • Temporada 2", "95% relevante", "18+", "Drama, Suspense"),
        VideoStreamTitle("3", "O Gambito da Rainha", "92% relevante", "16+", "Drama")
    )
}
