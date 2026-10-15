package br.com.wgc.design_system.core.tokens

/**
 * Define quando um ícone direcional deve ser espelhado em layouts RTL.
 *
 * Exemplo: `val behavior = WgcMirrorBehavior.MIRROR_IN_RTL`.
 * Quando usar: escolha esta API quando declarar se um recurso deve ser espelhado em RTL.
 */
enum class WgcMirrorBehavior {
    /** Nunca espelha, por exemplo logos, mídia de vídeo e relógios. */
    NEVER,

    /** Espelha em RTL, por exemplo setas de voltar/avançar e carrosséis. */
    MIRROR_IN_RTL
}
