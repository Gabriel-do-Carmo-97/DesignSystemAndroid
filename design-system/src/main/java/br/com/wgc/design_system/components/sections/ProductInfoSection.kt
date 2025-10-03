package br.com.wgc.design_system.components.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.design_system.components.cards.productinfo.ProductInfoCard
import br.com.wgc.design_system.components.cards.productinfo.ProductInfoModel

@Composable
fun ProductInfoSection(
    modifier: Modifier = Modifier,
    title: String,
    producs: List<ProductInfoModel>
) {
    Column(modifier = modifier) {
        Text(
            title,
            modifier = Modifier.padding(top = 16.dp, start = 16.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight(
                400
            )
        )
        LazyRow(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(producs.size) { index ->
                ProductInfoCard(model = producs[index])
            }
        }
    }
}

@Preview(showBackground = true, name = "Only Component", widthDp = 1000)
@Composable
private fun ProductSectionHorizontalPreview() = ProductInfoSection(
    title = "Promocoes",
    producs =listOf<ProductInfoModel>(
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
)

@Preview(showBackground = true, showSystemUi = true, name = "Component and SystemUi")
@Composable
private fun ProductSectionHorizontalPreview2() = ProductInfoSection(
    title = "Promocoes",
    producs =listOf<ProductInfoModel>(
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
)
