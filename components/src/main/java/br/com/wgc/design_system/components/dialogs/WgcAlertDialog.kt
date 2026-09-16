package br.com.wgc.design_system.components.dialogs

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
 * Diálogo de alerta corporativo do Design System (WgcAlertDialog).
 *
 * @param modifier Modificador de layout.
 * @param onDismissRequest Callback acionado ao fechar o diálogo.
 * @param title Título do diálogo.
 * @param message Mensagem explicativa do corpo do diálogo.
 * @param confirmButtonText Texto da ação primária de confirmação.
 * @param onConfirmClick Callback acionado na confirmação.
 * @param dismissButtonText Texto opcional da ação secundária de cancelamento.
 * @param onDismissClick Callback acionado no cancelamento.
 */
@Composable
fun WgcAlertDialog(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    title: String,
    message: String,
    confirmButtonText: String = "Confirmar",
    onConfirmClick: () -> Unit = {},
    dismissButtonText: String? = "Cancelar",
    onDismissClick: (() -> Unit)? = null
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        modifier = modifier,
        title = { Text(text = title, style = MaterialTheme.typography.titleLarge) },
        text = { Text(text = message, style = MaterialTheme.typography.bodyMedium) },
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

@Preview(showBackground = true)
@Composable
private fun WgcAlertDialogPreview() {
    MaterialTheme {
        WgcAlertDialog(
            onDismissRequest = {},
            title = "Atenção",
            message = "Deseja realmente confirmar esta ação no sistema?",
            confirmButtonText = "Confirmar",
            onConfirmClick = {},
            dismissButtonText = "Cancelar",
            onDismissClick = {}
        )
    }
}

