package br.com.wgc.design_system.components.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.commons.WgcComponentPreviews
import br.com.wgc.design_system.components.fields.SimpleTextField

/**
 * Campo de Entrada de Código OTP / Verificação por SMS (WgcOtpCodeInput).
 */
@Composable
fun WgcOtpCodeInput(
    modifier: Modifier = Modifier,
    otpCode: String,
    onOtpCodeChange: (String) -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
    ) {
        SimpleTextField(
            value = otpCode,
            onValueChange = { if (it.length <= 6) onOtpCodeChange(it) },
            label = "Código de Verificação (6 dígitos)"
        )
    }
}

@WgcComponentPreviews
@Composable
private fun WgcOtpCodeInputPreview() {
    MaterialTheme {
        WgcOtpCodeInput(otpCode = "123456", onOtpCodeChange = {})
    }
}
