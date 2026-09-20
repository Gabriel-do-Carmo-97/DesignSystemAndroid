@file:Suppress("MatchingDeclarationName")

package br.com.wgc.design_system.components.feedback

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.commons.WgcComponentPreviews
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Variantes semânticas para o [WgcSnackbar].
 */
enum class WgcSnackbarVariant {
    Default,
    Success,
    Error,
    Warning,
    Info
}

/**
 * Componente de Snackbar corporativo do Design System (WgcSnackbar).
 *
 * Suporta variantes semânticas (Default, Success, Error, Warning, Info), ícones contextuais,
 * ações customizadas e respeita rigorosamente as diretrizes de State Hoisting e tokens SSOT.
 */
@Suppress("LongMethod")
@Composable
fun WgcSnackbar(
    modifier: Modifier = Modifier,
    message: String,
    actionLabel: String? = null,
    onActionClick: (() -> Unit)? = null,
    variant: WgcSnackbarVariant = WgcSnackbarVariant.Default,
    icon: (@Composable () -> Unit)? = null,
    dismissAction: (@Composable () -> Unit)? = null
) {
    val (containerColor, contentColor, defaultIcon) = when (variant) {
        WgcSnackbarVariant.Default -> Triple(
            SnackbarDefaults.color,
            SnackbarDefaults.contentColor,
            null
        )
        WgcSnackbarVariant.Success -> Triple(
            MaterialTheme.colorScheme.tertiaryContainer,
            MaterialTheme.colorScheme.onTertiaryContainer,
            Icons.Default.CheckCircle
        )
        WgcSnackbarVariant.Error -> Triple(
            MaterialTheme.colorScheme.errorContainer,
            MaterialTheme.colorScheme.onErrorContainer,
            Icons.Default.Error
        )
        WgcSnackbarVariant.Warning -> Triple(
            MaterialTheme.colorScheme.secondaryContainer,
            MaterialTheme.colorScheme.onSecondaryContainer,
            Icons.Default.Warning
        )
        WgcSnackbarVariant.Info -> Triple(
            MaterialTheme.colorScheme.surfaceVariant,
            MaterialTheme.colorScheme.onSurfaceVariant,
            Icons.Default.Info
        )
    }

    Snackbar(
        modifier = modifier,
        containerColor = containerColor,
        contentColor = contentColor,
        actionContentColor = contentColor,
        dismissAction = dismissAction,
        action = if (actionLabel != null && onActionClick != null) {
            {
                TextButton(onClick = onActionClick) {
                    Text(text = actionLabel, color = contentColor)
                }
            }
        } else null
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
        ) {
            if (icon != null) {
                icon()
            } else if (defaultIcon != null) {
                Icon(
                    imageVector = defaultIcon,
                    contentDescription = null,
                    tint = contentColor,
                    modifier = Modifier.size(20.dp)
                )
            }
            Text(text = message, style = MaterialTheme.typography.bodyMedium, color = contentColor)
        }
    }
}

@Preview(showBackground = true)
@WgcComponentPreviews
@Composable
private fun WgcSnackbarDefaultPreview() {
    MaterialTheme {
        WgcSnackbar(
            message = "Operação realizada com sucesso!",
            actionLabel = "Desfazer",
            onActionClick = {},
            variant = WgcSnackbarVariant.Default
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcSnackbarSuccessPreview() {
    MaterialTheme {
        WgcSnackbar(
            message = "Item adicionado ao carrinho!",
            variant = WgcSnackbarVariant.Success
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcSnackbarErrorPreview() {
    MaterialTheme {
        WgcSnackbar(
            message = "Falha de conexão com o servidor.",
            actionLabel = "Tentar Novamente",
            onActionClick = {},
            variant = WgcSnackbarVariant.Error
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcSnackbarWarningPreview() {
    MaterialTheme {
        WgcSnackbar(
            message = "Sua sessão expira em 5 minutos.",
            variant = WgcSnackbarVariant.Warning
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcSnackbarInfoPreview() {
    MaterialTheme {
        WgcSnackbar(
            message = "Nova versão 1.1.0 disponível para download.",
            actionLabel = "Atualizar",
            onActionClick = {},
            variant = WgcSnackbarVariant.Info
        )
    }
}
