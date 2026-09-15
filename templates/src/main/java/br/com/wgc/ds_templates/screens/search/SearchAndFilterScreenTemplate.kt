package br.com.wgc.ds_templates.screens.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.chip.WgcChip
import br.com.wgc.design_system.components.fields.SearchTextField
import br.com.wgc.design_system.components.list.WgcListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class SearchAndFilterUiState(
    val searchQuery: String = "",
    val selectedCategory: String = "Todos",
    val categories: List<String> = listOf("Todos", "Eletrônicos", "Roupas", "Casa", "Esportes"),
    val results: List<String> = listOf("Fone de Ouvido Noise Cancelling", "Notebook Ultra Fino", "Teclado Mecânico RGB")
)

abstract class BaseSearchAndFilterViewModel : ViewModel() {
    abstract val uiState: StateFlow<SearchAndFilterUiState>
    abstract fun onSearchQueryChange(query: String)
    abstract fun onCategorySelect(category: String)
}

class FakeSearchAndFilterViewModel : BaseSearchAndFilterViewModel() {
    override val uiState: StateFlow<SearchAndFilterUiState> = MutableStateFlow(SearchAndFilterUiState()).asStateFlow()
    override fun onSearchQueryChange(query: String) {}
    override fun onCategorySelect(category: String) {}
}

@Composable
fun SearchAndFilterScreenTemplate(viewModel: BaseSearchAndFilterViewModel) {
    val state by viewModel.uiState.collectAsState()
    SearchAndFilterScreenContent(
        state = state,
        onSearchQueryChange = { viewModel.onSearchQueryChange(it) },
        onCategorySelect = { viewModel.onCategorySelect(it) }
    )
}

@Composable
fun SearchAndFilterScreenContent(
    modifier: Modifier = Modifier,
    state: SearchAndFilterUiState,
    onSearchQueryChange: (String) -> Unit,
    onCategorySelect: (String) -> Unit
) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
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
                onValueChange = onSearchQueryChange,
                label = "Pesquisar",
                leadingIcon = Icons.Default.Search
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                state.categories.forEach { category ->
                    WgcChip(
                        label = category,
                        selected = state.selectedCategory == category,
                        onClick = { onCategorySelect(category) }
                    )
                }
            }

            HorizontalDivider()

            Text(
                text = "Resultados (${state.results.size})",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )

            state.results.forEach { result ->
                WgcListItem(
                    headlineText = result,
                    supportingText = "Disponível em estoque"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchAndFilterPreview() {
    MaterialTheme {
        SearchAndFilterScreenContent(
            state = SearchAndFilterUiState(),
            onSearchQueryChange = {},
            onCategorySelect = {}
        )
    }
}
