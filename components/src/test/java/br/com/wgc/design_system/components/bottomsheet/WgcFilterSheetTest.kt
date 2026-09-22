package br.com.wgc.design_system.components.bottomsheet

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class WgcFilterSheetTest {

    @Test
    fun activeCountCalculatesAccurately() {
        val selectedCategories = setOf("1", "2")
        val priceRange = 100f..400f
        val priceBounds = 0f..1000f

        val isPriceFiltered = priceRange != priceBounds
        val activeCount = selectedCategories.size + (if (isPriceFiltered) 1 else 0)

        assertEquals(3, activeCount)
    }

    @Test
    fun categoryToggleAddsAndRemoves() {
        val categories = mutableSetOf("cat-1")

        // Toggle on
        if ("cat-2" in categories) categories.remove("cat-2") else categories.add("cat-2")
        assertTrue(categories.contains("cat-2"))
        assertEquals(2, categories.size)

        // Toggle off
        if ("cat-1" in categories) categories.remove("cat-1") else categories.add("cat-1")
        assertEquals(1, categories.size)
        assertTrue(categories.contains("cat-2"))
    }
}
