package br.com.wgc.design_system.factories.security

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.factories.security.templates.FakeSecuritySettingsViewModel
import br.com.wgc.design_system.factories.security.templates.WgcSecuritySettingsTemplate
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Fábrica Universal de Telas de Segurança e Acesso (WgcSecurityScreenFactory).
 */
@Composable
fun WgcSecurityScreenFactory(
    modifier: Modifier = Modifier,
    variant: WgcSecurityVariant = WgcSecurityVariant.STANDARD,
    headerSlot: (@Composable () -> Unit)? = null
) {
    when (variant) {
        WgcSecurityVariant.STANDARD,
        WgcSecurityVariant.TWO_FACTOR,
        WgcSecurityVariant.PASSWORD_CHANGE -> WgcSecuritySettingsTemplate(
            modifier = modifier,
            viewModel = FakeSecuritySettingsViewModel(),
            headerSlot = headerSlot
        )
    }
}

@Preview(name = "WgcSecurityScreenFactory - Preview", showBackground = true)
@Composable
private fun WgcSecurityScreenFactoryPreview() {
    WgcTheme {
        WgcSecurityScreenFactory()
    }
}
