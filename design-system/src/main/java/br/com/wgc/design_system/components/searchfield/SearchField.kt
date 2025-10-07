package br.com.wgc.design_system.components.searchfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SearchField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    leadingIcon: ImageVector? = null
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(100),
        leadingIcon = { if (leadingIcon != null) Icon(leadingIcon, null) },
        label = { Text(text = label) },
        maxLines = 1,
        singleLine = true,
        placeholder = { Text(text = "O que você procura?") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun SearchFieldPrev() {
    SearchField(
        value = "",
        onValueChange = {},
        label = "Pesquisar"
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SearchFieldPrev2() {
    SearchField(
        value = "",
        onValueChange = {},
        label = "Pesquisar",
        leadingIcon = Icons.Default.Search
    )
}

