package br.com.wgc.ds_templates.screens.clickbus

data class ClickBusTrip(val id: String, val company: String, val departureTime: String, val arrivalTime: String, val seatType: String, val price: Double)

object ClickBusMockData {
    val sampleTrips = listOf(
        ClickBusTrip("1", "Viação Cometa", "07:30", "13:30", "Leito Cama", 189.90),
        ClickBusTrip("2", "Auto Viação 1001", "09:00", "15:00", "Semi-Leito", 129.50),
        ClickBusTrip("3", "Expresso do Sul", "11:15", "17:15", "Executivo", 99.00)
    )
}
