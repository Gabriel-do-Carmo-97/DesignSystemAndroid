package br.com.wgc.ds_templates.screens.cea

data class CeaLook(val id: String, val title: String, val collection: String, val price: Double)

object CeaMockData {
    val sampleLooks = listOf(
        CeaLook("1", "Vestido Midi Floral", "Primavera C&A", 139.90),
        CeaLook("2", "Camisa Linho Conforto", "Masculino Casual", 119.90)
    )
}
