package br.com.wgc.ds_templates.screens.lalamove

data class LalamoveVehicle(val id: String, val type: String, val capacityKg: Int, val basePrice: Double)

object LalamoveMockData {
    val sampleVehicles = listOf(
        LalamoveVehicle("1", "Moto (Documentos e Caixas Pequenas)", 20, 14.50),
        LalamoveVehicle("2", "Carro / Utilitário Fiorino", 500, 48.00),
        LalamoveVehicle("3", "Caminhão 3/4 Baú", 3000, 160.00)
    )
}
