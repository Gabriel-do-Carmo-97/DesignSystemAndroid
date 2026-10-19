package br.com.wgc.design_system.commons.state.extensions

import br.com.wgc.design_system.commons.state.model.WgcAsyncUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

/**
 * Retorna o dado de sucesso ou `null` para os demais estados.
 *
 * Use quando um valor opcional for suficiente e não for necessário distinguir carregamento de erro.
 * Exemplo: `val user = state.getOrNull()`.
 */
fun <T> WgcAsyncUiState<T>.getOrNull(): T? =
    when (this) {
        is WgcAsyncUiState.Success -> data
        else -> null
    }

/**
 * Verifica se o estado está em carregamento.
 *
 * Exemplo: `if (state.isLoading()) showSpinner()`.
 */
fun <T> WgcAsyncUiState<T>.isLoading(): Boolean = this is WgcAsyncUiState.Loading

/**
 * Verifica se o estado contém um resultado de sucesso.
 *
 * Exemplo: `if (state.isSuccess()) enableContinue()`.
 */
fun <T> WgcAsyncUiState<T>.isSuccess(): Boolean = this is WgcAsyncUiState.Success

/**
 * Verifica se o estado representa uma falha.
 *
 * Exemplo: `if (state.isError()) showRetry()`.
 */
fun <T> WgcAsyncUiState<T>.isError(): Boolean = this is WgcAsyncUiState.Error

/**
 * Transforma somente o dado em [WgcAsyncUiState.Success], preservando os outros estados.
 *
 * Use para adaptar o modelo exibido sem alterar o estado assíncrono. Exemplo:
 * `val names = state.map { user -> user.name }`.
 *
 * @param transform Conversão aplicada ao dado de sucesso.
 */
inline fun <T, R> WgcAsyncUiState<T>.map(transform: (T) -> R): WgcAsyncUiState<R> =
    when (this) {
        is WgcAsyncUiState.Idle -> WgcAsyncUiState.Idle
        is WgcAsyncUiState.Loading -> WgcAsyncUiState.Loading
        is WgcAsyncUiState.Success -> WgcAsyncUiState.Success(transform(data))
        is WgcAsyncUiState.Error -> WgcAsyncUiState.Error(message, throwable)
    }

/**
 * Converte emissões de um [Flow] em estados assíncronos: emite [WgcAsyncUiState.Loading] no início,
 * envolve cada valor em [WgcAsyncUiState.Success] e converte exceções em [WgcAsyncUiState.Error].
 *
 * Use ao conectar um fluxo de dados à UI. Exemplo: `repository.observeUser().asWgcAsyncUiState()`.
 * O operador `catch` trata erros emitidos antes do término do fluxo; cancelamento segue as regras
 * usuais de corrotinas.
 */
fun <T> Flow<T>.asWgcAsyncUiState(): Flow<WgcAsyncUiState<T>> =
    this
        .map<T, WgcAsyncUiState<T>> { WgcAsyncUiState.Success(it) }
        .onStart { emit(WgcAsyncUiState.Loading) }
        .catch { emit(WgcAsyncUiState.Error(message = it.localizedMessage, throwable = it)) }
