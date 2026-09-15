package br.com.wgc.ds_templates.screens.webmotors

data class VehicleItem(
    val id: String,
    val makeModel: String,
    val version: String,
    val yearModel: String,
    val mileageKm: Int,
    val price: Double,
    val fipePrice: Double,
    val cityState: String,
    val certifiedReportApproved: Boolean = true,
    val isArmored: Boolean = false
)

object WebmotorsMockData {
    val sampleVehicles = listOf(
        VehicleItem(
            id = "car_1",
            makeModel = "Honda Civic",
            version = "2.0 16V Gasolina Touring 4P CVT",
            yearModel = "2024/2024",
            mileageKm = 14500,
            price = 189900.00,
            fipePrice = 195400.00,
            cityState = "São Paulo - SP",
            certifiedReportApproved = true,
            isArmored = false
        ),
        VehicleItem(
            id = "car_2",
            makeModel = "Jeep Compass",
            version = "1.3 T270 Turbo Flex Longitude AT6",
            yearModel = "2023/2024",
            mileageKm = 28000,
            price = 149900.00,
            fipePrice = 153000.00,
            cityState = "Campinas - SP",
            certifiedReportApproved = true,
            isArmored = true
        ),
        VehicleItem(
            id = "car_3",
            makeModel = "Toyota Corolla",
            version = "1.8 VVT-i Híbrido Altis Premium CVT",
            yearModel = "2024/2025",
            mileageKm = 8200,
            price = 178000.00,
            fipePrice = 182500.00,
            cityState = "Curitiba - PR",
            certifiedReportApproved = true,
            isArmored = false
        )
    )
}
