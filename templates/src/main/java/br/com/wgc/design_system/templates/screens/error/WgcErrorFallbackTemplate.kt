@file:Suppress("MatchingDeclarationName")

package br.com.wgc.design_system.templates.screens.error

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CloudOff
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.core.WgcCoreDsSpacing

data class WgcErrorFallbackUiState(
    val title: String = "Algo deu errado",
    val description: String = "Não foi possível carregar as informações. Verifique sua conexão com a internet e tente novamente.",
    val errorCode: String? = "ERR_HTTP_500_INTERNAL"
)

/**
 * Template genérico de contingência e erro para falhas de rede e indisponibilidade de serviços.
 */
@Suppress("LongMethod")
@Composable
fun WgcErrorFallbackTemplate(
    uiState: WgcErrorFallbackUiState = WgcErrorFallbackUiState(),
    onRetry: () -> Unit = {},
    onContactSupport: (() -> Unit)? = null,
    illustrationSlot: (@Composable () -> Unit)? = null
) {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(WgcCoreDsSpacing.lg24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (illustrationSlot != null) {
                Box(modifier = Modifier.padding(bottom = WgcCoreDsSpacing.md16.dp)) {
                    illustrationSlot()
                }
            } else {
                Icon(
                    imageVector = Icons.Default.CloudOff,
                    contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                        .padding(bottom = WgcCoreDsSpacing.md16.dp),
                    tint = MaterialTheme.colorScheme.error
                )
            }

            Text(
                text = uiState.title,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Text(
                text = uiState.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = WgcCoreDsSpacing.md16.dp)
            )

            if (uiState.errorCode != null) {
                Text(
                    text = "Código do erro: ${uiState.errorCode}",
                    style = MaterialTheme.typography.labelSmall,
                    fontFamily = FontFamily.Monospace,
                    color = MaterialTheme.colorScheme.outline,
                    modifier = Modifier.padding(bottom = WgcCoreDsSpacing.lg24.dp)
                )
            }

            WgcClassicButton(
                text = "Tentar Novamente",
                onClick = onRetry,
                modifier = Modifier.fillMaxWidth()
            )

            if (onContactSupport != null) {
                OutlinedButton(
                    onClick = onContactSupport,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = WgcCoreDsSpacing.sm8.dp)
                ) {
                    Text(text = "Falar com Suporte")
                }
            }
        }
    }
}
