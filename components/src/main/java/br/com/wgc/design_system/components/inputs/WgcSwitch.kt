package br.com.wgc.design_system.components.inputs

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.commons.WgcComponentPreviews

/**
 * Componente de Switch (WgcSwitch) baseado no Material 3.
 */
@Composable
fun WgcSwitch(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    isEnabled: Boolean = true
) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        enabled = isEnabled,
        modifier = modifier.semantics { role = Role.Switch }
    )
}

@WgcComponentPreviews
@Composable
private fun WgcSwitchAllStatesPreview() {
    MaterialTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                Text("Ativado & Habilitado")
                WgcSwitch(checked = true, onCheckedChange = {}, isEnabled = true)
            }
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                Text("Desativado & Habilitado")
                WgcSwitch(checked = false, onCheckedChange = {}, isEnabled = true)
            }
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                Text("Ativado & Desabilitado")
                WgcSwitch(checked = true, onCheckedChange = {}, isEnabled = false)
            }
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                Text("Desativado & Desabilitado")
                WgcSwitch(checked = false, onCheckedChange = {}, isEnabled = false)
            }
        }
    }
}
