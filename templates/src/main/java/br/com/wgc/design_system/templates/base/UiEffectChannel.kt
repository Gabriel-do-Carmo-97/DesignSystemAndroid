package br.com.wgc.design_system.templates.base

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

/**
 * Contrato para canais de efeitos colaterais de UI de disparo único (single-shot events).
 *
 * Utilizado em ViewModels para emitir eventos transitórios como navegação, toasts,
 * snackbars e diálogos, prevenindo reexecuções indevidas durante recomposições de tela no Jetpack Compose.
 *
 * @param T Tipo do evento de efeito colateral.
 */
interface UiEffectChannel<T> {
    /**
     * Fluxo frio ([Flow]) observável que emite os efeitos enviados ao canal.
     */
    val effects: Flow<T>

    /**
     * Envia um efeito para o canal de forma suspensa caso o buffer esteja cheio.
     *
     * @param effect O efeito a ser emitido para a UI.
     */
    suspend fun sendEffect(effect: T)

    /**
     * Tenta enviar imediatamente um efeito sem suspender a corrotina.
     *
     * @param effect O efeito a ser emitido para a UI.
     * @return `true` se o efeito foi enfileirado com sucesso, `false` caso contrário.
     */
    fun trySendEffect(effect: T): Boolean
}

/**
 * Implementação padrão de [UiEffectChannel] utilizando Kotlin Coroutines [Channel].
 *
 * @param T Tipo do evento de efeito colateral.
 * @property capacity Capacidade do buffer do canal, por padrão [Channel.BUFFERED].
 * @property onBufferOverflow Estratégia de descarte de buffer, por padrão [BufferOverflow.SUSPEND].
 */
class DefaultUiEffectChannel<T>(
    capacity: Int = Channel.BUFFERED,
    onBufferOverflow: BufferOverflow = BufferOverflow.SUSPEND,
) : UiEffectChannel<T> {
    private val channel =
        Channel<T>(
            capacity = capacity,
            onBufferOverflow = onBufferOverflow,
        )

    override val effects: Flow<T> = channel.receiveAsFlow()

    override suspend fun sendEffect(effect: T) {
        channel.send(effect)
    }

    override fun trySendEffect(effect: T): Boolean = channel.trySend(effect).isSuccess
}
