package br.com.wgc.design_system.components.feedback

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.tools.screenshot.PreviewTest

class WgcSnackbarScreenshotTest {

    @PreviewTest
    @Preview(showBackground = true, name = "Snackbar Variants Preview")
    @Composable
    private fun SnackbarVariantsPreview() {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            WgcSnackbar(
                message = "Item adicionado ao carrinho com sucesso!",
                variant = WgcSnackbarVariant.Success
            )
            WgcSnackbar(
                message = "Erro ao carregar os dados.",
                actionLabel = "Tentar novamente",
                onActionClick = {},
                variant = WgcSnackbarVariant.Error
            )
            WgcSnackbar(
                message = "Atenção: sua sessão expira em breve.",
                variant = WgcSnackbarVariant.Warning
            )
        }
    }
}
