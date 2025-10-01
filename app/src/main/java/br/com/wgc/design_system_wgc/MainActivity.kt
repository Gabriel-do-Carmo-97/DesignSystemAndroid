package br.com.wgc.design_system_wgc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import br.com.wgc.design_system.components.cards.circularImageproduct.CircularImageProductCard
import br.com.wgc.design_system.components.cards.circularImageproduct.CircularImageProductDescriptionCard
import br.com.wgc.design_system.components.cards.circularImageproduct.CircularImageProductModel
import br.com.wgc.design_system.components.cards.productinfo.ProductInfoCard
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
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .verticalScroll(rememberScrollState())
                    ) {
                        CircularImageProductCard(
                            model = CircularImageProductModel(
                                image = R.drawable.ic_launcher_background,
                                title = LoremIpsum(5).values.first(),
                                price = BigDecimal(149.99)
                            )
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        CircularImageProductDescriptionCard(
                            model = CircularImageProductModel(
                                image = R.drawable.ic_launcher_background,
                                title = LoremIpsum(5).values.first(),
                                price = BigDecimal(149.99),
                                description = LoremIpsum(100).values.first()
                            )
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        ProductInfoCard(
                            model = ProductInfoModel(
                                image = R.drawable.ic_launcher_background,
                                imageDescription = "Imagem do produto",
                                description = LoremIpsum(100).values.first()
                            )
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        ProductCircularImageSection()
                        ProductCircularImageDescriptionSection()
                        ProductInfoSection()
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