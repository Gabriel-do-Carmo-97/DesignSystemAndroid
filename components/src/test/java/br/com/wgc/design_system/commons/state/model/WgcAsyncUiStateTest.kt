package br.com.wgc.design_system.commons.state.model

import br.com.wgc.design_system.commons.state.extensions.getOrNull
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class WgcAsyncUiStateTest {

    @Test
    fun `getOrNull should return value only on Success`() {
        val success: WgcAsyncUiState<String> = WgcAsyncUiState.Success("teste")
        val loading: WgcAsyncUiState<String> = WgcAsyncUiState.Loading
        val error: WgcAsyncUiState<String> = WgcAsyncUiState.Error("falha")
        val idle: WgcAsyncUiState<String> = WgcAsyncUiState.Idle

        assertEquals("teste", success.getOrNull())
        assertNull(loading.getOrNull())
        assertNull(error.getOrNull())
        assertNull(idle.getOrNull())
    }
}
