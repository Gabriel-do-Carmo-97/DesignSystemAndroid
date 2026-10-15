package br.com.wgc.design_system.core.theme

/**
 * Facade unificada para as cores do WGC Design System.
 * Garante compatibilidade direta com testes de integração e código legado.
 */
/**
 * Alias de compatibilidade de nomenclatura para acessar a paleta de cores do core.
 *
 * Exemplo: `val accent = WgcCoreDsColorsFacade.orange500`.
 * Quando usar: escolha esta API quando acessar a facade de compatibilidade da paleta de cores.
 */
typealias WgcCoreDsColorsFacade = WgcCoreDsColors
