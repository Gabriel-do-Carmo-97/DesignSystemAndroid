package br.com.wgc.ds_templates.screens.quintoandar.schedule

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.ds_templates.screens.quintoandar.model.QuintoAndarMockData
import br.com.wgc.ds_templates.screens.quintoandar.model.QuintoAndarPropertyModel

data class ScheduleDayOption(
    val dayOfWeek: String,
    val dayNumber: String,
    val fullDate: String
)

/**
 * Template de Agendamento de Visita do QuintoAndar:
 * - Seletor de modalidade: Visita Presencial vs Tour por Vídeo
 * - Fita horizontal de seleção de datas disponíveis
 * - Seleção de faixas de horário (Manhã e Tarde)
 * - Observações ao corretor parceiro
 * - Garantia de cancelamento gratuito e botão de confirmação
 */
@Composable
fun WgcQuintoAndarScheduleVisitTemplate(
    modifier: Modifier = Modifier,
    property: QuintoAndarPropertyModel = QuintoAndarMockData.sampleDetailProperty,
    onBackClick: () -> Unit = {},
    onConfirmSchedule: (date: String, time: String, isVideo: Boolean) -> Unit = { _, _, _ -> },
    topBarSlot: (@Composable () -> Unit)? = null
) {
    var isVideoVisit by remember { mutableStateOf(false) }

    val days = listOf(
        ScheduleDayOption("Seg", "15", "Segunda, 15 Set"),
        ScheduleDayOption("Ter", "16", "Terça, 16 Set"),
        ScheduleDayOption("Qua", "17", "Quarta, 17 Set"),
        ScheduleDayOption("Qui", "18", "Quinta, 18 Set"),
        ScheduleDayOption("Sex", "19", "Sexta, 19 Set"),
        ScheduleDayOption("Sáb", "20", "Sábado, 20 Set")
    )
    var selectedDay by remember { mutableStateOf(days[0]) }

    val morningSlots = listOf("09:00", "10:00", "11:30")
    val afternoonSlots = listOf("14:00", "15:30", "16:30", "17:30")
    var selectedTimeSlot by remember { mutableStateOf("10:00") }

    var notes by remember { mutableStateOf("") }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            if (topBarSlot != null) {
                topBarSlot()
            } else {
                QuintoAndarScheduleTopBar(onBackClick = onBackClick)
            }
        },
        bottomBar = {
            QuintoAndarScheduleBottomBar(
                onConfirmClick = {
                    onConfirmSchedule(selectedDay.fullDate, selectedTimeSlot, isVideoVisit)
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(
                horizontal = WgcCoreDsSpacing.md16.dp,
                vertical = WgcCoreDsSpacing.md16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            // Card de resumo do imóvel
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.quintoAndarSurface))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(WgcCoreDsSize.s60.dp)
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                                .background(Color(WgcCoreDsColors.quintoAndarPrimaryLight)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.quintoAndarPrimary),
                                modifier = Modifier.size(WgcCoreDsSize.s28.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = property.title,
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = Color(WgcCoreDsColors.quintoAndarDark),
                                maxLines = 1
                            )
                            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.LocationOn,
                                    contentDescription = null,
                                    tint = Color(WgcCoreDsColors.quintoAndarSecondaryText),
                                    modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                                )
                                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                                Text(
                                    text = "${property.neighborhood} • ${property.address}",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Color(WgcCoreDsColors.quintoAndarSecondaryText),
                                    maxLines = 1
                                )
                            }
                            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                            Text(
                                text = property.totalPrice,
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Bold,
                                color = Color(WgcCoreDsColors.quintoAndarPrimary)
                            )
                        }
                    }
                }
            }

            // Seletor de Formato da Visita: Presencial vs Por Vídeo
            item {
                Text(
                    text = "Como você prefere visitar?",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.quintoAndarDark)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                ) {
                    // Presencial Card
                    VisitTypeCard(
                        modifier = Modifier.weight(1f),
                        title = "Presencial",
                        description = "Encontre o corretor no imóvel",
                        isSelected = !isVideoVisit,
                        icon = Icons.Default.Person,
                        onClick = { isVideoVisit = false }
                    )

                    // Por Vídeo Card
                    VisitTypeCard(
                        modifier = Modifier.weight(1f),
                        title = "Por Vídeo",
                        description = "Tour guiado por videochamada",
                        isSelected = isVideoVisit,
                        icon = Icons.Default.Videocam,
                        onClick = { isVideoVisit = true }
                    )
                }
            }

            // Seletor de Data
            item {
                Text(
                    text = "Escolha o dia",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.quintoAndarDark)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    items(days) { day ->
                        val isSelected = selectedDay == day
                        DayChip(
                            dayOption = day,
                            isSelected = isSelected,
                            onClick = { selectedDay = day }
                        )
                    }
                }
            }

            // Seletor de Horários (Manhã)
            item {
                Text(
                    text = "Horários pela Manhã",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.quintoAndarDark)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    morningSlots.forEach { slot ->
                        val isSelected = selectedTimeSlot == slot
                        TimeSlotChip(
                            time = slot,
                            isSelected = isSelected,
                            onClick = { selectedTimeSlot = slot },
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }

            // Seletor de Horários (Tarde)
            item {
                Text(
                    text = "Horários pela Tarde",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.quintoAndarDark)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    afternoonSlots.take(2).forEach { slot ->
                        val isSelected = selectedTimeSlot == slot
                        TimeSlotChip(
                            time = slot,
                            isSelected = isSelected,
                            onClick = { selectedTimeSlot = slot },
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    afternoonSlots.drop(2).forEach { slot ->
                        val isSelected = selectedTimeSlot == slot
                        TimeSlotChip(
                            time = slot,
                            isSelected = isSelected,
                            onClick = { selectedTimeSlot = slot },
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }

            // Instruções adicionais
            item {
                Text(
                    text = "Observações ou dúvidas (opcional)",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.quintoAndarDark)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                OutlinedTextField(
                    value = notes,
                    onValueChange = { notes = it },
                    placeholder = {
                        Text(
                            text = "Ex: Gostaria de checar a garagem e a vista da varanda",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color(WgcCoreDsColors.quintoAndarSecondaryText)
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(WgcCoreDsSize.s90.dp),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(WgcCoreDsColors.quintoAndarYellow),
                        unfocusedBorderColor = Color(WgcCoreDsColors.quintoAndarBorder),
                        focusedContainerColor = Color(WgcCoreDsColors.quintoAndarSurface),
                        unfocusedContainerColor = Color(WgcCoreDsColors.quintoAndarSurface)
                    )
                )
            }

            // Nota de Cancelamento Gratuito
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = WgcCoreDsSpacing.xs8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.quintoAndarGreen),
                        modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                    )
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                    Text(
                        text = "Cancelamento ou reagendamento gratuito a qualquer momento.",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(WgcCoreDsColors.quintoAndarSecondaryText)
                    )
                }
            }
        }
    }
}

@Composable
private fun QuintoAndarScheduleTopBar(
    onBackClick: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color(WgcCoreDsColors.quintoAndarSurface),
        shadowElevation = WgcCoreDsSpacing.xxs4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = WgcCoreDsSpacing.md16.dp,
                    vertical = WgcCoreDsSpacing.sm12.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = onBackClick,
                modifier = Modifier.size(WgcCoreDsSize.s36.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Voltar",
                    tint = Color(WgcCoreDsColors.quintoAndarDark)
                )
            }

            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))

            Text(
                text = "Agendar Visita",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.quintoAndarDark)
            )
        }
    }
}

@Composable
private fun VisitTypeCard(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    isSelected: Boolean,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    onClick: () -> Unit
) {
    val borderColor = if (isSelected) Color(WgcCoreDsColors.quintoAndarPrimary) else Color(WgcCoreDsColors.quintoAndarBorder)
    val bgColor = if (isSelected) Color(WgcCoreDsColors.quintoAndarPrimaryLight) else Color(WgcCoreDsColors.quintoAndarSurface)

    Card(
        modifier = modifier.clickable(onClick = onClick),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = bgColor),
        border = androidx.compose.foundation.BorderStroke(WgcCoreDsSpacing.xxxs2.dp, borderColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = if (isSelected) Color(WgcCoreDsColors.quintoAndarPrimary) else Color(WgcCoreDsColors.quintoAndarSecondaryText),
                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
            )
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.quintoAndarDark)
            )
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall,
                color = Color(WgcCoreDsColors.quintoAndarSecondaryText)
            )
        }
    }
}

@Composable
private fun DayChip(
    dayOption: ScheduleDayOption,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val bgColor = if (isSelected) Color(WgcCoreDsColors.quintoAndarPrimary) else Color(WgcCoreDsColors.quintoAndarSurface)
    val textColor = if (isSelected) Color.White else Color(WgcCoreDsColors.quintoAndarDark)
    val subTextColor = if (isSelected) Color(WgcCoreDsColors.quintoAndarYellow) else Color(WgcCoreDsColors.quintoAndarSecondaryText)

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp))
            .background(bgColor)
            .border(
                width = WgcCoreDsSpacing.xxxs2.dp,
                color = if (isSelected) Color(WgcCoreDsColors.quintoAndarPrimary) else Color(WgcCoreDsColors.quintoAndarBorder),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp)
            )
            .clickable(onClick = onClick)
            .padding(
                horizontal = WgcCoreDsSpacing.md16.dp,
                vertical = WgcCoreDsSpacing.sm12.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = dayOption.dayOfWeek,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.Medium,
            color = subTextColor
        )
        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
        Text(
            text = dayOption.dayNumber,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = textColor
        )
    }
}

@Composable
private fun TimeSlotChip(
    time: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val bgColor = if (isSelected) Color(WgcCoreDsColors.quintoAndarYellow) else Color(WgcCoreDsColors.quintoAndarSurface)
    val textColor = Color(WgcCoreDsColors.quintoAndarDark)
    val borderColor = if (isSelected) Color(WgcCoreDsColors.quintoAndarYellowDark) else Color(WgcCoreDsColors.quintoAndarBorder)

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
            .background(bgColor)
            .border(
                width = WgcCoreDsSpacing.xxxs2.dp,
                color = borderColor,
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp)
            )
            .clickable(onClick = onClick)
            .padding(vertical = WgcCoreDsSpacing.sm12.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = time,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
            color = textColor
        )
    }
}

@Composable
private fun QuintoAndarScheduleBottomBar(
    onConfirmClick: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color(WgcCoreDsColors.quintoAndarSurface),
        shadowElevation = WgcCoreDsSpacing.md16.dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = WgcCoreDsSpacing.md16.dp,
                    vertical = WgcCoreDsSpacing.sm12.dp
                )
        ) {
            Button(
                onClick = onConfirmClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(WgcCoreDsSize.s48.dp),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(WgcCoreDsColors.quintoAndarYellow))
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.CalendarToday,
                        contentDescription = null,
                        modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                    )
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                    Text(
                        text = "Confirmar Agendamento",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcQuintoAndarScheduleVisitTemplatePreview() {
    WgcQuintoAndarScheduleVisitTemplate()
}
