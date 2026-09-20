package br.com.wgc.design_system.components.inputs

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.design_system.commons.WgcComponentPreviews
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Componente corporativo para entrada de código PIN ou OTP (One-Time Password) de 4 ou 6 dígitos.
 *
 * Utiliza State Hoisting estrito, suporta mascaramento para senhas numéricas, indicação de foco ativo,
 * tratamento de erros com mensagem contextual e integração com teclado numérico.
 *
 * @param otpValue Valor textual atual do OTP.
 * @param onOtpChange Callback disparado a cada dígito alterado (comprimento limitado a [length]).
 * @param modifier Modificador de layout.
 * @param length Quantidade total de células numéricas (padrão: 6).
 * @param isMasked Se verdadeiro, oculta os dígitos com o caractere bullet '●'.
 * @param isError Indica se o estado atual é de erro ou validação inválida.
 * @param errorMessage Mensagem de erro descritiva exibida abaixo das células.
 * @param enabled Habilita ou desabilita a interação com o campo.
 */
@Suppress("LongMethod", "CyclomaticComplexMethod")
@Composable
fun WgcOtpInput(
    otpValue: String,
    onOtpChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    length: Int = 6,
    isMasked: Boolean = false,
    isError: Boolean = false,
    errorMessage: String? = null,
    enabled: Boolean = true
) {
    val focusRequester = remember { FocusRequester() }

    Column(modifier = modifier) {
        BasicTextField(
            value = otpValue,
            onValueChange = { newValue ->
                val digitsOnly = newValue.filter { it.isDigit() }
                if (digitsOnly.length <= length) {
                    onOtpChange(digitsOnly)
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = if (isMasked) KeyboardType.NumberPassword else KeyboardType.Number
            ),
            enabled = enabled,
            modifier = Modifier.focusRequester(focusRequester),
            decorationBox = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp, Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    repeat(length) { index ->
                        val char = otpValue.getOrNull(index)
                        val isFocused = otpValue.length == index
                        WgcOtpCell(
                            char = char,
                            isFocused = isFocused,
                            isMasked = isMasked,
                            isError = isError
                        )
                    }
                }
            }
        )

        if (isError && !errorMessage.isNullOrBlank()) {
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
            Text(
                text = errorMessage,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
private fun WgcOtpCell(
    char: Char?,
    isFocused: Boolean,
    isMasked: Boolean,
    isError: Boolean
) {
    val borderColor = when {
        isError -> MaterialTheme.colorScheme.error
        isFocused -> MaterialTheme.colorScheme.primary
        char != null -> MaterialTheme.colorScheme.outline
        else -> MaterialTheme.colorScheme.outlineVariant
    }

    val shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp)

    Surface(
        modifier = Modifier
            .size(48.dp)
            .border(width = if (isFocused || isError) 2.dp else 1.dp, color = borderColor, shape = shape),
        shape = shape,
        color = MaterialTheme.colorScheme.surface
    ) {
        Box(
            modifier = Modifier.size(48.dp),
            contentAlignment = Alignment.Center
        ) {
            val displayText = when {
                char == null -> ""
                isMasked -> "●"
                else -> char.toString()
            }

            Text(
                text = displayText,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                ),
                textAlign = TextAlign.Center,
                color = if (isError) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Preview(showBackground = true)
@WgcComponentPreviews
@Composable
private fun WgcOtpInputPreview() {
    MaterialTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            WgcOtpInput(
                otpValue = "123",
                onOtpChange = {},
                length = 6
            )

            WgcOtpInput(
                otpValue = "1234",
                onOtpChange = {},
                length = 4,
                isMasked = true
            )

            WgcOtpInput(
                otpValue = "987",
                onOtpChange = {},
                length = 6,
                isError = true,
                errorMessage = "Código de verificação incorreto."
            )
        }
    }
}
