package br.com.wgc.design_system.commons.state.model

/**
 * Interface selada que padroniza o ciclo de vida assíncrono para telas, templates
 * e componentes reativos do Design System WGC.
 *
 * Elimina acoplamento com modelos de dados de backend e facilita a renderização
 * de estados visuais (Skeleton, Loading, Sucesso, Erro).
 *
 * Use para representar o estado de uma operação assíncrona na UI e renderize-o com `Render` ou
 * transforme fluxos com `asWgcAsyncUiState()`.
 *
 * ```kotlin
 * val state: WgcAsyncUiState<User> = WgcAsyncUiState.Success(user)
 * ```
 *
 * @param T O tipo de dado retornado em caso de sucesso.
 */
sealed interface WgcAsyncUiState<out T> {

    /**
     * Estado inativo antes do início de uma ação ou quando não há resultado a exibir.
     */
    data object Idle : WgcAsyncUiState<Nothing>

    /**
     * Estado indicando que uma operação está em andamento e a UI pode exibir carregamento.
     */
    data object Loading : WgcAsyncUiState<Nothing>

    /**
     * Estado com resultado carregado com sucesso.
     *
     * @param data O dado pronto para consumo visual.
     */
    data class Success<out T>(val data: T) : WgcAsyncUiState<T>

    /**
     * Estado de falha, com mensagem opcional para a UI e exceção opcional para diagnóstico.
     *
     * @param message Mensagem de erro amigável.
     * @param throwable Exceção opcional capturada.
     */
    data class Error(
        val message: String? = null,
        val throwable: Throwable? = null,
    ) : WgcAsyncUiState<Nothing>
}
