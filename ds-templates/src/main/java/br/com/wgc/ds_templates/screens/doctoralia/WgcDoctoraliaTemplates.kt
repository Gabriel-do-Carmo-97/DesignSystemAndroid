package br.com.wgc.ds_templates.screens.doctoralia

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CallEnd
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcClassicButton

@Composable
fun WgcDoctoraliaHomeTemplate(
    doctors: List<DoctorSpecialist> = DoctoraliaMockData.sampleDoctors,
    onDoctorClick: (DoctorSpecialist) -> Unit = {},
    onStartTelemedicine: () -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().background(Color(WgcCoreDsColors.grey50)),
        contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
    ) {
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.doctoraliaGreen))
            ) {
                Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                    Text(text = "🩺 Telemedicina Imediata 24h", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
                    Text(text = "Clínico geral pronto atendimento em até 10 minutos por vídeo.", color = Color.White.copy(alpha = 0.9f), fontSize = 13.sp)
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))
                    WgcClassicButton(
                        textButton = "Entrar no Pronto Atendimento",
                        onClick = onStartTelemedicine,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }

        item {
            Text(text = "Especialistas Recomendados", fontWeight = FontWeight.Bold, fontSize = 16.sp)
        }

        items(doctors) { doc ->
            Card(
                modifier = Modifier.fillMaxWidth().clickable { onDoctorClick(doc) },
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier.size(WgcCoreDsSize.s48.dp).clip(CircleShape).background(Color(WgcCoreDsColors.doctoraliaGreenLight)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Default.Person, contentDescription = null, tint = Color(WgcCoreDsColors.doctoraliaGreen))
                        }
                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                        Column {
                            Text(text = doc.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                            Text(text = "${doc.specialty} • ${doc.crm}", fontSize = 13.sp, color = Color.Gray)
                        }
                    }
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Star, contentDescription = null, tint = Color(WgcCoreDsColors.tokstokYellow), modifier = Modifier.size(WgcCoreDsSize.s16.dp))
                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxxs2.dp))
                        Text(text = "${doc.rating} (${doc.reviewsCount} opiniões)", fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                        Spacer(modifier = Modifier.weight(1f))
                        Text(text = "R$ " + String.format("%.2f", doc.consultationFee), fontWeight = FontWeight.Bold, fontSize = 15.sp, color = Color(WgcCoreDsColors.doctoraliaNavy))
                    }
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
                    Text(text = "🕒 ${doc.nextAvailableSlot}", fontSize = 12.sp, color = Color(WgcCoreDsColors.doctoraliaGreen), fontWeight = FontWeight.Medium)
                }
            }
        }
    }
}

@Composable
fun WgcDoctoraliaSpecialistsTemplate(
    doctors: List<DoctorSpecialist> = DoctoraliaMockData.sampleDoctors,
    onSelectDoctor: (DoctorSpecialist) -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().background(Color(WgcCoreDsColors.grey50)),
        contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
    ) {
        item {
            Text(text = "Busca de Médicos & Especialidades", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(text = "Filtre por convênio, cidade ou telemedicina", fontSize = 13.sp, color = Color.Gray)
        }
        items(doctors) { doc ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                    Text(text = doc.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text(text = doc.specialty, color = Color(WgcCoreDsColors.doctoraliaGreen), fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
                    Text(text = "Convênios: ${doc.insuranceAccepted.joinToString(", ")}", fontSize = 12.sp, color = Color.DarkGray)
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
                    WgcClassicButton(
                        textButton = "Agendar Consulta",
                        onClick = { onSelectDoctor(doc) },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Composable
fun WgcDoctoraliaVideoCallTemplate(
    doctorName: String = "Dra. Juliana Mendes",
    specialty: String = "Dermatologia",
    onEndCall: () -> Unit = {}
) {
    Box(modifier = Modifier.fillMaxSize().background(Color(WgcCoreDsColors.doctoraliaNavy))) {
        Column(
            modifier = Modifier.fillMaxSize().padding(WgcCoreDsSpacing.lg24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Sala de Telemedicina Segura", color = Color.White.copy(alpha = 0.7f), fontSize = 13.sp)
                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
                Text(text = doctorName, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Text(text = specialty, color = Color(WgcCoreDsColors.doctoraliaGreen), fontSize = 14.sp)
            }

            Box(
                modifier = Modifier.size(160.dp).clip(CircleShape).background(Color.DarkGray),
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Default.Videocam, contentDescription = null, tint = Color.White, modifier = Modifier.size(WgcCoreDsSize.s64.dp))
            }

            Row(horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.lg24.dp)) {
                IconButton(
                    onClick = {},
                    modifier = Modifier.size(WgcCoreDsSize.s56.dp).clip(CircleShape).background(Color.DarkGray)
                ) {
                    Icon(Icons.Default.Mic, contentDescription = null, tint = Color.White)
                }
                IconButton(
                    onClick = onEndCall,
                    modifier = Modifier.size(WgcCoreDsSize.s56.dp).clip(CircleShape).background(Color(WgcCoreDsColors.red500))
                ) {
                    Icon(Icons.Default.CallEnd, contentDescription = null, tint = Color.White)
                }
            }
        }
    }
}

@Composable
fun WgcDoctoraliaPrescriptionsTemplate(
    prescriptions: List<MedicalPrescription> = DoctoraliaMockData.samplePrescriptions
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().background(Color(WgcCoreDsColors.grey50)),
        contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
    ) {
        item {
            Text(text = "Receitas & Atestados Digitais", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(text = "Documentos médicos com assinatura digital padrão ICP-Brasil", fontSize = 13.sp, color = Color.Gray)
        }
        items(prescriptions) { rx ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = rx.medicineName, fontWeight = FontWeight.Bold, fontSize = 15.sp)
                        Icon(Icons.Default.QrCode, contentDescription = null, tint = Color(WgcCoreDsColors.doctoraliaNavy))
                    }
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
                    Text(text = "Instruções: ${rx.dosageInstructions}", fontSize = 13.sp)
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
                    Text(text = "Médico: ${rx.doctorName} (${rx.crm})", fontSize = 12.sp, color = Color.DarkGray)
                    Text(text = "Chave ICP: ${rx.icpBrasilSignatureHash}", fontSize = 10.sp, color = Color.Gray)
                }
            }
        }
    }
}

@Composable
fun WgcDoctoraliaProfileTemplate(
    patient: PatientHealthProfile = DoctoraliaMockData.defaultPatient
) {
    Column(modifier = Modifier.fillMaxSize().background(Color(WgcCoreDsColors.grey50)).padding(WgcCoreDsSpacing.md16.dp)) {
        Text(text = "Prontuário do Paciente", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
                Text(text = "Paciente: ${patient.patientName}", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                Text(text = "Tipo Sanguíneo: ${patient.bloodType}", fontSize = 14.sp)
                Text(text = "Alergias: ${patient.allergies.joinToString(", ")}", fontSize = 14.sp, color = Color(WgcCoreDsColors.red500))
                Text(text = "Condições Crônicas: ${patient.chronicConditions.joinToString(", ")}", fontSize = 14.sp)
                Text(text = "Convênio Ativo: ${patient.activeHealthInsurance}", fontSize = 14.sp, color = Color(WgcCoreDsColors.doctoraliaGreen), fontWeight = FontWeight.SemiBold)
            }
        }
    }
}
