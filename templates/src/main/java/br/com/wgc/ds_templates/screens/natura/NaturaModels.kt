package br.com.wgc.ds_templates.screens.natura

data class NaturaItem(val id: String, val name: String, val line: String, val refillAvailable: Boolean, val price: Double)

object NaturaMockData {
    val sampleProducts = listOf(
        NaturaItem("1", "Óleo Desodorante Corporal Ekos Castanha 200ml", "Natura Ekos", true, 89.90),
        NaturaItem("2", "Chronos Gel Creme Antissinais 30+ 40g", "Chronos", true, 134.90),
        NaturaItem("3", "Essencial Exclusivo Deo Parfum Masculino 100ml", "Essencial", false, 239.90)
    )
}
