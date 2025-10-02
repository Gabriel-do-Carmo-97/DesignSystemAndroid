package br.com.wgc.design_system_wgc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.components.cards.circularImageproduct.CircularImageProductModel
import br.com.wgc.design_system.components.cards.productinfo.ProductInfoModel
import br.com.wgc.design_system.components.items.CardPrice
import br.com.wgc.design_system.components.sections.ProductCircularImageDescriptionSection
import br.com.wgc.design_system.components.sections.ProductCircularImageSection
import br.com.wgc.design_system.components.sections.ProductInfoSection
import br.com.wgc.design_system_wgc.ui.theme.DesignSystemWGCTheme
import java.math.BigDecimal

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DesignSystemWGCTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Spacer(modifier = Modifier)
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Spacer(modifier = Modifier.height(16.dp))
                        ProductCircularImageSection(
                            title = "Comidas",
                            producs = sampleCandies
                        )
                        ProductCircularImageDescriptionSection(
                            title = "Comidas",
                            producs = sampleCandies
                        )
                        ProductInfoSection(
                            title = "Comidas",
                            producs = sampleInfoModel
                        )
                        Spacer(modifier = Modifier)
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DesignSystemWGCTheme {
        CardPrice()
    }
}

val sampleCandies = listOf(
    CircularImageProductModel(
        title = "Chocolate",
        price = BigDecimal("3.99"),
        image = "https://images.pexels.com/photos/65882/chocolate-dark-coffee-confiserie-65882.jpeg",
        description = LoremIpsum(100).values.first()
    ),
    CircularImageProductModel(
        title = "Sorvete",
        price = BigDecimal("5.99"),
        image = "https://images.pexels.com/photos/1352278/pexels-photo-1352278.jpeg",
        description = LoremIpsum(100).values.first()
    ),
    CircularImageProductModel(
        title = "Bolo",
        price = BigDecimal("11.99"),
        image = "https://images.pexels.com/photos/291528/pexels-photo-291528.jpeg",
        description = LoremIpsum(100).values.first()
    )
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


val sampleProducts: List<CircularImageProductModel> = listOf(

    CircularImageProductModel(
        title = "Hamburguer",
        price = BigDecimal("12.99"),
        image = "https://images.pexels.com/photos/1639557/pexels-photo-1639557.jpeg"
    ),

    CircularImageProductModel(
        title = "Pizza",
        price = BigDecimal("19.99"),
        image = "https://images.pexels.com/photos/825661/pexels-photo-825661.jpeg"
    ),
    CircularImageProductModel(
        title = "Batata frita",
        price = BigDecimal("7.99"),
        image = "https://images.pexels.com/photos/1583884/pexels-photo-1583884.jpeg"
    ), *sampleDrinks.toTypedArray(), *sampleCandies.toTypedArray()
)

val sampleSections = mapOf(
    "Promoções" to sampleProducts,
    "Doces" to sampleCandies,
    "Bebidas" to sampleDrinks
)


val sampleInfoModel= listOf<ProductInfoModel>(
    ProductInfoModel(
        image = "https://images.pexels.com/photos/1583884/pexels-photo-1583884.jpeg",
        imageDescription = "Imagem do produto",
        description = LoremIpsum(100).values.first()
    ),
    ProductInfoModel(
        image = "https://images.pexels.com/photos/1583884/pexels-photo-1583884.jpeg",
        imageDescription = "Imagem do produto",
        description = LoremIpsum(100).values.first()
    ),
)