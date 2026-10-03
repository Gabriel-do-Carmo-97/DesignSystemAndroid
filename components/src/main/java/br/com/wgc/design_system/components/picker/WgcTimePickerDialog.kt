@file:OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)

package br.com.wgc.design_system.components.picker

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Diálogo corporativo de seleção de hora (TimePicker) com suporte a formato 24h e 12h.
 *
 * @param onDismiss Request de fechamento.
 * @param onConfirm Callback que recebe a hora e minuto selecionados.
 * @param initialHour Hora inicial (0..23).
 * @param initialMinute Minuto inicial (0..59).
 * @param is24Hour Se deve exibir o formato 24 horas.
 */
@Composable
fun WgcTimePickerDialog(
    onDismiss: () -> Unit,
    onConfirm: (hour: Int, minute: Int) -> Unit,
    initialHour: Int = 12,
    initialMinute: Int = 0,
    is24Hour: Boolean = true
) {
    val state = rememberTimePickerState(
        initialHour = initialHour,
        initialMinute = initialMinute,
        is24Hour = is24Hour
    )

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Selecionar Horário") },
        text = {
            Column(modifier = Modifier.padding(top = WgcCoreDsSpacing.sm8.dp)) {
                TimePicker(state = state)
            }
        },
        confirmButton = {
            TextButton(onClick = { onConfirm(state.hour, state.minute) }) {
                Text(text = "Confirmar")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(text = "Cancelar")
            }
        }
    )
}
