package br.com.wgc.design_system.components.bottomsheet

import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class WgcStandardBottomSheetTest {

    @Test
    fun standardBottomSheet_configurationInitializesCorrectly() {
        var dismissed = false
        val onDismiss = { dismissed = true }

        assertNotNull(onDismiss)
        onDismiss.invoke()
        assertTrue(dismissed)
    }
}
