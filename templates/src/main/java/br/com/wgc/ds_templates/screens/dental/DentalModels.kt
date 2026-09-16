package br.com.wgc.ds_templates.screens.dental

data class ToothCondition(
    val toothNumber: Int,
    val name: String,
    val status: ToothStatus,
    val notes: String
)

enum class ToothStatus {
    HEALTHY,
    CAVITY,
    TREATED,
    RESTORATION,
    EXTRACTION_RECOMMENDED
}

data class DentalXRayRecord(
    val id: String,
    val title: String,
    val examType: String,
    val date: String,
    val dentistName: String,
    val summaryReport: String
)

data class DentalAppointment(
    val id: String,
    val dentistName: String,
    val specialty: String,
    val clinicAddress: String,
    val date: String,
    val time: String,
    val isConfirmed: Boolean
)

data class DentalPlanUser(
    val name: String,
    val planName: String,
    val cardId: String,
    val gracePeriodStatus: String,
    val coverageLevel: String
)

object DentalMockData {
    val defaultUser = DentalPlanUser(
        name = "Gabriel do Carmo",
        planName = "DentiCare Premium Gold",
        cardId = "8890.1234.5678.90",
        gracePeriodStatus = "Carências 100% cumpridas",
        coverageLevel = "Ortodontia, Prótese e Clareamento"
    )

    val sampleTeeth = listOf(
        ToothCondition(11, "Incisivo Central Superior D", ToothStatus.HEALTHY, "Higienização excelente"),
        ToothCondition(16, "Primeiro Molar Superior D", ToothStatus.RESTORATION, "Restauração resina realizada em 2025"),
        ToothCondition(21, "Incisivo Central Superior E", ToothStatus.HEALTHY, "Sem alterações"),
        ToothCondition(26, "Primeiro Molar Superior E", ToothStatus.CAVITY, "Cárie oclusal inicial indicada p/ restauração"),
        ToothCondition(36, "Primeiro Molar Inferior E", ToothStatus.TREATED, "Tratamento de canal finalizado"),
        ToothCondition(48, "Terceiro Molar Inferior D", ToothStatus.EXTRACTION_RECOMMENDED, "Incluso - indicação cirúrgica")
    )

    val sampleXRays = listOf(
        DentalXRayRecord("xr_1", "Radiografia Panorâmica Total", "Panorâmica 360°", "10/01/2026", "Dra. Camila Torres (CRO 45210)", "Arcada sem lesões ósseas. Terceiros molares inclusos."),
        DentalXRayRecord("xr_2", "Raio-X Periapical Molar 26", "Periapical Digital", "05/02/2026", "Dr. Marcos Vinicius (CRO 38902)", "Área translúcida em esmalte compatível com cárie oclusal.")
    )

    val sampleAppointments = listOf(
        DentalAppointment("ap_1", "Dra. Camila Torres", "Ortodontia & Estética", "Av. Paulista, 1000 - Cj 42", "22/09/2026", "14:30", true),
        DentalAppointment("ap_2", "Dr. Roberto Silva", "Endodontia", "Rua Augusta, 450", "04/10/2026", "09:00", false)
    )
}
