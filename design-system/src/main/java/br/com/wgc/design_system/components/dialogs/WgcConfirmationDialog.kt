package br.com.wgc.design_system.components.dialogs

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.radio.WgcRadioButton

@Composable
fun WgcConfirmationDialog(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    title: String,
    options: List<String>,
    initialSelected: String,
    onConfirmSelection: (String) -> Unit
) {
    var selectedOption by remember { mutableStateOf(initialSelected) }

    AlertDialog(
        onDismissRequest = onDismissRequest,
        modifier = modifier,
        title = { Text(text = title) },
        text = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
            ) {
                options.forEach { option ->
                    WgcRadioButton(
                        selected = selectedOption == option,
                        label = option,
                        onClick = { selectedOption = option }
                    )
                }
            }
        },
        confirmButton = {
            TextButton(onClick = {
                onConfirmSelection(selectedOption)
                onDismissRequest()
            }) {
                Text(text = "Confirmar")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismissRequest) {
                Text(text = "Cancelar")
            }
        }
    )
}
