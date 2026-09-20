package br.com.wgc.design_system.templates.screens.medianetwork

data class UolNews(val id: String, val headline: String, val author: String)

object MediaNetworkMockData {
    val sampleNews = listOf(
        UolNews("1", "Dólar fecha em queda com apetite por mercados emergentes", "UOL Economia"),
        UolNews("2", "Rodada decisiva da Libertadores agita os gramados", "UOL Esporte")
    )
}
