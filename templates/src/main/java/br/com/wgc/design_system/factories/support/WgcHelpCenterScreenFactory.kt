package br.com.wgc.design_system.factories.support

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.templates.screens.support.FakeHelpCenterViewModel
import br.com.wgc.design_system.templates.screens.support.WgcHelpCenterSupportTemplate
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Fábrica Universal de Telas de Central de Ajuda e Suporte (WgcHelpCenterScreenFactory).
 */
@Composable
fun WgcHelpCenterScreenFactory(
    modifier: Modifier = Modifier,
    variant: WgcHelpCenterVariant = WgcHelpCenterVariant.STANDARD,
    headerSlot: (@Composable () -> Unit)? = null,
    contactActionSlot: (@Composable () -> Unit)? = null
) {
    when (variant) {
        WgcHelpCenterVariant.STANDARD,
        WgcHelpCenterVariant.FAQ,
        WgcHelpCenterVariant.CHAT_SUPPORT -> WgcHelpCenterSupportTemplate(
            modifier = modifier,
            viewModel = FakeHelpCenterViewModel(),
            headerSlot = headerSlot,
            contactActionSlot = contactActionSlot
        )
    }
}

@Preview(name = "WgcHelpCenterScreenFactory - Preview", showBackground = true)
@Composable
private fun WgcHelpCenterScreenFactoryPreview() {
    WgcTheme {
        WgcHelpCenterScreenFactory()
    }
}
