package br.com.wgc.design_system.commons.state.render

import androidx.compose.runtime.Composable
import br.com.wgc.design_system.commons.state.model.WgcAsyncUiState

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
