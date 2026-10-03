package br.com.wgc.design_system.navigation.fixtures

import br.com.wgc.design_system.navigation.deeplink.WgcDeepLinkValidator

/**
 * Utilitários e fixtures para testes determinísticos de rotas e navegação.
 */
object WgcNavigationTestFixtures {

    /**
     * Valida se um conjunto de rotas possui identificadores únicos e válidos.
     */
    fun assertUniqueRoutes(vararg routes: Any): Boolean {
        val classNames = routes.map { it::class.qualifiedName }
        return classNames.distinct().size == routes.size
    }

    /**
     * Valida um conjunto de deep links para múltiplos fluxos.
     */
    fun assertDeepLinksValidity(deepLinks: List<String>): Map<String, Boolean> {
        return deepLinks.associateWith { WgcDeepLinkValidator.isValid(it) }
    }
}
