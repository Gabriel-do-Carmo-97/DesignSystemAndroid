package br.com.wgc.ds_templates.screens.kabum

data class HardwareItem(
    val id: String,
    val name: String,
    val category: String,
    val price: Double,
    val ninjaDiscountPrice: Double,
    val tdpWatts: Int,
    val socket: String,
    val benchmarkScore: Int,
    val isInStock: Boolean = true
)

object KaBuMMockData {
    val sampleHardware = listOf(
        HardwareItem(
            id = "gpu_01",
            name = "Placa de Vídeo RTX 4070 Super 12GB GDDR6X",
            category = "Placa de Vídeo (GPU)",
            price = 4599.90,
            ninjaDiscountPrice = 3999.99,
            tdpWatts = 220,
            socket = "PCI-Express 4.0 16x",
            benchmarkScore = 21450
        ),
        HardwareItem(
            id = "cpu_01",
            name = "Processador AMD Ryzen 7 7800X3D 5.0GHz 8-Cores",
            category = "Processador (CPU)",
            price = 2899.90,
            ninjaDiscountPrice = 2499.00,
            tdpWatts = 120,
            socket = "Socket AM5",
            benchmarkScore = 34500
        ),
        HardwareItem(
            id = "mb_01",
            name = "Placa Mãe Asus ROG Strix B650-A Gaming Wi-Fi",
            category = "Placa Mãe",
            price = 1899.90,
            ninjaDiscountPrice = 1599.90,
            tdpWatts = 35,
            socket = "Socket AM5",
            benchmarkScore = 18000
        )
    )
}
