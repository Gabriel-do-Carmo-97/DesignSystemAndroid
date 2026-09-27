package br.com.wgc.design_system.components.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.commons.WgcComponentPreviews
import br.com.wgc.design_system.components.badge.WgcBadge
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Modelo de item para menus suspensos corporativos (WgcDropdownItem).
 */
data class WgcDropdownItem(
    val id: String,
    val title: String,
    val leadingIcon: ImageVector? = null,
    val badgeCount: Int? = null,
    val isDestructive: Boolean = false,
    val enabled: Boolean = true,
    val onClick: () -> Unit = {}
)

/**
 * Menu Suspenso Corporativo (WgcDropdownMenu).
 * Implementa tokens semânticos de cores, tipografia e slots de ícones/badges.
 *
 * @param expanded Controla a visibilidade do menu.
 * @param onDismissRequest Ação disparada ao fechar o menu.
 * @param items Lista de [WgcDropdownItem] a serem renderizados.
 * @param modifier Modificador de layout.
 */
@Composable
fun WgcDropdownMenu(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    items: List<WgcDropdownItem>,
    modifier: Modifier = Modifier
) {
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismissRequest,
        modifier = modifier
    ) {
        items.forEach { item ->
            DropdownMenuItem(
                text = {
                    Text(
                        text = item.title,
                        color = if (item.isDestructive) {
                            MaterialTheme.colorScheme.error
                        } else {
                            MaterialTheme.colorScheme.onSurface
                        },
                        style = MaterialTheme.typography.bodyMedium
                    )
                },
                onClick = {
                    item.onClick()
                    onDismissRequest()
                },
                leadingIcon = item.leadingIcon?.let { icon ->
                    {
                        Icon(
                            imageVector = icon,
                            contentDescription = null,
                            tint = if (item.isDestructive) {
                                MaterialTheme.colorScheme.error
                            } else {
                                MaterialTheme.colorScheme.onSurfaceVariant
                            }
                        )
                    }
                },
                trailingIcon = item.badgeCount?.let { count ->
                    {
                        WgcBadge(count = count)
                    }
                },
                enabled = item.enabled
            )
        }
    }
}

@Preview(showBackground = true)
@WgcComponentPreviews
@Composable
private fun WgcDropdownMenuPreview() {
    MaterialTheme {
        Surface {
            val sampleItems = listOf(
                WgcDropdownItem(id = "edit", title = "Editar Perfil", leadingIcon = Icons.Default.Edit),
                WgcDropdownItem(id = "share", title = "Compartilhar", leadingIcon = Icons.Default.Share, badgeCount = 1),
                WgcDropdownItem(id = "delete", title = "Excluir Conta", leadingIcon = Icons.Default.Delete, isDestructive = true)
            )
            WgcDropdownMenu(
                expanded = true,
                onDismissRequest = {},
                items = sampleItems,
                modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)
            )
        }
    }
}
