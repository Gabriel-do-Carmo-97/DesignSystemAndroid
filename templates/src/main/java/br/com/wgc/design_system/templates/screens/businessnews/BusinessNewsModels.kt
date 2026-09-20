package br.com.wgc.design_system.templates.screens.businessnews

data class ExameArticle(val id: String, val title: String, val category: String)

object BusinessNewsMockData {
    val sampleArticles = listOf(
        ExameArticle("1", "As 10 empresas que mais valorizaram no Ibovespa neste ano", "Mercados"),
        ExameArticle("2", "Inteligência Artificial revoluciona produtividade no setor financeiro", "Inovação")
    )
}
