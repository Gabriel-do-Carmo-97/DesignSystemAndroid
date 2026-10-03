package br.com.wgc.design_system.mock

import br.com.wgc.design_system.commons.isValidCep
import br.com.wgc.design_system.commons.isValidCnpj
import br.com.wgc.design_system.commons.isValidCpf
import br.com.wgc.design_system.commons.isValidPhone
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class WgcBrazilFixtureDataFactoryTest {

    @Test
    fun `generateCpf should produce valid CPFs`() {
        repeat(10) {
            val formatted = WgcBrazilFixtureDataFactory.generateCpf(formatted = true)
            val raw = WgcBrazilFixtureDataFactory.generateCpf(formatted = false)

            assertTrue("CPF formatado deve ser válido: $formatted", formatted.isValidCpf())
            assertTrue("CPF raw deve ser válido: $raw", raw.isValidCpf())
            assertEquals(14, formatted.length)
            assertEquals(11, raw.length)
        }
    }

    @Test
    fun `generateCnpj should produce valid CNPJs`() {
        repeat(10) {
            val formatted = WgcBrazilFixtureDataFactory.generateCnpj(formatted = true)
            val raw = WgcBrazilFixtureDataFactory.generateCnpj(formatted = false)

            assertTrue("CNPJ formatado deve ser válido: $formatted", formatted.isValidCnpj())
            assertTrue("CNPJ raw deve ser válido: $raw", raw.isValidCnpj())
            assertEquals(18, formatted.length)
            assertEquals(14, raw.length)
        }
    }

    @Test
    fun `generateCep should produce valid CEPs`() {
        repeat(10) {
            val formatted = WgcBrazilFixtureDataFactory.generateCep(formatted = true)
            val raw = WgcBrazilFixtureDataFactory.generateCep(formatted = false)

            assertTrue("CEP formatado deve ser válido: $formatted", formatted.isValidCep())
            assertTrue("CEP raw deve ser válido: $raw", raw.isValidCep())
            assertEquals(9, formatted.length)
            assertEquals(8, raw.length)
        }
    }

    @Test
    fun `generatePhone should produce valid mobile and landline phones`() {
        repeat(10) {
            val mobile = WgcBrazilFixtureDataFactory.generatePhone(isMobile = true, formatted = true)
            val landline = WgcBrazilFixtureDataFactory.generatePhone(isMobile = false, formatted = true)

            assertTrue("Telefone móvel deve ser válido: $mobile", mobile.isValidPhone())
            assertTrue("Telefone fixo deve ser válido: $landline", landline.isValidPhone())
        }
    }
}
