@file:Suppress("MagicNumber")

package br.com.wgc.design_system.components.fields

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import java.text.NumberFormat
import java.util.Locale

/**
 * WgcCurrencyInput
 *
 * Campo de entrada monetária formatado em tempo real com preservação de centavos (Long)
 * e formatação de moeda brasileira (R$).
 *
 * @param amountInCents Valor em centavos (ex: 1250L representa R$ 12,50).
 * @param onAmountChange Callback com novo valor em centavos.
 * @param label Rótulo do campo.
 * @param isError Indica se o campo possui erro.
 * @param errorMessage Mensagem de erro exibida no rodapé.
 * @param modifier Modificador de layout.
 */
@Composable
fun WgcCurrencyInput(
    amountInCents: Long,
    onAmountChange: (Long) -> Unit,
    label: String = "Valor",
    isError: Boolean = false,
    errorMessage: String? = null,
    modifier: Modifier = Modifier
) {
    val formatter = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
    val formattedText = formatter.format(amountInCents / 100.0)

    OutlinedTextField(
        value = formattedText,
        onValueChange = { input ->
            val digitsOnly = input.filter { it.isDigit() }
            val cents = digitsOnly.toLongOrNull() ?: 0L
            onAmountChange(cents)
        },
        modifier = modifier.fillMaxWidth(),
        label = { Text(text = label) },
        isError = isError,
        supportingText = {
            if (isError && errorMessage != null) {
                Text(text = errorMessage, color = MaterialTheme.colorScheme.error)
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true
    )
}
