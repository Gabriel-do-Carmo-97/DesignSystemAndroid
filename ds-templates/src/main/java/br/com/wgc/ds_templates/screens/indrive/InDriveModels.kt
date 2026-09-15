package br.com.wgc.ds_templates.screens.indrive

data class InDriveOffer(val id: String, val driverName: String, val carModel: String, val rating: Double, val distance: String, val proposedPrice: Double)

object InDriveMockData {
    val sampleOffers = listOf(
        InDriveOffer("1", "Marcos Silva", "Renault Sandero Prata", 4.92, "400m de distância", 22.00),
        InDriveOffer("2", "Eduardo Santos", "Volkswagen Polo Branco", 4.88, "700m de distância", 20.00),
        InDriveOffer("3", "Felipe Costa", "Fiat Argo Cinza", 4.95, "1.2km de distância", 19.00)
    )
}
