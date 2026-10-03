@file:Suppress("LongMethod", "MagicNumber")

package br.com.wgc.design_system.components.fields

import androidx.compose.foundation.layout.fillMaxWidth
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
 * Bandeiras de cartão de crédito detectáveis.
 */
enum class WgcCardBrand(val brandName: String) {
    VISA("Visa"),
    MASTERCARD("Mastercard"),
    ELO("Elo"),
    AMEX("American Express"),
    UNKNOWN("Desconhecida")
}

/**
 * Utilitário de detecção de bandeira e validação de Luhn.
 */
object WgcCreditCardValidator {

    fun detectBrand(digits: String): WgcCardBrand {
        return when {
            digits.startsWith("4") -> WgcCardBrand.VISA
            digits.startsWith("51") || digits.startsWith("52") || digits.startsWith("53") ||
                digits.startsWith("54") || digits.startsWith("55") -> WgcCardBrand.MASTERCARD
            digits.startsWith("4011") || digits.startsWith("4389") || digits.startsWith("5041") -> WgcCardBrand.ELO
            digits.startsWith("34") || digits.startsWith("37") -> WgcCardBrand.AMEX
            else -> WgcCardBrand.UNKNOWN
        }
    }

    fun isLuhnValid(number: String): Boolean {
        val digits = number.filter { it.isDigit() }
        if (digits.length < 13) return false
        var sum = 0
        var alternate = false
        for (i in digits.length - 1 downTo 0) {
            var n = digits[i].digitToInt()
            if (alternate) {
                n *= 2
                if (n > 9) n = (n % 10) + 1
            }
            sum += n
            alternate = !alternate
        }
        return (sum % 10 == 0)
    }
}

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
