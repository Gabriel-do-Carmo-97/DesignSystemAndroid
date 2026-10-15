package br.com.wgc.design_system.factories.biometrics

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.templates.screens.biometrics.FakeBiometricAuthViewModel
import br.com.wgc.design_system.templates.screens.biometrics.WgcBiometricAuthTemplate
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Fábrica Universal de Telas de Biometria (WgcBiometricsScreenFactory).
 */
@Composable
fun WgcBiometricsScreenFactory(
    modifier: Modifier = Modifier,
    variant: WgcBiometricsVariant = WgcBiometricsVariant.FINGERPRINT,
    onSuccess: () -> Unit = {},
    onFallback: () -> Unit = {}
) {
    when (variant) {
        WgcBiometricsVariant.FINGERPRINT,
        WgcBiometricsVariant.FACE_ID,
        WgcBiometricsVariant.IRIS -> WgcBiometricAuthTemplate(
            modifier = modifier,
            viewModel = FakeBiometricAuthViewModel(
                onBiometricTrigger = onSuccess,
                onFallbackPinTrigger = onFallback
            )
        )
    }
}

@Preview(name = "WgcBiometricsScreenFactory - Preview", showBackground = true)
@Composable
private fun WgcBiometricsScreenFactoryPreview() {
    WgcTheme {
        WgcBiometricsScreenFactory()
    }
}
