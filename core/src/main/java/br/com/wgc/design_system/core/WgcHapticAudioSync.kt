package br.com.wgc.design_system.core

import android.view.HapticFeedbackConstants
import android.view.View

/**
 * Tipos de eventos com feedback sensorial sincronizado (tátil e sonoro).
 */
enum class WgcFeedbackEvent {
    SELECTION_CLICK,
    OPERATION_SUCCESS,
    WARNING_ALERT,
    ERROR_ALERT
}

/**
 * Utilitário de despacho sincronizado de feedback tátil e sonoro corporativo.
 */
object WgcHapticAudioSync {

    /**
     * Executa o feedback tátil e sonoro no componente View ancorado.
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
