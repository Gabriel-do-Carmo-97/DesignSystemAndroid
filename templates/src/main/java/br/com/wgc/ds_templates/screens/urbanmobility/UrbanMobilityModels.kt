package br.com.wgc.ds_templates.screens.urbanmobility

data class NoveNoveRideOption(val id: String, val name: String, val eta: String, val price: Double, val discount: String? = null)
data class NoveNoveTripHistory(val id: String, val destination: String, val date: String, val price: Double, val driver: String)

object NoveNoveMockData {
    val sampleRides = listOf(
        NoveNoveRideOption("1", "99Pop", "3 min", 22.50, "Cupom 10% aplicado"),
        NoveNoveRideOption("2", "99Plus (Carros Mais Espaçosos)", "5 min", 28.90),
        NoveNoveRideOption("3", "99Moto (Rápido e Econômico)", "2 min", 13.40),
        NoveNoveRideOption("4", "99Taxi (Faixa de Ônibus)", "4 min", 34.00)
    )
    val sampleHistory = listOf(
        NoveNoveTripHistory("1", "Av. Paulista, 1000", "Hoje, 09:20", 24.50, "Carlos - Honda Civic"),
        NoveNoveTripHistory("2", "Aeroporto de Congonhas", "Ontem, 16:40", 52.80, "Renato - Toyota Corolla"),
        NoveNoveTripHistory("3", "Shopping Morumbi", "11 Set", 19.90, "Lucas - Chevrolet Onix")
    )
}
