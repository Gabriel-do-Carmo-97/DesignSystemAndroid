package br.com.wgc.design_system.core.brand

/**
 * Resolução desacoplada de assets visuais institucionais (logotipos, ícones de splash e favicons) por tenant whitelabel.
 * Exemplo: `WgcWhitelabelAssetResolver.resolve("default")`.
 * Quando usar: escolha esta API quando registrar ou resolver assets visuais por tenant.
 */
object WgcWhitelabelAssetResolver {

    private val brandRegistry = mutableMapOf(
        "default" to WgcBrandAssetSet(
            logoAssetPath = "brands/default/logo.svg",
            markAssetPath = "brands/default/mark.svg",
            splashBackgroundArgb = 0xFFFFFFFF.toInt(),
            primaryAccentArgb = 0xFF1E88E5.toInt()
        ),
        "fintech" to WgcBrandAssetSet(
            logoAssetPath = "brands/fintech/logo.svg",
            markAssetPath = "brands/fintech/mark.svg",
            splashBackgroundArgb = 0xFF0D1B2A.toInt(),
            primaryAccentArgb = 0xFF00E5FF.toInt()
        ),
        "retail" to WgcBrandAssetSet(
            logoAssetPath = "brands/retail/logo.svg",
            markAssetPath = "brands/retail/mark.svg",
            splashBackgroundArgb = 0xFFFFFFFF.toInt(),
            primaryAccentArgb = 0xFFE53935.toInt()
        )
    )

    fun resolve(tenant: String): WgcBrandAssetSet {
        return brandRegistry[tenant.lowercase()] ?: brandRegistry["default"]!!
    }

    fun registerTenant(tenant: String, assets: WgcBrandAssetSet) {
        brandRegistry[tenant.lowercase()] = assets
    }
}
