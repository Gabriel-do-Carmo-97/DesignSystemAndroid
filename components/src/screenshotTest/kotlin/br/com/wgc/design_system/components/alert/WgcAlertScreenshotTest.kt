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
        WgcAlert(title = "Erro", message = "Erro crítico.", type = AlertType.ERROR, onDismiss = {})
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Warning Alert")
    @Composable
    private fun WarningAlertPreview() {
        WgcAlert(title = "Atenção", message = "Cuidado ao prosseguir.", type = AlertType.WARNING, onDismiss = {})
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Info Alert")
    @Composable
    private fun InfoAlertPreview() {
        WgcAlert(title = "Informação", message = "Nova atualização disponível.", type = AlertType.INFO, onDismiss = {})
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Alert Without Dismiss")
    @Composable
    private fun AlertWithoutDismissPreview() {
        WgcAlert(title = "Aviso", message = "Aviso importante sem botão fechar.", type = AlertType.INFO)
    }
}
