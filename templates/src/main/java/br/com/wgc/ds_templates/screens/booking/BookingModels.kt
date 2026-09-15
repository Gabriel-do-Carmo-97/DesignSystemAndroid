package br.com.wgc.ds_templates.screens.booking

data class BookingHotel(val id: String, val name: String, val city: String, val score: Double, val reviewsCount: Int, val geniusDiscount: String, val price: Double)

object BookingMockData {
    val sampleHotels = listOf(
        BookingHotel("1", "Grand Mercure Ibirapuera", "São Paulo", 8.8, 1420, "Genius Nível 2 (15% OFF)", 540.00),
        BookingHotel("2", "Copacabana Palace A Belmond Hotel", "Rio de Janeiro", 9.5, 980, "Café da Manhã Grátis", 2400.00),
        BookingHotel("3", "Fasano Salvador", "Salvador", 9.2, 650, "Upgrade Grátis", 1850.00)
    )
}
