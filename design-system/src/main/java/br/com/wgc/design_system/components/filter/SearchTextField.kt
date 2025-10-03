package br.com.wgc.design_system.components.filter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.components.cards.circularImageproduct.CircularImageProductCard
import br.com.wgc.design_system.components.cards.circularImageproduct.CircularImageProductModel
import java.math.BigDecimal

@Composable
fun <T : Any> SearchTextField(
    modifier: Modifier = Modifier,
    sections: List<SearchTextFieldModel<T>>,
    filterPredicate: (item: T, query: String) -> Boolean,
    itemContent: @Composable (item: T) -> Unit
) {
    var searchQuery by rememberSaveable { mutableStateOf("") }

    val filteredSections = remember(searchQuery, sections) {
        if (searchQuery.isBlank()) {
            sections
        } else {
            sections.map { section ->
                    val filteredItems = section.items.filter { item ->
                        filterPredicate(item, searchQuery)
                    }
                    section.copy(items = filteredItems)
                }.filter { it.items.isNotEmpty() }
        }
    }

    Column(modifier = modifier) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { newValue -> searchQuery = newValue },
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(100),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            },
            label = { Text(text = "Pesquisar") },
            placeholder = { Text(text = "O que você procura?") }
        )
        LazyColumn(contentPadding = PaddingValues(16.dp)) {
            filteredSections.forEach { section ->
                val (title, list) = section
                item {
                    Text(
                        text = title,
                        modifier = Modifier.padding(bottom = 8.dp),
                        fontWeight = FontWeight.Bold
                    )
                }

                item {
                    LazyRow(
                        contentPadding = PaddingValues(horizontal = 16.dp)
                    ) {
                        items(list.size) { index ->
                            itemContent(list[index])
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RoundedTextFieldPreview() = SearchTextField(
    sections = sampleFilter,
    filterPredicate = { item, query ->
        item.title.contains(query, ignoreCase = true) ||
                item.description.contains(query, ignoreCase = true)
    },
    itemContent = {
        CircularImageProductCard(model = it)
    }
)


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun RoundedTextFieldPreview2() = SearchTextField(
    sections = sampleFilter,
    filterPredicate = { item, query ->
        item.title.contains(query, ignoreCase = true) ||
                item.description.contains(query, ignoreCase = true)
    },
    itemContent = {
        CircularImageProductCard(
            model = it
        )
    }
)
val sampleDrinks = listOf(
    CircularImageProductModel(
        title = "Cerveja",
        price = BigDecimal("5.99"),
        image = "https://images.pexels.com/photos/1552630/pexels-photo-1552630.jpeg",
    ),
    CircularImageProductModel(
        title = "Refrigerante",
        price = BigDecimal("4.99"),
        image = "https://images.pexels.com/photos/2775860/pexels-photo-2775860.jpeg"
    ),
    CircularImageProductModel(
        title = "Suco",
        price = BigDecimal("7.99"),
        image = "https://images.pexels.com/photos/96974/pexels-photo-96974.jpeg"
    ),
    CircularImageProductModel(
        title = "Água",
        price = BigDecimal("2.99"),
        image = "https://images.pexels.com/photos/327090/pexels-photo-327090.jpeg"
    )
)
val sampleFilter = listOf(
    SearchTextFieldModel(
        title = "Promoções",
        items = sampleDrinks
    ),
    SearchTextFieldModel(
        title = "Doces",
        items = sampleDrinks
    ),
    SearchTextFieldModel(
        title = "Bebidas",
        items = sampleDrinks
    )
)