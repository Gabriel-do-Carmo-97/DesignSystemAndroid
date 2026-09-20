package br.com.wgc.design_system.components.feedback

import org.junit.Assert.assertEquals
import org.junit.Test

class WgcRatingBarTest {

    @Test
    fun ratingClamping_worksWithinBounds() {
        val min = (-2.0f).coerceIn(0f, 5f)
        val max = 10.0f.coerceIn(0f, 5f)
        val valid = 3.5f.coerceIn(0f, 5f)

        assertEquals(0f, min, 0.001f)
        assertEquals(5f, max, 0.001f)
        assertEquals(3.5f, valid, 0.001f)
    }

    @Test
    fun ratingDescription_formatsCorrectly() {
        val rating = 4.5f
        val maxStars = 5
        val reviewCount = 120
        val desc = "Avaliação $rating de $maxStars estrelas com $reviewCount avaliações"

        assertEquals("Avaliação 4.5 de 5 estrelas com 120 avaliações", desc)
    }
}
