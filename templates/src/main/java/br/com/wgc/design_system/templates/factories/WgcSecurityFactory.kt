package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.security.BaseSecuritySettingsViewModel
import br.com.wgc.design_system.templates.screens.security.FakeSecuritySettingsViewModel
import br.com.wgc.design_system.templates.screens.security.WgcSecuritySettingsTemplate

/**
 * Fábrica universal para instanciação padronizada da Central de Segurança e Acesso.
 */
object WgcSecurityFactory {

    /**
     * Cria e retorna o Composable do template de Segurança e Acesso.
     *
     * @param modifier Modificador de layout
     * @param viewModel Instância do ViewModel base (default: FakeSecuritySettingsViewModel)
     * @param headerSlot Slot customizado para TopBar / cabeçalho
     */
    @Composable
    fun Create(
        modifier: Modifier = Modifier,
        viewModel: BaseSecuritySettingsViewModel = FakeSecuritySettingsViewModel(),
        headerSlot: (@Composable () -> Unit)? = null
    ) {
        WgcSecuritySettingsTemplate(
            modifier = modifier,
            viewModel = viewModel,
            headerSlot = headerSlot
        )
    }
}
