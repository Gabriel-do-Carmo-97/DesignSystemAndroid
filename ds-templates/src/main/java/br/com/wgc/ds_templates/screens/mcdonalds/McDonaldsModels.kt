package br.com.wgc.ds_templates.screens.mcdonalds

data class McItem(val id: String, val name: String, val points: Int, val price: Double)

object McDonaldsMockData {
    val sampleMenu = listOf(
        McItem("1", "Big Mac Combo Médio", 4000, 38.90),
        McItem("2", "Quarteirão com Queijo", 3200, 32.50),
        McItem("3", "McFlurry Ovomaltine", 1800, 16.90)
    )
}
