package br.com.wgc.design_system.components.tag

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class WgcTagTest {

    @Test
    fun `WgcTagVariant should contain all expected enum entries`() {
        val variants = WgcTagVariant.entries
        assertEquals(7, variants.size)
        assertTrue(variants.contains(WgcTagVariant.Primary))
        assertTrue(variants.contains(WgcTagVariant.Secondary))
        assertTrue(variants.contains(WgcTagVariant.Success))
        assertTrue(variants.contains(WgcTagVariant.Error))
        assertTrue(variants.contains(WgcTagVariant.Warning))
        assertTrue(variants.contains(WgcTagVariant.Info))
        assertTrue(variants.contains(WgcTagVariant.Neutral))
    }

    @Test
    fun `WgcTagStyle should contain Filled and Outlined`() {
        val styles = WgcTagStyle.entries
        assertEquals(2, styles.size)
        assertTrue(styles.contains(WgcTagStyle.Filled))
        assertTrue(styles.contains(WgcTagStyle.Outlined))
    }

    @Test
    fun `WgcTagSize should contain Small and Medium`() {
        val sizes = WgcTagSize.entries
        assertEquals(2, sizes.size)
        assertTrue(sizes.contains(WgcTagSize.Small))
        assertTrue(sizes.contains(WgcTagSize.Medium))
    }
}
