package br.com.wgc.design_system.core.brand

/**
 * Referências visuais e cores principais associadas aos assets de uma marca.
 *
 * Exemplo: `WgcWhitelabelAssetResolver.registerTenant("loja", assets)`.
 * Quando usar: escolha esta API quando agrupar cores e referências visuais de uma identidade de marca.
 */
data class WgcBrandAssetSet(
    val logoAssetPath: String,
    val markAssetPath: String,
    val splashBackgroundArgb: Int,
    val primaryAccentArgb: Int
)
