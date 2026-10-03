package br.com.wgc.design_system.commons

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
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

    @Test
    fun `status check extensions should report correct states`() {
        val loading: WgcAsyncUiState<Int> = WgcAsyncUiState.Loading
        assertTrue(loading.isLoading())
        assertFalse(loading.isSuccess())
        assertFalse(loading.isError())

        val success: WgcAsyncUiState<Int> = WgcAsyncUiState.Success(42)
        assertFalse(success.isLoading())
        assertTrue(success.isSuccess())
        assertFalse(success.isError())

        val error: WgcAsyncUiState<Int> = WgcAsyncUiState.Error("Erro")
        assertFalse(error.isLoading())
        assertFalse(error.isSuccess())
        assertTrue(error.isError())
    }

    @Test
    fun `map should transform success value and preserve other states`() {
        val success: WgcAsyncUiState<Int> = WgcAsyncUiState.Success(10)
        val transformed = success.map { it * 2 }
        assertEquals(20, (transformed as WgcAsyncUiState.Success).data)

        val error: WgcAsyncUiState<Int> = WgcAsyncUiState.Error("Falha")
        val mappedError = error.map { it * 2 }
        assertTrue(mappedError.isError())
    }

    @Test
    fun `asWgcAsyncUiState should emit Loading then Success`() = runBlocking {
        val emissions = flowOf("item1", "item2").asWgcAsyncUiState().toList()

        assertEquals(3, emissions.size)
        assertTrue(emissions[0] is WgcAsyncUiState.Loading)
        assertEquals("item1", (emissions[1] as WgcAsyncUiState.Success).data)
        assertEquals("item2", (emissions[2] as WgcAsyncUiState.Success).data)
    }

    @Test
    fun `asWgcAsyncUiState should catch exceptions and emit Error`() = runBlocking {
        val failingFlow = flow<String> {
            throw IllegalStateException("Erro de rede")
        }
        val emissions = failingFlow.asWgcAsyncUiState().toList()

        assertEquals(2, emissions.size)
        assertTrue(emissions[0] is WgcAsyncUiState.Loading)
        assertTrue(emissions[1] is WgcAsyncUiState.Error)
        assertEquals("Erro de rede", (emissions[1] as WgcAsyncUiState.Error).message)
    }
}
