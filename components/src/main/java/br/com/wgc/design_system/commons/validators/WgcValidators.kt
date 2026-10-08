package br.com.wgc.design_system.commons.validators

import br.com.wgc.design_system.commons.constants.ComponentsConstants

private val EMAIL_REGEX = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")

/**
 * Utilitários e extensões de validação de formulários corporativos do Design System WGC.
 */

/**
 * Valida se a string representa um Cadastro de Pessoas Físicas (CPF) matematicamente válido.
 */
fun String?.isValidCpf(): Boolean {
    if (this.isNullOrBlank()) return false
    val digits = this.filter { it.isDigit() }
    if (digits.length != ComponentsConstants.Formatters.CPF_LENGTH || digits.all { it == digits[0] }) return false

    val numbers = digits.map { it.digitToInt() }
    val firstRemainder = (0 until ComponentsConstants.Validators.CPF_FIRST_DIGIT_FACTORS_COUNT).sumOf {
        numbers[it] * (ComponentsConstants.Validators.CPF_FIRST_DIGIT_BASE_WEIGHT - it)
    } % ComponentsConstants.Validators.MODULO_BASE
    val firstDigit =
        if (firstRemainder < ComponentsConstants.Validators.DIGIT_TOLERANCE_MIN) 0
        else ComponentsConstants.Validators.MODULO_BASE - firstRemainder

    val secondRemainder = (0 until ComponentsConstants.Validators.CPF_SECOND_DIGIT_FACTORS_COUNT).sumOf {
        numbers[it] * (ComponentsConstants.Validators.CPF_SECOND_DIGIT_BASE_WEIGHT - it)
    } % ComponentsConstants.Validators.MODULO_BASE
    val secondDigit =
        if (secondRemainder < ComponentsConstants.Validators.DIGIT_TOLERANCE_MIN) 0
        else ComponentsConstants.Validators.MODULO_BASE - secondRemainder

    return numbers[ComponentsConstants.Validators.CPF_FIRST_CHECK_INDEX] == firstDigit &&
        numbers[ComponentsConstants.Validators.CPF_SECOND_CHECK_INDEX] == secondDigit
}

/**
 * Valida se a string representa um Cadastro Nacional da Pessoa Jurídica (CNPJ) matematicamente válido.
 */
fun String?.isValidCnpj(): Boolean {
    if (this.isNullOrBlank()) return false
    val digits = this.filter { it.isDigit() }
    if (digits.length != ComponentsConstants.Formatters.CNPJ_LENGTH || digits.all { it == digits[0] }) return false

    val numbers = digits.map { it.digitToInt() }
    val firstRemainder = (0 until ComponentsConstants.Validators.CNPJ_FIRST_DIGIT_FACTORS_COUNT).sumOf {
        numbers[it] * ComponentsConstants.Validators.CNPJ_WEIGHTS_FIRST[it]
    } % ComponentsConstants.Validators.MODULO_BASE
    val firstDigit =
        if (firstRemainder < ComponentsConstants.Validators.DIGIT_TOLERANCE_MIN) 0
        else ComponentsConstants.Validators.MODULO_BASE - firstRemainder

    val secondRemainder = (0 until ComponentsConstants.Validators.CNPJ_SECOND_DIGIT_FACTORS_COUNT).sumOf {
        numbers[it] * ComponentsConstants.Validators.CNPJ_WEIGHTS_SECOND[it]
    } % ComponentsConstants.Validators.MODULO_BASE
    val secondDigit =
        if (secondRemainder < ComponentsConstants.Validators.DIGIT_TOLERANCE_MIN) 0
        else ComponentsConstants.Validators.MODULO_BASE - secondRemainder

    return numbers[ComponentsConstants.Validators.CNPJ_FIRST_CHECK_INDEX] == firstDigit &&
        numbers[ComponentsConstants.Validators.CNPJ_SECOND_CHECK_INDEX] == secondDigit
}

/**
 * Valida se o formato do e-mail é sintaticamente válido.
 */
fun String?.isValidEmail(): Boolean {
    if (this.isNullOrBlank()) return false
    return EMAIL_REGEX.matches(this.trim())
}

/**
 * Valida se a string representa um número de telefone brasileiro válido (fixo com 10 dígitos ou móvel com 11).
 */
fun String?.isValidPhone(): Boolean {
    if (this.isNullOrBlank()) return false
    val digits = this.filter { it.isDigit() }
    if (digits.all { it == digits[0] }) return false

    return when (digits.length) {
        ComponentsConstants.Formatters.PHONE_FIXED_LENGTH ->
            digits[ComponentsConstants.Validators.PHONE_DDD_VALID_INDEX] in
                ComponentsConstants.Validators.PHONE_FIXED_FIRST_DIGIT_MIN..ComponentsConstants.Validators.PHONE_FIXED_FIRST_DIGIT_MAX
        ComponentsConstants.Formatters.PHONE_MOBILE_LENGTH ->
            digits[ComponentsConstants.Validators.PHONE_DDD_VALID_INDEX] ==
                ComponentsConstants.Validators.PHONE_MOBILE_FIRST_DIGIT
        else -> false
    }
}

/**
 * Valida se a string representa um Código de Endereçamento Postal (CEP) brasileiro de 8 dígitos.
 */
fun String?.isValidCep(): Boolean {
    if (this.isNullOrBlank()) return false
    val digits = this.filter { it.isDigit() }
    return digits.length == ComponentsConstants.Formatters.CEP_LENGTH && !digits.all { it == digits[0] }
}
