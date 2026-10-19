package br.com.wgc.design_system.core.brand

/**
 * Metadados acessíveis e chave semântica para localizar uma ilustração de marca.
 *
 * Exemplo: `val spec = WgcBrandIllustrations.getIllustration(WgcIllustrationType.NO_INTERNET)`.
 * Quando usar: escolha esta API quando fornecer a chave e os metadados acessíveis de uma ilustração.
 */
data class WgcIllustrationSpec(
    val type: WgcIllustrationType,
    val brandType: WgcBrandType,
    val contentDescription: String,
    val semanticKey: String
)
