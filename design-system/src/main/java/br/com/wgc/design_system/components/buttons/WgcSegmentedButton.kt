package br.com.wgc.design_system.components.buttons

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

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
