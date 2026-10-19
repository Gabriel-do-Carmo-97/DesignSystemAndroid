package br.com.wgc.design_system.commons.currency

import br.com.wgc.design_system.commons.constants.ComponentsConstants
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

/**
 * Formata este valor como moeda brasileira usando o locale `pt-BR`.
 *
 * Use para apresentar valores monetários calculados com [BigDecimal], evitando converter para
 * `Double` e perder precisão decimal. Exemplo: `BigDecimal("12.50").toBrazilianCurrency()`.
 */
fun BigDecimal.toBrazilianCurrency(): String = NumberFormat
    .getCurrencyInstance(
        Locale.forLanguageTag(ComponentsConstants.Commons.PT_BR)
    ).format(this@toBrazilianCurrency)
