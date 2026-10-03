package br.com.wgc.design_system.commons

import android.content.Context
import androidx.compose.ui.hapticfeedback.HapticFeedback
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class WgcHapticsTest {

    private val context = mockk<Context>(relaxed = true)
    private val composeHaptic = mockk<HapticFeedback>(relaxed = true)

    @Test
    fun `click should trigger TextHandleMove on Compose haptics`() {
        val helper = DefaultWgcHapticFeedback(context, composeHaptic)
        helper.click()

        verify { composeHaptic.performHapticFeedback(HapticFeedbackType.TextHandleMove) }
    }

    @Test
    fun `confirm should trigger LongPress on Compose haptics`() {
        val helper = DefaultWgcHapticFeedback(context, composeHaptic)
        helper.confirm()

        verify { composeHaptic.performHapticFeedback(HapticFeedbackType.LongPress) }
    }

    @Test
    fun `success, warning and error should execute safely without throwing exceptions`() {
        val helper = DefaultWgcHapticFeedback(context, composeHaptic)
        helper.success()
        helper.warning()
        helper.error()
    }

    @Test
    fun `helper with null composeHaptic should execute safely without crashes`() {
        val helper = DefaultWgcHapticFeedback(context, null)
        helper.click()
        helper.confirm()
        helper.success()
        helper.warning()
        helper.error()
    }
}
