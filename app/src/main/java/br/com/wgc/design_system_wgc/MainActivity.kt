package br.com.wgc.design_system_wgc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.components.sections.category.SectionCategories
import br.com.wgc.design_system.components.sections.category.SectionCategoryModel
import br.com.wgc.design_system.components.sections.product.SectionCards
import br.com.wgc.design_system.components.sections.product.SectionCardsModel
import br.com.wgc.design_system.components.sections.type.ItemSectionCategory
import br.com.wgc.design_system.components.sections.type.ItemSectionType
import br.com.wgc.design_system.mock.MockData
import br.com.wgc.design_system_wgc.ui.theme.DesignSystemWGCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DesignSystemWGCTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Spacer(Modifier.padding(innerPadding))
                    App()
                }
            }
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
    ) {

        item {
            SectionCategories(
                sectionModel = SectionCategoryModel(
                    title = "Categorias",
                    items = MockData.listItemSectionCircleCategoryModel,
                    itemType = ItemSectionCategory.CIRCLE
                )
            )
        }

        item {
            SectionCategories(
                sectionModel = SectionCategoryModel(
                    title = "Categorias",
                    items = MockData.listItemSectionCircleCategoryModel,
                    itemType = ItemSectionCategory.HORIZONTAL
                )
            )
        }
        item {
            SectionCards(
                sectionModel = SectionCardsModel(
                    title = "Promocoes",
                    items = MockData.listItemSectionCardModel,
                    itemType = ItemSectionType.DEFAULT
                )
            )
        }

        item {
            SectionCards(
                sectionModel = SectionCardsModel(
                    title = "Comidas",
                    items = MockData.listItemSectionCardModel,
                    itemType = ItemSectionType.HORIZONTAL
                )
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DesignSystemWGCTheme {
        App()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview2() {
    DesignSystemWGCTheme {
        App()
    }
}


