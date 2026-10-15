package br.com.wgc.design_system.factories.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.commons.previews.devices.phone.WgcDevicePreviews
import br.com.wgc.design_system.components.chip.WgcChip
import br.com.wgc.design_system.components.fields.SearchTextField
import br.com.wgc.design_system.components.list.WgcListItem
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.factories.search.templates.SearchAndFilterScreenContent
import br.com.wgc.design_system.factories.search.templates.SearchAndFilterUiState
import br.com.wgc.design_system.factories.verticals.megastore.templates.search.WgcShoppeVisualSearchScreenTemplate
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Fábrica Universal de Telas de Busca e Filtro (WgcSearchScreenFactory).
 *
 * Ponto de entrada unificado para busca de produtos, catálogo e resultados.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Suppress("LongMethod", "CyclomaticComplexMethod")
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
    when (variant) {
        WgcSearchVariant.VISUAL_SEARCH -> {
            WgcShoppeVisualSearchScreenTemplate(
                modifier = modifier,
                onBackClick = onBackClick
            )
        }
        WgcSearchVariant.STANDARD -> {
            if (contentSlot != null) {
                contentSlot()
            } else {
                SearchAndFilterScreenContent(
                    modifier = modifier,
                    state = SearchAndFilterUiState(
                        searchQuery = searchQuery,
                        selectedCategory = selectedCategory,
                        categories = categories,
                        results = results
                    ),
                    onSearchQueryChange = onSearchQueryChange,
                    onCategorySelect = onCategorySelect
                )
            }
        }
        WgcSearchVariant.ECOMMERCE -> {
            Scaffold(
                modifier = modifier.fillMaxSize(),
                topBar = {
                    TopAppBar(
                        title = { Text(title, fontWeight = FontWeight.Bold) },
                        navigationIcon = {
                            IconButton(onClick = onBackClick) {
                                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
                            }
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
                    if (searchBarSlot != null) {
                        searchBarSlot()
                    } else {
                        SearchTextField(
                            value = searchQuery,
                            onValueChange = onSearchQueryChange,
                            label = "Buscar em toda a loja",
                            leadingIcon = Icons.Default.Search
                        )
                    }

                    if (filterSlot != null) {
                        filterSlot()
                    } else {
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp),
                            contentPadding = PaddingValues(horizontal = WgcCoreDsSpacing.xxs4.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            items(categories) { category ->
                                WgcChip(
                                    label = category,
                                    selected = selectedCategory == category,
                                    onClick = { onCategorySelect(category) }
                                )
                            }
                        }
                    }

                    HorizontalDivider()

                    Text(
                        text = "Produtos Encontrados (${results.size})",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary
                    )

                    if (contentSlot != null) {
                        contentSlot()
                    } else {
                        results.forEach { product ->
                            WgcListItem(
                                headlineText = product,
                                supportingText = "Frete grátis disponível",
                                leadingContent = {
                                    Icon(Icons.Default.ShoppingBag, contentDescription = null)
                                },
                                onClick = { onResultClick(product) }
                            )
                        }
                    }
                }
            }
        }
        WgcSearchVariant.FOOD -> {
            Scaffold(
                modifier = modifier.fillMaxSize(),
                topBar = {
                    TopAppBar(
                        title = { Text("Restaurantes & Pratos", fontWeight = FontWeight.Bold) },
                        navigationIcon = {
                            IconButton(onClick = onBackClick) {
                                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
                            }
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
                    if (searchBarSlot != null) {
                        searchBarSlot()
                    } else {
                        SearchTextField(
                            value = searchQuery,
                            onValueChange = onSearchQueryChange,
                            label = "Buscar prato ou culinária",
                            leadingIcon = Icons.Default.Search
                        )
                    }

                    if (filterSlot != null) {
                        filterSlot()
                    } else {
                        val foodCategories = listOf("Todos", "Pizza", "Hambúrguer", "Japonesa", "Saudável")
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            items(foodCategories) { cat ->
                                WgcChip(
                                    label = cat,
                                    selected = selectedCategory == cat,
                                    onClick = { onCategorySelect(cat) }
                                )
                            }
                        }
                    }

                    HorizontalDivider()

                    Text(
                        text = "Destaques Próximos",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary
                    )

                    if (contentSlot != null) {
                        contentSlot()
                    } else {
                        val foodResults = listOf("Pizzaria Bella Napoli (25-35 min)", "Burger Artisan Prime (15-25 min)", "Sushi Hanami (30-40 min)")
                        foodResults.forEach { item ->
                            WgcListItem(
                                headlineText = item,
                                supportingText = "Avaliação 4.8 ★",
                                leadingContent = {
                                    Icon(Icons.Default.Fastfood, contentDescription = null)
                                },
                                onClick = { onResultClick(item) }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(name = "WgcSearchScreenFactory - Standard", showBackground = true)
@WgcDevicePreviews
@Composable
private fun WgcSearchScreenFactoryStandardPreview() {
    WgcTheme {
        WgcSearchScreenFactory(variant = WgcSearchVariant.STANDARD)
    }
}

@Preview(name = "WgcSearchScreenFactory - Ecommerce", showBackground = true)
@Composable
private fun WgcSearchScreenFactoryEcommercePreview() {
    WgcTheme {
        WgcSearchScreenFactory(variant = WgcSearchVariant.ECOMMERCE)
    }
}

@Preview(name = "WgcSearchScreenFactory - Food", showBackground = true)
@Composable
private fun WgcSearchScreenFactoryFoodPreview() {
    WgcTheme {
        WgcSearchScreenFactory(variant = WgcSearchVariant.FOOD)
    }
}
