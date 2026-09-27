package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.feedback.BaseErrorStateViewModel
import br.com.wgc.design_system.templates.screens.feedback.FakeErrorStateViewModel
import br.com.wgc.design_system.templates.screens.feedback.WgcErrorStateTemplate
import br.com.wgc.design_system.templates.screens.feedback.WgcErrorStateType
import br.com.wgc.design_system.templates.screens.feedback.WgcErrorStateUiState

/**
 * Fábrica Universal Corporativa para Telas de Erro e Resiliência (WgcErrorStateFactory).
 * Provê telas completas com defaults sensatos de produção e slots opcionais de customização.
 */
object WgcErrorStateFactory {

    /**
     * Cria tela de erro genérico com botão de retry.
     */
    @Composable
    fun GenericError(
        modifier: Modifier = Modifier,
        onRetryClick: () -> Unit = {},
        illustrationSlot: (@Composable () -> Unit)? = null
    ) {
        val viewModel = FakeErrorStateViewModel(
            initialState = WgcErrorStateUiState(
                type = WgcErrorStateType.GENERIC_ERROR,
                title = "Ops! Algo deu errado",
                description = "Ocorreu uma instabilidade momentânea em nossos servidores. Por favor, tente novamente.",
                actionButtonText = "Tentar Novamente"
            )
        )
        WgcErrorStateTemplate(
            modifier = modifier,
            viewModel = viewModel,
            illustrationSlot = illustrationSlot
        )
    }

    /**
     * Cria tela de resiliência sem conexão com a internet.
     */
    @Composable
    fun NoInternet(
        modifier: Modifier = Modifier,
        onRetryClick: () -> Unit = {},
        illustrationSlot: (@Composable () -> Unit)? = null
    ) {
        val viewModel = FakeErrorStateViewModel(
            initialState = WgcErrorStateUiState(
                type = WgcErrorStateType.NO_INTERNET,
                title = "Sem Conexão à Internet",
                description = "Verifique sua conexão Wi-Fi ou dados móveis e tente novamente para continuar navegando.",
                actionButtonText = "Recarregar"
            )
        )
        WgcErrorStateTemplate(
            modifier = modifier,
            viewModel = viewModel,
            illustrationSlot = illustrationSlot
        )
    }

    /**
     * Cria tela de estado vazio quando uma busca ou lista não possui itens.
     */
    @Composable
    fun EmptyState(
        modifier: Modifier = Modifier,
        title: String = "Nenhum resultado encontrado",
        description: String = "Não encontramos nenhum item correspondente à sua busca.",
        actionButtonText: String? = "Limpar Filtros",
        illustrationSlot: (@Composable () -> Unit)? = null
    ) {
        val viewModel = FakeErrorStateViewModel(
            initialState = WgcErrorStateUiState(
                type = WgcErrorStateType.EMPTY_STATE,
                title = title,
                description = description,
                actionButtonText = actionButtonText
            )
        )
        WgcErrorStateTemplate(
            modifier = modifier,
            viewModel = viewModel,
            illustrationSlot = illustrationSlot
        )
    }
}
