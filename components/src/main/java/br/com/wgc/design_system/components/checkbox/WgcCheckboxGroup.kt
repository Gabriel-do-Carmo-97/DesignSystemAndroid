@file:Suppress("LongMethod")

package br.com.wgc.design_system.components.checkbox

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing
import br.com.wgc.design_system.commons.previews.multi.theme.ThemePreviews
import br.com.wgc.design_system.theme.WgcTheme

/**
 * WgcCheckboxGroup
 *
 * Agrupador semântico de checkboxes com opção mestre "Selecionar Todos" (com suporte a estado indeterminado).
 */
@Composable
fun WgcCheckboxGroup(
    items: List<String>,
    selectedItems: Set<String>,
    onSelectionChange: (Set<String>) -> Unit,
    modifier: Modifier = Modifier,
    enableSelectAll: Boolean = true,
    selectAllLabel: String = "Selecionar todos"
) {
    val parentState = when {
        selectedItems.isEmpty() -> ToggleableState.Off
        selectedItems.size == items.size -> ToggleableState.On
        else -> ToggleableState.Indeterminate
    }

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.XS.dp)
    ) {
        if (enableSelectAll) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        if (parentState == ToggleableState.On) {
                            onSelectionChange(emptySet())
                        } else {
                            onSelectionChange(items.toSet())
                        }
                    }
                    .padding(vertical = WgcCoreDsSpacing.XS.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TriStateCheckbox(
                    state = parentState,
                    onClick = null
                )
                Text(
                    text = selectAllLabel,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(start = WgcCoreDsSpacing.SM.dp)
                )
            }
        }

        items.forEach { item ->
            val isChecked = selectedItems.contains(item)
            CheckboxDefaults(
                label = item,
                checked = isChecked,
                onCheckedChange = { checked ->
                    val newSet = selectedItems.toMutableSet()
                    if (checked) newSet.add(item) else newSet.remove(item)
                    onSelectionChange(newSet)
                }
            )
        }
    }
}

@ThemePreviews
@Composable
private fun WgcCheckboxGroupPreview() {
    WgcTheme {
        Column(modifier = Modifier.padding(16.dp)) {
            WgcCheckboxGroup(
                items = listOf("Item 1", "Item 2", "Item 3"),
                selectedItems = setOf("Item 1"),
                onSelectionChange = {}
            )
        }
    }
}
