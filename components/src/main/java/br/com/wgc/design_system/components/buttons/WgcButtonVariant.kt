package br.com.wgc.design_system.components.buttons

/**
 * Variantes suportadas pelo WgcButton.
 * 
 * Esta enum define os estilos visuais disponíveis para o botão:
 * - [Primary]: Botão principal com fundo preenchido na cor primária
 * - [Secondary]: Botão secundário com fundo na cor secundária
 * - [Outlined]: Botão com borda e fundo transparente
 * - [Ghost]: Botão apenas com texto, sem borda nem fundo
 * - [Danger]: Botão com fundo na cor de erro/aviso
 */
enum class WgcButtonVariant {
    /**
     * Botão principal com fundo preenchido na cor primária do tema.
     * Use para ações principais e de alta importância.
     */
    Primary,
    
    /**
     * Botão secundário com fundo na cor secundária do tema.
     * Use para ações de importância média ou alternativas.
     */
    Secondary,
    
    /**
     * Botão com borda e fundo transparente.
     * Use para ações que não devem chamar muita atenção.
     */
    Outlined,
    
    /**
     * Botão apenas com texto, sem borda nem fundo.
     * Use para ações secundárias ou links clicáveis.
     */
    Ghost,
    
    /**
     * Botão com fundo na cor de erro/aviso.
     * Use para ações destrutivas ou de alto risco.
     */
    Danger
}
