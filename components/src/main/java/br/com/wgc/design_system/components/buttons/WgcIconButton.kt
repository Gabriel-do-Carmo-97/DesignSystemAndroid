package br.com.wgc.design_system.components.buttons

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Warning
import br.com.wgc.design_system.commons.previews.multi.theme.ThemePreviews
import br.com.wgc.design_system.theme.WgcTheme

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

@ThemePreviews
@Composable
private fun WgcIconButtonPreview() {
    WgcTheme {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            WgcIconButton(
                onClick = {},
                icon = Icons.Default.Info,
                contentDescription = "Informação"
            )
            WgcIconButton(
                onClick = {},
                icon = Icons.Default.Warning,
                contentDescription = "Aviso",
                isEnabled = false
            )
        }
    }
}
