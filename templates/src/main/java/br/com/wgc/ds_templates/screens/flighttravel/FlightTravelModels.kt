package br.com.wgc.ds_templates.screens.flighttravel

data class DecolarPackage(val id: String, val destination: String, val nights: Int, val flightIncluded: Boolean, val price: Double)

object FlightTravelMockData {
    val samplePackages = listOf(
        DecolarPackage("1", "Gramado & Canela", 4, true, 1450.00),
        DecolarPackage("2", "Porto de Galinhas Resort", 7, true, 2890.00),
        DecolarPackage("3", "Buenos Aires Gourmet", 5, true, 2100.00)
    )
}
