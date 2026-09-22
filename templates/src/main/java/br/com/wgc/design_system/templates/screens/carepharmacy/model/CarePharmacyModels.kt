package br.com.wgc.design_system.templates.screens.carepharmacy.model

data class DrogasilOffer(
    val id: String,
    val title: String,
    val laboratory: String,
    val price: Double,
    val originalPrice: Double? = null,
    val discountTag: String
)

data class DrogasilVaccine(
    val id: String,
    val name: String,
    val audience: String,
    val price: Double,
    val slot: String
)

object CarePharmacyMockData {
    val sampleOffers = listOf(
        DrogasilOffer("1", "Protetor Solar Facial FPS 60", "La Roche-Posay Anthelios", 79.90, 99.90, "20% OFF"),
        DrogasilOffer("2", "Colágeno Hidrolisado Verisol", "Sanavita 30 Sachês", 89.90, 115.00, "22% OFF"),
        DrogasilOffer("3", "Fralda Descartável Confort Sec M", "Pampers 70 Unidades", 69.90, 84.90, "18% OFF")
    )

    val sampleVaccines = listOf(
        DrogasilVaccine("1", "Vacina Gripe Tetravalente", "Adultos e crianças", 79.90, "Hoje disponível"),
        DrogasilVaccine("2", "Vacina Herpes Zóster (Shingrix)", "Adultos acima de 50 anos", 780.00, "Agendamento aberto"),
        DrogasilVaccine("3", "Teste Rápido Dengue IgG/IgM", "Resultado em 15 minutos", 49.90, "Sem fila agora")
    )
}
