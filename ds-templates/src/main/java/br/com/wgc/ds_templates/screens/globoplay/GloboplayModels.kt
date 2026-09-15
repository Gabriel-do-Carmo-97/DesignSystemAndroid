package br.com.wgc.ds_templates.screens.globoplay

data class GloboplayContent(val id: String, val title: String, val category: String, val channel: String)

object GloboplayMockData {
    val sampleContent = listOf(
        GloboplayContent("1", "Renascer", "Novela das 9", "TV Globo"),
        GloboplayContent("2", "Os Outros", "Série Original Globoplay", "Globoplay Exclusivo"),
        GloboplayContent("3", "Brasileirão Série A", "Futebol ao Vivo", "Premiere")
    )
}
