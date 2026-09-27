package br.com.wgc.design_system.core

/**
 * Tokens de Direcionalidade para suporte a layouts LTR (Left-to-Right) e RTL (Right-to-Left).
 * Facilita o espelhamento consistente de padding, alinhamento e ícones direcionais.
 */
object WgcCoreDsDirectional {
    /** Layout padrão ocidental (Left-to-Right) */
    const val directionLtr = "LTR"

    /** Layout para idiomas do Oriente Médio (Right-to-Left) */
    const val directionRtl = "RTL"

    /**
     * Define se um ícone deve ser espelhado dinamicamente quando em ambiente RTL.
     */
    enum class WgcMirrorBehavior {
        /** Nunca espelha (ex: logos, mídias de vídeo, relógios) */
        NEVER,

        /** Sempre espelha em RTL (ex: setas de voltar, setas de avançar, carrosséis) */
        MIRROR_IN_RTL
    }
}
