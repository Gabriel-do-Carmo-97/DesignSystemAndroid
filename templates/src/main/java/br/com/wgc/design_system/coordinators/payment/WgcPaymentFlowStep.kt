package br.com.wgc.design_system.coordinators.payment

/**
 * Etapas do Fluxo de Pagamento.
 */
enum class WgcPaymentFlowStep {
    MethodSelection,
    CardInput,
    PixQrCode,
    Boleto,
    Success
}
