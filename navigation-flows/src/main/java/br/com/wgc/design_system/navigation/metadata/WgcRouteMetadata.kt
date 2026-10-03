package br.com.wgc.design_system.navigation.metadata

/**
 * Indica que uma rota ou subgrafo exige que a sessão do usuário esteja autenticada.
 */
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class RequiresAuth(
    val redirectRoute: String = "auth/login"
)

/**
 * Define o evento de analytics e telemetria associado automaticamente à visita da tela.
 */
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class AnalyticsEvent(
    val screenName: String,
    val module: String = "DesignSystem"
)

/**
 * Metadados para documentação viva e geração automática de grafos e catálogo de rotas.
 */
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class ScreenDoc(
    val title: String,
    val description: String,
    val ownerTeam: String = "Mobile-Core"
)
