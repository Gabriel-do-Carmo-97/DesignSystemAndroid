package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.pix.BasePixTransferViewModel
import br.com.wgc.design_system.templates.screens.pix.FakePixTransferViewModel
import br.com.wgc.design_system.templates.screens.pix.WgcPixTransferTemplate

/**
 * Fábrica universal para instanciação padronizada do template de Transferência Pix.
 * Respeita a regra de defaults corporativos sensatos e customização via slots.
 */
object WgcPixFactory {

    /**
     * Cria e retorna o Composable do template de Transferência Pix.
     *
     * @param modifier Modificador de layout
     * @param viewModel Instância do ViewModel base (default: FakePixTransferViewModel)
     * @param headerSlot Slot customizado para TopBar / cabeçalho
     * @param confirmButtonSlot Slot customizado para o botão de confirmação da transferência
     */
    @Composable
    fun Create(
        modifier: Modifier = Modifier,
        viewModel: BasePixTransferViewModel = FakePixTransferViewModel(),
        headerSlot: (@Composable () -> Unit)? = null,
        confirmButtonSlot: (@Composable () -> Unit)? = null
    ) {
        WgcPixTransferTemplate(
            modifier = modifier,
            viewModel = viewModel,
            headerSlot = headerSlot,
            confirmButtonSlot = confirmButtonSlot
        )
    }
}
