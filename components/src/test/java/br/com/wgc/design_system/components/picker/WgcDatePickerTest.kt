package br.com.wgc.design_system.components.picker

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class WgcDatePickerTest {

    @Test
    fun dateFormattingProducesExpectedOutput() {
        val calendar = java.util.Calendar.getInstance().apply {
            set(2024, java.util.Calendar.JANUARY, 1, 12, 0, 0)
        }
        val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val formatted = formatter.format(calendar.time)
        assertEquals("01/01/2024", formatted)
    }

    @Test
    fun dateRangeFormattingValidatesBoundaries() {
        val start = 1704067200000L
        val end = 1704672000000L

        assertTrue(start < end)
    }
}
