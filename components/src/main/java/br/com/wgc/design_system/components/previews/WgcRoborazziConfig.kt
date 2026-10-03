package br.com.wgc.design_system.components.previews

/**
 * Anotação e configuração corporativa para testes de regressão visual com Roborazzi.
 * Valida automaticamente a matriz 2x4x2 (Temas x Escalares de Fonte x Orientações).
 */
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class WgcRoborazziTestSpec(
    val testName: String = "",
    val testThemes: Boolean = true,
    val testFontScales: Boolean = true,
    val testRtl: Boolean = true,
    val tolerance: Float = 0.01f // 1% threshold para prevenir falsos positivos de anti-aliasing
)
