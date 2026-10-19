package br.com.wgc.design_system.components.alert

/**
 * Tipos de alerta disponíveis no WgcAlert.
 * 
 * Cada tipo define uma paleta de cores e ícone específico seguindo o Material Design 3:
 * - [SUCCESS]: Verde com ícone de check para confirmações positivas
 * - [ERROR]: Vermelho com ícone de erro para falhas e problemas
 * - [WARNING]: Amarelo/laranja com ícone de aviso para situações de atenção
 * - [INFO]: Azul com ícone de informação para comunicados neutros
 */
enum class AlertType {
    /**
     * Alerta de sucesso com fundo verde e ícone de check.
     * Use para confirmar que uma ação foi concluída com sucesso.
     */
    SUCCESS,
    
    /**
     * Alerta de erro com fundo vermelho e ícone de erro.
     * Use para comunicar falhas, erros de validação ou problemas.
     */
    ERROR,
    
    /**
     * Alerta de aviso com fundo amarelo/laranja e ícone de aviso.
     * Use para situações que requerem atenção do usuário.
     */
    WARNING,
    
    /**
     * Alerta informativo com fundo azul e ícone de informação.
     * Use para comunicados, dicas ou informações adicionais.
     */
    INFO
}
