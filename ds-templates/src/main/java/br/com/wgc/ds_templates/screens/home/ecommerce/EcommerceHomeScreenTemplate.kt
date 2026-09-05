package br.com.wgc.ds_templates.screens.home.ecommerce

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcIconButton
import br.com.wgc.design_system.components.chip.WgcChip
import br.com.wgc.design_system.components.fields.SearchTextField
import br.com.wgc.design_system.components.list.WgcListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class EcommerceHomeUiState(
    val searchQuery: String = "",
    val categories: List<String> = listOf("Tudo", "Ofertas", "Eletrônicos", "Moda"),
    val selectedCategory: String = "Tudo",
    val featuredProducts: List<String> = listOf("Smart TV 55\" 4K", "Smartphone Flagship 256GB")
)

abstract class BaseEcommerceHomeViewModel : ViewModel() {
    abstract val uiState: StateFlow<EcommerceHomeUiState>
    abstract fun onCartClick()
}

class FakeEcommerceHomeViewModel : BaseEcommerceHomeViewModel() {
    override val uiState: StateFlow<EcommerceHomeUiState> = MutableStateFlow(EcommerceHomeUiState()).asStateFlow()
    override fun onCartClick() {}
}

@Composable
fun EcommerceHomeScreenTemplate(viewModel: BaseEcommerceHomeViewModel) {
    val state by viewModel.uiState.collectAsState()
    EcommerceHomeScreenContent(
        state = state,
        onCartClick = { viewModel.onCartClick() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EcommerceHomeScreenContent(
    modifier: Modifier = Modifier,
    state: EcommerceHomeUiState,
    onCartClick: () -> Unit
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("WGC Store") },
                actions = {
                    WgcIconButton(onClick = onCartClick, icon = Icons.Default.ShoppingCart, contentDescription = "Carrinho")
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            SearchTextField(
                value = state.searchQuery,
                onValueChange = {},
                label = "Pesquisar no catálogo",
                leadingIcon = Icons.Default.Search
            )

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                state.categories.forEach { category ->
                    WgcChip(
                        label = category,
                        selected = state.selectedCategory == category,
                        onClick = {}
                    )
                }
            }

            Card(
                modifier = Modifier.fillMaxWidth().height(140.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
            ) {
                Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
                    Text(
                        text = "Semana Tech ⚡\nAté 40% OFF",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Text("Produtos em Destaque", style = MaterialTheme.typography.titleMedium)

            state.featuredProducts.forEach { product ->
                WgcListItem(
                    headlineText = product,
                    supportingText = "Frete Grátis"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EcommerceHomePreview() {
    MaterialTheme {
        EcommerceHomeScreenContent(state = EcommerceHomeUiState(), onCartClick = {})
    }
}
