package br.com.wgc.ds_templates.screens.home.fintech

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.avatar.WgcAvatar
import br.com.wgc.design_system.components.buttons.WgcIconButton
import br.com.wgc.design_system.components.list.WgcListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class FintechHomeUiState(
    val userName: String = "Gabriel",
    val balance: String = "R$ 12.450,00",
    val isBalanceVisible: Boolean = true,
    val transactions: List<String> = listOf("Pagamento Supermercado - R$ 150,00", "Pix Recebido - R$ 500,00", "Transferência enviada - R$ 100,00")
)

abstract class BaseFintechHomeViewModel : ViewModel() {
    abstract val uiState: StateFlow<FintechHomeUiState>
    abstract fun onToggleBalanceVisibility()
    abstract fun onPixClick()
    abstract fun onTransferClick()
}

class FakeFintechHomeViewModel : BaseFintechHomeViewModel() {
    override val uiState: StateFlow<FintechHomeUiState> = MutableStateFlow(FintechHomeUiState()).asStateFlow()
    override fun onToggleBalanceVisibility() {}
    override fun onPixClick() {}
    override fun onTransferClick() {}
}

@Composable
fun FintechHomeScreenTemplate(viewModel: BaseFintechHomeViewModel) {
    val state by viewModel.uiState.collectAsState()
    FintechHomeScreenContent(
        state = state,
        onToggleBalance = { viewModel.onToggleBalanceVisibility() },
        onPixClick = { viewModel.onPixClick() },
        onTransferClick = { viewModel.onTransferClick() }
    )
}

@Composable
fun FintechHomeScreenContent(
    modifier: Modifier = Modifier,
    state: FintechHomeUiState,
    onToggleBalance: () -> Unit,
    onPixClick: () -> Unit,
    onTransferClick: () -> Unit
) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.lg24.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    WgcAvatar(initials = state.userName.take(2))
                    Text(text = "Olá, ${state.userName}", style = MaterialTheme.typography.titleLarge)
                }
                WgcIconButton(onClick = onToggleBalance, icon = Icons.Default.Visibility, contentDescription = "Ver saldo")
            }

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
            ) {
                Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                    Text(text = "Saldo em conta", style = MaterialTheme.typography.labelMedium)
                    Text(
                        text = if (state.isBalanceVisible) state.balance else "••••••",
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(onClick = onPixClick) {
                    Icon(Icons.Default.Send, contentDescription = null)
                    Spacer(Modifier.width(4.dp))
                    Text("Pix")
                }
                Button(onClick = onTransferClick) {
                    Icon(Icons.Default.ArrowForward, contentDescription = null)
                    Spacer(Modifier.width(4.dp))
                    Text("Transferir")
                }
            }

            Text(text = "Últimas Transações", style = MaterialTheme.typography.titleMedium)
            state.transactions.forEach { tx ->
                WgcListItem(headlineText = tx)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FintechHomePreview() {
    MaterialTheme {
        FintechHomeScreenContent(
            state = FintechHomeUiState(),
            onToggleBalance = {},
            onPixClick = {},
            onTransferClick = {}
        )
    }
}
