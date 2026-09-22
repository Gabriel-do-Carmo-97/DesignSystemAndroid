package br.com.wgc.design_system.templates.screens.dental

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.HealthAndSafety
import androidx.compose.material.icons.filled.MedicalInformation
import androidx.compose.material.icons.filled.PermIdentity
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsElevation
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcClassicButton

@Composable
fun WgcDentalHomeTemplate(
    user: DentalPlanUser = DentalMockData.defaultUser,
    upcomingAppointment: DentalAppointment? = DentalMockData.sampleAppointments.firstOrNull(),
    onScheduleClick: () -> Unit = {},
    onViewOdontogramClick: () -> Unit = {},
    onViewXRayClick: () -> Unit = {}
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
                colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.dentalTeal))
            ) {
                Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(text = "Carteirinha Digital", color = Color.White.copy(alpha = 0.8f), fontSize = 12.sp)
                            Text(text = user.planName, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        }
                        Icon(Icons.Default.HealthAndSafety, contentDescription = null, tint = Color.White, modifier = Modifier.size(WgcCoreDsSize.s32.dp))
                    }
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))
                    Text(text = user.cardId, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text(text = "Titular: ${user.name}", color = Color.White.copy(alpha = 0.9f), fontSize = 14.sp)
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
                    Text(text = user.gracePeriodStatus, color = Color.White.copy(alpha = 0.75f), fontSize = 12.sp)
                }
            }
        }

        item {
            Text(text = "Ações Rápidas", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
                QuickActionCard(
                    title = "Odontograma",
                    icon = Icons.Default.HealthAndSafety,
                    modifier = Modifier.weight(1f),
                    onClick = onViewOdontogramClick
                )
                QuickActionCard(
                    title = "Raio-X Digital",
                    icon = Icons.Default.MedicalInformation,
                    modifier = Modifier.weight(1f),
                    onClick = onViewXRayClick
                )
                QuickActionCard(
                    title = "Agendar",
                    icon = Icons.Default.CalendarMonth,
                    modifier = Modifier.weight(1f),
                    onClick = onScheduleClick
                )
            }
        }

        item {
            Text(text = "Próxima Consulta", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
            if (upcomingAppointment != null) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier.size(WgcCoreDsSize.s40.dp).clip(CircleShape).background(Color(WgcCoreDsColors.dentalTealLight)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(Icons.Default.HealthAndSafety, contentDescription = null, tint = Color(WgcCoreDsColors.dentalTeal))
                            }
                            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                            Column {
                                Text(text = upcomingAppointment.dentistName, fontWeight = FontWeight.Bold, fontSize = 15.sp)
                                Text(text = upcomingAppointment.specialty, color = Color.Gray, fontSize = 13.sp)
                            }
                        }
                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
                        Text(text = "📍 ${upcomingAppointment.clinicAddress}", fontSize = 13.sp)
                        Text(text = "🗓️ ${upcomingAppointment.date} às ${upcomingAppointment.time}", fontWeight = FontWeight.SemiBold, fontSize = 13.sp, color = Color(WgcCoreDsColors.dentalDark))
                    }
                }
            }
        }
    }
}

@Composable
private fun QuickActionCard(
    title: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier.clickable { onClick() },
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(icon, contentDescription = null, tint = Color(WgcCoreDsColors.dentalTeal), modifier = Modifier.size(WgcCoreDsSize.s28.dp))
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
            Text(text = title, fontSize = 12.sp, fontWeight = FontWeight.Medium)
        }
    }
}

@Composable
fun WgcDentalOdontogramTemplate(
    teeth: List<ToothCondition> = DentalMockData.sampleTeeth,
    onToothClick: (ToothCondition) -> Unit = {}
) {
    var selectedTooth by remember { mutableStateOf<ToothCondition?>(teeth.firstOrNull()) }

    Column(modifier = Modifier.fillMaxSize().background(Color(WgcCoreDsColors.grey50)).padding(WgcCoreDsSpacing.md16.dp)) {
        Text(text = "🦷 Odontograma Clínico Interativo", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color(WgcCoreDsColors.dentalDark))
        Text(text = "Selecione um dente para inspecionar procedimentos e histórico", fontSize = 13.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                Text(text = "Arcada Superior e Inferior", fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    modifier = Modifier.height(220.dp),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    items(teeth) { tooth ->
                        val statusColor = when (tooth.status) {
                            ToothStatus.HEALTHY -> Color(WgcCoreDsColors.transitDigitalGreen)
                            ToothStatus.CAVITY -> Color(WgcCoreDsColors.red500)
                            ToothStatus.RESTORATION -> Color(WgcCoreDsColors.blue500)
                            ToothStatus.TREATED -> Color(WgcCoreDsColors.designerFurnitureYellow)
                            ToothStatus.EXTRACTION_RECOMMENDED -> Color.DarkGray
                        }
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                .background(if (selectedTooth == tooth) Color(WgcCoreDsColors.dentalTealLight) else Color(WgcCoreDsColors.grey100))
                                .clickable {
                                    selectedTooth = tooth
                                    onToothClick(tooth)
                                }
                                .padding(WgcCoreDsSpacing.xs8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Box(modifier = Modifier.size(WgcCoreDsSize.s10.dp).clip(CircleShape).background(statusColor))
                                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxxs2.dp))
                                Text(text = "D${tooth.toothNumber}", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                                Text(text = tooth.status.name.take(4), fontSize = 9.sp, color = Color.Gray)
                            }
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

        selectedTooth?.let { tooth ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                    Text(text = "Dente ${tooth.toothNumber} - ${tooth.name}", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
                    Text(text = "Status Atual: ${tooth.status.name}", fontWeight = FontWeight.SemiBold, color = Color(WgcCoreDsColors.dentalTeal))
                    Text(text = "Observações: ${tooth.notes}", fontSize = 13.sp, color = Color.DarkGray)
                }
            }
        }
    }
}

@Composable
fun WgcDentalXRayTemplate(
    xrays: List<DentalXRayRecord> = DentalMockData.sampleXRays,
    onViewDetail: (DentalXRayRecord) -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().background(Color(WgcCoreDsColors.grey50)),
        contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
    ) {
        item {
            Text(text = "Radiografias e Exames Digitais", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(text = "Histórico de exames odontológicos com laudo emitido", fontSize = 13.sp, color = Color.Gray)
        }

        items(xrays) { exam ->
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
                        Text(text = exam.title, fontWeight = FontWeight.Bold, fontSize = 15.sp)
                        Text(text = exam.date, fontSize = 12.sp, color = Color.Gray)
                    }
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
                    Text(text = "Responsável: ${exam.dentistName}", fontSize = 13.sp, color = Color.DarkGray)
                    Text(text = "Laudo: ${exam.summaryReport}", fontSize = 13.sp, color = Color.Gray)
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))
                    WgcClassicButton(
                        textButton = "Visualizar Raio-X em Alta Resolução",
                        onClick = { onViewDetail(exam) },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Composable
fun WgcDentalAppointmentTemplate(
    appointments: List<DentalAppointment> = DentalMockData.sampleAppointments,
    onNewSchedule: () -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().background(Color(WgcCoreDsColors.grey50)),
        contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Agendamento Odontológico", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }
        }

        items(appointments) { app ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                    Text(text = app.specialty, color = Color(WgcCoreDsColors.dentalTeal), fontWeight = FontWeight.Bold, fontSize = 13.sp)
                    Text(text = app.dentistName, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text(text = app.clinicAddress, fontSize = 13.sp, color = Color.Gray)
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
                    Text(text = "Data: ${app.date} às ${app.time}", fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                }
            }
        }

        item {
            WgcClassicButton(
                textButton = "Agendar Nova Consulta",
                onClick = onNewSchedule,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun WgcDentalProfileTemplate(
    user: DentalPlanUser = DentalMockData.defaultUser
) {
    Column(modifier = Modifier.fillMaxSize().background(Color(WgcCoreDsColors.grey50)).padding(WgcCoreDsSpacing.md16.dp)) {
        Text(text = "Meu Plano Odontológico", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
                Text(text = "Beneficiário: ${user.name}", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                Text(text = "Plano: ${user.planName}", fontSize = 14.sp)
                Text(text = "Matrícula: ${user.cardId}", fontSize = 14.sp)
                Text(text = "Coberturas: ${user.coverageLevel}", fontSize = 14.sp, color = Color(WgcCoreDsColors.dentalDark))
                Text(text = "Status: ${user.gracePeriodStatus}", fontSize = 13.sp, color = Color(WgcCoreDsColors.transitDigitalGreen))
            }
        }
    }
}
