package br.com.wgc.design_system.templates.screens.security

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class WgcSecuritySettingsTemplateTest {

    @Test
    fun `toggle biometrics and 2fa updates flags`() {
        val viewModel = FakeSecuritySettingsViewModel()

        viewModel.onToggleBiometrics(false)
        assertFalse(viewModel.uiState.value.isBiometricsEnabled)

        viewModel.onToggleTwoFactor(false)
        assertFalse(viewModel.uiState.value.isTwoFactorEnabled)
    }

    @Test
    fun `revoke device removes device from connected devices list`() {
        val viewModel = FakeSecuritySettingsViewModel()
        val initialCount = viewModel.uiState.value.connectedDevices.size

        viewModel.onRevokeDevice("dev-2")
        val remaining = viewModel.uiState.value.connectedDevices

        assertEquals(initialCount - 1, remaining.size)
        assertTrue(remaining.none { it.id == "dev-2" })
    }
}
