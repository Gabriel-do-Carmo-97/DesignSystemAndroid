package br.com.wgc.design_system.commons

import android.content.ClipboardManager
import android.content.Context
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class WgcClipboardManagerTest {

    private val context = mockk<Context>(relaxed = true)
    private val clipboard = mockk<ClipboardManager>(relaxed = true)
    private val haptic = mockk<WgcHapticFeedback>(relaxed = true)

    @Before
    fun setup() {
        every { context.getSystemService(Context.CLIPBOARD_SERVICE) } returns clipboard
    }

    @Test
    fun `copy should set primary clip and trigger haptic success`() {
        val manager = WgcClipboardManager(context, haptic)
        manager.copy("label", "texto_seguro", isSensitive = true)

        verify { clipboard.setPrimaryClip(any()) }
        verify { haptic.success() }
    }

    @Test
    fun `hasPrimaryClip should delegate to system clipboard`() {
        every { clipboard.hasPrimaryClip() } returns true
        val manager = WgcClipboardManager(context, haptic)

        assertTrue(manager.hasPrimaryClip())

        every { clipboard.hasPrimaryClip() } returns false
        assertFalse(manager.hasPrimaryClip())
    }

    @Test
    fun `clear should clear clipboard`() {
        val manager = WgcClipboardManager(context, haptic)
        manager.clear()

        verify { clipboard.setPrimaryClip(any()) }
    }
}
