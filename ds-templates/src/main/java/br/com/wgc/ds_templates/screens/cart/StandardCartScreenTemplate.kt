package br.com.wgc.ds_templates.screens.cart

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
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

data class CartItem(val id: String, val title: String, val price: String)

data class StandardCartUiState(
    val items: List<CartItem> = listOf(
        CartItem("1", "Fone de Ouvido Bluetooth", "R$ 299,00"),
        CartItem("2", "Smartwatch Esportivo", "R$ 599,00")
    ),
    val total: String = "R$ 898,00",
    val isLoading: Boolean = false
)

abstract class BaseStandardCartViewModel : ViewModel() {
    abstract val uiState: StateFlow<StandardCartUiState>
    abstract fun onCheckoutClick()
}

class FakeStandardCartViewModel : BaseStandardCartViewModel() {
    override val uiState: StateFlow<StandardCartUiState> = MutableStateFlow(StandardCartUiState()).asStateFlow()
    override fun onCheckoutClick() {}
}

@Composable
fun StandardCartScreenTemplate(viewModel: BaseStandardCartViewModel) {
    val state by viewModel.uiState.collectAsState()
    StandardCartScreenContent(
        state = state,
        onCheckoutClick = { viewModel.onCheckoutClick() }
    )
}

@Composable
fun StandardCartScreenContent(
    modifier: Modifier = Modifier,
    state: StandardCartUiState,
    onCheckoutClick: () -> Unit
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            Surface(
                tonalElevation = 8.dp,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Total:", style = MaterialTheme.typography.titleMedium)
                        Text(state.total, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                    }
                    ClassicButton(
                        textButton = "Finalizar Compra",
                        isLoading = state.isLoading,
                        onClick = onCheckoutClick
                    )
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
        ) {
            Text(text = "Meu Carrinho", style = MaterialTheme.typography.headlineMedium)
            HorizontalDivider()
            state.items.forEach { item ->
                WgcListItem(
                    headlineText = item.title,
                    supportingText = item.price
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun StandardCartPreview() {
    MaterialTheme {
        StandardCartScreenContent(state = StandardCartUiState(), onCheckoutClick = {})
    }
}
