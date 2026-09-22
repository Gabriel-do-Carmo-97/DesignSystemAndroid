package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.card.BaseCardManagementViewModel
import br.com.wgc.design_system.templates.screens.card.FakeCardManagementViewModel
import br.com.wgc.design_system.templates.screens.card.WgcCardManagementTemplate

/**
 * Fábrica universal para instanciação padronizada do template de Gestão de Cartões.
 */
object WgcCardFactory {

    /**
     * Cria e retorna o Composable do template de Gestão de Cartões.
     *
     * @param modifier Modificador de layout
     * @param viewModel Instância do ViewModel base (default: FakeCardManagementViewModel)
     * @param headerSlot Slot customizado para TopBar / cabeçalho
     * @param cardSlot Slot customizado para a visualização do cartão
     */
    @Composable
    fun Create(
        modifier: Modifier = Modifier,
        viewModel: BaseCardManagementViewModel = FakeCardManagementViewModel(),
        headerSlot: (@Composable () -> Unit)? = null,
        cardSlot: (@Composable () -> Unit)? = null
    ) {
        WgcCardManagementTemplate(
            modifier = modifier,
            viewModel = viewModel,
            headerSlot = headerSlot,
            cardSlot = cardSlot
        )
    }
}
