package br.com.wgc.design_system.components.audio

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class WgcAudioWavePlayerTest {

    @Test
    fun `play pause state toggles correctly`() {
        var isPlaying = false
        isPlaying = !isPlaying
        assertTrue(isPlaying)
        isPlaying = !isPlaying
        assertFalse(isPlaying)
    }

    @Test
    fun `progress is coerced within valid range`() {
        val rawProgress = 1.25f
        val validProgress = rawProgress.coerceIn(0f, 1f)
        assertEquals(1.0f, validProgress, 0.001f)

        val negativeProgress = -0.3f
        val validNegative = negativeProgress.coerceIn(0f, 1f)
        assertEquals(0.0f, validNegative, 0.001f)
    }

    @Test
    fun `playback speed changes correctly`() {
        var speed = 1.0f
        speed = 1.5f
        assertEquals(1.5f, speed, 0.001f)
        speed = 2.0f
        assertEquals(2.0f, speed, 0.001f)
    }
}
