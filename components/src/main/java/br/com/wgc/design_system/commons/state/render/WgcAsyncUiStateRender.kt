package br.com.wgc.design_system.commons.state.render

import androidx.compose.runtime.Composable
import br.com.wgc.design_system.commons.state.model.WgcAsyncUiState

/**
 * Despacha a renderização Compose para o callback correspondente ao estado assíncrono.
 *
 * Use dentro da UI para manter os ramos de carregamento, erro, inatividade e sucesso explícitos.
 * Se `onIdle` não for fornecido, `Idle` é renderizado com `onLoading`.
 *
 * ```kotlin
 * uiState.Render(
 *     onLoading = { CircularProgressIndicator() },
 *     onError = { message, _ -> Text(message ?: "Falha") },
 *     onSuccess = { user -> Text(user.name) },
 * )
 * ```
 *
 * @param onLoading Conteúdo exibido enquanto o estado for [WgcAsyncUiState.Loading].
 * @param onError Conteúdo de falha; recebe mensagem e exceção opcionais.
 * @param onIdle Conteúdo para [WgcAsyncUiState.Idle]; se omitido, usa `onLoading`.
 * @param onSuccess Conteúdo que recebe o dado carregado.
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
