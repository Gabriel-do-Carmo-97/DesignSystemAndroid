package br.com.wgc.ds_templates.screens.flamefastfood

data class BKMeal(val id: String, val name: String, val fireGrilled: Boolean, val price: Double)

object BurgerKingMockData {
    val sampleMenu = listOf(
        BKMeal("1", "Whopper Especial com Queijo", true, 36.90),
        BKMeal("2", "Mega Stacker Atômico 3.0", true, 49.90),
        BKMeal("3", "Balde de Batata Suprema", false, 24.90)
    )
}
