package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.loan.BaseLoanSimulatorViewModel
import br.com.wgc.design_system.templates.screens.loan.FakeLoanSimulatorViewModel
import br.com.wgc.design_system.templates.screens.loan.WgcLoanSimulatorTemplate

/**
 * Fábrica universal para instanciação padronizada do template de Simulação e Contratação de Empréstimos.
 */
object WgcCreditFactory {

    /**
     * Cria e retorna o Composable do template de Simulação de Empréstimo.
     *
     * @param modifier Modificador de layout
     * @param viewModel Instância do ViewModel base (default: FakeLoanSimulatorViewModel)
     * @param headerSlot Slot customizado para TopBar / cabeçalho
     * @param signatureSlot Slot customizado para o painel de assinatura de contrato
     */
    @Composable
    fun Create(
        modifier: Modifier = Modifier,
        viewModel: BaseLoanSimulatorViewModel = FakeLoanSimulatorViewModel(),
        headerSlot: (@Composable () -> Unit)? = null,
        signatureSlot: (@Composable () -> Unit)? = null
    ) {
        WgcLoanSimulatorTemplate(
            modifier = modifier,
            viewModel = viewModel,
            headerSlot = headerSlot,
            signatureSlot = signatureSlot
        )
    }
}
