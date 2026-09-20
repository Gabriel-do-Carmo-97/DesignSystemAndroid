package br.com.wgc.design_system.components.feedback

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class WgcSnackbarTest {

    @Test
    fun `WgcSnackbarVariant should contain all expected enum entries`() {
        val variants = WgcSnackbarVariant.entries
        assertEquals(5, variants.size)
        assertTrue(variants.contains(WgcSnackbarVariant.Default))
        assertTrue(variants.contains(WgcSnackbarVariant.Success))
        assertTrue(variants.contains(WgcSnackbarVariant.Error))
        assertTrue(variants.contains(WgcSnackbarVariant.Warning))
        assertTrue(variants.contains(WgcSnackbarVariant.Info))
    }
}
