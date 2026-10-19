package br.com.wgc.design_system.core.motion

import br.com.wgc.design_system.constants.CoreConstants

/**
 * Tokens de coreografia de movimento e transições escalonadas (stagger) para o Design System.
 * Exemplo: `val delayMs = WgcMotionChoreography.getItemDelay(itemIndex)`.
 * Quando usar: escolha esta API quando escalonar animações de elementos ou selecionar uma curva temporal.
 */
object WgcMotionChoreography {
    const val STAGGER_DELAY_FAST = CoreConstants.MotionChoreography.STAGGER_DELAY_FAST
    const val STAGGER_DELAY_NORMAL = CoreConstants.MotionChoreography.STAGGER_DELAY_NORMAL
    const val STAGGER_DELAY_SLOW = CoreConstants.MotionChoreography.STAGGER_DELAY_SLOW

    const val CASCADE_DURATION_SHORT = CoreConstants.MotionChoreography.CASCADE_DURATION_SHORT
    const val CASCADE_DURATION_MEDIUM = CoreConstants.MotionChoreography.CASCADE_DURATION_MEDIUM
    const val CASCADE_DURATION_LONG = CoreConstants.MotionChoreography.CASCADE_DURATION_LONG

    // Standard Cubic Bezier timing curves
    const val EASE_IN_OUT_CUBIC = CoreConstants.MotionChoreography.EASE_IN_OUT_CUBIC
    const val EASE_OUT_QUAD = CoreConstants.MotionChoreography.EASE_OUT_QUAD

    /**
     * Calcula o delay escalonado para um item de lista com base em seu índice.
     * Quando usar: chame este método ao calcular o atraso escalonado de cada item de uma lista animada.
     */
    fun getItemDelay(index: Int, stepDelayMs: Int = STAGGER_DELAY_NORMAL, maxDelayMs: Int = CASCADE_DURATION_LONG): Int {
        val delay = index * stepDelayMs
        return if (delay > maxDelayMs) maxDelayMs else delay
    }
}
