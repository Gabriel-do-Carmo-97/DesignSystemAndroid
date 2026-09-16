package br.com.wgc.ds_templates.screens.common.placeholder

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Construction
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * WgcGenericPlaceholderTemplate
 *
 * Template corporativo universal para abas secundárias e telas em desenvolvimento do Design System.
 * Garante conformidade com tokens de espaçamento, tipografia e slots de customização.
 *
 * @param title Título da funcionalidade/tela.
 * @param subtitle Mensagem explicativa ou de contexto.
 * @param modifier Modificador de layout.
 * @param topBarSlot Slot opcional para barra superior customizada.
 * @param bottomBarSlot Slot opcional para barra inferior customizada.
 */
@Composable
fun WgcGenericPlaceholderTemplate(
    title: String,
    subtitle: String = "Esta funcionalidade está em desenvolvimento e estará disponível em breve.",
    modifier: Modifier = Modifier,
    topBarSlot: (@Composable () -> Unit)? = null,
    bottomBarSlot: (@Composable () -> Unit)? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { topBarSlot?.invoke() },
        bottomBar = { bottomBarSlot?.invoke() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(WgcCoreDsSpacing.lg24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Default.Construction,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(48.dp)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(name = "WgcGenericPlaceholderTemplate - Preview", showBackground = true)
@Composable
private fun WgcGenericPlaceholderTemplatePreview() {
    MaterialTheme {
        Surface {
            WgcGenericPlaceholderTemplate(
                title = "Histórico de Pedidos"
            )
        }
    }
}
