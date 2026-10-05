package br.com.wgc.design_system.components.security

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

/**
 * Diálogo de alerta corporativo exibido ao detectar ambiente rooteado ou adulterado (OWASP MASVS).
 */
@Composable
fun WgcRootDetectionDialog(
    onAcknowledgeRisk: () -> Unit,
    onExitApp: () -> Unit,
    title: String = "Alerta de Segurança",
    message: String = "Identificamos que seu dispositivo possui privilégios de administrador (Root). " +
        "Por razões de segurança financeira, algumas funções podem ser restritas."
) {
    AlertDialog(
        onDismissRequest = {},
        icon = {
            Icon(
                imageVector = Icons.Default.Warning,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.error
            )
        },
        title = { Text(text = title) },
        text = { Text(text = message) },
        confirmButton = {
            TextButton(onClick = onAcknowledgeRisk) {
                Text(text = "Prosseguir por Minha Conta")
            }
        },
        dismissButton = {
            TextButton(onClick = onExitApp) {
                Text(text = "Sair do Aplicativo")
            }
        }
    )
}
