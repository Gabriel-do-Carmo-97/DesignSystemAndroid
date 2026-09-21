@file:Suppress("LongMethod")
package br.com.wgc.design_system.components.picker

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.DateRangePickerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Campo de seleção de data única com abertura em Dialog modal.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcDatePickerField(
    modifier: Modifier = Modifier,
    label: String = "Data",
    selectedDateMillis: Long? = null,
    onDateSelected: (Long?) -> Unit = {},
    isEnabled: Boolean = true
) {
    var showDialog by remember { mutableStateOf(false) }

    val formattedDate = remember(selectedDateMillis) {
        if (selectedDateMillis != null) {
            val formatter = SimpleDateFormat("dd/MM/yyyy", Locale("pt", "BR"))
            formatter.format(Date(selectedDateMillis))
        } else {
            "Selecionar data"
        }
    }

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSurface
        )

        OutlinedCard(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(enabled = isEnabled) { showDialog = true },
            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.sm12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = formattedDate,
                    style = MaterialTheme.typography.bodyMedium,
                    color = if (selectedDateMillis != null) MaterialTheme.colorScheme.onSurface
                    else MaterialTheme.colorScheme.onSurfaceVariant
                )
                Icon(
                    imageVector = Icons.Default.CalendarToday,
                    contentDescription = "Abrir calendário",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }

    if (showDialog) {
        val datePickerState = rememberDatePickerState(initialSelectedDateMillis = selectedDateMillis)

        DatePickerDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(onClick = {
                    onDateSelected(datePickerState.selectedDateMillis)
                    showDialog = false
                }) {
                    Text("Confirmar")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("Cancelar")
                }
            }
        ) {
            DatePicker(
                state = datePickerState,
                colors = DatePickerDefaults.colors(
                    selectedDayContainerColor = MaterialTheme.colorScheme.primary,
                    todayDateBorderColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    }
}

/**
 * Campo de seleção de intervalo de datas (Período).
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcDateRangePickerField(
    modifier: Modifier = Modifier,
    label: String = "Período",
    startDateMillis: Long? = null,
    endDateMillis: Long? = null,
    onDateRangeSelected: (Long?, Long?) -> Unit = { _, _ -> },
    isEnabled: Boolean = true
) {
    var showDialog by remember { mutableStateOf(false) }

    val formattedRange = remember(startDateMillis, endDateMillis) {
        val formatter = SimpleDateFormat("dd/MM/yyyy", Locale("pt", "BR"))
        when {
            startDateMillis != null && endDateMillis != null -> {
                "${formatter.format(Date(startDateMillis))} - ${formatter.format(Date(endDateMillis))}"
            }
            startDateMillis != null -> "${formatter.format(Date(startDateMillis))} - Selecionar fim"
            else -> "Selecionar período"
        }
    }

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSurface
        )

        OutlinedCard(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(enabled = isEnabled) { showDialog = true },
            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.sm12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = formattedRange,
                    style = MaterialTheme.typography.bodyMedium,
                    color = if (startDateMillis != null) MaterialTheme.colorScheme.onSurface
                    else MaterialTheme.colorScheme.onSurfaceVariant
                )
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "Abrir calendário de intervalo",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }

    if (showDialog) {
        val rangeState = rememberDateRangePickerState(
            initialSelectedStartDateMillis = startDateMillis,
            initialSelectedEndDateMillis = endDateMillis
        )

        DatePickerDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(onClick = {
                    onDateRangeSelected(
                        rangeState.selectedStartDateMillis,
                        rangeState.selectedEndDateMillis
                    )
                    showDialog = false
                }) {
                    Text("Confirmar")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("Cancelar")
                }
            }
        ) {
            DateRangePicker(
                state = rangeState,
                colors = DatePickerDefaults.colors(
                    selectedDayContainerColor = MaterialTheme.colorScheme.primary,
                    dayInSelectionRangeContainerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    }
}

@Preview(name = "WgcDatePickerField - Preview", showBackground = true)
@Composable
private fun WgcDatePickerFieldPreview() {
    MaterialTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            WgcDatePickerField(selectedDateMillis = System.currentTimeMillis())
            WgcDateRangePickerField(
                startDateMillis = System.currentTimeMillis(),
                endDateMillis = System.currentTimeMillis() + 86400000L * 7
            )
        }
    }
}
