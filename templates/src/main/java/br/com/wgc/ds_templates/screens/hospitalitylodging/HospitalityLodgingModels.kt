package br.com.wgc.ds_templates.screens.hospitalitylodging

data class HospedagemStay(val id: String, val title: String, val location: String, val rating: Double, val pricePerNight: Double, val tag: String)

object HospitalityLodgingMockData {
    val sampleStays = listOf(
        HospedagemStay("1", "Chalé na Árvore com Vista para a Serra", "Campos do Jordão, Brasil", 4.98, 650.00, "Preferido dos Hóspedes"),
        HospedagemStay("2", "Loft Moderno à Beira-Mar", "Florianópolis, Brasil", 4.95, 480.00, "Vista Espetacular"),
        HospedagemStay("3", "Cabana A-Frame na Floresta", "Monte Verde, Brasil", 4.92, 590.00, "Novo")
    )
}
