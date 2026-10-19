package br.com.wgc.design_system.commons.formatters

import br.com.wgc.design_system.commons.constants.ComponentsConstants
import java.text.NumberFormat
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

/**
 * Remove todos os caracteres que não sejam dígitos, preservando os dígitos Unicode.
 *
 * Use para normalizar texto mascarado antes de validar ou formatar. Exemplo: `"(11) 98765-4321".unmask()`.
 */
fun String.unmask(): String = this.filter { it.isDigit() }

/**
 * Formata este valor como moeda usando o locale informado (por padrão, `pt-BR`).
 *
 * Use para exibir valores monetários já representados por `Double`; para cálculos monetários com
 * precisão decimal, prefira `BigDecimal.toBrazilianCurrency()`.
 *
 * @param locale Locale que determina símbolo, separadores e convenções da moeda.
 * @return Texto monetário localizado, por exemplo `R$ 12,50` em `pt-BR`.
 */
fun Double.toCurrencyFormatted(
    locale: Locale = Locale.forLanguageTag(ComponentsConstants.Commons.PT_BR),
): String {
    val formatter = NumberFormat.getCurrencyInstance(locale)
    return formatter.format(this)
}

/**
 * Formata este timestamp Unix em milissegundos como data/hora no fuso informado.
 *
 * Use para exibir instantes armazenados como epoch milliseconds.
 *
 * @param pattern Padrão aceito por [DateTimeFormatter]; por padrão, `dd/MM/yyyy`.
 * @param zoneId Fuso usado para interpretar e formatar o instante; por padrão, o fuso do sistema.
 * @return Data formatada conforme o padrão.
 */
fun Long.toFormattedDate(
    pattern: String = ComponentsConstants.Commons.DEFAULT_DATE_PATTERN,
    zoneId: ZoneId = ZoneId.systemDefault(),
): String {
    val formatter = DateTimeFormatter.ofPattern(pattern).withZone(zoneId)
    return formatter.format(Instant.ofEpochMilli(this))
}

/**
 * Formata 11 dígitos como CPF (`000.000.000-00`).
 *
 * Use apenas para apresentação, não para validar o documento. Caracteres não numéricos são removidos;
 * se a quantidade de dígitos não for 11, retorna os dígitos sem máscara.
 * Exemplo: `"12345678901".formatCpf()`.
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
 * Formata 14 dígitos como CNPJ (`00.000.000/0000-00`).
 *
 * Use apenas para apresentação; quantidade diferente de 14 retorna os dígitos sem máscara.
 * Exemplo: `"12345678000199".formatCnpj()`.
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
 * Formata 8 dígitos como CEP (`00000-000`).
 *
 * Use para apresentação, não para verificar se o CEP existe; quantidade diferente de 8 retorna
 * os dígitos sem máscara. Exemplo: `"01310100".formatCep()`.
 */
fun String.formatCep(): String {
    val digits = this.unmask()
    if (digits.length != ComponentsConstants.Formatters.CEP_LENGTH) return digits
    return "${digits.substring(ComponentsConstants.Formatters.CEP_PART1_START, ComponentsConstants.Formatters.CEP_PART1_END)}-" +
        digits.substring(ComponentsConstants.Formatters.CEP_PART2_START, ComponentsConstants.Formatters.CEP_PART2_END)
}

/**
 * Formata telefone com 10 dígitos como fixo ou 11 como móvel no padrão brasileiro.
 *
 * Use para apresentar números normalizados; caracteres não numéricos são removidos. Comprimentos
 * diferentes retornam somente os dígitos, sem máscara. Exemplo: `"11987654321".formatPhone()`.
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
