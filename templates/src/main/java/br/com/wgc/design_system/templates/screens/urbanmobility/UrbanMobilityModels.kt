package br.com.wgc.design_system.templates.screens.urbanmobility

data class UrbanMobilityRideOption(val id: String, val name: String, val eta: String, val price: Double, val discount: String? = null)
data class UrbanMobilityTripHistory(val id: String, val destination: String, val date: String, val price: Double, val driver: String)

object UrbanMobilityMockData {
    val sampleRides = listOf(
        UrbanMobilityRideOption("1", "Economy", "3 min", 22.50, "Cupom 10% aplicado"),
        UrbanMobilityRideOption("2", "Comfort (Carros Mais Espaçosos)", "5 min", 28.90),
        UrbanMobilityRideOption("3", "FastMoto (Rápido e Econômico)", "2 min", 13.40),
        UrbanMobilityRideOption("4", "PriorityTaxi (Faixa de Ônibus)", "4 min", 34.00)
    )
    val sampleHistory = listOf(
        UrbanMobilityTripHistory("1", "Av. Paulista, 1000", "Hoje, 09:20", 24.50, "Carlos - Veículo Prata"),
        UrbanMobilityTripHistory("2", "Aeroporto Central", "Ontem, 16:40", 52.80, "Renato - Veículo Preto"),
        UrbanMobilityTripHistory("3", "Shopping Morumbi", "11 Set", 19.90, "Lucas - Veículo Branco")
    )
}
