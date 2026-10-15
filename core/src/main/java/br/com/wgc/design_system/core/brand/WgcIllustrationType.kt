package br.com.wgc.design_system.core.brand

/**
 * Categorias semânticas de ilustrações corporativas suportadas pelo Design System.
 *
 * Exemplo: `WgcBrandIllustrations.getIllustration(WgcIllustrationType.EMPTY_STATE)`.
 * Quando usar: escolha esta API quando indicar a finalidade semântica de uma ilustração.
 */
enum class WgcIllustrationType {
    EMPTY_STATE,
    NO_INTERNET,
    PAYMENT_SUCCESS,
    SECURITY_SHIELD,
    WELCOME_ONBOARDING,
    ERROR_GENERAL
}
