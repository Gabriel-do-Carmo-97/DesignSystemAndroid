package br.com.wgc.design_system.commons.currency

import br.com.wgc.design_system.commons.constants.ComponentsConstants
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

fun BigDecimal.toBrazilianCurrency(): String = NumberFormat
    .getCurrencyInstance(
        Locale.forLanguageTag(ComponentsConstants.Commons.PT_BR)
    ).format(this@toBrazilianCurrency)
