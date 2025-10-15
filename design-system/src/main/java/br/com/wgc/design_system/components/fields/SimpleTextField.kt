package br.com.wgc.design_system.components.fields

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.R

@Composable
fun SimpleTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    onValueChange: (String) -> Unit = {},
    isEnabled: Boolean = true,
    isReadOnly: Boolean = false,
    label: String = "SimpleLabel",
    placeholderText: String = "SimplePlaceholder",
    leadingIcon: ImageVector? = ImageVector.vectorResource(id = R.drawable.baseline_add_box_24),
    isError: Boolean = false,
    errorMessage: String = "SimpleErrorMessage",
    color: Color = Color.Green,
    keyboardType: KeyboardType = KeyboardType.Text,
){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15),
        leadingIcon = { if (leadingIcon != null) Icon(leadingIcon, null) },
        label = { Text(text = label) },
        maxLines = 1,
        singleLine = true,
        placeholder = { Text(text = placeholderText) },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = ImeAction.Next,
            autoCorrect = true,
            capitalization = KeyboardCapitalization.Sentences,
        ),
        isError = isError,
        supportingText = if (isError) { { Text(text = errorMessage) } } else { null },
        enabled = isEnabled,
        readOnly = isReadOnly,
        colors = OutlinedTextFieldDefaults.colors(
            errorTextColor = Color.Red,
            errorLabelColor = Color.Red,
            errorCursorColor = Color.Red,
            errorBorderColor = Color.Red,
            errorContainerColor = Color.Red.copy(alpha = 0.1f),
            errorLeadingIconColor = Color.Red,
            errorTrailingIconColor = Color.Red,

            focusedContainerColor = Color.Transparent,
            focusedTextColor = Color.Black,
            focusedLabelColor = color,
            focusedBorderColor = color,
            focusedPlaceholderColor = Color.LightGray,
        )
    )
}

@Preview(showBackground = true, name = "Only Component isError" )
@Composable
private fun SimpleFieldPrev() {
    SimpleTextField(isError = true)
}

@Preview(showBackground = true, )
@Composable
private fun SimpleFieldPrev1() {
    SimpleTextField()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SimpleFieldPrev2() {
    SimpleTextField()
}