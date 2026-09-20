package br.com.wgc.design_system.templates.screens.homemarketplace

data class MadeiraProduct(val id: String, val title: String, val discount: String, val price: Double)

object MadeiraMadeiraMockData {
    val sampleProducts = listOf(
        MadeiraProduct("1", "Guarda-Roupa Casal 6 Portas com Espelho", "-35% OFF", 899.00),
        MadeiraProduct("2", "Conjunto de Mesa de Jantar 4 Cadeiras", "-20% OFF", 649.00)
    )
}
