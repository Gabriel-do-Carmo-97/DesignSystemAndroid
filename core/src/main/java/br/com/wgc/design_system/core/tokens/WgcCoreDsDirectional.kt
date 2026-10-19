package br.com.wgc.design_system.core.tokens

import br.com.wgc.design_system.constants.CoreConstants

/**
 * Tokens de Direcionalidade para suporte a layouts LTR (Left-to-Right) e RTL (Right-to-Left).
 * Facilita o espelhamento consistente de padding, alinhamento e ícones direcionais.
 * Exemplo: use `WgcCoreDsDirectional.DIRECTION_RTL` com `WgcMirrorBehavior.MIRROR_IN_RTL`.
 * Quando usar: escolha esta API quando definir orientação de layout e comportamento RTL.
 */
object WgcCoreDsDirectional {
    /** Layout padrão ocidental (Left-to-Right) */
    const val DIRECTION_LTR = CoreConstants.CoreDsDirectional.DIRECTION_LTR

    /** Layout para idiomas do Oriente Médio (Right-to-Left) */
    const val DIRECTION_RTL = CoreConstants.CoreDsDirectional.DIRECTION_RTL
}
