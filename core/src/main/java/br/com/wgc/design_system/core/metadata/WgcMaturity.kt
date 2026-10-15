package br.com.wgc.design_system.core.metadata

/**
 * Anotação para marcar a maturidade e histórico de versão de componentes e rotas públicas.
 * Exemplo: `@WgcMaturity(level = WgcMaturityLevel.BETA, since = "1.1.0")`.
 * Quando usar: escolha esta API quando marcar a estabilidade e a versão de introdução de uma API pública.
 */
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
annotation class WgcMaturity(
    val level: WgcMaturityLevel = WgcMaturityLevel.STABLE,
    val since: String = "1.0.0",
    val deprecationReason: String = ""
)
