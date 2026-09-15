package br.com.wgc.ds_templates.screens.cdt

data class CdtVehicle(val plate: String, val model: String, val year: String, val licensingStatus: String)

object CdtMockData {
    val sampleVehicles = listOf(
        CdtVehicle("ABC1D23", "HONDA CIVIC TOURING", "2023/2024", "Licenciamento 2026 Pago")
    )
}
