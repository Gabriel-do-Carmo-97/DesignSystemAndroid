package br.com.wgc.design_system.components.media

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class WgcMediaPickerTest {

    @Test
    fun defaultStateIsIdle() {
        val state: WgcMediaUploadState = WgcMediaUploadState.Idle
        assertEquals(WgcMediaUploadState.Idle, state)
    }

    @Test
    fun uploadingStateContainsCorrectProgress() {
        val state = WgcMediaUploadState.Uploading(progress = 0.65f)
        assertEquals(0.65f, state.progress, 0.001f)
    }

    @Test
    fun successStateContainsFileMetadata() {
        val state = WgcMediaUploadState.Success(
            fileName = "contrato.pdf",
            fileSize = "1.8 MB"
        )
        assertEquals("contrato.pdf", state.fileName)
        assertEquals("1.8 MB", state.fileSize)
    }

    @Test
    fun errorStateContainsErrorMessage() {
        val state = WgcMediaUploadState.Error(
            errorMessage = "Arquivo excede o limite de 10MB"
        )
        assertEquals("Arquivo excede o limite de 10MB", state.errorMessage)
    }

    @Test
    fun callbacksTriggerCorrectly() {
        var picked = false
        var removed = false
        var retried = false

        val onPick = { picked = true }
        val onRemove = { removed = true }
        val onRetry = { retried = true }

        onPick()
        onRemove()
        onRetry()

        assertTrue(picked)
        assertTrue(removed)
        assertTrue(retried)
    }
}
