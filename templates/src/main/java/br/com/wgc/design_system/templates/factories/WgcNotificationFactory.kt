package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.notification.BaseNotificationHubViewModel
import br.com.wgc.design_system.templates.screens.notification.FakeNotificationHubViewModel
import br.com.wgc.design_system.templates.screens.notification.WgcNotificationHubTemplate

/**
 * Fábrica universal para instanciação padronizada da Central de Notificações.
 */
object WgcNotificationFactory {

    /**
     * Cria e retorna o Composable do template de Central de Notificações.
     *
     * @param modifier Modificador de layout
     * @param viewModel Instância do ViewModel base (default: FakeNotificationHubViewModel)
     * @param headerSlot Slot customizado para TopBar / cabeçalho
     */
    @Composable
    fun Create(
        modifier: Modifier = Modifier,
        viewModel: BaseNotificationHubViewModel = FakeNotificationHubViewModel(),
        headerSlot: (@Composable () -> Unit)? = null
    ) {
        WgcNotificationHubTemplate(
            modifier = modifier,
            viewModel = viewModel,
            headerSlot = headerSlot
        )
    }
}
