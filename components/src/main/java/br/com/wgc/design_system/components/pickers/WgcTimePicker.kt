package br.com.wgc.design_system.components.pickers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerColors
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.TimePickerLayoutType
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.commons.WgcComponentPreviews

/**
 * WgcTimePicker
 *
 * Componente stateless de seleção de horário inline utilizando Material 3 e tokens WGC.
 *
 * @param state Estado do TimePicker.
 * @param modifier Modificador de layout.
 * @param layoutType Tipo de layout do seletor (Vertical ou Horizontal).
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcTimePicker(
    state: TimePickerState,
    modifier: Modifier = Modifier,
    layoutType: TimePickerLayoutType = TimePickerDefaults.layoutType()
) {
    TimePicker(
        state = state,
        modifier = modifier,
        layoutType = layoutType,
        colors = TimePickerDefaults.colors(
            clockDialColor = MaterialTheme.colorScheme.surfaceVariant,
            selectorColor = MaterialTheme.colorScheme.primary,
            containerColor = MaterialTheme.colorScheme.surface,
            periodSelectorBorderColor = MaterialTheme.colorScheme.outline,
            periodSelectorSelectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            periodSelectorUnselectedContainerColor = MaterialTheme.colorScheme.surface,
            periodSelectorSelectedContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            periodSelectorUnselectedContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
            timeSelectorSelectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            timeSelectorUnselectedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
            timeSelectorSelectedContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            timeSelectorUnselectedContentColor = MaterialTheme.colorScheme.onSurfaceVariant
        )
    )
}

/**
 * WgcTimePickerDialog
 *
 * Diálogo modal para seleção de horário corporativo.
 *
 * @param state Estado do TimePicker.
 * @param onDismissRequest Callback ao fechar ou cancelar o diálogo.
 * @param onConfirm Callback disparado com (hora, minuto) selecionados.
 * @param modifier Modificador de layout.
 * @param title Título exibido no topo do diálogo.
 * @param confirmButtonText Texto do botão de confirmação.
 * @param dismissButtonText Texto do botão de cancelamento.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcTimePickerDialog(
    state: TimePickerState,
    onDismissRequest: () -> Unit,
    onConfirm: (hour: Int, minute: Int) -> Unit,
    modifier: Modifier = Modifier,
    title: String = "Selecionar horário",
    confirmButtonText: String = "Confirmar",
    dismissButtonText: String = "Cancelar"
) {
    BasicAlertDialog(
        onDismissRequest = onDismissRequest,
        modifier = modifier
    ) {
        Surface(
            shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
            color = MaterialTheme.colorScheme.surface,
            tonalElevation = WgcCoreDsSpacing.xxxs2.dp
        ) {
            Column(
                modifier = Modifier
                    .padding(WgcCoreDsSpacing.lg24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = WgcCoreDsSpacing.md16.dp)
                )

                WgcTimePicker(state = state)

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextButton(onClick = onDismissRequest) {
                        Text(
                            text = dismissButtonText,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    TextButton(
                        onClick = {
                            onConfirm(state.hour, state.minute)
                        }
                    ) {
                        Text(
                            text = confirmButtonText,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@WgcComponentPreviews
@Composable
private fun WgcTimePickerPreview() {
    val state = rememberTimePickerState(initialHour = 14, initialMinute = 30, is24Hour = true)
    MaterialTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(WgcCoreDsSpacing.md16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                WgcTimePicker(state = state)
            }
        }
    }
}
