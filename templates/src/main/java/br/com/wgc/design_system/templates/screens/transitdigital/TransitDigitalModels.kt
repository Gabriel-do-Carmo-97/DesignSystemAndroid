package br.com.wgc.design_system.templates.screens.transitdigital

data class CdtVehicle(val plate: String, val model: String, val year: String, val licensingStatus: String)

object TransitDigitalMockData {
    val sampleVehicles = listOf(
        CdtVehicle("ABC1D23", "HONDA CIVIC TOURING", "2023/2024", "Licenciamento 2026 Pago")
    )
}
