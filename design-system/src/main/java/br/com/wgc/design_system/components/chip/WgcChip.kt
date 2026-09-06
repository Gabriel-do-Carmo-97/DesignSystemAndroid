package br.com.wgc.design_system.components.chip

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.commons.WgcComponentPreviews

/**
 * Componente de Chip (WgcChip) inspirado no Material UI / Material 3.
 */
@Composable
fun WgcChip(
    modifier: Modifier = Modifier,
    label: String,
    selected: Boolean = false,
    isEnabled: Boolean = true,
    leadingIcon: ImageVector? = null,
    onClick: () -> Unit
) {
    val stateDesc = if (selected) "Selecionado" else "Não selecionado"

    FilterChip(
        selected = selected,
        onClick = onClick,
        enabled = isEnabled,
        label = { Text(text = label) },
        modifier = modifier
            .semantics(mergeDescendants = true) {
                role = Role.Checkbox
                stateDescription = stateDesc
            },
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else if (leadingIcon != null) {
            {
                Icon(
                    imageVector = leadingIcon,
                    contentDescription = null,
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        }
    )
}

@WgcComponentPreviews
@Composable
private fun WgcChipPreview() {
    MaterialTheme {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            WgcChip(label = "Todos", selected = true, onClick = {})
            WgcChip(label = "Favoritos", selected = false, onClick = {})
            WgcChip(label = "Desabilitado", selected = false, isEnabled = false, onClick = {})
        }
    }
}
