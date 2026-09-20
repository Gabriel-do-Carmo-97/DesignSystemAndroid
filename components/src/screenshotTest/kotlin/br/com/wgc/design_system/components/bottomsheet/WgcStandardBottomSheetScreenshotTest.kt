package br.com.wgc.design_system.components.bottomsheet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsSpacing

class WgcStandardBottomSheetScreenshotTest {

    @Preview(showBackground = true)
    @Composable
    fun WgcStandardBottomSheetContentPreview() {
        Surface {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(WgcCoreDsSpacing.lg.dp)
            ) {
                Text(
                    text = "Título da Folha Inferior",
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs.dp))
                Text(
                    text = "Descrição explicativa de opções para o usuário.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
