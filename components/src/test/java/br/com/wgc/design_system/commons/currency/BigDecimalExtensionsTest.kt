package br.com.wgc.design_system.commons.currency

import org.junit.Assert.assertTrue
import org.junit.Test
import java.math.BigDecimal

class BigDecimalExtensionsTest {

    @Test
    fun `toBrazilianCurrency should format BigDecimal to Brazilian real currency`() {
        val value = BigDecimal("1234.56")
        val formatted = value.toBrazilianCurrency()
        assertTrue(formatted.contains("1.234,56") || formatted.contains("1234,56"))
        assertTrue(formatted.contains("R$"))
    }
}
