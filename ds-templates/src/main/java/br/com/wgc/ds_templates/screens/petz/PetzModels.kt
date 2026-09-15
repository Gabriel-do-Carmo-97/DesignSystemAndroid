package br.com.wgc.ds_templates.screens.petz

data class PetzProduct(val id: String, val title: String, val category: String, val price: Double, val subscriptionPrice: Double)

object PetzMockData {
    val sampleProducts = listOf(
        PetzProduct("1", "Ração Royal Canin Golden Retriever Adulto 15kg", "Cães", 389.90, 350.91),
        PetzProduct("2", "Antipulgas NexGard Spectra 15 a 30kg", "Farmácia Pet", 149.90, 134.91),
        PetzProduct("3", "Arranhador para Gatos com Torre 3 Andares", "Gatos", 219.90, 197.91)
    )
}
