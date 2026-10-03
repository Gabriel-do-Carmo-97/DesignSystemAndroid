package br.com.wgc.design_system.core

/**
 * Resolução desacoplada de assets visuais institucionais (logotipos, ícones de splash e favicons) por tenant whitelabel.
 */
object WgcWhitelabelAssetResolver {

    data class BrandAssetSet(
        val logoAssetPath: String,
        val markAssetPath: String,
        val splashBackgroundArgb: Int,
        val primaryAccentArgb: Int
    )

    private val brandRegistry = mutableMapOf(
        "default" to BrandAssetSet(
            logoAssetPath = "brands/default/logo.svg",
            markAssetPath = "brands/default/mark.svg",
            splashBackgroundArgb = 0xFFFFFFFF.toInt(),
            primaryAccentArgb = 0xFF1E88E5.toInt()
        ),
        "fintech" to BrandAssetSet(
            logoAssetPath = "brands/fintech/logo.svg",
            markAssetPath = "brands/fintech/mark.svg",
            splashBackgroundArgb = 0xFF0D1B2A.toInt(),
            primaryAccentArgb = 0xFF00E5FF.toInt()
        ),
        "retail" to BrandAssetSet(
            logoAssetPath = "brands/retail/logo.svg",
            markAssetPath = "brands/retail/mark.svg",
            splashBackgroundArgb = 0xFFFFFFFF.toInt(),
            primaryAccentArgb = 0xFFE53935.toInt()
        )
    )

    fun resolve(tenant: String): BrandAssetSet {
        return brandRegistry[tenant.lowercase()] ?: brandRegistry["default"]!!
    }

    fun registerTenant(tenant: String, assets: BrandAssetSet) {
        brandRegistry[tenant.lowercase()] = assets
    }
}
