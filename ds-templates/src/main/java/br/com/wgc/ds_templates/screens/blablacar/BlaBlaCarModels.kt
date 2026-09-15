package br.com.wgc.ds_templates.screens.blablacar

data class BlaBlaRide(val id: String, val driver: String, val origin: String, val destination: String, val departureTime: String, val price: Double)

object BlaBlaCarMockData {
    val sampleRides = listOf(
        BlaBlaRide("1", "Rodrigo M.", "Campinas", "São Paulo (Metrô Barra Funda)", "08:00", 25.00),
        BlaBlaRide("2", "Beatriz P.", "São José dos Campos", "São Paulo", "09:30", 30.00),
        BlaBlaRide("3", "Lucas T.", "Santos", "São Paulo", "14:00", 28.00)
    )
}
