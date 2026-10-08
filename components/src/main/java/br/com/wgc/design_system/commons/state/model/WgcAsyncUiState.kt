package br.com.wgc.design_system.commons.state.model

/**
 * Interface selada que padroniza o ciclo de vida assíncrono para telas, templates
 * e componentes reativos do Design System WGC.
 *
 * Elimina acoplamento com modelos de dados de backend e facilita a renderização
 * de estados visuais (Skeleton, Loading, Sucesso, Erro).
 *
 * @param T O tipo de dado retornado em caso de sucesso.
 */
sealed interface WgcAsyncUiState<out T> {

    /**
     * Estado inicial inativo antes do disparo de uma ação.
     */
    data object Idle : WgcAsyncUiState<Nothing>

    /**
     * Estado indicando que uma operação está em carregamento.
     */
    data object Loading : WgcAsyncUiState<Nothing>

    /**
     * Estado com dado carregado com sucesso.
     *
     * @param data O dado pronto para consumo visual.
     */
    data class Success<out T>(val data: T) : WgcAsyncUiState<T>

    /**
     * Estado indicando falha na operação.
     *
     * @param message Mensagem de erro amigável.
     * @param throwable Exceção opcional capturada.
     */
    data class Error(
        val message: String? = null,
        val throwable: Throwable? = null,
    ) : WgcAsyncUiState<Nothing>
}
