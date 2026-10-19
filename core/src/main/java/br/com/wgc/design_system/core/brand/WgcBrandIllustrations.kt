package br.com.wgc.design_system.core.brand

/**
 * Provedor de Ilustrações Multi-Brand corporativo.
 *
 * Exemplo: `WgcBrandIllustrations.getIllustration(WgcIllustrationType.EMPTY_STATE)`.
 * Quando usar: escolha esta API quando resolver uma ilustração semântica para uma marca.
 */
object WgcBrandIllustrations {

    fun getIllustration(type: WgcIllustrationType, brandType: WgcBrandType = WgcBrandType.DEFAULT): WgcIllustrationSpec {
        val semanticKey = "wgc_ill_${brandType.name.lowercase()}_${type.name.lowercase()}"
        val desc = when (type) {
            WgcIllustrationType.EMPTY_STATE -> "Nenhum dado encontrado para ${brandType.name}"
            WgcIllustrationType.NO_INTERNET -> "Sem conexão à internet"
            WgcIllustrationType.PAYMENT_SUCCESS -> "Operação concluída com sucesso"
            WgcIllustrationType.SECURITY_SHIELD -> "Autenticação e segurança protegida"
            WgcIllustrationType.WELCOME_ONBOARDING -> "Bem-vindo ao ecossistema corporativo"
            WgcIllustrationType.ERROR_GENERAL -> "Ocorreu uma instabilidade temporária"
        }
        return WgcIllustrationSpec(
            type = type,
            brandType = brandType,
            contentDescription = desc,
            semanticKey = semanticKey
        )
    }
}
