package br.com.wgc.design_system.templates.base

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class UiEffectChannelTest {

    sealed interface NavigationEffect {
        data class NavigateToDetails(val id: String) : NavigationEffect
        object ShowToast : NavigationEffect
    }

    @Test
    fun sendEffect_shouldEmitEffectToSubscribers() = runBlocking {
        val effectChannel = DefaultUiEffectChannel<NavigationEffect>()

        val job = launch {
            val received = effectChannel.effects.first()
            assertEquals(NavigationEffect.NavigateToDetails("123"), received)
        }

        effectChannel.sendEffect(NavigationEffect.NavigateToDetails("123"))
        job.join()
    }

    @Test
    fun trySendEffect_shouldReturnTrueAndEmitSuccessfully() = runBlocking {
        val effectChannel = DefaultUiEffectChannel<NavigationEffect>()

        val job = launch {
            val received = effectChannel.effects.first()
            assertEquals(NavigationEffect.ShowToast, received)
        }

        val success = effectChannel.trySendEffect(NavigationEffect.ShowToast)
        assertTrue(success)
        job.join()
    }
}
