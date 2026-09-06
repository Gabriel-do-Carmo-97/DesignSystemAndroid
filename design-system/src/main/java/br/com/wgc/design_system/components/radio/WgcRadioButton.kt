package br.com.wgc.design_system.components.radio

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.commons.WgcComponentPreviews

/**
 * Botão de Rádio com Rótulo (WgcRadioButton) baseado no Material 3.
 */
@Composable
fun WgcRadioButton(
    modifier: Modifier = Modifier,
    selected: Boolean,
    label: String,
    onClick: () -> Unit,
    isEnabled: Boolean = true
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .semantics { role = Role.RadioButton }
            .clickable(enabled = isEnabled, onClick = onClick),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
    ) {
        RadioButton(
            selected = selected,
            onClick = null,
            enabled = isEnabled
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@WgcComponentPreviews
@Composable
private fun WgcRadioButtonAllStatesPreview() {
    MaterialTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            WgcRadioButton(selected = true, label = "Selecionado & Habilitado", onClick = {}, isEnabled = true)
            WgcRadioButton(selected = false, label = "Não Selecionado & Habilitado", onClick = {}, isEnabled = true)
            WgcRadioButton(selected = true, label = "Selecionado & Desabilitado", onClick = {}, isEnabled = false)
            WgcRadioButton(selected = false, label = "Não Selecionado & Desabilitado", onClick = {}, isEnabled = false)
        }
    }
}
