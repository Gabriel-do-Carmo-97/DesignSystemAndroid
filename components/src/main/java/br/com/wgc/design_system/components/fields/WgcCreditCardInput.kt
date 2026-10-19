@file:Suppress("LongMethod", "MagicNumber")

package br.com.wgc.design_system.components.fields

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.commons.previews.components.WgcComponentPreviews
import br.com.wgc.design_system.theme.WgcTheme
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

/**
 * Transformação visual de 16 dígitos com espaço a cada 4 dígitos.
 */
private class CreditCardVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val trimmed = if (text.text.length >= 16) text.text.substring(0..15) else text.text
        var out = ""
        for (i in trimmed.indices) {
            out += trimmed[i]
            if (i % 4 == 3 && i != 15) out += " "
        }
        val offsetTranslator = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                if (offset <= 0) return 0
                val spaces = (offset - 1) / 4
                return (offset + spaces).coerceAtMost(out.length)
            }

            override fun transformedToOriginal(offset: Int): Int {
                val spaces = offset / 5
                return (offset - spaces).coerceAtMost(trimmed.length)
            }
        }
        return TransformedText(AnnotatedString(out), offsetTranslator)
    }
}

/**
 * Campo de entrada para número de cartão de crédito.
 */
@Composable
fun WgcCreditCardInput(
    cardNumber: String,
    onCardNumberChange: (String) -> Unit,
    label: String = "Número do Cartão",
    isError: Boolean = false,
    errorMessage: String? = null,
    modifier: Modifier = Modifier
) {
    val digitsOnly = cardNumber.filter { it.isDigit() }.take(16)
    val detectedBrand = WgcCreditCardValidator.detectBrand(digitsOnly)

    OutlinedTextField(
        value = digitsOnly,
        onValueChange = { input ->
            val clean = input.filter { it.isDigit() }.take(16)
            onCardNumberChange(clean)
        },
        modifier = modifier.fillMaxWidth(),
        label = { Text(text = label) },
        placeholder = { Text(text = "0000 0000 0000 0000") },
        visualTransformation = CreditCardVisualTransformation(),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.CreditCard,
                contentDescription = detectedBrand.brandName,
                tint = if (detectedBrand != WgcCardBrand.UNKNOWN) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
            )
        },
        isError = isError,
        supportingText = {
            if (isError && errorMessage != null) {
                Text(text = errorMessage, color = MaterialTheme.colorScheme.error)
            } else if (detectedBrand != WgcCardBrand.UNKNOWN) {
                Text(text = detectedBrand.brandName, color = MaterialTheme.colorScheme.primary)
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true
    )
}

@WgcComponentPreviews
@Preview(showBackground = true, name = "WgcCreditCardInput - Default & Error")
@Composable
private fun WgcCreditCardInputPreview() {
    WgcTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            WgcCreditCardInput(
                cardNumber = "4532123456789012",
                onCardNumberChange = {}
            )
            WgcCreditCardInput(
                cardNumber = "1234567890123456",
                onCardNumberChange = {},
                isError = true,
                errorMessage = "Número de cartão inválido"
            )
        }
    }
}
