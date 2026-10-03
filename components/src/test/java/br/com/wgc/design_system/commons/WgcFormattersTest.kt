package br.com.wgc.design_system.commons

import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.ZoneId

class WgcFormattersTest {

    @Test
    fun `unmask should extract digits only`() {
        assertEquals("12345678901", "123.456.789-01".unmask())
        assertEquals("01234567000189", "01.234.567/0001-89".unmask())
        assertEquals("11987654321", "(11) 98765-4321".unmask())
        assertEquals("", "abc!@#".unmask())
    }

    @Test
    fun `formatCpf should format valid 11 digit string`() {
        assertEquals("123.456.789-01", "12345678901".formatCpf())
        assertEquals("123.456.789-01", "123.456.789-01".formatCpf())
        assertEquals("123", "123".formatCpf())
    }

    @Test
    fun `formatCnpj should format valid 14 digit string`() {
        assertEquals("12.345.678/0001-90", "12345678000190".formatCnpj())
        assertEquals("12.345.678/0001-90", "12.345.678/0001-90".formatCnpj())
        assertEquals("12345", "12345".formatCnpj())
    }

    @Test
    fun `formatCep should format valid 8 digit string`() {
        assertEquals("01310-100", "01310100".formatCep())
        assertEquals("01310-100", "01310-100".formatCep())
        assertEquals("123", "123".formatCep())
    }

    @Test
    fun `formatPhone should format mobile and fixed phone numbers`() {
        assertEquals("(11) 98765-4321", "11987654321".formatPhone())
        assertEquals("(11) 3456-7890", "1134567890".formatPhone())
        assertEquals("123", "123".formatPhone())
    }

    @Test
    fun `toCurrencyFormatted should format double to currency string`() {
        val formatted = 1250.50.toCurrencyFormatted()
        assert(formatted.contains("1.250,50") || formatted.contains("1250,50"))
    }

    @Test
    fun `toFormattedDate should format long timestamp correctly`() {
        // 1700000000000L is 2023-11-14T22:13:20Z
        val formatted = 1700000000000L.toFormattedDate(zoneId = ZoneId.of("UTC"))
        assertEquals("14/11/2023", formatted)
    }
}
