package br.com.wgc.design_system.commons.state.extensions

import br.com.wgc.design_system.commons.state.model.WgcAsyncUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

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
