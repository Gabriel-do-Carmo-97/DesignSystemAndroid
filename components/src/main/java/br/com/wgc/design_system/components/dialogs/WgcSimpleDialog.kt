package br.com.wgc.design_system.components.dialogs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsSpacing

@Composable
fun WgcSimpleDialog(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    title: String,
    options: List<String>,
    onOptionSelected: (String) -> Unit
) {
    androidx.compose.ui.window.Dialog(onDismissRequest = onDismissRequest) {
        Surface(
            modifier = modifier,
            shape = MaterialTheme.shapes.extraLarge,
            tonalElevation = AlertDialogDefaults.TonalElevation
        ) {
            Column(modifier = Modifier.padding(WgcCoreDsSpacing.lg24.dp)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(bottom = WgcCoreDsSpacing.md16.dp)
                )
                options.forEach { option ->
                    ListItem(
                        headlineContent = { Text(text = option) },
                        modifier = Modifier.clickable {
                            onOptionSelected(option)
                            onDismissRequest()
                        }
                    )
                }
            }
        }
    }
}
