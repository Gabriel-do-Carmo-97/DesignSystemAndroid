package br.com.wgc.design_system.core

/**
 * Nível de maturidade corporativa e estabilidade de um componente ou template do Design System.
 */
enum class WgcMaturityLevel {
    EXPERIMENTAL,
    BETA,
    STABLE,
    DEPRECATED
}

/**
 * Anotação para marcar a maturidade e histórico de versão de componentes e rotas públicas.
 */
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
annotation class WgcMaturity(
    val level: WgcMaturityLevel = WgcMaturityLevel.STABLE,
    val since: String = "1.0.0",
    val deprecationReason: String = ""
)
