package br.com.wgc.design_system.commons

import java.text.NumberFormat
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

private const val CPF_LENGTH = 11
private const val CNPJ_LENGTH = 14
private const val CEP_LENGTH = 8
private const val PHONE_FIXED_LENGTH = 10
private const val PHONE_MOBILE_LENGTH = 11

/**
 * Remove caracteres não numéricos de uma string, mantendo somente os dígitos.
 */
fun String.unmask(): String = this.filter { it.isDigit() }

/**
 * Formata um valor [Double] para representação monetária brasileira (padrão R$ 0,00).
 */
fun Double.toCurrencyFormatted(locale: Locale = Locale.forLanguageTag("pt-BR")): String {
    val formatter = NumberFormat.getCurrencyInstance(locale)
    return formatter.format(this)
}

/**
 * Converte um timestamp em milissegundos ([Long]) em uma data textual formatada.
 */
fun Long.toFormattedDate(
    pattern: String = "dd/MM/yyyy",
    zoneId: ZoneId = ZoneId.systemDefault(),
): String {
    val formatter = DateTimeFormatter.ofPattern(pattern).withZone(zoneId)
    return formatter.format(Instant.ofEpochMilli(this))
}

/**
 * Formata uma string de 11 dígitos numéricos no padrão de exibição de CPF: `000.000.000-00`.
 */
@Suppress("MagicNumber")
fun String.formatCpf(): String {
    val digits = this.unmask()
    if (digits.length != CPF_LENGTH) return digits
    return "${digits.substring(0, 3)}.${digits.substring(3, 6)}.${digits.substring(6, 9)}-${digits.substring(9, 11)}"
}

/**
 * Formata uma string de 14 dígitos numéricos no padrão de exibição de CNPJ: `00.000.000/0000-00`.
 */
@Suppress("MagicNumber")
fun String.formatCnpj(): String {
    val digits = this.unmask()
    if (digits.length != CNPJ_LENGTH) return digits
    return "${digits.substring(0, 2)}.${digits.substring(2, 5)}.${digits.substring(5, 8)}/" +
        "${digits.substring(8, 12)}-${digits.substring(12, 14)}"
}

/**
 * Formata uma string de 8 dígitos numéricos no padrão de exibição de CEP: `00000-000`.
 */
@Suppress("MagicNumber")
fun String.formatCep(): String {
    val digits = this.unmask()
    if (digits.length != CEP_LENGTH) return digits
    return "${digits.substring(0, 5)}-${digits.substring(5, 8)}"
}

/**
 * Formata uma string de 10 ou 11 dígitos numéricos no padrão telefônico brasileiro:
 * `(00) 0000-0000` (fixo) ou `(00) 00000-0000` (móvel).
 */
@Suppress("MagicNumber")
fun String.formatPhone(): String {
    val digits = this.unmask()
    return when (digits.length) {
        PHONE_FIXED_LENGTH -> "(${digits.substring(0, 2)}) ${digits.substring(2, 6)}-${digits.substring(6, 10)}"
        PHONE_MOBILE_LENGTH -> "(${digits.substring(0, 2)}) ${digits.substring(2, 7)}-${digits.substring(7, 11)}"
        else -> digits
    }
}
