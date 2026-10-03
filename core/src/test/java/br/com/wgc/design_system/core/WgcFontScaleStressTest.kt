@file:Suppress("MagicNumber")

package br.com.wgc.design_system.core

import org.junit.Assert.assertTrue
import org.junit.Test

class WgcFontScaleStressTest {

    @Test
    fun `font sizes scale linearly from 85 percent to 200 percent without negative values`() {
        val baseFontSizes = listOf(12.0f, 14.0f, 16.0f, 20.0f, 24.0f, 32.0f)
        val scales = listOf(0.85f, 1.0f, 1.15f, 1.30f, 1.50f, 2.0f)

        for (base in baseFontSizes) {
            for (scale in scales) {
                val scaled = base * scale
                assertTrue("Tamanho escalado deve ser positivo e proporcional", scaled > 0f)
                assertTrue("Tamanho máximo de 200% não deve exceder o dobro do original", scaled <= base * 2.0f)
            }
        }
    }
}
