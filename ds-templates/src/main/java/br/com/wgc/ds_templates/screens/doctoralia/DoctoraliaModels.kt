package br.com.wgc.ds_templates.screens.doctoralia

data class DoctorSpecialist(
    val id: String,
    val name: String,
    val crm: String,
    val specialty: String,
    val rating: Double,
    val reviewsCount: Int,
    val consultationFee: Double,
    val insuranceAccepted: List<String>,
    val nextAvailableSlot: String
)

data class MedicalPrescription(
    val id: String,
    val doctorName: String,
    val crm: String,
    val issuedDate: String,
    val medicineName: String,
    val dosageInstructions: String,
    val icpBrasilSignatureHash: String
)

data class PatientHealthProfile(
    val patientName: String,
    val bloodType: String,
    val allergies: List<String>,
    val chronicConditions: List<String>,
    val activeHealthInsurance: String
)

object DoctoraliaMockData {
    val sampleDoctors = listOf(
        DoctorSpecialist(
            id = "doc_1",
            name = "Dra. Juliana Mendes",
            crm = "CRM-SP 148.920",
            specialty = "Dermatologia & Tricologia",
            rating = 4.9,
            reviewsCount = 312,
            consultationFee = 280.00,
            insuranceAccepted = listOf("Bradesco", "Amil", "SulAmérica"),
            nextAvailableSlot = "Hoje às 16:30 (Telemedicina)"
        ),
        DoctorSpecialist(
            id = "doc_2",
            name = "Dr. Rodrigo Castro",
            crm = "CRM-SP 120.405",
            specialty = "Cardiologia & Check-up",
            rating = 4.8,
            reviewsCount = 189,
            consultationFee = 320.00,
            insuranceAccepted = listOf("Unimed", "NotreDame Intermédica", "Bradesco"),
            nextAvailableSlot = "Amanhã às 10:00"
        ),
        DoctorSpecialist(
            id = "doc_3",
            name = "Dra. Beatriz Fernandes",
            crm = "CRM-SP 173.882",
            specialty = "Psiquiatria & Saúde Mental",
            rating = 5.0,
            reviewsCount = 420,
            consultationFee = 350.00,
            insuranceAccepted = listOf("Particular", "Reembolso"),
            nextAvailableSlot = "Quinta-feira às 14:00"
        )
    )

    val samplePrescriptions = listOf(
        MedicalPrescription(
            id = "rx_01",
            doctorName = "Dra. Juliana Mendes",
            crm = "CRM-SP 148.920",
            issuedDate = "12/09/2026",
            medicineName = "Minoxidil 5% Loção Capilar 100ml",
            dosageInstructions = "Aplicar 1ml no couro cabeludo à noite diariamente.",
            icpBrasilSignatureHash = "ICP-BR#9982-A41B-CC71-2026"
        ),
        MedicalPrescription(
            id = "rx_02",
            doctorName = "Dr. Rodrigo Castro",
            crm = "CRM-SP 120.405",
            issuedDate = "01/08/2026",
            medicineName = "Rosuvastatina 10mg - 30 comprimidos",
            dosageInstructions = "Tomar 1 comprimido ao dia após o jantar.",
            icpBrasilSignatureHash = "ICP-BR#1104-B83C-DD90-2026"
        )
    )

    val defaultPatient = PatientHealthProfile(
        patientName = "Gabriel do Carmo",
        bloodType = "O+",
        allergies = listOf("Dipirona", "Penicilina"),
        chronicConditions = listOf("Nenhuma relatada"),
        activeHealthInsurance = "Bradesco Saúde Top Nacional"
    )
}
