@file:Suppress("MagicNumber")

package br.com.wgc.design_system.core

/**
 * Utilitário de Tipografia Fluida (Fluid Typography) para dimensionamento harmônico
 * entre smartphones compactos, dispositivos dobráveis (foldables) e tablets.
 * Implementação pura sem acoplamento a UI framework.
 */
object WgcFluidTypography {

    const val DEFAULT_MIN_VIEWPORT_WIDTH_DP = 360.0f
    const val DEFAULT_MAX_VIEWPORT_WIDTH_DP = 840.0f

    /**
     * Função pura para cálculo de clamp de tamanho de texto em sp com base na largura da viewport em dp.
     */
    fun clampSp(
        currentWidthDp: Float,
        minSp: Float,
        maxSp: Float,
        minWidthDp: Float = DEFAULT_MIN_VIEWPORT_WIDTH_DP,
        maxWidthDp: Float = DEFAULT_MAX_VIEWPORT_WIDTH_DP
    ): Float {
        if (currentWidthDp <= minWidthDp) return minSp
        if (currentWidthDp >= maxWidthDp) return maxSp

        val widthFraction = (currentWidthDp - minWidthDp) / (maxWidthDp - minWidthDp)
        return minSp + widthFraction * (maxSp - minSp)
    }
}
