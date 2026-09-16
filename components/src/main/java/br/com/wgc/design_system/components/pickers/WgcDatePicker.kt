package br.com.wgc.design_system.components.pickers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.commons.WgcComponentPreviews

/**
 * WgcDatePicker
 *
 * Componente stateless de seleção de data inline compatível com Material 3 e tokens WGC.
 *
 * @param state Estado do DatePicker.
 * @param modifier Modificador de layout.
 * @param showModeToggle Define se o botão de alternância de modo (calendário / input de texto) deve ser exibido.
 * @param title Slot opcional para o título superior.
 * @param headline Slot opcional para o cabeçalho de data selecionada.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcDatePicker(
    state: DatePickerState,
    modifier: Modifier = Modifier,
    showModeToggle: Boolean = true,
    title: (@Composable () -> Unit)? = null,
    headline: (@Composable () -> Unit)? = null
) {
    DatePicker(
        state = state,
        modifier = modifier,
        showModeToggle = showModeToggle,
        title = title,
        headline = headline,
        colors = DatePickerDefaults.colors(
            containerColor = MaterialTheme.colorScheme.surface,
            titleContentColor = MaterialTheme.colorScheme.onSurface,
            headlineContentColor = MaterialTheme.colorScheme.onSurface,
            selectedDayContainerColor = MaterialTheme.colorScheme.primary,
            selectedDayContentColor = MaterialTheme.colorScheme.onPrimary,
            todayDateBorderColor = MaterialTheme.colorScheme.primary,
            todayContentColor = MaterialTheme.colorScheme.primary
        )
    )
}

/**
 * WgcDatePickerDialog
 *
 * Diálogo modal para seleção de datas corporativo.
 *
 * @param state Estado do DatePicker.
 * @param onDismissRequest Callback disparado ao cancelar ou clicar fora do diálogo.
 * @param onConfirm Callback disparado ao confirmar a seleção de data.
 * @param modifier Modificador de layout.
 * @param confirmButtonText Texto do botão de confirmação.
 * @param dismissButtonText Texto do botão de cancelamento.
 * @param title Slot customizável para título superior.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcDatePickerDialog(
    state: DatePickerState,
    onDismissRequest: () -> Unit,
    onConfirm: (selectedDateMillis: Long?) -> Unit,
    modifier: Modifier = Modifier,
    confirmButtonText: String = "Confirmar",
    dismissButtonText: String = "Cancelar",
    title: (@Composable () -> Unit)? = null
) {
    DatePickerDialog(
        onDismissRequest = onDismissRequest,
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirm(state.selectedDateMillis)
                }
            ) {
                Text(
                    text = confirmButtonText,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        },
        dismissButton = {
            TextButton(onClick = onDismissRequest) {
                Text(
                    text = dismissButtonText,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        },
        modifier = modifier,
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = DatePickerDefaults.colors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        WgcDatePicker(
            state = state,
            title = title
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@WgcComponentPreviews
@Composable
private fun WgcDatePickerPreview() {
    val state = rememberDatePickerState(initialSelectedDateMillis = 1715000000000L)
    MaterialTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(WgcCoreDsSpacing.md16.dp),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
            ) {
                WgcDatePicker(state = state)
            }
        }
    }
}
