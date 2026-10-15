package br.com.wgc.design_system.factories.notification

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.templates.screens.notification.FakeNotificationHubViewModel
import br.com.wgc.design_system.templates.screens.notification.WgcNotificationHubTemplate
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Fábrica Universal de Telas de Notificação (WgcNotificationScreenFactory).
 */
@Composable
fun WgcNotificationScreenFactory(
    modifier: Modifier = Modifier,
    variant: WgcNotificationVariant = WgcNotificationVariant.STANDARD,
    headerSlot: (@Composable () -> Unit)? = null
) {
    when (variant) {
        WgcNotificationVariant.STANDARD,
        WgcNotificationVariant.INBOX,
        WgcNotificationVariant.PUSH_ALERTS -> WgcNotificationHubTemplate(
            modifier = modifier,
            viewModel = FakeNotificationHubViewModel(),
            headerSlot = headerSlot
        )
    }
}

@Preview(name = "WgcNotificationScreenFactory - Preview", showBackground = true)
@Composable
private fun WgcNotificationScreenFactoryPreview() {
    WgcTheme {
        WgcNotificationScreenFactory()
    }
}
