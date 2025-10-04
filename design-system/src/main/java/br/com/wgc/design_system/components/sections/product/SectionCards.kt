package br.com.wgc.design_system.components.sections.product

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
import br.com.wgc.design_system.components.sections.items.product.ItemSectionCard
import br.com.wgc.design_system.components.sections.items.product.ItemSectionCardModel
import br.com.wgc.design_system.components.sections.items.product.ItemSectionHorizontalCard
import br.com.wgc.design_system.components.sections.type.ItemSectionType
import java.math.BigDecimal

@Composable
fun SectionCards(
    modifier: Modifier = Modifier,
    sectionModel: SectionCardsModel
) {
    Column(modifier = modifier) {
        Text(
            sectionModel.title,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight(
                400
            )
        )
        LazyRow(
            modifier = Modifier
                .padding(top = 8.dp, bottom = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(sectionModel.items.size) { index ->
                when (sectionModel.itemType) {
                    ItemSectionType.DEFAULT -> ItemSectionCard(
                        model = sectionModel.items[index]
                    )
                    ItemSectionType.HORIZONTAL -> ItemSectionHorizontalCard(
                        model = sectionModel.items[index]
                    )
                }
            }
         }

    }
}

@Preview(showBackground = true, name = "WITH DEFAULT", widthDp = 500)
@Composable
private fun ProductSectionHorizontalPreview() = SectionCards(
    sectionModel = SectionCardsModel(
        title = "Promocoes",
        items =listOf(
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
            )
        ),
        itemType = ItemSectionType.DEFAULT
    )
)

@Preview(showBackground = true, name = "WITH HORIZONTAL")
@Composable
private fun ProductSectionHorizontalPreview3() = SectionCards(
    sectionModel = SectionCardsModel(
        title = "Promocoes",
        items =listOf(
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
        ),
        itemType = ItemSectionType.HORIZONTAL
    )
)