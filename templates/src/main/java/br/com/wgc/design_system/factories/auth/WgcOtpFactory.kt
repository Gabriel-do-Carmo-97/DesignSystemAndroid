package br.com.wgc.design_system.factories.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.components.auth.WgcBrandAuthHeader
import br.com.wgc.design_system.components.buttons.WgcButton
import br.com.wgc.design_system.components.fields.SimpleTextField
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Fábrica Universal de Telas de OTP / Confirmação de Código (WgcOtpFactory).
 */
@Composable
fun WgcOtpFactory(
    modifier: Modifier = Modifier,
    variant: WgcOtpVariant = WgcOtpVariant.FOOD_DELIVERY,
    headerSlot: (@Composable () -> Unit)? = null,
    otpInputSlot: (@Composable () -> Unit)? = null,
    confirmButtonSlot: (@Composable () -> Unit)? = null,
    resendSlot: (@Composable () -> Unit)? = null,
    onConfirmOtp: (String) -> Unit = {},
    onResendCode: () -> Unit = {}
) {
    Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(WgcCoreDsSpacing.lg24.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            headerSlot?.invoke() ?: WgcBrandAuthHeader(
                brandName = variant.displayName,
                brandLogoText = variant.logoText,
                brandColor = variant.primaryColor,
                title = "Confirmação de Código",
                subtitle = "Digite o código enviado para o seu dispositivo"
            )

            otpInputSlot?.invoke() ?: SimpleTextField(
                value = "",
                onValueChange = {},
                label = "Código de 6 dígitos"
            )

            confirmButtonSlot?.invoke() ?: WgcButton(
                text = "Confirmar Código",
                onClick = { onConfirmOtp("123456") },
                modifier = Modifier.fillMaxWidth()
            )

            resendSlot?.invoke() ?: TextButton(
                onClick = onResendCode,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Reenviar código")
            }
        }
    }
}

@Preview(name = "WgcOtpFactory - Preview", showBackground = true)
@Composable
private fun WgcOtpFactoryPreview() {
    WgcTheme {
        WgcOtpFactory()
    }
}
