package br.com.wgc.design_system.commons.formatters

import br.com.wgc.design_system.commons.constants.ComponentsConstants
import java.text.NumberFormat
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

/**
 * Remove caracteres não numéricos de uma string, mantendo somente os dígitos.
 */
fun String.unmask(): String = this.filter { it.isDigit() }

/**
 * Formata um valor [Double] para representação monetária brasileira (padrão R$ 0,00).
 */
fun Double.toCurrencyFormatted(
    locale: Locale = Locale.forLanguageTag(ComponentsConstants.Commons.PT_BR),
): String {
    val formatter = NumberFormat.getCurrencyInstance(locale)
    return formatter.format(this)
}

/**
 * Converte um timestamp em milissegundos ([Long]) em uma data textual formatada.
 */
fun Long.toFormattedDate(
    pattern: String = ComponentsConstants.Commons.DEFAULT_DATE_PATTERN,
    zoneId: ZoneId = ZoneId.systemDefault(),
): String {
    val formatter = DateTimeFormatter.ofPattern(pattern).withZone(zoneId)
    return formatter.format(Instant.ofEpochMilli(this))
}

/**
 * Formata uma string de 11 dígitos numéricos no padrão de exibição de CPF: `000.000.000-00`.
 */
fun String.formatCpf(): String {
    val digits = this.unmask()
    if (digits.length != ComponentsConstants.Formatters.CPF_LENGTH) return digits
    return "${digits.substring(ComponentsConstants.Formatters.CPF_PART1_START, ComponentsConstants.Formatters.CPF_PART1_END)}." +
        "${digits.substring(ComponentsConstants.Formatters.CPF_PART2_START, ComponentsConstants.Formatters.CPF_PART2_END)}." +
        "${digits.substring(ComponentsConstants.Formatters.CPF_PART3_START, ComponentsConstants.Formatters.CPF_PART3_END)}-" +
        digits.substring(ComponentsConstants.Formatters.CPF_PART4_START, ComponentsConstants.Formatters.CPF_PART4_END)
}

/**
 * Formata uma string de 14 dígitos numéricos no padrão de exibição de CNPJ: `00.000.000/0000-00`.
 */
fun String.formatCnpj(): String {
    val digits = this.unmask()
    if (digits.length != ComponentsConstants.Formatters.CNPJ_LENGTH) return digits
    return "${digits.substring(ComponentsConstants.Formatters.CNPJ_PART1_START, ComponentsConstants.Formatters.CNPJ_PART1_END)}." +
        "${digits.substring(ComponentsConstants.Formatters.CNPJ_PART2_START, ComponentsConstants.Formatters.CNPJ_PART2_END)}." +
        "${digits.substring(ComponentsConstants.Formatters.CNPJ_PART3_START, ComponentsConstants.Formatters.CNPJ_PART3_END)}/" +
        "${digits.substring(ComponentsConstants.Formatters.CNPJ_PART4_START, ComponentsConstants.Formatters.CNPJ_PART4_END)}-" +
        digits.substring(ComponentsConstants.Formatters.CNPJ_PART5_START, ComponentsConstants.Formatters.CNPJ_PART5_END)
}

/**
 * Formata uma string de 8 dígitos numéricos no padrão de exibição de CEP: `00000-000`.
 */
fun String.formatCep(): String {
    val digits = this.unmask()
    if (digits.length != ComponentsConstants.Formatters.CEP_LENGTH) return digits
    return "${digits.substring(ComponentsConstants.Formatters.CEP_PART1_START, ComponentsConstants.Formatters.CEP_PART1_END)}-" +
        digits.substring(ComponentsConstants.Formatters.CEP_PART2_START, ComponentsConstants.Formatters.CEP_PART2_END)
}

/**
 * Formata uma string de 10 ou 11 dígitos numéricos no padrão telefônico brasileiro:
 * `(00) 0000-0000` (fixo) ou `(00) 00000-0000` (móvel).
 */
fun String.formatPhone(): String {
    val digits = this.unmask()
    return when (digits.length) {
        ComponentsConstants.Formatters.PHONE_FIXED_LENGTH ->
            "(${digits.substring(ComponentsConstants.Formatters.PHONE_DDD_START, ComponentsConstants.Formatters.PHONE_DDD_END)}) " +
                "${digits.substring(ComponentsConstants.Formatters.PHONE_FIXED_PREFIX_START, ComponentsConstants.Formatters.PHONE_FIXED_PREFIX_END)}-" +
                digits.substring(ComponentsConstants.Formatters.PHONE_FIXED_SUFFIX_START, ComponentsConstants.Formatters.PHONE_FIXED_SUFFIX_END)
        ComponentsConstants.Formatters.PHONE_MOBILE_LENGTH ->
            "(${digits.substring(ComponentsConstants.Formatters.PHONE_DDD_START, ComponentsConstants.Formatters.PHONE_DDD_END)}) " +
                "${digits.substring(ComponentsConstants.Formatters.PHONE_MOBILE_PREFIX_START, ComponentsConstants.Formatters.PHONE_MOBILE_PREFIX_END)}-" +
                digits.substring(ComponentsConstants.Formatters.PHONE_MOBILE_SUFFIX_START, ComponentsConstants.Formatters.PHONE_MOBILE_SUFFIX_END)
        else -> digits
    }
}
