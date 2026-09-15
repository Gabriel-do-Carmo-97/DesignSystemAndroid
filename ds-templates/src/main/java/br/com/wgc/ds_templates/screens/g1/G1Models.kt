package br.com.wgc.ds_templates.screens.g1

data class G1NewsItem(val id: String, val headline: String, val section: String, val publishedAgo: String)

object G1MockData {
    val sampleNews = listOf(
        G1NewsItem("1", "Banco Central mantém taxa Selic e sinaliza cortes futuros", "Economia", "Há 15 minutos"),
        G1NewsItem("2", "Novo telescópio espacial revela galáxia com atmosfera similar à Terra", "Ciência & Tecnologia", "Há 40 minutos"),
        G1NewsItem("3", "Fato ou Boato: Mensagens falsas sobre impostos em pagamentos Pix", "Fato ou Boato", "Há 1 hora")
    )
}
