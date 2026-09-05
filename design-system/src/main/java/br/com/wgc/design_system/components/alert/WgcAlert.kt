package br.com.wgc.design_system.components.alert

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.commons.WgcComponentPreviews

enum class AlertType {
    SUCCESS, ERROR, WARNING, INFO
}

/**
 * Componente de Alerta (WgcAlert) inspirado no Material UI / Material 3.
 *
 * Exemplo de uso:
 * ```kotlin
 * WgcAlert(
 *     title = "Sucesso",
 *     message = "Operação realizada com sucesso.",
 *     type = AlertType.SUCCESS,
 *     onDismiss = { /* fechar */ }
 * )
 * ```
 */
@Composable
fun WgcAlert(
    modifier: Modifier = Modifier,
    title: String,
    message: String,
    type: AlertType = AlertType.INFO,
    onDismiss: (() -> Unit)? = null
) {
    val (containerColor, contentColor, icon) = when (type) {
        AlertType.SUCCESS -> Triple(
            MaterialTheme.colorScheme.primaryContainer,
            MaterialTheme.colorScheme.onPrimaryContainer,
            Icons.Default.CheckCircle
        )
        AlertType.ERROR -> Triple(
            MaterialTheme.colorScheme.errorContainer,
            MaterialTheme.colorScheme.onErrorContainer,
            Icons.Default.Error
        )
        AlertType.WARNING -> Triple(
            MaterialTheme.colorScheme.tertiaryContainer,
            MaterialTheme.colorScheme.onTertiaryContainer,
            Icons.Default.Warning
        )
        AlertType.INFO -> Triple(
            MaterialTheme.colorScheme.surfaceVariant,
            MaterialTheme.colorScheme.onSurfaceVariant,
            Icons.Default.Info
        )
    }

    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        color = containerColor,
        contentColor = contentColor
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = WgcCoreDsSpacing.xxs4.dp)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                Text(
                    text = message,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            if (onDismiss != null) {
                IconButton(
                    onClick = onDismiss,
                    modifier = Modifier
                        .size(24.dp)
                        .semantics { role = Role.Button }
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Fechar alerta",
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}

@WgcComponentPreviews
@Composable
private fun WgcAlertPreview() {
    MaterialTheme {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            WgcAlert(title = "Sucesso", message = "Tudo pronto!", type = AlertType.SUCCESS, onDismiss = {})
            WgcAlert(title = "Erro", message = "Falha na conexão.", type = AlertType.ERROR)
            WgcAlert(title = "Atenção", message = "Cuidado ao prosseguir.", type = AlertType.WARNING)
            WgcAlert(title = "Informação", message = "Nova atualização disponível.", type = AlertType.INFO)
        }
    }
}
