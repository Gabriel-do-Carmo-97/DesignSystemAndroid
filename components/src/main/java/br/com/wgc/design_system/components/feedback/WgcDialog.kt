package br.com.wgc.design_system.components.feedback

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Componente de Diálogo Modal do Design System (WgcDialog) baseado no Material 3.
 */
@Composable
fun WgcDialog(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    title: String,
    text: String,
    confirmButtonText: String,
    onConfirmClick: () -> Unit,
    dismissButtonText: String? = null,
    onDismissClick: (() -> Unit)? = null
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        modifier = modifier,
        title = { Text(text = title) },
        text = { Text(text = text) },
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
