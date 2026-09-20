package br.com.wgc.design_system.components.snackbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.commons.WgcComponentPreviews

/**
 * Variantes semânticas para o WgcSnackbar.
 */
enum class WgcSnackbarVariant {
    Default,
    Success,
    Error,
    Info
}

/**
 * WgcSnackbar
 *
 * Componente visual de notificação snackbar corporativo.
 *
 * @param message Mensagem de texto principal.
 * @param modifier Modificador de layout.
 * @param actionLabel Rótulo opcional para o botão de ação.
 * @param onActionClick Callback acionado ao clicar na ação.
 * @param withDismissAction Exibe botão com ícone de fechar.
 * @param onDismissClick Callback acionado ao clicar no botão de fechar.
 * @param variant Variante visual (Default, Success, Error, Info).
 */
@Composable
fun WgcSnackbar(
    message: String,
    modifier: Modifier = Modifier,
    actionLabel: String? = null,
    onActionClick: (() -> Unit)? = null,
    withDismissAction: Boolean = false,
    onDismissClick: (() -> Unit)? = null,
    variant: WgcSnackbarVariant = WgcSnackbarVariant.Default
) {
    val (containerColor, contentColor, icon) = when (variant) {
        WgcSnackbarVariant.Default -> Triple(
            MaterialTheme.colorScheme.inverseSurface,
            MaterialTheme.colorScheme.inverseOnSurface,
            null
        )
        WgcSnackbarVariant.Success -> Triple(
            MaterialTheme.colorScheme.primaryContainer,
            MaterialTheme.colorScheme.onPrimaryContainer,
            Icons.Default.CheckCircle
        )
        WgcSnackbarVariant.Error -> Triple(
            MaterialTheme.colorScheme.errorContainer,
            MaterialTheme.colorScheme.onErrorContainer,
            Icons.Default.Error
        )
        WgcSnackbarVariant.Info -> Triple(
            MaterialTheme.colorScheme.surfaceVariant,
            MaterialTheme.colorScheme.onSurfaceVariant,
            Icons.Default.Info
        )
    }

    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        color = containerColor,
        contentColor = contentColor,
        tonalElevation = WgcCoreDsSpacing.xxs4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = WgcCoreDsSpacing.md16.dp,
                    vertical = WgcCoreDsSpacing.sm12.dp
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
        ) {
            if (icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = contentColor
                )
            }

            Text(
                text = message,
                style = MaterialTheme.typography.bodyMedium,
                color = contentColor,
                modifier = Modifier.weight(1f)
            )

            if (!actionLabel.isNullOrBlank() && onActionClick != null) {
                TextButton(onClick = onActionClick) {
                    Text(
                        text = actionLabel,
                        style = MaterialTheme.typography.labelLarge,
                        color = if (variant == WgcSnackbarVariant.Default) {
                            MaterialTheme.colorScheme.inversePrimary
                        } else {
                            contentColor
                        }
                    )
                }
            }

            if (withDismissAction && onDismissClick != null) {
                IconButton(onClick = onDismissClick) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Fechar notificação",
                        tint = contentColor
                    )
                }
            }
        }
    }
}

/**
 * WgcSnackbarHost
 *
 * Host corporativo para exibição de Snackbars estilizados com o Design System WGC.
 *
 * @param hostState Estado do snackbar host gerenciado pelo Compose.
 * @param modifier Modificador de layout.
 */
@Composable
fun WgcSnackbarHost(
    hostState: SnackbarHostState,
    modifier: Modifier = Modifier,
    variant: WgcSnackbarVariant = WgcSnackbarVariant.Default
) {
    SnackbarHost(
        hostState = hostState,
        modifier = modifier
    ) { snackbarData: SnackbarData ->
        WgcSnackbar(
            message = snackbarData.visuals.message,
            actionLabel = snackbarData.visuals.actionLabel,
            onActionClick = { snackbarData.performAction() },
            withDismissAction = snackbarData.visuals.withDismissAction,
            onDismissClick = { snackbarData.dismiss() },
            variant = variant
        )
    }
}

@WgcComponentPreviews
@Composable
private fun WgcSnackbarPreview() {
    MaterialTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(WgcCoreDsSpacing.md16.dp),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
            ) {
                WgcSnackbar(
                    message = "Item adicionado ao carrinho com sucesso.",
                    actionLabel = "Desfazer",
                    onActionClick = {},
                    variant = WgcSnackbarVariant.Default
                )
                WgcSnackbar(
                    message = "Transação PIX concluída com sucesso.",
                    variant = WgcSnackbarVariant.Success
                )
                WgcSnackbar(
                    message = "Não foi possível conectar ao servidor.",
                    withDismissAction = true,
                    onDismissClick = {},
                    variant = WgcSnackbarVariant.Error
                )
            }
        }
    }
}
