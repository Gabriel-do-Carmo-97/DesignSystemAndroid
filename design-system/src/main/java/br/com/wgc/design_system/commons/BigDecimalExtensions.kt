package br.com.wgc.design_system.commons

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

fun BigDecimal.toBrazilianCurrency() : String {
    return NumberFormat
        .getCurrencyInstance(Locale("pt", "br"))
        .format(this)
}