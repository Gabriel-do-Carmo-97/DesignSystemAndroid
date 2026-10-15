package br.com.wgc.design_system.factories.search

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.templates.factories.WgcSearchFactory
import br.com.wgc.design_system.templates.factories.WgcSearchType
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Fábrica Universal de Telas de Busca e Filtro (WgcSearchScreenFactory).
 */
@Composable
fun WgcSearchScreenFactory(
    modifier: Modifier = Modifier,
    variant: WgcSearchVariant = WgcSearchVariant.STANDARD,
    title: String = "Pesquisa",
    searchQuery: String = "",
    onSearchQueryChange: (String) -> Unit = {},
    selectedCategory: String = "Todos",
    onCategorySelect: (String) -> Unit = {},
    categories: List<String> = listOf("Todos", "Eletrônicos", "Roupas", "Casa", "Esportes"),
    results: List<String> = listOf(
        "Fone de Ouvido Noise Cancelling",
        "Notebook Ultra Fino",
        "Teclado Mecânico RGB",
        "Cadeira Ergonômica"
    ),
    onResultClick: (String) -> Unit = {},
    onBackClick: () -> Unit = {},
    searchBarSlot: (@Composable () -> Unit)? = null,
    filterSlot: (@Composable () -> Unit)? = null,
    contentSlot: (@Composable () -> Unit)? = null
) {
    val type = when (variant) {
        WgcSearchVariant.STANDARD -> WgcSearchType.STANDARD
        WgcSearchVariant.VISUAL_SEARCH -> WgcSearchType.VISUAL_SEARCH
        WgcSearchVariant.ECOMMERCE -> WgcSearchType.ECOMMERCE
        WgcSearchVariant.FOOD -> WgcSearchType.FOOD
    }

    WgcSearchFactory(
        modifier = modifier,
        type = type,
        title = title,
        searchQuery = searchQuery,
        onSearchQueryChange = onSearchQueryChange,
        selectedCategory = selectedCategory,
        onCategorySelect = onCategorySelect,
        categories = categories,
        results = results,
        onResultClick = onResultClick,
        onBackClick = onBackClick,
        searchBarSlot = searchBarSlot,
        filterSlot = filterSlot,
        contentSlot = contentSlot
    )
}

@Preview(name = "WgcSearchScreenFactory - Preview", showBackground = true)
@Composable
private fun WgcSearchScreenFactoryPreview() {
    WgcTheme {
        WgcSearchScreenFactory()
    }
}
