package br.com.wgc.design_system.components.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.commons.WgcComponentPreviews

/**
 * Grupo de botões segmentados do Design System (WgcSegmentedButton) baseado no Material 3.
 */
@Composable
fun WgcSegmentedButton(
    modifier: Modifier = Modifier,
    options: List<String>,
    selectedIndex: Int,
    onOptionSelected: (Int) -> Unit
) {
    SingleChoiceSegmentedButtonRow(modifier = modifier) {
        options.forEachIndexed { index, label ->
            SegmentedButton(
                selected = selectedIndex == index,
                onClick = { onOptionSelected(index) },
                shape = SegmentedButtonDefaults.itemShape(index = index, count = options.size)
            ) {
                Text(text = label)
            }
        }
    }
}

@WgcComponentPreviews
@Composable
private fun WgcSegmentedButtonPreview() {
    MaterialTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            WgcSegmentedButton(
                options = listOf("Opção 1", "Opção 2", "Opção 3"),
                selectedIndex = 0,
                onOptionSelected = {}
            )
        }
    }
}
