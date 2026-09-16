package br.com.wgc.ds_templates.screens.beveragedelivery

data class BeverageItem(
    val id: String,
    val name: String,
    val brand: String,
    val volume: String,
    val temperatureStatus: String,
    val price: Double,
    val returnableBottle: Boolean = false
)

data class DeliveryPartnerDistributor(
    val name: String,
    val distanceKm: Double,
    val estimatedMinutes: Int,
    val rating: Double,
    val isOpenNow: Boolean
)

object BeverageDeliveryMockData {
    val sampleBeverages = listOf(
        BeverageItem("bev_1", "Cerveja Brahma Chopp Lata 350ml (Pack c/ 12)", "Brahma", "12x 350ml", "Estupidamente Gelada", 42.90, false),
        BeverageItem("bev_2", "Cerveja Corona Extra Long Neck 330ml", "Corona", "330ml", "Gelada", 7.49, false),
        BeverageItem("bev_3", "Cerveja Spaten Puro Malte Garrafa Retornável 600ml", "Spaten", "600ml", "Gelada", 8.29, true),
        BeverageItem("bev_4", "Gelo Filtrado em Cubos 5kg", "Gelo Nobre", "5kg", "Congelado", 14.90, false),
        BeverageItem("bev_5", "Refrigerante Coca-Cola Sem Açúcar 2L", "Coca-Cola", "2L", "Gelada", 9.99, false)
    )

    val sampleDistributor = DeliveryPartnerDistributor(
        name = "Distribuidora do Zé - Perdizes",
        distanceKm = 1.4,
        estimatedMinutes = 25,
        rating = 4.9,
        isOpenNow = true
    )
}
