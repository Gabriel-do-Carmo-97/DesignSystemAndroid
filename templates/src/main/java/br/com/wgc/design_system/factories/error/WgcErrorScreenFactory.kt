package br.com.wgc.design_system.factories.error

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.templates.screens.feedback.FakeErrorStateViewModel
import br.com.wgc.design_system.templates.screens.feedback.WgcErrorStateTemplate
import br.com.wgc.design_system.templates.screens.feedback.WgcErrorStateType
import br.com.wgc.design_system.templates.screens.feedback.WgcErrorStateUiState
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Fábrica Universal de Telas de Erro e Estados Vazios (WgcErrorScreenFactory).
 */
@Composable
fun WgcErrorScreenFactory(
    modifier: Modifier = Modifier,
    variant: WgcErrorVariant = WgcErrorVariant.GENERIC_ERROR,
    onActionClick: () -> Unit = {},
    illustrationSlot: (@Composable () -> Unit)? = null
) {
    val state = when (variant) {
        WgcErrorVariant.GENERIC_ERROR -> WgcErrorStateUiState(
            type = WgcErrorStateType.GENERIC_ERROR,
            title = "Ops! Algo deu errado",
            description = "Ocorreu uma instabilidade em nossos servidores. Por favor, tente novamente.",
            actionButtonText = "Tentar Novamente"
        )
        WgcErrorVariant.NO_INTERNET -> WgcErrorStateUiState(
            type = WgcErrorStateType.NO_INTERNET,
            title = "Sem conexão com a internet",
            description = "Verifique sua conexão Wi-Fi ou dados móveis e tente novamente.",
            actionButtonText = "Verificar Conexão"
        )
        WgcErrorVariant.EMPTY_STATE -> WgcErrorStateUiState(
            type = WgcErrorStateType.EMPTY_STATE,
            title = "Nenhum resultado encontrado",
            description = "Não encontramos nenhum item correspondente aos critérios selecionados.",
            actionButtonText = "Limpar Filtros"
        )
        WgcErrorVariant.SESSION_EXPIRED -> WgcErrorStateUiState(
            type = WgcErrorStateType.GENERIC_ERROR,
            title = "Sessão expirada",
            description = "Sua sessão expirou por segurança. Faça login novamente.",
            actionButtonText = "Fazer Login"
        )
    }

    WgcErrorStateTemplate(
        modifier = modifier,
        viewModel = FakeErrorStateViewModel(
            initialState = state,
            onPrimaryClick = onActionClick
        ),
        illustrationSlot = illustrationSlot
    )
}

@Preview(name = "WgcErrorScreenFactory - Preview", showBackground = true)
@Composable
private fun WgcErrorScreenFactoryPreview() {
    WgcTheme {
        WgcErrorScreenFactory()
    }
}
