package br.com.wgc.design_system.templates.screens.carpooling

data class CarpoolRide(val id: String, val driver: String, val origin: String, val destination: String, val departureTime: String, val price: Double)

object CarpoolingMockData {
    val sampleRides = listOf(
        CarpoolRide("1", "Rodrigo M.", "Campinas", "São Paulo (Metrô Barra Funda)", "08:00", 25.00),
        CarpoolRide("2", "Beatriz P.", "São José dos Campos", "São Paulo", "09:30", 30.00),
        CarpoolRide("3", "Lucas T.", "Santos", "São Paulo", "14:00", 28.00)
    )
}
