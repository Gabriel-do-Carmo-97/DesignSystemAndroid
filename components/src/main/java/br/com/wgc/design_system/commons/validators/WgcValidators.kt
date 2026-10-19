package br.com.wgc.design_system.commons.validators

import br.com.wgc.design_system.commons.constants.ComponentsConstants

private val EMAIL_REGEX = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")

/**
 * Utilitários para verificações sintáticas e aritméticas comuns em formulários brasileiros.
 *
 * Use estas funções para validação imediata de entrada na UI; elas não consultam serviços externos
 * nem provam identidade, existência do endereço ou titularidade do dado.
 */

/**
 * Verifica se o texto contém um CPF não repetido com dígitos verificadores matematicamente válidos.
 *
 * Aceita texto mascarado porque considera somente os dígitos. Entrada nula, em branco, com quantidade
 * incorreta ou dígitos repetidos retorna `false`. Exemplo: `cpfInput.isValidCpf()`.
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
 * Verifica se o texto contém um CNPJ não repetido com dígitos verificadores matematicamente válidos.
 *
 * Máscaras são aceitas (somente dígitos são considerados); entrada nula, em branco, com tamanho
 * incorreto ou dígitos repetidos retorna `false`. Exemplo: `cnpjInput.isValidCnpj()`.
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
 * Verifica se o texto não vazio corresponde ao padrão sintático de e-mail usado por esta biblioteca.
 *
 * O teste não verifica se o endereço existe ou pode receber mensagens; espaços externos são removidos.
 * Exemplo: `emailInput.isValidEmail()`.
 */
fun String?.isValidEmail(): Boolean {
    if (this.isNullOrBlank()) return false
    return EMAIL_REGEX.matches(this.trim())
}

/**
 * Verifica comprimento e primeiro dígito do número de telefone brasileiro (fixo com 10 ou móvel com 11 dígitos).
 *
 * Considera apenas dígitos, rejeita sequências de um mesmo dígito e verifica o primeiro dígito após
 * o DDD conforme as regras codificadas; não valida a faixa oficial de DDD. Exemplo:
 * `phoneInput.isValidPhone()`.
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
 * Verifica se há exatamente oito dígitos de CEP e se não são todos iguais.
 *
 * Aceita entrada mascarada, mas não confirma que o CEP exista. Exemplo: `cepInput.isValidCep()`.
 */
fun String?.isValidCep(): Boolean {
    if (this.isNullOrBlank()) return false
    val digits = this.filter { it.isDigit() }
    return digits.length == ComponentsConstants.Formatters.CEP_LENGTH && !digits.all { it == digits[0] }
}
