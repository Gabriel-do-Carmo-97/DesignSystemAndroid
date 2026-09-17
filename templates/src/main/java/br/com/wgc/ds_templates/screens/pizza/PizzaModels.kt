package br.com.wgc.ds_templates.screens.pizza

data class PizzaPizza(val id: String, val name: String, val ingredients: String, val price: Double)
object PizzaMockData {
    val samplePizzas = listOf(
        PizzaPizza("1", "Calabresa Especial", "Molho de tomate artesanal, mussarela, calabresa e orégano", 54.90),
        PizzaPizza("2", "Quatro Queijos & Catupiry", "Mussarela, requeijão catupiry, provolone e parmesão", 62.90),
        PizzaPizza("3", "Pepperoni Clássico", "Fatias generosas de pepperoni e mussarela derretida", 59.90)
    )
}
