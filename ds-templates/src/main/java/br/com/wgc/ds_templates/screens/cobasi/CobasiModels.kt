package br.com.wgc.ds_templates.screens.cobasi

data class CobasiItem(val id: String, val title: String, val category: String, val price: Double)

object CobasiMockData {
    val sampleItems = listOf(
        CobasiItem("1", "Tapete Higiênico Chalesco 30 Unidades", "Higiene Pet", 89.90),
        CobasiItem("2", "Fonte de Água Bivolt para Gatos", "Bebedouro", 129.90)
    )
}
