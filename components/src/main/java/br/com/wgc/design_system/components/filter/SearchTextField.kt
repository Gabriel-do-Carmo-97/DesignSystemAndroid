package br.com.wgc.design_system.components.filter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.components.fields.SearchTextField
import br.com.wgc.design_system.components.sections.items.product.ItemSectionCardModel
import br.com.wgc.design_system.components.sections.product.SectionCards
import br.com.wgc.design_system.components.sections.product.SectionCardsModel
import br.com.wgc.design_system.components.sections.type.ItemSectionType
import java.math.BigDecimal

@Composable
fun SearchTextField(
    modifier: Modifier = Modifier,
    sections: List<SectionCardsModel>,
    filterPredicate: (item: ItemSectionCardModel, query: String) -> Boolean,
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
        SearchTextField(modifier = Modifier
            .padding (top = 16.dp, start = 16.dp, end = 16.dp),
        value = searchQuery,
        onValueChange = { newValue -> searchQuery = newValue },
        label = "Pesquisar",
        leadingIcon = Icons.Default.Search
        )
        LazyColumn(contentPadding = PaddingValues(vertical = 8.dp)) {
            items(
                items = filteredSections,
                key = { section -> section.title }
            ) { section ->
                SectionCards(sectionModel = section)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RoundedTextFieldPreview() = SearchTextField(
    sections = sectionsCardModels,
    filterPredicate = { item, query ->
        item.name.contains(query, ignoreCase = true) ||
                item.description.contains(query, ignoreCase = true)
    },
)


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun RoundedTextFieldPreview2() = SearchTextField(
    sections = sectionsCardModels,
    filterPredicate = { item, query ->
        item.name.contains(query, ignoreCase = true) ||
                item.description.contains(query, ignoreCase = true)
    },
)

val sampleDrinks = listOf(
    ItemSectionCardModel(
        name = "Cerveja",
        price = BigDecimal("5.99"),
        image = "https://images.pexels.com/photos/1552630/pexels-photo-1552630.jpeg",
    ),
    ItemSectionCardModel(
        name = "Refrigerante",
        price = BigDecimal("4.99"),
        image = "https://images.pexels.com/photos/2775860/pexels-photo-2775860.jpeg"
    ),
    ItemSectionCardModel(
        name = "Suco",
        price = BigDecimal("7.99"),
        image = "https://images.pexels.com/photos/96974/pexels-photo-96974.jpeg"
    ),
    ItemSectionCardModel(
        name = "Água",
        price = BigDecimal("2.99"),
        image = "https://images.pexels.com/photos/327090/pexels-photo-327090.jpeg"
    )
)

val sectionsCardModels = listOf(
    SectionCardsModel(
        title = "BEBIDAS",
        items = sampleDrinks,
        itemType = ItemSectionType.DEFAULT
    ),
    SectionCardsModel(
        title = "COMIDAS",
        items = sampleDrinks,
        itemType = ItemSectionType.HORIZONTAL
    ),
    SectionCardsModel(
        title = "Promocoes",
        items = sampleDrinks,
        itemType = ItemSectionType.DEFAULT

    )
)