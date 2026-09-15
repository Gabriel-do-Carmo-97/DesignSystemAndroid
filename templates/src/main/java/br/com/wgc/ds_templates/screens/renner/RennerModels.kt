package br.com.wgc.ds_templates.screens.renner

data class RennerItem(val id: String, val title: String, val category: String, val price: Double)

object RennerMockData {
    val sampleProducts = listOf(
        RennerItem("1", "Jaqueta Puffer Corta-Vento", "Casacos", 199.90),
        RennerItem("2", "Calça Jeans Wide Leg", "Jeans", 159.90),
        RennerItem("3", "Camiseta Básica 100% Algodão Pima", "Básicos", 79.90)
    )
}
