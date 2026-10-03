package br.com.wgc.design_system.commons

import androidx.compose.runtime.Composable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

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

/**
 * Retorna o dado de [WgcAsyncUiState.Success] ou `null` caso contrário.
 */
fun <T> WgcAsyncUiState<T>.getOrNull(): T? =
    when (this) {
        is WgcAsyncUiState.Success -> data
        else -> null
    }

/**
 * Retorna se o estado atual é de carregamento ([WgcAsyncUiState.Loading]).
 */
fun <T> WgcAsyncUiState<T>.isLoading(): Boolean = this is WgcAsyncUiState.Loading

/**
 * Retorna se o estado atual é de sucesso ([WgcAsyncUiState.Success]).
 */
fun <T> WgcAsyncUiState<T>.isSuccess(): Boolean = this is WgcAsyncUiState.Success

/**
 * Retorna se o estado atual é de falha ([WgcAsyncUiState.Error]).
 */
fun <T> WgcAsyncUiState<T>.isError(): Boolean = this is WgcAsyncUiState.Error

/**
 * Mapeia o dado contido em caso de [WgcAsyncUiState.Success], preservando os demais estados.
 */
inline fun <T, R> WgcAsyncUiState<T>.map(transform: (T) -> R): WgcAsyncUiState<R> =
    when (this) {
        is WgcAsyncUiState.Idle -> WgcAsyncUiState.Idle
        is WgcAsyncUiState.Loading -> WgcAsyncUiState.Loading
        is WgcAsyncUiState.Success -> WgcAsyncUiState.Success(transform(data))
        is WgcAsyncUiState.Error -> WgcAsyncUiState.Error(message, throwable)
    }

/**
 * Converte um [Flow] em um [Flow] observável de [WgcAsyncUiState], emitindo automaticamente
 * [WgcAsyncUiState.Loading] no início e interceptando erros em [WgcAsyncUiState.Error].
 */
fun <T> Flow<T>.asWgcAsyncUiState(): Flow<WgcAsyncUiState<T>> =
    this
        .map<T, WgcAsyncUiState<T>> { WgcAsyncUiState.Success(it) }
        .onStart { emit(WgcAsyncUiState.Loading) }
        .catch { emit(WgcAsyncUiState.Error(message = it.localizedMessage, throwable = it)) }

/**
 * Renderizador declarativo de estados assíncronos no Jetpack Compose.
 */
@Composable
fun <T> WgcAsyncUiState<T>.Render(
    onLoading: @Composable () -> Unit,
    onError: @Composable (message: String?, throwable: Throwable?) -> Unit,
    onIdle: (@Composable () -> Unit)? = null,
    onSuccess: @Composable (data: T) -> Unit,
) {
    when (this) {
        is WgcAsyncUiState.Idle -> onIdle?.invoke() ?: onLoading()
        is WgcAsyncUiState.Loading -> onLoading()
        is WgcAsyncUiState.Success -> onSuccess(data)
        is WgcAsyncUiState.Error -> onError(message, throwable)
    }
}
