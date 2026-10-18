@file:Suppress("MagicNumber")

package br.com.wgc.design_system.components.fields

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
        if (digits.length < 13 || digits.length > 19) return false
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
