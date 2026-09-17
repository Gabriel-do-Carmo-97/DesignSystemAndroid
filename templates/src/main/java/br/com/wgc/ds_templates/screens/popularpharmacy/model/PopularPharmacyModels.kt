package br.com.wgc.ds_templates.screens.popularpharmacy.model

data class PagueMenosOffer(
    val id: String,
    val title: String,
    val brand: String,
    val price: Double,
    val discountPercent: Int
)

data class ClinicService(
    val id: String,
    val title: String,
    val desc: String,
    val price: Double,
    val duration: String
)

object PagueMenosMockData {
    val sampleOffers = listOf(
        PagueMenosOffer("1", "Shampoo Anticaspa Clear Men", "Clear", 22.90, 15),
        PagueMenosOffer("2", "Desodorante Rexona Clinical", "Rexona", 27.90, 20),
        PagueMenosOffer("3", "Fórmula Infantil Nan Confor 1", "Nestlé", 59.90, 10)
    )

    val clinicServices = listOf(
        ClinicService("1", "Aferição de Pressão + Bioimpedância", "Sala exclusiva climatizada", 0.0, "15 min"),
        ClinicService("2", "Aplicação de Injetáveis", "Com prescrição médica", 12.0, "10 min"),
        ClinicService("3", "Teste Rápido de Glicemia Capilar", "Resultado imediato", 9.90, "5 min")
    )
}
