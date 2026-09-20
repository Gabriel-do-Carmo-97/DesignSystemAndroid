package br.com.wgc.design_system.components.inputs

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class WgcOtpInputTest {

    @Test
    fun `otp filter should accept only digits up to length`() {
        val input = "123abc4"
        val length = 4
        val filtered = input.filter { it.isDigit() }.take(length)
        assertEquals("1234", filtered)
    }

    @Test
    fun `otp value should respect maximum length constraint`() {
        val length = 6
        val otpValue = "123456789"
        val clamped = otpValue.take(length)
        assertEquals(6, clamped.length)
        assertEquals("123456", clamped)
    }
}
