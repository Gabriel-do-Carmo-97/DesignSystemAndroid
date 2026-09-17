package br.com.wgc.ds_templates.screens.naturalbeauty

data class NaturalBeautyItem(val id: String, val name: String, val line: String, val refillAvailable: Boolean, val price: Double)

object NaturalBeautyMockData {
    val sampleProducts = listOf(
        NaturalBeautyItem("1", "Óleo Desodorante Corporal Ekos Castanha 200ml", "Beleza Natural Ekos", true, 89.90),
        NaturalBeautyItem("2", "Chronos Gel Creme Antissinais 30+ 40g", "Chronos", true, 134.90),
        NaturalBeautyItem("3", "Essencial Exclusivo Deo Parfum Masculino 100ml", "Essencial", false, 239.90)
    )
}
