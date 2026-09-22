package br.com.wgc.design_system.core

object WgcCoreDsMotion {
    /** 100ms - Duração muito rápida */
    const val durationFast100 = 100

    /** 150ms - Duração rápida para microinterações e fade outs */
    const val durationShort150 = 150

    /** 200ms - Duração rápida */
    const val durationNormal200 = 200

    /** 200ms - Alias ergonômico para duração rápida */
    const val durationShort200 = durationNormal200

    /** 300ms - Duração padrão */
    const val durationStandard300 = 300

    /** 500ms - Duração lenta / ênfase */
    const val durationSlow500 = 500

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
