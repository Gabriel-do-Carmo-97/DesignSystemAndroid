package br.com.wgc.ds_templates.screens.ctps

data class CtpsContract(val company: String, val role: String, val admissionDate: String, val isActive: Boolean)

object CtpsMockData {
    val sampleContracts = listOf(
        CtpsContract("WGC TECNOLOGIA S.A.", "Tech Lead Mobile Android", "01/02/2021", true),
        CtpsContract("INOVAÇÃO DIGITAL LTDA", "Engenheiro de Software Sênior", "15/03/2018", false)
    )
}
