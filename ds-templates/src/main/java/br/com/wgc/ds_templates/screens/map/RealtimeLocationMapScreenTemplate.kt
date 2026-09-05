package br.com.wgc.ds_templates.screens.map

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.ClassicButton
import br.com.wgc.design_system.components.list.WgcListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class RealtimeLocationUiState(
    val title: String = "Acompanhamento em Tempo Real",
    val statusText: String = "Entregador a 5 min de distância",
    val driverName: String = "Carlos Silva",
    val destinationAddress: String = "Av. Paulista, 1000 - São Paulo, SP",
    val isTrackingActive: Boolean = true
)

abstract class BaseRealtimeLocationViewModel : ViewModel() {
    abstract val uiState: StateFlow<RealtimeLocationUiState>
    abstract fun onContactDriverClick()
}

class FakeRealtimeLocationViewModel : BaseRealtimeLocationViewModel() {
    override val uiState: StateFlow<RealtimeLocationUiState> = MutableStateFlow(RealtimeLocationUiState()).asStateFlow()
    override fun onContactDriverClick() {}
}

@Composable
fun RealtimeLocationMapScreenTemplate(viewModel: BaseRealtimeLocationViewModel) {
    val state by viewModel.uiState.collectAsState()
    RealtimeLocationMapScreenContent(
        state = state,
        onContactDriverClick = { viewModel.onContactDriverClick() }
    )
}

@Composable
fun RealtimeLocationMapScreenContent(
    modifier: Modifier = Modifier,
    state: RealtimeLocationUiState,
    onContactDriverClick: () -> Unit
) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.surfaceVariant),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Default.Navigation,
                        contentDescription = null,
                        modifier = Modifier.size(64.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = "Visualização de Mapa em Tempo Real",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Surface(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                tonalElevation = 8.dp
            ) {
                Column(
                    modifier = Modifier
                        .padding(WgcCoreDsSpacing.md16.dp),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                    ) {
                        Icon(Icons.Default.LocationOn, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                        Text(text = state.statusText, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    }

                    WgcListItem(
                        headlineText = state.driverName,
                        supportingText = state.destinationAddress
                    )

                    ClassicButton(
                        textButton = "Entrar em Contato",
                        onClick = onContactDriverClick
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RealtimeLocationMapPreview() {
    MaterialTheme {
        RealtimeLocationMapScreenContent(
            state = RealtimeLocationUiState(),
            onContactDriverClick = {}
        )
    }
}
