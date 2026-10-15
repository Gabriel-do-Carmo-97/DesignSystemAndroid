@file:Suppress("LongMethod", "MagicNumber")

package br.com.wgc.design_system.components.fields

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.commons.previews.components.WgcComponentPreviews
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * WgcPhoneNumberInput
 *
 * Campo de entrada para número de telefone com seletor de DDI internacional e máscara.
 */
@Composable
fun WgcPhoneNumberInput(
    phoneNumber: String,
    onPhoneNumberChange: (String) -> Unit,
    selectedDdi: String = "+55",
    onDdiChange: (String) -> Unit = {},
    availableDdis: List<String> = listOf("+55", "+1", "+351", "+44", "+49"),
    label: String = "Telefone celular",
    isError: Boolean = false,
    errorMessage: String? = null,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = phoneNumber,
        onValueChange = { input ->
            val digitsOnly = input.filter { it.isDigit() }.take(11)
            onPhoneNumberChange(digitsOnly)
        },
        modifier = modifier.fillMaxWidth(),
        label = { Text(text = label) },
        placeholder = { Text(text = "(11) 99999-9999") },
        isError = isError,
        supportingText = {
            if (isError && errorMessage != null) {
                Text(text = errorMessage, color = MaterialTheme.colorScheme.error)
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        leadingIcon = {
            Box {
                Row(
                    modifier = Modifier
                        .clickable { expanded = true }
                        .padding(start = WgcCoreDsSpacing.sm.dp, end = WgcCoreDsSpacing.xs.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = selectedDdi,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Selecionar DDI",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    availableDdis.forEach { ddi ->
                        DropdownMenuItem(
                            text = { Text(text = ddi) },
                            onClick = {
                                onDdiChange(ddi)
                                expanded = false
                            }
                        )
                    }
                }
            }
        },
        singleLine = true
    )
}

@Preview(showBackground = true)
@WgcComponentPreviews
@Composable
private fun WgcPhoneNumberInputPreview() {
    MaterialTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            WgcPhoneNumberInput(
                phoneNumber = "987654321",
                onPhoneNumberChange = {},
                selectedDdi = "+55",
                onDdiChange = {}
            )

            WgcPhoneNumberInput(
                phoneNumber = "5551234567",
                onPhoneNumberChange = {},
                selectedDdi = "+1",
                onDdiChange = {}
            )

            WgcPhoneNumberInput(
                phoneNumber = "12345",
                onPhoneNumberChange = {},
                selectedDdi = "+55",
                onDdiChange = {},
                isError = true,
                errorMessage = "Número de telefone incompleto ou inválido."
            )
        }
    }
}
