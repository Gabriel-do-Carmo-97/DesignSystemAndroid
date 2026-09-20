package br.com.wgc.design_system.templates.screens.petsuperstore

data class CobasiItem(val id: String, val title: String, val category: String, val price: Double)

object PetSuperstoreMockData {
    val sampleItems = listOf(
        CobasiItem("1", "Tapete Higiênico Chalesco 30 Unidades", "Higiene Pet", 89.90),
        CobasiItem("2", "Fonte de Água Bivolt para Gatos", "Bebedouro", 129.90)
    )
}
