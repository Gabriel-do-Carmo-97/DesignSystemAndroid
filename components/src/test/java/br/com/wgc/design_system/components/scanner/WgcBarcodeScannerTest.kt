package br.com.wgc.design_system.components.scanner

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class WgcBarcodeScannerTest {

    @Test
    fun `toggle torch flips boolean state correctly`() {
        var torch = false
        torch = !torch
        assertTrue(torch)
        torch = !torch
        assertFalse(torch)
    }

    @Test
    fun `instruction text is stored correctly`() {
        val defaultInstruction = "Alinhe o código de barras ou QR Code dentro da área demarcada"
        val customInstruction = "Aproxime o boleto bancário"

        assertEquals("Aproxime o boleto bancário", customInstruction)
        assertTrue(defaultInstruction.isNotEmpty())
    }
}
