package br.com.wgc.design_system.core

object WgcCoreDsMotion {
    /** 100ms - Duração muito rápida */
    const val durationFast100 = CoreConstants.CoreDsMotion.DURATION_FAST100

    /** 150ms - Duração rápida para microinterações e fade outs */
    const val durationShort150 = CoreConstants.CoreDsMotion.DURATION_SHORT150

    /** 200ms - Duração rápida */
    const val durationNormal200 = CoreConstants.CoreDsMotion.DURATION_NORMAL200

    /** 200ms - Alias ergonômico para duração rápida */
    const val durationShort200 = CoreConstants.CoreDsMotion.DURATION_SHORT200

    /** 300ms - Duração padrão */
    const val durationStandard300 = CoreConstants.CoreDsMotion.DURATION_STANDARD300

    /** 500ms - Duração lenta / ênfase */
    const val durationSlow500 = CoreConstants.CoreDsMotion.DURATION_SLOW500

    /** 700ms - Duração muito lenta para fluxos complexos de onboarding e celebração */
    const val durationExtraSlow700 = CoreConstants.CoreDsMotion.DURATION_EXTRA_SLOW700

    // --- ESPECIFICAÇÕES DE FÍSICA DE MOLA (SPRING PHYSICS) ---
    /** Amortecimento sem quique (sem overshoot) */
    const val springDampingNoBouncy = CoreConstants.CoreDsMotion.SPRING_DAMPING_NO_BOUNCY

    /** Amortecimento padrão suave e responsivo */
    const val springDampingMediumBouncy = CoreConstants.CoreDsMotion.SPRING_DAMPING_MEDIUM_BOUNCY

    /** Amortecimento com alto quique para microinterações lúdicas */
    const val springDampingHighBouncy = CoreConstants.CoreDsMotion.SPRING_DAMPING_HIGH_BOUNCY

    /** Rigidez baixa (movimento lento e fluido) */
    const val springStiffnessLow = CoreConstants.CoreDsMotion.SPRING_STIFFNESS_LOW

    /** Rigidez média (movimento natural para elementos normais) */
    const val springStiffnessMedium = CoreConstants.CoreDsMotion.SPRING_STIFFNESS_MEDIUM

    /** Rigidez alta (movimento instantâneo e ágil para botões e toques rápidos) */
    const val springStiffnessHigh = CoreConstants.CoreDsMotion.SPRING_STIFFNESS_HIGH

    /** Curva de aceleração e desaceleração com ênfase (Emphasized) */
    val easingEmphasized = WgcCubicBezier(0.2f, 0.0f, 0.0f, 1.0f)

    /** Curva de desaceleração com ênfase (Emphasized Decelerate) para entradas */
    val easingEmphasizedDecelerate = WgcCubicBezier(0.05f, 0.7f, 0.1f, 1.0f)

    /** Curva de aceleração com ênfase (Emphasized Accelerate) para saídas */
    val easingEmphasizedAccelerate = WgcCubicBezier(0.3f, 0.0f, 0.8f, 0.15f)

    /** Curva padrão de desaceleração (Standard Decelerate) */
    val easingStandardDecelerate = WgcCubicBezier(0.0f, 0.0f, 0.2f, 1.0f)

    /** Curva padrão de aceleração (Standard Accelerate) */
    val easingStandardAccelerate = WgcCubicBezier(0.4f, 0.0f, 1.0f, 1.0f)
}

/**
 * Representação agnóstica de curva Cubic Bezier para transições e animações de UI.
 */
data class WgcCubicBezier(
    val x1: Float,
    val y1: Float,
    val x2: Float,
    val y2: Float
)
