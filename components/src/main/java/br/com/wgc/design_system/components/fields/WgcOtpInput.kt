package br.com.wgc.design_system.components.fields

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.commons.WgcComponentPreviews
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Campo de Entrada de Código PIN / OTP Corporativo (WgcOtpInput).
 * Suporta State Hoisting estrito, máscara de segurança, estados de erro e tamanho configurável (4 a 6 dígitos).
 *
 * @param otpValue Valor textual atual dos dígitos inseridos.
 * @param onOtpChange Callback disparado ao alterar o valor.
 * @param modifier Modificador de layout.
 * @param otpLength Quantidade de dígitos (padrão: 6).
 * @param isMasked Define se os dígitos são ocultados por uma máscara de segurança (ex: "•").
 * @param isError Define se o componente reflete estado de código inválido.
 * @param enabled Define se o campo aceita interação.
 */
@Composable
fun WgcOtpInput(
    otpValue: String,
    onOtpChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    otpLength: Int = 6,
    isMasked: Boolean = false,
    isError: Boolean = false,
    enabled: Boolean = true
) {
    BasicTextField(
        value = otpValue,
        onValueChange = { newValue ->
            if (newValue.length <= otpLength && newValue.all { it.isDigit() }) {
                onOtpChange(newValue)
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        enabled = enabled,
        modifier = modifier,
        decorationBox = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(otpLength) { index ->
                    val char = otpValue.getOrNull(index)
                    val isFocused = otpValue.length == index

                    val borderColor = when {
                        isError -> MaterialTheme.colorScheme.error
                        isFocused -> MaterialTheme.colorScheme.primary
                        char != null -> MaterialTheme.colorScheme.outline
                        else -> MaterialTheme.colorScheme.outlineVariant
                    }

                    val displayChar = when {
                        char == null -> ""
                        isMasked -> "•"
                        else -> char.toString()
                    }

                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .border(
                                width = if (isFocused) 2.dp else 1.dp,
                                color = borderColor,
                                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = displayChar,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = if (isError) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@WgcComponentPreviews
@Composable
private fun WgcOtpInputPreview() {
    MaterialTheme {
        Surface {
            WgcOtpInput(
                otpValue = "123",
                onOtpChange = {},
                otpLength = 6
            )
        }
    }
}
