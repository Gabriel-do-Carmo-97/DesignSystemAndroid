package br.com.wgc.ds_templates.screens.dominos

data class DominoPizza(val id: String, val name: String, val ingredients: String, val price: Double)

object DominosMockData {
    val samplePizzas = listOf(
        DominosPizza("1", "Calabresa Especial", "Molho de tomate artesanal, mussarela, calabresa e orégano", 54.90),
        DominosPizza("2", "Quatro Queijos & Catupiry", "Mussarela, requeijão catupiry, provolone e parmesão", 62.90),
        DominosPizza("3", "Pepperoni Clássico", "Fatias generosas de pepperoni e mussarela derretida", 59.90)
    )
}
