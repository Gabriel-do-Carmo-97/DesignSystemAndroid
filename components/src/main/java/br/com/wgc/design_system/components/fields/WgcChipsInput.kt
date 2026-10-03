@file:Suppress("LongMethod")

package br.com.wgc.design_system.components.fields

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChip
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * WgcChipsInput
 *
 * Campo de texto que converte termos digitados em chips interativos removíveis (tags).
 *
 * @param chips Lista de tags adicionadas.
 * @param onChipAdded Callback quando um novo chip é adicionado.
 * @param onChipRemoved Callback quando um chip é removido.
 * @param label Rótulo do campo.
 * @param placeholder Placeholder do campo.
 * @param modifier Modificador de layout.
 */
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun WgcChipsInput(
    chips: List<String>,
    onChipAdded: (String) -> Unit,
    onChipRemoved: (String) -> Unit,
    label: String = "Tags",
    placeholder: String = "Digite e pressione Enter...",
    modifier: Modifier = Modifier
) {
    var textInput by remember { mutableStateOf("") }

    val submitTag = {
        val trimmed = textInput.trim()
        if (trimmed.isNotEmpty() && !chips.contains(trimmed)) {
            onChipAdded(trimmed)
            textInput = ""
        }
    }

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm.dp)
    ) {
        OutlinedTextField(
            value = textInput,
            onValueChange = { textInput = it },
            label = { Text(text = label) },
            placeholder = { Text(text = placeholder) },
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                IconButton(onClick = submitTag) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Adicionar tag")
                }
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { submitTag() }),
            singleLine = true
        )

        if (chips.isNotEmpty()) {
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs.dp),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs.dp)
            ) {
                chips.forEach { chip ->
                    InputChip(
                        selected = false,
                        onClick = { },
                        label = { Text(text = chip) },
                        trailingIcon = {
                            IconButton(onClick = { onChipRemoved(chip) }) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "Remover $chip"
                                )
                            }
                        }
                    )
                }
            }
        }
    }
}
