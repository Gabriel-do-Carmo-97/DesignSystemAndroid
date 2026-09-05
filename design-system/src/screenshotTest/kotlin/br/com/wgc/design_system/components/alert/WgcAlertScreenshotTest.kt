package br.com.wgc.design_system.components.alert

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android.tools.screenshot.PreviewTest

class WgcAlertScreenshotTest {
    @PreviewTest
    @Preview(showBackground = true, name = "Success Alert")
    @Composable
    private fun SuccessAlertPreview() {
        WgcAlert(title = "Sucesso", message = "Operação concluída.", type = AlertType.SUCCESS, onDismiss = {})
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Error Alert")
    @Composable
    private fun ErrorAlertPreview() {
        WgcAlert(title = "Erro", message = "Erro crítico.", type = AlertType.ERROR)
    }
}
