package br.com.wgc.design_system.core.brand

/**
 * Identifica uma identidade de marca disponível no ecossistema WGC.
 *
 * Exemplo: `val brand = WgcBrandType.FINANCE`.
 * Quando usar: escolha esta API quando selecionar uma identidade de marca suportada.
 */
enum class WgcBrandType {
    DEFAULT,
    FINANCE,
    FOOD_DELIVERY,
    ECOMMERCE,
    FASHION,
    FITNESS
}
