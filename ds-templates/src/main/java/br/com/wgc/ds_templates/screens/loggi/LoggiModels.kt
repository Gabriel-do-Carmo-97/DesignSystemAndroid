package br.com.wgc.ds_templates.screens.loggi

data class LoggiPackage(val trackingCode: String, val destination: String, val status: String, val eta: String)

object LoggiMockData {
    val samplePackages = listOf(
        LoggiPackage("BR-LG-884219", "Rua Augusta, 1500 - São Paulo", "Em trânsito para o centro de distribuição", "Hoje até às 18h"),
        LoggiPackage("BR-LG-773192", "Av. Paulista, 900 - São Paulo", "Entregue ao destinatário", "Ontem às 14:22")
    )
}
