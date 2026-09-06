package br.com.wgc.design_system.components.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.commons.WgcComponentPreviews
import br.com.wgc.design_system.components.buttons.WgcSecondaryClassicButton

/**
 * Grupo de Botões de Login Social (WgcSocialLoginButtons).
 */
@Composable
fun WgcSocialLoginButtons(
    modifier: Modifier = Modifier,
    onGoogleClick: () -> Unit = {},
    onAppleClick: () -> Unit = {},
    onFacebookClick: () -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
    ) {
        WgcSecondaryClassicButton(textButton = "G  Continuar com Google", onClick = onGoogleClick)
        WgcSecondaryClassicButton(textButton = "  Continuar com Apple", onClick = onAppleClick)
        WgcSecondaryClassicButton(textButton = "f  Continuar com Facebook", onClick = onFacebookClick)
    }
}

@WgcComponentPreviews
@Composable
private fun WgcSocialLoginButtonsPreview() {
    MaterialTheme {
        WgcSocialLoginButtons()
    }
}
