package br.com.wgc.design_system_wgc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.components.cards.carddetail.ProductDetailCard
import br.com.wgc.design_system.components.cards.carddetail.ProductDetailModel
import br.com.wgc.design_system.components.filter.sampleDrinks
import br.com.wgc.design_system.components.sections.category.SectionCategories
import br.com.wgc.design_system.components.sections.category.SectionCategoryModel
import br.com.wgc.design_system.components.sections.items.category.ItemSectionCircleCategoryModel
import br.com.wgc.design_system.components.sections.items.product.ItemSectionCardModel
import br.com.wgc.design_system.components.sections.product.SectionCards
import br.com.wgc.design_system.components.sections.product.SectionCardsModel
import br.com.wgc.design_system.components.sections.type.ItemSectionCategory
import br.com.wgc.design_system.components.sections.type.ItemSectionType
import br.com.wgc.design_system_wgc.ui.theme.DesignSystemWGCTheme
import java.math.BigDecimal

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
        contentPadding = PaddingValues(16.dp)
    ) {

        item {
            SectionCategories(
                sectionModel = SectionCategoryModel(
                    title = "Categorias",
                    items = listOf(
                        ItemSectionCircleCategoryModel(
                            image = "https://images.pexels.com/photos/1583884/pexels-photo-1583884.jpeg",
                            name = "Hamburguer"
                        ),
                        ItemSectionCircleCategoryModel(
                            image = "https://images.pexels.com/photos/1583884/pexels-photo-1583884.jpeg",
                            name = "Hamburguer"
                        ),
                        ItemSectionCircleCategoryModel(
                            image = "https://images.pexels.com/photos/1583884/pexels-photo-1583884.jpeg",
                            name = "Hamburguer"
                        ),
                        ItemSectionCircleCategoryModel(
                            image = "https://images.pexels.com/photos/1583884/pexels-photo-1583884.jpeg",
                            name = "Hamburguer"
                        ),
                        ItemSectionCircleCategoryModel(
                            image = "https://images.pexels.com/photos/1583884/pexels-photo-1583884.jpeg",
                            name = "Hamburguer"
                        ),
                    ),
                    itemType = ItemSectionCategory.CIRCLE
                )
            )
        }
        item {
            SectionCards(
                sectionModel = SectionCardsModel(
                    title = "Promocoes",
                    items = sampleProducts,
                    itemType = ItemSectionType.DEFAULT
                )
            )
        }

        item {
            SectionCards(
                sectionModel = SectionCardsModel(
                    title = "Comidas",
                    items = sampleProducts,
                    itemType = ItemSectionType.HORIZONTAL
                )
            )
        }
        items(sampleItemDetail.size) {
            ProductDetailCard(
                productDetailModel = sampleItemDetail[it],
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

val sampleCandies = listOf(
    ItemSectionCardModel(
        name = "Chocolate",
        price = BigDecimal("3.99"),
        image = "https://images.pexels.com/photos/65882/chocolate-dark-coffee-confiserie-65882.jpeg",
        description = LoremIpsum(100).values.first()
    ),
    ItemSectionCardModel(
        name = "Sorvete",
        price = BigDecimal("5.99"),
        image = "https://images.pexels.com/photos/1352278/pexels-photo-1352278.jpeg",
        description = LoremIpsum(100).values.first()
    ),
    ItemSectionCardModel(
        name = "Bolo",
        price = BigDecimal("11.99"),
        image = "https://images.pexels.com/photos/291528/pexels-photo-291528.jpeg",
        description = LoremIpsum(100).values.first()
    )
)


val sampleProducts: List<ItemSectionCardModel> = listOf(

    ItemSectionCardModel(
        name = "Hamburguer",
        price = BigDecimal("12.99"),
        image = "https://images.pexels.com/photos/1639557/pexels-photo-1639557.jpeg"
    ),

    ItemSectionCardModel(
        name = "Pizza",
        price = BigDecimal("19.99"),
        image = "https://images.pexels.com/photos/825661/pexels-photo-825661.jpeg"
    ),
    ItemSectionCardModel(
        name = "Batata frita",
        price = BigDecimal("7.99"),
        image = "https://images.pexels.com/photos/1583884/pexels-photo-1583884.jpeg"
    ), *sampleDrinks.toTypedArray(), *sampleCandies.toTypedArray()
)

val sampleSections = mapOf(
    "Promoções" to sampleProducts,
    "Doces" to sampleCandies,
    "Bebidas" to sampleDrinks
)

val sampleItemDetail = listOf(
    ProductDetailModel(
        image = "https://images.pexels.com/photos/1583884/pexels-photo-1583884.jpeg",
        imageDescription = "Imagem do produto",
        name = "Batata frita",
        price = BigDecimal("7.99"),
        description = LoremIpsum(100).values.first()
    ),
    ProductDetailModel(
        image = "https://images.pexels.com/photos/1583884/pexels-photo-1583884.jpeg",
        imageDescription = "Imagem do produto",
        name = "Batata frita",
        price = BigDecimal("7.99"),
        description = LoremIpsum(100).values.first()
    ),
    ProductDetailModel(
        image = "https://images.pexels.com/photos/1583884/pexels-photo-1583884.jpeg",
        imageDescription = "Imagem do produto",
        name = "Batata frita",
        price = BigDecimal("7.99"),
        description = LoremIpsum(100).values.first()
    ),
    ProductDetailModel(
        image = "https://images.pexels.com/photos/1583884/pexels-photo-1583884.jpeg",
        imageDescription = "Imagem do produto",
        name = "Batata frita",
        price = BigDecimal("7.99"),
        description = LoremIpsum(100).values.first()
    ),
    ProductDetailModel(
        image = "https://images.pexels.com/photos/1583884/pexels-photo-1583884.jpeg",
        imageDescription = "Imagem do produto",
        name = "Batata frita",
        price = BigDecimal("7.99"),
        description = LoremIpsum(100).values.first()
    )
)