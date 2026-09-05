package br.com.wgc.design_system.components.dialogs

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WgcAlertDialog(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    title: String,
    message: String,
    confirmButtonText: String = "Confirmar",
    onConfirmClick: () -> Unit,
    dismissButtonText: String? = "Cancelar",
    onDismissClick: (() -> Unit)? = null
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        modifier = modifier,
        title = { Text(text = title) },
        text = { Text(text = message) },
        confirmButton = {
            TextButton(onClick = onConfirmClick) {
                Text(text = confirmButtonText)
            }
        },
        dismissButton = if (dismissButtonText != null && onDismissClick != null) {
            {
                TextButton(onClick = onDismissClick) {
                    Text(text = dismissButtonText)
                }
            }
        } else null
    )
}
