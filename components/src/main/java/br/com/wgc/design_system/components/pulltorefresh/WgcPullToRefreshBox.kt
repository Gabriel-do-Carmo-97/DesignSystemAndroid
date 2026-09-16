package br.com.wgc.design_system.components.pulltorefresh

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.commons.WgcComponentPreviews

/**
 * WgcPullToRefreshBox
 *
 * Contêiner corporativo para listas e telas que suportam gesto de puxar para atualizar (Pull-to-Refresh).
 * Encapsula as APIs Material 3 com suporte a temas, tokens e State Hoisting estrito.
 *
 * @param isRefreshing Estado booleano que indica se a atualização está em andamento.
 * @param onRefresh Callback disparado quando o usuário conclui o gesto de puxar.
 * @param modifier Modificador de layout.
 * @param enabled Habilita ou desabilita o gesto de atualização.
 * @param content Conteúdo rolável encapsulado.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcPullToRefreshBox(
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable BoxScope.() -> Unit
) {
    val state = rememberPullToRefreshState()

    PullToRefreshBox(
        isRefreshing = isRefreshing,
        onRefresh = onRefresh,
        modifier = modifier,
        state = state,
        indicator = {
            PullToRefreshDefaults.Indicator(
                state = state,
                isRefreshing = isRefreshing,
                modifier = Modifier.align(Alignment.TopCenter),
                containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                color = MaterialTheme.colorScheme.primary
            )
        },
        content = content
    )
}

@WgcComponentPreviews
@Composable
private fun WgcPullToRefreshBoxPreview() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            WgcPullToRefreshBox(
                isRefreshing = false,
                onRefresh = {}
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(WgcCoreDsSpacing.md16.dp)
                ) {
                    items(5) { index ->
                        Surface(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = WgcCoreDsSpacing.xxs4.dp),
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant
                        ) {
                            Text(
                                text = "Item de teste #$index",
                                modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }
        }
    }
}
