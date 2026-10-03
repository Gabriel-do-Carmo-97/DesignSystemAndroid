package br.com.wgc.design_system.core

/**
 * Tokens de coreografia de movimento e transições escalonadas (stagger) para o Design System.
 */
object WgcMotionChoreography {
    const val staggerDelayFast = 40
    const val staggerDelayNormal = 75
    const val staggerDelaySlow = 120

    const val cascadeDurationShort = 200
    const val cascadeDurationMedium = 350
    const val cascadeDurationLong = 500

    // Standard Cubic Bezier timing curves
    const val easeInOutCubic = "cubic-bezier(0.65, 0, 0.35, 1)"
    const val easeOutQuad = "cubic-bezier(0.25, 0.46, 0.45, 0.94)"

    /**
     * Calcula o delay escalonado para um item de lista com base em seu índice.
     */
    fun getItemDelay(index: Int, stepDelayMs: Int = staggerDelayNormal, maxDelayMs: Int = cascadeDurationLong): Int {
        val delay = index * stepDelayMs
        return if (delay > maxDelayMs) maxDelayMs else delay
    }
}
