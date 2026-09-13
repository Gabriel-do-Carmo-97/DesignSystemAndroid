package br.com.wgc.design_system.components.fields

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.auth.WgcOtpCodeInput

/**
 * Tipos de campos suportados pela WgcFieldFactory.
 */
enum class WgcFieldType {
    Standard,
    Search,
    Password,
    OtpCode
}

/**
 * Fábrica Universal de Campos de Entrada do Design System (WgcFieldFactory).
 * Provê alternância imediata entre [WgcFieldType] com defaults prontos para produção
 * e suporte a custom slot replacement ([customFieldSlot]).
 */
@Composable
fun WgcFieldFactory(
    modifier: Modifier = Modifier,
    type: WgcFieldType = WgcFieldType.Standard,
    value: String = "",
    onValueChange: (String) -> Unit = {},
    label: String = "Campo",
    placeholderText: String = "Digite aqui...",
    isEnabled: Boolean = true,
    isReadOnly: Boolean = false,
    isError: Boolean = false,
    errorMessage: String = "",
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    onTrailingIconClick: () -> Unit = {},
    customFieldSlot: (@Composable () -> Unit)? = null
) {
    if (customFieldSlot != null) {
        customFieldSlot()
        return
    }

    when (type) {
        WgcFieldType.Standard -> {
            SimpleTextField(
                modifier = modifier,
                value = value,
                onValueChange = onValueChange,
                isEnabled = isEnabled,
                isReadOnly = isReadOnly,
                label = label,
                placeholderText = placeholderText,
                leadingIcon = leadingIcon,
                trailingIcon = trailingIcon,
                onTrailingIconClick = onTrailingIconClick,
                isError = isError,
                errorMessage = errorMessage,
                isPasswordField = false
            )
        }
        WgcFieldType.Search -> {
            SearchTextField(
                modifier = modifier,
                value = value,
                onValueChange = onValueChange,
                label = if (label == "Campo") "Buscar" else label,
                leadingIcon = leadingIcon ?: Icons.Default.Search
            )
        }
        WgcFieldType.Password -> {
            SimpleTextField(
                modifier = modifier,
                value = value,
                onValueChange = onValueChange,
                isEnabled = isEnabled,
                isReadOnly = isReadOnly,
                label = if (label == "Campo") "Senha" else label,
                placeholderText = if (placeholderText == "Digite aqui...") "Digite sua senha" else placeholderText,
                leadingIcon = leadingIcon ?: Icons.Default.Lock,
                isError = isError,
                errorMessage = errorMessage,
                isPasswordField = true
            )
        }
        WgcFieldType.OtpCode -> {
            WgcOtpCodeInput(
                modifier = modifier,
                otpCode = value,
                onOtpCodeChange = onValueChange
            )
        }
    }
}

@Preview(name = "WgcFieldFactory - All Types", showBackground = true)
@Composable
private fun WgcFieldFactoryPreview() {
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            WgcFieldFactory(type = WgcFieldType.Standard, value = "Texto Padrão")
            WgcFieldFactory(type = WgcFieldType.Search, value = "")
            WgcFieldFactory(type = WgcFieldType.Password, value = "secret123")
            WgcFieldFactory(type = WgcFieldType.OtpCode, value = "491823")
        }
    }
}
