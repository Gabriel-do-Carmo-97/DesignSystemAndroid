package br.com.wgc.design_system.components.buttons

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics

/**
 * Botão de ícone do Design System (WgcIconButton) baseado no Material 3.
 */
@Composable
fun WgcIconButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    icon: ImageVector,
    contentDescription: String,
    isEnabled: Boolean = true
) {
    IconButton(
        onClick = onClick,
        enabled = isEnabled,
        modifier = modifier.semantics { role = Role.Button }
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription
        )
    }
}
