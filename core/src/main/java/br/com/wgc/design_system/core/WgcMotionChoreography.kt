package br.com.wgc.design_system.core

import br.com.wgc.design_system.constants.CoreConstants

/**
 * Tokens de coreografia de movimento e transições escalonadas (stagger) para o Design System.
 */
object WgcMotionChoreography {
    const val staggerDelayFast = CoreConstants.MotionChoreography.STAGGER_DELAY_FAST
    const val staggerDelayNormal = CoreConstants.MotionChoreography.STAGGER_DELAY_NORMAL
    const val staggerDelaySlow = CoreConstants.MotionChoreography.STAGGER_DELAY_SLOW

    const val cascadeDurationShort = CoreConstants.MotionChoreography.CASCADE_DURATION_SHORT
    const val cascadeDurationMedium = CoreConstants.MotionChoreography.CASCADE_DURATION_MEDIUM
    const val cascadeDurationLong = CoreConstants.MotionChoreography.CASCADE_DURATION_LONG

    // Standard Cubic Bezier timing curves
    const val easeInOutCubic = CoreConstants.MotionChoreography.EASE_IN_OUT_CUBIC
    const val easeOutQuad = CoreConstants.MotionChoreography.EASE_OUT_QUAD

    /**
     * Calcula o delay escalonado para um item de lista com base em seu índice.
     */
    fun getItemDelay(index: Int, stepDelayMs: Int = staggerDelayNormal, maxDelayMs: Int = cascadeDurationLong): Int {
        val delay = index * stepDelayMs
        return if (delay > maxDelayMs) maxDelayMs else delay
    }
}
