package br.com.wgc.design_system.coordinators.profile

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.factories.profile.WgcProfileScreenFactory
import br.com.wgc.design_system.factories.profile.WgcProfileVariant
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Coordenador do Fluxo de Perfil e Configurações (WgcProfileFlowCoordinator).
 */
@Composable
fun WgcProfileFlowCoordinator(
    modifier: Modifier = Modifier,
    variant: WgcProfileVariant = WgcProfileVariant.STANDARD,
    onLogout: () -> Unit = {},
    customScreenSlot: (@Composable () -> Unit)? = null
) {
    if (customScreenSlot != null) {
        customScreenSlot()
    } else {
        WgcProfileScreenFactory(
            modifier = modifier,
            variant = variant,
            onLogoutClick = onLogout
        )
    }
}

@Preview(name = "WgcProfileFlowCoordinator - Preview", showBackground = true)
@Composable
private fun WgcProfileFlowCoordinatorPreview() {
    WgcTheme {
        WgcProfileFlowCoordinator()
    }
}
