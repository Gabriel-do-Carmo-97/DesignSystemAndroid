package br.com.wgc.ds_templates.screens.boticario

data class BoticarioProduct(val id: String, val name: String, val line: String, val price: Double)

object BoticarioMockData {
    val sampleProducts = listOf(
        BoticarioProduct("1", "Malbec Desodorante Colônia 100ml", "Malbec", 199.90),
        BoticarioProduct("2", "Lily Eau de Parfum 75ml", "Lily", 279.90),
        BoticarioProduct("3", "Nativa SPA Ameixa Loção Hidratante 400ml", "Nativa SPA", 74.90)
    )
}
