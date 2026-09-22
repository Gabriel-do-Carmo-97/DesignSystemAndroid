package br.com.wgc.design_system.components.signature

import androidx.compose.ui.geometry.Offset
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class WgcSignaturePadTest {

    @Test
    fun `strokes list accumulates points correctly`() {
        val stroke1 = listOf(Offset(10f, 10f), Offset(20f, 20f))
        val stroke2 = listOf(Offset(30f, 30f), Offset(40f, 40f))
        val allStrokes = mutableListOf<List<Offset>>()

        allStrokes.add(stroke1)
        allStrokes.add(stroke2)

        assertEquals(2, allStrokes.size)
        assertEquals(2, allStrokes[0].size)
        assertEquals(10f, allStrokes[0][0].x, 0.001f)
    }

    @Test
    fun `undo removes last stroke from list`() {
        val stroke1 = listOf(Offset(0f, 0f), Offset(10f, 10f))
        val stroke2 = listOf(Offset(20f, 20f), Offset(30f, 30f))
        val strokes = mutableListOf(stroke1, stroke2)

        if (strokes.isNotEmpty()) {
            strokes.removeAt(strokes.lastIndex)
        }

        assertEquals(1, strokes.size)
        assertEquals(stroke1, strokes[0])
    }

    @Test
    fun `clear empties all strokes`() {
        val stroke1 = listOf(Offset(0f, 0f), Offset(10f, 10f))
        val strokes = mutableListOf(stroke1)

        strokes.clear()

        assertTrue(strokes.isEmpty())
    }
}
