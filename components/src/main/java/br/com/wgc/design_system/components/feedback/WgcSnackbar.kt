package br.com.wgc.design_system.components.feedback

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Componente de Snackbar do Design System (WgcSnackbar) baseado no Material 3.
 */
@Composable
fun WgcSnackbar(
    modifier: Modifier = Modifier,
    message: String,
    actionLabel: String? = null,
    onActionClick: (() -> Unit)? = null
) {
    Snackbar(
        modifier = modifier,
        action = if (actionLabel != null && onActionClick != null) {
            {
                TextButton(onClick = onActionClick) {
                    Text(text = actionLabel)
                }
            }
        } else null
    ) {
        Text(text = message)
    }
}
