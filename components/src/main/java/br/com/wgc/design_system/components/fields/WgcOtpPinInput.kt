package br.com.wgc.design_system.components.fields

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Campo corporativo de código PIN/OTP com caixas visuais independentes por dígito.
 *
 * @param value Código digitado atual.
 * @param onValueChange Callback de atualização de texto.
 * @param modifier Modificador de layout.
 * @param length Quantidade de dígitos (padrão: 6).
 * @param isError Se o campo está em estado de erro.
 * @param isMasked Se deve ocultar os dígitos com ponto '•' (para senhas/PIN sensível).
 */
@Composable
fun WgcOtpPinInput(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    length: Int = 6,
    isError: Boolean = false,
    isMasked: Boolean = false
) {
    val focusRequester = remember { FocusRequester() }

    BasicTextField(
        value = value,
        onValueChange = { input ->
            if (input.length <= length && input.all { it.isDigit() }) {
                onValueChange(input)
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        modifier = modifier.focusRequester(focusRequester),
        decorationBox = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(length) { index ->
                    val char = value.getOrNull(index)
                    val isFocused = value.length == index

                    val borderColor = when {
                        isError -> MaterialTheme.colorScheme.error
                        isFocused -> MaterialTheme.colorScheme.primary
                        char != null -> MaterialTheme.colorScheme.outline
                        else -> MaterialTheme.colorScheme.outlineVariant
                    }

                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .border(
                                width = if (isFocused) 2.dp else 1.dp,
                                color = borderColor,
                                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp)
                            )
                            .clickable { focusRequester.requestFocus() },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = when {
                                char == null -> ""
                                isMasked -> "•"
                                else -> char.toString()
                            },
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    )
}
