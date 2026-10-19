package br.com.wgc.design_system.core.feedback

import android.view.HapticFeedbackConstants
import android.view.View

/**
 * Utilitário de despacho sincronizado de feedback tátil e sonoro corporativo.
 * Exemplo: `WgcHapticAudioSync.performFeedback(view, WgcFeedbackEvent.OPERATION_SUCCESS)`.
 * Quando usar: escolha esta API quando despachar feedback háptico e, opcionalmente, sonoro.
 */
object WgcHapticAudioSync {

    /**
     * Executa o feedback tátil e sonoro no componente View ancorado.
     * Quando usar: chame este método ao emitir o feedback sensorial correspondente a uma ação.
     */
    fun performFeedback(view: View, event: WgcFeedbackEvent, enableSound: Boolean = false) {
        val hapticConstant = when (event) {
            WgcFeedbackEvent.SELECTION_CLICK -> HapticFeedbackConstants.KEYBOARD_TAP
            WgcFeedbackEvent.OPERATION_SUCCESS -> HapticFeedbackConstants.CONFIRM
            WgcFeedbackEvent.WARNING_ALERT -> HapticFeedbackConstants.REJECT
            WgcFeedbackEvent.ERROR_ALERT -> HapticFeedbackConstants.LONG_PRESS
        }
        view.performHapticFeedback(hapticConstant)
        if (enableSound) {
            view.playSoundEffect(android.view.SoundEffectConstants.CLICK)
        }
    }
}
