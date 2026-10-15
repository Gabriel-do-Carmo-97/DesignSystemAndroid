package br.com.wgc.design_system.core.feedback

/**
 * Eventos semânticos que selecionam uma resposta sensorial tátil ou sonora.
 *
 * Exemplo: `WgcHapticAudioSync.performFeedback(view, WgcFeedbackEvent.SELECTION_CLICK)`.
 * Quando usar: escolha esta API quando escolher o tipo semntico de feedback sensorial a emitir.
 */
enum class WgcFeedbackEvent {
    SELECTION_CLICK,
    OPERATION_SUCCESS,
    WARNING_ALERT,
    ERROR_ALERT
}
