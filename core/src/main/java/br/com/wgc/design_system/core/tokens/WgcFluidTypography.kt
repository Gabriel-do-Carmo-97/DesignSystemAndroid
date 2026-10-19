@file:Suppress("MagicNumber")

package br.com.wgc.design_system.core.tokens

import br.com.wgc.design_system.constants.CoreConstants

/**
 * Utilitário de Tipografia Fluida (Fluid Typography) para dimensionamento harmônico
 * entre smartphones compactos, dispositivos dobráveis (foldables) e tablets.
 * Implementação pura sem acoplamento a UI framework.
 * Exemplo: `val sizeSp = WgcFluidTypography.clampSp(widthDp, 14f, 20f)`.
 * Quando usar: escolha esta API quando limitar ou interpolar tamanho de texto conforme a tela.
 */
object WgcFluidTypography {

    const val DEFAULT_MIN_VIEWPORT_WIDTH_DP = CoreConstants.FluidTypography.DEFAULT_MIN_VIEWPORT_WIDTH_DP
    const val DEFAULT_MAX_VIEWPORT_WIDTH_DP = CoreConstants.FluidTypography.DEFAULT_MAX_VIEWPORT_WIDTH_DP

    /**
     * Função pura para cálculo de clamp de tamanho de texto em sp com base na largura da viewport em dp.
     * Quando usar: chame este método ao limitar o tamanho do texto conforme a largura da viewport.
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
