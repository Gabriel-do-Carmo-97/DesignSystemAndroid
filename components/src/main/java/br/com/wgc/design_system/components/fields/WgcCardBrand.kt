@file:Suppress("LongMethod", "MagicNumber")

package br.com.wgc.design_system.components.fields

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
