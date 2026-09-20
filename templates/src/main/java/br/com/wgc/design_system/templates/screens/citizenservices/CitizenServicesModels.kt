package br.com.wgc.design_system.templates.screens.citizenservices

data class GovService(val id: String, val title: String, val agency: String, val isFavorite: Boolean)

object GovBrMockData {
    val sampleServices = listOf(
        GovService("1", "Consultar Restituição IRPF 2026", "Receita Federal", true),
        GovService("2", "Assinatura Eletrônica Avançada de Documentos", "Gov.br Cidadão", true),
        GovService("3", "Consultar Histórico de Vacinas (Conecte SUS)", "Ministério da Saúde", false)
    )
}
