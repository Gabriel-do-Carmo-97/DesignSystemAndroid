package br.com.wgc.design_system.core.theme

/**
 * Modo visual ativo no contexto de tema do Design System.
 *
 * Exemplo: `WgcThemeContext.updateTheme(WgcThemeMode.DARK)`.
 * Quando usar: escolha esta API quando indicar o modo claro ou escuro do tema ativo.
 */
enum class WgcThemeMode {
    LIGHT,
    DARK,
    HIGH_CONTRAST
}
