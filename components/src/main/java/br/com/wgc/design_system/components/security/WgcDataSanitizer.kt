package br.com.wgc.design_system.components.security

/**
 * Sanitizador de dados sensíveis para logs corporativos (LGPD / PCI-DSS compliance).
 */
object WgcDataSanitizer {

    private val CPF_REGEX = Regex("""\b\d{3}\.?\d{3}\.?\d{3}-?\d{2}\b""")
    private val CARD_REGEX = Regex("""\b(?:\d[ -]*?){13,16}\b""")
    private val JWT_REGEX = Regex("""eyJ[A-Za-z0-9_-]+\.[A-Za-z0-9_-]+\.[A-Za-z0-9_-]+""")

    fun sanitize(input: String): String {
        var result = input
        result = CPF_REGEX.replace(result, "***.***.***-**")
        result = CARD_REGEX.replace(result, "**** **** **** ****")
        result = JWT_REGEX.replace(result, "[JWT_REDACTED]")
        return result
    }
}
