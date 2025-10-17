package br.com.wgc.design_system.components.checkbox

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun CheckboxDefaults(
    modifier: Modifier = Modifier,
    label: String = "Checkbox",
    isEnabled: Boolean = true,
    checked: Boolean = false,
    onCheckedChange: (Boolean) -> Unit = {},
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                enabled = isEnabled,
                onClick = { onCheckedChange(!checked) }
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Checkbox(
            modifier = Modifier.size(24.dp),
            checked = checked,
            onCheckedChange = null,
            enabled = isEnabled,
            colors = CheckboxDefaults.colors(
                checkedColor = MaterialTheme.colorScheme.primary,
                checkmarkColor = MaterialTheme.colorScheme.onPrimary,
                uncheckedColor = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        )
        Text(
            text = label,
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Preview(showBackground = true, name = "Checkbox Default")
@Composable
private fun CheckBoxDefaultPreview() {
    MaterialTheme {
        CheckboxDefaults(label = "Opção Aceita", checked = true)
    }
}

@Preview(showBackground = true, name = "Checkbox Disabled")
@Composable
private fun CheckBoxDisabledPreview() {
    MaterialTheme {
        CheckboxDefaults(label = "Opção Desabilitada", checked = false, isEnabled = false)
    }
}
