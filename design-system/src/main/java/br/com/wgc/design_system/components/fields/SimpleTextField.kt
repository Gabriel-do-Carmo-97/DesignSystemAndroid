package br.com.wgc.design_system.components.fields

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SimpleTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    onValueChange: (String) -> Unit = {},
    isEnabled: Boolean = true,
    isReadOnly: Boolean = false,
    label: String = "SimpleLabel",
    placeholderText: String = "SimplePlaceholder",
    leadingIcon: ImageVector? = Icons.Default.Info,
    trailingIcon: ImageVector? = null,
    onTrailingIconClick: () -> Unit = {},
    isError: Boolean = false,
    errorMessage: String = "SimpleErrorMessage",
    keyboardType: KeyboardType = KeyboardType.Text,
    isPasswordField: Boolean = false
) {
    var isPasswordVisible by rememberSaveable { mutableStateOf(false) }

    val finalVisualTransformation = when {
        isPasswordField && !isPasswordVisible -> PasswordVisualTransformation()
        isPasswordField && isPasswordVisible -> VisualTransformation.None
        else -> VisualTransformation.None
    }

    val finalTrailingIcon = when {
        isPasswordField -> if (isPasswordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility
        else -> trailingIcon
    }

    val finalOnTrailingIconClick = when {
        isPasswordField -> {
            { isPasswordVisible = !isPasswordVisible }
        }

        else -> onTrailingIconClick
    }
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15),
        leadingIcon = { if (leadingIcon != null) Icon(leadingIcon, null) },
        trailingIcon = {
            finalTrailingIcon?.let { safeIcon ->
                Icon(
                    modifier = Modifier.clickable(
                        onClick = { finalOnTrailingIconClick() }
                    ),
                    imageVector = safeIcon,
                    contentDescription = null
                )
            }
        },
        label = { Text(text = label, fontSize = MaterialTheme.typography.labelSmall.fontSize) },
        maxLines = 1,
        singleLine = true,
        placeholder = { Text(text = placeholderText) },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = ImeAction.Next,
            autoCorrect = true,
            capitalization = KeyboardCapitalization.Sentences,
        ),
        visualTransformation = finalVisualTransformation,
        isError = isError,
        supportingText = if (isError) {
            { Text(text = errorMessage) }
        } else {
            null
        },
        enabled = isEnabled,
        readOnly = isReadOnly,
        colors = OutlinedTextFieldDefaults.colors(
            errorContainerColor = MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.2f),
            errorTextColor = MaterialTheme.colorScheme.onErrorContainer,
            errorLabelColor = MaterialTheme.colorScheme.error,
            errorBorderColor = MaterialTheme.colorScheme.error,
            errorLeadingIconColor = MaterialTheme.colorScheme.error,
            errorTrailingIconColor = MaterialTheme.colorScheme.error,
            errorSupportingTextColor = MaterialTheme.colorScheme.error,
            errorCursorColor = MaterialTheme.colorScheme.error,

            focusedContainerColor = Color.Transparent,
            focusedTextColor = MaterialTheme.colorScheme.onSurface,
            focusedLabelColor = MaterialTheme.colorScheme.primary,
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            focusedLeadingIconColor = MaterialTheme.colorScheme.primary,
            focusedTrailingIconColor = MaterialTheme.colorScheme.primary,
            focusedPlaceholderColor = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    )
}

@Preview(showBackground = true, name = "Only Component isError")
@Composable
private fun SimpleFieldPrev() {
    SimpleTextField(isError = true)
}

@Preview(showBackground = true)
@Composable
private fun SimpleFieldPrev1() {
    SimpleTextField()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SimpleFieldPrev2() {
    SimpleTextField()
}