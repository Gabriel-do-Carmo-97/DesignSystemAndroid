package br.com.wgc.design_system.commons

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class WgcValidatorsTest {

    @Test
    fun `isValidCpf should validate correctly`() {
        // Valid CPF test
        assertTrue("52998224725".isValidCpf())
        assertTrue("529.982.247-25".isValidCpf())

        // Invalid CPFs
        assertFalse("11111111111".isValidCpf())
        assertFalse("12345678900".isValidCpf())
        assertFalse("".isValidCpf())
        assertFalse(null.isValidCpf())
    }

    @Test
    fun `isValidCnpj should validate correctly`() {
        // Valid CNPJ test
        assertTrue("11444777000161".isValidCnpj())
        assertTrue("11.444.777/0001-61".isValidCnpj())

        // Invalid CNPJs
        assertFalse("00000000000000".isValidCnpj())
        assertFalse("11444777000100".isValidCnpj())
        assertFalse("".isValidCnpj())
        assertFalse(null.isValidCnpj())
    }

    @Test
    fun `isValidEmail should validate email formats`() {
        assertTrue("test@wgc.com.br".isValidEmail())
        assertTrue("user.name+tag@domain.co".isValidEmail())

        assertFalse("invalid-email".isValidEmail())
        assertFalse("user@".isValidEmail())
        assertFalse("".isValidEmail())
        assertFalse(null.isValidEmail())
    }

    @Test
    fun `isValidPhone should validate mobile and landline phones`() {
        assertTrue("11987654321".isValidPhone())
        assertTrue("(11) 98765-4321".isValidPhone())
        assertTrue("1133334444".isValidPhone())
        assertTrue("(11) 3333-4444".isValidPhone())

        assertFalse("11111111111".isValidPhone())
        assertFalse("123".isValidPhone())
        assertFalse("".isValidPhone())
        assertFalse(null.isValidPhone())
    }

    @Test
    fun `isValidCep should validate 8-digit zip codes`() {
        assertTrue("01310100".isValidCep())
        assertTrue("01310-100".isValidCep())

        assertFalse("00000000".isValidCep())
        assertFalse("1234".isValidCep())
        assertFalse("".isValidCep())
        assertFalse(null.isValidCep())
    }
}
